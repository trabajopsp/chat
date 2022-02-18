package InterfazGrafica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PantallaServidor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaServidor frame = new PantallaServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaServidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtListadoClientes = new JLabel();
		txtListadoClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtListadoClientes.setBorder(BorderFactory.createLineBorder(Color.black));
		txtListadoClientes.setBounds(10, 11, 113, 318);
		contentPane.add(txtListadoClientes);
		
		JButton btnSalirConexion = new JButton("Salir conexion");
		btnSalirConexion.setBounds(361, 357, 113, 23);
		contentPane.add(btnSalirConexion);
		
		JLabel txtChatServidor = new JLabel();
		txtChatServidor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtChatServidor.setBorder(BorderFactory.createLineBorder(Color.black));
		txtChatServidor.setBounds(133, 11, 341, 318);
		contentPane.add(txtChatServidor);
	}
}
