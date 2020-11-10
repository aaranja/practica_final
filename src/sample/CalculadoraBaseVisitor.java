// Generated from C:/Users/Balboa-PC/Documents/automatas I/Practicafinal/src/sample\Calculadora.g4 by ANTLR 4.8
package sample;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link CalculadoraVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class CalculadoraBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements CalculadoraVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitArchivo(CalculadoraParser.ArchivoContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitHeader(CalculadoraParser.HeaderContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDatos(CalculadoraParser.DatosContext ctx) { return visitChildren(ctx); }
}