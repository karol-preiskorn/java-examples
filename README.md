# Java examples

Some tutorials, examples and exercises done in Java language. 
Articles for these examples are here:

## Casting Type
https://www.ultimasolution.pl/casting-type-in-java-type-safety-unchecked-cast-from-object-to-hashtable/
## List
https://www.ultimasolution.pl/list/

### Nested Collections
\src\main\java\ultima\CollectionEx1.java
```java
import java.util.Hashtable;

// one method (wrong!)
// @SuppressWarnings("unchecked")
class HashTable {
    public static void main(String[] arg) {
        // creating a hash table
        Hashtable<Integer, String> h = new Hashtable<Integer, String>();

        h.put(3, "Geeks");
        h.put(2, "forGeeks");
        h.put(1, "isBest");
        h.put(4, "Quamm");
        h.put(5, "Qq");
        h.put(6, "Qq");
        h.put(6, "Qq");

        // create a clone or shallow copy of hash table h
        Hashtable<Integer, String> h1 = (Hashtable<Integer, String>) h.clone();
        Hashtable<Integer, String> h2 = (Hashtable<Integer, String>) h1.clone();
        
        System.out.println("-- start --");
        System.out.println(">h: " + h);
        System.out.println("clone h->h1: " + h1);

        // clear hash table h
        h.clear();

        // checking hash table h
        System.out.println("after clearing h: " + h);
        System.out.println(">h1: " + h1);
        System.out.println(">h2: " + h2);

        // proper way create a clone or shallow copy of hash table h
        Hashtable<?, ?> h3 = (Hashtable<?, ?>) h.clone();
        // String s = (String) h3.get("Qq");
        // System.out.println(">(String) h3.get(0): " + s);
        System.out.println(">(String) h3: " + h3);
    }
}
```
### HashTable.java

### Vechicle.java

Optionals in Java

## package blockchain

Simple a blockchain build based on the article in medium https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa

Describe this implementation: https://www.ultimasolution.pl/blockchain-in-java/

### Block.java

Simple bloc

### NoobChain.java

### StringUtil.java

# History

- 2019-11-03 add gradle configuration for generate log4j2 jar
- 2019-11-06 add blockchain package
- 2020-02-14 correstion in description README.md
