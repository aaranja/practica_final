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
import java.nio.charset.StandardCharsets;

import sample.analizador.CargarGramatica;

public class Controller {
    @FXML private TextArea txtentrada;
    @FXML private Pane output_pane;
    @FXML private ChoiceBox<String> choice_grammar;
    private final SwingNode swingnode2 = new SwingNode();
    File seleccionado;
    String nombre_gramatica="carbohidratos.Calorias"; // default
    JTextArea txtConsole = new JTextArea(200,40);
    String folder_path = null;

    public void analizar (MouseEvent evento) throws IOException {
        txtConsole.setText("");
        String path_input="t.expr";
        String frase=txtentrada.getText();
        FileWriter escribir= new FileWriter(path_input, StandardCharsets.UTF_8);
        for (int i=0;i<frase.length();i++){
            escribir.write(frase.charAt(i));}
        escribir.close();

        // Ejecutar la gramática indicada
        nombre_gramatica = choice_grammar.getValue();
        CargarGramatica gramatica = new CargarGramatica();
        String salida_grammar = gramatica.invocarClase(nombre_gramatica, "analizar", path_input);
        System.out.println(salida_grammar);

        // Crear panel de salida
        JPanel output = new JPanel();
        output.setBounds(0,0,100,100);
        txtConsole.setText(salida_grammar);
        output.add(txtConsole);

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
            fc.setInitialDirectory(new File(folder_path));
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
       try{
           FileChooser fc = new FileChooser();
           fc.setInitialDirectory(new File(folder_path));

           if(!txtConsole.getText().equals("")){
               switch (nombre_gramatica) {
                   case "carbohidratos.Calorias":
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
                       FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("Archivos (*.csv)","*.csv");
                       fc.getExtensionFilters().add(filter2);
                       File seleccionado = fc.showSaveDialog(null);
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
       }catch(Exception error){
           System.out.println(error.toString());
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
        try{
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("c:\\"));
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Archivos (*.txt)","*.txt");
            FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("Archivos (*.csv)","*.csv");
            fc.getExtensionFilters().add(filter);
            fc.getExtensionFilters().add(filter2);
            seleccionado = fc.showOpenDialog(null);
            if (seleccionado != null) {
                String pathFile = seleccionado.getAbsolutePath();
                // get dynamic path
                folder_path = pathFile.substring(0, pathFile.lastIndexOf('\\')+1);

                // open file and get text data

                FileReader entrada  = new FileReader(pathFile, StandardCharsets.UTF_8);
                int c=0;
                String frase="";
                while(c!=-1){
                    c=entrada.read();
                    char letra = (char) c;
                    if (c!=-1 ){
                        frase=frase+letra;
                    }
                }
                entrada.close();
                txtentrada.setText(frase);

            }
        }catch(Exception error){
            System.out.println(error.toString());
        }

    }

    public void limpiarEntrada(MouseEvent evento){
        txtentrada.setText("");
    }

}
