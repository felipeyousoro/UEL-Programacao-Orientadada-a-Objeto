package exercicioDois;
import java.util.ArrayList;


public class Agencia {
	private int numeroAgencia;
	private ArrayList<Pessoa> filaComum = new ArrayList<Pessoa>();
	private ArrayList<Pessoa> filaPreferencial = new ArrayList<Pessoa>();
	
	private int flagPref = 0;
	
	public Agencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
	public int getNumeroAgencia() {
		return this.numeroAgencia;
	}
	
	public void inserirFila(Pessoa cliente) {
		if(cliente.getIdade() > 65) {
			this.filaPreferencial.add(cliente);
		}
		else {
			this.filaComum.add(cliente);
		}
	}
	
	public int buscarPosFilaNome(String nome) {
		Pessoa cliente = buscarClienteNome(nome);
		if(cliente.getNome().equals(nome)) {
			if(cliente.getIdade() > 65) {
				return this.filaPreferencial.indexOf(cliente);
			}
			else {
				return this.filaComum.indexOf(cliente);
			}
		}
		else {
			return -1;
		}
	}
	
	public void atenderFila() {
		Pessoa cliente;
		if(this.flagPref == 1 && this.filaPreferencial.size() > 0) {
			cliente = this.filaPreferencial.get(0);
			
			System.out.println("Cliente atendido!");
			System.out.printf("Nome do cliente: %s Horario de chegada: %s Idade: %s Servico: %s\n", cliente.getNome(), cliente.getHorario(), cliente.getIdade(), cliente.getServico());
			
			filaPreferencial.remove(0);
			this.flagPref = 0;
		}
		else if (this.filaComum.size() > 0){
			cliente = this.filaComum.get(0);
			
			System.out.println("Cliente atendido!");
			System.out.printf("Nome do cliente: %s Horario de chegada: %s Idade: %s Servico: %s\n", cliente.getNome(), cliente.getHorario(), cliente.getIdade(), cliente.getServico());
			
			this.filaComum.remove(0);
			this.flagPref = 1;
		}
		else if(this.filaPreferencial.size() > 0) {
			cliente = this.filaPreferencial.get(0);
			
			System.out.println("Cliente atendido!");
			System.out.printf("Nome do cliente: %s Horario de chegada: %s Idade: %s Servico: %s\n", cliente.getNome(), cliente.getHorario(), cliente.getIdade(), cliente.getServico());
			
			filaPreferencial.remove(0);
			this.flagPref = 0;
		}
	}
	
	public void removerFila(String nome) {
		Pessoa cliente = this.buscarClienteNome(nome);
		if(cliente.getNome().equals(nome)) {
			if(cliente.getIdade() > 65) {
				this.filaPreferencial.remove(cliente);
			}
			else {
				this.filaComum.remove(cliente);
			}
		}
	}
	
	public void imprimirFilas() {
		System.out.println("---Fila comum---");
		for(Pessoa cliente: this.filaComum) {
			System.out.printf("Nome do cliente: %s Horario de chegada: %s Idade: %s Servico: %s\n", cliente.getNome(), cliente.getHorario(), cliente.getIdade(), cliente.getServico());

		}
		System.out.println("---Fim da fila Comum---");
		
		System.out.println("---Fila Preferencial---");
		for(Pessoa cliente: this.filaPreferencial) {
			System.out.printf("Nome do cliente: %s Horario de chegada: %s Idade: %s Servico: %s\n", cliente.getNome(), cliente.getHorario(), cliente.getIdade(), cliente.getServico());

		}
		System.out.println("---Fim da fila preferencial---");

	}
	
	//Eu coloquei esse como private pois ele pode retornar um "erro", eu queria fazer algo como 
	//um return NULL e checar a existencia do objeto mas nao sei se da pra fazer isso em java
	private Pessoa buscarClienteNome(String nome) {
		for (int i = 0; i < this.filaComum.size(); i++) {
			if(this.filaComum.get(i).getNome().equals(nome)) {
				return this.filaComum.get(i);
			}
			
		}
		for (int i = 0; i < this.filaPreferencial.size(); i++) {
			if(this.filaPreferencial.get(i).getNome().equals(nome)) {
				return this.filaPreferencial.get(i);
			}
		}
		//Nao sei o que retornar em caso falso entao eu coloquei isso para funcionar.
		Pessoa erro = new Pessoa("erro", "erro,", -1, "erro");
		return erro;
	}
	
}
