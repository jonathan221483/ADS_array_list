import java.util.Arrays;

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

    }



    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(Object item) {

    }

    @Override
    public void add(Object item, int index) {

    }

    @Override
    public boolean removeItem(Object item) {
        return false;
    }

    @Override
    public Object removeByIndex(int index) {
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
