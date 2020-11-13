package sample;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javax.swing.*;
import java.io.*;
import sample.analizador.CargarGramatica;

public class Controller {

    @FXML private TextArea txtentrada;
    @FXML private Pane output_pane;
    @FXML private ChoiceBox<String> choice_grammar;
    private final SwingNode swingnode2 = new SwingNode();
    File seleccionado;
    String ruta;
    String nombre_gramatica="carbohidratos.Calorias"; // default

    public void analizar (MouseEvent evento) throws IOException {

       String path_input=seleccionado.getPath();
        String frase=txtentrada.getText();
        FileWriter escribir= new FileWriter(path_input);
        for (int i=0;i<frase.length();i++){
            escribir.write(frase.charAt(i));}
        escribir.close();

        // Se consegue la salida de la terminal
        JTextArea txtConsole = new JTextArea(200,40);
        PrintStream out = new PrintStream( new TextAreaOutputStream( txtConsole ) );
        System.setOut( out );
        System.setErr( out );

        // Crear panel de salida
        JPanel output = new JPanel();
        output.setBounds(0,0,100,100);
        output.add(txtConsole);

        nombre_gramatica = choice_grammar.getValue();

       // Ejecutar la gramática indicada
        CargarGramatica gramatica = new CargarGramatica();
        gramatica.invocarClase(nombre_gramatica, "analizar", path_input);

        // Verifica si el panel de javaFx esta vacío, remueve su contenido
       if (!output_pane.getChildren().isEmpty()){
            output_pane.getChildren().remove(swingnode2);
        }

        // Carga el contenido en el panel de JavaFX
        swingnode2.setContent(output);
        output_pane.getChildren().add(swingnode2);
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
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("All Files", "*.*");
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

    public void limpiarEntrada(MouseEvent evento){
        txtentrada.setText("");
    }

}