//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal

public class MapTest {


    public static void main(String[] args){

        try {

            //Test one
            System.out.println("Test cases for method <<MapConstructor>> : ");

            //Function tester() calls
            //First parameter is the max rows, second is the max columns
            mapTest(10, -1); //Max column value is negative, failure
            mapTest(0, 0);   //Invalid max row and column values, failure
            mapTest(0, -5);  //Same as above, failure
            mapTest(10, 10); //Success, valid positive integers
            mapTest('c', 'd'); //Auto converts according to ASCII values, success

            System.out.println();

            //Test two, initializing a Map
            System.out.println("Test cases for method <<initializeMap>> : ");

            //in order for test to work a map has to have been constructed
            Map mapTestTwo = new Map(10, 10); //Have fixed dimensions
            initializeMapTest(mapTestTwo);

            //Map mapTestTwo2 = new Map(-1, 100); //We've already established that negative values are invalid from tests above
                                                  //Using valid integers for maxRow and maxColumn have to be used in order to test initializeMap()
            //initializeMapTest(mapTestTwo2);


            System.out.println();


            //Test three, in order to work you need an initialized map already
            System.out.println("Test cases for method <<replaceCharacter>> : ");
            Map mapTestThree = new Map(10, 10); //Again have fixed dimensions

            replaceCharacterTest(mapTestThree, '~', 10, 10); //Boundary test case, expect Failure
            replaceCharacterTest(mapTestThree, '#', 9, 0);   //Boundary & zero case, expect Success
            replaceCharacterTest(mapTestThree, '~', 0, 0);   //Boundary test case, expect Success
            replaceCharacterTest(mapTestThree, 'G', 5, 5);   //Success
            replaceCharacterTest(mapTestThree, '7', 5, 5);  //Character input invalid, failure
            replaceCharacterTest(mapTestThree, 'G', -1, 5);  //Negative input row, failure
            replaceCharacterTest(mapTestThree, 'G', 5, 100); //Out of bounds in the column input, failure
            replaceCharacterTest(mapTestThree, '#', 0, 9);   //Success
            replaceCharacterTest(mapTestThree, '#', 5, -100); //Failure, negative value and out of bounds for column

            System.out.println();

            //Testing part 4, getters and setters

            int establishedRow = 10;
            int establishedColumn = 5;

            //Test getMaxRow() and getMaxColumn()
            System.out.println("Test cases for method <<getMaxRow>> : ");


            //Map mapTestGetters = new Map(-5, 0); //Note retrieving invalid input will not work
                                                   //Again here we assume that the constructor works with valid integers

            Map mapTestGetters = new Map(establishedRow, establishedColumn);

            //Row test for getter
            getMaxRowTest(mapTestGetters, establishedRow);

            System.out.println();

            System.out.println("Test cases for method <<getMaxColumn>> : ");

            //Column test for getter
            getMaxColumnTest(mapTestGetters, establishedColumn);

            System.out.println();

            //Test setMaxRow() and setMaxColumn
            Map mapTestSetters = new Map(establishedRow, establishedColumn);

            System.out.println("Test cases for method <<setMaxRow>> : ");

            //Row tests for setter
            setMaxRowTest(mapTestSetters, establishedRow, 20);
            setMaxRowTest(mapTestSetters, establishedRow, 1);
            setMaxRowTest(mapTestSetters, establishedRow, 0); //Should fail since maxRow needs to be >= 0
            setMaxRowTest(mapTestSetters, establishedRow, -10); //Should fail for same reason above

            System.out.println();


            System.out.println("Test cases for method <<setMaxColumn>> : ");

            //Column tests for setter
            setMaxColumnTest(mapTestSetters, establishedRow, 20);
            setMaxColumnTest(mapTestSetters, establishedRow, 1);
            setMaxColumnTest(mapTestSetters, establishedRow, 0); //Should fail since maxRow needs to be >= 0
            setMaxColumnTest(mapTestSetters, establishedRow, -10); //Should fail for same reason above


            System.out.println();

        }catch (Exception e){
            System.out.println("Invalid input");
        }
    }//End of main


    //Start of Tester methods

