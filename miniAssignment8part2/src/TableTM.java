//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

//TableTM class that is generic
public abstract class TableTM<T> {

    ArrayList<T> rowList = new ArrayList<>(); //Elements within a row
    ArrayList<String> columnList = new ArrayList<>();
    ArrayList<String> columnItems = new ArrayList<>();


    public void addItem(T item){
        rowList.add(item);
    }

    public void removeItem(T item){
        rowList.remove(item);
    }


    public abstract void printColumn();
    public abstract void printRow();

    public abstract String getColumnCategory(int i);
    public abstract void pad(String category, String item);

    final void printTable(){

        printColumn();

        printRow();

    }
}
