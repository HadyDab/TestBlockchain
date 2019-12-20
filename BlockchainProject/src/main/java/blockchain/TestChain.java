package blockchain;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import util.BlockchainUtil;

public class TestChain {
	
	private static List<Block> blockchain = new ArrayList<Block>();

	public static void main(String[] args) {
		
		Transaction genesistraction = new Transaction(
				"BlockChain Creator".getBytes(), 
				"public".getBytes(), 
				0, 
				0);
		List<Transaction> genesisTransactions = new ArrayList<Transaction>();
		genesisTransactions.add(genesistraction);
		
		Block genesisBlock = new Block("0", genesisTransactions);
		
		
		
		System.out.println("Mining Duration in Seconds:  " + BlockchainUtil.mineBlock(genesisBlock, 3));
		
		blockchain.add(genesisBlock);
		blockchain.forEach(Block::printBlock);
		
		
		
		
		
		
		//BlockchainUtil.saveBlockchainInToDB(blockchain);
		
		
		
		//List<Block> blockchainFromDB = BlockchainUtil.getBlockchainFromDB();
		//blockchainFromDB.forEach(Block::printBlock);
		
		//System.out.println("Hello World");
		
		
		
		
//		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
//	
//		Type blockchainType = new TypeToken<ArrayList<Block>>(){}.getType();
//		
//		List<Block> blockchainFromJson = new GsonBuilder().create().fromJson(blockchainJson, blockchainType);
//		
//		blockchainFromJson.forEach(Block::printBlock);
		
		
		

	}

}
