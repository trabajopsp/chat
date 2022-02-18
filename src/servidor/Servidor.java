
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;


public class Servidor {
	public static void main(String[] args) {
		int puerto = 13000;
		System.setProperty("javax.net.ssl.keystore", "src/certificado/mpd");
		System.setProperty("javax.net.ssl.keyStorePassword", "123456");
		
		try {
			SSLServerSocketFactory fabrica = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			SSLServerSocket miServidor = (SSLServerSocket) fabrica.createServerSocket(puerto);
			
			//ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidor.setSoTimeout(0);//espera infinito
			SSLSocket cliente = (SSLSocket) miServidor.accept();//produce un bloqueo esperando peticiones
			System.out.println("se ha conectado, esperando entrada Cliente");
			
			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leeCliente = new BufferedReader(lector);
			
			String linea = leeCliente.readLine();
			System.out.println("He leido =>" + linea);
			 
			// cierro todos los recursos
			leeCliente.close();
			miServidor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

}
