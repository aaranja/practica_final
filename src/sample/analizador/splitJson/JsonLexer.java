// Generated from Json.g4 by ANTLR 4.8
package sample.analizador.splitJson;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JsonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		STRING=10, NUMBER=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"INT", "EXP", "STRING", "ESC", "UNICODE", "HEX", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'{'", "'}'", "':'", "'true'", "'false'", "'null'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "STRING", 
			"NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Json.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\7\13E\n\13\f"+
		"\13\16\13H\13\13\5\13J\n\13\3\f\3\f\5\fN\n\f\3\f\3\f\3\r\3\r\3\r\7\rU"+
		"\n\r\f\r\16\rX\13\r\3\r\3\r\3\16\3\16\3\16\5\16_\n\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\21\6\21j\n\21\r\21\16\21k\3\22\6\22o\n\22\r"+
		"\22\16\22p\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\2\27\2\31\f\33\2\35\2\37\2!\r#\16\3\2\n\3\2\63;\3\2\62;\4\2GGgg\4\2-"+
		"-//\4\2$$^^\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2\13\f\17\17\"\"\2v"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\31\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r\62"+
		"\3\2\2\2\178\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25I\3\2\2\2\27K\3\2\2\2\31"+
		"Q\3\2\2\2\33[\3\2\2\2\35`\3\2\2\2\37f\3\2\2\2!i\3\2\2\2#n\3\2\2\2%&\7"+
		".\2\2&\4\3\2\2\2\'(\7}\2\2(\6\3\2\2\2)*\7\177\2\2*\b\3\2\2\2+,\7<\2\2"+
		",\n\3\2\2\2-.\7v\2\2./\7t\2\2/\60\7w\2\2\60\61\7g\2\2\61\f\3\2\2\2\62"+
		"\63\7h\2\2\63\64\7c\2\2\64\65\7n\2\2\65\66\7u\2\2\66\67\7g\2\2\67\16\3"+
		"\2\2\289\7p\2\29:\7w\2\2:;\7n\2\2;<\7n\2\2<\20\3\2\2\2=>\7]\2\2>\22\3"+
		"\2\2\2?@\7_\2\2@\24\3\2\2\2AJ\7\62\2\2BF\t\2\2\2CE\t\3\2\2DC\3\2\2\2E"+
		"H\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IA\3\2\2\2IB\3\2\2\2"+
		"J\26\3\2\2\2KM\t\4\2\2LN\t\5\2\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\5\25"+
		"\13\2P\30\3\2\2\2QV\7$\2\2RU\5\33\16\2SU\n\6\2\2TR\3\2\2\2TS\3\2\2\2U"+
		"X\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7$\2\2Z\32\3\2\2\2"+
		"[^\7^\2\2\\_\t\7\2\2]_\5\35\17\2^\\\3\2\2\2^]\3\2\2\2_\34\3\2\2\2`a\7"+
		"w\2\2ab\5\37\20\2bc\5\37\20\2cd\5\37\20\2de\5\37\20\2e\36\3\2\2\2fg\t"+
		"\b\2\2g \3\2\2\2hj\t\3\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\""+
		"\3\2\2\2mo\t\t\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2r"+
		"s\b\22\2\2s$\3\2\2\2\13\2FIMTV^kp\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}