/**
 * 
 */
package blockchain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import util.SHAHelper;

/**
 * @author hadydab
 *
 */
public class Block {
	
	public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private List<Transaction> transactions;
	
	
	public Block(String previousHash, String data, long timeStamp, List<Transaction> transactions) {
		super();
		this.previousHash = previousHash;
		this.data = data;
		this.timeStamp = timeStamp;
		this.transactions = transactions;
		this.hash = calculateHash();
	}
	
	public Block(String previousHash,List<Transaction> transactions) {
		this(previousHash,null,new Date().getTime() ,transactions);
	}
	
	public Block(String previousHash, String data) {
		this(previousHash, data,new Date().getTime() ,null);
	}
	
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	private String calculateHash() {
		
		String calculatedhash = SHAHelper.getSha256StringFromInput(previousHash
				+ Long.toString(timeStamp)
				+ Integer.toString(Arrays.hashCode(transactions.toArray()))
				);
		
		return calculatedhash;
	}
	
	
	

}
