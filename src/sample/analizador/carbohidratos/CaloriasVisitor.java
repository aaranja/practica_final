// Generated from Calorias.g4 by ANTLR 4.8
package sample.analizador.carbohidratos;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CaloriasParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CaloriasVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CaloriasParser#archivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchivo(CaloriasParser.ArchivoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code header}
	 * labeled alternative in {@link CaloriasParser#cabecera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(CaloriasParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code datos}
	 * labeled alternative in {@link CaloriasParser#persona}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatos(CaloriasParser.DatosContext ctx);
}