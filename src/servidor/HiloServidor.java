package servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.net.ssl.SSLSocket;

public class HiloServidor extends Thread{
	private SSLSocket cliente;
	private String nombreCliente;

	public HiloServidor( SSLSocket cliente) {
		;
		this.cliente = cliente;
	}
	
	public void run() {
		// Construyo el recurso dentro del try para que lo cierre él automáticamente
		try (BufferedWriter escribirAlCliente = 
				new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
			BufferedReader leerDeCliente = 
			new BufferedReader(new InputStreamReader(cliente.getInputStream())))
		{
			
			// envío algo al servidor
			escribirAlCliente.write("Entra en el chat " + nombreCliente);
			escribirAlCliente.newLine();
			escribirAlCliente.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
