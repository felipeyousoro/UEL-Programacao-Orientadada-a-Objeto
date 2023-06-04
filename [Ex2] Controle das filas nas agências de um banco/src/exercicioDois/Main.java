package exercicioDois;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o numero da agencia");
		int numeroAgencia = scanner.nextInt();
		scanner.nextLine();
		Agencia banco = new Agencia(numeroAgencia);
		
		int idade;
		String nome;
		String horario;
		String servico;
		
		boolean continuar = true;

		
		while (continuar){
			System.out.println("Digite 1 para cadastrar um cliente");
			System.out.println("Digite 2 para um cliente desistir da fila");
			System.out.println("Digite 3 para atender um cliente");
			System.out.println("Digite 4 para buscar por um cliente");
			System.out.println("Digite 5 para imprimir as filas");

			int comando = scanner.nextInt();
			scanner.nextLine();

			if (comando == 1){
				System.out.println("Digite o nome do cliente");
				nome = scanner.nextLine();
				System.out.println("Digite a hora de chegada");
				horario = scanner.nextLine();
				System.out.println("Digite a idade do cliente");
				idade = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o servico");
				servico = scanner.nextLine();

				Pessoa cliente = new Pessoa(nome, horario, idade, servico);
				banco.inserirFila(cliente);
				
				System.out.println("Cliente inserido!");
	 		} 
			else if (comando == 2){
				System.out.println("Digite o nome do cliente");
				nome = scanner.nextLine();
				
				banco.removerFila(nome);
				
				System.out.println("Cliente removido!");
				
	 		}
			else if (comando == 3){
				banco.atenderFila();
	 		}
			else if (comando == 4){
				System.out.println("Digite o nome do cliente");
				nome = scanner.nextLine();
				
	 			int pos = banco.buscarPosFilaNome(nome);
	 			if(pos == -1) {
		 			System.out.printf("\nCliente inexistente!\n");

	 			}
	 			else {
	 				System.out.printf("\nPosicao: %d\n", pos);
	 			}
	 		}
			else if (comando == 5){
	 			banco.imprimirFilas();
	 		}
	 			
	 			
	 			
	 			
			System.out.println("Deseja continuar? S ou N?");
			String continuarFila = scanner.nextLine();
			if (continuarFila.equals("N")){
				continuar = false;
			}

		}
		
		scanner.close();
	}
}
