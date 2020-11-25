// Generated from C:/Users/fidxl/dev/automatas_2/practica_final/src/sample/analizador/nutricion\Alimentos.g4 by ANTLR 4.8
package sample.analizador.nutricion;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlimentosParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlimentosVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#archivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchivo(AlimentosParser.ArchivoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#alimento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlimento(AlimentosParser.AlimentoContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#cantidad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCantidad(AlimentosParser.CantidadContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlimentosParser#gramos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGramos(AlimentosParser.GramosContext ctx);
}