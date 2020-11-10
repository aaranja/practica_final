// Generated from C:/Users/Balboa-PC/Documents/automatas I/Practicafinal/src/sample\Calculadora.g4 by ANTLR 4.8
package sample;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculadoraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculadoraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculadoraParser#archivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchivo(CalculadoraParser.ArchivoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code header}
	 * labeled alternative in {@link CalculadoraParser#cabecera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(CalculadoraParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code datos}
	 * labeled alternative in {@link CalculadoraParser#persona}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatos(CalculadoraParser.DatosContext ctx);
}