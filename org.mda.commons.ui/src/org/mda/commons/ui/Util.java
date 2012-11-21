package org.mda.commons.ui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Monitor;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;





public class Util {


  public final static String ADMIN_PERSPECTIVE = "org.mda.application.adminperspective";

  public final static String PRESENTATION_PERSPECTIVE = "org.mda.application.presentationperspective";
  
  private static final Log LOGGER            = LogFactory.getLogger(Util.class);

  
  public static void disableEscOnComponent (final Control control) {
		control.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.ESC)
					e.doit = false;
				
				if (e.keyCode == SWT.F4 && e.stateMask == SWT.ALT)
			      	  control.getShell().dispose();
			}
		});
	}
  
  public static Point getLocationOnScreenAfterWidget (final Control widget) {
	  Point point = widget.toDisplay(0,0);
	  point.x += widget.getSize().x + 5;
	  return point;
	  
  }
  
  public static void centreShell (final Composite shell) {
	    Display display = Display.getDefault();
	    Monitor primary = display.getPrimaryMonitor();
	    Rectangle bounds = primary.getBounds();
	    Rectangle rect = shell.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    shell.setLocation(x,y);
  }

  public static Object getStructuredSelection (ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      IStructuredSelection structSelection = (IStructuredSelection) selection;
      return structSelection.getFirstElement();
    }

    return null;
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

public static String logEvent (Event event) {

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
