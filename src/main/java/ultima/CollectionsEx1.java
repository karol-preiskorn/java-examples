package ultima;

import java.util.ArrayList;
import java.util.Iterator;

// todo The ArrayList class maintains the insertion order and is non-synchronized.

class CollectionEx1 {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<String>(); // Creating arraylist
        list.add("Ravi");// Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        list.add("jakiś");
        list.add("dodany");
        list.add("dodany");
        // Traversing list through Iterator
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
