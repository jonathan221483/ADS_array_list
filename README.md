# Algorithms and Data Structures | Khaimuldin Nursultan
## Assignment 2 | MyArrayList and MyLinkedList
### Methods needed to be implemented:

## ArrayList

. size() - returns size of ArrayList

. add(T element) - add element to the end of ArrayList

. add(T item, int index) - add element to ArrayList at specified index

. get(int index) - returns elements of ArrayList at the specified index

. contains(Object o) - returns true if ArrayList contain object

. toArray() - returns array from ArrayList

. removeItem(T o) - remove element from ArrayList

. addAll(int index, Collection<? extends T> c) - add elements from collection to ArrayList at specified index

. clear() - clear ArrayList: deletes all elements and size become equal zero

. set(int index, Object element) - set element at specified index

. removeByIndex(int index) - removes element at specified index from ArrayList

. indexOf(Object o) - returns index of object, if object does not exist in ArrayList return -1

. lastIndexOf(Object o) - returns index of object from the end, if object does not exist in ArrayList return -1

. sort() - sort ArrayList using sort algorithm


```
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
```



## LinkedList:

. size() - returns size of linked list

. add(T element) - add element to the end of LinkedList

. add(T item, int index) - add element to LinkedList at specified index

. contains(Object o) - returns true if LinkedList contain object

. removeItem(T item) - remove element from LinkedList

. removeByIndex(int index) - removes element at specified index from LinkedList

. clear() - clear LinkedList: deletes all elements and size become equal zero

. get(int index) - returns elements of LinkedList at the specified index

. getNode(int index) - returns Node object of LinkedList at the specified index

. indexOf(Object o) - returns index of object, if object does not exist in LinkedList return -1

. lastIndexOf(Object o) - returns index of object from the end, if object does not exist in LinkedList return -1

. sort() - sort LinkedList using quick sort algorithm

```
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
```


## It also needed to create Node class to manipulate the nodes in linked list:

```
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
```

# Both classes implements the same interface MyList.java
```
public interface MyList<T> {
    int size();
    boolean contains(Object o);
    void add(T item);
    void add(T item, int index);
    boolean removeItem(T item);
    T removeByIndex(int index);
    void clear();
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
```
