package mortgagecalculator;
import java.text.NumberFormat;
import java.util.Scanner;


public class MortgageCalculator {
	
	public void calculateMortgage() {
		
	    final int MONTHS_IN_YEAR = 12;
	    final int PERCENT = 100;
	
	    int principle = 0;
	
	    //create scanner to collect input
	    Scanner scanner = new Scanner(System.in);
	
	    do {
			System.out.println("");
	        System.out.print("Please enter your principle (whole number from 1K-1M): ");
	        principle = scanner.nextInt();
	    }
	    while ((principle < 1_000) || (principle > 1_000_000_000));
	
	
	    float enteredInterest;
	    float interestAnnual;
	    float interestMonthly;
	    int years = 0;
	    int numberPayments = 0;
	
	    do {
	        //grab input from user - Can be other than String bbbss
	        System.out.print("Please enter your Annual Interest Rate (0-30): ");
	        enteredInterest = scanner.nextFloat();
	        interestAnnual = enteredInterest / PERCENT;
	        interestMonthly = interestAnnual / MONTHS_IN_YEAR;
	        // System.out.println(interestAnnual);
	    }
	    while ((enteredInterest < 0) || (enteredInterest > 30));
	
	
	
	    do {
	        System.out.print("Please enter your the amount of years for the loan (0-40): ");
	        years = scanner.nextInt();
	        numberPayments = years * MONTHS_IN_YEAR;
	    }
	    while ((years < 0) || (years > 40));
	
	
	        /*
	Make NEW currency class instance -
	no NEW keyword because NumberFormat is abstract and can't instantiate
	*/;
	    NumberFormat currency = NumberFormat.getCurrencyInstance();
	    String principleStr = currency.format(principle);
	
	    //create instance for percentage
	    NumberFormat percentage = NumberFormat.getPercentInstance();
	    //reformat to percentage - String
	    String interestAnnualStr = percentage.format(interestAnnual);
	
	
	    //Mortgage
	    double mortgage = principle
	            * (interestMonthly * Math.pow(1 + interestMonthly, numberPayments))
	            / (Math.pow(1 + interestMonthly, numberPayments) - 1);
	
	    //reformat to currency - from previous currency instance
	    String mortgageStr = currency.format(mortgage);
	
		System.out.println("");
	    System.out.println("Principle: " + principleStr);
	    System.out.println("Annual Percentage Rate: " + interestAnnualStr);
	    System.out.println("Period (years): " + years);
	    System.out.println("Monthly Payment for Mortgage: " + mortgageStr);
		System.out.println("");
	    
	}
}
