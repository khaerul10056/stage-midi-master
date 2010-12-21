package org.mda.ui.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class ScreenComboBoxModel extends DefaultComboBoxModel {

  /**
   *
   */
  private static final long serialVersionUID = -8223498148725576948L;
  private static List <String> screens = new ArrayList <String> ();

  static {
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    for (GraphicsDevice gd : env.getScreenDevices()) {
      screens.add(gd.getIDstring());
    }

  };

  public Object getElementAt(int index) {
    return screens.get(index);

  }

  public int getSize() {
    return screens.size();
  }
  
  

}
