package less1;

import java.util.Date;

public class Transaction {
	
	//how much you want to transfer
	private double amount ;
	
	//for what this transfer
	private String memo ;
	
	//the transfer hour detail
	private Date transferHour ;
	
	//where to transfer
	private Account inAccount ;

	/**
	 * @param amount
	 * @param memo
	 * @param transferHour
	 * @param inAccount
	 */
	public Transaction(double amount, String memo, Account inAccount) {
		this.amount = amount;
		this.memo = memo;
		this.transferHour = new Date();
		this.inAccount = inAccount;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @return the transferHour
	 */
	public Date getTransferHour() {
		return transferHour;
	}

	/**
	 * @return the inAccount
	 */
	public Account getInAccount() {
		return inAccount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @param transferHour the transferHour to set
	 */
	public void setTransferHour(Date transferHour) {
		this.transferHour = transferHour;
	}

	/**
	 * @param inAccount the inAccount to set
	 */
	public void setInAccount(Account inAccount) {
		this.inAccount = inAccount;
	}
	
	/**
	 * Get a string summarizing the transaction
	 * @return the summary string
	 */
	public String getSumaryLine() {
		
		if (this.amount >=0) {
			return String.format("%s : %.02f₪ : הפקדה - Deposit : %s", this.transferHour.toString() , this.amount , this.memo);
		}else {
			return String.format("%s : (%.02f)₪ : משיכה - Withdrawl : %s", this.transferHour.toString(), -this.amount , this.memo);
		}
	}
	
	
	
}
