package sample.analizador.jsonAlimentos;

import sample.analizador.nutricion.AlimentosParser;

import javax.json.Json;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Visitante extends CrearJsonBaseVisitor{
    String salida = "";
    @Override
    public Object visitCrear(CrearJsonParser.CrearContext ctx) {
        for(CrearJsonParser.FilaContext fp : ctx.fila()){

            String datos = "\"" +fp.nombre().getText()+"\" : { \n\t" ;

            String cantidad = fp.cantidad().getText();

            String div = "/";
            Pattern pat = Pattern.compile(div);
            Matcher matcher = pat.matcher(cantidad);
            if(matcher.find()) datos += "\"cantidad\": "+ parse(fp.cantidad().getText()) +",\n\t";
            else datos += "\"cantidad\": "+ fp.cantidad().getText() +",\n\t";
            datos += "\"unidad\": "+ fp.unidad().getText() +",\n\t";
            datos += "\"peso bruto\": "+ fp.valores().get(0).getChild(0).getText()+",\n\t";
            datos += "\"peso neto\": "+ fp.valores().get(0).getChild(2).getText()+",\n\t";
            datos += "\"calorias\": "+ fp.valores().get(0).getChild(4).getText()+",\n\t";
            datos += "\"proteinas\": "+ fp.valores().get(0).getChild(6).getText()+",\n\t";
            datos += "\"lipidos\": "+ fp.valores().get(0).getChild(8).getText()+",\n\t";
            datos += "\"carbohidratos\": "+ fp.valores().get(0).getChild(10).getText()+",\n\t";
            datos += "},";
            salida += datos + "\n";
        }
        return salida;
    }

    double parse(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }
}
