package less1;

import java.util.ArrayList;
import java.util.Random;

public class Bank {

		//the name of the bank
		private String name ;
		
		//the users in this bank
		private ArrayList<User> users;
		
		//all the accounts list
		private ArrayList<Account> accounts ;

		/**
		 * @param name
		 * @param users
		 * @param accounts
		 */
		public Bank(String name) {
			
			this.name = name;
			this.users = new ArrayList<User>();
			this.accounts =  new ArrayList<Account>();
		}
		
		/**
		 * Creat an account for specific user name 
		 * @param firstName
		 * @param lastName
		 * @param pin
		 * @return unew user name that created 
		 */
		public User addNewUser(String firstName , String lastName , String pin) {
			User newUser = new User(firstName , lastName , pin , this);
			this.users.add(newUser);
			
			Account newAccount = new Account("savings", newUser, this);
			newUser.addAccount(newAccount);
			this.addAccount(newAccount);
			
			return newUser;
		}
		
		/**
		 * add new account for this user
		 * @param acct
		 */
		public void addAccount(Account acct) {
			this.accounts.add(acct);
		}
		
		
		/**
		 * //keep looping until nonUnique become false
		 * @return ID unique for each user
		 */
		public String getUserUUID() {
			Random rand = new Random();
			String uuid ;
			boolean nonunique;
			uuid = "";
			do {
				for (int i =0; i <=2 ; i++)
				{
					uuid += ((Integer)rand.nextInt(6)).toString();
				}
				nonunique = false;
				for (User u : this.users ) {
					
					if (uuid.compareTo(u.getUuid()) == 0 ) { // not equal == unique 
						nonunique = true;
						break;
					}
				}
				
			}while(nonunique);
			return uuid;
		}
		/**
		 * //keep looping until nonUnique become false
		 * @return ID unique for each account
		 */
		public String getAccountUUID() {
			Random rand = new Random();
			String uuid ;
			boolean nonunique;
			uuid = "";
			do {
				for (int i =0; i <=10 ; i++)
				{
					uuid += ((Integer)rand.nextInt(6)).toString();
				}
				nonunique = false;
				for (Account acc : this.accounts) {
					
					if (uuid.compareTo(acc.getUuid()) == 0 ) { // equal ==  not unique
						//keep looping until nonUnique become false
						nonunique = true;
						break;
					}
				}
				
			}while(nonunique);
			return uuid;
		}
		
		/**
		 * check log in
		 * @param userName
		 * @param password
		 * @return the user 
		 */
		public User CheckLogIn(String userName, String password) {
			
			for (User u : users) {
				if(userName.compareTo(u.getUuid()) == 0) {
					return u;
				}
			}
			return null;
			
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		
}
