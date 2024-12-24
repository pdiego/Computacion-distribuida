import java.net.*;
import java.io.*;

/**
* Este ejemplo ilustra las llamadas de metodos basicos para sockets
* Datagrama sin conexion
* El autor original es ML Liu.
*/

public class Ejemplo1Receptor {
	// Una aplicacion que recibe un mensaje utiulizando un socket 
	// datagrama sin conexion
	// Se espera una argumento en la linea de mandato:
	// 1 - Numero del puerto del socket receptor
	// Nota: se debería especificar el mismo numero de puerto del emisor
	// en la ejecucion del comando cuando se ejecute.

	public static void main( String args[]) {
		if (args.length != 1) 
			System.out.println("Este programa requiere 1 argumento para ejecutarse.");
		else {
			int puerto = Integer.parseInt(args[0]);
			final int MAX_LON = 10;
			// Esta es la longitud maxima asumida en octetos
			// del datagrama que se va a recibir.

			try {
				DatagramSocket miSocket = new DatagramSocket(puerto);
				// instancia un socket para recibir los datos
				byte[] almacen = new byte[MAX_LON];
				DatagramPacket datagrama = new DatagramPacket(almacen, MAX_LON);
				miSocket.receive(datagrama);
				String mensaje = new String(almacen);
				System.out.println(mensaje);
				miSocket.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			} // fin de catch
		} // fin else
	} // fin de main
} // fin class