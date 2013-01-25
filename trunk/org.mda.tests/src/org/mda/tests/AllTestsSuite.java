package org.mda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mda.application.ApplicationTest;
import org.mda.commons.ui.ContentProviderTest;
import org.mda.commons.ui.MidiFileEditorInputTest;
import org.mda.commons.ui.SessionsContentProviderTest;
import org.mda.commons.ui.additionals.AdditionalShellTest;
import org.mda.commons.ui.imports.ImportShellTest;
import org.mda.commons.ui.transpose.TransposeShellTest;
import org.mda.commons.ui.user.UserContentProviderTest;
import org.mda.commons.ui.user.UserLabelProviderTest;
import org.mda.commons.ui.user.UserShellTest;
import org.mda.core.ApplicationSessionTest;
import org.mda.core.ChordTest;
import org.mda.core.CopyrightSerializerTest;
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
import org.mda.export.ExportPdfSessionHandlerTest;
import org.mda.export.ExportPptSessionHandlerTest;
import org.mda.export.TestExportEngine;
import org.mda.export.TestPdfExporter;
import org.mda.export.TestPptExporter;
import org.mda.export.TestTextfileExporter;
import org.mda.find.TestSearchEngine;
import org.mda.google.TestGoogleContacts;
import org.mda.inject.InjectServiceTest;
import org.mda.javafx.presenter.javafx.BeamerPresenterTest;
import org.mda.midi.MidiInfoTest;
import org.mda.midi.mapping.MappingServiceTest;
import org.mda.midi.ui.MidiDeviceContentProviderTest;
import org.mda.presenter.MidiFileSlideCalculatorTest;
import org.mda.presenter.PresentationContextTest;
import org.mda.presenter.config.PresentationConfiguratorTest;
import org.mda.presenter.ui.config.PresentationSchemaEditorBuilderTest;
import org.mda.presenter.ui.test.ContentOverviewTest;
import org.mda.struct.MidiFileStructTest;
import org.mda.transpose.PitchTest;
import org.mda.transpose.TransposeTest;


@RunWith(Suite.class)
@SuiteClasses (  {

  //Application
  ApplicationTest.class,
	
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
  
  InjectServiceTest.class,
  TestSearchEngine.class,
  CopyrightSerializerTest.class,

  //UI
  AdditionalShellTest.class,
  PreviewEditorTest.class,
  PreviewEditorUiTest.class,
  
  NewPartShellTest.class,
  StepTypeColorerTest.class,
  
  ChordHoverTest.class,

  ContentOverviewTest.class,
  MidiFileEditorInputTest.class,
  PresentationContextTest.class,
  
  SessionsContentProviderTest.class,
  UserContentProviderTest.class,
  UserLabelProviderTest.class,
  
  ExportPdfSessionHandlerTest.class,
  ExportPptSessionHandlerTest.class,
  
  ImportShellTest.class,
  TransposeShellTest.class,
  UserShellTest.class,
  MidiFileDetailsShellTest.class, 
  MidiPartDetailsShellTest.class,
  PresentationSchemaEditorBuilderTest.class,
  
  //Presenter
  MidiFileSlideCalculatorTest.class,
  BeamerPresenterTest.class,
  PresentationConfiguratorTest.class,
  
  
  //JavaFX

  //Midi 
  MidiDeviceContentProviderTest.class, 
  MidiInfoTest.class,
  MidiFileSlideCalculatorTest.class,
  MappingServiceTest.class, 
  PitchTest.class,


  //Export
  TestExportEngine.class,
  TestPptExporter.class,
  TestPdfExporter.class,
  TestTextfileExporter.class,

  //Google
  TestGoogleContacts.class


}
)
public class AllTestsSuite {

}
