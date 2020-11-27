// Generated from C:/Users/fidxl/dev/automatas_2/practica_final/src/sample/analizador/nutricion\Alimentos.g4 by ANTLR 4.8
package sample.analizador.nutricion;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AlimentosParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NUMERO=2, GRAMOS=3, TEXTO=4, IGNORAR=5;
	public static final int
		RULE_archivo = 0, RULE_alimento = 1, RULE_cantidad = 2, RULE_gramos = 3, 
		RULE_nombre = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"archivo", "alimento", "cantidad", "gramos", "nombre"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", null, "'gr'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NUMERO", "GRAMOS", "TEXTO", "IGNORAR"
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
	public String getGrammarFileName() { return "Alimentos.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlimentosParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ArchivoContext extends ParserRuleContext {
		public List<AlimentoContext> alimento() {
			return getRuleContexts(AlimentoContext.class);
		}
		public AlimentoContext alimento(int i) {
			return getRuleContext(AlimentoContext.class,i);
		}
		public ArchivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_archivo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitArchivo(this);
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
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				alimento();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMERO );
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

	public static class AlimentoContext extends ParserRuleContext {
		public CantidadContext cantidad() {
			return getRuleContext(CantidadContext.class,0);
		}
		public NombreContext nombre() {
			return getRuleContext(NombreContext.class,0);
		}
		public AlimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alimento; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitAlimento(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlimentoContext alimento() throws RecognitionException {
		AlimentoContext _localctx = new AlimentoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_alimento);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(15);
			cantidad();
			setState(16);
			match(T__0);
			setState(17);
			nombre();
			}
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

	public static class CantidadContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(AlimentosParser.NUMERO, 0); }
		public GramosContext gramos() {
			return getRuleContext(GramosContext.class,0);
		}
		public CantidadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cantidad; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitCantidad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CantidadContext cantidad() throws RecognitionException {
		CantidadContext _localctx = new CantidadContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cantidad);
		try {
			setState(21);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(NUMERO);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				gramos();
				}
				break;
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

	public static class GramosContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(AlimentosParser.NUMERO, 0); }
		public TerminalNode GRAMOS() { return getToken(AlimentosParser.GRAMOS, 0); }
		public GramosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gramos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitGramos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GramosContext gramos() throws RecognitionException {
		GramosContext _localctx = new GramosContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_gramos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(NUMERO);
			setState(24);
			match(GRAMOS);
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

	public static class NombreContext extends ParserRuleContext {
		public List<TerminalNode> TEXTO() { return getTokens(AlimentosParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(AlimentosParser.TEXTO, i);
		}
		public NombreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nombre; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlimentosVisitor ) return ((AlimentosVisitor<? extends T>)visitor).visitNombre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NombreContext nombre() throws RecognitionException {
		NombreContext _localctx = new NombreContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nombre);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(TEXTO);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(27);
				match(T__0);
				setState(28);
				match(TEXTO);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\7%\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\5\4\30\n\4\3\5\3\5\3\5\3\6\3\6\3\6\7\6 \n\6\f\6\16\6#\13\6\3"+
		"\6\2\2\7\2\4\6\b\n\2\2\2\"\2\r\3\2\2\2\4\21\3\2\2\2\6\27\3\2\2\2\b\31"+
		"\3\2\2\2\n\34\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2"+
		"\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\22\5\6\4\2\22\23\7\3\2\2\23\24\5\n"+
		"\6\2\24\5\3\2\2\2\25\30\7\4\2\2\26\30\5\b\5\2\27\25\3\2\2\2\27\26\3\2"+
		"\2\2\30\7\3\2\2\2\31\32\7\4\2\2\32\33\7\5\2\2\33\t\3\2\2\2\34!\7\6\2\2"+
		"\35\36\7\3\2\2\36 \7\6\2\2\37\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2"+
		"\2\2\"\13\3\2\2\2#!\3\2\2\2\5\17\27!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}