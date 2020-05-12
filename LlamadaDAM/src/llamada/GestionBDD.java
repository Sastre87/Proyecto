package llamada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jluis
 */
class GestionBDD {
    
    Connection conn1=null;
    public GestionBDD() {
         // ABRE UNA CONEXIÓN A UNA BASE DE DATOS QUE SE SUPONE MYSQL Y QUE TIENE LAS TABLAS
        // Y LOS USUARIOS CREADOS SEGÚN ESTE EJEMPLO.

        try {
            //RECUERDA: PARA EJECUTAR ESTE CÓDIGO ES NECESARIO TENER mYSQL FUNCIONANDO Y LAS TABLAS Y USUARIOS CREADOS
            String url1 = "jdbc:mysql://localhost:3306/proyecto_citas";
            String user = "root";
            String password = "Pepepepe1@@";
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Conectado");
                listarLLamadas();
            }

        } catch (SQLException ex) {
            System.out.println("ERROR:La dirección no es válida o el usuario y clave");
            ex.printStackTrace();
        }
    }
    
    public ArrayList<String> listarLLamadas() throws SQLException{
		ArrayList<String> listarLLamadas = new ArrayList<String>();
		String query = "select codigo_cita from Citas where llamado=true;";

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn1.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				listarLLamadas.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		
                return listarLLamadas;
	}
    public ArrayList<Integer> listarMesas() throws SQLException{
		ArrayList<Integer> listarMesas = new ArrayList<Integer>();
		String query = "select tipo_tramite from Citas where llamado=true;";

		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn1.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				listarMesas.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs.close();
			stmt.close();
		}
		
                return listarMesas;
	}

}