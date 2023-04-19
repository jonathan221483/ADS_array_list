public class Main {
    public static void main(String[] args) {
        /*MyArrayList a = new MyArrayList();
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

        a.sort();
        for (int i = 0; i < a.size(); i++)
            System.out.print(a.get(i)+", ");
        System.out.println("");
        System.out.println(a.lastIndexOf(1));
        System.out.println();*/



        MyArrayList b = new MyArrayList();
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
            System.out.print(b.get(i)+", ");
        System.out.println("");
        System.out.println(b.indexOf(23));
        System.out.println();


    }
}