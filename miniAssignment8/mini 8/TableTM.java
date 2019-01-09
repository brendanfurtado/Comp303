//Name: Brendan Furtado
//ID: 260737867

import java.util.ArrayList;

//TableTM class that is generic
public abstract class TableTM<T> {

    ArrayList<T> rowItems = new ArrayList<>(); //Elements within a row
    ArrayList<String> columnList = new ArrayList<>();
    ArrayList<String> columnMethods = new ArrayList<>();


    public void addItem(T item){
        rowItems.add(item);
    }

    public void removeItem(T item){
        rowItems.remove(item);
    }

    public abstract void printHeader();
    public abstract void printRows();
    public abstract void pad(String category, String item);

    final void printTable(){

        printHeader();
        printRows();

    }
}
