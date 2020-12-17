package sample.analizador.splitJson;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import sample.analizador.ThrowingErrorListener;
import sample.analizador.promedios.Visitante;

import java.nio.charset.StandardCharsets;

public class Split {
    ParseTree arbol;
    public String analizar(String path){
        String salida = null;
        try{
            CharStream input = CharStreams.fromFileName(path, StandardCharsets.UTF_8);
            JsonLexer lexico = new JsonLexer(input);

            lexico.removeErrorListeners();
            lexico.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexico);

            JsonParser sintactico = new JsonParser(tokens);
            sintactico.removeErrorListeners();
            sintactico.addErrorListener(ThrowingErrorListener.INSTANCE);

            this.arbol = sintactico.json();
            Visitante visitas = new Visitante();
            salida = visitas.visit(arbol).toString();
        }catch(Exception e){
            salida = e.toString();
            System.out.println(e.toString());
        }
        return salida;
    }

}
