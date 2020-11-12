package sample.analizador;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CargarGramatica extends ClassLoader {
    String path_class = "sample.analizador.";
    public void invocarClase(String nombreClase, String nombreMetodo, String path){
        try{
            // Conseguir la clase por el nombre y su package
            ClassLoader classLoader = this.getClass().getClassLoader();
            Class claseCargada = classLoader.loadClass(path_class+nombreClase);

            // Crea una nueva instancia de la clase cargada
            Constructor constructor = claseCargada.getConstructor();
            Object gramatica = constructor.newInstance();

            // Conseguir el método
            Method visita = claseCargada.getMethod(nombreMetodo,String.class);
            visita.invoke(gramatica, path);
        }catch (Exception a) {
            a.printStackTrace();
        }
    }

}
