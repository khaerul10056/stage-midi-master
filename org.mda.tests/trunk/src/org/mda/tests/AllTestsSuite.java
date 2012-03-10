package org.mda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mda.core.ApplicationSessionTest;
import org.mda.core.ChordTest;
import org.mda.core.MidiPlayerServiceTest;
import org.mda.core.UtilsTest;
import org.mda.core.additionals.TestAdditionalsHandler;
import org.mda.core.exporter.PDFExporterTest;
import org.mda.core.importer.TextImporterTest;
import org.mda.editor.preview.ui.test.PreviewEditorTest;
import org.mda.editor.preview.ui.test.PreviewEditorUiTest;
import org.mda.export.powerpoint.ExporterTest;
import org.mda.navigator.ui.ContentNavigatorTest;
import org.mda.navigator.ui.PresentationNavigatorTest;
import org.mda.presenter.ui.slide.PresentationToControllerConnectorTest;
import org.mda.presenter.ui.test.BeamerPresenterTest;
import org.mda.presenter.ui.test.ContentOverviewTest;
import org.mda.presenter.ui.test.MidiFileSlideCalculatorTest;


@RunWith(Suite.class)
@SuiteClasses (  {

  //Core
  TextImporterTest.class,
  PDFExporterTest.class,
  ChordTest.class,
  MidiPlayerServiceTest.class,
  ApplicationSessionTest.class,
  TestAdditionalsHandler.class,
  UtilsTest.class,



  //UI
  PreviewEditorTest.class,
  PreviewEditorUiTest.class,

  BeamerPresenterTest.class,
  MidiFileSlideCalculatorTest.class,
  ContentNavigatorTest.class,
  PresentationNavigatorTest.class,
  ContentOverviewTest.class,
  PresentationToControllerConnectorTest.class,


  //Export
  ExporterTest.class





}
)
public class AllTestsSuite {

}
