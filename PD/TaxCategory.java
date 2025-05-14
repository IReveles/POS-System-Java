package PD;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaxCategory {

	private String category;
	private LocalDate effectiveDate;
	TreeSet<TaxRate> taxRates;

	public TaxCategory() {
		// TODO - implement TaxCategory.TaxCategory
		this.category = null;
		taxRates = new TreeSet<TaxRate>();
	}

	/**
	 * 
	 * @param category
	 */
	public TaxCategory(String category, String effectiveDate) {
		// TODO - implement TaxCategory.TaxCategory
		this();
		this.category = category;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
		this.effectiveDate = LocalDate.parse(effectiveDate, formatter);
	}

	/**
	 * 
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		// TODO - implement TaxCategory.getTaxRateForDate
		BigDecimal taxRateAmount = new BigDecimal("0");
		for(TaxRate taxRate : taxRates) {
			if(taxRate.isEffective(date)) {
				taxRateAmount = taxRate.getTaxRate();
			}
		}
		return taxRateAmount;
	}

	/**
	 * 
	 * @param taxRate
	 */
	public void addTaxRate(TaxRate taxRate) {
		// TODO - implement TaxCategory.addTaxRate
		taxRates.add(taxRate);
	}

	/**
	 * 
	 * @param taxRate
	 */
	public void removeTaxRate(TaxRate taxRate) {
		// TODO - implement TaxCategory.removeTaxRate
		taxRates.remove(taxRate);
	}

	
	public String toString() {
		// TODO - implement TaxCategory.toString
		return this.category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public TreeSet<TaxRate> getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(TreeSet<TaxRate> taxRates) {
		this.taxRates = taxRates;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}