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

        a.sort();
        for (int i = 0; i < a.size(); i++)
            System.out.print(a.get(i)+", ");
        System.out.println("");
        System.out.println(a.lastIndexOf(1));
        System.out.println();
    }
}