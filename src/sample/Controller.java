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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sample.analizador.CargarGramatica;

public class Controller {

    @FXML private TextArea txtentrada;
    @FXML private TextArea txtsalida;
    @FXML private Pane pane;
    @FXML private Pane output_pane;
    @FXML private ChoiceBox<String> choice_grammar;
    private SwingNode swingnode = new SwingNode();
    private SwingNode swingnode2 = new SwingNode();
    File seleccionado;
    String nombre_gramatica="carbohidratos.Calorias"; // default
    JTextArea txtConsole = new JTextArea(200,40);

    public void analizar (MouseEvent evento) throws IOException {

        txtConsole.setText("");
        String path_input="t.expr";
        String frase=txtentrada.getText();
        FileWriter escribir= new FileWriter(path_input);
        for (int i=0;i<frase.length();i++){
            escribir.write(frase.charAt(i));}
        escribir.close();

        // Se consegue la salida de la terminal
        PrintStream out = new PrintStream( new TextAreaOutputStream( txtConsole ) );
        System.setOut( out );
        System.setErr( out );

        // Crear panel de salida
        JPanel output = new JPanel();
        output.setBounds(0,0,100,100);
        output.add(txtConsole);

        nombre_gramatica = choice_grammar.getValue().toString();

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
            fc.setInitialDirectory(new File("C:\\practicafinal"));
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Archivos (*.txt)","*.txt");
            FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("Archivos (*.csv)","*.csv");
            fc.getExtensionFilters().add(filter);
            fc.getExtensionFilters().add(filter2);
            File seleccionad = fc.showSaveDialog(null);
            if (seleccionad!=null)
            {
                String salida = txtentrada.getText();
                FileWriter escritura  = new FileWriter(seleccionad);
                for(int i=0;i<salida.length();i++)
                {
                    escritura.write(salida.charAt(i));
                }
                escritura.close();
            }
        }
    }

    public void guardarSalida (ActionEvent evento) throws IOException{
        if(!txtConsole.getText().equals("")){
           switch (nombre_gramatica)
           {
               case "carbohidratos.Calorias":
                   FileChooser fc = new FileChooser();
                   fc.setInitialDirectory(new File("C:\\practicafinal"));
                   FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Archivos (*.txt)","*.txt");
                   fc.getExtensionFilters().add(filter);
                   File seleccionad = fc.showSaveDialog(null);
                   if (seleccionad!=null)
                   {
                       String salida = txtConsole.getText();
                       FileWriter escritura  = new FileWriter(seleccionad);
                       for(int i=0;i<salida.length();i++)
                       {
                           escritura.write(salida.charAt(i));
                       }
                       escritura.close();
                   }
                   break;
               case "promedios.Calificaciones":
                   FileChooser fc2 = new FileChooser();
                   fc2.setInitialDirectory(new File("C:\\practicafinal"));
                   FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("Archivos (*.csv)","*.csv");
                   fc2.getExtensionFilters().add(filter2);
                   File seleccionado = fc2.showSaveDialog(null);
                   if(seleccionado!=null) {
                       String salida = txtConsole.getText();
                       FileWriter escritura = new FileWriter(seleccionado);

                       escritura.write("Numero");
                       escritura.write(",");
                       escritura.write("Nombre de estudiante");
                       escritura.write(",");
                       escritura.write("Promedio \n");

                       for (String fila : salida.split("\\n")) {

                           int sad = fila.lastIndexOf(" ");
                           String promedio = ",".concat(fila.substring(sad + 1));
                           String nombre = fila.substring(0, sad);
                           nombre = nombre.replace("] ", "],");
                           String resultado = nombre.concat(promedio);
                           escritura.write(resultado);
                       }
                       escritura.close();
                   }
                   break;
           }

        }
    }//prueba 2

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
        fc.setInitialDirectory(new File("c:\\practicafinal"));
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Archivos (*.txt)","*.txt");
        FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("Archivos (*.csv)","*.csv");
        fc.getExtensionFilters().add(filter);
        fc.getExtensionFilters().add(filter2);
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
