package sample.analizador.promedios;
import java.util.ArrayList;
import java.util.List;
public class Visitante extends CsvBaseVisitor {

    @Override
    public String visitArchivo(CsvParser.ArchivoContext ctx) {

        List<Double> porcentaje = new ArrayList<Double>();

        List<String> listCabecera = new ArrayList<>();
        for(CsvParser.CampoContext campoCabecera : ctx.cabecera().fila().campo()){
            listCabecera.add(campoCabecera.getText());
        }
        listCabecera.remove(0); // remover 'N'
        listCabecera.remove(0); // remover 'nombre'

        // conseguir porcentajes

        for(String evaluacion : listCabecera){
            // quitar comillas si el campo tiene ,
            evaluacion = evaluacion.replace("\"", "");
            // se consigue el porcentaje y remueve el char '%'
            int index = evaluacion.lastIndexOf(" ");
            evaluacion = evaluacion.substring(index+1).replace("%","");
            // agregar el porcentaje a la lista
            porcentaje.add(Double.parseDouble(evaluacion)/100);
        }

        // recorre la lista de filas del archivo
        for (CsvParser.FilaContext filaContext : ctx.fila()) {
            List<String> fila_alumno = new ArrayList<String>();

            // recorre la lista de campos de la fila actual
            for (CsvParser.CampoContext campoContext : filaContext.campo()){
                fila_alumno.add(campoContext.getText());
            }

            String indice = "["+fila_alumno.remove(0)+"]";
            String nombre = fila_alumno.remove(0);
            Double promedio = 0.0;
            int k = 0;
            for(String calificacion: fila_alumno){
                calificacion = calificacion.replace("\"", "").replace(",",".");
                calificacion = calificacion.equals("") ? "0.0" : calificacion;
                Double calNum = Double.parseDouble(calificacion);
                // sumar al promedio el porcentaje por la calificación
                promedio += calNum*porcentaje.get(k);
                k++;
            }
            // imprimir resultado del alumno
            System.out.println(indice+" "+nombre+" "+promedio);
            fila_alumno.clear();

        }
        return null;
    }


}
