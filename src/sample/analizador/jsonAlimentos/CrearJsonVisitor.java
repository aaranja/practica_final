// Generated from CrearJson.g4 by ANTLR 4.8
package sample.analizador.jsonAlimentos;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CrearJsonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CrearJsonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CrearJsonParser#crear}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrear(CrearJsonParser.CrearContext ctx);
	/**
	 * Visit a parse tree produced by {@link CrearJsonParser#fila}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFila(CrearJsonParser.FilaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CrearJsonParser#nombre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNombre(CrearJsonParser.NombreContext ctx);
	/**
	 * Visit a parse tree produced by {@link CrearJsonParser#cantidad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCantidad(CrearJsonParser.CantidadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CrearJsonParser#unidad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnidad(CrearJsonParser.UnidadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CrearJsonParser#valores}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValores(CrearJsonParser.ValoresContext ctx);
	/**
	 * Visit a parse tree produced by {@link CrearJsonParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(CrearJsonParser.ValorContext ctx);
}