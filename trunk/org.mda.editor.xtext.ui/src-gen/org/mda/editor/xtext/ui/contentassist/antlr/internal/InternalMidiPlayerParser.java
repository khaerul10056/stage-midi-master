package org.mda.editor.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.mda.editor.xtext.services.MidiPlayerGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMidiPlayerParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'REFRAIN'", "'BRIDGE'", "'VERS'", "'SOLO'", "'ZWISCHENSPIEL'", "'INTRO'", "'EXTRO'", "'name'", "'path'", "'fontsize'", "'pic'", "'key'", "'{'", "'}'", "'bar'", "'refPart'", "','", "'-'", "'('", "')'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalMidiPlayerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMidiPlayerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMidiPlayerParser.tokenNames; }
    public String getGrammarFileName() { return "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g"; }


     
     	private MidiPlayerGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MidiPlayerGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleMidiFile"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:61:1: entryRuleMidiFile : ruleMidiFile EOF ;
    public final void entryRuleMidiFile() throws RecognitionException {
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:62:1: ( ruleMidiFile EOF )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:63:1: ruleMidiFile EOF
            {
             before(grammarAccess.getMidiFileRule()); 
            pushFollow(FOLLOW_ruleMidiFile_in_entryRuleMidiFile61);
            ruleMidiFile();

            state._fsp--;

             after(grammarAccess.getMidiFileRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFile68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMidiFile"


    // $ANTLR start "ruleMidiFile"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:70:1: ruleMidiFile : ( ( rule__MidiFile__Group__0 ) ) ;
    public final void ruleMidiFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:74:2: ( ( ( rule__MidiFile__Group__0 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:75:1: ( ( rule__MidiFile__Group__0 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:75:1: ( ( rule__MidiFile__Group__0 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:76:1: ( rule__MidiFile__Group__0 )
            {
             before(grammarAccess.getMidiFileAccess().getGroup()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:77:1: ( rule__MidiFile__Group__0 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:77:2: rule__MidiFile__Group__0
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__0_in_ruleMidiFile94);
            rule__MidiFile__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMidiFile"


    // $ANTLR start "entryRuleEString"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:89:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:90:1: ( ruleEString EOF )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:91:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString121);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:98:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:102:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:103:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:103:1: ( ( rule__EString__Alternatives ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:104:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:105:1: ( rule__EString__Alternatives )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:105:2: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_rule__EString__Alternatives_in_ruleEString154);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleMidiFilePart"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:117:1: entryRuleMidiFilePart : ruleMidiFilePart EOF ;
    public final void entryRuleMidiFilePart() throws RecognitionException {
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:118:1: ( ruleMidiFilePart EOF )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:119:1: ruleMidiFilePart EOF
            {
             before(grammarAccess.getMidiFilePartRule()); 
            pushFollow(FOLLOW_ruleMidiFilePart_in_entryRuleMidiFilePart181);
            ruleMidiFilePart();

            state._fsp--;

             after(grammarAccess.getMidiFilePartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFilePart188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMidiFilePart"


    // $ANTLR start "ruleMidiFilePart"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:126:1: ruleMidiFilePart : ( ( rule__MidiFilePart__Group__0 ) ) ;
    public final void ruleMidiFilePart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:130:2: ( ( ( rule__MidiFilePart__Group__0 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:131:1: ( ( rule__MidiFilePart__Group__0 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:131:1: ( ( rule__MidiFilePart__Group__0 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:132:1: ( rule__MidiFilePart__Group__0 )
            {
             before(grammarAccess.getMidiFilePartAccess().getGroup()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:133:1: ( rule__MidiFilePart__Group__0 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:133:2: rule__MidiFilePart__Group__0
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group__0_in_ruleMidiFilePart214);
            rule__MidiFilePart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMidiFilePartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMidiFilePart"


    // $ANTLR start "entryRuleMidiFileTextLine"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:145:1: entryRuleMidiFileTextLine : ruleMidiFileTextLine EOF ;
    public final void entryRuleMidiFileTextLine() throws RecognitionException {
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:146:1: ( ruleMidiFileTextLine EOF )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:147:1: ruleMidiFileTextLine EOF
            {
             before(grammarAccess.getMidiFileTextLineRule()); 
            pushFollow(FOLLOW_ruleMidiFileTextLine_in_entryRuleMidiFileTextLine241);
            ruleMidiFileTextLine();

            state._fsp--;

             after(grammarAccess.getMidiFileTextLineRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFileTextLine248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMidiFileTextLine"


    // $ANTLR start "ruleMidiFileTextLine"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:154:1: ruleMidiFileTextLine : ( ( rule__MidiFileTextLine__Group__0 ) ) ;
    public final void ruleMidiFileTextLine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:158:2: ( ( ( rule__MidiFileTextLine__Group__0 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:159:1: ( ( rule__MidiFileTextLine__Group__0 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:159:1: ( ( rule__MidiFileTextLine__Group__0 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:160:1: ( rule__MidiFileTextLine__Group__0 )
            {
             before(grammarAccess.getMidiFileTextLineAccess().getGroup()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:161:1: ( rule__MidiFileTextLine__Group__0 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:161:2: rule__MidiFileTextLine__Group__0
            {
            pushFollow(FOLLOW_rule__MidiFileTextLine__Group__0_in_ruleMidiFileTextLine274);
            rule__MidiFileTextLine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileTextLineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMidiFileTextLine"


    // $ANTLR start "entryRuleEInt"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:173:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:174:1: ( ruleEInt EOF )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:175:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt301);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:182:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:186:2: ( ( ( rule__EInt__Group__0 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:187:1: ( ( rule__EInt__Group__0 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:187:1: ( ( rule__EInt__Group__0 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:188:1: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:189:1: ( rule__EInt__Group__0 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:189:2: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_rule__EInt__Group__0_in_ruleEInt334);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleMidiFileChordPart"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:201:1: entryRuleMidiFileChordPart : ruleMidiFileChordPart EOF ;
    public final void entryRuleMidiFileChordPart() throws RecognitionException {
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:202:1: ( ruleMidiFileChordPart EOF )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:203:1: ruleMidiFileChordPart EOF
            {
             before(grammarAccess.getMidiFileChordPartRule()); 
            pushFollow(FOLLOW_ruleMidiFileChordPart_in_entryRuleMidiFileChordPart361);
            ruleMidiFileChordPart();

            state._fsp--;

             after(grammarAccess.getMidiFileChordPartRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFileChordPart368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMidiFileChordPart"


    // $ANTLR start "ruleMidiFileChordPart"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:210:1: ruleMidiFileChordPart : ( ( rule__MidiFileChordPart__Group__0 ) ) ;
    public final void ruleMidiFileChordPart() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:214:2: ( ( ( rule__MidiFileChordPart__Group__0 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:215:1: ( ( rule__MidiFileChordPart__Group__0 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:215:1: ( ( rule__MidiFileChordPart__Group__0 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:216:1: ( rule__MidiFileChordPart__Group__0 )
            {
             before(grammarAccess.getMidiFileChordPartAccess().getGroup()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:217:1: ( rule__MidiFileChordPart__Group__0 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:217:2: rule__MidiFileChordPart__Group__0
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__Group__0_in_ruleMidiFileChordPart394);
            rule__MidiFileChordPart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileChordPartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMidiFileChordPart"


    // $ANTLR start "ruleMidiFilePartType"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:230:1: ruleMidiFilePartType : ( ( rule__MidiFilePartType__Alternatives ) ) ;
    public final void ruleMidiFilePartType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:234:1: ( ( ( rule__MidiFilePartType__Alternatives ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:235:1: ( ( rule__MidiFilePartType__Alternatives ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:235:1: ( ( rule__MidiFilePartType__Alternatives ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:236:1: ( rule__MidiFilePartType__Alternatives )
            {
             before(grammarAccess.getMidiFilePartTypeAccess().getAlternatives()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:237:1: ( rule__MidiFilePartType__Alternatives )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:237:2: rule__MidiFilePartType__Alternatives
            {
            pushFollow(FOLLOW_rule__MidiFilePartType__Alternatives_in_ruleMidiFilePartType431);
            rule__MidiFilePartType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMidiFilePartTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMidiFilePartType"


    // $ANTLR start "rule__EString__Alternatives"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:248:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:252:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:253:1: ( RULE_STRING )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:253:1: ( RULE_STRING )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:254:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EString__Alternatives466); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:259:6: ( RULE_ID )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:259:6: ( RULE_ID )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:260:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EString__Alternatives483); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__MidiFilePartType__Alternatives"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:270:1: rule__MidiFilePartType__Alternatives : ( ( ( 'REFRAIN' ) ) | ( ( 'BRIDGE' ) ) | ( ( 'VERS' ) ) | ( ( 'SOLO' ) ) | ( ( 'ZWISCHENSPIEL' ) ) | ( ( 'INTRO' ) ) | ( ( 'EXTRO' ) ) );
    public final void rule__MidiFilePartType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:274:1: ( ( ( 'REFRAIN' ) ) | ( ( 'BRIDGE' ) ) | ( ( 'VERS' ) ) | ( ( 'SOLO' ) ) | ( ( 'ZWISCHENSPIEL' ) ) | ( ( 'INTRO' ) ) | ( ( 'EXTRO' ) ) )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            case 14:
                {
                alt2=4;
                }
                break;
            case 15:
                {
                alt2=5;
                }
                break;
            case 16:
                {
                alt2=6;
                }
                break;
            case 17:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:275:1: ( ( 'REFRAIN' ) )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:275:1: ( ( 'REFRAIN' ) )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:276:1: ( 'REFRAIN' )
                    {
                     before(grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0()); 
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:277:1: ( 'REFRAIN' )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:277:3: 'REFRAIN'
                    {
                    match(input,11,FOLLOW_11_in_rule__MidiFilePartType__Alternatives516); 

                    }

                     after(grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:282:6: ( ( 'BRIDGE' ) )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:282:6: ( ( 'BRIDGE' ) )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:283:1: ( 'BRIDGE' )
                    {
                     before(grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1()); 
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:284:1: ( 'BRIDGE' )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:284:3: 'BRIDGE'
                    {
                    match(input,12,FOLLOW_12_in_rule__MidiFilePartType__Alternatives537); 

                    }

                     after(grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:289:6: ( ( 'VERS' ) )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:289:6: ( ( 'VERS' ) )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:290:1: ( 'VERS' )
                    {
                     before(grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2()); 
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:291:1: ( 'VERS' )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:291:3: 'VERS'
                    {
                    match(input,13,FOLLOW_13_in_rule__MidiFilePartType__Alternatives558); 

                    }

                     after(grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:296:6: ( ( 'SOLO' ) )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:296:6: ( ( 'SOLO' ) )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:297:1: ( 'SOLO' )
                    {
                     before(grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3()); 
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:298:1: ( 'SOLO' )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:298:3: 'SOLO'
                    {
                    match(input,14,FOLLOW_14_in_rule__MidiFilePartType__Alternatives579); 

                    }

                     after(grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:303:6: ( ( 'ZWISCHENSPIEL' ) )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:303:6: ( ( 'ZWISCHENSPIEL' ) )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:304:1: ( 'ZWISCHENSPIEL' )
                    {
                     before(grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4()); 
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:305:1: ( 'ZWISCHENSPIEL' )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:305:3: 'ZWISCHENSPIEL'
                    {
                    match(input,15,FOLLOW_15_in_rule__MidiFilePartType__Alternatives600); 

                    }

                     after(grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:310:6: ( ( 'INTRO' ) )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:310:6: ( ( 'INTRO' ) )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:311:1: ( 'INTRO' )
                    {
                     before(grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5()); 
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:312:1: ( 'INTRO' )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:312:3: 'INTRO'
                    {
                    match(input,16,FOLLOW_16_in_rule__MidiFilePartType__Alternatives621); 

                    }

                     after(grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:317:6: ( ( 'EXTRO' ) )
                    {
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:317:6: ( ( 'EXTRO' ) )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:318:1: ( 'EXTRO' )
                    {
                     before(grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6()); 
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:319:1: ( 'EXTRO' )
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:319:3: 'EXTRO'
                    {
                    match(input,17,FOLLOW_17_in_rule__MidiFilePartType__Alternatives642); 

                    }

                     after(grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePartType__Alternatives"


    // $ANTLR start "rule__MidiFile__Group__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:331:1: rule__MidiFile__Group__0 : rule__MidiFile__Group__0__Impl rule__MidiFile__Group__1 ;
    public final void rule__MidiFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:335:1: ( rule__MidiFile__Group__0__Impl rule__MidiFile__Group__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:336:2: rule__MidiFile__Group__0__Impl rule__MidiFile__Group__1
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__0__Impl_in_rule__MidiFile__Group__0675);
            rule__MidiFile__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group__1_in_rule__MidiFile__Group__0678);
            rule__MidiFile__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__0"


    // $ANTLR start "rule__MidiFile__Group__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:343:1: rule__MidiFile__Group__0__Impl : ( () ) ;
    public final void rule__MidiFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:347:1: ( ( () ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:348:1: ( () )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:348:1: ( () )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:349:1: ()
            {
             before(grammarAccess.getMidiFileAccess().getMidiFileAction_0()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:350:1: ()
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:352:1: 
            {
            }

             after(grammarAccess.getMidiFileAccess().getMidiFileAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__0__Impl"


    // $ANTLR start "rule__MidiFile__Group__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:362:1: rule__MidiFile__Group__1 : rule__MidiFile__Group__1__Impl rule__MidiFile__Group__2 ;
    public final void rule__MidiFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:366:1: ( rule__MidiFile__Group__1__Impl rule__MidiFile__Group__2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:367:2: rule__MidiFile__Group__1__Impl rule__MidiFile__Group__2
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__1__Impl_in_rule__MidiFile__Group__1736);
            rule__MidiFile__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group__2_in_rule__MidiFile__Group__1739);
            rule__MidiFile__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__1"


    // $ANTLR start "rule__MidiFile__Group__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:374:1: rule__MidiFile__Group__1__Impl : ( ( rule__MidiFile__Group_1__0 ) ) ;
    public final void rule__MidiFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:378:1: ( ( ( rule__MidiFile__Group_1__0 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:379:1: ( ( rule__MidiFile__Group_1__0 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:379:1: ( ( rule__MidiFile__Group_1__0 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:380:1: ( rule__MidiFile__Group_1__0 )
            {
             before(grammarAccess.getMidiFileAccess().getGroup_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:381:1: ( rule__MidiFile__Group_1__0 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:381:2: rule__MidiFile__Group_1__0
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_1__0_in_rule__MidiFile__Group__1__Impl766);
            rule__MidiFile__Group_1__0();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__1__Impl"


    // $ANTLR start "rule__MidiFile__Group__2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:391:1: rule__MidiFile__Group__2 : rule__MidiFile__Group__2__Impl rule__MidiFile__Group__3 ;
    public final void rule__MidiFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:395:1: ( rule__MidiFile__Group__2__Impl rule__MidiFile__Group__3 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:396:2: rule__MidiFile__Group__2__Impl rule__MidiFile__Group__3
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__2__Impl_in_rule__MidiFile__Group__2796);
            rule__MidiFile__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group__3_in_rule__MidiFile__Group__2799);
            rule__MidiFile__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__2"


    // $ANTLR start "rule__MidiFile__Group__2__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:403:1: rule__MidiFile__Group__2__Impl : ( ( rule__MidiFile__Group_2__0 )? ) ;
    public final void rule__MidiFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:407:1: ( ( ( rule__MidiFile__Group_2__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:408:1: ( ( rule__MidiFile__Group_2__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:408:1: ( ( rule__MidiFile__Group_2__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:409:1: ( rule__MidiFile__Group_2__0 )?
            {
             before(grammarAccess.getMidiFileAccess().getGroup_2()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:410:1: ( rule__MidiFile__Group_2__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:410:2: rule__MidiFile__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MidiFile__Group_2__0_in_rule__MidiFile__Group__2__Impl826);
                    rule__MidiFile__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFileAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__2__Impl"


    // $ANTLR start "rule__MidiFile__Group__3"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:420:1: rule__MidiFile__Group__3 : rule__MidiFile__Group__3__Impl rule__MidiFile__Group__4 ;
    public final void rule__MidiFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:424:1: ( rule__MidiFile__Group__3__Impl rule__MidiFile__Group__4 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:425:2: rule__MidiFile__Group__3__Impl rule__MidiFile__Group__4
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__3__Impl_in_rule__MidiFile__Group__3857);
            rule__MidiFile__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group__4_in_rule__MidiFile__Group__3860);
            rule__MidiFile__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__3"


    // $ANTLR start "rule__MidiFile__Group__3__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:432:1: rule__MidiFile__Group__3__Impl : ( ( rule__MidiFile__Group_3__0 )? ) ;
    public final void rule__MidiFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:436:1: ( ( ( rule__MidiFile__Group_3__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:437:1: ( ( rule__MidiFile__Group_3__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:437:1: ( ( rule__MidiFile__Group_3__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:438:1: ( rule__MidiFile__Group_3__0 )?
            {
             before(grammarAccess.getMidiFileAccess().getGroup_3()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:439:1: ( rule__MidiFile__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:439:2: rule__MidiFile__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__MidiFile__Group_3__0_in_rule__MidiFile__Group__3__Impl887);
                    rule__MidiFile__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFileAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__3__Impl"


    // $ANTLR start "rule__MidiFile__Group__4"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:449:1: rule__MidiFile__Group__4 : rule__MidiFile__Group__4__Impl rule__MidiFile__Group__5 ;
    public final void rule__MidiFile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:453:1: ( rule__MidiFile__Group__4__Impl rule__MidiFile__Group__5 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:454:2: rule__MidiFile__Group__4__Impl rule__MidiFile__Group__5
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__4__Impl_in_rule__MidiFile__Group__4918);
            rule__MidiFile__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group__5_in_rule__MidiFile__Group__4921);
            rule__MidiFile__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__4"


    // $ANTLR start "rule__MidiFile__Group__4__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:461:1: rule__MidiFile__Group__4__Impl : ( ( rule__MidiFile__Group_4__0 )? ) ;
    public final void rule__MidiFile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:465:1: ( ( ( rule__MidiFile__Group_4__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:466:1: ( ( rule__MidiFile__Group_4__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:466:1: ( ( rule__MidiFile__Group_4__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:467:1: ( rule__MidiFile__Group_4__0 )?
            {
             before(grammarAccess.getMidiFileAccess().getGroup_4()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:468:1: ( rule__MidiFile__Group_4__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==21) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:468:2: rule__MidiFile__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__MidiFile__Group_4__0_in_rule__MidiFile__Group__4__Impl948);
                    rule__MidiFile__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFileAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__4__Impl"


    // $ANTLR start "rule__MidiFile__Group__5"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:478:1: rule__MidiFile__Group__5 : rule__MidiFile__Group__5__Impl rule__MidiFile__Group__6 ;
    public final void rule__MidiFile__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:482:1: ( rule__MidiFile__Group__5__Impl rule__MidiFile__Group__6 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:483:2: rule__MidiFile__Group__5__Impl rule__MidiFile__Group__6
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__5__Impl_in_rule__MidiFile__Group__5979);
            rule__MidiFile__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group__6_in_rule__MidiFile__Group__5982);
            rule__MidiFile__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__5"


    // $ANTLR start "rule__MidiFile__Group__5__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:490:1: rule__MidiFile__Group__5__Impl : ( ( rule__MidiFile__Group_5__0 )? ) ;
    public final void rule__MidiFile__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:494:1: ( ( ( rule__MidiFile__Group_5__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:495:1: ( ( rule__MidiFile__Group_5__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:495:1: ( ( rule__MidiFile__Group_5__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:496:1: ( rule__MidiFile__Group_5__0 )?
            {
             before(grammarAccess.getMidiFileAccess().getGroup_5()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:497:1: ( rule__MidiFile__Group_5__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:497:2: rule__MidiFile__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__MidiFile__Group_5__0_in_rule__MidiFile__Group__5__Impl1009);
                    rule__MidiFile__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFileAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__5__Impl"


    // $ANTLR start "rule__MidiFile__Group__6"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:507:1: rule__MidiFile__Group__6 : rule__MidiFile__Group__6__Impl ;
    public final void rule__MidiFile__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:511:1: ( rule__MidiFile__Group__6__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:512:2: rule__MidiFile__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__MidiFile__Group__6__Impl_in_rule__MidiFile__Group__61040);
            rule__MidiFile__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__6"


    // $ANTLR start "rule__MidiFile__Group__6__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:518:1: rule__MidiFile__Group__6__Impl : ( ( rule__MidiFile__Group_6__0 )? ) ;
    public final void rule__MidiFile__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:522:1: ( ( ( rule__MidiFile__Group_6__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:523:1: ( ( rule__MidiFile__Group_6__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:523:1: ( ( rule__MidiFile__Group_6__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:524:1: ( rule__MidiFile__Group_6__0 )?
            {
             before(grammarAccess.getMidiFileAccess().getGroup_6()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:525:1: ( rule__MidiFile__Group_6__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==23) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:525:2: rule__MidiFile__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__MidiFile__Group_6__0_in_rule__MidiFile__Group__6__Impl1067);
                    rule__MidiFile__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFileAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group__6__Impl"


    // $ANTLR start "rule__MidiFile__Group_1__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:549:1: rule__MidiFile__Group_1__0 : rule__MidiFile__Group_1__0__Impl rule__MidiFile__Group_1__1 ;
    public final void rule__MidiFile__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:553:1: ( rule__MidiFile__Group_1__0__Impl rule__MidiFile__Group_1__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:554:2: rule__MidiFile__Group_1__0__Impl rule__MidiFile__Group_1__1
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_1__0__Impl_in_rule__MidiFile__Group_1__01112);
            rule__MidiFile__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group_1__1_in_rule__MidiFile__Group_1__01115);
            rule__MidiFile__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_1__0"


    // $ANTLR start "rule__MidiFile__Group_1__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:561:1: rule__MidiFile__Group_1__0__Impl : ( 'name' ) ;
    public final void rule__MidiFile__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:565:1: ( ( 'name' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:566:1: ( 'name' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:566:1: ( 'name' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:567:1: 'name'
            {
             before(grammarAccess.getMidiFileAccess().getNameKeyword_1_0()); 
            match(input,18,FOLLOW_18_in_rule__MidiFile__Group_1__0__Impl1143); 
             after(grammarAccess.getMidiFileAccess().getNameKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_1__0__Impl"


    // $ANTLR start "rule__MidiFile__Group_1__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:580:1: rule__MidiFile__Group_1__1 : rule__MidiFile__Group_1__1__Impl ;
    public final void rule__MidiFile__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:584:1: ( rule__MidiFile__Group_1__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:585:2: rule__MidiFile__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_1__1__Impl_in_rule__MidiFile__Group_1__11174);
            rule__MidiFile__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_1__1"


    // $ANTLR start "rule__MidiFile__Group_1__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:591:1: rule__MidiFile__Group_1__1__Impl : ( ( rule__MidiFile__NameAssignment_1_1 ) ) ;
    public final void rule__MidiFile__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:595:1: ( ( ( rule__MidiFile__NameAssignment_1_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:596:1: ( ( rule__MidiFile__NameAssignment_1_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:596:1: ( ( rule__MidiFile__NameAssignment_1_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:597:1: ( rule__MidiFile__NameAssignment_1_1 )
            {
             before(grammarAccess.getMidiFileAccess().getNameAssignment_1_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:598:1: ( rule__MidiFile__NameAssignment_1_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:598:2: rule__MidiFile__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MidiFile__NameAssignment_1_1_in_rule__MidiFile__Group_1__1__Impl1201);
            rule__MidiFile__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_1__1__Impl"


    // $ANTLR start "rule__MidiFile__Group_2__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:612:1: rule__MidiFile__Group_2__0 : rule__MidiFile__Group_2__0__Impl rule__MidiFile__Group_2__1 ;
    public final void rule__MidiFile__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:616:1: ( rule__MidiFile__Group_2__0__Impl rule__MidiFile__Group_2__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:617:2: rule__MidiFile__Group_2__0__Impl rule__MidiFile__Group_2__1
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_2__0__Impl_in_rule__MidiFile__Group_2__01235);
            rule__MidiFile__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group_2__1_in_rule__MidiFile__Group_2__01238);
            rule__MidiFile__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_2__0"


    // $ANTLR start "rule__MidiFile__Group_2__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:624:1: rule__MidiFile__Group_2__0__Impl : ( 'path' ) ;
    public final void rule__MidiFile__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:628:1: ( ( 'path' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:629:1: ( 'path' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:629:1: ( 'path' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:630:1: 'path'
            {
             before(grammarAccess.getMidiFileAccess().getPathKeyword_2_0()); 
            match(input,19,FOLLOW_19_in_rule__MidiFile__Group_2__0__Impl1266); 
             after(grammarAccess.getMidiFileAccess().getPathKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_2__0__Impl"


    // $ANTLR start "rule__MidiFile__Group_2__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:643:1: rule__MidiFile__Group_2__1 : rule__MidiFile__Group_2__1__Impl ;
    public final void rule__MidiFile__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:647:1: ( rule__MidiFile__Group_2__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:648:2: rule__MidiFile__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_2__1__Impl_in_rule__MidiFile__Group_2__11297);
            rule__MidiFile__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_2__1"


    // $ANTLR start "rule__MidiFile__Group_2__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:654:1: rule__MidiFile__Group_2__1__Impl : ( ( rule__MidiFile__PathAssignment_2_1 ) ) ;
    public final void rule__MidiFile__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:658:1: ( ( ( rule__MidiFile__PathAssignment_2_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:659:1: ( ( rule__MidiFile__PathAssignment_2_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:659:1: ( ( rule__MidiFile__PathAssignment_2_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:660:1: ( rule__MidiFile__PathAssignment_2_1 )
            {
             before(grammarAccess.getMidiFileAccess().getPathAssignment_2_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:661:1: ( rule__MidiFile__PathAssignment_2_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:661:2: rule__MidiFile__PathAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MidiFile__PathAssignment_2_1_in_rule__MidiFile__Group_2__1__Impl1324);
            rule__MidiFile__PathAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileAccess().getPathAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_2__1__Impl"


    // $ANTLR start "rule__MidiFile__Group_3__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:675:1: rule__MidiFile__Group_3__0 : rule__MidiFile__Group_3__0__Impl rule__MidiFile__Group_3__1 ;
    public final void rule__MidiFile__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:679:1: ( rule__MidiFile__Group_3__0__Impl rule__MidiFile__Group_3__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:680:2: rule__MidiFile__Group_3__0__Impl rule__MidiFile__Group_3__1
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_3__0__Impl_in_rule__MidiFile__Group_3__01358);
            rule__MidiFile__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group_3__1_in_rule__MidiFile__Group_3__01361);
            rule__MidiFile__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_3__0"


    // $ANTLR start "rule__MidiFile__Group_3__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:687:1: rule__MidiFile__Group_3__0__Impl : ( 'fontsize' ) ;
    public final void rule__MidiFile__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:691:1: ( ( 'fontsize' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:692:1: ( 'fontsize' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:692:1: ( 'fontsize' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:693:1: 'fontsize'
            {
             before(grammarAccess.getMidiFileAccess().getFontsizeKeyword_3_0()); 
            match(input,20,FOLLOW_20_in_rule__MidiFile__Group_3__0__Impl1389); 
             after(grammarAccess.getMidiFileAccess().getFontsizeKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_3__0__Impl"


    // $ANTLR start "rule__MidiFile__Group_3__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:706:1: rule__MidiFile__Group_3__1 : rule__MidiFile__Group_3__1__Impl ;
    public final void rule__MidiFile__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:710:1: ( rule__MidiFile__Group_3__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:711:2: rule__MidiFile__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_3__1__Impl_in_rule__MidiFile__Group_3__11420);
            rule__MidiFile__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_3__1"


    // $ANTLR start "rule__MidiFile__Group_3__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:717:1: rule__MidiFile__Group_3__1__Impl : ( ( rule__MidiFile__FontsizeAssignment_3_1 ) ) ;
    public final void rule__MidiFile__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:721:1: ( ( ( rule__MidiFile__FontsizeAssignment_3_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:722:1: ( ( rule__MidiFile__FontsizeAssignment_3_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:722:1: ( ( rule__MidiFile__FontsizeAssignment_3_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:723:1: ( rule__MidiFile__FontsizeAssignment_3_1 )
            {
             before(grammarAccess.getMidiFileAccess().getFontsizeAssignment_3_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:724:1: ( rule__MidiFile__FontsizeAssignment_3_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:724:2: rule__MidiFile__FontsizeAssignment_3_1
            {
            pushFollow(FOLLOW_rule__MidiFile__FontsizeAssignment_3_1_in_rule__MidiFile__Group_3__1__Impl1447);
            rule__MidiFile__FontsizeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileAccess().getFontsizeAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_3__1__Impl"


    // $ANTLR start "rule__MidiFile__Group_4__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:738:1: rule__MidiFile__Group_4__0 : rule__MidiFile__Group_4__0__Impl rule__MidiFile__Group_4__1 ;
    public final void rule__MidiFile__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:742:1: ( rule__MidiFile__Group_4__0__Impl rule__MidiFile__Group_4__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:743:2: rule__MidiFile__Group_4__0__Impl rule__MidiFile__Group_4__1
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_4__0__Impl_in_rule__MidiFile__Group_4__01481);
            rule__MidiFile__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group_4__1_in_rule__MidiFile__Group_4__01484);
            rule__MidiFile__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_4__0"


    // $ANTLR start "rule__MidiFile__Group_4__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:750:1: rule__MidiFile__Group_4__0__Impl : ( 'pic' ) ;
    public final void rule__MidiFile__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:754:1: ( ( 'pic' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:755:1: ( 'pic' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:755:1: ( 'pic' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:756:1: 'pic'
            {
             before(grammarAccess.getMidiFileAccess().getPicKeyword_4_0()); 
            match(input,21,FOLLOW_21_in_rule__MidiFile__Group_4__0__Impl1512); 
             after(grammarAccess.getMidiFileAccess().getPicKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_4__0__Impl"


    // $ANTLR start "rule__MidiFile__Group_4__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:769:1: rule__MidiFile__Group_4__1 : rule__MidiFile__Group_4__1__Impl ;
    public final void rule__MidiFile__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:773:1: ( rule__MidiFile__Group_4__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:774:2: rule__MidiFile__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_4__1__Impl_in_rule__MidiFile__Group_4__11543);
            rule__MidiFile__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_4__1"


    // $ANTLR start "rule__MidiFile__Group_4__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:780:1: rule__MidiFile__Group_4__1__Impl : ( ( rule__MidiFile__PicAssignment_4_1 ) ) ;
    public final void rule__MidiFile__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:784:1: ( ( ( rule__MidiFile__PicAssignment_4_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:785:1: ( ( rule__MidiFile__PicAssignment_4_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:785:1: ( ( rule__MidiFile__PicAssignment_4_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:786:1: ( rule__MidiFile__PicAssignment_4_1 )
            {
             before(grammarAccess.getMidiFileAccess().getPicAssignment_4_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:787:1: ( rule__MidiFile__PicAssignment_4_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:787:2: rule__MidiFile__PicAssignment_4_1
            {
            pushFollow(FOLLOW_rule__MidiFile__PicAssignment_4_1_in_rule__MidiFile__Group_4__1__Impl1570);
            rule__MidiFile__PicAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileAccess().getPicAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_4__1__Impl"


    // $ANTLR start "rule__MidiFile__Group_5__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:801:1: rule__MidiFile__Group_5__0 : rule__MidiFile__Group_5__0__Impl rule__MidiFile__Group_5__1 ;
    public final void rule__MidiFile__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:805:1: ( rule__MidiFile__Group_5__0__Impl rule__MidiFile__Group_5__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:806:2: rule__MidiFile__Group_5__0__Impl rule__MidiFile__Group_5__1
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_5__0__Impl_in_rule__MidiFile__Group_5__01604);
            rule__MidiFile__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group_5__1_in_rule__MidiFile__Group_5__01607);
            rule__MidiFile__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_5__0"


    // $ANTLR start "rule__MidiFile__Group_5__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:813:1: rule__MidiFile__Group_5__0__Impl : ( 'key' ) ;
    public final void rule__MidiFile__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:817:1: ( ( 'key' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:818:1: ( 'key' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:818:1: ( 'key' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:819:1: 'key'
            {
             before(grammarAccess.getMidiFileAccess().getKeyKeyword_5_0()); 
            match(input,22,FOLLOW_22_in_rule__MidiFile__Group_5__0__Impl1635); 
             after(grammarAccess.getMidiFileAccess().getKeyKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_5__0__Impl"


    // $ANTLR start "rule__MidiFile__Group_5__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:832:1: rule__MidiFile__Group_5__1 : rule__MidiFile__Group_5__1__Impl ;
    public final void rule__MidiFile__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:836:1: ( rule__MidiFile__Group_5__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:837:2: rule__MidiFile__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_5__1__Impl_in_rule__MidiFile__Group_5__11666);
            rule__MidiFile__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_5__1"


    // $ANTLR start "rule__MidiFile__Group_5__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:843:1: rule__MidiFile__Group_5__1__Impl : ( ( rule__MidiFile__KeyAssignment_5_1 ) ) ;
    public final void rule__MidiFile__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:847:1: ( ( ( rule__MidiFile__KeyAssignment_5_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:848:1: ( ( rule__MidiFile__KeyAssignment_5_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:848:1: ( ( rule__MidiFile__KeyAssignment_5_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:849:1: ( rule__MidiFile__KeyAssignment_5_1 )
            {
             before(grammarAccess.getMidiFileAccess().getKeyAssignment_5_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:850:1: ( rule__MidiFile__KeyAssignment_5_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:850:2: rule__MidiFile__KeyAssignment_5_1
            {
            pushFollow(FOLLOW_rule__MidiFile__KeyAssignment_5_1_in_rule__MidiFile__Group_5__1__Impl1693);
            rule__MidiFile__KeyAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileAccess().getKeyAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_5__1__Impl"


    // $ANTLR start "rule__MidiFile__Group_6__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:864:1: rule__MidiFile__Group_6__0 : rule__MidiFile__Group_6__0__Impl rule__MidiFile__Group_6__1 ;
    public final void rule__MidiFile__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:868:1: ( rule__MidiFile__Group_6__0__Impl rule__MidiFile__Group_6__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:869:2: rule__MidiFile__Group_6__0__Impl rule__MidiFile__Group_6__1
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_6__0__Impl_in_rule__MidiFile__Group_6__01727);
            rule__MidiFile__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group_6__1_in_rule__MidiFile__Group_6__01730);
            rule__MidiFile__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_6__0"


    // $ANTLR start "rule__MidiFile__Group_6__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:876:1: rule__MidiFile__Group_6__0__Impl : ( '{' ) ;
    public final void rule__MidiFile__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:880:1: ( ( '{' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:881:1: ( '{' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:881:1: ( '{' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:882:1: '{'
            {
             before(grammarAccess.getMidiFileAccess().getLeftCurlyBracketKeyword_6_0()); 
            match(input,23,FOLLOW_23_in_rule__MidiFile__Group_6__0__Impl1758); 
             after(grammarAccess.getMidiFileAccess().getLeftCurlyBracketKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_6__0__Impl"


    // $ANTLR start "rule__MidiFile__Group_6__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:895:1: rule__MidiFile__Group_6__1 : rule__MidiFile__Group_6__1__Impl rule__MidiFile__Group_6__2 ;
    public final void rule__MidiFile__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:899:1: ( rule__MidiFile__Group_6__1__Impl rule__MidiFile__Group_6__2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:900:2: rule__MidiFile__Group_6__1__Impl rule__MidiFile__Group_6__2
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_6__1__Impl_in_rule__MidiFile__Group_6__11789);
            rule__MidiFile__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFile__Group_6__2_in_rule__MidiFile__Group_6__11792);
            rule__MidiFile__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_6__1"


    // $ANTLR start "rule__MidiFile__Group_6__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:907:1: rule__MidiFile__Group_6__1__Impl : ( ( rule__MidiFile__PartsAssignment_6_1 )* ) ;
    public final void rule__MidiFile__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:911:1: ( ( ( rule__MidiFile__PartsAssignment_6_1 )* ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:912:1: ( ( rule__MidiFile__PartsAssignment_6_1 )* )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:912:1: ( ( rule__MidiFile__PartsAssignment_6_1 )* )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:913:1: ( rule__MidiFile__PartsAssignment_6_1 )*
            {
             before(grammarAccess.getMidiFileAccess().getPartsAssignment_6_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:914:1: ( rule__MidiFile__PartsAssignment_6_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=11 && LA8_0<=17)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:914:2: rule__MidiFile__PartsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_rule__MidiFile__PartsAssignment_6_1_in_rule__MidiFile__Group_6__1__Impl1819);
            	    rule__MidiFile__PartsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getMidiFileAccess().getPartsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_6__1__Impl"


    // $ANTLR start "rule__MidiFile__Group_6__2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:924:1: rule__MidiFile__Group_6__2 : rule__MidiFile__Group_6__2__Impl ;
    public final void rule__MidiFile__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:928:1: ( rule__MidiFile__Group_6__2__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:929:2: rule__MidiFile__Group_6__2__Impl
            {
            pushFollow(FOLLOW_rule__MidiFile__Group_6__2__Impl_in_rule__MidiFile__Group_6__21850);
            rule__MidiFile__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_6__2"


    // $ANTLR start "rule__MidiFile__Group_6__2__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:935:1: rule__MidiFile__Group_6__2__Impl : ( '}' ) ;
    public final void rule__MidiFile__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:939:1: ( ( '}' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:940:1: ( '}' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:940:1: ( '}' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:941:1: '}'
            {
             before(grammarAccess.getMidiFileAccess().getRightCurlyBracketKeyword_6_2()); 
            match(input,24,FOLLOW_24_in_rule__MidiFile__Group_6__2__Impl1878); 
             after(grammarAccess.getMidiFileAccess().getRightCurlyBracketKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__Group_6__2__Impl"


    // $ANTLR start "rule__MidiFilePart__Group__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:960:1: rule__MidiFilePart__Group__0 : rule__MidiFilePart__Group__0__Impl rule__MidiFilePart__Group__1 ;
    public final void rule__MidiFilePart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:964:1: ( rule__MidiFilePart__Group__0__Impl rule__MidiFilePart__Group__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:965:2: rule__MidiFilePart__Group__0__Impl rule__MidiFilePart__Group__1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group__0__Impl_in_rule__MidiFilePart__Group__01915);
            rule__MidiFilePart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group__1_in_rule__MidiFilePart__Group__01918);
            rule__MidiFilePart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__0"


    // $ANTLR start "rule__MidiFilePart__Group__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:972:1: rule__MidiFilePart__Group__0__Impl : ( () ) ;
    public final void rule__MidiFilePart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:976:1: ( ( () ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:977:1: ( () )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:977:1: ( () )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:978:1: ()
            {
             before(grammarAccess.getMidiFilePartAccess().getMidiFilePartAction_0()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:979:1: ()
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:981:1: 
            {
            }

             after(grammarAccess.getMidiFilePartAccess().getMidiFilePartAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__0__Impl"


    // $ANTLR start "rule__MidiFilePart__Group__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:991:1: rule__MidiFilePart__Group__1 : rule__MidiFilePart__Group__1__Impl rule__MidiFilePart__Group__2 ;
    public final void rule__MidiFilePart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:995:1: ( rule__MidiFilePart__Group__1__Impl rule__MidiFilePart__Group__2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:996:2: rule__MidiFilePart__Group__1__Impl rule__MidiFilePart__Group__2
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group__1__Impl_in_rule__MidiFilePart__Group__11976);
            rule__MidiFilePart__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group__2_in_rule__MidiFilePart__Group__11979);
            rule__MidiFilePart__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__1"


    // $ANTLR start "rule__MidiFilePart__Group__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1003:1: rule__MidiFilePart__Group__1__Impl : ( ( rule__MidiFilePart__ParttypeAssignment_1 ) ) ;
    public final void rule__MidiFilePart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1007:1: ( ( ( rule__MidiFilePart__ParttypeAssignment_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1008:1: ( ( rule__MidiFilePart__ParttypeAssignment_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1008:1: ( ( rule__MidiFilePart__ParttypeAssignment_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1009:1: ( rule__MidiFilePart__ParttypeAssignment_1 )
            {
             before(grammarAccess.getMidiFilePartAccess().getParttypeAssignment_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1010:1: ( rule__MidiFilePart__ParttypeAssignment_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1010:2: rule__MidiFilePart__ParttypeAssignment_1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__ParttypeAssignment_1_in_rule__MidiFilePart__Group__1__Impl2006);
            rule__MidiFilePart__ParttypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFilePartAccess().getParttypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__1__Impl"


    // $ANTLR start "rule__MidiFilePart__Group__2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1020:1: rule__MidiFilePart__Group__2 : rule__MidiFilePart__Group__2__Impl rule__MidiFilePart__Group__3 ;
    public final void rule__MidiFilePart__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1024:1: ( rule__MidiFilePart__Group__2__Impl rule__MidiFilePart__Group__3 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1025:2: rule__MidiFilePart__Group__2__Impl rule__MidiFilePart__Group__3
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group__2__Impl_in_rule__MidiFilePart__Group__22036);
            rule__MidiFilePart__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group__3_in_rule__MidiFilePart__Group__22039);
            rule__MidiFilePart__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__2"


    // $ANTLR start "rule__MidiFilePart__Group__2__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1032:1: rule__MidiFilePart__Group__2__Impl : ( ( rule__MidiFilePart__Group_2__0 )? ) ;
    public final void rule__MidiFilePart__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1036:1: ( ( ( rule__MidiFilePart__Group_2__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1037:1: ( ( rule__MidiFilePart__Group_2__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1037:1: ( ( rule__MidiFilePart__Group_2__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1038:1: ( rule__MidiFilePart__Group_2__0 )?
            {
             before(grammarAccess.getMidiFilePartAccess().getGroup_2()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1039:1: ( rule__MidiFilePart__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1039:2: rule__MidiFilePart__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__MidiFilePart__Group_2__0_in_rule__MidiFilePart__Group__2__Impl2066);
                    rule__MidiFilePart__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFilePartAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__2__Impl"


    // $ANTLR start "rule__MidiFilePart__Group__3"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1049:1: rule__MidiFilePart__Group__3 : rule__MidiFilePart__Group__3__Impl rule__MidiFilePart__Group__4 ;
    public final void rule__MidiFilePart__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1053:1: ( rule__MidiFilePart__Group__3__Impl rule__MidiFilePart__Group__4 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1054:2: rule__MidiFilePart__Group__3__Impl rule__MidiFilePart__Group__4
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group__3__Impl_in_rule__MidiFilePart__Group__32097);
            rule__MidiFilePart__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group__4_in_rule__MidiFilePart__Group__32100);
            rule__MidiFilePart__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__3"


    // $ANTLR start "rule__MidiFilePart__Group__3__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1061:1: rule__MidiFilePart__Group__3__Impl : ( ( rule__MidiFilePart__Group_3__0 )? ) ;
    public final void rule__MidiFilePart__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1065:1: ( ( ( rule__MidiFilePart__Group_3__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1066:1: ( ( rule__MidiFilePart__Group_3__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1066:1: ( ( rule__MidiFilePart__Group_3__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1067:1: ( rule__MidiFilePart__Group_3__0 )?
            {
             before(grammarAccess.getMidiFilePartAccess().getGroup_3()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1068:1: ( rule__MidiFilePart__Group_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1068:2: rule__MidiFilePart__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__MidiFilePart__Group_3__0_in_rule__MidiFilePart__Group__3__Impl2127);
                    rule__MidiFilePart__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFilePartAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__3__Impl"


    // $ANTLR start "rule__MidiFilePart__Group__4"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1078:1: rule__MidiFilePart__Group__4 : rule__MidiFilePart__Group__4__Impl ;
    public final void rule__MidiFilePart__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1082:1: ( rule__MidiFilePart__Group__4__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1083:2: rule__MidiFilePart__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group__4__Impl_in_rule__MidiFilePart__Group__42158);
            rule__MidiFilePart__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__4"


    // $ANTLR start "rule__MidiFilePart__Group__4__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1089:1: rule__MidiFilePart__Group__4__Impl : ( ( rule__MidiFilePart__Group_4__0 )? ) ;
    public final void rule__MidiFilePart__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1093:1: ( ( ( rule__MidiFilePart__Group_4__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1094:1: ( ( rule__MidiFilePart__Group_4__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1094:1: ( ( rule__MidiFilePart__Group_4__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1095:1: ( rule__MidiFilePart__Group_4__0 )?
            {
             before(grammarAccess.getMidiFilePartAccess().getGroup_4()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1096:1: ( rule__MidiFilePart__Group_4__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1096:2: rule__MidiFilePart__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__MidiFilePart__Group_4__0_in_rule__MidiFilePart__Group__4__Impl2185);
                    rule__MidiFilePart__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFilePartAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group__4__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_2__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1116:1: rule__MidiFilePart__Group_2__0 : rule__MidiFilePart__Group_2__0__Impl rule__MidiFilePart__Group_2__1 ;
    public final void rule__MidiFilePart__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1120:1: ( rule__MidiFilePart__Group_2__0__Impl rule__MidiFilePart__Group_2__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1121:2: rule__MidiFilePart__Group_2__0__Impl rule__MidiFilePart__Group_2__1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_2__0__Impl_in_rule__MidiFilePart__Group_2__02226);
            rule__MidiFilePart__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group_2__1_in_rule__MidiFilePart__Group_2__02229);
            rule__MidiFilePart__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_2__0"


    // $ANTLR start "rule__MidiFilePart__Group_2__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1128:1: rule__MidiFilePart__Group_2__0__Impl : ( 'bar' ) ;
    public final void rule__MidiFilePart__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1132:1: ( ( 'bar' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1133:1: ( 'bar' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1133:1: ( 'bar' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1134:1: 'bar'
            {
             before(grammarAccess.getMidiFilePartAccess().getBarKeyword_2_0()); 
            match(input,25,FOLLOW_25_in_rule__MidiFilePart__Group_2__0__Impl2257); 
             after(grammarAccess.getMidiFilePartAccess().getBarKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_2__0__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_2__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1147:1: rule__MidiFilePart__Group_2__1 : rule__MidiFilePart__Group_2__1__Impl ;
    public final void rule__MidiFilePart__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1151:1: ( rule__MidiFilePart__Group_2__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1152:2: rule__MidiFilePart__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_2__1__Impl_in_rule__MidiFilePart__Group_2__12288);
            rule__MidiFilePart__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_2__1"


    // $ANTLR start "rule__MidiFilePart__Group_2__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1158:1: rule__MidiFilePart__Group_2__1__Impl : ( ( rule__MidiFilePart__BarAssignment_2_1 ) ) ;
    public final void rule__MidiFilePart__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1162:1: ( ( ( rule__MidiFilePart__BarAssignment_2_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1163:1: ( ( rule__MidiFilePart__BarAssignment_2_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1163:1: ( ( rule__MidiFilePart__BarAssignment_2_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1164:1: ( rule__MidiFilePart__BarAssignment_2_1 )
            {
             before(grammarAccess.getMidiFilePartAccess().getBarAssignment_2_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1165:1: ( rule__MidiFilePart__BarAssignment_2_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1165:2: rule__MidiFilePart__BarAssignment_2_1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__BarAssignment_2_1_in_rule__MidiFilePart__Group_2__1__Impl2315);
            rule__MidiFilePart__BarAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFilePartAccess().getBarAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_2__1__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_3__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1179:1: rule__MidiFilePart__Group_3__0 : rule__MidiFilePart__Group_3__0__Impl rule__MidiFilePart__Group_3__1 ;
    public final void rule__MidiFilePart__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1183:1: ( rule__MidiFilePart__Group_3__0__Impl rule__MidiFilePart__Group_3__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1184:2: rule__MidiFilePart__Group_3__0__Impl rule__MidiFilePart__Group_3__1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_3__0__Impl_in_rule__MidiFilePart__Group_3__02349);
            rule__MidiFilePart__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group_3__1_in_rule__MidiFilePart__Group_3__02352);
            rule__MidiFilePart__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_3__0"


    // $ANTLR start "rule__MidiFilePart__Group_3__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1191:1: rule__MidiFilePart__Group_3__0__Impl : ( 'refPart' ) ;
    public final void rule__MidiFilePart__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1195:1: ( ( 'refPart' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1196:1: ( 'refPart' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1196:1: ( 'refPart' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1197:1: 'refPart'
            {
             before(grammarAccess.getMidiFilePartAccess().getRefPartKeyword_3_0()); 
            match(input,26,FOLLOW_26_in_rule__MidiFilePart__Group_3__0__Impl2380); 
             after(grammarAccess.getMidiFilePartAccess().getRefPartKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_3__0__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_3__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1210:1: rule__MidiFilePart__Group_3__1 : rule__MidiFilePart__Group_3__1__Impl ;
    public final void rule__MidiFilePart__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1214:1: ( rule__MidiFilePart__Group_3__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1215:2: rule__MidiFilePart__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_3__1__Impl_in_rule__MidiFilePart__Group_3__12411);
            rule__MidiFilePart__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_3__1"


    // $ANTLR start "rule__MidiFilePart__Group_3__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1221:1: rule__MidiFilePart__Group_3__1__Impl : ( ( rule__MidiFilePart__RefPartAssignment_3_1 ) ) ;
    public final void rule__MidiFilePart__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1225:1: ( ( ( rule__MidiFilePart__RefPartAssignment_3_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1226:1: ( ( rule__MidiFilePart__RefPartAssignment_3_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1226:1: ( ( rule__MidiFilePart__RefPartAssignment_3_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1227:1: ( rule__MidiFilePart__RefPartAssignment_3_1 )
            {
             before(grammarAccess.getMidiFilePartAccess().getRefPartAssignment_3_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1228:1: ( rule__MidiFilePart__RefPartAssignment_3_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1228:2: rule__MidiFilePart__RefPartAssignment_3_1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__RefPartAssignment_3_1_in_rule__MidiFilePart__Group_3__1__Impl2438);
            rule__MidiFilePart__RefPartAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFilePartAccess().getRefPartAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_3__1__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_4__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1242:1: rule__MidiFilePart__Group_4__0 : rule__MidiFilePart__Group_4__0__Impl rule__MidiFilePart__Group_4__1 ;
    public final void rule__MidiFilePart__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1246:1: ( rule__MidiFilePart__Group_4__0__Impl rule__MidiFilePart__Group_4__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1247:2: rule__MidiFilePart__Group_4__0__Impl rule__MidiFilePart__Group_4__1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_4__0__Impl_in_rule__MidiFilePart__Group_4__02472);
            rule__MidiFilePart__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group_4__1_in_rule__MidiFilePart__Group_4__02475);
            rule__MidiFilePart__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__0"


    // $ANTLR start "rule__MidiFilePart__Group_4__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1254:1: rule__MidiFilePart__Group_4__0__Impl : ( '{' ) ;
    public final void rule__MidiFilePart__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1258:1: ( ( '{' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1259:1: ( '{' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1259:1: ( '{' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1260:1: '{'
            {
             before(grammarAccess.getMidiFilePartAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,23,FOLLOW_23_in_rule__MidiFilePart__Group_4__0__Impl2503); 
             after(grammarAccess.getMidiFilePartAccess().getLeftCurlyBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__0__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_4__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1273:1: rule__MidiFilePart__Group_4__1 : rule__MidiFilePart__Group_4__1__Impl rule__MidiFilePart__Group_4__2 ;
    public final void rule__MidiFilePart__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1277:1: ( rule__MidiFilePart__Group_4__1__Impl rule__MidiFilePart__Group_4__2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1278:2: rule__MidiFilePart__Group_4__1__Impl rule__MidiFilePart__Group_4__2
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_4__1__Impl_in_rule__MidiFilePart__Group_4__12534);
            rule__MidiFilePart__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group_4__2_in_rule__MidiFilePart__Group_4__12537);
            rule__MidiFilePart__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__1"


    // $ANTLR start "rule__MidiFilePart__Group_4__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1285:1: rule__MidiFilePart__Group_4__1__Impl : ( ( rule__MidiFilePart__TextlinesAssignment_4_1 ) ) ;
    public final void rule__MidiFilePart__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1289:1: ( ( ( rule__MidiFilePart__TextlinesAssignment_4_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1290:1: ( ( rule__MidiFilePart__TextlinesAssignment_4_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1290:1: ( ( rule__MidiFilePart__TextlinesAssignment_4_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1291:1: ( rule__MidiFilePart__TextlinesAssignment_4_1 )
            {
             before(grammarAccess.getMidiFilePartAccess().getTextlinesAssignment_4_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1292:1: ( rule__MidiFilePart__TextlinesAssignment_4_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1292:2: rule__MidiFilePart__TextlinesAssignment_4_1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__TextlinesAssignment_4_1_in_rule__MidiFilePart__Group_4__1__Impl2564);
            rule__MidiFilePart__TextlinesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFilePartAccess().getTextlinesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__1__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_4__2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1302:1: rule__MidiFilePart__Group_4__2 : rule__MidiFilePart__Group_4__2__Impl rule__MidiFilePart__Group_4__3 ;
    public final void rule__MidiFilePart__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1306:1: ( rule__MidiFilePart__Group_4__2__Impl rule__MidiFilePart__Group_4__3 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1307:2: rule__MidiFilePart__Group_4__2__Impl rule__MidiFilePart__Group_4__3
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_4__2__Impl_in_rule__MidiFilePart__Group_4__22594);
            rule__MidiFilePart__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group_4__3_in_rule__MidiFilePart__Group_4__22597);
            rule__MidiFilePart__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__2"


    // $ANTLR start "rule__MidiFilePart__Group_4__2__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1314:1: rule__MidiFilePart__Group_4__2__Impl : ( ( rule__MidiFilePart__Group_4_2__0 )* ) ;
    public final void rule__MidiFilePart__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1318:1: ( ( ( rule__MidiFilePart__Group_4_2__0 )* ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1319:1: ( ( rule__MidiFilePart__Group_4_2__0 )* )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1319:1: ( ( rule__MidiFilePart__Group_4_2__0 )* )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1320:1: ( rule__MidiFilePart__Group_4_2__0 )*
            {
             before(grammarAccess.getMidiFilePartAccess().getGroup_4_2()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1321:1: ( rule__MidiFilePart__Group_4_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1321:2: rule__MidiFilePart__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_rule__MidiFilePart__Group_4_2__0_in_rule__MidiFilePart__Group_4__2__Impl2624);
            	    rule__MidiFilePart__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getMidiFilePartAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__2__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_4__3"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1331:1: rule__MidiFilePart__Group_4__3 : rule__MidiFilePart__Group_4__3__Impl ;
    public final void rule__MidiFilePart__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1335:1: ( rule__MidiFilePart__Group_4__3__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1336:2: rule__MidiFilePart__Group_4__3__Impl
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_4__3__Impl_in_rule__MidiFilePart__Group_4__32655);
            rule__MidiFilePart__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__3"


    // $ANTLR start "rule__MidiFilePart__Group_4__3__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1342:1: rule__MidiFilePart__Group_4__3__Impl : ( '}' ) ;
    public final void rule__MidiFilePart__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1346:1: ( ( '}' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1347:1: ( '}' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1347:1: ( '}' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1348:1: '}'
            {
             before(grammarAccess.getMidiFilePartAccess().getRightCurlyBracketKeyword_4_3()); 
            match(input,24,FOLLOW_24_in_rule__MidiFilePart__Group_4__3__Impl2683); 
             after(grammarAccess.getMidiFilePartAccess().getRightCurlyBracketKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4__3__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_4_2__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1369:1: rule__MidiFilePart__Group_4_2__0 : rule__MidiFilePart__Group_4_2__0__Impl rule__MidiFilePart__Group_4_2__1 ;
    public final void rule__MidiFilePart__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1373:1: ( rule__MidiFilePart__Group_4_2__0__Impl rule__MidiFilePart__Group_4_2__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1374:2: rule__MidiFilePart__Group_4_2__0__Impl rule__MidiFilePart__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_4_2__0__Impl_in_rule__MidiFilePart__Group_4_2__02722);
            rule__MidiFilePart__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFilePart__Group_4_2__1_in_rule__MidiFilePart__Group_4_2__02725);
            rule__MidiFilePart__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4_2__0"


    // $ANTLR start "rule__MidiFilePart__Group_4_2__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1381:1: rule__MidiFilePart__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__MidiFilePart__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1385:1: ( ( ',' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1386:1: ( ',' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1386:1: ( ',' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1387:1: ','
            {
             before(grammarAccess.getMidiFilePartAccess().getCommaKeyword_4_2_0()); 
            match(input,27,FOLLOW_27_in_rule__MidiFilePart__Group_4_2__0__Impl2753); 
             after(grammarAccess.getMidiFilePartAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4_2__0__Impl"


    // $ANTLR start "rule__MidiFilePart__Group_4_2__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1400:1: rule__MidiFilePart__Group_4_2__1 : rule__MidiFilePart__Group_4_2__1__Impl ;
    public final void rule__MidiFilePart__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1404:1: ( rule__MidiFilePart__Group_4_2__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1405:2: rule__MidiFilePart__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFilePart__Group_4_2__1__Impl_in_rule__MidiFilePart__Group_4_2__12784);
            rule__MidiFilePart__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4_2__1"


    // $ANTLR start "rule__MidiFilePart__Group_4_2__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1411:1: rule__MidiFilePart__Group_4_2__1__Impl : ( ( rule__MidiFilePart__TextlinesAssignment_4_2_1 ) ) ;
    public final void rule__MidiFilePart__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1415:1: ( ( ( rule__MidiFilePart__TextlinesAssignment_4_2_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1416:1: ( ( rule__MidiFilePart__TextlinesAssignment_4_2_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1416:1: ( ( rule__MidiFilePart__TextlinesAssignment_4_2_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1417:1: ( rule__MidiFilePart__TextlinesAssignment_4_2_1 )
            {
             before(grammarAccess.getMidiFilePartAccess().getTextlinesAssignment_4_2_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1418:1: ( rule__MidiFilePart__TextlinesAssignment_4_2_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1418:2: rule__MidiFilePart__TextlinesAssignment_4_2_1
            {
            pushFollow(FOLLOW_rule__MidiFilePart__TextlinesAssignment_4_2_1_in_rule__MidiFilePart__Group_4_2__1__Impl2811);
            rule__MidiFilePart__TextlinesAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFilePartAccess().getTextlinesAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__Group_4_2__1__Impl"


    // $ANTLR start "rule__MidiFileTextLine__Group__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1432:1: rule__MidiFileTextLine__Group__0 : rule__MidiFileTextLine__Group__0__Impl rule__MidiFileTextLine__Group__1 ;
    public final void rule__MidiFileTextLine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1436:1: ( rule__MidiFileTextLine__Group__0__Impl rule__MidiFileTextLine__Group__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1437:2: rule__MidiFileTextLine__Group__0__Impl rule__MidiFileTextLine__Group__1
            {
            pushFollow(FOLLOW_rule__MidiFileTextLine__Group__0__Impl_in_rule__MidiFileTextLine__Group__02845);
            rule__MidiFileTextLine__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFileTextLine__Group__1_in_rule__MidiFileTextLine__Group__02848);
            rule__MidiFileTextLine__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group__0"


    // $ANTLR start "rule__MidiFileTextLine__Group__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1444:1: rule__MidiFileTextLine__Group__0__Impl : ( () ) ;
    public final void rule__MidiFileTextLine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1448:1: ( ( () ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1449:1: ( () )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1449:1: ( () )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1450:1: ()
            {
             before(grammarAccess.getMidiFileTextLineAccess().getMidiFileTextLineAction_0()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1451:1: ()
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1453:1: 
            {
            }

             after(grammarAccess.getMidiFileTextLineAccess().getMidiFileTextLineAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group__0__Impl"


    // $ANTLR start "rule__MidiFileTextLine__Group__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1463:1: rule__MidiFileTextLine__Group__1 : rule__MidiFileTextLine__Group__1__Impl ;
    public final void rule__MidiFileTextLine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1467:1: ( rule__MidiFileTextLine__Group__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1468:2: rule__MidiFileTextLine__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MidiFileTextLine__Group__1__Impl_in_rule__MidiFileTextLine__Group__12906);
            rule__MidiFileTextLine__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group__1"


    // $ANTLR start "rule__MidiFileTextLine__Group__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1474:1: rule__MidiFileTextLine__Group__1__Impl : ( ( rule__MidiFileTextLine__Group_1__0 )? ) ;
    public final void rule__MidiFileTextLine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1478:1: ( ( ( rule__MidiFileTextLine__Group_1__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1479:1: ( ( rule__MidiFileTextLine__Group_1__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1479:1: ( ( rule__MidiFileTextLine__Group_1__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1480:1: ( rule__MidiFileTextLine__Group_1__0 )?
            {
             before(grammarAccess.getMidiFileTextLineAccess().getGroup_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1481:1: ( rule__MidiFileTextLine__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1481:2: rule__MidiFileTextLine__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__MidiFileTextLine__Group_1__0_in_rule__MidiFileTextLine__Group__1__Impl2933);
                    rule__MidiFileTextLine__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFileTextLineAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group__1__Impl"


    // $ANTLR start "rule__MidiFileTextLine__Group_1__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1495:1: rule__MidiFileTextLine__Group_1__0 : rule__MidiFileTextLine__Group_1__0__Impl rule__MidiFileTextLine__Group_1__1 ;
    public final void rule__MidiFileTextLine__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1499:1: ( rule__MidiFileTextLine__Group_1__0__Impl rule__MidiFileTextLine__Group_1__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1500:2: rule__MidiFileTextLine__Group_1__0__Impl rule__MidiFileTextLine__Group_1__1
            {
            pushFollow(FOLLOW_rule__MidiFileTextLine__Group_1__0__Impl_in_rule__MidiFileTextLine__Group_1__02968);
            rule__MidiFileTextLine__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFileTextLine__Group_1__1_in_rule__MidiFileTextLine__Group_1__02971);
            rule__MidiFileTextLine__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group_1__0"


    // $ANTLR start "rule__MidiFileTextLine__Group_1__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1507:1: rule__MidiFileTextLine__Group_1__0__Impl : ( '{' ) ;
    public final void rule__MidiFileTextLine__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1511:1: ( ( '{' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1512:1: ( '{' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1512:1: ( '{' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1513:1: '{'
            {
             before(grammarAccess.getMidiFileTextLineAccess().getLeftCurlyBracketKeyword_1_0()); 
            match(input,23,FOLLOW_23_in_rule__MidiFileTextLine__Group_1__0__Impl2999); 
             after(grammarAccess.getMidiFileTextLineAccess().getLeftCurlyBracketKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group_1__0__Impl"


    // $ANTLR start "rule__MidiFileTextLine__Group_1__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1526:1: rule__MidiFileTextLine__Group_1__1 : rule__MidiFileTextLine__Group_1__1__Impl rule__MidiFileTextLine__Group_1__2 ;
    public final void rule__MidiFileTextLine__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1530:1: ( rule__MidiFileTextLine__Group_1__1__Impl rule__MidiFileTextLine__Group_1__2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1531:2: rule__MidiFileTextLine__Group_1__1__Impl rule__MidiFileTextLine__Group_1__2
            {
            pushFollow(FOLLOW_rule__MidiFileTextLine__Group_1__1__Impl_in_rule__MidiFileTextLine__Group_1__13030);
            rule__MidiFileTextLine__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFileTextLine__Group_1__2_in_rule__MidiFileTextLine__Group_1__13033);
            rule__MidiFileTextLine__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group_1__1"


    // $ANTLR start "rule__MidiFileTextLine__Group_1__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1538:1: rule__MidiFileTextLine__Group_1__1__Impl : ( ( rule__MidiFileTextLine__ChordPartsAssignment_1_1 )* ) ;
    public final void rule__MidiFileTextLine__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1542:1: ( ( ( rule__MidiFileTextLine__ChordPartsAssignment_1_1 )* ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1543:1: ( ( rule__MidiFileTextLine__ChordPartsAssignment_1_1 )* )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1543:1: ( ( rule__MidiFileTextLine__ChordPartsAssignment_1_1 )* )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1544:1: ( rule__MidiFileTextLine__ChordPartsAssignment_1_1 )*
            {
             before(grammarAccess.getMidiFileTextLineAccess().getChordPartsAssignment_1_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1545:1: ( rule__MidiFileTextLine__ChordPartsAssignment_1_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_ID)||LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1545:2: rule__MidiFileTextLine__ChordPartsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_rule__MidiFileTextLine__ChordPartsAssignment_1_1_in_rule__MidiFileTextLine__Group_1__1__Impl3060);
            	    rule__MidiFileTextLine__ChordPartsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getMidiFileTextLineAccess().getChordPartsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group_1__1__Impl"


    // $ANTLR start "rule__MidiFileTextLine__Group_1__2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1555:1: rule__MidiFileTextLine__Group_1__2 : rule__MidiFileTextLine__Group_1__2__Impl ;
    public final void rule__MidiFileTextLine__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1559:1: ( rule__MidiFileTextLine__Group_1__2__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1560:2: rule__MidiFileTextLine__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__MidiFileTextLine__Group_1__2__Impl_in_rule__MidiFileTextLine__Group_1__23091);
            rule__MidiFileTextLine__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group_1__2"


    // $ANTLR start "rule__MidiFileTextLine__Group_1__2__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1566:1: rule__MidiFileTextLine__Group_1__2__Impl : ( '}' ) ;
    public final void rule__MidiFileTextLine__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1570:1: ( ( '}' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1571:1: ( '}' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1571:1: ( '}' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1572:1: '}'
            {
             before(grammarAccess.getMidiFileTextLineAccess().getRightCurlyBracketKeyword_1_2()); 
            match(input,24,FOLLOW_24_in_rule__MidiFileTextLine__Group_1__2__Impl3119); 
             after(grammarAccess.getMidiFileTextLineAccess().getRightCurlyBracketKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__Group_1__2__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1591:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1595:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1596:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__03156);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__03159);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1603:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1607:1: ( ( ( '-' )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1608:1: ( ( '-' )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1608:1: ( ( '-' )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1609:1: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1610:1: ( '-' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1611:2: '-'
                    {
                    match(input,28,FOLLOW_28_in_rule__EInt__Group__0__Impl3188); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1622:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1626:1: ( rule__EInt__Group__1__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1627:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__13221);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1633:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1637:1: ( ( RULE_INT ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1638:1: ( RULE_INT )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1638:1: ( RULE_INT )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1639:1: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl3248); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__MidiFileChordPart__Group__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1654:1: rule__MidiFileChordPart__Group__0 : rule__MidiFileChordPart__Group__0__Impl rule__MidiFileChordPart__Group__1 ;
    public final void rule__MidiFileChordPart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1658:1: ( rule__MidiFileChordPart__Group__0__Impl rule__MidiFileChordPart__Group__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1659:2: rule__MidiFileChordPart__Group__0__Impl rule__MidiFileChordPart__Group__1
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__Group__0__Impl_in_rule__MidiFileChordPart__Group__03281);
            rule__MidiFileChordPart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFileChordPart__Group__1_in_rule__MidiFileChordPart__Group__03284);
            rule__MidiFileChordPart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group__0"


    // $ANTLR start "rule__MidiFileChordPart__Group__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1666:1: rule__MidiFileChordPart__Group__0__Impl : ( () ) ;
    public final void rule__MidiFileChordPart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1670:1: ( ( () ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1671:1: ( () )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1671:1: ( () )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1672:1: ()
            {
             before(grammarAccess.getMidiFileChordPartAccess().getMidiFileChordPartAction_0()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1673:1: ()
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1675:1: 
            {
            }

             after(grammarAccess.getMidiFileChordPartAccess().getMidiFileChordPartAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group__0__Impl"


    // $ANTLR start "rule__MidiFileChordPart__Group__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1685:1: rule__MidiFileChordPart__Group__1 : rule__MidiFileChordPart__Group__1__Impl rule__MidiFileChordPart__Group__2 ;
    public final void rule__MidiFileChordPart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1689:1: ( rule__MidiFileChordPart__Group__1__Impl rule__MidiFileChordPart__Group__2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1690:2: rule__MidiFileChordPart__Group__1__Impl rule__MidiFileChordPart__Group__2
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__Group__1__Impl_in_rule__MidiFileChordPart__Group__13342);
            rule__MidiFileChordPart__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFileChordPart__Group__2_in_rule__MidiFileChordPart__Group__13345);
            rule__MidiFileChordPart__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group__1"


    // $ANTLR start "rule__MidiFileChordPart__Group__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1697:1: rule__MidiFileChordPart__Group__1__Impl : ( ( rule__MidiFileChordPart__Group_1__0 )? ) ;
    public final void rule__MidiFileChordPart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1701:1: ( ( ( rule__MidiFileChordPart__Group_1__0 )? ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1702:1: ( ( rule__MidiFileChordPart__Group_1__0 )? )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1702:1: ( ( rule__MidiFileChordPart__Group_1__0 )? )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1703:1: ( rule__MidiFileChordPart__Group_1__0 )?
            {
             before(grammarAccess.getMidiFileChordPartAccess().getGroup_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1704:1: ( rule__MidiFileChordPart__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==29) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1704:2: rule__MidiFileChordPart__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__MidiFileChordPart__Group_1__0_in_rule__MidiFileChordPart__Group__1__Impl3372);
                    rule__MidiFileChordPart__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMidiFileChordPartAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group__1__Impl"


    // $ANTLR start "rule__MidiFileChordPart__Group__2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1714:1: rule__MidiFileChordPart__Group__2 : rule__MidiFileChordPart__Group__2__Impl ;
    public final void rule__MidiFileChordPart__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1718:1: ( rule__MidiFileChordPart__Group__2__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1719:2: rule__MidiFileChordPart__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__Group__2__Impl_in_rule__MidiFileChordPart__Group__23403);
            rule__MidiFileChordPart__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group__2"


    // $ANTLR start "rule__MidiFileChordPart__Group__2__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1725:1: rule__MidiFileChordPart__Group__2__Impl : ( ( rule__MidiFileChordPart__TextAssignment_2 ) ) ;
    public final void rule__MidiFileChordPart__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1729:1: ( ( ( rule__MidiFileChordPart__TextAssignment_2 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1730:1: ( ( rule__MidiFileChordPart__TextAssignment_2 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1730:1: ( ( rule__MidiFileChordPart__TextAssignment_2 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1731:1: ( rule__MidiFileChordPart__TextAssignment_2 )
            {
             before(grammarAccess.getMidiFileChordPartAccess().getTextAssignment_2()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1732:1: ( rule__MidiFileChordPart__TextAssignment_2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1732:2: rule__MidiFileChordPart__TextAssignment_2
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__TextAssignment_2_in_rule__MidiFileChordPart__Group__2__Impl3430);
            rule__MidiFileChordPart__TextAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileChordPartAccess().getTextAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group__2__Impl"


    // $ANTLR start "rule__MidiFileChordPart__Group_1__0"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1748:1: rule__MidiFileChordPart__Group_1__0 : rule__MidiFileChordPart__Group_1__0__Impl rule__MidiFileChordPart__Group_1__1 ;
    public final void rule__MidiFileChordPart__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1752:1: ( rule__MidiFileChordPart__Group_1__0__Impl rule__MidiFileChordPart__Group_1__1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1753:2: rule__MidiFileChordPart__Group_1__0__Impl rule__MidiFileChordPart__Group_1__1
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__Group_1__0__Impl_in_rule__MidiFileChordPart__Group_1__03466);
            rule__MidiFileChordPart__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFileChordPart__Group_1__1_in_rule__MidiFileChordPart__Group_1__03469);
            rule__MidiFileChordPart__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group_1__0"


    // $ANTLR start "rule__MidiFileChordPart__Group_1__0__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1760:1: rule__MidiFileChordPart__Group_1__0__Impl : ( '(' ) ;
    public final void rule__MidiFileChordPart__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1764:1: ( ( '(' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1765:1: ( '(' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1765:1: ( '(' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1766:1: '('
            {
             before(grammarAccess.getMidiFileChordPartAccess().getLeftParenthesisKeyword_1_0()); 
            match(input,29,FOLLOW_29_in_rule__MidiFileChordPart__Group_1__0__Impl3497); 
             after(grammarAccess.getMidiFileChordPartAccess().getLeftParenthesisKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group_1__0__Impl"


    // $ANTLR start "rule__MidiFileChordPart__Group_1__1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1779:1: rule__MidiFileChordPart__Group_1__1 : rule__MidiFileChordPart__Group_1__1__Impl rule__MidiFileChordPart__Group_1__2 ;
    public final void rule__MidiFileChordPart__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1783:1: ( rule__MidiFileChordPart__Group_1__1__Impl rule__MidiFileChordPart__Group_1__2 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1784:2: rule__MidiFileChordPart__Group_1__1__Impl rule__MidiFileChordPart__Group_1__2
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__Group_1__1__Impl_in_rule__MidiFileChordPart__Group_1__13528);
            rule__MidiFileChordPart__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MidiFileChordPart__Group_1__2_in_rule__MidiFileChordPart__Group_1__13531);
            rule__MidiFileChordPart__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group_1__1"


    // $ANTLR start "rule__MidiFileChordPart__Group_1__1__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1791:1: rule__MidiFileChordPart__Group_1__1__Impl : ( ( rule__MidiFileChordPart__ChordAssignment_1_1 ) ) ;
    public final void rule__MidiFileChordPart__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1795:1: ( ( ( rule__MidiFileChordPart__ChordAssignment_1_1 ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1796:1: ( ( rule__MidiFileChordPart__ChordAssignment_1_1 ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1796:1: ( ( rule__MidiFileChordPart__ChordAssignment_1_1 ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1797:1: ( rule__MidiFileChordPart__ChordAssignment_1_1 )
            {
             before(grammarAccess.getMidiFileChordPartAccess().getChordAssignment_1_1()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1798:1: ( rule__MidiFileChordPart__ChordAssignment_1_1 )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1798:2: rule__MidiFileChordPart__ChordAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__ChordAssignment_1_1_in_rule__MidiFileChordPart__Group_1__1__Impl3558);
            rule__MidiFileChordPart__ChordAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMidiFileChordPartAccess().getChordAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group_1__1__Impl"


    // $ANTLR start "rule__MidiFileChordPart__Group_1__2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1808:1: rule__MidiFileChordPart__Group_1__2 : rule__MidiFileChordPart__Group_1__2__Impl ;
    public final void rule__MidiFileChordPart__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1812:1: ( rule__MidiFileChordPart__Group_1__2__Impl )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1813:2: rule__MidiFileChordPart__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__MidiFileChordPart__Group_1__2__Impl_in_rule__MidiFileChordPart__Group_1__23588);
            rule__MidiFileChordPart__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group_1__2"


    // $ANTLR start "rule__MidiFileChordPart__Group_1__2__Impl"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1819:1: rule__MidiFileChordPart__Group_1__2__Impl : ( ')' ) ;
    public final void rule__MidiFileChordPart__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1823:1: ( ( ')' ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1824:1: ( ')' )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1824:1: ( ')' )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1825:1: ')'
            {
             before(grammarAccess.getMidiFileChordPartAccess().getRightParenthesisKeyword_1_2()); 
            match(input,30,FOLLOW_30_in_rule__MidiFileChordPart__Group_1__2__Impl3616); 
             after(grammarAccess.getMidiFileChordPartAccess().getRightParenthesisKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__Group_1__2__Impl"


    // $ANTLR start "rule__MidiFile__NameAssignment_1_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1845:1: rule__MidiFile__NameAssignment_1_1 : ( ruleEString ) ;
    public final void rule__MidiFile__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1849:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1850:1: ( ruleEString )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1850:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1851:1: ruleEString
            {
             before(grammarAccess.getMidiFileAccess().getNameEStringParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFile__NameAssignment_1_13658);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFileAccess().getNameEStringParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__NameAssignment_1_1"


    // $ANTLR start "rule__MidiFile__PathAssignment_2_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1860:1: rule__MidiFile__PathAssignment_2_1 : ( ruleEString ) ;
    public final void rule__MidiFile__PathAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1864:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1865:1: ( ruleEString )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1865:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1866:1: ruleEString
            {
             before(grammarAccess.getMidiFileAccess().getPathEStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFile__PathAssignment_2_13689);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFileAccess().getPathEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__PathAssignment_2_1"


    // $ANTLR start "rule__MidiFile__FontsizeAssignment_3_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1875:1: rule__MidiFile__FontsizeAssignment_3_1 : ( ruleEString ) ;
    public final void rule__MidiFile__FontsizeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1879:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1880:1: ( ruleEString )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1880:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1881:1: ruleEString
            {
             before(grammarAccess.getMidiFileAccess().getFontsizeEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFile__FontsizeAssignment_3_13720);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFileAccess().getFontsizeEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__FontsizeAssignment_3_1"


    // $ANTLR start "rule__MidiFile__PicAssignment_4_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1890:1: rule__MidiFile__PicAssignment_4_1 : ( ruleEString ) ;
    public final void rule__MidiFile__PicAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1894:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1895:1: ( ruleEString )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1895:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1896:1: ruleEString
            {
             before(grammarAccess.getMidiFileAccess().getPicEStringParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFile__PicAssignment_4_13751);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFileAccess().getPicEStringParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__PicAssignment_4_1"


    // $ANTLR start "rule__MidiFile__KeyAssignment_5_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1905:1: rule__MidiFile__KeyAssignment_5_1 : ( ruleEString ) ;
    public final void rule__MidiFile__KeyAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1909:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1910:1: ( ruleEString )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1910:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1911:1: ruleEString
            {
             before(grammarAccess.getMidiFileAccess().getKeyEStringParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFile__KeyAssignment_5_13782);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFileAccess().getKeyEStringParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__KeyAssignment_5_1"


    // $ANTLR start "rule__MidiFile__PartsAssignment_6_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1920:1: rule__MidiFile__PartsAssignment_6_1 : ( ruleMidiFilePart ) ;
    public final void rule__MidiFile__PartsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1924:1: ( ( ruleMidiFilePart ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1925:1: ( ruleMidiFilePart )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1925:1: ( ruleMidiFilePart )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1926:1: ruleMidiFilePart
            {
             before(grammarAccess.getMidiFileAccess().getPartsMidiFilePartParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleMidiFilePart_in_rule__MidiFile__PartsAssignment_6_13813);
            ruleMidiFilePart();

            state._fsp--;

             after(grammarAccess.getMidiFileAccess().getPartsMidiFilePartParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFile__PartsAssignment_6_1"


    // $ANTLR start "rule__MidiFilePart__ParttypeAssignment_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1935:1: rule__MidiFilePart__ParttypeAssignment_1 : ( ruleMidiFilePartType ) ;
    public final void rule__MidiFilePart__ParttypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1939:1: ( ( ruleMidiFilePartType ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1940:1: ( ruleMidiFilePartType )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1940:1: ( ruleMidiFilePartType )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1941:1: ruleMidiFilePartType
            {
             before(grammarAccess.getMidiFilePartAccess().getParttypeMidiFilePartTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleMidiFilePartType_in_rule__MidiFilePart__ParttypeAssignment_13844);
            ruleMidiFilePartType();

            state._fsp--;

             after(grammarAccess.getMidiFilePartAccess().getParttypeMidiFilePartTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__ParttypeAssignment_1"


    // $ANTLR start "rule__MidiFilePart__BarAssignment_2_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1950:1: rule__MidiFilePart__BarAssignment_2_1 : ( ruleEInt ) ;
    public final void rule__MidiFilePart__BarAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1954:1: ( ( ruleEInt ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1955:1: ( ruleEInt )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1955:1: ( ruleEInt )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1956:1: ruleEInt
            {
             before(grammarAccess.getMidiFilePartAccess().getBarEIntParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleEInt_in_rule__MidiFilePart__BarAssignment_2_13875);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getMidiFilePartAccess().getBarEIntParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__BarAssignment_2_1"


    // $ANTLR start "rule__MidiFilePart__RefPartAssignment_3_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1965:1: rule__MidiFilePart__RefPartAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__MidiFilePart__RefPartAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1969:1: ( ( ( ruleEString ) ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1970:1: ( ( ruleEString ) )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1970:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1971:1: ( ruleEString )
            {
             before(grammarAccess.getMidiFilePartAccess().getRefPartMidiFilePartCrossReference_3_1_0()); 
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1972:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1973:1: ruleEString
            {
             before(grammarAccess.getMidiFilePartAccess().getRefPartMidiFilePartEStringParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFilePart__RefPartAssignment_3_13910);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFilePartAccess().getRefPartMidiFilePartEStringParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getMidiFilePartAccess().getRefPartMidiFilePartCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__RefPartAssignment_3_1"


    // $ANTLR start "rule__MidiFilePart__TextlinesAssignment_4_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1984:1: rule__MidiFilePart__TextlinesAssignment_4_1 : ( ruleMidiFileTextLine ) ;
    public final void rule__MidiFilePart__TextlinesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1988:1: ( ( ruleMidiFileTextLine ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1989:1: ( ruleMidiFileTextLine )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1989:1: ( ruleMidiFileTextLine )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1990:1: ruleMidiFileTextLine
            {
             before(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleMidiFileTextLine_in_rule__MidiFilePart__TextlinesAssignment_4_13945);
            ruleMidiFileTextLine();

            state._fsp--;

             after(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__TextlinesAssignment_4_1"


    // $ANTLR start "rule__MidiFilePart__TextlinesAssignment_4_2_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:1999:1: rule__MidiFilePart__TextlinesAssignment_4_2_1 : ( ruleMidiFileTextLine ) ;
    public final void rule__MidiFilePart__TextlinesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2003:1: ( ( ruleMidiFileTextLine ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2004:1: ( ruleMidiFileTextLine )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2004:1: ( ruleMidiFileTextLine )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2005:1: ruleMidiFileTextLine
            {
             before(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_ruleMidiFileTextLine_in_rule__MidiFilePart__TextlinesAssignment_4_2_13976);
            ruleMidiFileTextLine();

            state._fsp--;

             after(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFilePart__TextlinesAssignment_4_2_1"


    // $ANTLR start "rule__MidiFileTextLine__ChordPartsAssignment_1_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2014:1: rule__MidiFileTextLine__ChordPartsAssignment_1_1 : ( ruleMidiFileChordPart ) ;
    public final void rule__MidiFileTextLine__ChordPartsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2018:1: ( ( ruleMidiFileChordPart ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2019:1: ( ruleMidiFileChordPart )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2019:1: ( ruleMidiFileChordPart )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2020:1: ruleMidiFileChordPart
            {
             before(grammarAccess.getMidiFileTextLineAccess().getChordPartsMidiFileChordPartParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMidiFileChordPart_in_rule__MidiFileTextLine__ChordPartsAssignment_1_14007);
            ruleMidiFileChordPart();

            state._fsp--;

             after(grammarAccess.getMidiFileTextLineAccess().getChordPartsMidiFileChordPartParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileTextLine__ChordPartsAssignment_1_1"


    // $ANTLR start "rule__MidiFileChordPart__ChordAssignment_1_1"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2029:1: rule__MidiFileChordPart__ChordAssignment_1_1 : ( ruleEString ) ;
    public final void rule__MidiFileChordPart__ChordAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2033:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2034:1: ( ruleEString )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2034:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2035:1: ruleEString
            {
             before(grammarAccess.getMidiFileChordPartAccess().getChordEStringParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFileChordPart__ChordAssignment_1_14038);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFileChordPartAccess().getChordEStringParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__ChordAssignment_1_1"


    // $ANTLR start "rule__MidiFileChordPart__TextAssignment_2"
    // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2044:1: rule__MidiFileChordPart__TextAssignment_2 : ( ruleEString ) ;
    public final void rule__MidiFileChordPart__TextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2048:1: ( ( ruleEString ) )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2049:1: ( ruleEString )
            {
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2049:1: ( ruleEString )
            // ../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g:2050:1: ruleEString
            {
             before(grammarAccess.getMidiFileChordPartAccess().getTextEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__MidiFileChordPart__TextAssignment_24069);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMidiFileChordPartAccess().getTextEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MidiFileChordPart__TextAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMidiFile_in_entryRuleMidiFile61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFile68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__0_in_ruleMidiFile94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFilePart_in_entryRuleMidiFilePart181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFilePart188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__0_in_ruleMidiFilePart214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFileTextLine_in_entryRuleMidiFileTextLine241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFileTextLine248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group__0_in_ruleMidiFileTextLine274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0_in_ruleEInt334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFileChordPart_in_entryRuleMidiFileChordPart361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFileChordPart368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group__0_in_ruleMidiFileChordPart394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePartType__Alternatives_in_ruleMidiFilePartType431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__MidiFilePartType__Alternatives516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__MidiFilePartType__Alternatives537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__MidiFilePartType__Alternatives558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__MidiFilePartType__Alternatives579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__MidiFilePartType__Alternatives600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__MidiFilePartType__Alternatives621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__MidiFilePartType__Alternatives642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__0__Impl_in_rule__MidiFile__Group__0675 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__1_in_rule__MidiFile__Group__0678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__1__Impl_in_rule__MidiFile__Group__1736 = new BitSet(new long[]{0x0000000000F80000L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__2_in_rule__MidiFile__Group__1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_1__0_in_rule__MidiFile__Group__1__Impl766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__2__Impl_in_rule__MidiFile__Group__2796 = new BitSet(new long[]{0x0000000000F80000L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__3_in_rule__MidiFile__Group__2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_2__0_in_rule__MidiFile__Group__2__Impl826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__3__Impl_in_rule__MidiFile__Group__3857 = new BitSet(new long[]{0x0000000000F80000L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__4_in_rule__MidiFile__Group__3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_3__0_in_rule__MidiFile__Group__3__Impl887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__4__Impl_in_rule__MidiFile__Group__4918 = new BitSet(new long[]{0x0000000000F80000L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__5_in_rule__MidiFile__Group__4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_4__0_in_rule__MidiFile__Group__4__Impl948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__5__Impl_in_rule__MidiFile__Group__5979 = new BitSet(new long[]{0x0000000000F80000L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__6_in_rule__MidiFile__Group__5982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_5__0_in_rule__MidiFile__Group__5__Impl1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group__6__Impl_in_rule__MidiFile__Group__61040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_6__0_in_rule__MidiFile__Group__6__Impl1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_1__0__Impl_in_rule__MidiFile__Group_1__01112 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_1__1_in_rule__MidiFile__Group_1__01115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__MidiFile__Group_1__0__Impl1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_1__1__Impl_in_rule__MidiFile__Group_1__11174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__NameAssignment_1_1_in_rule__MidiFile__Group_1__1__Impl1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_2__0__Impl_in_rule__MidiFile__Group_2__01235 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_2__1_in_rule__MidiFile__Group_2__01238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__MidiFile__Group_2__0__Impl1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_2__1__Impl_in_rule__MidiFile__Group_2__11297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__PathAssignment_2_1_in_rule__MidiFile__Group_2__1__Impl1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_3__0__Impl_in_rule__MidiFile__Group_3__01358 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_3__1_in_rule__MidiFile__Group_3__01361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__MidiFile__Group_3__0__Impl1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_3__1__Impl_in_rule__MidiFile__Group_3__11420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__FontsizeAssignment_3_1_in_rule__MidiFile__Group_3__1__Impl1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_4__0__Impl_in_rule__MidiFile__Group_4__01481 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_4__1_in_rule__MidiFile__Group_4__01484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__MidiFile__Group_4__0__Impl1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_4__1__Impl_in_rule__MidiFile__Group_4__11543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__PicAssignment_4_1_in_rule__MidiFile__Group_4__1__Impl1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_5__0__Impl_in_rule__MidiFile__Group_5__01604 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_5__1_in_rule__MidiFile__Group_5__01607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__MidiFile__Group_5__0__Impl1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_5__1__Impl_in_rule__MidiFile__Group_5__11666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__KeyAssignment_5_1_in_rule__MidiFile__Group_5__1__Impl1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_6__0__Impl_in_rule__MidiFile__Group_6__01727 = new BitSet(new long[]{0x000000000103F800L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_6__1_in_rule__MidiFile__Group_6__01730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MidiFile__Group_6__0__Impl1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_6__1__Impl_in_rule__MidiFile__Group_6__11789 = new BitSet(new long[]{0x000000000103F800L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_6__2_in_rule__MidiFile__Group_6__11792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFile__PartsAssignment_6_1_in_rule__MidiFile__Group_6__1__Impl1819 = new BitSet(new long[]{0x000000000003F802L});
    public static final BitSet FOLLOW_rule__MidiFile__Group_6__2__Impl_in_rule__MidiFile__Group_6__21850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MidiFile__Group_6__2__Impl1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__0__Impl_in_rule__MidiFilePart__Group__01915 = new BitSet(new long[]{0x000000000003F800L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__1_in_rule__MidiFilePart__Group__01918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__1__Impl_in_rule__MidiFilePart__Group__11976 = new BitSet(new long[]{0x0000000006800000L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__2_in_rule__MidiFilePart__Group__11979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__ParttypeAssignment_1_in_rule__MidiFilePart__Group__1__Impl2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__2__Impl_in_rule__MidiFilePart__Group__22036 = new BitSet(new long[]{0x0000000006800000L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__3_in_rule__MidiFilePart__Group__22039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_2__0_in_rule__MidiFilePart__Group__2__Impl2066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__3__Impl_in_rule__MidiFilePart__Group__32097 = new BitSet(new long[]{0x0000000006800000L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__4_in_rule__MidiFilePart__Group__32100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_3__0_in_rule__MidiFilePart__Group__3__Impl2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group__4__Impl_in_rule__MidiFilePart__Group__42158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__0_in_rule__MidiFilePart__Group__4__Impl2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_2__0__Impl_in_rule__MidiFilePart__Group_2__02226 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_2__1_in_rule__MidiFilePart__Group_2__02229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__MidiFilePart__Group_2__0__Impl2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_2__1__Impl_in_rule__MidiFilePart__Group_2__12288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__BarAssignment_2_1_in_rule__MidiFilePart__Group_2__1__Impl2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_3__0__Impl_in_rule__MidiFilePart__Group_3__02349 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_3__1_in_rule__MidiFilePart__Group_3__02352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__MidiFilePart__Group_3__0__Impl2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_3__1__Impl_in_rule__MidiFilePart__Group_3__12411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__RefPartAssignment_3_1_in_rule__MidiFilePart__Group_3__1__Impl2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__0__Impl_in_rule__MidiFilePart__Group_4__02472 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__1_in_rule__MidiFilePart__Group_4__02475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MidiFilePart__Group_4__0__Impl2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__1__Impl_in_rule__MidiFilePart__Group_4__12534 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__2_in_rule__MidiFilePart__Group_4__12537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__TextlinesAssignment_4_1_in_rule__MidiFilePart__Group_4__1__Impl2564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__2__Impl_in_rule__MidiFilePart__Group_4__22594 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__3_in_rule__MidiFilePart__Group_4__22597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4_2__0_in_rule__MidiFilePart__Group_4__2__Impl2624 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4__3__Impl_in_rule__MidiFilePart__Group_4__32655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MidiFilePart__Group_4__3__Impl2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4_2__0__Impl_in_rule__MidiFilePart__Group_4_2__02722 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4_2__1_in_rule__MidiFilePart__Group_4_2__02725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MidiFilePart__Group_4_2__0__Impl2753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__Group_4_2__1__Impl_in_rule__MidiFilePart__Group_4_2__12784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFilePart__TextlinesAssignment_4_2_1_in_rule__MidiFilePart__Group_4_2__1__Impl2811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group__0__Impl_in_rule__MidiFileTextLine__Group__02845 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group__1_in_rule__MidiFileTextLine__Group__02848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group__1__Impl_in_rule__MidiFileTextLine__Group__12906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group_1__0_in_rule__MidiFileTextLine__Group__1__Impl2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group_1__0__Impl_in_rule__MidiFileTextLine__Group_1__02968 = new BitSet(new long[]{0x0000000021000030L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group_1__1_in_rule__MidiFileTextLine__Group_1__02971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__MidiFileTextLine__Group_1__0__Impl2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group_1__1__Impl_in_rule__MidiFileTextLine__Group_1__13030 = new BitSet(new long[]{0x0000000021000030L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group_1__2_in_rule__MidiFileTextLine__Group_1__13033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__ChordPartsAssignment_1_1_in_rule__MidiFileTextLine__Group_1__1__Impl3060 = new BitSet(new long[]{0x0000000020000032L});
    public static final BitSet FOLLOW_rule__MidiFileTextLine__Group_1__2__Impl_in_rule__MidiFileTextLine__Group_1__23091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__MidiFileTextLine__Group_1__2__Impl3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__03156 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__03159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__EInt__Group__0__Impl3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__13221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group__0__Impl_in_rule__MidiFileChordPart__Group__03281 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group__1_in_rule__MidiFileChordPart__Group__03284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group__1__Impl_in_rule__MidiFileChordPart__Group__13342 = new BitSet(new long[]{0x0000000020000030L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group__2_in_rule__MidiFileChordPart__Group__13345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group_1__0_in_rule__MidiFileChordPart__Group__1__Impl3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group__2__Impl_in_rule__MidiFileChordPart__Group__23403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__TextAssignment_2_in_rule__MidiFileChordPart__Group__2__Impl3430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group_1__0__Impl_in_rule__MidiFileChordPart__Group_1__03466 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group_1__1_in_rule__MidiFileChordPart__Group_1__03469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MidiFileChordPart__Group_1__0__Impl3497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group_1__1__Impl_in_rule__MidiFileChordPart__Group_1__13528 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group_1__2_in_rule__MidiFileChordPart__Group_1__13531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__ChordAssignment_1_1_in_rule__MidiFileChordPart__Group_1__1__Impl3558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MidiFileChordPart__Group_1__2__Impl_in_rule__MidiFileChordPart__Group_1__23588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__MidiFileChordPart__Group_1__2__Impl3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFile__NameAssignment_1_13658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFile__PathAssignment_2_13689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFile__FontsizeAssignment_3_13720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFile__PicAssignment_4_13751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFile__KeyAssignment_5_13782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFilePart_in_rule__MidiFile__PartsAssignment_6_13813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFilePartType_in_rule__MidiFilePart__ParttypeAssignment_13844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_rule__MidiFilePart__BarAssignment_2_13875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFilePart__RefPartAssignment_3_13910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFileTextLine_in_rule__MidiFilePart__TextlinesAssignment_4_13945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFileTextLine_in_rule__MidiFilePart__TextlinesAssignment_4_2_13976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFileChordPart_in_rule__MidiFileTextLine__ChordPartsAssignment_1_14007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFileChordPart__ChordAssignment_1_14038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__MidiFileChordPart__TextAssignment_24069 = new BitSet(new long[]{0x0000000000000002L});

}