package sample.analizador.promedios;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import sample.analizador.ThrowingErrorListener;

import java.nio.charset.StandardCharsets;


public class Calificaciones {
    ParseTree arbol;
    public String analizar(String path){
        String salida = null;
        try{
            CharStream input = CharStreams.fromFileName(path, StandardCharsets.UTF_8);
            CsvLexer lexico = new CsvLexer(input);

            lexico.removeErrorListeners();
            lexico.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexico);

            CsvParser sintactico = new CsvParser(tokens);
            sintactico.removeErrorListeners();
            sintactico.addErrorListener(ThrowingErrorListener.INSTANCE);

            this.arbol = sintactico.archivo();
            sample.analizador.promedios.Visitante visitas = new Visitante();
            salida = visitas.visit(arbol).toString();
        }catch(Exception e){
            salida = e.toString();
            System.out.println(e.toString());
        }
        return salida;
    }
}



