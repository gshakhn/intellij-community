package com.intellij.rt.execution.junit;

import com.intellij.rt.execution.junit.segments.OutputObjectRegistryImpl;
import com.intellij.rt.execution.junit.segments.PoolOfDelimiters;
import com.intellij.rt.execution.junit.segments.SegmentedOutputStream;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.textui.ResultPrinter;
import junit.textui.TestRunner;

public class IdeaTestRunner extends TestRunner {
  public JUnit4API JUNIT4_API = null;
  private TestListener myTestsListener;
  private OutputObjectRegistryImpl myRegistry;

  public IdeaTestRunner() {
    super(DeafStream.DEAF_PRINT_STREAM);
  }

  public static int startRunnerWithArgs(IdeaTestRunner testRunner, String[] args) {
    try {
      Test suite = TestRunnerUtil.getTestSuite(testRunner, args);
      TestResult result = testRunner.doRun(suite);
      if (!result.wasSuccessful()) {
        return -1;
      }
      return 0;
    }
    catch (Exception e) {
      e.printStackTrace(System.err);
      return -2;
    }
  }

  public void clearStatus() {
    super.clearStatus();
  }

  public Class loadSuiteClass(String suiteClassName) throws ClassNotFoundException {
    return super.loadSuiteClass(suiteClassName);
  }

  public void runFailed(String message) {
    super.runFailed(message);
  }

  public void setStreams(SegmentedOutputStream segmentedOut, SegmentedOutputStream segmentedErr) {
    setPrinter(new TimeSender());
    myRegistry = new OutputObjectRegistryImpl(segmentedOut, segmentedErr, JUNIT4_API);
    myTestsListener = new TestResultsSender(myRegistry, segmentedErr, JUNIT4_API);
  }

  protected TestResult createTestResult() {
    TestResult testResult = super.createTestResult();
    testResult.addListener(myTestsListener);
    return testResult;
  }

  public TestResult doRun(Test suite, boolean wait) {
    try {
      TreeSender.sendSuite(myRegistry, suite);
    }
    catch (Exception e) {
      //noinspection HardCodedStringLiteral
      System.err.println("Internal Error occured.");
      e.printStackTrace(System.err);
    }
    return super.doRun(suite, wait);
  }

  public static class MockResultPrinter extends ResultPrinter {
    public MockResultPrinter() {
      super(DeafStream.DEAF_PRINT_STREAM);
    }
  }

  private class TimeSender extends ResultPrinter {
    public TimeSender() {
      super(DeafStream.DEAF_PRINT_STREAM);
    }

    protected void printHeader(long runTime) {
      myRegistry.createPacket().addString(PoolOfDelimiters.TESTS_DONE).addLong(runTime).send();
    }
  }
}
