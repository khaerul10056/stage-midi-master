package org.mda.commons.ui.calculator.configurator;

import mda.PresentationScheme;
import mda.User;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.commons.ui.DefaultMidiFileContentEditorConfig;
import org.mda.commons.ui.IMidiFileEditorUIConfig;

public class PresentationConfiguratorTest {

  private PresentationConfigurator  configurator;
  private static ApplicationSession appSession = MdaModule.getInjector().getInstance(ApplicationSession.class);

  @Before
  public void setup () {
    appSession.load(null);
    appSession.getCurrentModel().getPresentationschemes().clear();
    for (User next: appSession.getCurrentModel().getUsers()) {
      next.getPresentationschemes().clear();
    }
    configurator = new PresentationConfigurator();
  }

  private void checkConfiguration (final IMidiFileEditorUIConfig config,
                                   final IMidiFileEditorUIConfig compareConfig) {
    Assert.assertEquals(compareConfig.getDefaultBackgroundColor(), config.getDefaultBackgroundColor());
    Assert.assertEquals(compareConfig.getDefaultForegroundColor(), config.getDefaultForegroundColor());
    Assert.assertEquals (compareConfig.getFont(), config.getFont());
    Assert.assertEquals (compareConfig.getDefaultPresentationScreenSize(), config.getDefaultPresentationScreenSize());
    Assert.assertEquals (compareConfig.isShowBackground(), config.isShowBackground());
    Assert.assertEquals (compareConfig.isShowBlockType(), config.isShowBlockType());
    Assert.assertEquals (compareConfig.isPagePerPart(), config.isPagePerPart());
    Assert.assertEquals (compareConfig.isNewPageRespected(), config.isNewPageRespected());
    Assert.assertEquals (compareConfig.isShowTitle(), config.isShowTitle());
    Assert.assertEquals (compareConfig.isShowCopyright(), config.isShowCopyright());
    Assert.assertEquals (compareConfig.isSkipEmptySlides(), config.isSkipEmptySlides());
    Assert.assertEquals (compareConfig.isOptimizeLineFilling(), config.isOptimizeLineFilling());
    Assert.assertEquals (compareConfig.getBorder(), config.getBorder());
    Assert.assertEquals (compareConfig.isOptimizeEqualParts(), config.isOptimizeEqualParts());
    Assert.assertEquals (compareConfig.isOptimizeEmptyTokens(), config.isOptimizeEmptyTokens());
    Assert.assertEquals (compareConfig.isAutoWrapToNewPage(), config.isAutoWrapToNewPage());
  }

  @Test
  public void dontOverwriteDefault () {
    DefaultMidiFileContentEditorConfig defaultConfig = new DefaultMidiFileContentEditorConfig();
    IMidiFileEditorUIConfig configuredConfig = configurator.configure(null, appSession.getCurrentModel(), PresentationType.PDF);

    checkConfiguration( configuredConfig, defaultConfig);
  }

  private String getColorString (int colorID) {
    return Utils.colorToString(Display.getDefault().getSystemColor(colorID));
  }

  @Test
  public void overwriteWithGeneric () {
    appSession.getCurrentModel();

    DefaultMidiFileContentEditorConfig defaultConfig = new DefaultMidiFileContentEditorConfig();

    //Case 2: Generic scheme is for another presentationtype
    PresentationScheme genericSchema = MidiPlayerService.mf.createPresentationScheme();
    genericSchema.setType(PresentationType.PPT.name());
    genericSchema.setBackgroundColor(getColorString(SWT.COLOR_BLUE));
    genericSchema.setForegroundColor(getColorString(SWT.COLOR_YELLOW));
    //genericSchema.setFont TODO
    //genericSchema.setDefaultPresentationSize TODO
    genericSchema.setShowBackground(! defaultConfig.isShowBackground());
    genericSchema.setShowBlockType(! defaultConfig.isShowBlockType());
    appSession.getCurrentModel().getPresentationschemes().add(genericSchema);
    IMidiFileEditorUIConfig configuredConfig = configurator.configure(null, appSession.getCurrentModel(), PresentationType.PDF);
    checkConfiguration( configuredConfig, defaultConfig);

    //Case 3: Generic scheme is for this presentationtype
    DefaultMidiFileContentEditorConfig overwrittenGenericExpected = new DefaultMidiFileContentEditorConfig();
    overwrittenGenericExpected.setBackgroundColor(getColorString(SWT.COLOR_BLUE));
    overwrittenGenericExpected.setForegroundColor(getColorString(SWT.COLOR_YELLOW));
    overwrittenGenericExpected.setShowBackground(genericSchema.getShowBackground());
    overwrittenGenericExpected.setShowBlockType(genericSchema.getShowBlockType());
    IMidiFileEditorUIConfig configuredConfigPpt = configurator.configure(null, appSession.getCurrentModel(), PresentationType.PPT);
    checkConfiguration( configuredConfigPpt, overwrittenGenericExpected);
  }

