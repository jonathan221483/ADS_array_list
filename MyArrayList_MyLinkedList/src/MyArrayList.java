import java.util.Arrays;
public class MyArrayList implements MyList {

    private int size = 0; //size of array
    private Object[] data = new Object[10]; //creation of array of objects to collect data

    MyArrayList(){ //constructor for MyArrayList
        this.data = (Object[]) new Object[5];
        this.size = 0;
    }

    public int size() { //returns the size of arraylist
        return size;
    }

    public boolean contains(Object o) { //return true if the given Object parameter is inside the arraylist
        for (int i = 0; i < size; i ++){
            if (data[i].equals(o))
                return true;
        }
        return false;
    }

    public void add(Object item) { //adds item to arraylist
        if(size == data.length) {
            increaseSize();
        }
        data[size]=item;
        size++;
    }
    private void increaseSize(){ //used to increase the size of arraylist to add more elements
        Object[] temp = new Object[size * 2];
        for(int i=0; i< data.length; i++){
            temp[i]=data[i];
        }
        data = temp;
    }

    @Override
    public void add(Object elem, int index) { //also adds item to arraylist, but user can choose the index where it will be put
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


    public void checkIndex(int index){ //checks if given index is outside the boundaries of array
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean removeItem(Object item) { //removes given item from arraylist
        removeByIndex(indexOf(item));
        return true;
    }

    public Object removeByIndex(int index) { //removes item with given index
        checkIndex(index);
        Object temp = get(index);
        for (int i = index+1; i < size; i++){
            data[i-1] = data[i];
        }
        size--;
        return temp;
    }


    public void clear() { //fully clears the array by creating a new empty one
        size = 0;
        data = new Object[5];
    }

    public Object get(int index) { //returns element in given index
        checkIndex(index);
        return data[index];
    }

    public int indexOf(Object o) { //returns first index of given element, if there is no such element returns -1
        for (int i = 0; i < size - 1; i++){
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) { //returns last index of given element, if there is no such element returns -1
        int index = -1;
        for (int i = size-1; i >= 0; i--){
            if(data[i].equals(o))
                return i;
        }
        return -1;
    }


    public void sort() { //sorts the arraylist
        Arrays.sort(data);
    }


}
