package blockchain;

import blockchain.StringUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Block {

  public String hash;
  public String previousHash;
  private String data; // our data will be a simple message.
  private long timeStamp; // as number of milliseconds since 1/1/1970.
  private int nonce;

  /**
   * Calculate Hash SHA256. Calculate new hash based on blocks contents.
   *
   * hash = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) +
   * data
   *
   * Calculation in in @StringUtil.applySha256
   *
   * @return String calculated hash
   */
  public String calculateHash() {
    String calculatedhash = StringUtil
        .applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
    return calculatedhash;
  }

  /**
   * Mine BlockChain.
   *
   * The mineBlock() method takes in an int called difficulty, this is the number
   * of 0’s they must solve for. We will require miners to do proof-of-work by
   * trying different variable values in the block until its hash starts with a
   * certain number of 0’s.
   * <p>
   * Lets add an int called nonce to be included in our calculateHash() method,
   * and the much needed mineBlock() method
   * <p>
   * Mining a block means solving a computationally complex task for the block.
   * While calculating the hash of a block is somewhat trivial, finding the hash
   * starting with five zeroes is not. Even more complicated would be to find a
   * hash starting with ten zeroes, and we get a general idea.
   * <p>
   * So, how exactly can we do this? Honestly, the solution is much less fancy!
   * It's with brute force that we attempt to achieve this goal. We make use of
   * nonce here: Let's see what we trying to do here are:
   *
   * <li>We start by defining the prefix we desire to find
   * <li>Then we check whether we've found the solution
   * <li>If not we increment the nonce and calculate the hash in a loop
   * <li>The loop goes on until we hit the jackpot
   *
   * We're starting with the default value of nonce here and incrementing it by
   * one. But there are more sophisticated strategies to start and increment a
   * nonce in real-world applications. Also, we're not verifying our data here,
   * which is typically an important part.
   *
   * @param difficulty
   *                     (1-5) how many leading zero should be
   * @see #setBounds(int,int,int,int)
   * @since e71a2d1dccace93e151f4c6f8f75ab17cd9ed728
   */
  public void mineBlock(int difficulty) {
    // Create a string with difficulty * "0"
    String target = new String(new char[difficulty]).replace('\0', '0');
    while (!hash.substring(0, difficulty).equals(target)) {
      nonce++;
      hash = calculateHash();
    }
    System.out.println("Block Mined at difficulty:= " + difficulty + ", hash:= " + hash + ", target:= " + target);
  }

  /**
   * getData from Block
   *
   * @return String data
   */
  public String getData() {
    return data;
  }

  /**
   * convertTime print timestamp long in reable format
   *
   * @param value
   * @return date String
   */
  public String convertTime(long time) {
    Date date = new Date(time);
    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
    return format.format(date);
  }

  public List<String> merkleTree() {

    ArrayList<String> tree = new ArrayList<>();

    // Start by adding all the hashes of the transactions as leaves of the
    // tree.

    for (T t : transactions) {
      tree.add(t.hash());
    }

    int levelOffset = 0; // Offset in the list where the currently processed level starts. Step
                         // througheach level, stopping when we reach the root (levelSize == 1).

    for (int levelSize = transactions.size(); levelSize > 1; levelSize = (levelSize + 1) / 2) {
      // For each pair of nodes on that level:
      for (int left = 0; left < levelSize; left += 2) {

        // The right hand node can be the same as the left hand, in the case where we
        // don't have enough transactions.
        int right = Math.min(left + 1, levelSize - 1);
        String tleft = tree.get(levelOffset + left);
        String tright = tree.get(levelOffset + right);
        tree.add(SHA256.generateHash(tleft + tright));
      }

      // Move to the next level.
      levelOffset += levelSize;
    }
    return tree;

  }

  /**
   * Block Constructor.
   *
   * @param data
   *                       information in block data of blockchain
   * @param previousHash
   *                       link to previosus block
   * @return
   */

  public Block(String data, String previousHash) {
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = new Date().getTime();
    this.hash = calculateHash(); // Making sure we do this after we set the other values.

    System.out.println("\nCreate block data: " + this.data + ", timestamp: " + Long.toString(timeStamp)
        + ", timeStamp in readable:= " + convertTime(timeStamp));
  }
}
