//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args){
        Food f1 = new Food("Banana", 27, 0, 1);
        Food f2 = new Food("Egg", 0, 5, 6 );
        Food f3 = new Food("Bagel", 56, 2, 11);

        //This example is the usage of the column Strategy
        ArrayList columnHeaders = new ArrayList();
        columnHeaders.add("Name");
        columnHeaders.add("Calories");
        columnHeaders.add("Protein");
        //columnHeaders.add("Carbs");
        //columnHeaders.add("Fat");

        ArrayList<ColumnStrategyI> columnItems = new ArrayList();

        columnItems.add(new Name());
        columnItems.add(new Calories());
        columnItems.add(new Protein());
        //columnItems.add(new Carbs());
        //columnItems.add(new Fat());


        Table t = new Table(columnHeaders, columnItems);
        t.addItem(f1);
        t.addItem(f2);
        t.addItem(f3);
        System.out.println("Strategy design output: ");
        System.out.println();

        t.printTable();

        System.out.println();

        //Part 2 question
        ArrayList columnItems2 = new ArrayList();
        columnItems2.add("Name");
        columnItems2.add("Calories");
        columnItems2.add("Protein");
        //columnItems2.add("Carbs");
        //columnItems2.add("Fat");
        TableTM tm = new FoodTM(columnHeaders);
        tm.addItem(f1);
        tm.addItem(f2);
        tm.addItem(f3);
        System.out.println("Template method design output: ");
        System.out.println();

        tm.printTable();

    }
}
