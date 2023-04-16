import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        System.out.println("Line 7: " + myList);

        myList.add("second");
        System.out.println("Line 10: " + myList);

        String toRemove = "remove";
        myList.add(toRemove);
        System.out.println("Line 14: " + myList);

        myList.add("third");
        System.out.println("Line 17: " + myList);

        myList.add("forth");
        System.out.println("Line 20: " + myList);

        myList.add("first", 0);
        System.out.println("Line 23: " + myList);

        myList.add("remove");
        System.out.println("Line 26: " + myList);

        myList.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.equals(o2) ? 0 : o1.compareTo(o2);
            }
        });
        System.out.println("Line 35: " + myList);

        myList.remove(1);
        System.out.println("Line 38: " + myList);

        myList.remove(toRemove);
        System.out.println("Line 41: " + myList);

        System.out.println("Line 43: " + myList.get(0));
        System.out.println("Line 44: " + myList.indexOf(toRemove));
        System.out.println("Line 45: " + myList.indexOf(myList.get(0)));
        System.out.println("Line 46: " + myList.contains(myList.get(1)));
        System.out.println("Line 47: " + myList.size());

        Collection<String> collection = new ArrayList<>();
        collection.add("x");
        collection.add("y");

        myList.addAll(collection);
        System.out.print("Line 54: ");
        for (String element : myList)
            System.out.print(element + ", ");
        System.out.println();

        ListIterator<String> listIterator = myList.listIterator();
        for (int i = 0; i < 2; i++) {
            System.out.println("Line 61-" + (i+1) + ": " + listIterator.hasNext());
            System.out.println("Line 62-" + (i+1) + ": " + listIterator.next());
        }

        System.out.println("Line 65: " + listIterator.hasNext());
        System.out.println("Line 66: " + listIterator.nextIndex()); // 2

        for (int i = 0; i < 4; i++) {
            System.out.println("Line 69-" + (i+1) + ": " + listIterator.next());
            System.out.println("Line 70-" + (i+1) + ": " + listIterator.hasNext());
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Line 74-" + (i+1) + ": " + listIterator.hasPrevious());
            System.out.println("Line 75-" + (i+1) + ": " + listIterator.previous());
        }

        System.out.println("Line 78: " + listIterator.previousIndex()); // 2

        for (int i = 0; i < 2; i++) {
            System.out.println("Line 81-" + (i+1) + ": " + listIterator.hasPrevious());
            System.out.println("Line 82-" + (i+1) + ": " + listIterator.previous());
        }

        System.out.println("Line 85: " + listIterator.hasPrevious());
        System.out.println(myList);
        System.out.println("Line 87: " + listIterator.next()); // remove
        listIterator.remove();
        System.out.println("Line 89: " + listIterator.nextIndex());
        System.out.println("Line 90: " + listIterator.previousIndex());
        System.out.println("Line 91: " + myList);
        System.out.println("Line 92: " + myList.indexOf("remove"));

        listIterator.add("addedString");
        System.out.println("Line 95: " + myList);
        System.out.println("Line 96: " + listIterator.next());
        System.out.println("Line 97: " + myList);
        listIterator.set("idk");
        System.out.println("Line 99: " + myList);

        listIterator.add("last");
        System.out.println("Line 102: " + myList);

        listIterator.add("five");
        System.out.println("Line 105: " + myList);

        myList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.charAt(0) == 'f';
            }
        });
        System.out.println("Line 113: " + myList);
    }
}