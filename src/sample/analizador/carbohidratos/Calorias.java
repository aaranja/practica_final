package sample.analizador.carbohidratos;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import sample.analizador.ThrowingErrorListener;


public class Calorias {
    ParseTree arbol;
    public String analizar(String path){
        String salida = null;
       try{
           CharStream input = CharStreams.fromFileName(path);

           CaloriasLexer lexico = new CaloriasLexer(input);
           // cambiar la clase que maneja el error
           lexico.removeErrorListeners();
           lexico.addErrorListener(ThrowingErrorListener.INSTANCE);

           CommonTokenStream tokens = new CommonTokenStream(lexico);
           CaloriasParser sintactico = new CaloriasParser(tokens);
           sintactico.removeErrorListeners();
           sintactico.addErrorListener(ThrowingErrorListener.INSTANCE);

           this.arbol = sintactico.archivo();
           Visitante visitas = new Visitante();
           salida = visitas.visit(arbol).toString();
       }catch(Exception e){
           salida = e.toString();
           System.out.println(e.toString());
        }
       return salida;
    }

}


