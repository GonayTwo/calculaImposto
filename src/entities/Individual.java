package entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Individual extends TaxPayer{
	private Double healthExpenditures;
	NumberFormat formatter = new DecimalFormat("#.00");
	
	public Individual(String name, Double income, Double healthExpenditures) {
		super(name, income);
		this.healthExpenditures = healthExpenditures;
	}



	@Override
	public Double calculateTaxes() {
		Double taxPaid;
		if(super.getIncome() < 20000) {
			taxPaid = (super.getIncome() * 0.15) - (this.healthExpenditures * 0.5);
		}else {
			taxPaid = (super.getIncome() * 0.25) - (this.healthExpenditures * 0.5);
		}
		return taxPaid;
	}
	
	@Override
	public String toString() {
		return super.getName()+": $ "+formatter.format(calculateTaxes());
	}


	public Double getHealthExpenditures() {
		return healthExpenditures;
	}



	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	

}
