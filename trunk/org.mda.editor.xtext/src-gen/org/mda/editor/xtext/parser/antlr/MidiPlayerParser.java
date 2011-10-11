/*
* generated by Xtext
*/
package org.mda.editor.xtext.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.mda.editor.xtext.services.MidiPlayerGrammarAccess;

public class MidiPlayerParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private MidiPlayerGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.mda.editor.xtext.parser.antlr.internal.InternalMidiPlayerParser createParser(XtextTokenStream stream) {
		return new org.mda.editor.xtext.parser.antlr.internal.InternalMidiPlayerParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "MidiFile";
	}
	
	public MidiPlayerGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MidiPlayerGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
