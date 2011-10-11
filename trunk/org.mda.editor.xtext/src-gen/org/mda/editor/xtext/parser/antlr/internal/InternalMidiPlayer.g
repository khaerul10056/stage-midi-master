/*
* generated by Xtext
*/
grammar InternalMidiPlayer;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.mda.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

}

@parser::members {

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
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleMidiFile
entryRuleMidiFile returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMidiFileRule()); }
	 iv_ruleMidiFile=ruleMidiFile 
	 { $current=$iv_ruleMidiFile.current; } 
	 EOF 
;

// Rule MidiFile
ruleMidiFile returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getMidiFileAccess().getMidiFileAction_0(),
            $current);
    }
)(	otherlv_1='name' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMidiFileAccess().getNameKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileAccess().getNameEStringParserRuleCall_1_1_0()); 
	    }
		lv_name_2_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
))(	otherlv_3='path' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMidiFileAccess().getPathKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileAccess().getPathEStringParserRuleCall_2_1_0()); 
	    }
		lv_path_4_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileRule());
	        }
       		set(
       			$current, 
       			"path",
        		lv_path_4_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_5='fontsize' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMidiFileAccess().getFontsizeKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileAccess().getFontsizeEStringParserRuleCall_3_1_0()); 
	    }
		lv_fontsize_6_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileRule());
	        }
       		set(
       			$current, 
       			"fontsize",
        		lv_fontsize_6_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_7='pic' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getMidiFileAccess().getPicKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileAccess().getPicEStringParserRuleCall_4_1_0()); 
	    }
		lv_pic_8_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileRule());
	        }
       		set(
       			$current, 
       			"pic",
        		lv_pic_8_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_9='key' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getMidiFileAccess().getKeyKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileAccess().getKeyEStringParserRuleCall_5_1_0()); 
	    }
		lv_key_10_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileRule());
	        }
       		set(
       			$current, 
       			"key",
        		lv_key_10_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_11='{' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getMidiFileAccess().getLeftCurlyBracketKeyword_6_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileAccess().getPartsMidiFilePartParserRuleCall_6_1_0()); 
	    }
		lv_parts_12_0=ruleMidiFilePart		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileRule());
	        }
       		add(
       			$current, 
       			"parts",
        		lv_parts_12_0, 
        		"MidiFilePart");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_13='}' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getMidiFileAccess().getRightCurlyBracketKeyword_6_2());
    }
)?)
;





// Entry rule entryRuleEString
entryRuleEString returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEStringRule()); } 
	 iv_ruleEString=ruleEString 
	 { $current=$iv_ruleEString.current.getText(); }  
	 EOF 
;

// Rule EString
ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_STRING_0=RULE_STRING    {
		$current.merge(this_STRING_0);
    }

    { 
    newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
    }

    |    this_ID_1=RULE_ID    {
		$current.merge(this_ID_1);
    }

    { 
    newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleMidiFilePart
entryRuleMidiFilePart returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMidiFilePartRule()); }
	 iv_ruleMidiFilePart=ruleMidiFilePart 
	 { $current=$iv_ruleMidiFilePart.current; } 
	 EOF 
;

// Rule MidiFilePart
ruleMidiFilePart returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getMidiFilePartAccess().getMidiFilePartAction_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getParttypeMidiFilePartTypeEnumRuleCall_1_0()); 
	    }
		lv_parttype_1_0=ruleMidiFilePartType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
	        }
       		set(
       			$current, 
       			"parttype",
        		lv_parttype_1_0, 
        		"MidiFilePartType");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_2='bar' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMidiFilePartAccess().getBarKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getBarEIntParserRuleCall_2_1_0()); 
	    }
		lv_bar_3_0=ruleEInt		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
	        }
       		set(
       			$current, 
       			"bar",
        		lv_bar_3_0, 
        		"EInt");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_4='refPart' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMidiFilePartAccess().getRefPartKeyword_3_0());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getMidiFilePartRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getRefPartMidiFilePartCrossReference_3_1_0()); 
	    }
		ruleEString		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_6='{' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMidiFilePartAccess().getLeftCurlyBracketKeyword_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_1_0()); 
	    }
		lv_textlines_7_0=ruleMidiFileTextLine		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
	        }
       		add(
       			$current, 
       			"textlines",
        		lv_textlines_7_0, 
        		"MidiFileTextLine");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_8=',' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getMidiFilePartAccess().getCommaKeyword_4_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFilePartAccess().getTextlinesMidiFileTextLineParserRuleCall_4_2_1_0()); 
	    }
		lv_textlines_9_0=ruleMidiFileTextLine		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFilePartRule());
	        }
       		add(
       			$current, 
       			"textlines",
        		lv_textlines_9_0, 
        		"MidiFileTextLine");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getMidiFilePartAccess().getRightCurlyBracketKeyword_4_3());
    }
)?)
;





