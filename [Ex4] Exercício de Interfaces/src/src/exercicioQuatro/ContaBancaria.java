package exercicioQuatro;

import java.math.BigDecimal;

public interface ContaBancaria {

	void sacar(BigDecimal quantia);
	
	void depositar(BigDecimal quantia);
}
