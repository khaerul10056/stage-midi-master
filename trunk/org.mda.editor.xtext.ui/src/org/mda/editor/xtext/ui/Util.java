package org.mda.editor.xtext.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.Serializer;
import org.mda.editor.xtext.parser.antlr.MidiPlayerParser;
import org.mda.editor.xtext.ui.internal.MidiPlayerActivator;
import com.google.inject.Injector;


public class Util {

  public final static String getSerializedString (EObject eobject) {
    Injector injector = MidiPlayerActivator.getInstance().getInjector("org.mda.editor.xtext.MidiPlayer");
    Serializer serializer = injector.getInstance(Serializer.class);
    return serializer.serialize(eobject);
  }

  public final static EObject getModel (final String string) {
    Injector injector = MidiPlayerActivator.getInstance().getInjector("org.mda.editor.xtext.MidiPlayer");
    MidiPlayerParser parser = injector.getInstance(MidiPlayerParser.class);
    IParseResult doParse = parser.doParse(string.subSequence(0, string.length()));
    return doParse.getRootASTElement();
  }

}
