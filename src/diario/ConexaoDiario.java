package diario;

import java.sql.*;

public class ConexaoDiario {
	private String url;
	private String usuario;
	private String senha;
	private Connection conexao;
	
	ConexaoDiario(){
		url = "jdbc:postresql://localhost:5432/?";
		usuario = "postgres";
		senha = "2908";
		
		try {
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
}
