package util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import blockchain.Block;

public class BlockchainUtil {
	
	
	private static final String  BLOCKCHAINDBURL = "src/main/resources/blockchain.txt";
	private static final Path BLOCKCHAINFILEPATH = Paths.get(BLOCKCHAINDBURL);
	
	public static boolean isChainValid(List<Block> blockchain) {
		Block currentBlock; 
		Block previousBlock;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}
	
	
	
	public static String readBlockchainFromDB() {
		String blockchainString = "";
		try {
			if(Files.exists(BLOCKCHAINFILEPATH)) {
				byte[] blockchainBypes = Files.readAllBytes(BLOCKCHAINFILEPATH);
				blockchainString = new String(blockchainBypes);
			}
		} catch (IOException e) {

		}
		return blockchainString;
	}
	
	
	public static List<Block>  getBlockchainFromDB(){
		
		List<Block> blockchainFromJson = new ArrayList<Block>();
		String blockchainString = readBlockchainFromDB();
		Type blockchainType = new TypeToken<ArrayList<Block>>(){}.getType();
		blockchainFromJson = new GsonBuilder().create().fromJson(blockchainString, blockchainType);
		
		return blockchainFromJson;
		
	}
	
	public static boolean saveBlockchainInToDB(List<Block> blockchain) {
		try {
			if(Files.exists(BLOCKCHAINFILEPATH)) {
				String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
				Files.write(BLOCKCHAINFILEPATH, blockchainJson.getBytes());
	
				return true;
			}
			return false;
		} catch (IOException e) {
			return false;
			
		}
		
	}
	
	
	
	public static long mineBlock(Block blockToBeMine, int difficulty) {
		Instant start = Instant.now();
		blockToBeMine.mineBlock(difficulty);
		Instant end = Instant.now();
		long miningDuration = Duration.between(start, end).getSeconds();
		return miningDuration;
		
	}
	
	
	
	
	


}
