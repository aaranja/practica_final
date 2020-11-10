package sample;

public class MyVisitor extends CalculadoraBaseVisitor {
    @Override public String visitDatos(CalculadoraParser.DatosContext ctx)
    {
        int contador = 0;
        int pos = 1;
        for (int i = 0; i < ctx.ID().size(); i++)
        {
            int car = Integer.parseInt(ctx.NUM(contador).toString())*4;
            int pro = Integer.parseInt(ctx.NUM(contador+1).toString())*4;
            int gra = Integer.parseInt(ctx.NUM(contador+2).toString())*9;
            int calorias=car+pro+gra;
            contador=contador+3;
            System.out.println("["+pos+"]"+ctx.ID(i) +" "+calorias+" kcal");
            pos++;
        }
        return null;
    }
}
