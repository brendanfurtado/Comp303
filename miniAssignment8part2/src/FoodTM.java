//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

public class FoodTM extends TableTM {

    FoodTM(ArrayList<String> column, ArrayList<String> columnItems){
        this.columnList = column;
        this.columnItems  = columnItems;
    }

    @Override
    public void printColumn() {
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

                String category = getColumnCategory(i);
                Food item = (Food) rowList.get(j);

                if(category.equalsIgnoreCase("Name")){

                    pad(category, item.getName());
                    System.out.print(item.getName());
                }

                else if(category.equalsIgnoreCase("Calories")){
                    pad(category, item.getCaloriesString());
                    System.out.print(item.getCaloriesString());
                }
                else if(category.equalsIgnoreCase("Carbs")){
                    pad(category, item.getCarbsString());
                    System.out.print(item.getCarbsString());
                }
                else if(category.equalsIgnoreCase("Fat")){
                    pad(category, item.getFatString());
                    System.out.print(item.getFatString());
                }
                else if(category.equalsIgnoreCase("Protein")){
                    pad(category, item.getProteinString());
                    System.out.print(item.getProteinString());
                }
            }
            System.out.println();
        }
    }

    @Override
    public String getColumnCategory(int i) {
        return (String) columnList.get(i);

    }

    @Override
    public void pad(String category, String item) {
        for(int k = 0; k < category.length() + 2 - item.length() ; k++){
            System.out.print(" ");
        }
    }
}
