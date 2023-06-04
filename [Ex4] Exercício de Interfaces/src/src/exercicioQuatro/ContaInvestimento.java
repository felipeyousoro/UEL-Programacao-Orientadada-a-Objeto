package exercicioQuatro;
import java.math.BigDecimal;

public class ContaInvestimento implements ContaBancaria, Tributavel{
	String cliente;
	String numeroConta;
	BigDecimal saldo = BigDecimal.ZERO;
	
	public ContaInvestimento(String cliente, String numeroConta){
		this.cliente = cliente;
		this.numeroConta = numeroConta;
	}
	
	public void sacar(BigDecimal quantia) {
		if(saldo.compareTo(quantia) >= 0) {
			saldo = saldo.subtract(quantia);
		}
	}
	
	public void depositar(BigDecimal quantia) {
		this.saldo = saldo.add(quantia);
	}
	
	public void calcularNovoSaldo(BigDecimal rendimento) {
		BigDecimal rendimentoPorCem = rendimento.divide(new BigDecimal(100));
		rendimentoPorCem = rendimentoPorCem.add(new BigDecimal(1));
		saldo = saldo.multiply(rendimentoPorCem);
	}
	
	public BigDecimal calcularTaxaDeAdministracao(BigDecimal rendimento) {
		BigDecimal taxaAdministracao = rendimento.multiply(new BigDecimal(0.01));
		return taxaAdministracao;
	}
	
	public BigDecimal calcularTributo(BigDecimal rendimento) {
		BigDecimal tributo = rendimento.multiply(new BigDecimal(0.005));
		return tributo;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public BigDecimal getSaldo() {
		return this.saldo;
	}
	
}
