import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		
		BankAccount bankAccount= new BankAccount("Alex","789");
		bankAccount.showMenu();
		

	}

}

class BankAccount {
	double balance;
	double previousTransaction;
	String custumerName;
	String custumerId;
	
	BankAccount(String cname, String cid){
		this.custumerName=cname;
		this.custumerId=cid;
		
	}
	
	void deposit(double amount) {
		if(amount>0) {
			balance +=amount;
			previousTransaction=amount;
		}
	}
	void withdraw(double amount) {
		if (amount !=0) {
			
			balance -=amount;
			previousTransaction=-amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Deposited : "+ previousTransaction);
		}
		if(previousTransaction<0) {
			System.out.println("Withdrawed : "+ Math.abs(previousTransaction));
		}
		
		else {
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu() {
		
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome  " + custumerName);
		System.out.println("Your ID is " + custumerId);
		System.out.println("\n");
		System.out.println("A. Check balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("==================================================================");
			System.out.println("Please choose an option");
			System.out.println("==================================================================");
			
			option = scanner.next().charAt(0);
			
			switch(option) {
			case 'A' :
				System.out.println("Balance is "+ balance);
				break;
			case 'B':
				System.out.println("Please enter amount to deposit");
				double amnt=scanner.nextDouble();
				deposit(amnt);
				break;
				
			case 'C' :
				System.out.println("Please enter amount to Withdraw");
				double amnt1=scanner.nextDouble();
				withdraw(amnt1);
				break;
			case 'D' : 
				System.out.println("=============================");
				 getPreviousTransaction();
				 break;
			case 'E' :
				System.out.println("***************************************");
				break;
			default : 
				System.out.println("Invalid option!!! Please enter correct letter");
				break;
			}
		}while(option !='E');
		
		System.out.println("Thank you for using our services");
		
	}
}
