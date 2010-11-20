package org.mda.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class GuiHelper {

  public static Font fontText = new Font(Font.MONOSPACED, Font.BOLD, 24);

	public final static void layout (Container container, final boolean fitFontSize) {
		//container.setBackground(Color.GRAY);
		//container.setForeground(Color.WHITE);
		if (fitFontSize) container.setFont(container.getFont().deriveFont(30f));
	}

	public final static JComboBox addLabelAndCombobox (final String label, final Container container, final int x, final int y) {
	  if (container == null)
	    throw new IllegalArgumentException("Parameter component must not be null");
	  if (! (container.getLayout() instanceof GridBagLayout))
	    throw new IllegalArgumentException("You can't add a labelAndCombobox to a component without gridbaglayout");

	  JLabel lblCombobox = new JLabel(label);
	  JComboBox cmbBox = new JComboBox ();
	  container.add(lblCombobox, new GridBagConstraints(x, y, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets (5,10,5,5), 100, 10));
	  container.add(cmbBox, new GridBagConstraints(x + 1, y, 1, 1, 1, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets (5,5,5,10), 100, 10));
	  return cmbBox;
	}

	/**
	 * finds the graphics-device with the given ID
	 * If not find returns the default device.
	 * @param id ID
	 * @return found device or default
	 */
	public final static GraphicsDevice findGraphicsDevice (final String id) {
	  GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    for (GraphicsDevice gd : env.getScreenDevices()) {
      if (gd.getIDstring().equals(id))
        return gd;
    }

    return env.getDefaultScreenDevice();

	}



}
