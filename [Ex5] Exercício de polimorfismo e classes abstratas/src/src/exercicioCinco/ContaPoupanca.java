package exercicioCinco;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria{
	protected int diaRendimento;
	
	public ContaPoupanca(String cliente, String numeroConta, int diaRendimento){
		super(cliente, numeroConta);
		this.diaRendimento = diaRendimento;
	}
	
	public void calcularNovoSaldo(BigDecimal rendimento) {
		BigDecimal rendimentoPorCem = rendimento.divide(new BigDecimal(100));
		rendimentoPorCem = rendimentoPorCem.add(new BigDecimal(1));
		saldo = saldo.multiply(rendimentoPorCem);
	}
	
	public void depositar(BigDecimal quantia) {
		this.saldo = saldo.add(quantia);
	}
	
	public void sacar(BigDecimal quantia) {
		if(saldo.compareTo(quantia) >= 0) {
			saldo = saldo.subtract(quantia);
		}
	}
	
}
