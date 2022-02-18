
package servidor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import InterfazGrafica.PantallaClientePrincipal;
import InterfazGrafica.PantallaServidor;

public class Servidor {
	static public String nombreCliente;
	

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	// Variable con el fichero "Properties" con la configuración
	private static final String PROPERTIES_FILE = "src/config/datos.properties";

	public static void main(String[] args) {
		Properties properties = new Properties();
		System.setProperty("javax.net.ssl.keystore", "src/certificado/mpd");
		System.setProperty("javax.net.ssl.keyStorePassword", "123456");

		try {
			properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
			int puerto = Integer.valueOf(properties.getProperty("puertoEscucha"));
			SSLServerSocketFactory fabrica = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			SSLServerSocket miServidor = (SSLServerSocket) fabrica.createServerSocket(puerto);
			
			int numClientes = Integer.valueOf(properties.getProperty("maxClientes"));
			
			//Mostramos la pantalla del servidor
			PantallaServidor pServer = new PantallaServidor();
			pServer.setVisible(true);
			
			for (int i = 0; i<numClientes; i++) {
				
			}
			// ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidor.setSoTimeout(0);// espera infinito
			SSLSocket cliente = (SSLSocket) miServidor.accept();// produce un bloqueo esperando peticiones
			System.out.println("se ha conectado, esperando entrada Cliente");
			System.out.println(nombreCliente);

			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leeCliente = new BufferedReader(lector);

		
			// cierro todos los recursos
			leeCliente.close();
			miServidor.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
