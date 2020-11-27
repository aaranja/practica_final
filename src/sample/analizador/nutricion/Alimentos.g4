grammar Alimentos;

archivo: alimento+;

alimento: (cantidad ' ' nombre);
cantidad:  NUMERO | gramos;
gramos : NUMERO GRAMOS;
nombre : TEXTO (' ' TEXTO)*;

//--tokens--
NUMERO: [0-9]+;
GRAMOS: 'gr';
TEXTO :  ~[ ,\t\r\n0-9]+;
IGNORAR:   [ \t\r\n]+ -> skip;