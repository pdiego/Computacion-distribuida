# Computacion-distribuida
Ejemplos Computación Distribuida de ML Liu

## API Socket UDP
- Ejemplo1Emisor.java
Una aplicacion que manda un mensaje utilizando un socket datagrama sin conexion

- Ejemplo1Receptor.java
Una aplicacion que recibe un mensaje utilizando un socket datagrama sin conexion


### Paso dos:

- MiSocketDatagrama.java
- Ejemplo2ReceptorEmisor.java 
- Ejemplo2EmisorReceptor.java


Para crear los class
´´´javac Ejemplo2ReceptorEmisor.java MiSocketDatagrama.java´´´
´´´javac Ejemplo2EmisorReceptor.java MiSocketDatagrama.java´´´

para ejecutar programa:

´´´java Ejemplo2EmisorReceptor.java localhost 9090 8181 "Pablo es guapo del todo"´´´
´´´java Ejemplo2ReceptorEmisor.java localhost 8181 9090 "Pedro es presidente"´´´