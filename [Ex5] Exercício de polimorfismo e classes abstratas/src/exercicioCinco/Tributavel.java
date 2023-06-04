package exercicioCinco;

import java.math.BigDecimal;

public abstract class Tributavel extends ContaBancaria{
	
	public Tributavel(String cliente, String numeroConta){
		super(cliente, numeroConta);
	}
	
	public abstract BigDecimal calcularTributo(BigDecimal rendimento);
}
