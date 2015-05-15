import java.util.Scanner;

public class TestLoanClass {
  /** Main method */
    public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Enter yearly interest rate
    System.out.print( "Enter yearly interest rate, for example, 8.25: ");
    double annualInterestRate = input.nextDouble();

    // Enter number of years
    System.out.print("Enter number of years as an integer: ");
    int numberOfYears = input.nextInt();
    
    // Enter loan amount
    System.out.print("Enter loan amount, for example, 120000.95: ");
    double loanAmount =  input.nextDouble();
   
    // Create Loan object
    Loan loan =  new Loan(annualInterestRate, numberOfYears, loanAmount);

    // Display loan date, monthly payment, and total payment
   	System.out.printf("The loan was created on %s\n" +"The monthly payment is %.2f\nThe total payment is %.2f\n",loan.getLoanDate().toString(), loan.getMonthlyPayment(),  loan.getTotalPayment());
	
   	input.close();//Close input
  }
}
class Loan {
	  private double annualInterestRate;
	  private int numberOfYears;
	  private double loanAmount;
	  private java.util.Date loanDate;

	  /** Default constructor */
	  public Loan() {
	    this(2.5, 1, 1000);
	  }

	  /** Construct a loan with specified annual interest rate,
	      number of years and loan amount 
	    */
	  public Loan(double annualInterestRate, int numberOfYears,double loanAmount)throws IllegalArgumentException,IllegalArgumentException, IllegalArgumentException {
		  
		  if(annualInterestRate<=0 || numberOfYears<=0 || loanAmount<=0){//Judge the annual interest rate,number of years,loan amount whether less than or equal to zero
			  throw new IllegalArgumentException("Invalid value input.");
		  }		
		  else{
			  this.numberOfYears = numberOfYears;
			  this.loanAmount = loanAmount;
			  this.annualInterestRate = annualInterestRate;
			  loanDate = new java.util.Date();
		  }
	  }

	  /** Return annualInterestRate */
	  public double getAnnualInterestRate() {
		  return annualInterestRate;
	  }

	  /** Set a new annualInterestRate */
	  public void setAnnualInterestRate(double annualInterestRate){
		  if(annualInterestRate<=0 ){ //Judge the annual interest rate whether less than or equal to zero
			  throw new IllegalArgumentException("Yearly interest rate is invalid. ");
		  }
		  else{
			  this.annualInterestRate = annualInterestRate;
		  }
	 }

	  /** Return numberOfYears */
	  public int getNumberOfYears() {
	    return numberOfYears;
	  }

	  /** Set a new numberOfYears */
	  public void setNumberOfYears(int numberOfYears){//Judge the ,number of years whether less than or equal to zero
		  if(numberOfYears<=0 ){
		      throw  new IllegalArgumentException("Number of year is invalid. ");
		  }
		  else{
			  this.numberOfYears = numberOfYears;
		  }
	 }

	  /** Return loanAmount */
	  public double getLoanAmount() {
		  return loanAmount;
	  }

	  /** Set a newloanAmount */
	  public void setLoanAmount(double loanAmount){//Judge the loan amount whether less than or equal to zero
		  if(loanAmount<=0 ){
			  throw new IllegalArgumentException("Loan Amount is invalid. ");
		  }		
		  else{
			  this.loanAmount = loanAmount;
		  }
	  }

	  /** Find monthly payment */
	  public double getMonthlyPayment() {
		  double monthlyInterestRate = annualInterestRate / 1200;
		  double monthlyPayment = loanAmount * monthlyInterestRate / (1 -(Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
		  return monthlyPayment;    
	  }

	  /** Find total payment */
	  public double getTotalPayment() {
		  double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		  return totalPayment;    
	  }

	  /** Return loan date */
	  public java.util.Date getLoanDate() {
		  return loanDate;
	  }
}
