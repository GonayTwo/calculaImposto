package entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Company extends TaxPayer{
	private Integer numberOfEmployees;
	NumberFormat formatter = new DecimalFormat("#.00");

	public Company(String name, Double income, Integer numberOfEmployees) {
		super(name, income);
		this.numberOfEmployees = numberOfEmployees;
	}


	@Override
	public Double calculateTaxes() {
		Double taxPaid;
		if(this.numberOfEmployees < 10) {
			taxPaid = super.getIncome() * 0.16;
		}else {
			taxPaid = super.getIncome() * 0.14;
		}
		return taxPaid;
	}
	
	@Override
	public String toString() {
		return super.getName()+": $ "+formatter.format(calculateTaxes());
	}
	
	
	
	
	

}
