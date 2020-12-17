// Generated from C:/Users/fidxl/dev/automatas_2/practica_final/src/sample/analizador/splitJson\Json.g4 by ANTLR 4.8
package sample.analizador.splitJson;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsonParser#archivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchivo(JsonParser.ArchivoContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#fila}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFila(JsonParser.FilaContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(JsonParser.ItemContext ctx);
}