package DAO;

import java.sql.*;
import java.util.ArrayList;

import Model.Cliente;

public class ClienteDAO {

	private Connection conn;
	
	//Estabelecendo conexão com o banco de dados
	public ClienteDAO() {
		
		//Sempre que um objeto DAO é instanciado um conexão com um banco de dados é estabelecida
		
		this.conn = null;
		String url = "jdbc:mysql://localhost/loja";//Local do DATABASE local
		String user = "root";//Usuário do banco de dados local
		String password = "admin";//Senha do bancdo de dados local
		
		try {

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão com banco de dados estabelecida\n");
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		
		}
	}
	
	
	//Criando método de inserir objetos de Cliente no banco de dados
		public boolean inserirCliente(Cliente cliente) {
			
			//Criando o comando SQL desejado do método
			String sql = "INSERT INTO Cliente(cpf , nome) VALUES (?, ?)";
			
			try {
				
				//Aplicando o comando criado no método no banco de dados
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cliente.getCpf());
				ps.setString(2, cliente.getNome());
				ps.execute();
				
				//Retornando verdadeiro caso execute o comando SQL
				return true;
				
			}catch(SQLException e){
				
				//Retornando exceção e valor falso caso não execute o comando SQL
				e.printStackTrace();
				return false;
			
			}
			
		}
		
		
		//Criando método de excluir objetos de Cliente no banco de dados
		public boolean deletarCliente(Cliente cliente) {
			
			//Criando o comando SQL desejado do método
			String sql = "DELETE FROM Cliente WHERE cpf = ?";
			
			try {
				
				//Aplicando o comando criado no método no banco de dados
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cliente.getCpf());
				ps.executeUpdate();
				
				//Retornando verdadeiro caso execute o comando SQL
				return true;
				
			}catch(SQLException e) {

				//Retornando exceção e valor falso caso não execute o comando SQL
				e.printStackTrace();
				return false;
			
			}
			
		}
		
		//Criando método de listar os objetos de Cliente no banco de dados
		public ArrayList<Cliente> listarClientes(){
			
			ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();//Instanciando uma lista de Clientes
			String sql = "SELECT * FROM Cliente";//Criando o comando SQL desejado do método
			
			
			try {
				
				//Aplicando o comando criado no método no banco de dados
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				//Percorrendo a tabela Cliente enquanto houver um próximo objeto nela mesma
				while(rs.next()) {
					
					//Pegando os valores de cada Atributo desejado da tabela no banco de dados
					String cpf = rs.getString("cpf");
					String nome = rs.getString("nome");
					Cliente cliente = new Cliente(cpf, nome);
					listaClientes.add(cliente);
					
				}
				
				//Retornando verdadeiro caso execute o comando SQL
				return listaClientes;
				
			}catch(SQLException e) {
				
				//Retornando exceção e valor falso caso não execute o comando SQL
				e.printStackTrace();
				return listaClientes;
				
			}
			
		}
}

