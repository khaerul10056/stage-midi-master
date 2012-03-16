package org.mda.commons.ui;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;





public class Util {


  public final static String ADMIN_PERSPECTIVE = "org.mda.application.adminperspective";

  public final static String PRESENTATION_PERSPECTIVE = "org.mda.application.presentationperspective";


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

}
