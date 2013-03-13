package org.mda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.mda.core.ApplicationSessionTest;
import org.mda.core.ChordTest;
import org.mda.core.CopyrightSerializerTest;
import org.mda.core.MidiPlayerServiceTest;
import org.mda.core.UtilsTest;
import org.mda.core.additionals.TestAdditionalsHandler;
import org.mda.core.importer.TextImporterTest;
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
import org.mda.presenter.PresentationContextTest;
import org.mda.presenter.SlideContainerTest;
import org.mda.presenter.SongSlideCalculatorTest;
import org.mda.presenter.config.PresentationConfiguratorTest;
import org.mda.struct.MidiFileStructTest;
import org.mda.transpose.PitchTest;
import org.mda.transpose.TransposeTest;


@RunWith(Suite.class)
@SuiteClasses (  {

  //Application
  
	
  //Core
  TextImporterTest.class,
  ChordTest.class,
  MidiPlayerServiceTest.class,
  ApplicationSessionTest.class,
  TestAdditionalsHandler.class,
  UtilsTest.class,
  TransposeTest.class,
  MidiFileStructTest.class,
  
  InjectServiceTest.class,
  TestSearchEngine.class,
  CopyrightSerializerTest.class,

  //UI
  
  PresentationContextTest.class,
  
  
  
  
  
  
  //Presenter
  SongSlideCalculatorTest.class,
  BeamerPresenterTest.class,
  PresentationConfiguratorTest.class,
  SlideContainerTest.class,
  
  
  //JavaFX

  //Midi 
  MidiInfoTest.class,
  SongSlideCalculatorTest.class,
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
