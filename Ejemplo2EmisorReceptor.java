import java.net.*;

/**
*	Este ejemplo ilustra un proceso que envía y después recibe
*	utilizando un socket datagrama.
*	@author ML Lui.
*/

public class Ejemplo2EmisorReceptor {
	//	Una aplicacion que manda y que despues recibe un mensaje utilizando
	// 	un socket datagrama sin conexion.
	//	Se esperan 4 parametros en la ejecucion por consola de comandos, en orden:
	//	1 - Nombre de dominio o direccion IP.
	//	2 - Puerto del socket de datagrama del receptor
	//	3 - Numero de puerto del socket de este proceso
	//	4 - Mensaje: cadena de texto

	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("Este programa requiere 4 argumentos de linea de comandos");
		} else {
			try {
				InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
				int puertoReceptor = Integer.parseInt(args[1]);
				int miPuerto = Integer.parseInt(args[2]);
				String mensaje = args[3];

				MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
				// instancia un socket datagrama para enviar y recibir datos

				miSocket.enviaMensaje( maquinaReceptora, puertoReceptor, mensaje);
				// ahora espera recibir un datagrama por el socket

				System.out.println(miSocket.recibeMensaje());

				miSocket.close();
			} catch( Exception ex) {
				ex.printStackTrace();
			} 

		} // fin else
	} // fin main
} // fin Ejemplo2EmisorReceptor
