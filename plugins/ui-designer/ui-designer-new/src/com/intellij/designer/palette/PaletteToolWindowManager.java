/*
 * Copyright 2000-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.designer.palette;

import com.intellij.designer.AbstractToolWindowManager;
import com.intellij.designer.designSurface.DesignerEditorPanel;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Alexander Lobas
 */
public class PaletteToolWindowManager extends AbstractToolWindowManager {
  private final PalettePanel myToolWindowPanel = new PalettePanel();

  public PaletteToolWindowManager(Project project, FileEditorManager fileEditorManager) {
    super(project, fileEditorManager);
  }

  public static PaletteToolWindowManager getInstance(Project project) {
    return project.getComponent(PaletteToolWindowManager.class);
  }

  public void clearActiveItem() {
    myToolWindowPanel.clearActiveItem();
  }

  @Override
  protected void initToolWindow() {
    myToolWindow = ToolWindowManager.getInstance(myProject).registerToolWindow("Palette\t", false, ToolWindowAnchor.RIGHT, myProject, true);
    myToolWindow.setIcon(AllIcons.Toolwindows.ToolWindowPalette);

    ContentManager contentManager = myToolWindow.getContentManager();
    Content content = contentManager.getFactory().createContent(myToolWindowPanel, null, false);
    content.setCloseable(false);
    content.setPreferredFocusableComponent(myToolWindowPanel);
    contentManager.addContent(content);
    contentManager.setSelectedContent(content, true);
    myToolWindow.setAvailable(false, null);
  }

  @Override
  protected void updateToolWindow(@Nullable DesignerEditorPanel designer) {
    myToolWindowPanel.loadPalette(designer);

    if (myToolWindowPanel.isEmpty()) {
      myToolWindow.setAvailable(false, null);
    }
    else {
      myToolWindow.setAvailable(true, null);
      myToolWindow.show(null);
    }
  }

  @NotNull
  @Override
  public String getComponentName() {
    return "PaletteToolWindowManager";
  }
}