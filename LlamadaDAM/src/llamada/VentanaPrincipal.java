package llamada;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;


public class VentanaPrincipal extends JFrame{
	private JTextField codigo;
	private JTextField mesa;
	public VentanaPrincipal() throws SQLException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCitas = new JLabel("CODIGO");
		lblCitas.setBounds(461, 45, 56, 16);
		lblCitas.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCitas);
		
		codigo = new JTextField();
		codigo.setHorizontalAlignment(SwingConstants.CENTER);
		ArrayList <String> lista = new ArrayList<String>();
		lista=Main.baseDatos.listarLLamadas();
		String cita=" ";
		for(int i=0; i<lista.size();i++) {
			cita=cita+lista.get(i)+"      ";
		}
		
		
		codigo.setText(cita);
		codigo.setBounds(179, 77, 617, 39);
		getContentPane().add(codigo);
		codigo.setColumns(10);
		
		JLabel lblMesa = new JLabel("MESA");
		lblMesa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesa.setBounds(461, 153, 56, 16);
		getContentPane().add(lblMesa);
		
		mesa = new JTextField();
		mesa.setHorizontalAlignment(SwingConstants.CENTER);
		ArrayList <Integer> mesa1 = new ArrayList<Integer>();
		mesa1=Main.baseDatos.listarMesas();
		String mes=" ";
		for(int i=0; i<mesa1.size();i++) {
			mes=mes+"Mesa  "+mesa1.get(i)+"      ";
		}
		mesa.setText(mes);
		mesa.setHorizontalAlignment(SwingConstants.CENTER);
		mesa.setColumns(10);
		mesa.setBounds(179, 206, 617, 39);
		getContentPane().add(mesa);
	
		
		
		
		
		
	
		
		
		
		setSize(1000, 800);
		setVisible(true);
	}
}
