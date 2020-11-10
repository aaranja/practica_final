// Generated from C:/Users/Balboa-PC/Documents/automatas I/Practicafinal/src/sample\Calculadora.g4 by ANTLR 4.8
package sample;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculadoraParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, GRAMOS=4, ID=5, NUM=6, ESPACIOS=7;
	public static final int
		RULE_archivo = 0, RULE_cabecera = 1, RULE_persona = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"archivo", "cabecera", "persona"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'CARBOHIDRATOS'", "'PROTEINAS'", "'GRASAS'", "'g'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "GRAMOS", "ID", "NUM", "ESPACIOS"
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

	@Override
	public String getGrammarFileName() { return "Calculadora.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalculadoraParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ArchivoContext extends ParserRuleContext {
		public CabeceraContext cabecera() {
			return getRuleContext(CabeceraContext.class,0);
		}
		public List<PersonaContext> persona() {
			return getRuleContexts(PersonaContext.class);
		}
		public PersonaContext persona(int i) {
			return getRuleContext(PersonaContext.class,i);
		}
		public ArchivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_archivo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculadoraVisitor ) return ((CalculadoraVisitor<? extends T>)visitor).visitArchivo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArchivoContext archivo() throws RecognitionException {
		ArchivoContext _localctx = new ArchivoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_archivo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			cabecera();
			setState(8); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(7);
				persona();
				}
				}
				setState(10); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CabeceraContext extends ParserRuleContext {
		public CabeceraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cabecera; }
	 
		public CabeceraContext() { }
		public void copyFrom(CabeceraContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class HeaderContext extends CabeceraContext {
		public TerminalNode ID() { return getToken(CalculadoraParser.ID, 0); }
		public HeaderContext(CabeceraContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculadoraVisitor ) return ((CalculadoraVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CabeceraContext cabecera() throws RecognitionException {
		CabeceraContext _localctx = new CabeceraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cabecera);
		try {
			_localctx = new HeaderContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(ID);
			setState(13);
			match(T__0);
			setState(14);
			match(T__1);
			setState(15);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PersonaContext extends ParserRuleContext {
		public PersonaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_persona; }
	 
		public PersonaContext() { }
		public void copyFrom(PersonaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DatosContext extends PersonaContext {
		public List<TerminalNode> ID() { return getTokens(CalculadoraParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CalculadoraParser.ID, i);
		}
		public List<TerminalNode> NUM() { return getTokens(CalculadoraParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(CalculadoraParser.NUM, i);
		}
		public List<TerminalNode> GRAMOS() { return getTokens(CalculadoraParser.GRAMOS); }
		public TerminalNode GRAMOS(int i) {
			return getToken(CalculadoraParser.GRAMOS, i);
		}
		public DatosContext(PersonaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalculadoraVisitor ) return ((CalculadoraVisitor<? extends T>)visitor).visitDatos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PersonaContext persona() throws RecognitionException {
		PersonaContext _localctx = new PersonaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_persona);
		try {
			int _alt;
			_localctx = new DatosContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(24); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(17);
					match(ID);
					setState(18);
					match(NUM);
					setState(19);
					match(GRAMOS);
					setState(20);
					match(NUM);
					setState(21);
					match(GRAMOS);
					setState(22);
					match(NUM);
					setState(23);
					match(GRAMOS);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(26); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t\37\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\6\2\13\n\2\r\2\16\2\f\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\6\4\33\n\4\r\4\16\4\34\3\4\2\2\5\2\4\6\2\2\2\35\2"+
		"\b\3\2\2\2\4\16\3\2\2\2\6\32\3\2\2\2\b\n\5\4\3\2\t\13\5\6\4\2\n\t\3\2"+
		"\2\2\13\f\3\2\2\2\f\n\3\2\2\2\f\r\3\2\2\2\r\3\3\2\2\2\16\17\7\7\2\2\17"+
		"\20\7\3\2\2\20\21\7\4\2\2\21\22\7\5\2\2\22\5\3\2\2\2\23\24\7\7\2\2\24"+
		"\25\7\b\2\2\25\26\7\6\2\2\26\27\7\b\2\2\27\30\7\6\2\2\30\31\7\b\2\2\31"+
		"\33\7\6\2\2\32\23\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35"+
		"\7\3\2\2\2\4\f\34";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}