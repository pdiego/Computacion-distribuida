import java.net.*;

/**
* Este ejemplo ilustra la sintaxis basica de los
*	socket datagrama orientados a conexion.
* @author ML liu.
*/

public class Ejemplo3Emisor {
	// Una aplicacion que utiliza un socket datagrama
	//	orientado a conexion para mandar multiples mensajes 
	//	Se esperan 4 argumentos para la ejecucion desde consola, en orden:
	// 1 - Nombre de dominio o IP
	// 2 - Puerto de socket del otro proceso
	// 3 - Puerto del socket de este proceso
	// 4 - Mensaje

	public static void main (String[] args) {

		if (args.length != 4) {
			System.out.println("Este programa requiere 4 argumentos de linea de comandos.");
		} else {
			try {
				InetAddress maquinaReceptora = InetAddress.getByName(args[0]);
				int puertoReceptor = Integer.parseInt(args[1]);
				int miPuerto = Integer.parseInt(args[2]);
				String mensaje = args[3];

				// instancia un socket Diagrama para la conexion
				MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
				// Hace la conexion
				miSocket.connect(maquinaReceptora, puertoReceptor);
				for(int i=0; i<10; i++) {
					miSocket.enviaMensaje(maquinaReceptora, puertoReceptor, mensaje);
				}

				// ahora recibe un mensaje desde el otro programa
				System.out.println(miSocket.recibeMensaje());
				miSocket.disconnect();
				miSocket.close();

			} catch(Exception ex) {
				ex.printStackTrace();
			} // fin catch
		} // fin del else

	} // fin de main
} // fin de class