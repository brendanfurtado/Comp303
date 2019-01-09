import java.util.ArrayList;
public class Table<T> {

    ArrayList<T> rowList;
    ArrayList<T> columnList; //Will be built by a programmer using this code

    Table(ArrayList<T> columnList){

        this.rowList = new ArrayList<>();
        this.columnList = columnList;

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
        String offset = "  "; //Offset of a word is two spaces to the right

        //Loop to place columns in the table
        for(int i = 0; i < columnList.size(); i++){
            header = header + offset;
            T item = (T) columnList.get(i);
            header = header + item;
            header = header + " ";
        }
        System.out.println(header);

        sizeOfHeader = calcHeader(header);
        //Loop for bar below column variables
        for(int i = 0; i < sizeOfHeader; i++){
            System.out.print("-");
        }

        System.out.println();

        //Loop for items in the rows and print them
        for(int i = 0; i < rowList.size(); i++){
            System.out.print(offset);
            T item = rowList.get(i);
            System.out.println(item);
        }

    }
    //Helper method to help find the length of the header, which is based on the input column
    // a user creates.
    public int calcHeader(String s){
        int size = 0;
        for(int i = 0; i < s.length(); i++ ){
            size++;
        }
        return size;
    }

}
