package llamada;

import java.io.IOException;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runtime objrun= Runtime.getRuntime();
		 
		try {
			objrun.exec("C:\\Users\\jluis\\OneDrive\\Escritorio\\M13\\Proyecto_Usuarios\\web\\Menu_usuario.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
