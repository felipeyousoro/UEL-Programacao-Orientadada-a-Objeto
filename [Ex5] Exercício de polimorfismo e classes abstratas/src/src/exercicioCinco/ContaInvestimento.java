package exercicioCinco;

import java.math.BigDecimal;

public class ContaInvestimento extends Tributavel{

	public ContaInvestimento(String cliente, String numeroConta){
		super(cliente, numeroConta);
	}
	
	public void sacar(BigDecimal quantia) {
		if(saldo.compareTo(quantia) >= 0) {
			saldo = saldo.subtract(quantia);
		}
	}
	
	public void depositar(BigDecimal quantia) {
		this.saldo = saldo.add(quantia);
	}
	
	public BigDecimal calcularTributo(BigDecimal rendimento) {
		BigDecimal tributo = rendimento.multiply(new BigDecimal(0.005));
		return tributo;
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
	
}
