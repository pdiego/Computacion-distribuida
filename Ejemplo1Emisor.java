import java.net.*;
import java.io.*;

/**
* Este ejemplo ilustra las llamadas de metodos basicos para sockets
* Datagrama sin conexion
* El autor original es ML Liu.
*/

public class Ejemplo1Emisor {
	// Una aplicacion que manda un mensaje utilizando un socket 
	// datagrama sin conexion.
	// Se espera tres argumentos en la linea de mandato, en orden:
	// 1 - Nombre del dominio, o dirección IP del receptor.
	// 2 - Numero de puerto del socket del receptor
	// 3 - Mensaje o cadena para enviar

	public static void main (String[ ] args) {
		if (args.length != 3) 
			System.out.println("Este programa requiere 3 argumentos para ejecutarse.");
		else {
			try {
				InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
				int puertoReceptor = Integer.parseInt( args[1]);
				String mensaje = args[2];
	
				// instancia un socket datagrama para enviar datos.
				DatagramSocket miSocket = new DatagramSocket();
				byte[] almacen = mensaje.getBytes();

				DatagramPacket datagrama = new DatagramPacket(almacen, almacen.length, maquinaReceptora, puertoReceptor);
				miSocket.send(datagrama);
				miSocket.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			} // fin catch
		} // Fin de ELSE

	} // Fin de main
} // Fin de class