import java.util.ArrayList;

//Table class that is generic
public class Table<T> {

    ArrayList<T> rowList; //Elements within a row
    ArrayList<columnStrategy> columnItems; //Will be built by a programmer using this code
    ArrayList<String> columnList;

    Table(ArrayList<String> columnList, ArrayList<columnStrategy> columnItems){

        this.rowList = new ArrayList<>();
        this.columnList = columnList;
        this.columnItems = columnItems;

    }

    public void addItem(T item){
        rowList.add(item);
    }

    public void removeItem(T item){
        rowList.remove(item);
    }

    public void printTable(){

        int sizeOfHeader = 0;
        String header = "";
        String offset = " "; //Offset of a word is two spaces to the right

        //Loop to place columns in the table
        //We automatically pad each column name with a two blanks on either side.
        //So the actual size of each column header = string length + 2.

        for(int i = 0; i < columnList.size(); i++){
            String item = offset + columnList.get(i) + offset;
            header = header + item;
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

            // loop for each column that needs to be printed
            for (int i = 0; i < columnItems.size(); i++) {
                T item = rowList.get(j);
                columnStrategy c = columnItems.get(i);
                String itemString = c.getItem(item);

                // remember we added a blank on either side of columnname
                int columnamesize = columnList.get(i).length() + 2;
                int pad = columnamesize - itemString.length();
                for(int k = 0; k < pad; k++){
                    System.out.print(" ");
                }
                System.out.print(itemString);


            }
            System.out.println();
        }

    }

}
