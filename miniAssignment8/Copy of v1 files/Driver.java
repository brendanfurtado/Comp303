import java.util.ArrayList;

public class Driver {

    public static void main(String[] args){
        Food f1 = new Food("Banana", 27, 0, 1);
        Food f2 = new Food("Egg", 0, 5, 6 );
        Food f3 = new Food("Bagel", 56, 2, 11);

        ArrayList columnList = new ArrayList();
        columnList.add("Name");
        columnList.add("Calories");

        Table t = new Table(columnList);
        t.addItem(f1);
        t.addItem(f2);
        t.addItem(f3);
        t.printTable();
    }
}
