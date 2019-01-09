

/**
 * <p>This is the tester for the Map object. All te</p>
 *<b>I noticed that tests will not continue to show any other failure after the first failure. I still added
 * failures just in case, however, when MapTest is run, it will only display the first encounter of a test failure.  </b>
 *
 * @author: Brendan Furtado
 * @version 1.1
 * <p>ID: 260737867</p>
 * <p>Course: Comp 303, Vybihal</p>
 *
 */

import org.junit.Test;
import static org.junit.Assert.*;

//For test runner
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class MapTest{


    private Map mapTest;


    /**
     * <p>This test combines both functionality in the Map constructor and the method initializeMap.
     * An assertion will be only true if a map object was properly made and initialized. If any error were to occur,
     * it would most likely be in the construction of the map object, as it will throw an exception if the input
     * dimensions are improper. </p>
     */
    @Test
    public void testInitializeMap()  {
        int numberOfTests = 0;

        try {

            numberOfTests++;
            mapTest = new Map(10, 10); //Have fixed dimensions
            // Method isInitialized (from original submission) checks to see the map is initialized.
            assertTrue(mapTest.getInitialized()); //Actual value should be true.

            numberOfTests++;
            mapTest = new Map(20, 10);
            assertTrue(mapTest.getInitialized());

            numberOfTests++;
            mapTest = new Map(1000, 999);
            assertTrue(mapTest.getInitialized());

            numberOfTests++;
            mapTest = new Map(-10, 10); //Should throw an exception so following lines won't execute
            assertTrue(mapTest.getInitialized());  //Expected to not reach here as the input will lead to an exception.



        } catch (Exception e) { //Tests will stop at the first error/exception encounter.

            System.out.println("Test number " + numberOfTests + " failed for testInitializeMap. All tests before succeeded. Stopping tests...");

        }
    }

    /**
     * <p>This test will evaluate if a character was placed onto the map correctly. With fixed dimensions,
     * tests will replace characters inside the map and then use the getChar method to verify the character's
     * existence. It will fail if an invalid character is inputted or if a dimension is outside the boundary.</p>
     *
     */
    @Test
    public void testReplaceCharacter() {

        int numberOfTests = 0;

        try {


            mapTest = new Map(10, 10); //Fix  boundaries for insertion


            numberOfTests++;
            mapTest.replaceCharacter('G', 5, 5); //Place char into map

            assertEquals(mapTest.getChar(5,5), 'G'); //Will be good if the char placed == the char intended to place

            //-------------------
            numberOfTests++;
            mapTest.replaceCharacter('#', 9, 0);

            assertEquals(mapTest.getChar(9, 0), '#');

            //-------------------

            numberOfTests++;
            mapTest.replaceCharacter('7', 5, 5); //Expected to fail because of invalid character

            assertEquals(mapTest.getChar(-1, 5), '~');


            //-------------------

            numberOfTests++;
            mapTest.replaceCharacter('G', 100, 100); //Expected to fail because of invalid input dimensions

            assertEquals(mapTest.getChar(100, 100), 'G');

            //-------------------

            numberOfTests++;
            mapTest.replaceCharacter('~', 0, 0);

            assertEquals(mapTest.getChar(0, 0), '~');

            //-------------------

            numberOfTests++;
            mapTest.replaceCharacter('G', -5, 0); //Expected to fail because one input dimension is negative

            assertEquals(mapTest.getChar(-5, 0), 'G');



        }catch (Exception e){
            System.out.println("Test number " + numberOfTests + " failed for testReplaceCharacter. All tests before succeeded. Stopping tests...");
        }
    }


    /**
     * <p>Will test the retrieval of the max row in a map object.</p>
     */

    @Test
    public void testGetMaxRow()  {

        int numberOfTests = 0;

        try {

            numberOfTests++;
            mapTest = new Map(10,110);
            assertEquals(mapTest.getMaxRow(), 10);


            numberOfTests++;
            mapTest = new Map(500,1000);
            assertEquals(mapTest.getMaxRow(), 500);


            numberOfTests++;
            mapTest = new Map(-500,1000); //Expected to fail because invalid row dimension
            assertEquals(mapTest.getMaxRow(), -500);


        }catch (Exception e){
            System.out.println("Test number " + numberOfTests + " failed for testGetMaxRow. All tests before succeeded. Stopping tests...");
        }
    }

    /**
     * <p>Will test the retrieval of the max column in a map object.</p>
     */
    @Test
    public void testGetMaxColumn() {

        int numberOfTests = 0;

        try {

            numberOfTests++;
            mapTest = new Map(10,10);
            assertEquals(mapTest.getMaxColumn(), 10);


            numberOfTests++;
            mapTest = new Map(500,1000);
            assertEquals(mapTest.getMaxColumn(), 1000);

            numberOfTests++;
            mapTest = new Map(500,-1000); //Expected to fail because of invalid column dimension
            assertEquals(mapTest.getMaxColumn(), -1000);




        }catch (Exception e){
            System.out.println("Test number " + numberOfTests + " failed for testGetMaxColumn. All tests before succeeded. Stopping tests...");
        }
    }

    /**
     * Will test the setter for max row. It will set a new dimension and to verify the change, the getter is used on
     * the map and stores the new dimension into a variable. assertEquals will then evaluate the correctness.
     */
    @Test
    public void testSetMaxRow() {
        int numberOfTests = 0;

        try{

            mapTest = new Map(10, 10);

            numberOfTests++;
            mapTest.setMaxRow(100);
            int verifyDimensionChange = mapTest.getMaxRow(); //Grab max row value that was just set

            assertEquals(verifyDimensionChange, 100); //Verify against actual


            numberOfTests++;
            mapTest.setMaxRow(1);
            verifyDimensionChange = mapTest.getMaxRow();

            assertEquals(verifyDimensionChange, 1);


            numberOfTests++;
            mapTest.setMaxRow(-10); //Expected to fail because you cannot set a max dimension to a negative number
            verifyDimensionChange = mapTest.getMaxRow();

            assertEquals(verifyDimensionChange, -10);

        }catch (Exception e){
            System.out.println("Test number " + numberOfTests + " failed for testSetMaxRow. All tests before succeeded. Stopping tests...");

        }
    }

    /**
     * Will test the setter for max column. It will set a new dimension and to verify the change, the getter is used on
     * the map and stores the new dimension into a variable. assertEquals will then evaluate the correctness.
     */
    @Test
    public void testSetMaxColumn() {

        int numberOfTests = 0;

        try{

            mapTest = new Map(10, 10);

            numberOfTests++;
            mapTest.setMaxColumn(5);
            int verifyDimensionChange = mapTest.getMaxColumn();

            assertEquals(verifyDimensionChange, 5);

            numberOfTests++;
            mapTest.setMaxColumn(100);
            verifyDimensionChange = mapTest.getMaxColumn();

            assertEquals(verifyDimensionChange, 100);

            numberOfTests++;
            mapTest.setMaxColumn(-10); //Expected to fail because you cannot set a max dimension to a negative number
            verifyDimensionChange = mapTest.getMaxColumn();

            assertEquals(verifyDimensionChange, -10);


        }catch (Exception e){
            System.out.println("Test number " + numberOfTests + " failed for testSetMaxRow. All tests before succeeded. Stopping tests...");

        }

    }

    /**
     * <p>Main for the tester. Implements a test runner for above test methods.</p>
     * @param args arguments for main.
     */
    public static void main(String[] args) {

        //Test runner for evaluating test cases
        Result result= JUnitCore.runClasses(MapTest.class);
        for (Failure failure: result.getFailures()) {
            System.out.println(failure.toString());
        }


        System.out.println(result.wasSuccessful());


    }//End of main


}