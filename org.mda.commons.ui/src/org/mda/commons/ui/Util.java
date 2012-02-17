package org.mda.commons.ui;

import java.net.URL;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;





public class Util {

  private static final Log LOGGER  = LogFactory.getLogger(Util.class);

  public final static String ICON_SONG = "song.jpg";
  public final static String ICON_SESSION = "session.png";
  public final static String ICON_ADD_PART = "add_part.gif";
  public final static String ICON_PART = "part.gif";
  public final static String ICON_REFPART = "referencedPart.gif";

  private final static ImageRegistry registry = new ImageRegistry();

  public static Image loadImage (final String id) {
    Image foundImage = registry.get(id);

    if (foundImage == null) {

      URL url = Util.class.getResource("/org/mda/icons/" + id);
      ImageDescriptor image = ImageDescriptor.createFromURL(url);
      if (image != null)
        foundImage = image.createImage();
      else
        LOGGER.warn("Image " + id + " not found");

      if (foundImage != null)
        registry.put(id, foundImage);
    }

    return foundImage;

  }

public static String logEvent (KeyEvent event) {

  String string = event.character == SWT.KeyDown ? "DOWN": "UP  ";

  string += ": stateMask=0x" + Integer.toHexString(event.stateMask);

  if ((event.stateMask & SWT.CTRL) != 0)
      string += " CTRL";

  if ((event.stateMask & SWT.ALT) != 0)
      string += " ALT";

  if ((event.stateMask & SWT.SHIFT) != 0)
      string += " SHIFT";

  if ((event.stateMask & SWT.COMMAND) != 0)
      string += " COMMAND";

  string += ", keyCode=0x" + Integer.toHexString(event.keyCode);
  string += ", character=0x" + Integer.toHexString(event.character);

  switch (event.character) {

      case 0: string += " '\\0'"; break;
      case SWT.BS: string += " '\\b'"; break;
      case SWT.CR: string += " '\\r'"; break;
      case SWT.DEL: string += " DEL"; break;
      case SWT.ESC: string += " ESC"; break;
      case SWT.LF: string += " '\\n'"; break;
      case SWT.TAB: string += " '\\t'";break;
      default:
          string += " '" + event.character + "'";
          break;

  }

  return string;

}

}
