package less1;

import java.util.Scanner;

public class DemoATM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Bank theBank= new Bank("הראשון הבינלאומי הבנק");

		User aUser = theBank.addNewUser("Fuad", "Nasser-Aldeen", "1234");
		
		Account account = new Account("checking", aUser, theBank);
		aUser.addAccount(account);
		theBank.addAccount(account);
		
		User curUser ;
		while(true) {
			//stay in the login prompt until successful login
			curUser = DemoATM.mainMenuPrompt(theBank ,sc);
			
			//stay in main menu until user quits
			DemoATM.printUserMenu(curUser, sc);
		}
	}

	private static User mainMenuPrompt(Bank theBank, Scanner sc) {
		String symbol ="\uD83C\uDFE6";
		String userID ; 
		String pin ;
		User curUser;
		
		
		
		do {
			System.out.printf("\n\nWelcome to %s %s\n\n" , theBank.getName() , symbol);
			System.out.print("Enter userID: ");
			userID = sc.nextLine();
			
			System.out.print("Enter pin: ");
			pin = sc.nextLine();
			
			curUser = theBank.CheckLogIn(userID , pin);
			
			if (curUser == null){
				System.out.println("Inccorect User Name or Passwaord , Please Try again..\n\n");
				
			}
		}while(curUser == null);
		
		return curUser;
	}
	
	
	private static void printUserMenu(User curUser, Scanner sc) {
		System.out.printf("\n\nWelcome %s , what would you like to do?",
				curUser.getFirstName());
		curUser.AccountHistory();
		int choice ;
		do {
			
		System.out.println();
		System.out.println("   1) Show account transaction history - בחשבון שלך התנועות על מידע ");
		System.out.println("   2) Withdrawl - למשוך");
		System.out.println("   3) Deposit - להפקיד");
		System.out.println("   4) Transfer - להעביר ");
		System.out.println("   5) Quit");
		System.out.println();
		System.out.println("Enter a choice: ");
		choice = sc.nextInt();
		
		if(choice > 5 || choice < 1 ) {
			System.out.println("Incorrect Option. \nPlease Try again ");
		}
		}while(choice > 5 || choice < 1 );
		
		switch (choice) {
		case 1: 
			DemoATM.TransactionHistory(curUser , sc);
			break;
		case 2:
			DemoATM.Withdrawl(curUser , sc);
			break;
		case 3:
			DemoATM.Deposit(curUser , sc);
			break;
		case 4:
			DemoATM.Transfer(curUser , sc);
			break;
		case 5:
			sc.nextLine();
			break;
		}
		
		if(choice != 5) {
			DemoATM.printUserMenu(curUser, sc);
		}
	}

	private static void Transfer(User curUser, Scanner sc) {
		
		int from_Account;
		int to_Account;
		double money ;
		String memo;
		String shekel = "\u20AA";
		
		do {
			
			System.out.printf("Which Account you Want to transfer to ? 1-%d\n" ,curUser.SizeOfAccount());
			from_Account = sc.nextInt();
			
			if(from_Account < 1 || from_Account > curUser.SizeOfAccount()) {
				System.out.println("Invalid Number , please Try again ");
			}
			
			}while(from_Account < 1 || from_Account > curUser.SizeOfAccount());
		
		do {
			
			System.out.printf("Which Account you Want to transfer from ? 1-%d\n" ,curUser.SizeOfAccount());
			to_Account= sc.nextInt();
			
			if(to_Account < 1 || to_Account > curUser.SizeOfAccount()) {
				System.out.println("Invalid Number , please Try again ");
			}
			
			}while(to_Account < 1 || to_Account > curUser.SizeOfAccount());
			
		
			do {
				
				System.out.println("How Much You Want to transfer להעביר to the Second Account ? \n");
				money = sc.nextInt();
				
				if(money > curUser.MaxBalance(from_Account-1)) {
					System.out.println("You Can't transfer Money more than your balance "
							+ ", Please Try again\n");
					System.out.println("Your Balance is : " + curUser.MaxBalance(from_Account-1)+shekel);
				}
			}while(money > curUser.MaxBalance(from_Account-1));
		
		System.out.println();
		curUser.DepositAccount(from_Account-1 , -1*money);
		curUser.DepositAccount(to_Account-1 , money);
		
		curUser.addAcctTransaction(from_Account-1, money, String.format("Transfer from account %s",
				curUser.getAcctUUID(from_Account-1)));
		
		curUser.addAcctTransaction(to_Account-1, money, String.format("Transfer to account %s",
				curUser.getAcctUUID(to_Account-1)));
		System.out.println();
		
	}

	private static void Deposit(User curUser, Scanner sc) {
		
		int depo;
		double money ;
		String memo;
		
		
		do {
			
			System.out.printf("Which Account you Want to Deposit to ? 1-%d\n" ,curUser.SizeOfAccount());
			depo = sc.nextInt();
			
			if(depo < 1 || depo > curUser.SizeOfAccount()) {
				System.out.println("Invalid Number , please Try again ");
			}
			
			}while(depo < 1 || depo > curUser.SizeOfAccount());
			
			do {
				
				System.out.println("How Much You Want to Deposit להפקיד to the Account ? \n");
				money = sc.nextInt();
				
				if(money < 0 ) {
					System.out.println("You Can't Deposit Money less than Zero "
							+ ", Please Try again\n");
				}
			}while(money < 0);
		
		sc.nextLine();
		
		
		System.out.print("Enter a memo: ");
		memo = sc.nextLine();
		curUser.DepositAccount(depo-1 , money);
		curUser.addAcctTransaction(depo-1, money, memo);
		System.out.println();
		
	}

	private static void Withdrawl(User curUser, Scanner sc) {

		int depo;
		double money ;
		String memo;
		String shekel = "\u20AA";
		
		do {
			
		System.out.printf("Which Account you Want to Withdrawl למשוך to ? 1-%d\n" ,curUser.SizeOfAccount());
		depo = sc.nextInt();
		
		if(depo < 1 || depo > curUser.SizeOfAccount()) {
			System.out.println("Invalid Number , please Try again ");
		}
		
		}while(depo < 1 || depo > curUser.SizeOfAccount());
		
		if(curUser.MaxBalance(depo-1) <=0) {
			System.out.println("You can't Withdrawl Money.");
			System.out.println("Your Balance is : " + curUser.MaxBalance(depo-1) +shekel);
			return;
		}
		do {
			
			System.out.println("How Much You Want to Withdrawl to the Account ? (max " + curUser.MaxBalance(depo-1)+shekel+")\n");
			money = sc.nextInt();
			
			if(money > curUser.MaxBalance(depo-1)) {
				System.out.println("You Can't Withdrawl Money More than Your Balance "
						+ ", Please Try again\n");
				System.out.println("Your Balance is : " + curUser.MaxBalance(depo-1));
			}
			
		}while(money > curUser.MaxBalance(depo-1));
		
		sc.nextLine();
			System.out.print("Enter a memo: ");
			memo = sc.nextLine();
			curUser.DepositAccount(depo-1 , -1*money);
			curUser.addAcctTransaction(depo-1, -1*money, memo);
			System.out.println();
		
	
	
	
	
}
	
	
/**
 * print transaction history for specific account 
 * @param curUser
 * @param sc 	- print history account for this user.
 */
	private static void TransactionHistory(User curUser, Scanner sc) {
		
	int theAcct;
		do {
	//get account whose transaction history to look at
	System.out.printf("Enter the number (1-%d) of the a ccount " + 
			"whose transactions you want to see: \n", curUser.SizeOfAccount());
	
	theAcct = sc.nextInt();
	
	if(theAcct<1 || theAcct> curUser.SizeOfAccount()) {
		System.out.println("Invalid choise , please try again");
	}
		}while(theAcct<1 || theAcct> curUser.SizeOfAccount());
		
	curUser.printAccTransHistory(theAcct-1);
	}

}
