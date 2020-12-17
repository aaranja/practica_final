package sample.analizador.splitJson;

import javax.json.Json;

public class Visitante extends JsonBaseVisitor{
    @Override public String visitJson(JsonParser.JsonContext ctx) {
        String resultado = "";
        String tab = "\t";

        //System.out.println(ctx.multiObject().object());;




        return resultado;
    }

}
