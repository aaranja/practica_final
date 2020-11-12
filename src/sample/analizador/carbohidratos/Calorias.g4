grammar Calorias;

archivo: cabecera persona+;

cabecera: ID  'CARBOHIDRATOS' 'PROTEINAS' 'GRASAS' #header;

persona: (ID NUM GRAMOS NUM GRAMOS NUM GRAMOS)+ #datos;


GRAMOS: 'g';
ID:[a-zA-Z]+;
NUM:[0-9]+;
ESPACIOS:   [ \t\r\n]+ -> skip;