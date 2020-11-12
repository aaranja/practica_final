package sample.analizador.carbohidratos;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Calorias {
    ParseTree arbol;
    public void analizar(String path){
       try{
           CharStream input = CharStreams.fromFileName(path);
           CaloriasLexer lexico = new CaloriasLexer(input);
           CommonTokenStream tokens = new CommonTokenStream(lexico);
           CaloriasParser sintactico = new CaloriasParser(tokens);
           this.arbol = sintactico.archivo();
           Visitante visitas = new Visitante();
           visitas.visit(arbol);
       }catch(Exception e){
           System.out.println(e.toString());
        }
    }

}
