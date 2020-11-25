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
        Integer cantidad = null;
        String nombre_alimento = null;
        Pair<String, Integer> dato ;
        Double total_calorias=0.0;
        Integer calorias = null;
        JsonObject plato= null;

        try{
            JsonReader rdr = Json.createReader(new FileReader("C:\\Users\\fidxl\\dev\\automatas_2\\practica_final\\src\\sample\\analizador\\nutricion\\alimentos.json"));
            JsonObject obj = rdr.readObject();


            for(AlimentosParser.AlimentoContext alimento: ctx.alimento()){
                nombre_alimento = alimento.NOMBRE().getText();
                if(alimento.cantidad().NUMERO() !=null){
                    cantidad = Integer.parseInt(alimento.cantidad().NUMERO().getText())*100;
                }else{
                    cantidad = Integer.parseInt(alimento.cantidad().gramos().NUMERO().getText());
                }
                for (JsonValue objPlato : obj.values()){
                    plato = (JsonObject) objPlato;
                    JsonValue datos = plato.get(nombre_alimento);
                    if(datos!=null){
                        calorias = Integer.valueOf(datos.toString());
                        break;
                    }

                }

                calorias = (cantidad * calorias)/100;
                total_calorias += calorias;
                System.out.println("Las calorias de "+nombre_alimento+" son: "+ calorias+ "kcal");
                //getCalorias(nombre_alimento, cantidad);
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }

        salida = ("El total de calorias es: "+total_calorias+" kcal");



        return salida;
    }

    public String getCalorias(String nombre, Integer cantidad){

        return "";
    }



}
