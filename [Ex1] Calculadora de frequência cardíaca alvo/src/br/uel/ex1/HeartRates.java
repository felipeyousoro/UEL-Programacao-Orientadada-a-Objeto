package br.uel.ex1;

public class HeartRates {
	private String nome, sobrenome;
	private int dia, mes, ano;
	
	//Construtor
	public HeartRates(String nome, String sobrenome, int dia, int mes, int ano) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	//Gets
	public String getNome() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	//Sets
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void imprimePessoa() {
		int idade =  calculaIdade(this.dia, this.mes, this.ano);
		System.out.println("Nome completo: " + this.nome + " " +  this.sobrenome);
		System.out.println("Data de nascimento: " + this.dia + "/" + this.mes + "/" + this.ano);
		System.out.println("Idade: " + idade + " anos");
		System.out.println("Numero maximo de batimentos: " + calculaBatMax(idade));
		System.out.println("Intervalo de frequencia cardiaca: " +  calculaBatInterMin(idade) + "-" + calculaBatInterMax(idade) + " batimentos");
	}
	
	private int calculaIdade(int d, int m, int a) {
		int idade;
		idade = 0;
		if((m > 8) || (m == 8 && d > 27)) {
			idade--;
		}
		idade = idade + 2021 - a;
		return idade;
	}
	
	/*No texto as vezes tratava a frequencia alvo como um numero e as vezes
	como um intervalo entao eu assumi que era pra calcular os limites do intervalo
	*/
	private double calculaBatInterMax(int idade) {
		return (double) calculaBatMax(idade) * 0.85;
	}
	
	private double calculaBatInterMin(int idade) {
		return (double) calculaBatMax(idade) * 0.5;
	}

	private int calculaBatMax(int idade) {
		return 220 - idade;
	}
}