  @Test
  public void overwriteWithUser () {
    appSession.getCurrentModel().getUsers().clear();
    User newUser = MidiPlayerService.mf.createUser();

    DefaultMidiFileContentEditorConfig defaultConfig = new DefaultMidiFileContentEditorConfig();

    //Case 2: Generic scheme is for another presentationtype
    PresentationScheme genericSchema = MidiPlayerService.mf.createPresentationScheme();
    genericSchema.setType(PresentationType.PPT.name());
    genericSchema.setBorder(defaultConfig.getBorder() + 100);
    genericSchema.setOptimizeEmptyTokens(! defaultConfig.isOptimizeEmptyTokens());
    genericSchema.setNewPageRespected(! defaultConfig.isNewPageRespected());
    genericSchema.setPagePerPart(! defaultConfig.isPagePerPart());

    newUser.getPresentationschemes().add(genericSchema);
    appSession.getCurrentModel().getUsers().add(newUser);
    IMidiFileEditorUIConfig configuredConfig = configurator.configure(newUser, appSession.getCurrentModel(), PresentationType.PDF);
    checkConfiguration( configuredConfig, defaultConfig);

    //Case 3: Generic scheme is for this presentationtype
    DefaultMidiFileContentEditorConfig overwrittenGenericExpected = new DefaultMidiFileContentEditorConfig();
    overwrittenGenericExpected.setBorder (genericSchema.getBorder());
    overwrittenGenericExpected.setOptimizeEmptyTokens(genericSchema.getOptimizeEmptyTokens());
    overwrittenGenericExpected.setNewPageRespected(genericSchema.getNewPageRespected());
    overwrittenGenericExpected.setPagePerPart(genericSchema.getPagePerPart());
    IMidiFileEditorUIConfig configuredConfigPpt = configurator.configure(newUser, appSession.getCurrentModel(), PresentationType.PPT);
    checkConfiguration( configuredConfigPpt, overwrittenGenericExpected);
  }

  @Test
  public void overwriteWithGenericAndUser () {
    //Case 1: Fitting userschema is attached over generic schema
    appSession.getCurrentModel().getUsers().clear();
    User newUser = MidiPlayerService.mf.createUser();

    DefaultMidiFileContentEditorConfig defaultConfig = new DefaultMidiFileContentEditorConfig();

    PresentationScheme genericSchema = MidiPlayerService.mf.createPresentationScheme();
    genericSchema.setType(PresentationType.PDF.name());
    genericSchema.setBorder(defaultConfig.getBorder() + 100);
    genericSchema.setOptimizeEmptyTokens(! defaultConfig.isOptimizeEmptyTokens());
    genericSchema.setNewPageRespected(! defaultConfig.isNewPageRespected());
    genericSchema.setPagePerPart(! defaultConfig.isPagePerPart());

    PresentationScheme userSchema = MidiPlayerService.mf.createPresentationScheme();
    userSchema.setType(PresentationType.PDF.name());
    userSchema.setBorder(defaultConfig.getBorder() + 100);
    userSchema.setOptimizeEmptyTokens(! defaultConfig.isOptimizeEmptyTokens());
    userSchema.setNewPageRespected(! defaultConfig.isNewPageRespected());
    userSchema.setPagePerPart(defaultConfig.isPagePerPart());
    userSchema.setShowBlockType(! defaultConfig.isShowBlockType());

    appSession.getCurrentModel().getPresentationschemes().add(genericSchema);
    newUser.getPresentationschemes().add(userSchema);
    appSession.getCurrentModel().getUsers().add(newUser);

    DefaultMidiFileContentEditorConfig overwrittenGenericExpected = new DefaultMidiFileContentEditorConfig();
    overwrittenGenericExpected.setBorder (genericSchema.getBorder());
    overwrittenGenericExpected.setOptimizeEmptyTokens(genericSchema.getOptimizeEmptyTokens());
    overwrittenGenericExpected.setNewPageRespected(genericSchema.getNewPageRespected());
    overwrittenGenericExpected.setPagePerPart(userSchema.getPagePerPart()); //overwritten by default and reoverwritten by user
    overwrittenGenericExpected.setShowBlockType(userSchema.getShowBlockType()); //overwritten only by user
    IMidiFileEditorUIConfig configuredConfigPpt = configurator.configure(newUser, appSession.getCurrentModel(), PresentationType.PDF);
    checkConfiguration( configuredConfigPpt, overwrittenGenericExpected);

  }

}
