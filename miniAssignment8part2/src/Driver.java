//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args){
        Food f1 = new Food("Banana", 27, 0, 1);
        Food f2 = new Food("Egg", 0, 5, 6 );
        Food f3 = new Food("Bagel", 56, 2, 11);

        ArrayList columnHeaders = new ArrayList();
        columnHeaders.add("Name");
        columnHeaders.add("Calories");
        //columnHeaders.add("Protein");
        //columnHeaders.add("Carbs");
        //columnHeaders.add("Fat");

        ArrayList columnItems = new ArrayList();
        columnItems.add("Name");
        columnItems.add("Calories");
        //columnItems.add("Protein");
        //columnItems.add("Carbs");
        //columnItems.add("Fat");


        TableTM t = new FoodTM(columnHeaders,columnItems);
        t.addItem(f1);
        t.addItem(f2);
        t.addItem(f3);
        t.printTable();

    }
}
