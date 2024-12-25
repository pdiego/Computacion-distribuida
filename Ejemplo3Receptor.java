import java.net.*;

/**
*
*
*
*/

public class Ejemplo3Receptor {
	// Una aplicacion que utiliza un socket datagrama
	//	orientado a conexion para recibir multiples mensajes 
	// y despues enviar uno de confirmacion
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
				InetAddress maquinaEmisora = InetAddress.getByName(args[0]);
				int puertoEmisor = Integer.parseInt(args[1]);
				int miPuerto = Integer.parseInt(args[2]);
				String mensaje = args[3];

				// instancia un socket Diagrama para la conexion
				MiSocketDatagrama miSocket = new MiSocketDatagrama(miPuerto);
				// Hace la conexion
				miSocket.connect(maquinaEmisora, puertoEmisor);
				for(int i=0; i<10; i++) {
					System.out.println(miSocket.recibeMensaje());
				}

				// al finalizar la recepcion confirmamos fin enviando mensaje
				miSocket.enviaMensaje(maquinaEmisora, puertoEmisor, mensaje);
				miSocket.disconnect();
				miSocket.close();

			} catch(Exception ex) {
				ex.printStackTrace();
			} // fin catch
		} // fin del else

	} // fin de main
} // fin de class