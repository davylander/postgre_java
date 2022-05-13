import java.sql.*;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection conexao;
	
	Conexao(){
		url = "jdbc:postgresql://localhost:5432/test";
		usuario = "postgres"; 
		senha =  "2908";
		
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conexão realizada com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int executarSQL(String sql) {
		try {
			Statement statement = conexao.createStatement();
			int resposta = statement.executeUpdate(sql);
			conexao.close();
			return resposta;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public ResultSet executaBusca(String sql) {
		try {
			Statement statement = conexao.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			conexao.close();
			return resultSet;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
