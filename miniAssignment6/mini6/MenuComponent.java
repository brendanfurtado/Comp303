//Student Name: Brendan Furtado
//Student ID: 260737867

//Interface for a composite design pattern arrangement
//All of these functions will either be implemented in Menu.java or Invoice.java
public abstract class MenuComponent {

    public void add(MenuComponent newMenuComponent){
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent newMenuComponent){
        throw new UnsupportedOperationException();
    }

    public String getType(){
        throw new UnsupportedOperationException();
    }

    public String getName(){
        throw new UnsupportedOperationException();
    }

    public String getDescription(){
        throw new UnsupportedOperationException();
    }

    public int getPrice(){
        throw new UnsupportedOperationException();
    }

    public boolean getIsAlcoholic(){
        throw new UnsupportedOperationException();
    }

    public boolean getItemOfTheDay(){
        throw new UnsupportedOperationException();
    }


    public void setItemOfTheDay(boolean b){
        throw new UnsupportedOperationException();
    }

    public double getDiscountPercentage(){
        throw new UnsupportedOperationException();
    }

    public void printMenu(){
        throw new UnsupportedOperationException();
    }

    public boolean getComponent(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }


}
