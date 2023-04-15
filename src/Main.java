import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyList();

        System.out.println(myList);

        myList.add("second");
        System.out.println(myList);

        String toRemove = "remove";
        myList.add(toRemove);
        System.out.println(myList);

        myList.add("third");
        System.out.println(myList);

        myList.add("forth");
        System.out.println(myList);

        myList.add("first", 0);
        System.out.println(myList);

        myList.add("remove");
        System.out.println(myList);

        myList.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.equals(o2) ? 0 : o1.compareTo(o2);
            }
        });
        System.out.println(myList);

        myList.remove(1);
        System.out.println(myList);

        myList.remove(toRemove);
        System.out.println(myList);

        System.out.println(myList.get(0));
        System.out.println(myList.indexOf(toRemove));
        System.out.println(myList.indexOf(myList.get(0)));
        System.out.println(myList.contains(myList.get(1)));
        System.out.println(myList.size());

        Collection<String> collection = new ArrayList<>();
        collection.add("x");
        collection.add("y");

        myList.addAll(collection);
        for (String element : myList)
            System.out.print(element + ", ");
        System.out.println();

        ListIterator<String> listIterator = myList.listIterator();
        for (int i = 0; i < 2; i++) {
            System.out.println(listIterator.hasNext());
            System.out.println(listIterator.next());
        }

        System.out.println(listIterator.hasNext());
        System.out.println(listIterator.nextIndex()); // 2

        for (int i = 0; i < 4; i++) {
            System.out.println(listIterator.next());
            System.out.println(listIterator.hasNext());
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(listIterator.hasPrevious());
            System.out.println(listIterator.previous());
        }

        System.out.println(listIterator.previousIndex()); // 1

        for (int i = 0; i < 3; i++) {
            System.out.println(listIterator.hasPrevious());
            System.out.println(listIterator.previous());
        }

        System.out.println(listIterator.next()); // TODO
        listIterator.remove();
        System.out.println(myList);

        listIterator.set("idk");
        System.out.println(myList);

        listIterator.add("last");
        System.out.println(myList);

        myList.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.indexOf(0) == 'f';
            }
        });
        System.out.println(myList);
    }
}