    //Tester for Constructor Map in Map.java
    public static void mapTest(int inputMaxRows, int inputMaxColumns){

        try {
            Map testMap = new Map(inputMaxRows, inputMaxColumns);

            System.out.println("Arguments: <<" + inputMaxRows + "," + inputMaxColumns + ">> Result: <<Success>> ");

        } catch(Exception e) {
            System.out.println("Arguments: <<" + inputMaxRows + "," + inputMaxColumns + ">> Result: <<Failure>> ");
        }

    }//End of constructor tester

    //Tester for initialzeMap()
    public static void initializeMapTest(Map map){

        try {

            map.initializeMap();

            if(map.getInitialized()){
                System.out.println("Arguments: <<map>> Result: <<Successfully Initialized>> ");
            }
            else
                System.out.println("Arguments: <<map>> Result: <<Failure in Initialization>> ");

        }catch(Exception e){
            System.out.println("Arguments: <<map>> Result: <<Failure in Initialization>> ");
        }
    }


    //Uses an already constructed map as the map constructor was tested and validated for correctness prior to these tests
    public static void replaceCharacterTest(Map map, char mapCharacter, int inputRow, int inputColumn){

        try{

            //If placement is valid within the bounds of the graph, boolean would be true and the test would be a success
            boolean isValidCharacter = map.replaceCharacter(mapCharacter, inputRow, inputColumn);

            if(isValidCharacter){
                System.out.println("Arguments: <<" + mapCharacter + "," + inputRow + "," + inputColumn + ">> Result: <<Success>> ");
            }

        }catch (Exception e){
            System.out.println("Arguments: <<" + mapCharacter + "," + inputRow + "," + inputColumn + ">> Result: <<Failure>> ");
        }

    }

    //Setters and getters testing
    public static void getMaxRowTest(Map map, int currentMaxRow){

        try{

            //If the getter is productive, it will retrieve the max value of the dimension making it a success
            if( map.getMaxRow() == currentMaxRow && map.getInitialized()){
                System.out.println("Arguments: <<map" + "," + currentMaxRow + ">> Result: <<Success in retrieving max row>>" );
            }

        }catch(Exception e){
            System.out.println("Arguments: <<map" + "," + currentMaxRow + ">> Result: <<Failure in retrieving max row>>" );
        }//If here, getter failed
    }

    public static void getMaxColumnTest(Map map, int currentMaxColumn ){

        try{

            //If the getter is productive, it will retrieve the max value of the dimension making it a success
            if( map.getMaxColumn() == currentMaxColumn && map.getInitialized()){
                System.out.println("Arguments: <<map" + "," + currentMaxColumn + ">> Result: <<Success in retrieving max column>>" );
            }

        }catch(Exception e){
            System.out.println("Arguments: <<map" + "," + currentMaxColumn + ">> Result: <<Failure in retrieving max column>>" );
        }//If here, getter failed

    }

    public static void setMaxRowTest(Map map, int previousRowMax, int newRowMax){

        try{

            map.setMaxRow(newRowMax);

            //This will indicate if a change in the row dimension has been made with newRowMax being the new value
            if(map.getMaxRow() != previousRowMax){
                System.out.println("Arguments: <<map" + "," + previousRowMax + "," + newRowMax + ">> Result: <<Success in changing row dimension>>" );
            }

        }catch(Exception e){
            //Otherwise, if no change is made to the value, failure
            System.out.println("Arguments: <<map" + "," + previousRowMax + "," + newRowMax + ">> Result: <<Failure in changing row dimension>>" );
        }

    }

    public static void setMaxColumnTest(Map map, int previousColumnMax, int newColumnMax){

        try{
            map.setMaxColumn(newColumnMax);

            //This will indicate if a change in the column dimension has been made with newColumnMax being the new value
            if(map.getMaxColumn() != previousColumnMax){
                System.out.println("Arguments: <<map" + "," + previousColumnMax + "," + newColumnMax + ">> Result: <<Success in changing column dimension>>" );
            }

        }catch(Exception e){
            //Otherwise, if no change is made to the value, failure
            System.out.println("Arguments: <<map" + "," + previousColumnMax + "," + newColumnMax + ">> Result: <<Failure in changing column dimension>>" );
        }
    }
}