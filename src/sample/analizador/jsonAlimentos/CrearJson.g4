grammar CrearJson;

crear: fila+;
fila : nombre ' ' cantidad ' ' unidad ' ' valores+;
nombre : TEXTO (' ' TEXTO)* ;
cantidad:  (INT '/' INT) | INT;
unidad : (TEXTO (' ' TEXTO)*) | CHAR;

valores: valor (' ' valor)*;
valor: FLOAT | INT | 'ND' | 'O.O' | 'NO' | 'o.o' ;


FLOAT
 : [0-9]+ '.' {_input.LA(1) != '.'}?
 | [0-9]* '.' [0-9]+
 ;

CHAR: [A-Za-z];

INT
 : [0-9]+
 ;

 TEXTO: ~[ ,/\n\r"]+ ;

 WS: [ \t\n\r]+ -> skip;


