package exercicioDois;

public class Pessoa {
	private String nome;
	private String horario;
	private int idade;
	private String servico;
	
	public Pessoa(String nome, String horario, int idade, String servico) {
		this.nome = nome;
		this.horario = horario;
		this.idade = idade;
		this.servico = servico;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public String getHorario() {
		return this.horario;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public String getServico() {
		return this.servico;
	}
	
}
