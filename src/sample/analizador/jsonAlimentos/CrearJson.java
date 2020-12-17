package sample.analizador.jsonAlimentos;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import sample.analizador.ThrowingErrorListener;


public class CrearJson {
    ParseTree arbol;
    public String analizar(String path){
        String salida = null;
        try{
            CharStream input = CharStreams.fromFileName(path);

            CrearJsonLexer lexico = new CrearJsonLexer(input);
            // cambiar la clase que maneja el error
            lexico.removeErrorListeners();
            lexico.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexico);
            CrearJsonParser sintactico = new CrearJsonParser(tokens);
            sintactico.removeErrorListeners();
            sintactico.addErrorListener(ThrowingErrorListener.INSTANCE);

            this.arbol = sintactico.crear();
            Visitante visitas = new Visitante();
            salida = visitas.visit(arbol).toString();
        }catch(Exception e){
            salida = e.toString();
            System.out.println(e.toString());
        }
        return salida;
    }

}
