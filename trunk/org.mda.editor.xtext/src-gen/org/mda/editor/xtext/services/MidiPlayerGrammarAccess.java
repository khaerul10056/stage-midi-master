/*
* generated by Xtext
*/

package org.mda.editor.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class MidiPlayerGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class MidiFileElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MidiFile");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMidiFileAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cNameKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cNameAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cNameEStringParserRuleCall_1_1_0 = (RuleCall)cNameAssignment_1_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cPathKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cPathAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cPathEStringParserRuleCall_2_1_0 = (RuleCall)cPathAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFontsizeKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cFontsizeAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cFontsizeEStringParserRuleCall_3_1_0 = (RuleCall)cFontsizeAssignment_3_1.eContents().get(0);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cPicKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cPicAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cPicEStringParserRuleCall_4_1_0 = (RuleCall)cPicAssignment_4_1.eContents().get(0);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cKeyKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cKeyAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cKeyEStringParserRuleCall_5_1_0 = (RuleCall)cKeyAssignment_5_1.eContents().get(0);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Keyword cLeftCurlyBracketKeyword_6_0 = (Keyword)cGroup_6.eContents().get(0);
		private final Assignment cPartsAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cPartsMidiFilePartParserRuleCall_6_1_0 = (RuleCall)cPartsAssignment_6_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6_2 = (Keyword)cGroup_6.eContents().get(2);
		
		//MidiFile:
		//	{MidiFile} ("name" name=EString) ("path" path=EString)? ("fontsize" fontsize=EString)? ("pic" pic=EString)? ("key"
		//	key=EString)? ("{" parts+=MidiFilePart* "}")?;
		public ParserRule getRule() { return rule; }

		//{MidiFile} ("name" name=EString) ("path" path=EString)? ("fontsize" fontsize=EString)? ("pic" pic=EString)? ("key"
		//key=EString)? ("{" parts+=MidiFilePart* "}")?
		public Group getGroup() { return cGroup; }

		//{MidiFile}
		public Action getMidiFileAction_0() { return cMidiFileAction_0; }

		//"name" name=EString
		public Group getGroup_1() { return cGroup_1; }

		//"name"
		public Keyword getNameKeyword_1_0() { return cNameKeyword_1_0; }

		//name=EString
		public Assignment getNameAssignment_1_1() { return cNameAssignment_1_1; }

		//EString
		public RuleCall getNameEStringParserRuleCall_1_1_0() { return cNameEStringParserRuleCall_1_1_0; }

		//("path" path=EString)?
		public Group getGroup_2() { return cGroup_2; }

		//"path"
		public Keyword getPathKeyword_2_0() { return cPathKeyword_2_0; }

		//path=EString
		public Assignment getPathAssignment_2_1() { return cPathAssignment_2_1; }

		//EString
		public RuleCall getPathEStringParserRuleCall_2_1_0() { return cPathEStringParserRuleCall_2_1_0; }

		//("fontsize" fontsize=EString)?
		public Group getGroup_3() { return cGroup_3; }

		//"fontsize"
		public Keyword getFontsizeKeyword_3_0() { return cFontsizeKeyword_3_0; }

		//fontsize=EString
		public Assignment getFontsizeAssignment_3_1() { return cFontsizeAssignment_3_1; }

		//EString
		public RuleCall getFontsizeEStringParserRuleCall_3_1_0() { return cFontsizeEStringParserRuleCall_3_1_0; }

		//("pic" pic=EString)?
		public Group getGroup_4() { return cGroup_4; }

		//"pic"
		public Keyword getPicKeyword_4_0() { return cPicKeyword_4_0; }

		//pic=EString
		public Assignment getPicAssignment_4_1() { return cPicAssignment_4_1; }

		//EString
		public RuleCall getPicEStringParserRuleCall_4_1_0() { return cPicEStringParserRuleCall_4_1_0; }

		//("key" key=EString)?
		public Group getGroup_5() { return cGroup_5; }

		//"key"
		public Keyword getKeyKeyword_5_0() { return cKeyKeyword_5_0; }

		//key=EString
		public Assignment getKeyAssignment_5_1() { return cKeyAssignment_5_1; }

		//EString
		public RuleCall getKeyEStringParserRuleCall_5_1_0() { return cKeyEStringParserRuleCall_5_1_0; }

		//("{" parts+=MidiFilePart* "}")?
		public Group getGroup_6() { return cGroup_6; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_6_0() { return cLeftCurlyBracketKeyword_6_0; }

		//parts+=MidiFilePart*
		public Assignment getPartsAssignment_6_1() { return cPartsAssignment_6_1; }

		//MidiFilePart
		public RuleCall getPartsMidiFilePartParserRuleCall_6_1_0() { return cPartsMidiFilePartParserRuleCall_6_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6_2() { return cRightCurlyBracketKeyword_6_2; }
	}

	public class EStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EString");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EString returns ecore::EString:
		//	STRING | ID;
		public ParserRule getRule() { return rule; }

		//STRING | ID
		public Alternatives getAlternatives() { return cAlternatives; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0() { return cSTRINGTerminalRuleCall_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
	}

	public class MidiFilePartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MidiFilePart");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMidiFilePartAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cParttypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cParttypeMidiFilePartTypeEnumRuleCall_1_0 = (RuleCall)cParttypeAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cBarKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cBarAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cBarEIntParserRuleCall_2_1_0 = (RuleCall)cBarAssignment_2_1.eContents().get(0);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cRefPartKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cRefPartAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cRefPartMidiFilePartCrossReference_3_1_0 = (CrossReference)cRefPartAssignment_3_1.eContents().get(0);
		private final RuleCall cRefPartMidiFilePartEStringParserRuleCall_3_1_0_1 = (RuleCall)cRefPartMidiFilePartCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftCurlyBracketKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cTextlinesAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cTextlinesMidiFileTextLineParserRuleCall_4_1_0 = (RuleCall)cTextlinesAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cTextlinesAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cTextlinesMidiFileTextLineParserRuleCall_4_2_1_0 = (RuleCall)cTextlinesAssignment_4_2_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		
		//MidiFilePart:
		//	{MidiFilePart} parttype=MidiFilePartType ("bar" bar=EInt)? ("refPart" refPart=[MidiFilePart|EString])? ("{"
		//	textlines+=MidiFileTextLine ("," textlines+=MidiFileTextLine)* "}")?;
		public ParserRule getRule() { return rule; }

		//{MidiFilePart} parttype=MidiFilePartType ("bar" bar=EInt)? ("refPart" refPart=[MidiFilePart|EString])? ("{"
		//textlines+=MidiFileTextLine ("," textlines+=MidiFileTextLine)* "}")?
		public Group getGroup() { return cGroup; }

		//{MidiFilePart}
		public Action getMidiFilePartAction_0() { return cMidiFilePartAction_0; }

		//parttype=MidiFilePartType
		public Assignment getParttypeAssignment_1() { return cParttypeAssignment_1; }

		//MidiFilePartType
		public RuleCall getParttypeMidiFilePartTypeEnumRuleCall_1_0() { return cParttypeMidiFilePartTypeEnumRuleCall_1_0; }

		//("bar" bar=EInt)?
		public Group getGroup_2() { return cGroup_2; }

		//"bar"
		public Keyword getBarKeyword_2_0() { return cBarKeyword_2_0; }

		//bar=EInt
		public Assignment getBarAssignment_2_1() { return cBarAssignment_2_1; }

		//EInt
		public RuleCall getBarEIntParserRuleCall_2_1_0() { return cBarEIntParserRuleCall_2_1_0; }

		//("refPart" refPart=[MidiFilePart|EString])?
		public Group getGroup_3() { return cGroup_3; }

		//"refPart"
		public Keyword getRefPartKeyword_3_0() { return cRefPartKeyword_3_0; }

		//refPart=[MidiFilePart|EString]
		public Assignment getRefPartAssignment_3_1() { return cRefPartAssignment_3_1; }

		//[MidiFilePart|EString]
		public CrossReference getRefPartMidiFilePartCrossReference_3_1_0() { return cRefPartMidiFilePartCrossReference_3_1_0; }

		//EString
		public RuleCall getRefPartMidiFilePartEStringParserRuleCall_3_1_0_1() { return cRefPartMidiFilePartEStringParserRuleCall_3_1_0_1; }

		//("{" textlines+=MidiFileTextLine ("," textlines+=MidiFileTextLine)* "}")?
		public Group getGroup_4() { return cGroup_4; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4_0() { return cLeftCurlyBracketKeyword_4_0; }

		//textlines+=MidiFileTextLine
		public Assignment getTextlinesAssignment_4_1() { return cTextlinesAssignment_4_1; }

		//MidiFileTextLine
		public RuleCall getTextlinesMidiFileTextLineParserRuleCall_4_1_0() { return cTextlinesMidiFileTextLineParserRuleCall_4_1_0; }

		//("," textlines+=MidiFileTextLine)*
		public Group getGroup_4_2() { return cGroup_4_2; }

		//","
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }

		//textlines+=MidiFileTextLine
		public Assignment getTextlinesAssignment_4_2_1() { return cTextlinesAssignment_4_2_1; }

		//MidiFileTextLine
		public RuleCall getTextlinesMidiFileTextLineParserRuleCall_4_2_1_0() { return cTextlinesMidiFileTextLineParserRuleCall_4_2_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4_3() { return cRightCurlyBracketKeyword_4_3; }
	}

	public class MidiFileTextLineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MidiFileTextLine");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMidiFileTextLineAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cChordPartsAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cChordPartsMidiFileChordPartParserRuleCall_1_1_0 = (RuleCall)cChordPartsAssignment_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		
		//MidiFileTextLine:
		//	{MidiFileTextLine} ("{" chordParts+=MidiFileChordPart* "}")?;
		public ParserRule getRule() { return rule; }

		//{MidiFileTextLine} ("{" chordParts+=MidiFileChordPart* "}")?
		public Group getGroup() { return cGroup; }

		//{MidiFileTextLine}
		public Action getMidiFileTextLineAction_0() { return cMidiFileTextLineAction_0; }

		//("{" chordParts+=MidiFileChordPart* "}")?
		public Group getGroup_1() { return cGroup_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1_0() { return cLeftCurlyBracketKeyword_1_0; }

		//chordParts+=MidiFileChordPart*
		public Assignment getChordPartsAssignment_1_1() { return cChordPartsAssignment_1_1; }

		//MidiFileChordPart
		public RuleCall getChordPartsMidiFileChordPartParserRuleCall_1_1_0() { return cChordPartsMidiFileChordPartParserRuleCall_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_1_2() { return cRightCurlyBracketKeyword_1_2; }
	}

	public class EIntElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EInt");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cHyphenMinusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final RuleCall cINTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		
		//EInt returns ecore::EInt:
		//	"-"? INT;
		public ParserRule getRule() { return rule; }

		//"-"? INT
		public Group getGroup() { return cGroup; }

		//"-"?
		public Keyword getHyphenMinusKeyword_0() { return cHyphenMinusKeyword_0; }

		//INT
		public RuleCall getINTTerminalRuleCall_1() { return cINTTerminalRuleCall_1; }
	}

	public class MidiFileChordPartElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MidiFileChordPart");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMidiFileChordPartAction_0 = (Action)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final Assignment cChordAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cChordEStringParserRuleCall_1_1_0 = (RuleCall)cChordAssignment_1_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_1_2 = (Keyword)cGroup_1.eContents().get(2);
		private final Assignment cTextAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cTextEStringParserRuleCall_2_0 = (RuleCall)cTextAssignment_2.eContents().get(0);
		
		//MidiFileChordPart:
		//	{MidiFileChordPart} ("(" chord=EString ")")? text=EString;
		public ParserRule getRule() { return rule; }

		//{MidiFileChordPart} ("(" chord=EString ")")? text=EString
		public Group getGroup() { return cGroup; }

		//{MidiFileChordPart}
		public Action getMidiFileChordPartAction_0() { return cMidiFileChordPartAction_0; }

		//("(" chord=EString ")")?
		public Group getGroup_1() { return cGroup_1; }

		//"("
		public Keyword getLeftParenthesisKeyword_1_0() { return cLeftParenthesisKeyword_1_0; }

		//chord=EString
		public Assignment getChordAssignment_1_1() { return cChordAssignment_1_1; }

		//EString
		public RuleCall getChordEStringParserRuleCall_1_1_0() { return cChordEStringParserRuleCall_1_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_1_2() { return cRightParenthesisKeyword_1_2; }

		//text=EString
		public Assignment getTextAssignment_2() { return cTextAssignment_2; }

		//EString
		public RuleCall getTextEStringParserRuleCall_2_0() { return cTextEStringParserRuleCall_2_0; }
	}
	
	
	public class MidiFilePartTypeElements extends AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "MidiFilePartType");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cREFRAINEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cREFRAINREFRAINKeyword_0_0 = (Keyword)cREFRAINEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cBRIDGEEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cBRIDGEBRIDGEKeyword_1_0 = (Keyword)cBRIDGEEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cVERSEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cVERSVERSKeyword_2_0 = (Keyword)cVERSEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cSOLOEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cSOLOSOLOKeyword_3_0 = (Keyword)cSOLOEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cZWISCHENSPIELEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cZWISCHENSPIELZWISCHENSPIELKeyword_4_0 = (Keyword)cZWISCHENSPIELEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cINTROEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cINTROINTROKeyword_5_0 = (Keyword)cINTROEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cEXTROEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cEXTROEXTROKeyword_6_0 = (Keyword)cEXTROEnumLiteralDeclaration_6.eContents().get(0);
		
		//enum MidiFilePartType:
		//	REFRAIN | BRIDGE | VERS | SOLO | ZWISCHENSPIEL | INTRO | EXTRO;
		public EnumRule getRule() { return rule; }

		//REFRAIN | BRIDGE | VERS | SOLO | ZWISCHENSPIEL | INTRO | EXTRO
		public Alternatives getAlternatives() { return cAlternatives; }

		//REFRAIN
		public EnumLiteralDeclaration getREFRAINEnumLiteralDeclaration_0() { return cREFRAINEnumLiteralDeclaration_0; }

		//"REFRAIN"
		public Keyword getREFRAINREFRAINKeyword_0_0() { return cREFRAINREFRAINKeyword_0_0; }

		//BRIDGE
		public EnumLiteralDeclaration getBRIDGEEnumLiteralDeclaration_1() { return cBRIDGEEnumLiteralDeclaration_1; }

		//"BRIDGE"
		public Keyword getBRIDGEBRIDGEKeyword_1_0() { return cBRIDGEBRIDGEKeyword_1_0; }

		//VERS
		public EnumLiteralDeclaration getVERSEnumLiteralDeclaration_2() { return cVERSEnumLiteralDeclaration_2; }

		//"VERS"
		public Keyword getVERSVERSKeyword_2_0() { return cVERSVERSKeyword_2_0; }

		//SOLO
		public EnumLiteralDeclaration getSOLOEnumLiteralDeclaration_3() { return cSOLOEnumLiteralDeclaration_3; }

		//"SOLO"
		public Keyword getSOLOSOLOKeyword_3_0() { return cSOLOSOLOKeyword_3_0; }

		//ZWISCHENSPIEL
		public EnumLiteralDeclaration getZWISCHENSPIELEnumLiteralDeclaration_4() { return cZWISCHENSPIELEnumLiteralDeclaration_4; }

		//"ZWISCHENSPIEL"
		public Keyword getZWISCHENSPIELZWISCHENSPIELKeyword_4_0() { return cZWISCHENSPIELZWISCHENSPIELKeyword_4_0; }

		//INTRO
		public EnumLiteralDeclaration getINTROEnumLiteralDeclaration_5() { return cINTROEnumLiteralDeclaration_5; }

		//"INTRO"
		public Keyword getINTROINTROKeyword_5_0() { return cINTROINTROKeyword_5_0; }

		//EXTRO
		public EnumLiteralDeclaration getEXTROEnumLiteralDeclaration_6() { return cEXTROEnumLiteralDeclaration_6; }

		//"EXTRO"
		public Keyword getEXTROEXTROKeyword_6_0() { return cEXTROEXTROKeyword_6_0; }
	}
	
	private MidiFileElements pMidiFile;
	private EStringElements pEString;
	private MidiFilePartElements pMidiFilePart;
	private MidiFileTextLineElements pMidiFileTextLine;
	private MidiFilePartTypeElements unknownRuleMidiFilePartType;
	private EIntElements pEInt;
	private MidiFileChordPartElements pMidiFileChordPart;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public MidiPlayerGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammarProvider = grammarProvider;
		this.gaTerminals = gaTerminals;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//MidiFile:
	//	{MidiFile} ("name" name=EString) ("path" path=EString)? ("fontsize" fontsize=EString)? ("pic" pic=EString)? ("key"
	//	key=EString)? ("{" parts+=MidiFilePart* "}")?;
	public MidiFileElements getMidiFileAccess() {
		return (pMidiFile != null) ? pMidiFile : (pMidiFile = new MidiFileElements());
	}
	
	public ParserRule getMidiFileRule() {
		return getMidiFileAccess().getRule();
	}

	//EString returns ecore::EString:
	//	STRING | ID;
	public EStringElements getEStringAccess() {
		return (pEString != null) ? pEString : (pEString = new EStringElements());
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}

	//MidiFilePart:
	//	{MidiFilePart} parttype=MidiFilePartType ("bar" bar=EInt)? ("refPart" refPart=[MidiFilePart|EString])? ("{"
	//	textlines+=MidiFileTextLine ("," textlines+=MidiFileTextLine)* "}")?;
	public MidiFilePartElements getMidiFilePartAccess() {
		return (pMidiFilePart != null) ? pMidiFilePart : (pMidiFilePart = new MidiFilePartElements());
	}
	
	public ParserRule getMidiFilePartRule() {
		return getMidiFilePartAccess().getRule();
	}

	//MidiFileTextLine:
	//	{MidiFileTextLine} ("{" chordParts+=MidiFileChordPart* "}")?;
	public MidiFileTextLineElements getMidiFileTextLineAccess() {
		return (pMidiFileTextLine != null) ? pMidiFileTextLine : (pMidiFileTextLine = new MidiFileTextLineElements());
	}
	
	public ParserRule getMidiFileTextLineRule() {
		return getMidiFileTextLineAccess().getRule();
	}

	//enum MidiFilePartType:
	//	REFRAIN | BRIDGE | VERS | SOLO | ZWISCHENSPIEL | INTRO | EXTRO;
	public MidiFilePartTypeElements getMidiFilePartTypeAccess() {
		return (unknownRuleMidiFilePartType != null) ? unknownRuleMidiFilePartType : (unknownRuleMidiFilePartType = new MidiFilePartTypeElements());
	}
	
	public EnumRule getMidiFilePartTypeRule() {
		return getMidiFilePartTypeAccess().getRule();
	}

	//EInt returns ecore::EInt:
	//	"-"? INT;
	public EIntElements getEIntAccess() {
		return (pEInt != null) ? pEInt : (pEInt = new EIntElements());
	}
	
	public ParserRule getEIntRule() {
		return getEIntAccess().getRule();
	}

	//MidiFileChordPart:
	//	{MidiFileChordPart} ("(" chord=EString ")")? text=EString;
	public MidiFileChordPartElements getMidiFileChordPartAccess() {
		return (pMidiFileChordPart != null) ? pMidiFileChordPart : (pMidiFileChordPart = new MidiFileChordPartElements());
	}
	
	public ParserRule getMidiFileChordPartRule() {
		return getMidiFileChordPartAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}