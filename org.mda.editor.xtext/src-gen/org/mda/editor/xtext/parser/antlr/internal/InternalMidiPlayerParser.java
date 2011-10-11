package org.mda.editor.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.mda.editor.xtext.services.MidiPlayerGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMidiPlayerParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'name'", "'path'", "'fontsize'", "'pic'", "'key'", "'{'", "'}'", "'bar'", "'refPart'", "','", "'-'", "'('", "')'", "'REFRAIN'", "'BRIDGE'", "'VERS'", "'SOLO'", "'ZWISCHENSPIEL'", "'INTRO'", "'EXTRO'"
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
    public String getGrammarFileName() { return "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g"; }



     	private MidiPlayerGrammarAccess grammarAccess;
     	
        public InternalMidiPlayerParser(TokenStream input, MidiPlayerGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MidiFile";	
       	}
       	
       	@Override
       	protected MidiPlayerGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMidiFile"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:68:1: entryRuleMidiFile returns [EObject current=null] : iv_ruleMidiFile= ruleMidiFile EOF ;
    public final EObject entryRuleMidiFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFile = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:69:2: (iv_ruleMidiFile= ruleMidiFile EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:70:2: iv_ruleMidiFile= ruleMidiFile EOF
            {
             newCompositeNode(grammarAccess.getMidiFileRule()); 
            pushFollow(FOLLOW_ruleMidiFile_in_entryRuleMidiFile75);
            iv_ruleMidiFile=ruleMidiFile();

            state._fsp--;

             current =iv_ruleMidiFile; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFile85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMidiFile"


    // $ANTLR start "ruleMidiFile"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:77:1: ruleMidiFile returns [EObject current=null] : ( () (otherlv_1= 'name' ( (lv_name_2_0= ruleEString ) ) ) (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? (otherlv_7= 'pic' ( (lv_pic_8_0= ruleEString ) ) )? (otherlv_9= 'key' ( (lv_key_10_0= ruleEString ) ) )? (otherlv_11= '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* otherlv_13= '}' )? ) ;
    public final EObject ruleMidiFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_path_4_0 = null;

        AntlrDatatypeRuleToken lv_fontsize_6_0 = null;

        AntlrDatatypeRuleToken lv_pic_8_0 = null;

        AntlrDatatypeRuleToken lv_key_10_0 = null;

        EObject lv_parts_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:80:28: ( ( () (otherlv_1= 'name' ( (lv_name_2_0= ruleEString ) ) ) (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? (otherlv_7= 'pic' ( (lv_pic_8_0= ruleEString ) ) )? (otherlv_9= 'key' ( (lv_key_10_0= ruleEString ) ) )? (otherlv_11= '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* otherlv_13= '}' )? ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:81:1: ( () (otherlv_1= 'name' ( (lv_name_2_0= ruleEString ) ) ) (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? (otherlv_7= 'pic' ( (lv_pic_8_0= ruleEString ) ) )? (otherlv_9= 'key' ( (lv_key_10_0= ruleEString ) ) )? (otherlv_11= '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* otherlv_13= '}' )? )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:81:1: ( () (otherlv_1= 'name' ( (lv_name_2_0= ruleEString ) ) ) (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? (otherlv_7= 'pic' ( (lv_pic_8_0= ruleEString ) ) )? (otherlv_9= 'key' ( (lv_key_10_0= ruleEString ) ) )? (otherlv_11= '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* otherlv_13= '}' )? )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:81:2: () (otherlv_1= 'name' ( (lv_name_2_0= ruleEString ) ) ) (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )? (otherlv_5= 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? (otherlv_7= 'pic' ( (lv_pic_8_0= ruleEString ) ) )? (otherlv_9= 'key' ( (lv_key_10_0= ruleEString ) ) )? (otherlv_11= '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* otherlv_13= '}' )?
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:81:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMidiFileAccess().getMidiFileAction_0(),
                        current);
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:87:2: (otherlv_1= 'name' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:87:4: otherlv_1= 'name' ( (lv_name_2_0= ruleEString ) )
            {
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleMidiFile132); 

                	newLeafNode(otherlv_1, grammarAccess.getMidiFileAccess().getNameKeyword_1_0());
                
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:91:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:92:1: (lv_name_2_0= ruleEString )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:92:1: (lv_name_2_0= ruleEString )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:93:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getMidiFileAccess().getNameEStringParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleMidiFile153);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMidiFileRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:109:3: (otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:109:5: otherlv_3= 'path' ( (lv_path_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleMidiFile167); 

                        	newLeafNode(otherlv_3, grammarAccess.getMidiFileAccess().getPathKeyword_2_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:113:1: ( (lv_path_4_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:114:1: (lv_path_4_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:114:1: (lv_path_4_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:115:3: lv_path_4_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getMidiFileAccess().getPathEStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleMidiFile188);
                    lv_path_4_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMidiFileRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_4_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:131:4: (otherlv_5= 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:131:6: otherlv_5= 'fontsize' ( (lv_fontsize_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleMidiFile203); 

                        	newLeafNode(otherlv_5, grammarAccess.getMidiFileAccess().getFontsizeKeyword_3_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:135:1: ( (lv_fontsize_6_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:136:1: (lv_fontsize_6_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:136:1: (lv_fontsize_6_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:137:3: lv_fontsize_6_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getMidiFileAccess().getFontsizeEStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleMidiFile224);
                    lv_fontsize_6_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMidiFileRule());
                    	        }
                           		set(
                           			current, 
                           			"fontsize",
                            		lv_fontsize_6_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:153:4: (otherlv_7= 'pic' ( (lv_pic_8_0= ruleEString ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:153:6: otherlv_7= 'pic' ( (lv_pic_8_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleMidiFile239); 

                        	newLeafNode(otherlv_7, grammarAccess.getMidiFileAccess().getPicKeyword_4_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:157:1: ( (lv_pic_8_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:158:1: (lv_pic_8_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:158:1: (lv_pic_8_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:159:3: lv_pic_8_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getMidiFileAccess().getPicEStringParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleMidiFile260);
                    lv_pic_8_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMidiFileRule());
                    	        }
                           		set(
                           			current, 
                           			"pic",
                            		lv_pic_8_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:175:4: (otherlv_9= 'key' ( (lv_key_10_0= ruleEString ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:175:6: otherlv_9= 'key' ( (lv_key_10_0= ruleEString ) )
                    {
                    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleMidiFile275); 

                        	newLeafNode(otherlv_9, grammarAccess.getMidiFileAccess().getKeyKeyword_5_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:179:1: ( (lv_key_10_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:180:1: (lv_key_10_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:180:1: (lv_key_10_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:181:3: lv_key_10_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getMidiFileAccess().getKeyEStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleMidiFile296);
                    lv_key_10_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMidiFileRule());
                    	        }
                           		set(
                           			current, 
                           			"key",
                            		lv_key_10_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:197:4: (otherlv_11= '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* otherlv_13= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:197:6: otherlv_11= '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* otherlv_13= '}'
                    {
                    otherlv_11=(Token)match(input,16,FOLLOW_16_in_ruleMidiFile311); 

                        	newLeafNode(otherlv_11, grammarAccess.getMidiFileAccess().getLeftCurlyBracketKeyword_6_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:201:1: ( (lv_parts_12_0= ruleMidiFilePart ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=24 && LA5_0<=30)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:202:1: (lv_parts_12_0= ruleMidiFilePart )
                    	    {
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:202:1: (lv_parts_12_0= ruleMidiFilePart )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:203:3: lv_parts_12_0= ruleMidiFilePart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMidiFileAccess().getPartsMidiFilePartParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMidiFilePart_in_ruleMidiFile332);
                    	    lv_parts_12_0=ruleMidiFilePart();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMidiFileRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parts",
                    	            		lv_parts_12_0, 
                    	            		"MidiFilePart");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleMidiFile345); 

                        	newLeafNode(otherlv_13, grammarAccess.getMidiFileAccess().getRightCurlyBracketKeyword_6_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMidiFile"


    // $ANTLR start "entryRuleEString"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:231:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:232:2: (iv_ruleEString= ruleEString EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:233:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString384);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString395); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:240:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:243:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:244:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:244:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:244:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEString435); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:252:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEString461); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleMidiFilePart"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:267:1: entryRuleMidiFilePart returns [EObject current=null] : iv_ruleMidiFilePart= ruleMidiFilePart EOF ;
    public final EObject entryRuleMidiFilePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFilePart = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:268:2: (iv_ruleMidiFilePart= ruleMidiFilePart EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:269:2: iv_ruleMidiFilePart= ruleMidiFilePart EOF
            {
             newCompositeNode(grammarAccess.getMidiFilePartRule()); 
            pushFollow(FOLLOW_ruleMidiFilePart_in_entryRuleMidiFilePart506);
            iv_ruleMidiFilePart=ruleMidiFilePart();

            state._fsp--;

             current =iv_ruleMidiFilePart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFilePart516); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMidiFilePart"


    // $ANTLR start "ruleMidiFilePart"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:276:1: ruleMidiFilePart returns [EObject current=null] : ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? (otherlv_4= 'refPart' ( ( ruleEString ) ) )? (otherlv_6= '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* otherlv_10= '}' )? ) ;
    public final EObject ruleMidiFilePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Enumerator lv_parttype_1_0 = null;

        AntlrDatatypeRuleToken lv_bar_3_0 = null;

        EObject lv_textlines_7_0 = null;

        EObject lv_textlines_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:279:28: ( ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? (otherlv_4= 'refPart' ( ( ruleEString ) ) )? (otherlv_6= '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* otherlv_10= '}' )? ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:280:1: ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? (otherlv_4= 'refPart' ( ( ruleEString ) ) )? (otherlv_6= '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* otherlv_10= '}' )? )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:280:1: ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? (otherlv_4= 'refPart' ( ( ruleEString ) ) )? (otherlv_6= '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* otherlv_10= '}' )? )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:280:2: () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? (otherlv_4= 'refPart' ( ( ruleEString ) ) )? (otherlv_6= '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* otherlv_10= '}' )?
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:280:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:281:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMidiFilePartAccess().getMidiFilePartAction_0(),
                        current);
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:286:2: ( (lv_parttype_1_0= ruleMidiFilePartType ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:287:1: (lv_parttype_1_0= ruleMidiFilePartType )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:287:1: (lv_parttype_1_0= ruleMidiFilePartType )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:288:3: lv_parttype_1_0= ruleMidiFilePartType
            {
             
            	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getParttypeMidiFilePartTypeEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMidiFilePartType_in_ruleMidiFilePart571);
            lv_parttype_1_0=ruleMidiFilePartType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
            	        }
                   		set(
                   			current, 
                   			"parttype",
                    		lv_parttype_1_0, 
                    		"MidiFilePartType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:304:2: (otherlv_2= 'bar' ( (lv_bar_3_0= ruleEInt ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:304:4: otherlv_2= 'bar' ( (lv_bar_3_0= ruleEInt ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleMidiFilePart584); 

                        	newLeafNode(otherlv_2, grammarAccess.getMidiFilePartAccess().getBarKeyword_2_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:308:1: ( (lv_bar_3_0= ruleEInt ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:309:1: (lv_bar_3_0= ruleEInt )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:309:1: (lv_bar_3_0= ruleEInt )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:310:3: lv_bar_3_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getBarEIntParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEInt_in_ruleMidiFilePart605);
                    lv_bar_3_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
                    	        }
                           		set(
                           			current, 
                           			"bar",
                            		lv_bar_3_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:326:4: (otherlv_4= 'refPart' ( ( ruleEString ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:326:6: otherlv_4= 'refPart' ( ( ruleEString ) )
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleMidiFilePart620); 

                        	newLeafNode(otherlv_4, grammarAccess.getMidiFilePartAccess().getRefPartKeyword_3_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:330:1: ( ( ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:331:1: ( ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:331:1: ( ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:332:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getMidiFilePartRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getRefPartMidiFilePartCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleMidiFilePart643);
                    ruleEString();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:345:4: (otherlv_6= '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* otherlv_10= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:345:6: otherlv_6= '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* otherlv_10= '}'
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleMidiFilePart658); 

                        	newLeafNode(otherlv_6, grammarAccess.getMidiFilePartAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:349:1: ( (lv_textlines_7_0= ruleMidiFileTextLine ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:350:1: (lv_textlines_7_0= ruleMidiFileTextLine )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:350:1: (lv_textlines_7_0= ruleMidiFileTextLine )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:351:3: lv_textlines_7_0= ruleMidiFileTextLine
                    {
                     
                    	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart679);
                    lv_textlines_7_0=ruleMidiFileTextLine();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
                    	        }
                           		add(
                           			current, 
                           			"textlines",
                            		lv_textlines_7_0, 
                            		"MidiFileTextLine");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:367:2: (otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==20) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:367:4: otherlv_8= ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) )
                    	    {
                    	    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleMidiFilePart692); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getMidiFilePartAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:371:1: ( (lv_textlines_9_0= ruleMidiFileTextLine ) )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:372:1: (lv_textlines_9_0= ruleMidiFileTextLine )
                    	    {
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:372:1: (lv_textlines_9_0= ruleMidiFileTextLine )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:373:3: lv_textlines_9_0= ruleMidiFileTextLine
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart713);
                    	    lv_textlines_9_0=ruleMidiFileTextLine();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"textlines",
                    	            		lv_textlines_9_0, 
                    	            		"MidiFileTextLine");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleMidiFilePart727); 

                        	newLeafNode(otherlv_10, grammarAccess.getMidiFilePartAccess().getRightCurlyBracketKeyword_4_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMidiFilePart"


    // $ANTLR start "entryRuleMidiFileTextLine"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:401:1: entryRuleMidiFileTextLine returns [EObject current=null] : iv_ruleMidiFileTextLine= ruleMidiFileTextLine EOF ;
    public final EObject entryRuleMidiFileTextLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFileTextLine = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:402:2: (iv_ruleMidiFileTextLine= ruleMidiFileTextLine EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:403:2: iv_ruleMidiFileTextLine= ruleMidiFileTextLine EOF
            {
             newCompositeNode(grammarAccess.getMidiFileTextLineRule()); 
            pushFollow(FOLLOW_ruleMidiFileTextLine_in_entryRuleMidiFileTextLine765);
            iv_ruleMidiFileTextLine=ruleMidiFileTextLine();

            state._fsp--;

             current =iv_ruleMidiFileTextLine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFileTextLine775); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMidiFileTextLine"


    // $ANTLR start "ruleMidiFileTextLine"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:410:1: ruleMidiFileTextLine returns [EObject current=null] : ( () (otherlv_1= '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleMidiFileTextLine() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_chordParts_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:413:28: ( ( () (otherlv_1= '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* otherlv_3= '}' )? ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:414:1: ( () (otherlv_1= '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* otherlv_3= '}' )? )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:414:1: ( () (otherlv_1= '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* otherlv_3= '}' )? )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:414:2: () (otherlv_1= '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* otherlv_3= '}' )?
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:414:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:415:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMidiFileTextLineAccess().getMidiFileTextLineAction_0(),
                        current);
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:420:2: (otherlv_1= '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* otherlv_3= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==16) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:420:4: otherlv_1= '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleMidiFileTextLine822); 

                        	newLeafNode(otherlv_1, grammarAccess.getMidiFileTextLineAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:424:1: ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)||LA12_0==22) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:425:1: (lv_chordParts_2_0= ruleMidiFileChordPart )
                    	    {
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:425:1: (lv_chordParts_2_0= ruleMidiFileChordPart )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:426:3: lv_chordParts_2_0= ruleMidiFileChordPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMidiFileTextLineAccess().getChordPartsMidiFileChordPartParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMidiFileChordPart_in_ruleMidiFileTextLine843);
                    	    lv_chordParts_2_0=ruleMidiFileChordPart();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMidiFileTextLineRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"chordParts",
                    	            		lv_chordParts_2_0, 
                    	            		"MidiFileChordPart");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleMidiFileTextLine856); 

                        	newLeafNode(otherlv_3, grammarAccess.getMidiFileTextLineAccess().getRightCurlyBracketKeyword_1_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMidiFileTextLine"


    // $ANTLR start "entryRuleEInt"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:454:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:455:2: (iv_ruleEInt= ruleEInt EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:456:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt895);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt906); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:463:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:466:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:467:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:467:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:467:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:467:2: (kw= '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:468:2: kw= '-'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleEInt945); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEInt962); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleMidiFileChordPart"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:488:1: entryRuleMidiFileChordPart returns [EObject current=null] : iv_ruleMidiFileChordPart= ruleMidiFileChordPart EOF ;
    public final EObject entryRuleMidiFileChordPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFileChordPart = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:489:2: (iv_ruleMidiFileChordPart= ruleMidiFileChordPart EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:490:2: iv_ruleMidiFileChordPart= ruleMidiFileChordPart EOF
            {
             newCompositeNode(grammarAccess.getMidiFileChordPartRule()); 
            pushFollow(FOLLOW_ruleMidiFileChordPart_in_entryRuleMidiFileChordPart1007);
            iv_ruleMidiFileChordPart=ruleMidiFileChordPart();

            state._fsp--;

             current =iv_ruleMidiFileChordPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMidiFileChordPart1017); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMidiFileChordPart"


    // $ANTLR start "ruleMidiFileChordPart"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:497:1: ruleMidiFileChordPart returns [EObject current=null] : ( () (otherlv_1= '(' ( (lv_chord_2_0= ruleEString ) ) otherlv_3= ')' )? ( (lv_text_4_0= ruleEString ) ) ) ;
    public final EObject ruleMidiFileChordPart() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_chord_2_0 = null;

        AntlrDatatypeRuleToken lv_text_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:500:28: ( ( () (otherlv_1= '(' ( (lv_chord_2_0= ruleEString ) ) otherlv_3= ')' )? ( (lv_text_4_0= ruleEString ) ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:501:1: ( () (otherlv_1= '(' ( (lv_chord_2_0= ruleEString ) ) otherlv_3= ')' )? ( (lv_text_4_0= ruleEString ) ) )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:501:1: ( () (otherlv_1= '(' ( (lv_chord_2_0= ruleEString ) ) otherlv_3= ')' )? ( (lv_text_4_0= ruleEString ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:501:2: () (otherlv_1= '(' ( (lv_chord_2_0= ruleEString ) ) otherlv_3= ')' )? ( (lv_text_4_0= ruleEString ) )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:501:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:502:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMidiFileChordPartAccess().getMidiFileChordPartAction_0(),
                        current);
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:507:2: (otherlv_1= '(' ( (lv_chord_2_0= ruleEString ) ) otherlv_3= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:507:4: otherlv_1= '(' ( (lv_chord_2_0= ruleEString ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleMidiFileChordPart1064); 

                        	newLeafNode(otherlv_1, grammarAccess.getMidiFileChordPartAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:511:1: ( (lv_chord_2_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:512:1: (lv_chord_2_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:512:1: (lv_chord_2_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:513:3: lv_chord_2_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getMidiFileChordPartAccess().getChordEStringParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleMidiFileChordPart1085);
                    lv_chord_2_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMidiFileChordPartRule());
                    	        }
                           		set(
                           			current, 
                           			"chord",
                            		lv_chord_2_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleMidiFileChordPart1097); 

                        	newLeafNode(otherlv_3, grammarAccess.getMidiFileChordPartAccess().getRightParenthesisKeyword_1_2());
                        

                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:533:3: ( (lv_text_4_0= ruleEString ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:534:1: (lv_text_4_0= ruleEString )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:534:1: (lv_text_4_0= ruleEString )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:535:3: lv_text_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getMidiFileChordPartAccess().getTextEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleMidiFileChordPart1120);
            lv_text_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMidiFileChordPartRule());
            	        }
                   		set(
                   			current, 
                   			"text",
                    		lv_text_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMidiFileChordPart"


    // $ANTLR start "ruleMidiFilePartType"
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:559:1: ruleMidiFilePartType returns [Enumerator current=null] : ( (enumLiteral_0= 'REFRAIN' ) | (enumLiteral_1= 'BRIDGE' ) | (enumLiteral_2= 'VERS' ) | (enumLiteral_3= 'SOLO' ) | (enumLiteral_4= 'ZWISCHENSPIEL' ) | (enumLiteral_5= 'INTRO' ) | (enumLiteral_6= 'EXTRO' ) ) ;
    public final Enumerator ruleMidiFilePartType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;

         enterRule(); 
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:561:28: ( ( (enumLiteral_0= 'REFRAIN' ) | (enumLiteral_1= 'BRIDGE' ) | (enumLiteral_2= 'VERS' ) | (enumLiteral_3= 'SOLO' ) | (enumLiteral_4= 'ZWISCHENSPIEL' ) | (enumLiteral_5= 'INTRO' ) | (enumLiteral_6= 'EXTRO' ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:562:1: ( (enumLiteral_0= 'REFRAIN' ) | (enumLiteral_1= 'BRIDGE' ) | (enumLiteral_2= 'VERS' ) | (enumLiteral_3= 'SOLO' ) | (enumLiteral_4= 'ZWISCHENSPIEL' ) | (enumLiteral_5= 'INTRO' ) | (enumLiteral_6= 'EXTRO' ) )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:562:1: ( (enumLiteral_0= 'REFRAIN' ) | (enumLiteral_1= 'BRIDGE' ) | (enumLiteral_2= 'VERS' ) | (enumLiteral_3= 'SOLO' ) | (enumLiteral_4= 'ZWISCHENSPIEL' ) | (enumLiteral_5= 'INTRO' ) | (enumLiteral_6= 'EXTRO' ) )
            int alt16=7;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt16=1;
                }
                break;
            case 25:
                {
                alt16=2;
                }
                break;
            case 26:
                {
                alt16=3;
                }
                break;
            case 27:
                {
                alt16=4;
                }
                break;
            case 28:
                {
                alt16=5;
                }
                break;
            case 29:
                {
                alt16=6;
                }
                break;
            case 30:
                {
                alt16=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:562:2: (enumLiteral_0= 'REFRAIN' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:562:2: (enumLiteral_0= 'REFRAIN' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:562:4: enumLiteral_0= 'REFRAIN'
                    {
                    enumLiteral_0=(Token)match(input,24,FOLLOW_24_in_ruleMidiFilePartType1170); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:568:6: (enumLiteral_1= 'BRIDGE' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:568:6: (enumLiteral_1= 'BRIDGE' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:568:8: enumLiteral_1= 'BRIDGE'
                    {
                    enumLiteral_1=(Token)match(input,25,FOLLOW_25_in_ruleMidiFilePartType1187); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:574:6: (enumLiteral_2= 'VERS' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:574:6: (enumLiteral_2= 'VERS' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:574:8: enumLiteral_2= 'VERS'
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_26_in_ruleMidiFilePartType1204); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:580:6: (enumLiteral_3= 'SOLO' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:580:6: (enumLiteral_3= 'SOLO' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:580:8: enumLiteral_3= 'SOLO'
                    {
                    enumLiteral_3=(Token)match(input,27,FOLLOW_27_in_ruleMidiFilePartType1221); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:586:6: (enumLiteral_4= 'ZWISCHENSPIEL' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:586:6: (enumLiteral_4= 'ZWISCHENSPIEL' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:586:8: enumLiteral_4= 'ZWISCHENSPIEL'
                    {
                    enumLiteral_4=(Token)match(input,28,FOLLOW_28_in_ruleMidiFilePartType1238); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:592:6: (enumLiteral_5= 'INTRO' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:592:6: (enumLiteral_5= 'INTRO' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:592:8: enumLiteral_5= 'INTRO'
                    {
                    enumLiteral_5=(Token)match(input,29,FOLLOW_29_in_ruleMidiFilePartType1255); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:598:6: (enumLiteral_6= 'EXTRO' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:598:6: (enumLiteral_6= 'EXTRO' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:598:8: enumLiteral_6= 'EXTRO'
                    {
                    enumLiteral_6=(Token)match(input,30,FOLLOW_30_in_ruleMidiFilePartType1272); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMidiFilePartType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMidiFile_in_entryRuleMidiFile75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFile85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleMidiFile132 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile153 = new BitSet(new long[]{0x000000000001F002L});
    public static final BitSet FOLLOW_12_in_ruleMidiFile167 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile188 = new BitSet(new long[]{0x000000000001E002L});
    public static final BitSet FOLLOW_13_in_ruleMidiFile203 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile224 = new BitSet(new long[]{0x000000000001C002L});
    public static final BitSet FOLLOW_14_in_ruleMidiFile239 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile260 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_15_in_ruleMidiFile275 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile296 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleMidiFile311 = new BitSet(new long[]{0x000000007F020000L});
    public static final BitSet FOLLOW_ruleMidiFilePart_in_ruleMidiFile332 = new BitSet(new long[]{0x000000007F020000L});
    public static final BitSet FOLLOW_17_in_ruleMidiFile345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEString435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEString461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFilePart_in_entryRuleMidiFilePart506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFilePart516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFilePartType_in_ruleMidiFilePart571 = new BitSet(new long[]{0x00000000000D0002L});
    public static final BitSet FOLLOW_18_in_ruleMidiFilePart584 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_ruleEInt_in_ruleMidiFilePart605 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_19_in_ruleMidiFilePart620 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFilePart643 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleMidiFilePart658 = new BitSet(new long[]{0x0000000000130000L});
    public static final BitSet FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart679 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_20_in_ruleMidiFilePart692 = new BitSet(new long[]{0x0000000000130000L});
    public static final BitSet FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart713 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_17_in_ruleMidiFilePart727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFileTextLine_in_entryRuleMidiFileTextLine765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFileTextLine775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMidiFileTextLine822 = new BitSet(new long[]{0x0000000000420030L});
    public static final BitSet FOLLOW_ruleMidiFileChordPart_in_ruleMidiFileTextLine843 = new BitSet(new long[]{0x0000000000420030L});
    public static final BitSet FOLLOW_17_in_ruleMidiFileTextLine856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleEInt945 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEInt962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMidiFileChordPart_in_entryRuleMidiFileChordPart1007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMidiFileChordPart1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleMidiFileChordPart1064 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFileChordPart1085 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleMidiFileChordPart1097 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleMidiFileChordPart1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleMidiFilePartType1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleMidiFilePartType1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleMidiFilePartType1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleMidiFilePartType1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleMidiFilePartType1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleMidiFilePartType1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleMidiFilePartType1272 = new BitSet(new long[]{0x0000000000000002L});

}