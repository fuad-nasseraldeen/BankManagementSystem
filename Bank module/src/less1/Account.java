package less1;

import java.util.ArrayList;

public class Account {

		// name of the account etc checking , savings
		private String name ;
		
		// how much there in this account
		private double balance ; 
		
		//unique number for this account
		private String uuid ;
		
		//this account's belong to this user holder
		private User userHolder ;
		
		private ArrayList<Transaction> transaction;
		
		

		/**
		 * @param name 	the name of the account
		 * @param balance	the balance for the account 
		 * @param uuid	unique number for this account 
		 * @param userHolder	this account belong to this user holder
		 */
		public Account(String name, User userHolder, Bank theBank) {
			
			this.name = name;
			this.balance = balance;
			this.uuid = theBank.getAccountUUID();
			this.userHolder = userHolder;
			this.transaction = new ArrayList<Transaction>();
		}


		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}


		/**
		 * @param transaction the transaction to set
		 */
		public void setTransaction(ArrayList<Transaction> transaction) {
			this.transaction = transaction;
		}


		/**
		 * @return the transaction
		 */
		public ArrayList<Transaction> getTransaction() {
			return transaction;
		}


		/**
		 * @return the balance
		 */
		public double getBalance() {
			
			return balance;
		}


		/**
		 * @return the uuid
		 */
		public String getUuid() {
			return uuid;
		}


		/**
		 * @return the userHolder
		 */
		public User getUserHolder() {
			return userHolder;
		}


		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}


		/**
		 * @param balance the balance to set
		 */
		public void setBalance(double balance) {
			this.balance = balance;
		}


		/**
		 * @param uuid the uuid to set
		 */
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}


		/**
		 * @param userHolder the userHolder to set
		 */
		public void setUserHolder(User userHolder) {
			this.userHolder = userHolder;
		}

		/**
		 * printing account summary 
		 * @return strinf format account summary
		 */
		public String AccountSummaryHistory() {
			double balance = getBalance();
			String shekel = "\u20AA";
			return String.format(" %.02f%s  :  %s  :  %s" , balance, shekel , this.uuid ,this.name );
		}

		public void printTransHistory() {
			System.out.printf("\nTransaction History for Account %s\n" , this.uuid);
			if(this.transaction.size() == 0 ) {
				System.out.println("\nThere is No Transaction History for this Account.\n\n ");
			}
			for ( int t = this.transaction.size()-1 ; t >=0 ; t--) {
				System.out.println(this.transaction.get(t).getSumaryLine());
			}
			System.out.println();
		}
		
		public void DepositToAccount(Double money) {
			this.balance +=money;
			String c = "\u00BB";
			String shekel = "\u20AA";
			if (money < 0 ) {
				System.out.printf("You Withdrawl %s%s %.02f%s   " ,c,c, -1*money ,shekel);
				System.out.println();
				System.out.printf("Your Balance in Account %s is : %.02f%s" ,this.uuid, this.balance , shekel);
				
				System.out.println();
			}else {
			System.out.printf("You Deposit %s%s %.02f%s   ",c, c , money ,shekel);
			System.out.println();
			System.out.printf("Your Balance in Account %s is : %.02f%s" ,this.uuid, this.balance , shekel);
			System.out.println();
			}
		}

		/**
		 * Add a new Transaction in this account
		 * @param money	the amount transacted
		 * @param memo		the transaction memo
		 */
		public void DepositTransaction(double money, String memo) {
			
			Transaction trans = new Transaction(money, memo , this);
			transaction.add(trans);
			
			
		}
		
		
		
		
		
		
		
}
