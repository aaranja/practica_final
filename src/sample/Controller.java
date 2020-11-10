package sample;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class Controller {

    @FXML private TextArea txtentrada;
    @FXML private TextArea txtsalida;
    @FXML private Pane pane;
    @FXML private Pane pane_errores;
    private SwingNode swingnode = new SwingNode();
    private SwingNode swingnode2 = new SwingNode();
    File seleccionado;
    String ruta;


    public void prueba (MouseEvent evento) throws IOException {
        String entrada="\\t.txt";
        String frase=txtentrada.getText();
        FileWriter escribir= new FileWriter(entrada);
        for (int i=0;i<frase.length();i++){
            escribir.write(frase.charAt(i));}
        escribir.close();

        CharStream input = CharStreams.fromFileName("\\t.txt");
        CalculadoraLexer lexico = new CalculadoraLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexico);
        CalculadoraParser sintactico = new CalculadoraParser(tokens);
        ParseTree tree = sintactico.archivo();

        MyVisitor visitas = new MyVisitor();
        visitas.visit(tree);

        JTextArea txtConsole = new JTextArea(200,40);
        PrintStream out = new PrintStream( new TextAreaOutputStream( txtConsole ) );
        System.setOut( out );
        System.setErr( out );
        JPanel panelerr = new JPanel();
        panelerr.setBounds(0,0,100,100);
        panelerr.add(txtConsole);

        swingnode2.setContent(panelerr);
        if (pane_errores.getChildren().contains(swingnode2)){
            pane_errores.getChildren().remove(swingnode2);

        }
        pane_errores.getChildren().add(swingnode2);

        /*TreeViewer tv = new TreeViewer(Arrays.asList(sintactico.getRuleNames()),tree);
        JPanel panel = new JPanel();
        panel.setBounds(0,0,100,100);
        panel.add(tv);
        panel.setVisible(true);
        panel.updateUI();

        swingnode.setContent(panel);
        if (pane.getChildren().contains(swingnode)){
            pane.getChildren().remove(swingnode);

        }
        pane.getChildren().add(swingnode);
        txtsalida.setText(tree.toStringTree(sintactico));*/
    }

    public void guardar (ActionEvent evento) throws IOException{
        if(seleccionado != null){
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\"));
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Archivos (*.txt)","*.txt");
            fc.getExtensionFilters().add(filter);
            File seleccionado = fc.showSaveDialog(null);
            String salida = txtentrada.getText();
            FileWriter escritura  = new FileWriter(seleccionado);
            for(int i=0;i<salida.length();i++)
            {
                escritura.write(salida.charAt(i));
            }
            escritura.close();
        }
    }

    public void guardarCambios (ActionEvent evento) throws IOException{
       if( seleccionado != null) {
           String salida = txtentrada.getText();
           FileWriter escritura = new FileWriter(seleccionado);
           for (int i = 0; i < salida.length(); i++) {
               escritura.write(salida.charAt(i));
           }
           escritura.close();
       }
    }

    public void abrir (ActionEvent evento) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("c:\\"));
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Archivos (*.txt)","*.txt");
        fc.getExtensionFilters().add(filter);
        seleccionado = fc.showOpenDialog(null);
        if (seleccionado != null)
        {
            FileReader entrada  = new FileReader(seleccionado.getAbsolutePath());
            int c=0;
            String frase="";
            while(c!=-1)
            {
                c=entrada.read();
                char letra = (char) c;
                if (c!=-1 ){

                    frase=frase+letra;
                }


            }
            entrada.close();
            txtentrada.setText(frase);

        }

    }

    public void limpiarEntrada(MouseEvent evento)
    {
        txtentrada.setText("");
    }



}
