package PD;
import java.math.BigDecimal;

public abstract class Payment {

	private BigDecimal amount;
	private BigDecimal amtTendered;

	public abstract Boolean countAsCash();

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmtTendered() {
		return amtTendered;
	}

	public void setAmtTendered(BigDecimal amtTendered) {
		this.amtTendered = amtTendered;
	}

}