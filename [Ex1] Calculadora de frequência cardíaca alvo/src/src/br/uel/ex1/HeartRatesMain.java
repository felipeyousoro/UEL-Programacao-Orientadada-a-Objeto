package br.uel.ex1;

import java.util.Scanner;


public class HeartRatesMain {
	public static void main(String[] args) { 
		Scanner entrada = new Scanner(System.in);
		String n, sn;
		int d, m, a;
		
		System.out.println("Digite o nome:");
		n = entrada.nextLine();
		System.out.println("Digite o sobrenome:");
		sn = entrada.nextLine();
		System.out.println("Digite o dia");
		d = entrada.nextInt();
		System.out.println("Digite o mes:");
		m = entrada.nextInt();
		System.out.println("Digite o ano:");
		a = entrada.nextInt();
		
		HeartRates pessoa = new HeartRates(n, sn, d, m ,a);
		
		pessoa.imprimePessoa();
		
		entrada.close();
	   } 

}
