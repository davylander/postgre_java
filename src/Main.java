import java.sql.*;

public class Main {

	public static void main(String[] args) {
		
		//insert("Ser Cancedeletado","cancelado.del@gmail.com");
		select();
		//update("Davi Souto Neri","davisouto.if@gmail.com",1);
		//delete(7);
		
		
	}
	
	public static void insert(String nome, String email) {
		Conexao conexao = new Conexao();
		String sql = "INSERT into cliente (nome,email,id)" + 
					 "values ('"+ nome +"', '"+ email +"',default)"
				   ;
				
		int resultado = conexao.executarSQL(sql);
		
		if (resultado > -1) {
			System.out.println("Cadastrado com sucesso!!");
			System.out.println("Linhas: " + resultado);
		}else {
			System.out.println("Erro durante o cadastro!");
		}
	}
	
	public static void select() {
		Conexao conexao = new Conexao();
		String sql = "SELECT * FROM cliente"; //+ selectSQL;
		ResultSet resultSet = conexao.executaBusca(sql);
		
		try {
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String email = resultSet.getString("email");
				System.out.println(id+", "+ nome + ", " + email);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(String nome, String email, int id) {
		Conexao conexao = new Conexao();
		String sql = "UPDATE cliente "
				   + "SET nome = '"+ nome +"', email = '"+ email +"' "
				   + "WHERE id = " + id
				   ;
				
		int resultado = conexao.executarSQL(sql);
		
		if (resultado > -1) {
			System.out.println("Atualizado com sucesso!!");
			System.out.println("Linhas: " + resultado);
		}else {
			System.out.println("Erro durante o cadastro!");
		}
	}
	
	public static void delete(int id) {
		Conexao conexao = new Conexao();
		String sql = "DELETE FROM cliente "
				   + "WHERE id = " + id 
				   ;
				
		int resultado = conexao.executarSQL(sql);
		
		if (resultado > -1) {
			System.out.println("Deletado com sucesso!!");
			System.out.println("Linhas: " + resultado);
		}else {
			System.out.println("Erro durante o cadastro!");
		}
	}

}
