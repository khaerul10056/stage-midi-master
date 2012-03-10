package org.mda.core;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.junit.Assert;
import org.junit.Test;
import org.mda.Utils;


public class UtilsTest {



  @Test
  public void colorToString () {
    Assert.assertEquals ("50x100x75", Utils.colorToString(new Color (Display.getCurrent(), 100, 50, 75)));
  }

  @Test
  public void stringToColor () {
    Color defaultColor = new Color (Display.getCurrent(), 0, 0, 0);
    Assert.assertEquals (new Color (Display.getCurrent(), 100, 50, 75), Utils.stringToColor("50x100x75", null));
    Assert.assertNull (Utils.stringToColor(null, null));
    Assert.assertNull (Utils.stringToColor("ruetzl", null));
    Assert.assertEquals (defaultColor, Utils.stringToColor("ruetzl", defaultColor));
  }

  @Test
  public void loadImageWithNotValidId  () {
    Assert.assertNull (Utils.loadImageFromProject("unvalid"));
  }

  @Test
  public void removeString () {
    Assert.assertEquals ("this is a test", Utils.removeString("Hello, this is a test", 0, 7));
    Assert.assertEquals ("Heis is a test", Utils.removeString("Hello, this is a test", 2, 7));


    try {
    Assert.assertEquals ("Heis is a test", Utils.removeString("Hello, this is a test", -1, 7));
    Assert.fail ("Exception expected");
    } catch (ArrayIndexOutOfBoundsException e) {

    }

    try {
    Assert.assertEquals ("Heis is a test", Utils.removeString("Hello, this is a test", 2, 712));
    Assert.fail ("Exception expected");
    } catch (ArrayIndexOutOfBoundsException e) {

    }


  }

}
