grammar Json;
json: multiObject | array;
multiObject : object (',' object)*;
object: '{' pair nombre '}'
      | '{' '}'
      ;
nombre: ',' pair #valor;
pair: STRING ':' value;
value: STRING
     | NUMBER
     | object
     | array
     | 'true'
     | 'false'
     | 'null';
array: '[' value (',' value)* ']'
     | '[' ']'
     ;

fragment INT: '0' | [1-9] [0-9]*;
fragment EXP: [Ee] [+\-]? INT;

STRING: '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' (["\\/bfnrt] | UNICODE);
fragment UNICODE : 'u' HEX HEX HEX HEX;
fragment HEX : [0-9a-fA-F];

NUMBER: [0-9]+;
WS: [ \t\n\r]+ -> skip;