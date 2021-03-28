// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: LexemasRespuesta.jflex

package com.froi.editorcodigoindigo.analizadorrespuesta;

import java_cup.runtime.*;
import static com.froi.editorcodigoindigo.analizadorrespuesta.ParserRespuestasSym.*;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
public class RespuestasLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\1\1\2\22\0\1\1"+
    "\1\3\1\4\11\0\1\5\15\0\1\6\1\0\1\7"+
    "\1\0\1\10\2\0\1\11\1\0\1\12\1\13\1\14"+
    "\1\15\2\0\1\16\1\17\1\0\1\20\1\0\1\21"+
    "\1\22\1\23\1\0\1\24\1\25\1\26\1\27\5\0"+
    "\1\30\1\0\1\31\1\0\1\32\1\0\1\33\3\0"+
    "\1\34\1\15\2\0\1\35\4\0\1\36\1\0\1\37"+
    "\1\0\1\40\1\41\1\42\1\43\5\0\1\44\1\2"+
    "\1\45\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\7\2\1\1\10\1\11\1\12\1\13\2\0\1\14"+
    "\36\0\1\15\25\0\1\16\17\0\1\17\4\0\1\20"+
    "\1\21\4\0\1\22\1\23\2\0\1\24\5\0\1\25"+
    "\3\0\1\26\4\0\1\27";

  private static int [] zzUnpackAction() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\46\0\46\0\114\0\46\0\46\0\46"+
    "\0\46\0\162\0\230\0\46\0\46\0\46\0\46\0\276"+
    "\0\114\0\46\0\344\0\u010a\0\u0130\0\u0156\0\u017c\0\u01a2"+
    "\0\u01c8\0\u01ee\0\u0214\0\u023a\0\u0260\0\u0286\0\u02ac\0\u02d2"+
    "\0\u02f8\0\u031e\0\u0344\0\u036a\0\u0390\0\u03b6\0\u03dc\0\u0402"+
    "\0\u0428\0\u044e\0\u0474\0\u049a\0\u04c0\0\u04e6\0\u050c\0\u0532"+
    "\0\46\0\u0558\0\u057e\0\u05a4\0\u05ca\0\u05f0\0\u0616\0\u063c"+
    "\0\u0662\0\u0688\0\u06ae\0\u06d4\0\u06fa\0\u0720\0\u0746\0\u076c"+
    "\0\u0792\0\u07b8\0\u07de\0\u0804\0\u082a\0\u0850\0\46\0\u0876"+
    "\0\u089c\0\u08c2\0\u08e8\0\u090e\0\u0934\0\u095a\0\u0980\0\u09a6"+
    "\0\u09cc\0\u09f2\0\u0a18\0\u0a3e\0\u0a64\0\u0a8a\0\46\0\u0ab0"+
    "\0\u0ad6\0\u0afc\0\u0b22\0\u0b48\0\u0b6e\0\u0b94\0\u0bba\0\u0be0"+
    "\0\u0c06\0\46\0\46\0\u0c2c\0\u0c52\0\46\0\u0c78\0\u0c9e"+
    "\0\u0cc4\0\u0cea\0\u0d10\0\46\0\u0d36\0\u0d5c\0\u0d82\0\46"+
    "\0\u0da8\0\u0dce\0\u0df4\0\u0e1a\0\46";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\4\2\1\12\1\13\11\2\1\14\1\15\3\2\1\13"+
    "\6\2\1\16\1\17\46\0\1\20\1\21\2\20\1\22"+
    "\6\20\1\23\1\24\1\20\1\25\7\20\1\26\17\20"+
    "\16\0\1\27\16\0\1\27\31\0\1\30\14\0\1\30"+
    "\7\0\4\20\1\22\45\20\1\22\7\20\1\31\35\20"+
    "\1\22\17\20\1\32\25\20\1\22\14\20\1\33\30\20"+
    "\1\22\11\20\1\34\27\20\21\0\1\35\14\0\1\35"+
    "\25\0\1\36\16\0\1\36\10\0\4\20\1\22\20\20"+
    "\1\37\1\40\23\20\1\22\17\20\1\41\25\20\1\22"+
    "\20\20\1\42\24\20\1\22\16\20\1\43\22\20\32\0"+
    "\1\44\45\0\1\45\13\0\4\20\1\22\5\20\1\46"+
    "\37\20\1\22\4\20\1\47\40\20\1\22\15\20\1\50"+
    "\27\20\1\22\21\20\1\51\23\20\1\22\15\20\1\52"+
    "\23\20\24\0\1\53\13\0\1\53\31\0\1\54\13\0"+
    "\1\54\5\0\4\20\1\22\17\20\1\55\25\20\1\22"+
    "\13\20\1\56\31\20\1\22\17\20\1\57\25\20\1\22"+
    "\17\20\1\60\22\20\1\52\2\20\1\61\41\20\14\0"+
    "\1\62\17\0\1\62\25\0\1\63\17\0\1\63\11\0"+
    "\4\20\1\22\11\20\1\64\33\20\1\22\13\20\1\65"+
    "\31\20\1\22\25\20\1\66\17\20\1\22\22\20\1\67"+
    "\16\20\25\0\1\70\13\0\1\70\31\0\1\71\13\0"+
    "\1\71\4\0\4\20\1\22\16\20\1\72\26\20\1\22"+
    "\7\20\1\73\35\20\1\22\6\20\1\74\36\20\1\22"+
    "\5\20\1\75\33\20\23\0\1\76\13\0\1\76\31\0"+
    "\1\77\13\0\1\77\6\0\4\20\1\22\5\20\1\100"+
    "\37\20\1\22\20\20\1\101\24\20\1\22\7\20\1\102"+
    "\35\20\1\22\5\20\1\103\33\20\27\0\1\104\13\0"+
    "\1\104\31\0\1\105\13\0\1\105\2\0\4\20\1\22"+
    "\11\20\1\106\30\20\1\101\2\20\1\107\45\20\1\22"+
    "\21\20\1\110\23\20\1\22\11\20\1\111\27\20\14\0"+
    "\1\112\17\0\1\112\25\0\1\113\17\0\1\113\11\0"+
    "\4\20\1\22\15\20\1\114\27\20\1\22\7\20\1\115"+
    "\35\20\1\22\15\20\1\116\23\20\25\0\1\117\13\0"+
    "\1\117\31\0\1\120\13\0\1\120\4\0\4\20\1\22"+
    "\14\20\1\121\30\20\1\22\5\20\1\122\37\20\1\22"+
    "\14\20\1\123\24\20\26\0\1\124\13\0\1\124\31\0"+
    "\1\125\13\0\1\125\3\0\1\20\1\126\2\20\1\127"+
    "\25\20\1\130\17\20\1\22\21\20\1\131\23\20\1\22"+
    "\7\20\1\132\15\20\1\133\13\20\11\0\1\134\21\0"+
    "\1\134\23\0\1\135\21\0\1\135\12\0\1\20\1\126"+
    "\2\20\1\127\45\20\1\22\7\20\1\136\35\20\1\22"+
    "\4\20\1\137\40\20\1\22\20\20\1\140\24\20\1\22"+
    "\7\20\1\141\31\20\25\0\1\142\13\0\1\142\31\0"+
    "\1\143\13\0\1\143\4\0\4\20\1\22\17\20\1\144"+
    "\25\20\1\22\6\20\1\145\33\20\1\140\2\20\1\146"+
    "\45\20\1\22\12\20\1\147\32\20\1\22\17\20\1\150"+
    "\25\20\1\22\15\20\1\151\27\20\1\22\7\20\1\152"+
    "\35\20\1\22\15\20\1\153\24\20\1\151\2\20\1\154"+
    "\45\20\1\22\5\20\1\155\37\20\1\22\17\20\1\156"+
    "\25\20\1\22\22\20\1\157\17\20\1\156\2\20\1\160"+
    "\45\20\1\22\21\20\1\161\23\20\1\22\4\20\1\162"+
    "\40\20\1\22\6\20\1\163\36\20\1\22\4\20\1\164"+
    "\35\20\1\164\2\20\1\165\41\20";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3648];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\3\11\1\1\4\11\2\1\4\11\2\0\1\11"+
    "\36\0\1\11\25\0\1\11\17\0\1\11\4\0\2\1"+
    "\4\0\2\11\2\0\1\11\5\0\1\11\3\0\1\11"+
    "\4\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public RespuestasLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.out.println("Lexema no correspondiente al lenguaje; " + yytext());
            }
            // fall through
          case 24: break;
          case 2:
            { /* Ignorar */
            }
            // fall through
          case 25: break;
          case 3:
            { System.out.println("EXCLAMACION: " + yytext()); return new Symbol(EXCLAMACION, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 26: break;
          case 4:
            { System.out.println("COMA: " + yytext()); return new Symbol(COMA, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 27: break;
          case 5:
            { System.out.println("PUNTOS: " + yytext()); return new Symbol(PUNTOS, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 28: break;
          case 6:
            { System.out.println("MENOR_QUE: " + yytext()); return new Symbol(MENOR_QUE, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 29: break;
          case 7:
            { System.out.println("MAYOR_QUE: " + yytext()); return new Symbol(MAYOR_QUE, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 30: break;
          case 8:
            { System.out.println("CORCHETE_A: " + yytext()); return new Symbol(CORCHETE_A, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 31: break;
          case 9:
            { System.out.println("CORCHETE_C: " + yytext()); return new Symbol(CORCHETE_C, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 32: break;
          case 10:
            { System.out.println("LLAVE_A: " + yytext()); return new Symbol(LLAVE_A, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 33: break;
          case 11:
            { System.out.println("LLAVE_C: " + yytext()); return new Symbol(LLAVE_C, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 34: break;
          case 12:
            { System.out.println("ALLCHARACTERS: " + yytext()); return new Symbol(ALLCHARACTERS, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 35: break;
          case 13:
            { System.out.println("TIPO: " + yytext()); return new Symbol(TIPO, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 36: break;
          case 14:
            { System.out.println("DETALLES: " + yytext()); return new Symbol(DETALLES, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 37: break;
          case 15:
            { System.out.println("DESCRIPCION: " + yytext()); return new Symbol(DESCRIPCION, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 38: break;
          case 16:
            { System.out.println("FIN_RESPUESTA: " + yytext()); return new Symbol(FIN_RESPUESTA, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 39: break;
          case 17:
            { System.out.println("INI_RESPUESTA: " + yytext()); return new Symbol(INI_RESPUESTA, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 40: break;
          case 18:
            { System.out.println("FIN_RESPUESTAS: " + yytext()); return new Symbol(FIN_RESPUESTAS, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 41: break;
          case 19:
            { System.out.println("INI_RESPUESTAS: " + yytext()); return new Symbol(INI_RESPUESTAS, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 42: break;
          case 20:
            { System.out.println("INSTRUCCIONES: " + yytext()); return new Symbol(INSTRUCCIONES, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 43: break;
          case 21:
            { System.out.println("ERROR_DETECTADO: " + yytext()); return new Symbol(ERROR_DETECTADO, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 44: break;
          case 22:
            { System.out.println("DESCRIPCION_ERROR: " + yytext()); return new Symbol(DESCRIPCION_ERROR, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 45: break;
          case 23:
            { System.out.println("INSTRUCCION_EJECUTADA: " + yytext()); return new Symbol(INSTRUCCION_EJECUTADA, yyline+1, yycolumn+1, yytext());
            }
            // fall through
          case 46: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
