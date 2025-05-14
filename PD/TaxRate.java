package PD;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxRate implements Comparable<TaxRate> {

	private BigDecimal taxRate;
	private LocalDate effectiveDate;

	public TaxRate() {
		// TODO - implement TaxRate.TaxRate
		this.taxRate = null;
		this.effectiveDate = null;
	}

	/**
	 * 
	 * @param effectiveDate
	 * @param rate
	 */
	public TaxRate(LocalDate effectiveDate, BigDecimal rate) {
		// TODO - implement TaxRate.TaxRate
		this.taxRate = rate;
		this.effectiveDate = effectiveDate;
	}

	/**
	 * 
	 * @param date
	 */
	public boolean isEffective(LocalDate date) {
		// TODO - implement TaxRate.isEffective
		return date.isAfter(getEffectiveDate());
	}

	/**
	 * 
	 * @param taxRate
	 */
	public int compareTo(TaxRate taxRate) {
		// TODO - implement TaxRate.compareTo
	return	this.getEffectiveDate().compareTo(taxRate.getEffectiveDate());
	}

	public String toString() {
		// TODO - implement TaxRate.toString
		return taxRate.toString();
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}