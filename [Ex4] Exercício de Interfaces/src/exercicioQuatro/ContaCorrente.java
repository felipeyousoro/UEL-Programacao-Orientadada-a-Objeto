package exercicioQuatro;

import java.math.BigDecimal;

public class ContaCorrente implements ContaBancaria {
	String cliente;
	String numeroConta;
	BigDecimal saldo = BigDecimal.ZERO;
	BigDecimal limite;
	
	public ContaCorrente(String cliente, String numeroConta, BigDecimal limite){
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.limite = limite;
	}
	
	public void depositar(BigDecimal quantia) {
		this.saldo = saldo.add(quantia);
	}
	
	public void sacar(BigDecimal quantia) {
		BigDecimal quantiaMaxima = saldo;
		quantiaMaxima = quantiaMaxima.add(limite);
		if(quantiaMaxima.compareTo(quantia) >= 0) {
			saldo = saldo.subtract(quantia);
		}
	}
	
	public String getCliente() {
		return this.cliente;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}
}
