package org.mda.editor.xtext.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
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
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalMidiPlayerParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g"; }



     	private MidiPlayerGrammarAccess grammarAccess;
     	
        public InternalMidiPlayerParser(TokenStream input, IAstFactory factory, MidiPlayerGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MidiFile";	
       	}
       	
       	@Override
       	protected MidiPlayerGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleMidiFile
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:78:1: entryRuleMidiFile returns [EObject current=null] : iv_ruleMidiFile= ruleMidiFile EOF ;
    public final EObject entryRuleMidiFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFile = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:79:2: (iv_ruleMidiFile= ruleMidiFile EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:80:2: iv_ruleMidiFile= ruleMidiFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMidiFileRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMidiFile_in_entryRuleMidiFile75);
            iv_ruleMidiFile=ruleMidiFile();
            _fsp--;

             current =iv_ruleMidiFile; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMidiFile85); 

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
    // $ANTLR end entryRuleMidiFile


    // $ANTLR start ruleMidiFile
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:87:1: ruleMidiFile returns [EObject current=null] : ( () ( 'name' ( (lv_name_2_0= ruleEString ) ) ) ( 'path' ( (lv_path_4_0= ruleEString ) ) )? ( 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? ( 'pic' ( (lv_pic_8_0= ruleEString ) ) )? ( 'key' ( (lv_key_10_0= ruleEString ) ) )? ( '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* '}' )? ) ;
    public final EObject ruleMidiFile() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_path_4_0 = null;

        AntlrDatatypeRuleToken lv_fontsize_6_0 = null;

        AntlrDatatypeRuleToken lv_pic_8_0 = null;

        AntlrDatatypeRuleToken lv_key_10_0 = null;

        EObject lv_parts_12_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:92:6: ( ( () ( 'name' ( (lv_name_2_0= ruleEString ) ) ) ( 'path' ( (lv_path_4_0= ruleEString ) ) )? ( 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? ( 'pic' ( (lv_pic_8_0= ruleEString ) ) )? ( 'key' ( (lv_key_10_0= ruleEString ) ) )? ( '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* '}' )? ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:93:1: ( () ( 'name' ( (lv_name_2_0= ruleEString ) ) ) ( 'path' ( (lv_path_4_0= ruleEString ) ) )? ( 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? ( 'pic' ( (lv_pic_8_0= ruleEString ) ) )? ( 'key' ( (lv_key_10_0= ruleEString ) ) )? ( '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* '}' )? )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:93:1: ( () ( 'name' ( (lv_name_2_0= ruleEString ) ) ) ( 'path' ( (lv_path_4_0= ruleEString ) ) )? ( 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? ( 'pic' ( (lv_pic_8_0= ruleEString ) ) )? ( 'key' ( (lv_key_10_0= ruleEString ) ) )? ( '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* '}' )? )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:93:2: () ( 'name' ( (lv_name_2_0= ruleEString ) ) ) ( 'path' ( (lv_path_4_0= ruleEString ) ) )? ( 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )? ( 'pic' ( (lv_pic_8_0= ruleEString ) ) )? ( 'key' ( (lv_key_10_0= ruleEString ) ) )? ( '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* '}' )?
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:93:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:94:5: 
            {
             
                    temp=factory.create(grammarAccess.getMidiFileAccess().getMidiFileAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getMidiFileAccess().getMidiFileAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:104:2: ( 'name' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:104:4: 'name' ( (lv_name_2_0= ruleEString ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleMidiFile130); 

                    createLeafNode(grammarAccess.getMidiFileAccess().getNameKeyword_1_0(), null); 
                
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:108:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:109:1: (lv_name_2_0= ruleEString )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:109:1: (lv_name_2_0= ruleEString )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:110:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMidiFileAccess().getNameEStringParserRuleCall_1_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFile151);
            lv_name_2_0=ruleEString();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMidiFileRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"EString", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:132:3: ( 'path' ( (lv_path_4_0= ruleEString ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:132:5: 'path' ( (lv_path_4_0= ruleEString ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleMidiFile163); 

                            createLeafNode(grammarAccess.getMidiFileAccess().getPathKeyword_2_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:136:1: ( (lv_path_4_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:137:1: (lv_path_4_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:137:1: (lv_path_4_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:138:3: lv_path_4_0= ruleEString
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFileAccess().getPathEStringParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFile184);
                    lv_path_4_0=ruleEString();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFileRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"path",
                    	        		lv_path_4_0, 
                    	        		"EString", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:160:4: ( 'fontsize' ( (lv_fontsize_6_0= ruleEString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:160:6: 'fontsize' ( (lv_fontsize_6_0= ruleEString ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleMidiFile197); 

                            createLeafNode(grammarAccess.getMidiFileAccess().getFontsizeKeyword_3_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:164:1: ( (lv_fontsize_6_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:165:1: (lv_fontsize_6_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:165:1: (lv_fontsize_6_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:166:3: lv_fontsize_6_0= ruleEString
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFileAccess().getFontsizeEStringParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFile218);
                    lv_fontsize_6_0=ruleEString();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFileRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"fontsize",
                    	        		lv_fontsize_6_0, 
                    	        		"EString", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:188:4: ( 'pic' ( (lv_pic_8_0= ruleEString ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:188:6: 'pic' ( (lv_pic_8_0= ruleEString ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleMidiFile231); 

                            createLeafNode(grammarAccess.getMidiFileAccess().getPicKeyword_4_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:192:1: ( (lv_pic_8_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:193:1: (lv_pic_8_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:193:1: (lv_pic_8_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:194:3: lv_pic_8_0= ruleEString
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFileAccess().getPicEStringParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFile252);
                    lv_pic_8_0=ruleEString();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFileRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"pic",
                    	        		lv_pic_8_0, 
                    	        		"EString", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:216:4: ( 'key' ( (lv_key_10_0= ruleEString ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:216:6: 'key' ( (lv_key_10_0= ruleEString ) )
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleMidiFile265); 

                            createLeafNode(grammarAccess.getMidiFileAccess().getKeyKeyword_5_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:220:1: ( (lv_key_10_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:221:1: (lv_key_10_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:221:1: (lv_key_10_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:222:3: lv_key_10_0= ruleEString
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFileAccess().getKeyEStringParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFile286);
                    lv_key_10_0=ruleEString();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFileRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"key",
                    	        		lv_key_10_0, 
                    	        		"EString", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:244:4: ( '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:244:6: '{' ( (lv_parts_12_0= ruleMidiFilePart ) )* '}'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleMidiFile299); 

                            createLeafNode(grammarAccess.getMidiFileAccess().getLeftCurlyBracketKeyword_6_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:248:1: ( (lv_parts_12_0= ruleMidiFilePart ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=24 && LA5_0<=30)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:249:1: (lv_parts_12_0= ruleMidiFilePart )
                    	    {
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:249:1: (lv_parts_12_0= ruleMidiFilePart )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:250:3: lv_parts_12_0= ruleMidiFilePart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMidiFileAccess().getPartsMidiFilePartParserRuleCall_6_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMidiFilePart_in_ruleMidiFile320);
                    	    lv_parts_12_0=ruleMidiFilePart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMidiFileRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"parts",
                    	    	        		lv_parts_12_0, 
                    	    	        		"MidiFilePart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match(input,17,FollowSets000.FOLLOW_17_in_ruleMidiFile331); 

                            createLeafNode(grammarAccess.getMidiFileAccess().getRightCurlyBracketKeyword_6_2(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMidiFile


    // $ANTLR start entryRuleEString
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:284:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:285:2: (iv_ruleEString= ruleEString EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:286:2: iv_ruleEString= ruleEString EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEStringRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString370);
            iv_ruleEString=ruleEString();
            _fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString381); 

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
    // $ANTLR end entryRuleEString


    // $ANTLR start ruleEString
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:293:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:298:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:299:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:299:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    new NoViableAltException("299:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:299:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString421); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:307:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString447); 

                    		current.merge(this_ID_1);
                        
                     
                        createLeafNode(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEString


    // $ANTLR start entryRuleMidiFilePart
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:322:1: entryRuleMidiFilePart returns [EObject current=null] : iv_ruleMidiFilePart= ruleMidiFilePart EOF ;
    public final EObject entryRuleMidiFilePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFilePart = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:323:2: (iv_ruleMidiFilePart= ruleMidiFilePart EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:324:2: iv_ruleMidiFilePart= ruleMidiFilePart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMidiFilePartRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMidiFilePart_in_entryRuleMidiFilePart492);
            iv_ruleMidiFilePart=ruleMidiFilePart();
            _fsp--;

             current =iv_ruleMidiFilePart; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMidiFilePart502); 

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
    // $ANTLR end entryRuleMidiFilePart


    // $ANTLR start ruleMidiFilePart
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:331:1: ruleMidiFilePart returns [EObject current=null] : ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) ( 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? ( 'refPart' ( ( ruleEString ) ) )? ( '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* '}' )? ) ;
    public final EObject ruleMidiFilePart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_parttype_1_0 = null;

        AntlrDatatypeRuleToken lv_bar_3_0 = null;

        EObject lv_textlines_7_0 = null;

        EObject lv_textlines_9_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:336:6: ( ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) ( 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? ( 'refPart' ( ( ruleEString ) ) )? ( '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* '}' )? ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:337:1: ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) ( 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? ( 'refPart' ( ( ruleEString ) ) )? ( '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* '}' )? )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:337:1: ( () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) ( 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? ( 'refPart' ( ( ruleEString ) ) )? ( '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* '}' )? )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:337:2: () ( (lv_parttype_1_0= ruleMidiFilePartType ) ) ( 'bar' ( (lv_bar_3_0= ruleEInt ) ) )? ( 'refPart' ( ( ruleEString ) ) )? ( '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* '}' )?
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:337:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:338:5: 
            {
             
                    temp=factory.create(grammarAccess.getMidiFilePartAccess().getMidiFilePartAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getMidiFilePartAccess().getMidiFilePartAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:348:2: ( (lv_parttype_1_0= ruleMidiFilePartType ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:349:1: (lv_parttype_1_0= ruleMidiFilePartType )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:349:1: (lv_parttype_1_0= ruleMidiFilePartType )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:350:3: lv_parttype_1_0= ruleMidiFilePartType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMidiFilePartAccess().getParttypeMidiFilePartTypeEnumRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMidiFilePartType_in_ruleMidiFilePart557);
            lv_parttype_1_0=ruleMidiFilePartType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMidiFilePartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"parttype",
            	        		lv_parttype_1_0, 
            	        		"MidiFilePartType", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:372:2: ( 'bar' ( (lv_bar_3_0= ruleEInt ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:372:4: 'bar' ( (lv_bar_3_0= ruleEInt ) )
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleMidiFilePart568); 

                            createLeafNode(grammarAccess.getMidiFilePartAccess().getBarKeyword_2_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:376:1: ( (lv_bar_3_0= ruleEInt ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:377:1: (lv_bar_3_0= ruleEInt )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:377:1: (lv_bar_3_0= ruleEInt )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:378:3: lv_bar_3_0= ruleEInt
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFilePartAccess().getBarEIntParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleMidiFilePart589);
                    lv_bar_3_0=ruleEInt();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFilePartRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"bar",
                    	        		lv_bar_3_0, 
                    	        		"EInt", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:400:4: ( 'refPart' ( ( ruleEString ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:400:6: 'refPart' ( ( ruleEString ) )
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleMidiFilePart602); 

                            createLeafNode(grammarAccess.getMidiFilePartAccess().getRefPartKeyword_3_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:404:1: ( ( ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:405:1: ( ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:405:1: ( ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:406:3: ruleEString
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFilePartRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFilePartAccess().getRefPartMidiFilePartCrossReference_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFilePart625);
                    ruleEString();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:420:4: ( '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:420:6: '{' ( (lv_textlines_7_0= ruleMidiFileTextLine ) ) ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )* '}'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleMidiFilePart638); 

                            createLeafNode(grammarAccess.getMidiFilePartAccess().getLeftCurlyBracketKeyword_4_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:424:1: ( (lv_textlines_7_0= ruleMidiFileTextLine ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:425:1: (lv_textlines_7_0= ruleMidiFileTextLine )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:425:1: (lv_textlines_7_0= ruleMidiFileTextLine )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:426:3: lv_textlines_7_0= ruleMidiFileTextLine
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart659);
                    lv_textlines_7_0=ruleMidiFileTextLine();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFilePartRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"textlines",
                    	        		lv_textlines_7_0, 
                    	        		"MidiFileTextLine", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:448:2: ( ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==20) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:448:4: ',' ( (lv_textlines_9_0= ruleMidiFileTextLine ) )
                    	    {
                    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleMidiFilePart670); 

                    	            createLeafNode(grammarAccess.getMidiFilePartAccess().getCommaKeyword_4_2_0(), null); 
                    	        
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:452:1: ( (lv_textlines_9_0= ruleMidiFileTextLine ) )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:453:1: (lv_textlines_9_0= ruleMidiFileTextLine )
                    	    {
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:453:1: (lv_textlines_9_0= ruleMidiFileTextLine )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:454:3: lv_textlines_9_0= ruleMidiFileTextLine
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart691);
                    	    lv_textlines_9_0=ruleMidiFileTextLine();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMidiFilePartRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"textlines",
                    	    	        		lv_textlines_9_0, 
                    	    	        		"MidiFileTextLine", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match(input,17,FollowSets000.FOLLOW_17_in_ruleMidiFilePart703); 

                            createLeafNode(grammarAccess.getMidiFilePartAccess().getRightCurlyBracketKeyword_4_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMidiFilePart


    // $ANTLR start entryRuleMidiFileTextLine
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:488:1: entryRuleMidiFileTextLine returns [EObject current=null] : iv_ruleMidiFileTextLine= ruleMidiFileTextLine EOF ;
    public final EObject entryRuleMidiFileTextLine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFileTextLine = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:489:2: (iv_ruleMidiFileTextLine= ruleMidiFileTextLine EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:490:2: iv_ruleMidiFileTextLine= ruleMidiFileTextLine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMidiFileTextLineRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMidiFileTextLine_in_entryRuleMidiFileTextLine741);
            iv_ruleMidiFileTextLine=ruleMidiFileTextLine();
            _fsp--;

             current =iv_ruleMidiFileTextLine; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMidiFileTextLine751); 

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
    // $ANTLR end entryRuleMidiFileTextLine


    // $ANTLR start ruleMidiFileTextLine
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:497:1: ruleMidiFileTextLine returns [EObject current=null] : ( () ( '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* '}' )? ) ;
    public final EObject ruleMidiFileTextLine() throws RecognitionException {
        EObject current = null;

        EObject lv_chordParts_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:502:6: ( ( () ( '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* '}' )? ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:503:1: ( () ( '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* '}' )? )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:503:1: ( () ( '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* '}' )? )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:503:2: () ( '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* '}' )?
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:503:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:504:5: 
            {
             
                    temp=factory.create(grammarAccess.getMidiFileTextLineAccess().getMidiFileTextLineAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getMidiFileTextLineAccess().getMidiFileTextLineAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:514:2: ( '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==16) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:514:4: '{' ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )* '}'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleMidiFileTextLine796); 

                            createLeafNode(grammarAccess.getMidiFileTextLineAccess().getLeftCurlyBracketKeyword_1_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:518:1: ( (lv_chordParts_2_0= ruleMidiFileChordPart ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)||LA12_0==22) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:519:1: (lv_chordParts_2_0= ruleMidiFileChordPart )
                    	    {
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:519:1: (lv_chordParts_2_0= ruleMidiFileChordPart )
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:520:3: lv_chordParts_2_0= ruleMidiFileChordPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMidiFileTextLineAccess().getChordPartsMidiFileChordPartParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMidiFileChordPart_in_ruleMidiFileTextLine817);
                    	    lv_chordParts_2_0=ruleMidiFileChordPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMidiFileTextLineRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"chordParts",
                    	    	        		lv_chordParts_2_0, 
                    	    	        		"MidiFileChordPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match(input,17,FollowSets000.FOLLOW_17_in_ruleMidiFileTextLine828); 

                            createLeafNode(grammarAccess.getMidiFileTextLineAccess().getRightCurlyBracketKeyword_1_2(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMidiFileTextLine


    // $ANTLR start entryRuleEInt
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:554:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:555:2: (iv_ruleEInt= ruleEInt EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:556:2: iv_ruleEInt= ruleEInt EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEIntRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt867);
            iv_ruleEInt=ruleEInt();
            _fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt878); 

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
    // $ANTLR end entryRuleEInt


    // $ANTLR start ruleEInt
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:563:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:568:6: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:569:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:569:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:569:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:569:2: (kw= '-' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:570:2: kw= '-'
                    {
                    kw=(Token)input.LT(1);
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleEInt917); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0(), null); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt934); 

            		current.merge(this_INT_1);
                
             
                createLeafNode(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEInt


    // $ANTLR start entryRuleMidiFileChordPart
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:590:1: entryRuleMidiFileChordPart returns [EObject current=null] : iv_ruleMidiFileChordPart= ruleMidiFileChordPart EOF ;
    public final EObject entryRuleMidiFileChordPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMidiFileChordPart = null;


        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:591:2: (iv_ruleMidiFileChordPart= ruleMidiFileChordPart EOF )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:592:2: iv_ruleMidiFileChordPart= ruleMidiFileChordPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMidiFileChordPartRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMidiFileChordPart_in_entryRuleMidiFileChordPart979);
            iv_ruleMidiFileChordPart=ruleMidiFileChordPart();
            _fsp--;

             current =iv_ruleMidiFileChordPart; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMidiFileChordPart989); 

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
    // $ANTLR end entryRuleMidiFileChordPart


    // $ANTLR start ruleMidiFileChordPart
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:599:1: ruleMidiFileChordPart returns [EObject current=null] : ( () ( '(' ( (lv_chord_2_0= ruleEString ) ) ')' )? ( (lv_text_4_0= ruleEString ) ) ) ;
    public final EObject ruleMidiFileChordPart() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_chord_2_0 = null;

        AntlrDatatypeRuleToken lv_text_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:604:6: ( ( () ( '(' ( (lv_chord_2_0= ruleEString ) ) ')' )? ( (lv_text_4_0= ruleEString ) ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:605:1: ( () ( '(' ( (lv_chord_2_0= ruleEString ) ) ')' )? ( (lv_text_4_0= ruleEString ) ) )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:605:1: ( () ( '(' ( (lv_chord_2_0= ruleEString ) ) ')' )? ( (lv_text_4_0= ruleEString ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:605:2: () ( '(' ( (lv_chord_2_0= ruleEString ) ) ')' )? ( (lv_text_4_0= ruleEString ) )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:605:2: ()
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:606:5: 
            {
             
                    temp=factory.create(grammarAccess.getMidiFileChordPartAccess().getMidiFileChordPartAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getMidiFileChordPartAccess().getMidiFileChordPartAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:616:2: ( '(' ( (lv_chord_2_0= ruleEString ) ) ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:616:4: '(' ( (lv_chord_2_0= ruleEString ) ) ')'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleMidiFileChordPart1034); 

                            createLeafNode(grammarAccess.getMidiFileChordPartAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:620:1: ( (lv_chord_2_0= ruleEString ) )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:621:1: (lv_chord_2_0= ruleEString )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:621:1: (lv_chord_2_0= ruleEString )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:622:3: lv_chord_2_0= ruleEString
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMidiFileChordPartAccess().getChordEStringParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFileChordPart1055);
                    lv_chord_2_0=ruleEString();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMidiFileChordPartRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"chord",
                    	        		lv_chord_2_0, 
                    	        		"EString", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleMidiFileChordPart1065); 

                            createLeafNode(grammarAccess.getMidiFileChordPartAccess().getRightParenthesisKeyword_1_2(), null); 
                        

                    }
                    break;

            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:648:3: ( (lv_text_4_0= ruleEString ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:649:1: (lv_text_4_0= ruleEString )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:649:1: (lv_text_4_0= ruleEString )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:650:3: lv_text_4_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMidiFileChordPartAccess().getTextEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleMidiFileChordPart1088);
            lv_text_4_0=ruleEString();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMidiFileChordPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"text",
            	        		lv_text_4_0, 
            	        		"EString", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMidiFileChordPart


    // $ANTLR start ruleMidiFilePartType
    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:680:1: ruleMidiFilePartType returns [Enumerator current=null] : ( ( 'REFRAIN' ) | ( 'BRIDGE' ) | ( 'VERS' ) | ( 'SOLO' ) | ( 'ZWISCHENSPIEL' ) | ( 'INTRO' ) | ( 'EXTRO' ) ) ;
    public final Enumerator ruleMidiFilePartType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:684:6: ( ( ( 'REFRAIN' ) | ( 'BRIDGE' ) | ( 'VERS' ) | ( 'SOLO' ) | ( 'ZWISCHENSPIEL' ) | ( 'INTRO' ) | ( 'EXTRO' ) ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:685:1: ( ( 'REFRAIN' ) | ( 'BRIDGE' ) | ( 'VERS' ) | ( 'SOLO' ) | ( 'ZWISCHENSPIEL' ) | ( 'INTRO' ) | ( 'EXTRO' ) )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:685:1: ( ( 'REFRAIN' ) | ( 'BRIDGE' ) | ( 'VERS' ) | ( 'SOLO' ) | ( 'ZWISCHENSPIEL' ) | ( 'INTRO' ) | ( 'EXTRO' ) )
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
                    new NoViableAltException("685:1: ( ( 'REFRAIN' ) | ( 'BRIDGE' ) | ( 'VERS' ) | ( 'SOLO' ) | ( 'ZWISCHENSPIEL' ) | ( 'INTRO' ) | ( 'EXTRO' ) )", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:685:2: ( 'REFRAIN' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:685:2: ( 'REFRAIN' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:685:4: 'REFRAIN'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleMidiFilePartType1136); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:691:6: ( 'BRIDGE' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:691:6: ( 'BRIDGE' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:691:8: 'BRIDGE'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleMidiFilePartType1151); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:697:6: ( 'VERS' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:697:6: ( 'VERS' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:697:8: 'VERS'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_ruleMidiFilePartType1166); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:703:6: ( 'SOLO' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:703:6: ( 'SOLO' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:703:8: 'SOLO'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_ruleMidiFilePartType1181); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:709:6: ( 'ZWISCHENSPIEL' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:709:6: ( 'ZWISCHENSPIEL' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:709:8: 'ZWISCHENSPIEL'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_ruleMidiFilePartType1196); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:715:6: ( 'INTRO' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:715:6: ( 'INTRO' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:715:8: 'INTRO'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_ruleMidiFilePartType1211); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:721:6: ( 'EXTRO' )
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:721:6: ( 'EXTRO' )
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:721:8: 'EXTRO'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_ruleMidiFilePartType1226); 

                            current = grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMidiFilePartType


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMidiFile_in_entryRuleMidiFile75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMidiFile85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleMidiFile130 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile151 = new BitSet(new long[]{0x000000000001F002L});
        public static final BitSet FOLLOW_12_in_ruleMidiFile163 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile184 = new BitSet(new long[]{0x000000000001E002L});
        public static final BitSet FOLLOW_13_in_ruleMidiFile197 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile218 = new BitSet(new long[]{0x000000000001C002L});
        public static final BitSet FOLLOW_14_in_ruleMidiFile231 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile252 = new BitSet(new long[]{0x0000000000018002L});
        public static final BitSet FOLLOW_15_in_ruleMidiFile265 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFile286 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleMidiFile299 = new BitSet(new long[]{0x000000007F020000L});
        public static final BitSet FOLLOW_ruleMidiFilePart_in_ruleMidiFile320 = new BitSet(new long[]{0x000000007F020000L});
        public static final BitSet FOLLOW_17_in_ruleMidiFile331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString370 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString421 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMidiFilePart_in_entryRuleMidiFilePart492 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMidiFilePart502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMidiFilePartType_in_ruleMidiFilePart557 = new BitSet(new long[]{0x00000000000D0002L});
        public static final BitSet FOLLOW_18_in_ruleMidiFilePart568 = new BitSet(new long[]{0x0000000000200040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleMidiFilePart589 = new BitSet(new long[]{0x0000000000090002L});
        public static final BitSet FOLLOW_19_in_ruleMidiFilePart602 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFilePart625 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleMidiFilePart638 = new BitSet(new long[]{0x0000000000130000L});
        public static final BitSet FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart659 = new BitSet(new long[]{0x0000000000120000L});
        public static final BitSet FOLLOW_20_in_ruleMidiFilePart670 = new BitSet(new long[]{0x0000000000130000L});
        public static final BitSet FOLLOW_ruleMidiFileTextLine_in_ruleMidiFilePart691 = new BitSet(new long[]{0x0000000000120000L});
        public static final BitSet FOLLOW_17_in_ruleMidiFilePart703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMidiFileTextLine_in_entryRuleMidiFileTextLine741 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMidiFileTextLine751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMidiFileTextLine796 = new BitSet(new long[]{0x0000000000420030L});
        public static final BitSet FOLLOW_ruleMidiFileChordPart_in_ruleMidiFileTextLine817 = new BitSet(new long[]{0x0000000000420030L});
        public static final BitSet FOLLOW_17_in_ruleMidiFileTextLine828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleEInt917 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMidiFileChordPart_in_entryRuleMidiFileChordPart979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMidiFileChordPart989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMidiFileChordPart1034 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFileChordPart1055 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleMidiFileChordPart1065 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleMidiFileChordPart1088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleMidiFilePartType1136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleMidiFilePartType1151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleMidiFilePartType1166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleMidiFilePartType1181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleMidiFilePartType1196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleMidiFilePartType1211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleMidiFilePartType1226 = new BitSet(new long[]{0x0000000000000002L});
    }


}