package sample.analizador.nutricion;

import javafx.util.Pair;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.swing.text.html.parser.AttributeList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Visitante extends AlimentosBaseVisitor {



    @Override public String visitArchivo(AlimentosParser.ArchivoContext ctx) {

        String salida = "";
        Double cantidad = null;
        String nombre_alimento = null;
        Double total_calorias=0.0;
        Double calorias = null;
        String missing = "";
        JsonObject plato= null;

        try{
            JsonReader rdr = Json.createReader(new FileReader("src\\sample\\analizador\\nutricion\\alimentos.json"));
            JsonObject obj = rdr.readObject();


            for(AlimentosParser.AlimentoContext alimento: ctx.alimento()){
                /* Conseguir el nombre del alimento y convertir la primera letra en mayúscula y el resto en minúscula*/
                nombre_alimento = alimento.nombre().getText();
                nombre_alimento = nombre_alimento.toLowerCase();
                nombre_alimento = nombre_alimento.substring(0, 1).toUpperCase() + nombre_alimento.substring(1);

                if(alimento.cantidad().NUMERO() !=null){
                    cantidad = Double.parseDouble(alimento.cantidad().NUMERO().getText())*100;
                }else{
                    cantidad = Double.parseDouble(alimento.cantidad().gramos().NUMERO().getText());
                }
                for (JsonValue objPlato : obj.values()){
                    plato = (JsonObject) objPlato;
                    JsonValue datos = plato.get(nombre_alimento);
                    if(datos!=null){
                        calorias = Double.valueOf(datos.toString());
                        break;
                    }

                }

               if(calorias != null){
                   calorias = (cantidad * calorias)/100;
                   total_calorias += calorias;
                   System.out.println("Las calorias de "+nombre_alimento+" son: "+ calorias+ "kcal");
                   //getCalorias(nombre_alimento, cantidad);
                   calorias = null;
               }else{
                   missing += "No encontrado: "+ nombre_alimento+"\n";
               }
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }

        salida = (missing+"El total de calorias es: "+total_calorias+" kcal");

        return salida;
    }



}
