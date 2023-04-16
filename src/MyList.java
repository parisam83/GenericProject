import java.util.*;
import java.util.function.Predicate;

public class MyList<E> implements Iterable<E>{
    private int size = 0;
    private Object[] elements = {};
    //private Object[] elements = new Object[0];

    public void add(E newElement){
        updateCapacity(1);
        elements[size] = newElement;
        updateSize(1);
    }

    public void add(E newElement, int index){
        updateCapacity(1);
        for (int i = size - 1; i >= index; i--)
            elements[i + 1] = elements[i];
        elements[index] = newElement;
        updateSize(1);
    }

    public void remove(E deleteElement){
        int deleteIndex = indexOf(deleteElement);
        remove(deleteIndex);
    }

    public void remove(int deleteIndex){
        for (int i = deleteIndex + 1; i < size; i++)
            elements[i - 1] = elements[i];
        updateCapacity(-1);
        updateSize(-1);
    }

    public E get(int index){
        return (E) elements[index];
    }

    public int indexOf(E element){
        for (int i = 0; i < size; i++)
            if (elements[i] == element)
                return i;
        return -1;
    }

    public boolean contains(E element){
        return indexOf(element) != (-1);
    }

    public int size(){
        return size;
    }

    public ListIterator<E> listIterator(){
        return new ListIterator<E>() {
            int cursor; // index of next element to return
            int lastReturned = -1; // index of last returned element; -1 if no such
            //boolean cursorDirection = true, remove = false;

            @Override
            public boolean hasNext() {
                return cursor != size;
            }

            @Override
            public E next() {
                cursor++;
                return (E) elements[lastReturned = (cursor - 1)];
            }

            @Override
            public boolean hasPrevious() {
                return cursor != 0;
            }

            @Override
            public E previous() {
                return (E) elements[lastReturned = --cursor];
            }

            @Override
            public int nextIndex() {
                return cursor;
            }

            @Override
            public int previousIndex() {
                return cursor - 1;
            }

            @Override
            public void remove() {
                MyList.this.remove(lastReturned);
                cursor = lastReturned;
                lastReturned = -1;
            }

            @Override
            public void set(E e) {
                MyList.this.set(lastReturned, e);

            }

            @Override
            public void add(E e) {
                MyList.this.add(e, cursor);
                cursor++;
                lastReturned = -1;
            }
        };
    }

    public Iterator<E> iterator(){
        return new Iterator<E>() {
            int lastReturned = -1; // index of last returned value

            @Override
            public boolean hasNext() {
                return lastReturned + 1 < size;
            }

            @Override
            public E next() {
                return (E) elements[++lastReturned];
            }
        };
    }

    public void sort(Comparator<? super E> comparator){
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++)
                if (comparator.compare((E) elements[i], (E) elements[j]) > 0)
                    swap(i, j);
    }

    public void addAll(Collection<? extends E> collection){
        updateCapacity(collection.size());
        int index = size;
        for (E collectionMember : collection)
            elements[index++] = collectionMember;
        updateSize(collection.size());
    }

    public void removeIf(Predicate<E> predicate){
        for (int i = 0; i < size; i++)
            if (predicate.test((E) elements[i]))
                remove(i);
    }

    // my methods
    public void set(int index, E element){
        elements[index] = element;
    }
    public void updateCapacity(int difference){
        Object[] newElements = new Object[size + difference];
        for (int i = 0; i < Math.min(size, size + difference); i++)
            newElements[i] = elements[i];
        elements = newElements;
    }
    public void updateSize(int difference){
        size += difference;
    }

    public void swap(int index1, int index2){
        E tmp = (E) elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = tmp;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
