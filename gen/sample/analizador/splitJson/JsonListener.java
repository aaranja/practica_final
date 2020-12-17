// Generated from C:/Users/fidxl/dev/automatas_2/practica_final/src/sample/analizador/splitJson\Json.g4 by ANTLR 4.8
package sample.analizador.splitJson;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JsonParser}.
 */
public interface JsonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JsonParser#archivo}.
	 * @param ctx the parse tree
	 */
	void enterArchivo(JsonParser.ArchivoContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#archivo}.
	 * @param ctx the parse tree
	 */
	void exitArchivo(JsonParser.ArchivoContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#fila}.
	 * @param ctx the parse tree
	 */
	void enterFila(JsonParser.FilaContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#fila}.
	 * @param ctx the parse tree
	 */
	void exitFila(JsonParser.FilaContext ctx);
	/**
	 * Enter a parse tree produced by {@link JsonParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(JsonParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link JsonParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(JsonParser.ItemContext ctx);
}