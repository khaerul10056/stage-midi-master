package org.mda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mda.commons.ui.ContentProviderTest;
import org.mda.commons.ui.MidiFileEditorInputTest;
import org.mda.core.ApplicationSessionTest;
import org.mda.core.ChordTest;
import org.mda.core.MidiPlayerServiceTest;
import org.mda.core.UtilsTest;
import org.mda.core.additionals.TestAdditionalsHandler;
import org.mda.core.importer.TextImporterTest;
import org.mda.editor.preview.ui.test.PreviewEditorTest;
import org.mda.editor.preview.ui.test.PreviewEditorUiTest;
import org.mda.export.TestExportEngine;
import org.mda.export.TestPdfExporter;
import org.mda.export.TestPptExporter;
import org.mda.google.TestGoogleContacts;
import org.mda.navigator.ui.ContentNavigatorTest;
import org.mda.navigator.ui.PresentationNavigatorTest;
import org.mda.presenter.ui.slide.PresentationToControllerConnectorTest;
import org.mda.presenter.ui.test.BeamerPresenterTest;
import org.mda.presenter.ui.test.ContentOverviewTest;
import org.mda.presenter.ui.test.MidiFileSlideCalculatorTest;
import org.mda.transpose.TransposeTest;


@RunWith(Suite.class)
@SuiteClasses (  {

  //Core
  TextImporterTest.class,
  ChordTest.class,
  MidiPlayerServiceTest.class,
  ApplicationSessionTest.class,
  TestAdditionalsHandler.class,
  UtilsTest.class,
  TransposeTest.class,
  ContentProviderTest.class,

  //UI
  PreviewEditorTest.class,
  PreviewEditorUiTest.class,

  BeamerPresenterTest.class,
  MidiFileSlideCalculatorTest.class,
  ContentNavigatorTest.class,
  PresentationNavigatorTest.class,
  ContentOverviewTest.class,
  PresentationToControllerConnectorTest.class,
  MidiFileEditorInputTest.class,



  //Export
  TestExportEngine.class,
  TestPptExporter.class,
  TestPdfExporter.class,

  //Google
  TestGoogleContacts.class


}
)
public class AllTestsSuite {

}
