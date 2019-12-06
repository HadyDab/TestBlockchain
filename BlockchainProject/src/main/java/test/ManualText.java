/**
 * 
 */
package test;

import blockchain.Transaction;
import util.SHAHelper;

/**
 * @author hadydab
 *
 */
public class ManualText {
	
	public static void main(String[] args) {
		
		Transaction trn1 = new Transaction("Hady".getBytes(), 
				"Hannah".getBytes(), 3, 500);
		Transaction trn2 = new Transaction("Hady".getBytes(), 
				"Hannah".getBytes(), 3, 500);
		Transaction trn3 = new Transaction("Hady".getBytes(), 
				"Hannah".getBytes(), 3, 500);
		
		System.out.println(SHAHelper.getSha256StringFromInput("hADY"));
		
		
		
	}

}
