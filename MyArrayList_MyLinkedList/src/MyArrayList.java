import java.util.Arrays;
public class MyArrayList implements MyList {

    private int size = 0;
    private Object[] data = new Object[10];

    MyArrayList(){
        this.data = (Object[]) new Object[5];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i ++){
            if (data[i].equals(o))
                return true;
        }
        return false;
    }

    public void add(Object item) {
        if(size == data.length) {
            increaseSize();
        }
        data[size]=item;
        size++;
    }
    private void increaseSize(){
        Object[] temp = new Object[size * 2];
        for(int i=0; i< data.length; i++){
            temp[i]=data[i];
        }
        data = temp;
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
