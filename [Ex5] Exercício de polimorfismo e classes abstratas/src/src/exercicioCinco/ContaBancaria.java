package exercicioCinco;

import java.math.BigDecimal;

public abstract class ContaBancaria {
	protected String cliente;
	protected String numeroConta;
	protected BigDecimal saldo = BigDecimal.ZERO;
	
	public ContaBancaria(String cliente, String numeroConta){
		this.cliente = cliente;
		this.numeroConta = numeroConta;
	}
	
	public final String getCliente() {
		return this.cliente;
	}
	
	public final BigDecimal getSaldo() {
		return this.saldo;
	}
	
	public abstract void depositar(BigDecimal quantia);
	
	public abstract void sacar(BigDecimal quantia);

	public boolean equals(Object o) {
		ContaBancaria contaBancaria = (ContaBancaria) o;
		return contaBancaria.getCliente().equals(this.cliente);
	}
	
}

