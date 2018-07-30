# LCD refactor

 
Objetivo: Programa que imprime números en estilo de una pantalla LCD 

Entrada: La entrada contiene varias líneas. Cada línea contiene 2 números separados por coma. El primer número representa el tamaño de la impresión (entre 1 y 10, esta variable se llama “size”). El segundo número es el número a mostrar en la pantalla. Para terminar, se debe digitar 0,0. Esto terminará la aplicación.

Salida: Imprimir los números especificados usando el caracter “-“ para los caracteres horizontales, y “|” para los verticales. Cada dígito debe ocupar exactamente size+2 columnas y 2*size + 3 filas. 

Entre cada impresión debe haber una línea blanca. 
 
Ejemplo: 
Entrada: 
2,12345 
3,67890 
0,0 
   
Salida:   
 <pre>  
   _ _  _ _        _ _
|     |    | |  | |
|  _ _| _ _| |__| |_ _
| |        |    |     |
| |_ _  _ _|    |  _ _|

 _ _ _  _ _ _   _ _ _   _ _ _   _ _ _ 
|            | |     | |     | |     |
|            | |     | |     | |     |
|_ _ _       | |_ _ _| |_ _ _| |     |
|     |      | |     |       | |     |
|     |      | |     |       | |     |
|_ _ _|      | |_ _ _|  _ _ _| |_ _ _|

</pre>

## A. Funcionalidad.
El programa se ejecuta de acuerdo a la solicitud mencionada anteriormente

## B. Elegancia de la solución.
El codigo ha sido refactorizado manteniendo una alta cohesion y un bajo acoplamiento

## C. Orientación a la calidad y mantenibilidad.
Debido a la alta cohesion y bajo acoplamiento, es facil hacerle mantenimiento en una etapa posterior. 

Por ejemplo, si se desea no ejecutar en consola pero sí en pantalla es facil hacer la transicion.
Han sido implementados patrones de diseño:
Singleton: Un servicio único que lee la consola con el fin de evitar el error que sucede al abrir de nuevo una consola cerrada. Esto permite separar la lectura de la cantidad de líneas y la lectura de los comandos (tamaño y mensaje a imprimir).

Abstract Factory: Como los caracteres tienen los mismos atributos, y teniendo en cuenta que los segmentos de la matriz de impresión son los mismos (7 en total), se separa la creación de los caracteres de la creación de la matriz de impresión. Esto permite implementar posteriormente otros caracteres que se deseen imprimir (letras por ejemplo). Además brinda mas elegancia y claridad en el codigo dado. 