// Entry rule entryRuleMidiFileTextLine
entryRuleMidiFileTextLine returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMidiFileTextLineRule()); }
	 iv_ruleMidiFileTextLine=ruleMidiFileTextLine 
	 { $current=$iv_ruleMidiFileTextLine.current; } 
	 EOF 
;

// Rule MidiFileTextLine
ruleMidiFileTextLine returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getMidiFileTextLineAccess().getMidiFileTextLineAction_0(),
            $current);
    }
)(	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMidiFileTextLineAccess().getLeftCurlyBracketKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileTextLineAccess().getChordPartsMidiFileChordPartParserRuleCall_1_1_0()); 
	    }
		lv_chordParts_2_0=ruleMidiFileChordPart		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileTextLineRule());
	        }
       		add(
       			$current, 
       			"chordParts",
        		lv_chordParts_2_0, 
        		"MidiFileChordPart");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_3='}' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMidiFileTextLineAccess().getRightCurlyBracketKeyword_1_2());
    }
)?)
;





// Entry rule entryRuleEInt
entryRuleEInt returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEIntRule()); } 
	 iv_ruleEInt=ruleEInt 
	 { $current=$iv_ruleEInt.current.getText(); }  
	 EOF 
;

// Rule EInt
ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
    }
)?    this_INT_1=RULE_INT    {
		$current.merge(this_INT_1);
    }

    { 
    newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
    }
)
    ;





// Entry rule entryRuleMidiFileChordPart
entryRuleMidiFileChordPart returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMidiFileChordPartRule()); }
	 iv_ruleMidiFileChordPart=ruleMidiFileChordPart 
	 { $current=$iv_ruleMidiFileChordPart.current; } 
	 EOF 
;

// Rule MidiFileChordPart
ruleMidiFileChordPart returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getMidiFileChordPartAccess().getMidiFileChordPartAction_0(),
            $current);
    }
)(	otherlv_1='(' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMidiFileChordPartAccess().getLeftParenthesisKeyword_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileChordPartAccess().getChordEStringParserRuleCall_1_1_0()); 
	    }
		lv_chord_2_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileChordPartRule());
	        }
       		set(
       			$current, 
       			"chord",
        		lv_chord_2_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=')' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getMidiFileChordPartAccess().getRightParenthesisKeyword_1_2());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getMidiFileChordPartAccess().getTextEStringParserRuleCall_2_0()); 
	    }
		lv_text_4_0=ruleEString		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMidiFileChordPartRule());
	        }
       		set(
       			$current, 
       			"text",
        		lv_text_4_0, 
        		"EString");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Rule MidiFilePartType
ruleMidiFilePartType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='REFRAIN' 
	{
        $current = grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getMidiFilePartTypeAccess().getREFRAINEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='BRIDGE' 
	{
        $current = grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getMidiFilePartTypeAccess().getBRIDGEEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='VERS' 
	{
        $current = grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getMidiFilePartTypeAccess().getVERSEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='SOLO' 
	{
        $current = grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getMidiFilePartTypeAccess().getSOLOEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='ZWISCHENSPIEL' 
	{
        $current = grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getMidiFilePartTypeAccess().getZWISCHENSPIELEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='INTRO' 
	{
        $current = grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getMidiFilePartTypeAccess().getINTROEnumLiteralDeclaration_5()); 
    }
)
    |(	enumLiteral_6='EXTRO' 
	{
        $current = grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getMidiFilePartTypeAccess().getEXTROEnumLiteralDeclaration_6()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


