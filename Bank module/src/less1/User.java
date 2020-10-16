package less1;

import java.util.ArrayList;

public class User {
	 
	//User first name
	private String firstName ;
	
	//User last name
	private String lastName ;
	
	//uuid - number unique code just for this user it's like the id or log in 
	private String uuid ; 
	
	private String pin;
	//all the accounts that this user have
	private ArrayList<Account> accounts ;


	/**
	 * @param firstName - first name for the user
	 * @param lastName - last name for the user
	 * @param uuid - uniqe code - id for the user
	 * @param account - all the account that this user have
	 */
	public User(String firstName, String lastName, String pin , Bank theBank) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.uuid = theBank.getUserUUID();
		this.accounts = new ArrayList<Account>();
		this.pin = pin;
		
		System.out.printf("New user %s %s with UserID %s created. \n" ,firstName, lastName  , this.uuid);
		
	}

	public int SizeOfAccount() {
		return accounts.size();
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}


	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}


	/**
	 * @return the accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	/**
	 * adding account acc for the user
	 * @param acc
	 */
	public void addAccount(Account acc) {
		this.accounts.add(acc);
	}
	
	/**
	 * Get the transaction history for the account
	 * @param acctIdx the history transaction for this account 
	 */
	public void printAccTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	
	/**
	 * print the history for this account
	 * @param theAcct
	 */
	public void AccountHistory() {
		
		System.out.printf("\n\n%s's Accounts Summary\n" , this.firstName);
		
		for (int i = 0 ; i<= this.accounts.size()-1 ; i++) {
		System.out.printf("   %d)   %s\n" , i+1 , accounts.get(i).AccountSummaryHistory());
			}
		System.out.println();
		}

	public void DepositAccount(int theAcct , double money) {
		accounts.get(theAcct).DepositToAccount(money);
		
	}

	/**
	 * deposit to the account money
	 * @param depo 	number of the account 
	 * @param money		how much to Deposit
	 * @param memo		what the reason to Deposit , etc , Gift from Grand Mother or saving..
	 */
	public void addAcctTransaction(int depo, double money, String memo) {
		accounts.get(depo).DepositTransaction(money , memo) ;
		
	}

	public double MaxBalance(int depo) {
		return this.accounts.get(depo).getBalance();
	}

	/**
	 * return the uuid for the specific Account
	 * @param to_Account
	 * @return
	 */
	public String getAcctUUID(int to_Account) {
		return accounts.get(to_Account).getUuid();
	}
		
	
	
	
}
