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
    public void add(Object elem, int index) {
        if (index > size)
            throw new IndexOutOfBoundsException();
        if (size() == data.length)
            increaseSize();
        for (int i = size; i > index; i--){
            data[i] = data[i - 1];
        }
        data[index] = elem;
        size++;
    }


    public void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean remove(Object item) {
        remove(indexOf(item));
        return true;
    }

    public Object remove(int index) {
        Object temp = get(index);
        for (int i = index; i < size - 1; i++){
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        return temp;
    }


    public void clear() {
        size = 0;
        data = new Object[5];
    }

    public Object get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size - 1; i++){
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = size-1; i >= 0; i--){
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }


    public void sort() {
        Arrays.sort(data);
    }


}
