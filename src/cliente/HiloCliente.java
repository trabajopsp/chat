package cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;

import InterfazGrafica.PantallaCliente;

public class HiloCliente extends Thread {

	private SSLSocket misocket;

	// Contrsuctor con el socket del cliente + el numero maximo de clientes
	public HiloCliente(SSLSocket misocket) {
		super();
		this.misocket = misocket;
	}

	public void run() {
		try {
			// Para la lectura de lo que nos llegue por el socket
			BufferedReader leeCliente = new BufferedReader(new InputStreamReader(misocket.getInputStream()));
			BufferedWriter escribeCliente = new BufferedWriter(new OutputStreamWriter(misocket.getOutputStream()));

			PantallaCliente pantallaClientes=new PantallaCliente();
			pantallaClientes.setVisible(true);
			/*
			 * // Lectura String linea = leeCliente.readLine();
			 * System.out.println("He leido =>" + linea);
			 * 
			 * 
			 * escribeCliente.write("soy " + linea + " iteraccion:" + i + "\n");
			 * escribeCliente.flush(); System.out.println("soy " + linea + " iteraccion:" +
			 * i);
			 * 
			 * 
			 * leeCliente.close(); misocket.close(); System.out.println("TERMINO");
			 */

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
