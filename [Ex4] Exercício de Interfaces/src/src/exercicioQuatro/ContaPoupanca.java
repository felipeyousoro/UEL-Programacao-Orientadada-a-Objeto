package exercicioQuatro;

import java.math.BigDecimal;

public class ContaPoupanca implements ContaBancaria {
	String cliente;
	String numeroConta;
	BigDecimal saldo = BigDecimal.ZERO;
	int diaRendimento;
	
	public ContaPoupanca(String cliente, String numeroConta, int diaRendimento){
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.diaRendimento = diaRendimento;
	}
	
	public void calcularNovoSaldo(BigDecimal rendimento) {
		BigDecimal rendimentoPorCem = rendimento.divide(new BigDecimal(100));
		rendimentoPorCem = rendimentoPorCem.add(new BigDecimal(1));
		saldo = saldo.multiply(rendimentoPorCem);
	}
	
	public void sacar(BigDecimal quantia) {
		if(saldo.compareTo(quantia) >= 0) {
			saldo = saldo.subtract(quantia);
		}
	}
	
	public void depositar(BigDecimal quantia) {
		this.saldo = saldo.add(quantia);
	}

	public String getCliente() {
		return this.cliente;
	}
	
	public BigDecimal getSaldo() {
		return this.saldo;
	}
}
