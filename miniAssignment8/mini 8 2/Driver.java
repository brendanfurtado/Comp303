//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args){
        Food f1 = new Food("Banana", 27, 0, 1);
        Food f2 = new Food("Egg", 0, 5, 6 );
        Food f3 = new Food("Bagel", 56, 2, 11);

        //This example is the usage of the column Strategy

        System.out.println("Results from the Strategy Pattern");
        System.out.println();
        ArrayList columnHeaders = new ArrayList();
        columnHeaders.add("Name");
        columnHeaders.add("Calories");
        //columnHeaders.add("Fat");
        //columnHeaders.add("Carbs");
        //columnHeaders.add("Protein");


        ArrayList<ColumnStrategyI> columnItems = new ArrayList();

        columnItems.add(new Name());
        columnItems.add(new Calories());
        //columnItems.add(new Fat());
        //columnItems.add(new Carbs());
        //columnItems.add(new Protein());

        Table t = new Table(columnHeaders, columnItems);
        t.addItem(f1);
        t.addItem(f2);
        t.addItem(f3);
        t.printTable();


        System.out.println();
        System.out.println();
        System.out.println("Results from the Template Method Pattern");
        System.out.println();

        ArrayList columnItemsM = new ArrayList();
        columnItemsM.add("Name");
        columnItemsM.add("Calories");
        //columnItemsM.add("Fat");
        //columnItemsM.add("Carbs");
        //columnItemsM.add("Protein");


        ArrayList columnMethods = new ArrayList();
        columnMethods.add("getName");
        columnMethods.add("getCaloriesString");
        //columnMethods.add("getFatString");
        //columnMethods.add("getCarbsString");
        //columnMethods.add("getProteinString");


        TableTM tm = new FoodTM(columnItemsM, columnMethods);
        tm.addItem(f1);
        tm.addItem(f2);
        tm.addItem(f3);
        tm.printTable();
    }
}
