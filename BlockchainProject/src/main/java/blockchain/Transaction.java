/**
 * 
 */
package blockchain;

/**
 * @author hadydab
 *
 */
public class Transaction {
	private byte[]   sender;
	private byte[]   receiver;
	private int transactionfee;
	private double amount;
	
	
	
	public Transaction(byte[] sender, byte[] receiver, int transactionfee, double amount) {
		this.sender = sender;
		this.receiver = receiver;
		this.transactionfee = transactionfee;
		this.amount = amount;
	}
	
	
	public byte[] getSender() {
		return sender;
	}
	public void setSender(byte[] sender) {
		this.sender = sender;
	}
	public byte[] getReceiver() {
		return receiver;
	}
	public void setReceiver(byte[] receiver) {
		this.receiver = receiver;
	}
	public int getTransactionfee() {
		return transactionfee;
	}
	public void setTransactionfee(int transactionfee) {
		this.transactionfee = transactionfee;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	

}
