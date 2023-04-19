import java.util.Arrays;
public class MyArrayList implements MyList {

    private int size;
    private Object[] data = new Object[10];

    public int size() {
        return size;
    }


    public boolean contains(Object o) {
        return false;
    }


    public void add(Object item) {
        size++;
        data = Arrays.copyOf(data, data.length+1);
        data[size]=item;
    }

    @Override
    public void add(Object item, int index) {

    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
