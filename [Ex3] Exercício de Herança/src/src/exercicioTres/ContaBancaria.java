package exercicioTres;
import java.math.BigDecimal;

public class ContaBancaria {
	protected String cliente;
	protected String numeroConta;
	protected BigDecimal saldo = BigDecimal.ZERO;
	
	
	public ContaBancaria(String cliente, String numeroConta) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
	}
	
	public void depositar(BigDecimal quantia) {
		saldo = saldo.add(quantia);
	}
	
	public void sacar(BigDecimal quantia) {
		if(saldo.compareTo(quantia) >= 0) {
			saldo = saldo.subtract(quantia);
		}
		else {
			System.out.println("Saque invalido!");
		}
	}
		
	public String getCliente() {
		return cliente;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	
}
