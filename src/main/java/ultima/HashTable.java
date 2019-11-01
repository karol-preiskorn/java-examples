package ultima;

import java.util.Hashtable;

//
// @SuppressWarnings("unchecked")
class HashTable {
    public static void main(String[] arg) {
        // creating a hash table
        Hashtable<Integer, String> h = new Hashtable<Integer, String>();
        Hashtable<Integer, String> h1 = new Hashtable<Integer, String>();
        Hashtable<Integer, String> h2 = new Hashtable<Integer, String>();

        h.put(3, "Geeks");
        h.put(2, "forGeeks");
        h.put(1, "isBest");
        h.put(4, "Quamm");
        h.put(5, "Qq");
        h.put(6, "Qq");
        h.put(6, "Qq");

        // create a clone or shallow copy of hash table h
        h1 = (Hashtable<Integer, String>) h.clone();
        h2 = (Hashtable<Integer, String>) h1.clone();
        System.out.println("-- start --");
        System.out.println(">h: " + h);
        System.out.println("clone h->h1: " + h1);

        // clear hash table h
        h.clear();

        // checking hash table h
        System.out.println("after clearing h: " + h);
        System.out.println(">h1: " + h1);
        System.out.println(">h2: " + h2);

        Hashtable<?, ?> h3 = (Hashtable<?, ?>) h2.clone();
        // String s = (String) h3.get("Qq");
        // System.out.println(">(String) h3.get(0): " + s);
        System.out.println(">(String) h3: " + h3);
    }
}
