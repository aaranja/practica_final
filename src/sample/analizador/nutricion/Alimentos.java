package sample.analizador.nutricion;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import sample.analizador.ThrowingErrorListener;

import java.nio.charset.StandardCharsets;

public class Alimentos {
    ParseTree arbol;
    public String analizar(String path){
        String salida = null;
        try{
            CharStream input = CharStreams.fromFileName(path, StandardCharsets.UTF_8);
            AlimentosLexer lexico = new AlimentosLexer(input);
            lexico.removeErrorListeners();
            lexico.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexico);

            AlimentosParser sintactico = new AlimentosParser(tokens);
            sintactico.removeErrorListeners();
            sintactico.addErrorListener(ThrowingErrorListener.INSTANCE);

            this.arbol = sintactico.archivo();
            sample.analizador.nutricion.Visitante visitas = new Visitante();
            salida = visitas.visit(arbol).toString();
        }catch(Exception e){
            salida = e.toString();
            System.out.println(e.toString());
        }
        return salida;
    }

}