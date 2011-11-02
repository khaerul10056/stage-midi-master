package org.mda.tests;

import maosoft.TransposeServiceTest;
import maosoft.midiplayer.ChordTest;
import maosoft.midiplayer.exporter.PDFExporterTest;
import maosoft.midiplayer.importer.TextImporterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mda.editor.preview.ui.test.PreviewEditorTest;
import org.mda.editor.preview.ui.test.PreviewEditorUiTest;
import org.mda.presenter.ui.test.BeamerPresenterTest;
import org.mda.presenter.ui.test.MidiFileSlideCalculatorTest;


@RunWith(Suite.class)
@SuiteClasses (  {

  //Runtime
  TextImporterTest.class,
  PDFExporterTest.class,
  ChordTest.class,
  TransposeServiceTest.class,



  //UI
  PreviewEditorTest.class,
  PreviewEditorUiTest.class,

  BeamerPresenterTest.class,
  MidiFileSlideCalculatorTest.class



}
)
public class AllTestsSuite {

}
