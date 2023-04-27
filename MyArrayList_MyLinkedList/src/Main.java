public class Main {
    public static void main(String[] args) {
       MyArrayList a = new MyArrayList();
        a.add(1);
        a.add(5);
        a.add(3);
        a.add(7);
        a.add(1);
        a.add(3);
        a.add(87);
        a.add(1);
        a.add(8);
        a.add(3);

        for (int i = 0; i < a.size(); i++)
            System.out.print(a.get(i)+", ");
        System.out.println("");
        System.out.println("ArrayList sublist:");
        Object[] sub = a.sublist(5,9);
        for (int i = 0; i < sub.length; i++)
        System.out.print(sub[i]+" ");
        System.out.println("");
        System.out.println("");

        MyLinkedList b = new MyLinkedList();
        b.add(1);
        b.add(5);
        b.add(3);
        b.add(7);
        b.add(8);
        b.add(64);
        b.add(87);
        b.add(74);
        b.add(45);
        b.add(23);
        for (int i = 0; i < b.size(); i++)
            System.out.print(b.get(i)+" ");
        System.out.println("");
        System.out.println("LinkedList sublist:");
        Object[] sub2 = b.sublist(2,6);
        for (int i = 0; i < sub2.length; i++)
            System.out.print(sub2[i]+" ");
    }
}


//return sort sublist