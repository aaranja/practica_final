// Generated from Csv.g4 by ANTLR 4.8
package sample.analizador.promedios;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CsvParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CsvVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CsvParser#archivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArchivo(CsvParser.ArchivoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#cabecera}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCabecera(CsvParser.CabeceraContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#fila}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFila(CsvParser.FilaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CsvParser#campo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampo(CsvParser.CampoContext ctx);
}