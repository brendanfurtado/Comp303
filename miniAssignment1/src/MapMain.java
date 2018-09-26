//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal

import java.util.Scanner;

public class MapMain {

    //Scanner will be used inside helper methods called in the main function
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //playingMap holds the matrix for the board
        Map playingMap;

        //Opening message
        System.out.println("Welcome to Map!");

        //Main interface for user
        //getUserInt - helper method that interfaces with the console to scan for integer input
        //getUserChar - helper method that interfaces with the console to scan for a character input
        //Both methods stay in a loop until the right inputs have been entered

        //These will be used to hold the user inputs
        int inputMaxRows, inputMaxColumns;
        char inputChar;

        //While loop to get user input on max row size
        while (true) {

            inputMaxRows = getUserInt("Please input the maximum number of rows: ", "row");

            if (inputMaxRows <= 0) {
                System.out.println("Row size cannot be zero! Please enter a valid integer greater than 0.");
                continue;
            }

            //Exit the loop once we get a valid size > 0
            break;

        }

        //While loop to get user input on column row size
        while (true) {

            inputMaxColumns = getUserInt("Please input the maximum number of columns: ", "column");

            if (inputMaxColumns <= 0) {
                System.out.println("Column size cannot be zero! Please enter a valid integer greater than 0.");
                continue;
            }

            //Exit the loop once we get a valid size > 0
            break;

        }

        //Create the map based on dimensions
        try {

            //The code will exit if an internal error occurs when allocating the matrix
            playingMap = new Map(inputMaxRows, inputMaxColumns);

            System.out.println("A " + inputMaxRows + " x " + inputMaxColumns + " Map has been created.");
            System.out.println("Please add an object to the map (~ for water, G for grass, # for tree)");

        } catch (Exception e) {
            System.out.println("Internal error! Unable to create matrix. Exiting program!");
            System.out.println(e.toString());
            return;

        }

        //Dimensions have been established and map is created, move on to placing characters onto the map
        //These will be used to hold the user inputs to row and column index
        int rowCoordinate, columnCoordinate;
        boolean outsideLoop = true;

        //outsideLoop runs until a user decides to exit by typing 'n' or 'N'
        while (outsideLoop) {

            //Inside loop until the user enters a valid row in the range
            while (true) {

                rowCoordinate = getUserInt("Row: ", "row");

                //Check if the input is within range
                if (rowCoordinate < 0 || rowCoordinate > inputMaxRows - 1) {
                    System.out.println("Invalid row value! It must be between 0 and " + (inputMaxRows - 1) + ".");
                    continue;
                }

                //Exit the loop once we get a valid row
                break;
            }

            //Inside loop until the user enters a valid column in the range
            while (true) {

                columnCoordinate = getUserInt("Column: ", "column");

                //Check if the input is within range
                if (columnCoordinate < 0 || columnCoordinate > inputMaxColumns - 1) {
                    System.out.println("Invalid column value! It must be between 0 and " + (inputMaxColumns - 1) + ".");
                    continue;
                }

                //Exit the loop once we get a valid row
                break;
            }

            //Prompts the user to enter a character to be replaced in the matrix
            //Loops until the character is one of: G g ~ #
            while (true) {

                inputChar = getUserChar("Character: ");

                if (inputChar == 'G' || inputChar == 'g' || inputChar == '~' || inputChar == '#') {
                    break;
                }

                System.out.println("Invalid character! It must either: ~ or G or g or #");
            }

            try {

                //Method that uses user input to place a character onto the Map
                playingMap.replaceCharacter(inputChar, rowCoordinate, columnCoordinate);
                System.out.println("Your " + inputChar + " was added to " + rowCoordinate + "," + columnCoordinate + " in the map.");

                //Prompts user if they want to continue to add characters
                while (true) {

                    inputChar = getUserChar("Would you like to enter another character, Type Y to continue, N to quit: ");

                    if (inputChar == 'N' || inputChar == 'n' || inputChar == 'Y' || inputChar == 'y') {
                        break;
                    }

                    System.out.println("Invalid character! It must be one of:  Y or y or N or n ");

                }

                //If user types in N or n, it will break the loop and print the final Map graph before exiting program
                if (inputChar == 'n' || inputChar == 'N') {
                    playingMap.printMap();
                    outsideLoop = false; // the user wants to exit the program
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("We should never get here cause the index should always be in bounds");
                System.out.println(e.toString());
            }

        } //Close the outsideLoop

} //End of main function


    //Start of helper functions

    //The helper functions help with user console interaction
    //The first only allows the user to enter an integer
    //The second allows the user to enter a character. it can only be the characters G, g, ~ or #
    public static int getUserInt(String prompt, String dimension) {

        //Holds the user input
        int userInteger = 0;

        while (true) {

            //Asks for user input for max number of rows and columns
            System.out.print(prompt);

            //Catch any errors thrown by the scanner object
            try {

                //Get the integer that the user types
                userInteger = scanner.nextInt();

                //User cannot type a negative integer
                if (userInteger < 0) {
                    System.out.println("Invalid integer " + userInteger + "! Please enter a valid integer.\n");
                    continue;
                }

                //At this stage the user has entered a valid integer
                break;

            } catch (Exception e) {
                System.out.println("Invalid " + dimension + "! Please enter a valid integer.\n");
                //This command clears the buffer inside the scanner. Without it, the scanner would go into an infinite loop
                scanner.next();
            }

        }
        return userInteger;
    }

    public static char getUserChar(String prompt) {

        String userString = "";  //Initialize to the empty string

        //Asks for user input for max number of rows and columns
        System.out.print(prompt);

        //Use try catch to catch any exceptions from the scanner
        try {

            //The scanner object only deals with strings, so we get the string and convert to char
            userString = scanner.next();

        } catch (Exception e) {
            System.out.println("Internal scanner exception!");
            System.out.println(e.toString());
            //This command clears the buffer inside the scanner. without it, the scanner would go into an infinite loop
            scanner.next();
        }

        //Return the java native character and not the String object
        return userString.toUpperCase().charAt(0);
    }

}//End of class