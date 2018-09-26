//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal

public class Map {

    private int maxRow;
    private int maxColumn;

    //I chose to represent the underlying storage of the matrix as a 1D array instead of 2D
    //For a very large value of n in the 1D version will be more optimal than a 2D version in Java,
    //especially if the array is holding large objects instead of just characters

    //I also use the character primitive type since we are only dealing with three characters ~ G and #,
    //using a String would be very inefficient

    private char[] mapMatrix;

    //The size is just maxRow * maxColumn, we do this so we can represent the matrix as a single dimension array
    private int size = 0;

    //This variable holds the state of the matrix. If the caller has reset the size of the row or column, by using setters,
    //then the variable is set to false until the entire matrix is reallocated and reinitialized.
    //It essentially prevents unintentional index out of bounds errors.
    private boolean initialized;


    public Map(int row, int column) throws Exception {

        try {

            if (row <= 0 || column <= 0) {
                throw new IllegalArgumentException();
            }

            maxRow = row;
            maxColumn = column;
            initialized = false;
            size = maxColumn * maxRow;

            //Inorder to complete the construction of the map, we call initialize which allocates and initializes the storage
            initializeMap();

        } catch (Exception e) {
            throw new Exception(e);
        }

    }


    public void initializeMap() throws Exception {


        try {

            //Allocate an array to hold the characters in the matrix
            mapMatrix = new char[size];

            //This for loop runs in O(n);
            //For very large arrays holding objects the single dimension version should be significantly faster
            //than using a 2D version

            for (int i = 0; i < size; i++) {
                mapMatrix[i] = '~';
            }

            initialized = true;

        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public boolean replaceCharacter(char mapCharacter, int inputRow, int inputColumn) throws IndexOutOfBoundsException, IllegalArgumentException {

        //If the matrix has not been initialized then return false.
        //This prevents mistakenly accessing an index out of bounds if the row or column was reset and
        //the object not reinitialize

        if (!initialized) {
            return false;
        }

        //User specified an index outside of the matrix dimensions
        if (inputRow < 0 || inputRow >= maxRow) {
            throw new IndexOutOfBoundsException("Invalid row! It must be between 0 and " + inputRow);
        }

        if (inputColumn < 0 || inputColumn >= maxColumn) {
            throw new IndexOutOfBoundsException("Invalid row! It must be between 0 and " + inputColumn);
        }

        //User specified an invalid replacement character
        if (!(mapCharacter == 'G' || mapCharacter == 'g' || mapCharacter == '~' || mapCharacter == '#')) {
            throw new IllegalArgumentException("This is an invalid character! It must be either ~ or G or # \n");
        }

        //Compute the i x j matrix offset in a single dimensional array
        int offset = inputRow * maxColumn + inputColumn;
        mapMatrix[offset] = mapCharacter;
        return true;
}

    //Method that will print the map
    //TA Akash Singh on the discussion board titled "Testing constructors and print functions?" that print statements don't need to be tested

    public void printMap() {

        for (int i = 0; i < size; i++) {

            //When we hit a zero remainder then we are ready for a newline; including the first time through
            if ((i % maxColumn) == 0) {
                System.out.println();
            }

            System.out.print(mapMatrix[i] + "");

        }

        System.out.println();

    } //End of printMap


    //Getters and setters

    public int getMaxRow() {
        return this.maxRow;
    }

    public int getMaxColumn() {
        return this.maxColumn;
    }

    //Since setting the maxRow and maxColumn invalidates the storage allocated for the matrix; we prevent any access to it
    //by setting the boolean value initialized to false. The user has to call initializeMap to reallocate the storage needed

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

    public boolean getInitialized() {
        return this.initialized;
    }

}
