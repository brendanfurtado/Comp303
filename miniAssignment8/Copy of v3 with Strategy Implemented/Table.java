//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

//Table class that is generic
public class Table<T> {

    ArrayList<T> rowList; //Elements within a row
    ArrayList<ColumnStrategyI> columnItems; //Will be built by a programmer using this code
    ArrayList<String> columnList; //Act as the column header,

    Table(ArrayList<String> columnList, ArrayList<ColumnStrategyI> columnItems){

        this.rowList = new ArrayList<>();
        this.columnList = columnList;
        this.columnItems = columnItems;

    }

    //Basic remove and add item to the rowList
    public void addItem(T item){
        rowList.add(item);
    }

    public void removeItem(T item){
        rowList.remove(item);
    }

    public void printTable(){

        int sizeOfHeader = 0;
        String header = ""; //Header will be built according to what is in the column list
        String offset = "  "; //Offset of a word is two spaces to the right

        //Loop to place columns in the table
        for(int i = 0; i < columnList.size(); i++){
            header = header + offset;
            String item = columnList.get(i);
            header = header + item;
            header = header + " ";
        }
        System.out.println(header);

        sizeOfHeader = header.length();
        //Loop for bar below column variables
        for(int i = 0; i < sizeOfHeader; i++){
            System.out.print("-");
        }

        System.out.println();

        //Loop for items in the rows and print them
        for (int j = 0; j < rowList.size(); j++ ) {

            System.out.print(offset);

            // loop for each column that needs to be printed
            for(int i = 0; i < columnItems.size(); i++) {

                T item = rowList.get(j);
                ColumnStrategyI c = columnItems.get(i);
                String itemString = c.getItem(item); //Retrieves the respective info of the item based on category,
                                                    // the category depends on what is received by ColumnStrategyI c in the previous line

                String s = columnList.get(i);
                int columnSize = s.length() + 2; //Allocated space for each column.

                for(int k = 0; k < columnSize - itemString.length(); k++){
                    System.out.print(" ");
                }

                System.out.print(itemString);

            }
            System.out.println();
        }

    }

}
