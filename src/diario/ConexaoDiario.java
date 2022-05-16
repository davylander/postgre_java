package diario;

import java.sql.*;

public class ConexaoDiario {
	private String url;
	private String usuario;
	private String senha;
	private Connection conexao;
	
	ConexaoDiario(){
		url = "jdbc:postresql://localhost:5432/diario";
		usuario = "postgres";
		senha = "2908";
		
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conex�o realizada com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public int executarComandosSQL(String sql) {
		try {
			Statement statement = conexao.createStatement();
			int resposta = statement.executeUpdate(sql);
			return resposta;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public ResultSet executaBuscaSQL(String sql) {
		try {
			Statement statement = conexao.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
