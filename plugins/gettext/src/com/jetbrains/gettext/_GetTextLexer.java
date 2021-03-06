/* The following code was generated by JFlex 1.4.3 on 7/11/12 4:30 PM */

package com.jetbrains.gettext;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 7/11/12 4:30 PM from the specification file
 * <tt>/home/svetlana/git/idea/IDEA/tools/lexer/../../community/plugins/gettext/src/com/jetbrains/gettext/GetText.flex</tt>
 */
class _GetTextLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int FLAG_DEL = 14;
  public static final int YYINITIAL = 0;
  public static final int REFERENCE_COMMENT = 8;
  public static final int COMMENT = 4;
  public static final int FLAG_COMMENT = 12;
  public static final int PREVIOUS_COMMENT = 10;
  public static final int EXTR_COMMENT = 6;
  public static final int START_COMMENT = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7, 7
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\1\0\1\4"+
    "\1\11\10\0\1\15\1\37\1\12\1\0\12\7\1\13\6\0\1\33"+
    "\1\42\1\21\1\25\1\45\1\34\1\20\1\44\1\24\1\43\1\46"+
    "\1\30\1\16\1\41\1\40\1\27\1\10\1\32\1\17\1\22\1\31"+
    "\1\47\1\50\1\23\1\36\1\35\1\5\1\0\1\6\1\0\1\26"+
    "\1\0\1\33\1\42\1\21\1\25\1\45\1\34\1\20\1\44\1\24"+
    "\1\43\1\46\1\30\1\16\1\41\1\40\1\27\1\10\1\32\1\17"+
    "\1\22\1\31\1\47\1\50\1\23\1\36\1\35\1\0\1\14\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\1\4\1\5\1\6\2\7\1\10"+
    "\2\11\1\12\1\13\1\14\1\2\1\1\1\15\1\1"+
    "\2\16\1\17\1\20\1\21\1\22\1\23\1\10\2\3"+
    "\2\4\2\5\2\6\1\24\1\25\1\24\1\7\2\24"+
    "\1\26\21\24\1\27\1\0\2\30\1\1\2\0\1\31"+
    "\24\0\1\1\21\0\3\1\36\0\2\1\1\32\2\0"+
    "\1\32\6\0\1\33\1\34\23\0\1\35\1\1\1\0"+
    "\1\35\24\0\1\36\1\0\1\36\23\0\1\37\34\0"+
    "\1\40\2\0\1\41\3\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[252];
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
    "\0\0\0\51\0\122\0\173\0\244\0\315\0\366\0\u011f"+
    "\0\u0148\0\u0171\0\u0148\0\u019a\0\u0148\0\u0148\0\u01c3\0\u01ec"+
    "\0\u0148\0\u0215\0\u023e\0\u0148\0\u0148\0\u0267\0\u0290\0\u02b9"+
    "\0\u0148\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386\0\u03af\0\u03d8"+
    "\0\u0401\0\u042a\0\u0148\0\u0148\0\u019a\0\u0453\0\u047c\0\u04a5"+
    "\0\u0148\0\u02e2\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b"+
    "\0\u05c4\0\u05ed\0\u0616\0\u063f\0\u0668\0\u0691\0\u06ba\0\u06e3"+
    "\0\u070c\0\u0735\0\u0148\0\u019a\0\u075e\0\u0148\0\u0787\0\u07b0"+
    "\0\u07d9\0\u0148\0\u0802\0\u082b\0\u0854\0\u087d\0\u08a6\0\u08cf"+
    "\0\u08f8\0\u0921\0\u094a\0\u0973\0\u099c\0\u09c5\0\u09ee\0\u0a17"+
    "\0\u0a40\0\u0a69\0\u0a92\0\u0abb\0\u0ae4\0\u0b0d\0\u0b36\0\u0b5f"+
    "\0\u0b88\0\u0bb1\0\u0bda\0\u0c03\0\u0c2c\0\u0c55\0\u0c7e\0\u0ca7"+
    "\0\u0cd0\0\u0cf9\0\u0d22\0\u0d4b\0\u0d74\0\u0d9d\0\u0dc6\0\u0def"+
    "\0\u0e18\0\u0e41\0\u0e6a\0\u0e93\0\u0ebc\0\u0ee5\0\u0f0e\0\u0f37"+
    "\0\u0f60\0\u0f89\0\u0fb2\0\u0fdb\0\u1004\0\u102d\0\u1056\0\u107f"+
    "\0\u10a8\0\u10d1\0\u10fa\0\u1123\0\u114c\0\u1175\0\u119e\0\u11c7"+
    "\0\u11f0\0\u1219\0\u1242\0\u126b\0\u1294\0\u12bd\0\u12e6\0\u130f"+
    "\0\u1338\0\u1361\0\u138a\0\u13b3\0\u13dc\0\u1405\0\u142e\0\u1457"+
    "\0\u1480\0\u14a9\0\u14d2\0\u14fb\0\u1524\0\u0148\0\u0148\0\u154d"+
    "\0\u1576\0\u159f\0\u15c8\0\u15f1\0\u161a\0\u1643\0\u166c\0\u1695"+
    "\0\u16be\0\u16e7\0\u1710\0\u1739\0\u1762\0\u178b\0\u17b4\0\u17dd"+
    "\0\u1806\0\u182f\0\u01ec\0\u1858\0\u1881\0\u0148\0\u18aa\0\u18d3"+
    "\0\u18fc\0\u1925\0\u194e\0\u1977\0\u19a0\0\u19c9\0\u19f2\0\u1a1b"+
    "\0\u1a44\0\u1a6d\0\u1a96\0\u1abf\0\u1ae8\0\u1b11\0\u1b3a\0\u1b63"+
    "\0\u1b8c\0\u1bb5\0\u01ec\0\u1bde\0\u0148\0\u1c07\0\u1c30\0\u1c59"+
    "\0\u1c82\0\u1cab\0\u1cd4\0\u1cfd\0\u1d26\0\u1d4f\0\u1d78\0\u1da1"+
    "\0\u1dca\0\u1df3\0\u1e1c\0\u1e45\0\u1e6e\0\u1e97\0\u1ec0\0\u1ee9"+
    "\0\u0148\0\u1f12\0\u1f3b\0\u1f64\0\u1f8d\0\u1fb6\0\u1fdf\0\u2008"+
    "\0\u2031\0\u205a\0\u2083\0\u20ac\0\u20d5\0\u20fe\0\u2127\0\u2150"+
    "\0\u2179\0\u21a2\0\u21cb\0\u21f4\0\u221d\0\u2246\0\u226f\0\u2298"+
    "\0\u22c1\0\u22ea\0\u2313\0\u233c\0\u2365\0\u0148\0\u238e\0\u23b7"+
    "\0\u0148\0\u23e0\0\u2409\0\u2432";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[252];
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
    "\1\11\1\12\2\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\4\11\1\22\7\20\1\11\10\20\1\11\11\20"+
    "\1\11\1\23\1\24\1\25\1\14\1\15\1\16\1\17"+
    "\2\11\1\26\1\27\1\30\1\31\1\32\32\11\1\33"+
    "\1\23\1\24\1\33\1\34\44\33\1\35\1\23\1\24"+
    "\1\35\1\36\44\35\1\37\1\23\1\24\1\37\1\40"+
    "\44\37\1\41\1\23\1\24\1\41\1\42\44\41\1\43"+
    "\1\23\1\24\1\44\1\45\2\43\1\46\1\47\1\43"+
    "\1\50\1\51\2\43\1\52\1\53\1\54\1\55\1\56"+
    "\4\43\1\57\1\60\1\43\1\61\1\62\1\63\1\43"+
    "\1\64\1\43\1\65\1\66\1\67\1\70\1\43\1\71"+
    "\1\72\3\43\1\23\1\24\1\44\1\45\2\43\1\46"+
    "\2\43\1\50\1\51\1\43\1\73\1\52\32\43\53\0"+
    "\1\13\46\0\1\74\1\75\1\76\1\74\1\76\44\74"+
    "\7\0\1\17\51\0\1\20\5\0\10\20\1\0\10\20"+
    "\1\0\11\20\10\0\1\20\5\0\1\20\1\77\6\20"+
    "\1\0\10\20\1\0\11\20\2\0\1\24\46\0\1\26"+
    "\2\0\46\26\1\27\2\0\46\27\1\30\2\0\46\30"+
    "\17\0\1\100\31\0\1\33\2\0\46\33\1\34\1\75"+
    "\1\76\1\34\1\33\44\34\1\35\2\0\46\35\1\36"+
    "\1\75\1\76\1\36\1\35\44\36\1\37\2\0\46\37"+
    "\1\40\1\75\1\76\1\40\1\37\44\40\1\41\2\0"+
    "\46\41\1\42\1\75\1\76\1\42\1\41\44\42\7\0"+
    "\1\46\63\0\1\101\40\0\1\102\54\0\1\103\2\0"+
    "\1\104\22\0\1\105\25\0\1\106\12\0\1\106\33\0"+
    "\1\107\17\0\1\110\32\0\1\111\65\0\1\112\5\0"+
    "\1\113\1\114\27\0\1\115\57\0\1\116\65\0\1\117"+
    "\31\0\1\120\40\0\1\113\71\0\1\121\46\0\1\122"+
    "\50\0\1\123\43\0\1\124\45\0\1\125\45\0\1\126"+
    "\25\0\1\76\56\0\1\20\5\0\2\20\1\127\5\20"+
    "\1\0\10\20\1\0\11\20\20\0\1\130\67\0\1\131"+
    "\44\0\1\132\61\0\1\133\43\0\1\110\32\0\1\134"+
    "\73\0\1\135\40\0\1\136\44\0\1\105\42\0\1\137"+
    "\55\0\1\105\53\0\1\140\35\0\1\113\22\0\1\141"+
    "\47\0\1\142\55\0\1\105\37\0\1\143\56\0\1\144"+
    "\44\0\1\145\51\0\1\146\57\0\1\147\25\0\1\150"+
    "\71\0\1\105\13\0\1\20\5\0\1\20\1\151\1\20"+
    "\1\152\2\20\1\153\1\20\1\0\10\20\1\0\11\20"+
    "\17\0\1\154\1\0\1\155\2\0\1\156\53\0\1\157"+
    "\4\0\1\136\44\0\1\160\65\0\1\161\42\0\1\162"+
    "\44\0\1\163\55\0\1\164\54\0\1\165\34\0\1\166"+
    "\52\0\1\167\36\0\1\170\65\0\1\171\34\0\1\105"+
    "\23\0\1\172\13\0\1\173\6\0\1\174\1\175\1\176"+
    "\1\177\4\0\1\200\1\201\2\0\1\202\2\0\1\203"+
    "\1\0\1\204\1\0\1\205\1\206\1\0\1\207\1\210"+
    "\21\0\1\211\64\0\1\105\34\0\1\113\41\0\1\20"+
    "\5\0\4\20\1\212\3\20\1\0\10\20\1\0\11\20"+
    "\10\0\1\20\5\0\4\20\1\213\3\20\1\0\10\20"+
    "\1\0\11\20\10\0\1\20\5\0\7\20\1\214\1\0"+
    "\10\20\1\0\11\20\22\0\1\215\50\0\1\216\53\0"+
    "\1\217\53\0\1\220\50\0\1\221\36\0\1\126\56\0"+
    "\1\222\56\0\1\113\50\0\1\223\56\0\1\224\47\0"+
    "\1\225\56\0\1\113\50\0\1\226\41\0\1\227\33\0"+
    "\1\230\51\0\1\231\44\0\1\232\2\0\1\233\22\0"+
    "\1\234\25\0\1\235\12\0\1\235\33\0\1\236\17\0"+
    "\1\237\32\0\1\240\65\0\1\241\5\0\1\242\1\243"+
    "\27\0\1\244\74\0\1\245\21\0\1\242\71\0\1\246"+
    "\46\0\1\247\43\0\1\250\45\0\1\251\45\0\1\252"+
    "\45\0\1\105\36\0\1\20\5\0\10\20\1\0\3\20"+
    "\1\253\4\20\1\0\11\20\10\0\1\20\5\0\5\20"+
    "\1\254\2\20\1\0\10\20\1\0\11\20\10\0\1\20"+
    "\5\0\10\20\1\255\10\20\1\0\11\20\32\0\1\256"+
    "\41\0\1\257\53\0\1\255\53\0\1\260\41\0\1\261"+
    "\67\0\1\262\25\0\1\263\73\0\1\105\51\0\1\264"+
    "\30\0\1\265\65\0\1\266\44\0\1\267\61\0\1\270"+
    "\43\0\1\237\32\0\1\271\73\0\1\272\40\0\1\273"+
    "\44\0\1\234\42\0\1\274\55\0\1\234\53\0\1\275"+
    "\35\0\1\242\22\0\1\276\54\0\1\234\45\0\1\277"+
    "\45\0\1\300\57\0\1\301\25\0\1\302\71\0\1\234"+
    "\13\0\1\20\5\0\4\20\1\303\3\20\1\0\10\20"+
    "\1\0\11\20\27\0\1\304\43\0\1\305\60\0\1\306"+
    "\51\0\1\307\37\0\1\310\61\0\1\311\47\0\1\312"+
    "\55\0\1\313\40\0\1\314\4\0\1\273\44\0\1\315"+
    "\65\0\1\316\42\0\1\317\44\0\1\320\55\0\1\321"+
    "\54\0\1\322\34\0\1\323\52\0\1\324\37\0\1\234"+
    "\23\0\1\325\22\0\1\326\64\0\1\234\34\0\1\242"+
    "\61\0\1\327\53\0\1\111\45\0\1\117\65\0\1\330"+
    "\25\0\1\331\61\0\1\332\44\0\1\333\51\0\1\334"+
    "\50\0\1\335\36\0\1\252\56\0\1\336\56\0\1\242"+
    "\50\0\1\337\56\0\1\340\47\0\1\341\56\0\1\242"+
    "\24\0\1\342\51\0\1\234\57\0\1\343\51\0\1\344"+
    "\37\0\1\126\62\0\1\345\46\0\1\346\41\0\1\347"+
    "\67\0\1\350\25\0\1\351\73\0\1\234\51\0\1\352"+
    "\30\0\1\353\60\0\1\354\57\0\1\306\26\0\1\355"+
    "\63\0\1\356\51\0\1\357\37\0\1\360\61\0\1\361"+
    "\47\0\1\362\55\0\1\363\44\0\1\364\36\0\1\306"+
    "\62\0\1\240\45\0\1\245\65\0\1\365\25\0\1\366"+
    "\61\0\1\367\44\0\1\370\51\0\1\371\52\0\1\372"+
    "\37\0\1\252\62\0\1\373\56\0\1\356\26\0\1\374"+
    "\52\0\1\356\27\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9307];
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


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\10\1\1\11\1\1\1\11\1\1\2\11\2\1\1\11"+
    "\2\1\2\11\3\1\1\11\11\1\2\11\4\1\1\11"+
    "\21\1\1\11\1\0\1\1\1\11\1\1\2\0\1\11"+
    "\24\0\1\1\21\0\3\1\36\0\3\1\2\0\1\1"+
    "\6\0\2\11\23\0\2\1\1\0\1\11\24\0\1\1"+
    "\1\0\1\11\23\0\1\11\34\0\1\11\2\0\1\11"+
    "\3\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[252];
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

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */

  public _GetTextLexer() {
    this((java.io.Reader)null);
  }



  _GetTextLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  _GetTextLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 160) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
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
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++]:zzBufferL.charAt(zzCurrentPosL++);
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
              zzInput = zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++]:zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 3: 
          { return GetTextTokenTypes.COMMENT;
          }
        case 34: break;
        case 32: 
          { yybegin(FLAG_DEL); return GetTextTokenTypes.NO_FORMAT_FLAG;
          }
        case 35: break;
        case 30: 
          { return GetTextTokenTypes.MSGCTXT;
          }
        case 36: break;
        case 10: 
          { return GetTextTokenTypes.QUOTE;
          }
        case 37: break;
        case 9: 
          { return GetTextTokenTypes.WHITE_SPACE;
          }
        case 38: break;
        case 11: 
          { return GetTextTokenTypes.LBRACE;
          }
        case 39: break;
        case 18: 
          { yybegin(PREVIOUS_COMMENT); return GetTextTokenTypes.PREVIOUS_COMMENT;
          }
        case 40: break;
        case 13: 
          { yybegin(START_COMMENT); return GetTextTokenTypes.COMMENT_SYMBOLS;
          }
        case 41: break;
        case 31: 
          { yybegin(FLAG_DEL); return GetTextTokenTypes.FORMAT_FLAG;
          }
        case 42: break;
        case 8: 
          { return GetTextTokenTypes.BAD_CHARACTER;
          }
        case 43: break;
        case 21: 
          { return GetTextTokenTypes.FLAG_DELIVERY;
          }
        case 44: break;
        case 12: 
          { return GetTextTokenTypes.RBRACE;
          }
        case 45: break;
        case 14: 
          { yybegin(YYINITIAL); return GetTextTokenTypes.WHITE_SPACE;
          }
        case 46: break;
        case 25: 
          { return GetTextTokenTypes.DOTS;
          }
        case 47: break;
        case 5: 
          { return GetTextTokenTypes.REFERENCE;
          }
        case 48: break;
        case 29: 
          { return GetTextTokenTypes.MSGSTR;
          }
        case 49: break;
        case 24: 
          { return GetTextTokenTypes.STRING;
          }
        case 50: break;
        case 7: 
          { return GetTextTokenTypes.RANGE_NUMBER;
          }
        case 51: break;
        case 27: 
          { yybegin(FLAG_DEL); return GetTextTokenTypes.RANGE_FLAG;
          }
        case 52: break;
        case 22: 
          { return GetTextTokenTypes.COLON;
          }
        case 53: break;
        case 2: 
          { return GetTextTokenTypes.NUMBER;
          }
        case 54: break;
        case 20: 
          { return GetTextTokenTypes.BAD_FLAG_COMMENT;
          }
        case 55: break;
        case 23: 
          { yybegin(FLAG_COMMENT); return GetTextTokenTypes.FLAG_DELIVERY;
          }
        case 56: break;
        case 4: 
          { return GetTextTokenTypes.EXTR_COMMENT;
          }
        case 57: break;
        case 26: 
          { return GetTextTokenTypes.MSGID;
          }
        case 58: break;
        case 17: 
          { yybegin(REFERENCE_COMMENT); return GetTextTokenTypes.REFERENCE;
          }
        case 59: break;
        case 6: 
          { return GetTextTokenTypes.PREVIOUS_COMMENT;
          }
        case 60: break;
        case 19: 
          { yybegin(FLAG_COMMENT); return GetTextTokenTypes.FLAG_COMMENT;
          }
        case 61: break;
        case 33: 
          { return GetTextTokenTypes.MSGID_PLURAL;
          }
        case 62: break;
        case 28: 
          { yybegin(FLAG_DEL); return GetTextTokenTypes.FUZZY_FLAG;
          }
        case 63: break;
        case 15: 
          { yybegin(COMMENT); return GetTextTokenTypes.COMMENT_SYMBOLS;
          }
        case 64: break;
        case 1: 
          { return GetTextTokenTypes.COMMAND;
          }
        case 65: break;
        case 16: 
          { yybegin(EXTR_COMMENT); return GetTextTokenTypes.EXTR_COMMENT;
          }
        case 66: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
