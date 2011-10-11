package org.mda.editor.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMidiPlayerLexer extends Lexer {
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int T29=29;
    public static final int T28=28;
    public static final int T27=27;
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=31;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=4;
    public static final int RULE_INT=6;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int RULE_WS=9;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int T18=18;
    public static final int T30=30;
    public static final int T19=19;
    public InternalMidiPlayerLexer() {;} 
    public InternalMidiPlayerLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:10:5: ( 'name' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:10:7: 'name'
            {
            match("name"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:11:5: ( 'path' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:11:7: 'path'
            {
            match("path"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:12:5: ( 'fontsize' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:12:7: 'fontsize'
            {
            match("fontsize"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:13:5: ( 'pic' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:13:7: 'pic'
            {
            match("pic"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:14:5: ( 'key' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:14:7: 'key'
            {
            match("key"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:15:5: ( '{' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:15:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:16:5: ( '}' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:16:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:17:5: ( 'bar' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:17:7: 'bar'
            {
            match("bar"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:18:5: ( 'refPart' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:18:7: 'refPart'
            {
            match("refPart"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:19:5: ( ',' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:19:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:20:5: ( '-' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:20:7: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:21:5: ( '(' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:21:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:22:5: ( ')' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:22:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:23:5: ( 'REFRAIN' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:23:7: 'REFRAIN'
            {
            match("REFRAIN"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:24:5: ( 'BRIDGE' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:24:7: 'BRIDGE'
            {
            match("BRIDGE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:25:5: ( 'VERS' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:25:7: 'VERS'
            {
            match("VERS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:26:5: ( 'SOLO' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:26:7: 'SOLO'
            {
            match("SOLO"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:27:5: ( 'ZWISCHENSPIEL' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:27:7: 'ZWISCHENSPIEL'
            {
            match("ZWISCHENSPIEL"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:28:5: ( 'INTRO' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:28:7: 'INTRO'
            {
            match("INTRO"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:29:5: ( 'EXTRO' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:29:7: 'EXTRO'
            {
            match("EXTRO"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:730:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:730:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:730:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:730:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:730:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:732:10: ( ( '0' .. '9' )+ )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:732:12: ( '0' .. '9' )+
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:732:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:732:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("734:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:734:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:736:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:736:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:736:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFE')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:736:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:41: ( '\\r' )? '\\n'
                    {
                    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:738:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:740:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:740:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:740:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:742:16: ( . )
            // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:742:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=27;
        int LA12_0 = input.LA(1);

        if ( (LA12_0=='n') ) {
            alt12 = mTokensHelper001();
        }
        else if ( (LA12_0=='p') ) {
            alt12 = mTokensHelper002();
        }
        else if ( (LA12_0=='f') ) {
            alt12 = mTokensHelper003();
        }
        else if ( (LA12_0=='k') ) {
            alt12 = mTokensHelper004();
        }
        else if ( (LA12_0=='{') ) {
            alt12 = mTokensHelper005();
        }
        else if ( (LA12_0=='}') ) {
            alt12 = mTokensHelper006();
        }
        else if ( (LA12_0=='b') ) {
            alt12 = mTokensHelper007();
        }
        else if ( (LA12_0=='r') ) {
            alt12 = mTokensHelper008();
        }
        else if ( (LA12_0==',') ) {
            alt12 = mTokensHelper009();
        }
        else if ( (LA12_0=='-') ) {
            alt12 = mTokensHelper010();
        }
        else if ( (LA12_0=='(') ) {
            alt12 = mTokensHelper011();
        }
        else if ( (LA12_0==')') ) {
            alt12 = mTokensHelper012();
        }
        else if ( (LA12_0=='R') ) {
            alt12 = mTokensHelper013();
        }
        else if ( (LA12_0=='B') ) {
            alt12 = mTokensHelper014();
        }
        else if ( (LA12_0=='V') ) {
            alt12 = mTokensHelper015();
        }
        else if ( (LA12_0=='S') ) {
            alt12 = mTokensHelper016();
        }
        else if ( (LA12_0=='Z') ) {
            alt12 = mTokensHelper017();
        }
        else if ( (LA12_0=='I') ) {
            alt12 = mTokensHelper018();
        }
        else if ( (LA12_0=='E') ) {
            alt12 = mTokensHelper019();
        }
        else if ( (LA12_0=='^') ) {
            alt12 = mTokensHelper020();
        }
        else if ( (LA12_0=='A'||(LA12_0>='C' && LA12_0<='D')||(LA12_0>='F' && LA12_0<='H')||(LA12_0>='J' && LA12_0<='Q')||(LA12_0>='T' && LA12_0<='U')||(LA12_0>='W' && LA12_0<='Y')||LA12_0=='_'||LA12_0=='a'||(LA12_0>='c' && LA12_0<='e')||(LA12_0>='g' && LA12_0<='j')||(LA12_0>='l' && LA12_0<='m')||LA12_0=='o'||LA12_0=='q'||(LA12_0>='s' && LA12_0<='z')) ) {
            alt12 = mTokensHelper021();
        }
        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
            alt12 = mTokensHelper022();
        }
        else if ( (LA12_0=='\"') ) {
            alt12 = mTokensHelper023();
        }
        else if ( (LA12_0=='\'') ) {
            alt12 = mTokensHelper024();
        }
        else if ( (LA12_0=='/') ) {
            alt12 = mTokensHelper025();
        }
        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
            alt12 = mTokensHelper026();
        }
        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='.'||(LA12_0>=':' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFE')) ) {
            alt12 = mTokensHelper027();
        }
        else {
            alt12 = mTokensHelper028();
        }
        switch (alt12) {
            case 1 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:66: T25
                {
                mT25(); 

                }
                break;
            case 16 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:70: T26
                {
                mT26(); 

                }
                break;
            case 17 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:74: T27
                {
                mT27(); 

                }
                break;
            case 18 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:78: T28
                {
                mT28(); 

                }
                break;
            case 19 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:82: T29
                {
                mT29(); 

                }
                break;
            case 20 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:86: T30
                {
                mT30(); 

                }
                break;
            case 21 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:90: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 22 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:98: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 23 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:107: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 24 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:119: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 25 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:135: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 26 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:151: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 27 :
                // ../org.mda.editor.xtext/src-gen/org/mda/editor/xtext/parser/antlr/internal/InternalMidiPlayer.g:1:159: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }
    private int mTokensHelper001() throws RecognitionException {
        int LA12_1 = input.LA(2);

        if ( (LA12_1=='a') ) {
            int LA12_28 = input.LA(3);

            if ( (LA12_28=='m') ) {
                int LA12_54 = input.LA(4);

                if ( (LA12_54=='e') ) {
                    int LA12_68 = input.LA(5);

                    if ( ((LA12_68>='0' && LA12_68<='9')||(LA12_68>='A' && LA12_68<='Z')||LA12_68=='_'||(LA12_68>='a' && LA12_68<='z')) ) {
                        return 21;
                    }
                    else {
                        return 1;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper002() throws RecognitionException {
        switch ( input.LA(2) ) {
        case 'i':
            {
            int LA12_30 = input.LA(3);

            if ( (LA12_30=='c') ) {
                int LA12_55 = input.LA(4);

                if ( ((LA12_55>='0' && LA12_55<='9')||(LA12_55>='A' && LA12_55<='Z')||LA12_55=='_'||(LA12_55>='a' && LA12_55<='z')) ) {
                    return 21;
                }
                else {
                    return 4;}
            }
            else {
                return 21;}
            }
        case 'a':
            {
            int LA12_31 = input.LA(3);

            if ( (LA12_31=='t') ) {
                int LA12_56 = input.LA(4);

                if ( (LA12_56=='h') ) {
                    int LA12_70 = input.LA(5);

                    if ( ((LA12_70>='0' && LA12_70<='9')||(LA12_70>='A' && LA12_70<='Z')||LA12_70=='_'||(LA12_70>='a' && LA12_70<='z')) ) {
                        return 21;
                    }
                    else {
                        return 2;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
            }
        default:
            return 21;}

    }

    private int mTokensHelper003() throws RecognitionException {
        int LA12_3 = input.LA(2);

        if ( (LA12_3=='o') ) {
            int LA12_32 = input.LA(3);

            if ( (LA12_32=='n') ) {
                int LA12_57 = input.LA(4);

                if ( (LA12_57=='t') ) {
                    int LA12_71 = input.LA(5);

                    if ( (LA12_71=='s') ) {
                        int LA12_84 = input.LA(6);

                        if ( (LA12_84=='i') ) {
                            int LA12_93 = input.LA(7);

                            if ( (LA12_93=='z') ) {
                                int LA12_100 = input.LA(8);

                                if ( (LA12_100=='e') ) {
                                    int LA12_105 = input.LA(9);

                                    if ( ((LA12_105>='0' && LA12_105<='9')||(LA12_105>='A' && LA12_105<='Z')||LA12_105=='_'||(LA12_105>='a' && LA12_105<='z')) ) {
                                        return 21;
                                    }
                                    else {
                                        return 3;}
                                }
                                else {
                                    return 21;}
                            }
                            else {
                                return 21;}
                        }
                        else {
                            return 21;}
                    }
                    else {
                        return 21;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper004() throws RecognitionException {
        int LA12_4 = input.LA(2);

        if ( (LA12_4=='e') ) {
            int LA12_33 = input.LA(3);

            if ( (LA12_33=='y') ) {
                int LA12_58 = input.LA(4);

                if ( ((LA12_58>='0' && LA12_58<='9')||(LA12_58>='A' && LA12_58<='Z')||LA12_58=='_'||(LA12_58>='a' && LA12_58<='z')) ) {
                    return 21;
                }
                else {
                    return 5;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper005() throws RecognitionException {
        return 6;
    }

    private int mTokensHelper006() throws RecognitionException {
        return 7;
    }

    private int mTokensHelper007() throws RecognitionException {
        int LA12_7 = input.LA(2);

        if ( (LA12_7=='a') ) {
            int LA12_36 = input.LA(3);

            if ( (LA12_36=='r') ) {
                int LA12_59 = input.LA(4);

                if ( ((LA12_59>='0' && LA12_59<='9')||(LA12_59>='A' && LA12_59<='Z')||LA12_59=='_'||(LA12_59>='a' && LA12_59<='z')) ) {
                    return 21;
                }
                else {
                    return 8;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper008() throws RecognitionException {
        int LA12_8 = input.LA(2);

        if ( (LA12_8=='e') ) {
            int LA12_37 = input.LA(3);

            if ( (LA12_37=='f') ) {
                int LA12_60 = input.LA(4);

                if ( (LA12_60=='P') ) {
                    int LA12_74 = input.LA(5);

                    if ( (LA12_74=='a') ) {
                        int LA12_85 = input.LA(6);

                        if ( (LA12_85=='r') ) {
                            int LA12_94 = input.LA(7);

                            if ( (LA12_94=='t') ) {
                                int LA12_101 = input.LA(8);

                                if ( ((LA12_101>='0' && LA12_101<='9')||(LA12_101>='A' && LA12_101<='Z')||LA12_101=='_'||(LA12_101>='a' && LA12_101<='z')) ) {
                                    return 21;
                                }
                                else {
                                    return 9;}
                            }
                            else {
                                return 21;}
                        }
                        else {
                            return 21;}
                    }
                    else {
                        return 21;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper009() throws RecognitionException {
        return 10;
    }

    private int mTokensHelper010() throws RecognitionException {
        return 11;
    }

    private int mTokensHelper011() throws RecognitionException {
        return 12;
    }

    private int mTokensHelper012() throws RecognitionException {
        return 13;
    }

    private int mTokensHelper013() throws RecognitionException {
        int LA12_13 = input.LA(2);

        if ( (LA12_13=='E') ) {
            int LA12_42 = input.LA(3);

            if ( (LA12_42=='F') ) {
                int LA12_61 = input.LA(4);

                if ( (LA12_61=='R') ) {
                    int LA12_75 = input.LA(5);

                    if ( (LA12_75=='A') ) {
                        int LA12_86 = input.LA(6);

                        if ( (LA12_86=='I') ) {
                            int LA12_95 = input.LA(7);

                            if ( (LA12_95=='N') ) {
                                int LA12_102 = input.LA(8);

                                if ( ((LA12_102>='0' && LA12_102<='9')||(LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
                                    return 21;
                                }
                                else {
                                    return 14;}
                            }
                            else {
                                return 21;}
                        }
                        else {
                            return 21;}
                    }
                    else {
                        return 21;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper014() throws RecognitionException {
        int LA12_14 = input.LA(2);

        if ( (LA12_14=='R') ) {
            int LA12_43 = input.LA(3);

            if ( (LA12_43=='I') ) {
                int LA12_62 = input.LA(4);

                if ( (LA12_62=='D') ) {
                    int LA12_76 = input.LA(5);

                    if ( (LA12_76=='G') ) {
                        int LA12_87 = input.LA(6);

                        if ( (LA12_87=='E') ) {
                            int LA12_96 = input.LA(7);

                            if ( ((LA12_96>='0' && LA12_96<='9')||(LA12_96>='A' && LA12_96<='Z')||LA12_96=='_'||(LA12_96>='a' && LA12_96<='z')) ) {
                                return 21;
                            }
                            else {
                                return 15;}
                        }
                        else {
                            return 21;}
                    }
                    else {
                        return 21;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper015() throws RecognitionException {
        int LA12_15 = input.LA(2);

        if ( (LA12_15=='E') ) {
            int LA12_44 = input.LA(3);

            if ( (LA12_44=='R') ) {
                int LA12_63 = input.LA(4);

                if ( (LA12_63=='S') ) {
                    int LA12_77 = input.LA(5);

                    if ( ((LA12_77>='0' && LA12_77<='9')||(LA12_77>='A' && LA12_77<='Z')||LA12_77=='_'||(LA12_77>='a' && LA12_77<='z')) ) {
                        return 21;
                    }
                    else {
                        return 16;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper016() throws RecognitionException {
        int LA12_16 = input.LA(2);

        if ( (LA12_16=='O') ) {
            int LA12_45 = input.LA(3);

            if ( (LA12_45=='L') ) {
                int LA12_64 = input.LA(4);

                if ( (LA12_64=='O') ) {
                    int LA12_78 = input.LA(5);

                    if ( ((LA12_78>='0' && LA12_78<='9')||(LA12_78>='A' && LA12_78<='Z')||LA12_78=='_'||(LA12_78>='a' && LA12_78<='z')) ) {
                        return 21;
                    }
                    else {
                        return 17;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper017() throws RecognitionException {
        int LA12_17 = input.LA(2);

        if ( (LA12_17=='W') ) {
            int LA12_46 = input.LA(3);

            if ( (LA12_46=='I') ) {
                int LA12_65 = input.LA(4);

                if ( (LA12_65=='S') ) {
                    int LA12_79 = input.LA(5);

                    if ( (LA12_79=='C') ) {
                        int LA12_90 = input.LA(6);

                        if ( (LA12_90=='H') ) {
                            int LA12_97 = input.LA(7);

                            if ( (LA12_97=='E') ) {
                                int LA12_104 = input.LA(8);

                                if ( (LA12_104=='N') ) {
                                    int LA12_108 = input.LA(9);

                                    if ( (LA12_108=='S') ) {
                                        int LA12_110 = input.LA(10);

                                        if ( (LA12_110=='P') ) {
                                            int LA12_111 = input.LA(11);

                                            if ( (LA12_111=='I') ) {
                                                int LA12_112 = input.LA(12);

                                                if ( (LA12_112=='E') ) {
                                                    int LA12_113 = input.LA(13);

                                                    if ( (LA12_113=='L') ) {
                                                        int LA12_114 = input.LA(14);

                                                        if ( ((LA12_114>='0' && LA12_114<='9')||(LA12_114>='A' && LA12_114<='Z')||LA12_114=='_'||(LA12_114>='a' && LA12_114<='z')) ) {
                                                            return 21;
                                                        }
                                                        else {
                                                            return 18;}
                                                    }
                                                    else {
                                                        return 21;}
                                                }
                                                else {
                                                    return 21;}
                                            }
                                            else {
                                                return 21;}
                                        }
                                        else {
                                            return 21;}
                                    }
                                    else {
                                        return 21;}
                                }
                                else {
                                    return 21;}
                            }
                            else {
                                return 21;}
                        }
                        else {
                            return 21;}
                    }
                    else {
                        return 21;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper018() throws RecognitionException {
        int LA12_18 = input.LA(2);

        if ( (LA12_18=='N') ) {
            int LA12_47 = input.LA(3);

            if ( (LA12_47=='T') ) {
                int LA12_66 = input.LA(4);

                if ( (LA12_66=='R') ) {
                    int LA12_80 = input.LA(5);

                    if ( (LA12_80=='O') ) {
                        int LA12_91 = input.LA(6);

                        if ( ((LA12_91>='0' && LA12_91<='9')||(LA12_91>='A' && LA12_91<='Z')||LA12_91=='_'||(LA12_91>='a' && LA12_91<='z')) ) {
                            return 21;
                        }
                        else {
                            return 19;}
                    }
                    else {
                        return 21;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper019() throws RecognitionException {
        int LA12_19 = input.LA(2);

        if ( (LA12_19=='X') ) {
            int LA12_48 = input.LA(3);

            if ( (LA12_48=='T') ) {
                int LA12_67 = input.LA(4);

                if ( (LA12_67=='R') ) {
                    int LA12_81 = input.LA(5);

                    if ( (LA12_81=='O') ) {
                        int LA12_92 = input.LA(6);

                        if ( ((LA12_92>='0' && LA12_92<='9')||(LA12_92>='A' && LA12_92<='Z')||LA12_92=='_'||(LA12_92>='a' && LA12_92<='z')) ) {
                            return 21;
                        }
                        else {
                            return 20;}
                    }
                    else {
                        return 21;}
                }
                else {
                    return 21;}
            }
            else {
                return 21;}
        }
        else {
            return 21;}
    }

    private int mTokensHelper020() throws RecognitionException {
        int LA12_20 = input.LA(2);

        if ( ((LA12_20>='A' && LA12_20<='Z')||LA12_20=='_'||(LA12_20>='a' && LA12_20<='z')) ) {
            return 21;
        }
        else {
            return 27;}
    }

    private int mTokensHelper021() throws RecognitionException {
        return 21;
    }

    private int mTokensHelper022() throws RecognitionException {
        return 22;
    }

    private int mTokensHelper023() throws RecognitionException {
        int LA12_23 = input.LA(2);

        if ( ((LA12_23>='\u0000' && LA12_23<='\uFFFE')) ) {
            return 23;
        }
        else {
            return 27;}
    }

    private int mTokensHelper024() throws RecognitionException {
        int LA12_24 = input.LA(2);

        if ( ((LA12_24>='\u0000' && LA12_24<='\uFFFE')) ) {
            return 23;
        }
        else {
            return 27;}
    }

    private int mTokensHelper025() throws RecognitionException {
        switch ( input.LA(2) ) {
        case '/':
            {
            return 25;
            }
        case '*':
            {
            return 24;
            }
        default:
            return 27;}

    }

    private int mTokensHelper026() throws RecognitionException {
        return 26;
    }

    private int mTokensHelper027() throws RecognitionException {
        return 27;
    }

    private int mTokensHelper028() throws RecognitionException {
        NoViableAltException nvae =
            new NoViableAltException("1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 12, 0, input);

        throw nvae;
    }



 

}