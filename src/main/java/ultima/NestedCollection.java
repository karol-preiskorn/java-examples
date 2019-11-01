package ultima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class NestedCollection {

    List<List<String>> nestedList = Arrays.asList(Arrays.asList("one:one"),
            Arrays.asList("two:one", "two:two", "two:three"),
            Arrays.asList("three:one", "three:two", "three:three", "three:four"));

    // ArrayList<Class> myList = new ArrayList<Class>();
    //
    // TODO make it static
    List<String> listL = new ArrayList<String>(List.of("A", "C", "B"));
    List<String> listLL = new LinkedList<>();
    List<String> listLV = new Vector<>();
    List<String> listLS = new Stack<>();

    public static void main(String[] args) {
        // simple example of List<String>
        try {
            // creating Arrays of String type
            String a[] = new String[] { "E", "B", "A", "C", "D" };

            // getting the list view of Array
            List<String> list = Arrays.asList(a);
            System.out.println("The List<String> is: " + list);
            list.sort(null);

            System.out.println("The sort and add List<String> is: " + list);

            // printing the list
            System.out.println("The List<String> is: " + list);
            // FIXME make static
            listL.add(List.of("A", "C", "B"));

        } catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
        // simple example of List<List<String>>
        try {
            System.out.println("The List<List<String>> is: " + new NestedCollection().nestedList);
        } catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}
