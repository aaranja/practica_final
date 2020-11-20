package sample.analizador;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CargarGramatica extends ClassLoader {
    String path_class = "sample.analizador.";
    public String invocarClase(String nombreClase, String nombreMetodo, String path){
        String salida = null;
        try{
            // Conseguir la clase por el nombre y su package
            ClassLoader classLoader = this.getClass().getClassLoader();
            Class claseCargada = classLoader.loadClass(path_class+nombreClase);

            // Crea una nueva instancia de la clase cargada
            Constructor constructor = claseCargada.getConstructor();
            Object gramatica = constructor.newInstance();

            // Conseguir
            Method visita = claseCargada.getMethod(nombreMetodo,String.class);
            salida = visita.invoke(gramatica, path).toString();
        }catch (Exception a) {
            a.printStackTrace();
        }
        return salida;
    }

}
