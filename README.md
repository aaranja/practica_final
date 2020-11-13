# Práctica final

### Pasos para configurar el proyecto
- **Configuración de librerías**
  - Ir a *File > Project Structure > Libraries > New Project Library > Java*
  - Añadir librerías de JavaFX y ANTLR4
    - *Add > "path-to-javaFX\lib"*
    - *Add > "path-to-antlr4.jar"*

- **Configuración de ejecución**
  - Ir a *Run > Edit Configurations... > Templates > Application*
  - Configurar en Main Class 
    - *sample.Main*
  - Configurar en las opciones VM
    - *--module-path "path-to-javaFX\lib" --add-modules=ALL-MODULE-PATH*

#### Listo
