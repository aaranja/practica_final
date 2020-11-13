package sample.analizador.promedios;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.nio.charset.StandardCharsets;

public class Calificaciones {
    ParseTree arbol;
    public void analizar(String path){
        try{

            CharStream input = CharStreams.fromFileName(path, StandardCharsets.UTF_8);
            CsvLexer lexico = new CsvLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexico);
            CsvParser sintactico = new CsvParser(tokens);
            this.arbol = sintactico.archivo();
            sample.analizador.promedios.Visitante visitas = new Visitante();
            visitas.visit(arbol);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
