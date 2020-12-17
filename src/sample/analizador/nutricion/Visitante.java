package sample.analizador.nutricion;

import javax.json.*;
import java.io.FileReader;
import java.util.AbstractMap;

public class Visitante extends AlimentosBaseVisitor {

    @Override public String visitArchivo(AlimentosParser.ArchivoContext ctx) {
        String ruta_json = "src\\sample\\analizador\\nutricion\\alimentos.json";
        String salida = "";
        Double cantidad = null;
        String nombre_alimento = null;
        Double total_calorias=0.0;
        Double calorias = null;
        String missing = "";
        JsonObject plato= null;
        JsonObject dato3= null;
        JsonObject platillo;

        try{
            JsonReader rdr = Json.createReader(new FileReader(ruta_json));
            JsonObject obj = rdr.readObject();

            for(AlimentosParser.AlimentoContext alimento: ctx.alimento()){
                /* Conseguir el nombre del alimento y convertir la primera letra
                en mayúscula y el resto en minúscula */
                nombre_alimento = alimento.nombre().getText();
                nombre_alimento = nombre_alimento.toLowerCase();
                nombre_alimento = nombre_alimento.substring(0, 1).toUpperCase() +
                        nombre_alimento.substring(1);

                /* Conseguir los gramos o porciones */
                if(alimento.cantidad().NUMERO() !=null){
                    cantidad = Double.parseDouble(alimento.cantidad().NUMERO().getText())*100;
                }else cantidad = Double.parseDouble(alimento.cantidad().gramos().NUMERO().getText());

                /* Buscar en el JSON el nombre del alimento en cada uno de los platillos */

                /* Iterar cada tipo de alimento consiguiendo todos las llaves del json*/
                for(String tipo_plato: obj.keySet()){
                    platillo = (JsonObject) obj.get(tipo_plato);
                    /* Iterar sobre cada alimento consiguiente todas la llaves*/
                    for(String alimento2 : platillo.keySet() ){
                        /* Conseguir caada valor de alimento*/
                        System.out.println(tipo_plato+" - "+ alimento2+ ": "+ platillo.get(alimento2));
                    }
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
