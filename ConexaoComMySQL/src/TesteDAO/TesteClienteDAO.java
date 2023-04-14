package TesteDAO;

import java.util.ArrayList;

import DAO.ClienteDAO;
import Model.Cliente;

public class TesteClienteDAO {

	public static void main(String[] args) {
		
		//Instanciando objetos de Cliente
		Cliente cliente1 = new Cliente("094.879.341-67", "João Vitor");
		Cliente cliente2 = new Cliente("563.341.076-74", "Amanda Cardoso");
		Cliente cliente3 = new Cliente("995.714.641-02", "Fábio Aragão");
		
		//Instanciando objetos de ClienteDAO
		ClienteDAO c = new ClienteDAO();
		
		
		//Inserindo os objetos de Cliente no banco de dados atraves de metodos da DAO
		c.inserirCliente(cliente1);
		c.inserirCliente(cliente2);
		
		//Imprimindo no console o sucesso das inserções de Cliente ao banco de dados
		if(c.inserirCliente(cliente3)) {
			System.out.print("Cliente cadastrado com sucesso!\n");
		}
		
		
		//Imprimindo no console da tabela Cliente do banco de dados atraves do metodo DAO
		ArrayList<Cliente> tabelaCliente = c.listarClientes();
		for(int i = 0; i < tabelaCliente.size(); i++) {
			
			System.out.println(tabelaCliente.get(i));
			
		}
		
		
		//Imprimindo no console o sucesso da exclusão de um Cliente do banco de dados
		if(c.deletarCliente(cliente3)) {
			System.out.println("\nCliente deletado com sucesso!");
		}
		
		
		//Imprimindo no console da tabela Cliente do banco de dados atraves do metodo DAO
		ArrayList<Cliente> tabelaCliente2 = c.listarClientes();
		for(int i = 0; i < tabelaCliente2.size(); i++) {
			
			System.out.println(tabelaCliente2.get(i));
			
		}
		
		
	}

}
