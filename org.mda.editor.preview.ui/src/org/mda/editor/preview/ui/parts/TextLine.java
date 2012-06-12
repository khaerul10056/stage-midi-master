package org.mda.editor.preview.ui.parts;

import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.mda.ApplicationSession;
import org.mda.MdaModule;
import org.mda.Utils;
import org.mda.logging.Log;
import org.mda.logging.LogFactory;


public class TextLine extends StyledText{

  public final static int TEXTLINE_LENGTH = 80;

  private ApplicationSession session = MdaModule.getInjector().getInstance(ApplicationSession.class);

  private static final Log LOGGER  = LogFactory.getLogger(TextLine.class);

  private final boolean newSlide;

  public TextLine (boolean newSlide, Composite parent, int style) {
    super(parent, style);
    this.newSlide = newSlide;
  }

  public boolean isNewSlide () {
    return newSlide;
  }

  public void setText (String text) {

    if (session != null && session.getFeatureActivation().isShowWhitespaces()) {
      text = text.replaceAll(" ", "#");
    }

    super.setText(Utils.fillString(text, TEXTLINE_LENGTH)); //TODO Configurable
  }

  public String getSaveableText () {

    String text = getText();

    if (session != null && session.getFeatureActivation().isShowWhitespaces()) {
      text = text.replaceAll("#", " ");
    }

    return text;
  }

}
