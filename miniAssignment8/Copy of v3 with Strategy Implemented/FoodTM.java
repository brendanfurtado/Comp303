//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

public class FoodTM extends TableTM {

    FoodTM(ArrayList<String> columnList){
        this.columnList = columnList;
    }

    @Override
    public void printHeader() {
        int sizeOfHeader = 0;
        String header = "";
        String offset = "  "; //Offset of a word is two spaces to the right

        //Loop to place columns in the table
        for (int i = 0; i < columnList.size(); i++) {
            header = header + offset;
            String item = (String) columnList.get(i);
            header = header + item;
            header = header + " ";
        }
        System.out.println(header);

        sizeOfHeader = header.length();
        //Loop for bar below column variables
        for (int i = 0; i < sizeOfHeader; i++) {
            System.out.print("-");
        }

        System.out.println();

    }

    @Override
    public void printRow() {
        //Loop for items in the rows and print them

        for (int j = 0; j < rowList.size(); j++) {

            System.out.print("  "); //Offset
            // loop for each column that needs to be printed
            for (int i = 0; i < columnList.size(); i++) {

                String columnName = (String) columnList.get(i);
                Food item = (Food) rowList.get(j);

                if(columnName.equalsIgnoreCase("Name")){
                    pad(columnName, item.getNameString());
                    System.out.print(item.getNameString());
                }

                else if(columnName.equalsIgnoreCase("Calories")){
                    pad(columnName, item.getCaloriesString());
                    System.out.print(item.getCaloriesString());
                }
                else if(columnName.equalsIgnoreCase("Carbs")){
                    pad(columnName, item.getCarbsString());
                    System.out.print(item.getCarbsString());
                }
                else if(columnName.equalsIgnoreCase("Fat")){
                    pad(columnName, item.getFatString());
                    System.out.print(item.getFatString());
                }
                else if(columnName.equalsIgnoreCase("Protein")){
                    pad(columnName, item.getProteinString());
                    System.out.print(item.getProteinString());
                }
            }
            System.out.println();
        }
    }

    @Override
    public void pad(String columnName, String columnValue) {
        for(int k = 0; k < columnName.length() + 2 - columnValue.length() ; k++){
            System.out.print(" ");
        }
    }
}
