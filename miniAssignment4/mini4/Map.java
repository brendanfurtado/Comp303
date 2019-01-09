
/**
 *<h1>The Map Class</h1>
 *  The Map program implements an object that resembles a gridded map, and is set to display
 *  the ~ symbol across it's dimensions. Once a map is constructed and initialized, a user can modify
 *  the map to display other symbols, e.g G for grass, and # for tree.
 *
 *
 * @author: Brendan Furtado
 * @version 1.1
 * <p>ID: 260737867</p>
 * <p>Course: Comp 303, Vybihal</p>
 *
 *
 */



public class Map {

    private int maxRow;

    private int maxColumn;

    private char[] mapMatrix; //1d character array to store elements of the map

    private int size = 0; //Size to be used for mapMatrix

    private boolean initialized; //Status for mapMatrix, to verify if all slots are initialized.


    /**
     * <b>Map Constructor</b>
     *
     * <p>If the dimensions row and column are 0 or negative, the program will throw an exception.
     *  If the dimensions are valid, the size is calculated, and the constructor will populate the map by calling
     *  the initializeMap() method.</p>
     *
     *  @param row The max row for a Map
     *  @param column The max column for a Map
     *  @throws Exception Throws exception if the row or column values are negative.
     */
    public Map(int row, int column) throws Exception {


        try {

            if (row <= 0 || column <= 0) {
                throw new IllegalArgumentException();
            }

            maxRow = row;
            maxColumn = column;
            initialized = false;
            size = maxColumn * maxRow;

            initializeMap();

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    /**
     * <b>Initialize Map </b>
     * <p>This method will populate the map by filling all slots in the one dimensional array, mapMatrix,
     * with the ~ character. I used a 1d array because, for large values of n it will be much quicker than a
     * 2d array, this loop will run in at worst O(n) time.</p>
     *
     *
     *
     * @throws Exception Thrown if there is an index out of bounds error or an improper allocation of the mapMatrix
     */
    public void initializeMap() throws Exception {


        try {

            mapMatrix = new char[size];

            for (int i = 0; i < size; i++) {
                mapMatrix[i] = '~';
            }

            initialized = true;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    /**
     * <p>This method takes as input a replacement map character for the specified coordinates. It first checks that the Map object is initialized. It also checks
     * out of bounds coordinates and a valid mapCharacter. Valid mapCharacters are: G, ~, #. </p>
     *
     * @param mapCharacter A character that will be intended to place onto the map.
     * @param inputRow The row the user wants to place the mapCharacter.
     * @param inputColumn The column the user wants to place the mapCharacter.
     * @return boolean value that will indicate whether a mapCharacter was successfully placed in the Map.
     * @throws IndexOutOfBoundsException Throws exception if the row or column values are negative.
     * @throws IllegalArgumentException Throws exception if the mapCharacter is not valid.
     *
     */
    public boolean replaceCharacter(char mapCharacter, int inputRow, int inputColumn) throws IndexOutOfBoundsException, IllegalArgumentException {



        if (!initialized) {
            return false;
        }

        if (inputRow < 0 || inputRow >= maxRow) {
            throw new IndexOutOfBoundsException("Invalid row! It must be between 0 and " + inputRow);
        }

        if (inputColumn < 0 || inputColumn >= maxColumn) {
            throw new IndexOutOfBoundsException("Invalid row! It must be between 0 and " + inputColumn);
        }

        if (!(mapCharacter == 'G' || mapCharacter == 'g' || mapCharacter == '~' || mapCharacter == '#')) {
            throw new IllegalArgumentException("This is an invalid character! It must be either ~ or G or # \n");
        }

        int offset = inputRow * maxColumn + inputColumn; //An offset is lastly computed to store the character in the 1d array.
        mapMatrix[offset] = mapCharacter;
        return true;

    }


    /**
     * <p>Method that will print the contents of the map object. A newline to the map
     * is calculated when the remainder of i % maxColumn is zero, indicating the end of the row.
     * Otherwise it will just print the character at the given index. </p>
     *
     */
    public void printMap() {



        for (int i = 0; i < size; i++) {

            if ((i % maxColumn) == 0) {
                System.out.println();
            }

            System.out.print(mapMatrix[i] + "");

        }

        System.out.println();

    }

    /**
     * Returns maximum row length for the map.
     *
     * @return int
     */
    public int getMaxRow() {



        return this.maxRow;
    }

    /**
     * Returns maximum column length for the map.
     *
     * @return int
     *
     */
    public int getMaxColumn() {



        return this.maxColumn;
    }


    /**
     * Sets a new value for the row dimension for a map.
     *
     * @param maxValue New row value being set.
     * @throws Exception Throws exception if the value being set is zero or negative.
     *
     */
    public void setMaxRow(int maxValue) throws Exception {



        try {

            if(maxValue <= 0){
                throw new IllegalArgumentException();
            }

            initialized = false;
            this.maxRow = maxValue;

        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Sets a new value for the column dimension for a map.
     *
     * @param maxValue New column value being set.
     * @throws Exception Throws exception if the value being set is zero or negative.
     */
    public void setMaxColumn(int maxValue) throws Exception {

        try{

            if(maxValue <=0){
                throw new IllegalArgumentException();
            }

            initialized = false;
            this.maxColumn = maxValue;

        }catch(Exception e){
            throw new IllegalArgumentException();
        }

    }

    /**
     * Will check to see if a map is initialized/populated with ~ characters.
     * @return boolean
     */
    public boolean getInitialized() {
        return this.initialized;
    }


    /**
     * Will return a character stored at the row and column coordinates.
     *
     * Used mainly for testing in MapTest.java.
     *
     * @param rowCoordinate corresponds to the row coordinate of a character
     * @param columnCoordinate corresponds to the column coordinate of a character
     * @return char
     * @throws IndexOutOfBoundsException Exception thrown when trying to access outside map dimensions.
     */
    public char getChar(int rowCoordinate, int columnCoordinate) throws IndexOutOfBoundsException{

        try{
            int offset = rowCoordinate * maxColumn + columnCoordinate;

            if(offset < 0){
                throw new IndexOutOfBoundsException();
            }
            return mapMatrix[offset];

        }catch (Exception e){
            throw new IndexOutOfBoundsException();
        }


    }


}
