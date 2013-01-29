package org.mda.presenter.config;

import mda.PresentationScheme;
import mda.User;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mda.ApplicationSession;
import org.mda.MidiPlayerService;
import org.mda.Utils;
import org.mda.inject.InjectServiceMock;

public class PresentationConfiguratorTest {

  private PresentationConfigurator  configurator;
  private static ApplicationSession appSession = new ApplicationSession();
  private PresentationConfigDefaults defaults = new PresentationConfigDefaults();
  
  @BeforeClass
  public static void beforeClass () {
	  InjectServiceMock.initialize();
  }

  @Before
  public void setup () {
    appSession.load(null);
    appSession.getCurrentModel().getPresentationschemes().clear();
    for (User next: appSession.getCurrentModel().getUsers()) {
      next.getPresentationschemes().clear();
    }
    configurator = new PresentationConfigurator();
  }

  private void checkConfiguration (final IPresenterConfig config,
                                   final IPresenterConfig compareConfig) {
    Assert.assertEquals(compareConfig.getDefaultBackgroundColor(), config.getDefaultBackgroundColor());
    Assert.assertEquals(compareConfig.getDefaultForegroundColor(), config.getDefaultForegroundColor());
    Assert.assertEquals (compareConfig.getFont(), config.getFont());
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
  
  private DefaultPresenterConfig createDefault (PresentationType type) {
	  DefaultPresenterConfig defaultConfig = new DefaultPresenterConfig();
	  
	  configurator.overwriteConfiguration(defaultConfig, defaults.getAllDefaultSchemes(), type);
	  return defaultConfig;
  }

  @Test
  public void dontOverwriteDefault () {
    DefaultPresenterConfig defaultConfig = createDefault(PresentationType.PDF);
    IPresenterConfig configuredConfig = configurator.configure(null, appSession.getCurrentModel(), PresentationType.PDF);

    checkConfiguration( configuredConfig, defaultConfig);
  }

  private String getColorString (int colorID) {
    return Utils.colorToString(Display.getDefault().getSystemColor(colorID));
  }

  @Test
  public void overwriteWithGeneric () {
    appSession.getCurrentModel();

    DefaultPresenterConfig defaultConfig = createDefault(PresentationType.PDF);

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
    IPresenterConfig configuredConfig = configurator.configure(null, appSession.getCurrentModel(), PresentationType.PDF);
    checkConfiguration( configuredConfig, defaultConfig);

    //Case 3: Generic scheme is for this presentationtype
    DefaultPresenterConfig overwrittenGenericExpected  = createDefault(PresentationType.PPT);
    overwrittenGenericExpected.setBackgroundColor(getColorString(SWT.COLOR_BLUE));
    overwrittenGenericExpected.setForegroundColor(getColorString(SWT.COLOR_YELLOW));
    overwrittenGenericExpected.setShowBackground(genericSchema.getShowBackground());
    overwrittenGenericExpected.setShowBlockType(genericSchema.getShowBlockType());
    IPresenterConfig configuredConfigPpt = configurator.configure(null, appSession.getCurrentModel(), PresentationType.PPT);
    checkConfiguration( configuredConfigPpt, overwrittenGenericExpected);
  }

  @Test
  public void overwriteWithUser () {
    appSession.getCurrentModel().getUsers().clear();
    User newUser = MidiPlayerService.mf.createUser();

    DefaultPresenterConfig defaultConfig  = createDefault(PresentationType.PDF);

    //Case 2: Generic scheme is for another presentationtype
    PresentationScheme genericSchema = MidiPlayerService.mf.createPresentationScheme();
    genericSchema.setType(PresentationType.PPT.name());
    genericSchema.setBorder(defaultConfig.getBorder() + 100);
    genericSchema.setOptimizeEmptyTokens(! defaultConfig.isOptimizeEmptyTokens());
    genericSchema.setNewPageRespected(! defaultConfig.isNewPageRespected());
    genericSchema.setPagePerPart(! defaultConfig.isPagePerPart());

    newUser.getPresentationschemes().add(genericSchema);
    appSession.getCurrentModel().getUsers().add(newUser);
    IPresenterConfig configuredConfig = configurator.configure(newUser, appSession.getCurrentModel(), PresentationType.PDF);
    checkConfiguration( configuredConfig, defaultConfig);

    //Case 3: Generic scheme is for this presentationtype
    DefaultPresenterConfig overwrittenGenericExpected  = createDefault(PresentationType.PPT);
    overwrittenGenericExpected.setBorder (genericSchema.getBorder());
    overwrittenGenericExpected.setOptimizeEmptyTokens(genericSchema.getOptimizeEmptyTokens());
    overwrittenGenericExpected.setNewPageRespected(genericSchema.getNewPageRespected());
    overwrittenGenericExpected.setPagePerPart(genericSchema.getPagePerPart());
    IPresenterConfig configuredConfigPpt = configurator.configure(newUser, appSession.getCurrentModel(), PresentationType.PPT);
    checkConfiguration( configuredConfigPpt, overwrittenGenericExpected);
  }

  @Test
  public void overwriteWithGenericAndUser () {
    //Case 1: Fitting userschema is attached over generic schema
    appSession.getCurrentModel().getUsers().clear();
    User newUser = MidiPlayerService.mf.createUser();

    DefaultPresenterConfig defaultConfig = createDefault(PresentationType.PDF);

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

    DefaultPresenterConfig overwrittenGenericExpected  = createDefault(PresentationType.PDF);
    overwrittenGenericExpected.setBorder (genericSchema.getBorder());
    overwrittenGenericExpected.setOptimizeEmptyTokens(genericSchema.getOptimizeEmptyTokens());
    overwrittenGenericExpected.setNewPageRespected(genericSchema.getNewPageRespected());
    overwrittenGenericExpected.setPagePerPart(userSchema.getPagePerPart()); //overwritten by default and reoverwritten by user
    overwrittenGenericExpected.setShowBlockType(userSchema.getShowBlockType()); //overwritten only by user
    IPresenterConfig configuredConfigPpt = configurator.configure(newUser, appSession.getCurrentModel(), PresentationType.PDF);
    checkConfiguration( configuredConfigPpt, overwrittenGenericExpected);

  }

}
