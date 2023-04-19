public class MyLinkedList<T> implements MyList<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data){
            this.data = data;
        }
        public E getData() {
            return data;
        }
        public void setData(E data) {
            this.data = data;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public Node<E> getPrevious() {
            return previous;
        }
        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }

        MyLinkedList(){
            size = 0;
            head = null;
            tail = null;
        }

    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void checkIndex(int index){
        if (index > size)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void add(Object item) {

    }

    @Override
    public void add(Object item, int index) {
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


    private void connectFirst(Node<T> temp){
        temp.next = head;
        head.previous = temp;
        head = temp;
    }

    private void connectCenter(Node<T> temp, int index){
        Node<T> prev = getNode(index - 1);
        Node<T> next = getNode(index);
        prev.next = temp;
        temp.previous = next;
        next.previous = temp;
        temp.next = next;
    }

    private void connectLast(Node<T> temp){
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
    public boolean removeItem(Object item) {
        return false;
    }

    @Override
    public T removeByIndex(int index) {
        return null;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) {
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
