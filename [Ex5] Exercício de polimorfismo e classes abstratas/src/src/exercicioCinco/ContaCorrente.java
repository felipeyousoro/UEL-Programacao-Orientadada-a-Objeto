package exercicioCinco;

import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria{
	protected BigDecimal limite;
	
	public ContaCorrente(String cliente, String numeroConta, BigDecimal limite){
		super(cliente, numeroConta);
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
	
}
