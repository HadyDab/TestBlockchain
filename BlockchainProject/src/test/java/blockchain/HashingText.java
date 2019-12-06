/**
 * 
 */
package blockchain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author hadydab
 *
 */
public class HashingText {
	
	
	
	
	private static Transaction genesistraction;
	private static List<Transaction> genesisTransactions;
	private static Block genesisBlock;
	
	private static Transaction trn1;
	private static Transaction trn2;
	private static Transaction trn3;
	private static List<Transaction> trasactions;
	
	private static List<Block> blockchain;
	
	@BeforeClass
	public static void setUp() {
		
		// creation of our genesis Block with hard coded Previous hash value 0
		genesistraction = new Transaction(
				"BlockChain Creator".getBytes(), 
				"public".getBytes(), 
				0, 
				0);
		genesisTransactions.add(genesistraction);
		genesisBlock = new Block("0", genesisTransactions);
		
		blockchain.add(genesisBlock);
		
		
		
		
		// 
		trn1 = new Transaction("Hady".getBytes(), 
				"Hannah".getBytes(), 3, 500);
		trn2 = new Transaction("Hady".getBytes(), 
				"Hannah".getBytes(), 3, 500);
		trn3 = new Transaction("Hady".getBytes(), 
				"Hannah".getBytes(), 3, 500);
		
		trasactions.add(trn1);
		trasactions.add(trn2);
		trasactions.add(trn3);
		
		
		
	}

	@Test
	public void test() {
		assertEquals("Object are equals", "Hady", "Hady");
	}

}
