package blockchain;

import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class NoobChain {
  public static ArrayList<Block> blockchain = new ArrayList<Block>();
  public static int difficulty = 6;

  /**
   * @return Boolean
   */
  public static Boolean isChainValid() {
    Block currentBlock;
    Block previousBlock;
    String hashTarget = new String(new char[difficulty]).replace('\0', '0');

    // loop through blockchain to check hashes:
    for (int i = 1; i < blockchain.size(); i++) {
      currentBlock = blockchain.get(i);
      previousBlock = blockchain.get(i - 1);
      // compare registered hash and calculated hash:
      if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
        System.out.println("Current Hashes not equal");
        return false;
      }
      // compare previous hash and registered previous hash
      if (!previousBlock.hash.equals(currentBlock.previousHash)) {
        System.out.println("Previous Hashes not equal");
        return false;
      }
      // check if hash is solved
      if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
        System.out.println("This block hasn't been mined");
        return false;
      }
    }
    return true;
  }

  /**
   * Noob blockchain.
   *
   * @param args
   *               no arguments
   */
  public static void main(String[] args) {

    blockchain.add(new Block("root", "0"));
    blockchain.get(0).mineBlock(difficulty);
    for (int j = 1; j < 10; j++) {
      blockchain.add(new Block("Yo im the " + j + " block", blockchain.get(blockchain.size() - 1).hash));
      blockchain.get(j).mineBlock(difficulty);
    }
    System.out.println("\nBlockchain is Valid: " + isChainValid());
    String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
    System.out.println(blockchainJson);
  }
}
