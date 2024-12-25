import java.net.*;
import java.io.*;

/**
*	Una subclase de DatagramSocket que contine
*	metodos para mandar y recibir mensajes
*	@Autor: ML Liu.
*/

public class MiSocketDatagrama extends DatagramSocket {
	static final int MAX_LON = 10;
	MiSocketDatagrama(int numeroPuerto) throws SocketException {
		super(numeroPuerto);
	} // fin MiSocketDatagrama

	public void enviaMensaje(InetAddress maquinaReceptora, int puertoReceptor, String mensaje) throws IOException {
		byte[] almacenEnvio = mensaje.getBytes();
		DatagramPacket datagrama = new DatagramPacket( almacenEnvio, almacenEnvio.length, maquinaReceptora, puertoReceptor);
		this.send(datagrama);
	} // fin de enviaMensaje

	public String recibeMensaje() throws IOException {
		byte[] almacenRecepcion = new byte[MAX_LON];
		DatagramPacket datagrama = new DatagramPacket(almacenRecepcion, MAX_LON);
		this.receive(datagrama);
		String mensaje = new String(almacenRecepcion);
		return mensaje;
	} // fin de recibemensaje
} // fin class