package org.mda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mda.commons.ui.ContentProviderTest;
import org.mda.commons.ui.MidiFileEditorInputTest;
import org.mda.commons.ui.SessionsContentProviderTest;
import org.mda.commons.ui.calculator.configurator.PresentationConfiguratorTest;
import org.mda.commons.ui.imports.ImportShellTest;
import org.mda.commons.ui.transpose.TransposeShellTest;
import org.mda.commons.ui.user.UserContentProviderTest;
import org.mda.commons.ui.user.UserLabelProviderTest;
import org.mda.commons.ui.user.UserShellTest;
import org.mda.core.ApplicationSessionTest;
import org.mda.core.ChordTest;
import org.mda.core.MidiPlayerServiceTest;
import org.mda.core.UtilsTest;
import org.mda.core.additionals.TestAdditionalsHandler;
import org.mda.core.importer.TextImporterTest;
import org.mda.editor.preview.ui.StepTypeColorerTest;
import org.mda.editor.preview.ui.chords.ChordHoverTest;
import org.mda.editor.preview.ui.details.MidiFileDetailsShellTest;
import org.mda.editor.preview.ui.details.MidiPartDetailsShellTest;
import org.mda.editor.preview.ui.newpart.NewPartShellTest;
import org.mda.editor.preview.ui.test.PreviewEditorTest;
import org.mda.editor.preview.ui.test.PreviewEditorUiTest;
import org.mda.export.TestExportEngine;
import org.mda.export.TestPdfExporter;
import org.mda.export.TestPptExporter;
import org.mda.google.TestGoogleContacts;
import org.mda.presenter.ui.PresentationContextTest;
import org.mda.presenter.ui.config.PresentationSchemaEditorBuilderTest;
import org.mda.presenter.ui.test.BeamerPresenterTest;
import org.mda.presenter.ui.test.ContentOverviewTest;
import org.mda.presenter.ui.test.MidiFileSlideCalculatorTest;
import org.mda.struct.MidiFileStructTest;
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
  MidiFileStructTest.class,
  PresentationConfiguratorTest.class,

  //UI
  PreviewEditorTest.class,
  PreviewEditorUiTest.class,
  
  NewPartShellTest.class,
  StepTypeColorerTest.class,
  
  ChordHoverTest.class,

  BeamerPresenterTest.class,
  MidiFileSlideCalculatorTest.class,
  ContentOverviewTest.class,
  MidiFileEditorInputTest.class,
  PresentationContextTest.class,
  
  SessionsContentProviderTest.class,
  UserContentProviderTest.class,
  UserLabelProviderTest.class,
  
  ImportShellTest.class,
  TransposeShellTest.class,
  UserShellTest.class,
  MidiFileDetailsShellTest.class, 
  MidiPartDetailsShellTest.class,
  PresentationSchemaEditorBuilderTest.class,



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
