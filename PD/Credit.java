package PD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Credit extends AuthorizedPayment {

	private String cardType;
	private String acctNumber;
	private LocalDate expireDate;

	public Credit() {
		// TODO - implement Credit.Credit
	}

	/**
	 * 
	 * @param amount
	 * @param cardType
	 * @param acctNumber
	 * @param expireDate
	 */
	public Credit(BigDecimal amount, BigDecimal amtTendered, String cardType, String acctNumber, String expireDate) {
		// TODO - implement Credit.Credit
		this();
		setAmount(amount);
		setAmtTendered(amtTendered);
		this.cardType = cardType;
		this.acctNumber = acctNumber;
		this.expireDate = LocalDate.parse(expireDate, DateTimeFormatter.ofPattern("MM/d/yyyy"));
	}

	public Boolean isAuthorized() {
		// TODO - implement Credit.isAuthorized
		return true;
	}

	public String toString() {
		// TODO - implement Credit.toString
		throw new UnsupportedOperationException();
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

}