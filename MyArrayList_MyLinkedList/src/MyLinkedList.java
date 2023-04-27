import java.util.Arrays;
import java.util.Comparator;

public class MyLinkedList<T> implements MyList<T>{

    private Node<T> head; //head of the list (first element)
    private Node<T> tail; //tail of the list (last element)
    private int size = 0;  //size of linked list
    private class Node<E>{ //Node class needed for manipulating the nodes inside linked list
        private E data; //the elements of list
        private Node<E> next;
        private Node<E> previous;

        public Node(E data){ //constructor for node
            this.data = data;
        }
        public E getData() { //take data from node
            return data;
        }
        public void setData(E data) { //change data in node
            this.data = data;
        }
        public Node<E> getNext() { //get the element from next node
            return next;
        }
        public void setNext(Node<E> next) { //change the element in next node
            this.next = next;
        }
        public Node<E> getPrevious() { //get the element from previous node
            return previous;
        }
        public void setPrevious(Node<E> previous) { //change the element in previous node
            this.previous = previous;
        }
    }

        MyLinkedList(){ //constructor for Linked list
            size = 0;
            head = null;
            tail = null;
        }

    public int size() { //returns the size of list
        return size;
    }

    @Override
    public boolean contains(Object o) { //return true if the given Object parameter is inside the linked list
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void checkIndex(int index){ //checks if given index is outside the boundaries of list
        if (index > size)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(Object item) { //adds item to linked list
        add(item, size);
    }

    @Override
    public void add(Object item, int index) { //adds item into particular index in linked list
        checkIndex(index);
        Node<T> temp = (Node<T>) new Node<>(item);
        size ++;
        if (head == null) {
            head = temp;
            tail = temp;
            return;
        }
        if (index == 0) {
            connectFirst(temp);
            return;
        }
        if (index + 1 != size()) {
            connectCenter(temp, index);
            return;
        }
        connectLast(temp);
    }


    private void connectFirst(Node<T> temp){ //connects node to the beginning
        temp.next = head;
        head.previous = temp;
        head = temp;
    }

    private void connectCenter(Node<T> temp, int index){ //connects node to the center of the list
        Node<T> prev = getNode(index - 1);
        Node<T> next = getNode(index);
        prev.next = temp;
        temp.previous = next;
        next.previous = temp;
        temp.next = next;
    }

    private void connectLast(Node<T> temp){ //connects node to the ending
        tail.next = temp;
        temp.previous = tail;
        tail = temp;
    }

    public Node<T> getNode(int index){ // get node by it index
        checkIndex(index);
        Node<T> temp = head;
        int i = 0;
        while (temp != null){
            if (i == index)
                return temp;
            i++;
            temp = temp.next;
        }
        return null;
    }

    @Override
    public boolean removeItem(Object item) { //removes given element in list
        removeByIndex(indexOf(item));
        return true;
    }

    @Override
    public T removeByIndex(int index) { //removes element in given index in the list
        T temp = get(index);
        if (index == 0) {
            head = head.next;
            if (size > 1) head.previous = null;
        }
        else if (index == size) {
            tail = tail.previous;
            if (size > 2) tail.next = null;
        }
        else {
            Node<T> previous = getNode(index - 1);
            Node<T> next = getNode(index + 1);
            previous.next = next;
            next.previous = previous;
        }
        size--;
        return temp;
    }

    @Override
    public void clear() { //fully clears the linked list
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) { //returns the element in given index
        checkIndex(index);
        Node present;
        if (index <= size / 2) {
            present = head;
            for (int i = 0; i < index; i++)
                present = present.next;
        }
        else {
            present = tail;
            for (int i = size - 1; i > index; i--)
                present = present.previous;
        }
        return (T) present.data;
    }

    @Override
    public int indexOf(Object o) { //returns index of the given item
        Node<T> element = head;
        int i = 0;
        while (element != null){
            if(i==size)
                return -1;
            if (element.getData().equals(o))
                return i;
            i++;
            element = element.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) { //returns last encountered index of the given item
        Node<T> element = tail;
        int i = size - 1;
        while (element != null){
            if (element.getData().equals(o))
                return i;
            i --;
            element = element.previous;
        }
        return -1;
    }

    @Override
    public void sort() {
    }



    public Object[] sublist(int first, int last) {
        checkIndex(first);
        checkIndex(last);
        Object[] sub = new Object[last-first+1];
        Node present;

        for(int i = first; i<=last; i++) {
            if (i <= size / 2) {
                present = head;
                for (int j = 0; j < i; j++)
                    present = present.next;
            } else {
                present = tail;
                for (int j = size - 1; j > i; j--)
                    present = present.previous;
            }
            sub[i - first] = present.data;
        }
        /*Comparator<Object> c = null;
        for(int i = 0; i < sub.length; i++)
        {
            for(int j = i+1; j < sub.length; j++)
            {
                if(c.compare(sub[i],sub[j])>0)
                {
                    Object temp = sub[i];
                    sub[i]=sub[j];
                    sub[j]=temp;
                }
            }
        }*/
        Arrays.sort(sub);
        return sub;
    }
}
