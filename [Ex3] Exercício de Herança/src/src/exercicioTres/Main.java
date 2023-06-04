package exercicioTres;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) { 
		ArrayList<ContaCorrente> listaContaCorrente = new ArrayList<ContaCorrente>();
		ArrayList<ContaPoupanca> listaContaPoupanca = new ArrayList<ContaPoupanca>();

		Scanner scanner = new Scanner(System.in);
		
		boolean continuar = true;
		
		BigDecimal limite;
		BigDecimal quantia;
		String cliente;
		String numeroConta;
		int diaRendimento;
		ContaCorrente contaCorrente;
		ContaPoupanca contaPoupanca;
		
		int tipoDaConta;
		int comando;
		while (continuar){
			System.out.println("Digite 1 para cadastrar uma conta");
			System.out.println("Digite 2 para sacar um valor");
			System.out.println("Digite 3 para atualizar uma conta poupanca");
			System.out.println("Digite 4 para depositar em uma conta");
			System.out.println("Digite 5 para mostrar o saldo de uma conta");

			comando = scanner.nextInt();
			scanner.nextLine();


			
			if (comando == 1){
				System.out.println("Digite o tipo da conta: 1 para Corrente 2 para Poupanca");
				tipoDaConta = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				System.out.println("Digite o numero da conta");
				numeroConta = scanner.nextLine();

				if(tipoDaConta == 1) {
					System.out.println("Digite o limite da conta");
					limite = scanner.nextBigDecimal();
					scanner.nextLine();
					listaContaCorrente.add(new ContaCorrente(cliente, numeroConta, limite));
				}
				else {
					System.out.println("Digite o dia de rendimento da conta");
					diaRendimento = scanner.nextInt();
					scanner.nextLine();
					listaContaPoupanca.add(new ContaPoupanca(cliente, numeroConta, diaRendimento));
				}

	 		} 
			else if (comando == 2){
				System.out.println("Digite o tipo da conta: 1 para Corrente 2 para Poupanca");
				tipoDaConta = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				System.out.println("Digite a quantia do saque");
				quantia = scanner.nextBigDecimal();
				scanner.nextLine();
				
				if(tipoDaConta == 1) {
					contaCorrente = buscarContaCorrente(listaContaCorrente, cliente);
					contaCorrente.sacar(quantia);
				}
				else {
					contaPoupanca = buscarContaPoupanca(listaContaPoupanca, cliente);
					contaPoupanca.sacar(quantia);
				}
				
	 		}
			else if(comando == 3) {
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				System.out.println("Digite a quantia do rendimento");
				quantia = scanner.nextBigDecimal();
				
				contaPoupanca = buscarContaPoupanca(listaContaPoupanca, cliente);
				contaPoupanca.calcularNovoSaldo(quantia);
				
			}
			else if(comando == 4) {
				System.out.println("Digite o tipo da conta: 1 para Corrente 2 para Poupanca");
				tipoDaConta = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				System.out.println("Digite a quantia do deposito");
				quantia = scanner.nextBigDecimal();

				if(tipoDaConta == 1) {
					contaCorrente = buscarContaCorrente(listaContaCorrente, cliente);
					contaCorrente.depositar(quantia);
				}
				else {
					contaPoupanca = buscarContaPoupanca(listaContaPoupanca, cliente);
					contaPoupanca.depositar(quantia);
				}
				
			}
			else if(comando == 5) {
				System.out.println("Digite o tipo da conta: 1 para Corrente 2 para Poupanca");
				tipoDaConta = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				
				if(tipoDaConta == 1) {
					contaCorrente = buscarContaCorrente(listaContaCorrente, cliente);
					System.out.println("Saldo: " + contaCorrente.getSaldo());
				}
				else {
					contaPoupanca = buscarContaPoupanca(listaContaPoupanca, cliente);
					System.out.println("Saldo: " + contaPoupanca.getSaldo());
				}
				
			}
	 			
			System.out.println("Deseja continuar? S ou N?");
			String continuarFila = scanner.nextLine();
			if (continuarFila.equals("N")){
				continuar = false;
			}

		}
		
		scanner.close();
	}
	
	public static ContaCorrente buscarContaCorrente(ArrayList<ContaCorrente> listaContaCorrente, String cliente) {
		for (int i = 0; i < listaContaCorrente.size(); i++) {
			if(listaContaCorrente.get(i).getCliente().equals(cliente)) {
				return listaContaCorrente.get(i);
			}
		}
		return new ContaCorrente("erro", "erro", new BigDecimal(-1));
	}
	
	public static ContaPoupanca buscarContaPoupanca(ArrayList<ContaPoupanca> listaContaPoupanca, String cliente) {
		for (int i = 0; i < listaContaPoupanca.size(); i++) {
			if(listaContaPoupanca.get(i).getCliente().equals(cliente)) {
				return listaContaPoupanca.get(i);
			}
		}
		return new ContaPoupanca("erro", "erro", -1);
	}
	
}
