package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import InterfazGrafica.PantallaClientePrincipal;

public class Cliente {
	// Variable con el fichero "Properties" con la configuraci�n
	private static final String PROPERTIES_FILE = "src/config/datos.properties";

	public static void main(String[] args) throws InterruptedException {
		
		//Para el certificado:
		System.setProperty("javax.net.ssl.trustStore","src/certificado/Usuariompd");
		System.setProperty("javax.net.ssl.trustStorePassword","890123");

		Properties properties = new Properties();

		try {
			properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
			int puerto = Integer.valueOf(properties.getProperty("puertoEscucha"));
			String host = properties.getProperty("host");
			
			PantallaClientePrincipal conexion = new PantallaClientePrincipal();
			conexion.setVisible(true);
			
			
			// Creaci�n de Socket Seguro
			SSLSocketFactory fabrica = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket misocket = (SSLSocket) fabrica.createSocket(host, puerto);
			
			
			// Para la lectura de lo que nos llegue por el socket
			BufferedReader leeCliente = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			BufferedWriter escribeCliente = new BufferedWriter(new OutputStreamWriter(misocket.getOutputStream()));
			
			
		
			leeCliente.close();
			misocket.close();
			System.out.println("TERMINO");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
