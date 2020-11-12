package sample.analizador.promedios;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Visitante extends CsvBaseVisitor {

    @Override
    public String visitArchivo(CsvParser.ArchivoContext ctx) {
        List<Double> porcentaje = new ArrayList<Double>();
        int k= 0;
        for (CsvParser.FilaContext filaContext : ctx.fila()) {
                // Se buscan los porcentajes de los trabajos
                String campo = filaContext.campo().get(0).getText();
                Pattern pattern = Pattern.compile("%");
                Matcher matcher = pattern.matcher(campo);

                // Si encuentra un porcentaje, lo gurda en una lista
                if (matcher.find()){
                    campo = campo.replaceAll("^['\"]*", "");
                    campo = campo.split("%", 2)[0];
                    porcentaje.add(Double.parseDouble(campo)/100);
                }else{
                    // Se buscarán los nombres y las calificaciones de los alumnos
                    List<String> fila_alumno = new ArrayList<String>();

                    campo = campo.replaceAll("^['\"]*", "").replaceAll("['\"]*$", "");
                    String[] alumno = campo.split(",", 9);

                    for(String a: alumno){
                        fila_alumno.add(a);
                    }

                    k++;
                    fila_alumno.remove(0);
                    System.out.print("["+(k)+"] Alumno: "+fila_alumno.remove(0));
                    int j = 0;
                    Double promedio = 0.0;
                    while(j<porcentaje.size()){
                        String calf = fila_alumno.remove(0);
                        if (calf.equals("")){
                            calf="0";
                        }
                        Double i = Double.parseDouble(calf)*(porcentaje.get(j));
                        //System.out.println(i);
                        promedio += i;
                        j++;
                    }
                    System.out.println(", promedio: "+promedio);
                }
            }
        return null;
    }


}
