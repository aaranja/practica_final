grammar Csv;
archivo: cabecera fila+ ;
cabecera : fila ;

fila : campo (',' campo)* '\r'? '\n' ;

campo
    : TEXTO
    | CADENA
    |
    ;

TEXTO   : ~[,\n\r"]+ ;
CADENA : '"' ('""'|~'"')* '"' ;