package blockchain;

import com.google.gson.GsonBuilder;
import java.util.ArrayList;

public class NoobChain {
  public static ArrayList<Block> blockchain = new ArrayList<Block>();

  /**
   * Noob blockchain.
   *
   * @param args
   *               no arguments
   */
  public static void main(String[] args) {
    Block prevBlock = new Block("Root", null);
    for (int i = 0; i < 10; i++) {
      Block tmpBlock = new Block(i + " blockchain", prevBlock.hash);
      prevBlock = tmpBlock;
      System.out.println("Hash for block nr:" + i + ", named: " + tmpBlock.getData() + " : " + tmpBlock.hash);
    }

    blockchain.add(new Block("Hi im the first block", "0"));
    blockchain.add(new Block("Yo im the second block", blockchain.get(blockchain.size() - 1).hash));
    blockchain.add(new Block("Hey im the third block", blockchain.get(blockchain.size() - 1).hash));

    String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
    System.out.println(blockchainJson);
  }
}
