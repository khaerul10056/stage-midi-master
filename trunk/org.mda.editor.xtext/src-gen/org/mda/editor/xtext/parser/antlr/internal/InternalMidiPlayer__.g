lexer grammar InternalMidiPlayer;
@header {
package org.mda.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'name' ;
T12 : 'path' ;
T13 : 'fontsize' ;
T14 : 'pic' ;
T15 : 'key' ;
T16 : '{' ;
T17 : '}' ;
T18 : 'bar' ;
T19 : 'refPart' ;
T20 : ',' ;
T21 : '-' ;
T22 : '(' ;
T23 : ')' ;
T24 : 'REFRAIN' ;
T25 : 'BRIDGE' ;
T26 : 'VERS' ;
T27 : 'SOLO' ;
T28 : 'ZWISCHENSPIEL' ;
T29 : 'INTRO' ;
T30 : 'EXTRO' ;

// $ANTLR src "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g" 730
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g" 732
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g" 734
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g" 736
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g" 738
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g" 740
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g" 742
RULE_ANY_OTHER : .;


