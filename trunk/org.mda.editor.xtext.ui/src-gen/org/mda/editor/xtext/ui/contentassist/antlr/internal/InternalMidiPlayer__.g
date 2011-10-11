lexer grammar InternalMidiPlayer;
@header {
package org.mda.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'REFRAIN' ;
T12 : 'BRIDGE' ;
T13 : 'VERS' ;
T14 : 'SOLO' ;
T15 : 'ZWISCHENSPIEL' ;
T16 : 'INTRO' ;
T17 : 'EXTRO' ;
T18 : 'name' ;
T19 : 'path' ;
T20 : 'fontsize' ;
T21 : 'pic' ;
T22 : 'key' ;
T23 : '{' ;
T24 : '}' ;
T25 : 'bar' ;
T26 : 'refPart' ;
T27 : ',' ;
T28 : '-' ;
T29 : '(' ;
T30 : ')' ;

// $ANTLR src "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g" 2060
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g" 2062
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g" 2064
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g" 2066
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g" 2068
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g" 2070
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.mda.editor.xtext.ui/src-gen/org/mda/editor/xtext/ui/contentassist/antlr/internal/InternalMidiPlayer.g" 2072
RULE_ANY_OTHER : .;


