//Name: Brendan Furtado
//ID: 260737867

import java.lang.reflect.*;
import java.util.ArrayList;


public class FoodTM extends TableTM {

    FoodTM(ArrayList<String> columnList, ArrayList<String> columnMethods) {

        this.columnList = columnList;
        this.columnMethods = columnMethods;
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
    public void printRows() {

        String offset = "  "; //Offset of a word is two spaces to the right

        //Loop for items in the rows and print them
        for (int j = 0; j < rowItems.size(); j++) {

            System.out.print(offset);

            //Loop for each column that needs to be printed
            //Use java reflection to get the method to call
            //I used the reflection pattern because I found myself using a lot of else-if statements
            // I found that this solved that problem.
            for (int i = 0; i < columnList.size(); i++) {

                String methodName = (String) columnMethods.get(i);
                String headerName = (String) columnList.get(i);

                try {

                    //First get the food object created from the driver main
                    Food food = (Food) rowItems.get(j);

                    //Using java reflection, get the object Method from the class using getMethod
                    //methodName should be the Strings that were inserted in the driver main eg: "getName" or "getCaloriesString"
                    Method columnMethod = food.getClass().getMethod(methodName);

                    //Finally call the method indirectly using invoke
                    String columnValue = (String) columnMethod.invoke(food);

                    //Pad for formatting
                    pad(headerName, columnValue);
                    System.out.print(columnValue);
                }

                catch (NoSuchMethodException | InvocationTargetException e) {
                    System.out.println(e.toString());
                }
                catch (Exception e) {
                    System.out.println(e.toString());
                }
            }

            System.out.println();
        }
    }

    @Override
    public void pad(String category, String item) {
        for(int k = 0; k < category.length() + 2 - item.length() ; k++){
            System.out.print(" ");
        }
    }
}
