package exercicioTres;
import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria{
	private int diaRendimento;
	
	public ContaPoupanca(String cliente, String numeroConta, int diaRendimento){
		super(cliente, numeroConta);
		this.diaRendimento = diaRendimento;
	}
	
	public void calcularNovoSaldo(BigDecimal rendimento) {
		BigDecimal rendimentoPorCem = rendimento.divide(new BigDecimal(100));
		rendimentoPorCem = rendimentoPorCem.add(new BigDecimal(1));
		saldo = saldo.multiply(rendimentoPorCem);
	}
	
}
