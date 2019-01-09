//Student Name: Brendan Furtado
//Student ID: 260737867

import java.util.ArrayList;
import java.util.Iterator;

//Menu for the restaurant
//One menu represents one restaurant
//This acts as thr grouping stage in the composite design pattern,
//it uses aspects of leaf elements to perform functions inside the interface MenuComponent where all methods lie.
public class Menu extends MenuComponent implements MenuIterator  {
    private String menuName;    //Name of menu/restaurant
    public ArrayList menuComponents; //List of menu items
    boolean itemOfTheDayExists;     //check to see if the item of the day exists
    double discountPercentage;

    public Menu(String menuName){
        this.menuName = menuName;
        menuComponents = new ArrayList<Item>(); //List of items in menu
        itemOfTheDayExists = false; //Tag so that only one item of the day exists
        discountPercentage = 0.5; //Default discount percentage
    }

    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    //
    public void setItemOfTheDay(MenuComponent menuComponent) throws Exception {

        //Base case to see if the menu item even exists within the menu.
        if(!menuComponents.contains(menuComponent)){
            throw new Exception("The menu does not contain this item! Cannot set " + menuComponent.getName() + "item of the day.");
        }

        int countDuplicates = doesItemOfDayExist();

        if(countDuplicates == 0){
            int index = menuComponents.indexOf(menuComponent);
            MenuComponent item = (MenuComponent) menuComponents.get(index);
            item.setItemOfTheDay(true);
            itemOfTheDayExists = true;
        }

        //replace item of the day
        else if(countDuplicates == 1){
            for(int i = 0; i < menuComponents.size(); i++) {
                MenuComponent temp = (MenuComponent) menuComponents.get(i);
                if (temp.getItemOfTheDay()) {
                    temp.setItemOfTheDay(false);
                    itemOfTheDayExists = false;
                }
            }

            menuComponent.setItemOfTheDay(true);
            itemOfTheDayExists = true;
        }
        else{
            throw new Exception("There are more than one items of the day!");
        }

    }

    //Uses iterator from MenuIterator interface and goes through the arraylist (menu).
    public void printMenu() {

        Iterator menuIterator = createIterator();
        System.out.println("Menu for " + getName() + ":");

        while (menuIterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) menuIterator.next();
            if(menuComponent.getItemOfTheDay()){
                double temp = menuComponent.getPrice() * discountPercentage;
                System.out.println("Item of the day! " + menuComponent.getType() + " - " + menuComponent.getName() + ": " + menuComponent.getDescription() + " $" + menuComponent.getPrice() + " Discount Price: $" + temp);
            }
            else{
                System.out.println(menuComponent.getType() + " - " + menuComponent.getName() + ": " + menuComponent.getDescription() + " $" + menuComponent.getPrice());

            }
        }
        System.out.println();

    }

    public Iterator createIterator(){
        return menuComponents.iterator();
    }

    //Helper method to see if the item of the day exists
    public int doesItemOfDayExist(){
        int count = 0;
        int index = 0;
        Iterator menuIterator = createIterator();

        while(menuIterator.hasNext()){
            MenuComponent temp = (MenuComponent) menuComponents.get(index);
            if(temp.getItemOfTheDay()){
                count++;
            }
            index++;
            menuIterator.next();
        }
        return count;
    }

    //See if a menuComponent doesn't exist
    public boolean getComponent(MenuComponent menuComponent){
        int index = menuComponents.indexOf(menuComponent);
        if(index != -1){
            return true;
        }
        return false;
    }

    public ArrayList getMenuList(){
        return menuComponents;
    }

    public String getName(){
        return this.menuName;
    }

    public double getDiscountPercentage(){
        return this.discountPercentage;
    }

    //If user wants to change the discount percentage.
    public void setDiscountPercentage(double discountPercentage){

        this.discountPercentage = discountPercentage;
    }

}
