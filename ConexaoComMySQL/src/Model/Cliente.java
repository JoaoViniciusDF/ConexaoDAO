package Model;

public class Cliente {

	//Atributos de cliente
	private String nome, cpf;
	
	//Construtor de CLiente
	public Cliente(String cpf, String nome) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}


	//Getters and Setters para os atributos
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	//Método de String para traduzir os atributos de Cliente para string
	@Override
	public String toString() {
		
		return cpf + " - " + nome;
		
	}
	
	
}
