package llamada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;



public class Main {
	static GestionBDD baseDatos = new GestionBDD();
	public static void main(String[] args) throws SQLException {
		
		new VentanaPrincipal();
		
	}

}
