package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxPayers = new ArrayList<TaxPayer>();
		
		
		Integer numberOfPayers;
		
		System.out.println("Enter the number of Taxpayers:");
		numberOfPayers = sc.nextInt();
		
		for(int i=0;i<numberOfPayers;i++) {
			System.out.println("Tax Payer #"+(i+1)+" data:");
			System.out.println("Individual or Company(i/c)?");
			String typeTaxPayer = sc.next();
			if(typeTaxPayer.equals("i")) {
				System.out.print("tax payer's name:");
				String name = sc.next();
				System.out.println("tax payer's anual income:");
				Double income = sc.nextDouble();
				System.out.println("tax payer's healthExpenditures:");
				Double healthExpenditures = sc.nextDouble();
				taxPayers.add(new Individual(name, income, healthExpenditures));
			}else {
				System.out.print("tax payer's name:");
				String name = sc.next();
				System.out.println("tax payer's anual income:");
				Double income = sc.nextDouble();
				System.out.println("tax payer's employees:");
				Integer numberOfEmployees = sc.nextInt();
				taxPayers.add(new Company(name, income,numberOfEmployees));
			}
		}
		
		Double total = 0.0;
		System.out.println("TAXES PAID:");
		for(TaxPayer tp : taxPayers) {
			System.out.println(tp.toString());
			total += tp.calculateTaxes();
		}
		System.out.println("TOTAL TAXES: $ "+total);
		sc.close();
	}
}
