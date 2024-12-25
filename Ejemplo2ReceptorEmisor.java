import java.net.*;

/**
*	Este ejemplo ilustra un proceso recibe un mensaje y
*	despues lo manda utilizando un socket datagrama.
*	@author ML Lui.
*/

public class Ejemplo2ReceptorEmisor {
	//	Una aplicacion que recibe un mensaje y despues lo
	// 	manda utilizando un socket datagrama sin conexion.
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

				// instancia un socket datagrama para enviar y recibir datos
				MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);

				// primero espera recibir un datagrama por el socket
				System.out.println(miSocket.recibeMensaje());

				// ahora envia un mensaje al otro proceso
				miSocket.enviaMensaje( maquinaReceptora, puertoReceptor, mensaje);

				miSocket.close();

			} catch( Exception ex) {
				ex.printStackTrace();
			} 

		} // fin else
	} // fin main
} // fin Ejemplo2EmisorReceptor
