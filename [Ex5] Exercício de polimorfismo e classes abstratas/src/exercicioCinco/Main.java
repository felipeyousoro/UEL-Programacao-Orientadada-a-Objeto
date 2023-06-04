package exercicioCinco;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);
		
		boolean continuar = true;
		
		BigDecimal limite;
		BigDecimal quantia;
		BigDecimal taxaRendimento;
		
		String cliente;
		String numeroConta;
		
		int diaRendimento;
		int comando;
		int tipoDaConta;
		
		ContaPoupanca contaPoupanca;
		ContaInvestimento contaInvestimento;
		ContaBancaria contaBancaria;
				
		LinkedList<ContaBancaria> listaContas = new LinkedList<ContaBancaria>();
		
		while (continuar){
			System.out.println("Digite 1 para cadastrar uma conta");
			System.out.println("Digite 2 para sacar um valor");
			System.out.println("Digite 3 para atualizar uma conta poupanca ou investimento");
			System.out.println("Digite 4 para depositar em uma conta");
			System.out.println("Digite 5 para mostrar o saldo de uma conta");
			System.out.println("Digite 6 para calcular os tributos em uma conta");
			System.out.println("Digite 7 para calcular a taxa de administracao de uma conta");

			comando = scanner.nextInt();
			scanner.nextLine();
	
			if(comando == 1){
				System.out.println("Digite o tipo da conta: \n1 para Corrente \n2 para Poupanca \n3 para Investimento");
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
					
					listaContas.add(new ContaCorrente(cliente, numeroConta, limite));
				}
				else if(tipoDaConta == 2){
					System.out.println("Digite o dia de rendimento da conta");
					diaRendimento = scanner.nextInt();
					scanner.nextLine();
					
					listaContas.add(new ContaPoupanca(cliente, numeroConta, diaRendimento));
				}
				else {
					listaContas.add(new ContaInvestimento(cliente, numeroConta));
				}
				
	 		} 
			else if(comando == 2) {
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				
				System.out.println("Digite a quantia do saque");
				quantia = scanner.nextBigDecimal();
				scanner.nextLine();
				
				contaBancaria = buscarContaPeloCliente(listaContas, cliente);
				
				contaBancaria.sacar(quantia);
				
			}
			else if(comando == 3) {
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				
				System.out.println("Digite a quantia do rendimento");
				taxaRendimento = scanner.nextBigDecimal();
				
				contaBancaria = buscarContaPeloCliente(listaContas, cliente);
						
				if(contaBancaria instanceof ContaPoupanca) {
					contaPoupanca = (ContaPoupanca) contaBancaria;
					
					contaPoupanca.calcularNovoSaldo(taxaRendimento);
				}
				else{
					contaInvestimento = (ContaInvestimento) contaBancaria;
					
					contaInvestimento.calcularNovoSaldo(taxaRendimento);
				}
				
			}
			else if(comando == 4) {
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();

				System.out.println("Digite a quantia do deposito");
				quantia = scanner.nextBigDecimal();
				scanner.nextLine();
				
				contaBancaria = buscarContaPeloCliente(listaContas, cliente);
				
				contaBancaria.depositar(quantia);
				
			}
			else if(comando == 5) {
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();

				
				contaBancaria = buscarContaPeloCliente(listaContas, cliente);
				
				System.out.println("Saldo: " + contaBancaria.getSaldo());
				
			}
			else if(comando == 6) {
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				
				System.out.println("Digite a quantia do rendimento");
				taxaRendimento = scanner.nextBigDecimal();
				
				contaInvestimento = (ContaInvestimento) buscarContaPeloCliente(listaContas, cliente);
				
				System.out.println("Tributo: " + contaInvestimento.calcularTributo(taxaRendimento));
				
			}
			else if(comando == 7) {
				System.out.println("Digite o nome do cliente");
				cliente = scanner.nextLine();
				
				System.out.println("Digite a quantia do rendimento");
				taxaRendimento = scanner.nextBigDecimal();
				
				contaInvestimento = (ContaInvestimento) buscarContaPeloCliente(listaContas, cliente);
				
				System.out.println("Taxa de administracao: " + contaInvestimento.calcularTaxaDeAdministracao(taxaRendimento));
				
			}
			
			System.out.println("Deseja continuar? S ou N?");
			String continuarFila = scanner.nextLine();
			
			if (continuarFila.equals("N")){
				continuar = false;
			}

		}
		
		scanner.close();
		
	}
	
	public static ContaBancaria buscarContaPeloCliente(LinkedList<ContaBancaria> listaContas, String cliente) {
		int indice = listaContas.indexOf(new ContaInvestimento(cliente, "vazio"));
		return listaContas.get(indice);
	}
	
}
