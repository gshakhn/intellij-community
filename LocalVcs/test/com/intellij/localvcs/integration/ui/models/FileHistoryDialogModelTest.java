package com.intellij.localvcs.integration.ui.models;

import com.intellij.localvcs.Label;
import com.intellij.localvcs.LocalVcsTestCase;
import com.intellij.localvcs.TestLocalVcs;
import com.intellij.localvcs.integration.TestIdeaGateway;
import com.intellij.localvcs.integration.TestVirtualFile;
import com.intellij.mock.MockEditorFactory;
import com.intellij.mock.MockFileTypeManager;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.vfs.VirtualFile;
import static org.easymock.classextension.EasyMock.*;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class FileHistoryDialogModelTest extends LocalVcsTestCase {
  private TestLocalVcs vcs = new TestLocalVcs();
  private FileHistoryDialogModel m;

  @Test
  public void testIncludingUnsavedVersionInLabels() {
    vcs.beginChangeSet();
    vcs.createFile("f", b("old"), null);
    vcs.endChangeSet("1");

    initModelFor("f", "new");

    List<Label> ll = m.getLabels();

    assertEquals(2, ll.size());
    assertEquals("not saved", ll.get(0).getName());
    assertEquals("1", ll.get(1).getName());
  }

  @Test
  public void testUnsavedVersionTimestampMemorizedTheModelCreationTime() {
    setCurrentTimestamp(123);
    vcs.createFile("f", b("old"), null);

    setCurrentTimestamp(456);
    initModelFor("f", "new");

    assertEquals(456L, m.getLabels().get(0).getTimestamp());

    setCurrentTimestamp(789);
    assertEquals(456L, m.getLabels().get(0).getTimestamp());
  }

  @Test
  public void testDoesNotIncludeUnsavedVersionDifferentOnlyInLineSeparator() {
    vcs.createFile("f", b("one\r\ntwo\r\n"), null);

    initModelFor("f", "one\ntwo\n");

    assertEquals(1, m.getLabels().size());
  }

  @Test
  public void testLabelsListAfterPurgeConteinsOnlyCurrentVersion() {
    setCurrentTimestamp(10);
    vcs.createFile("f", b(""), null);
    vcs.purgeUpTo(20);

    initModelFor("f");

    List<Label> ll = m.getLabels();

    assertEquals(1, ll.size());
    assertEquals("current", ll.get(0).getName());
  }

  @Test
  public void testDifferenceModelTitles() {
    vcs.createFile("old", b(""), 123L);
    vcs.rename("old", "new");

    initModelFor("new");
    m.selectLabels(0, 1);

    FileDifferenceModel dm = m.getDifferenceModel();
    assertTrue(dm.getLeftTitle().endsWith(" - old"));
    assertTrue(dm.getRightTitle().endsWith(" - new"));
  }

  @Test
  public void testDifferenceModelContents() {
    vcs.createFile("f", b("old"), null);
    vcs.changeFileContent("f", b("new"), null);

    initModelFor("f");
    m.selectLabels(0, 1);

    assertDifferenceModelContents("old", "new");
  }

  @Test
  public void testContentsWhenOnlyOneLabelSelected() {
    vcs.createFile("f", b("old"), null);
    vcs.changeFileContent("f", b("new"), null);

    initModelFor("f");
    m.selectLabels(1, 1);

    assertDifferenceModelContents("old", "new");
  }

  @Test
  public void testContentsForUnsavedVersion() {
    vcs.createFile("f", b("old"), null);

    initModelFor("f", "unsaved");
    m.selectLabels(0, 1);

    assertDifferenceModelContents("old", "unsaved");
  }

  @Test
  public void testTitlesForUnsavedEntry() {
    vcs.createDirectory("dir", null);
    vcs.createFile("dir/f", b("old"), null);

    setCurrentTimestamp(new Date(2003, 01, 01).getTime());
    initModelFor("dir/f", "unsaved");
    m.selectLabels(0, 1);

    FileDifferenceModel dm = m.getDifferenceModel();
    assertEquals("dir/f", dm.getTitle());
    assertEquals("01.02.03 0:00 - f", dm.getRightTitle());
  }

  private void assertDifferenceModelContents(String left, String right) {
    FileDifferenceModel dm = m.getDifferenceModel();

    FileTypeManager tm = new MockFileTypeManager();
    EditorFactory ef = new MockEditorFactory();

    assertEquals(left, dm.getLeftDiffContent(tm, ef).getText());
    assertEquals(right, dm.getRightDiffContent(tm, ef).getText());
  }

  @Test
  public void testRevertion() throws Exception {
    vcs.createFile("file", b("old"), 1L);
    vcs.changeFileContent("file", b("new"), null);

    VirtualFile f = createMock(VirtualFile.class);
    expect(f.contentsToByteArray()).andReturn(b("new"));
    expect(f.getPath()).andStubReturn("file");
    expect(f.getName()).andStubReturn("file");
    expect(f.getTimeStamp()).andStubReturn(2L);
    f.setBinaryContent(aryEq(b("old")), eq(-1L), eq(1L));
    replay(f);

    m = new FileHistoryDialogModel(f, vcs, new TestIdeaGateway());
    m.selectLabels(1, 1);

    m.revert();
    verify(f);
  }

  private void initModelFor(String path) {
    initModelFor(path, new String(vcs.getEntry(path).getContent().getBytes()));
  }

  private void initModelFor(String path, String content) {
    TestVirtualFile f = new TestVirtualFile(path, content, null);
    m = new FileHistoryDialogModel(f, vcs, new TestIdeaGateway());
  }
}
