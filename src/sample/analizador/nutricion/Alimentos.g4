grammar Alimentos;

archivo: alimento+;

alimento: (cantidad NOMBRE);
cantidad: NUMERO|gramos;
gramos : NUMERO GRAMOS;

//--tokens--
NUMERO: [0-9]+;
GRAMOS: 'gr';
NOMBRE : ~[, \t\r\n0-9]+;
ESPACIOS:   [ \t\r\n]+ -> skip;