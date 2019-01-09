//Student Name: Brendan Furtado
//Student ID: 260737867

import java.util.ArrayList;
import java.util.Iterator;

//An invoice will also act as an order system
public class Invoice extends MenuComponent implements MenuIterator {

    private String orderName; //Name the order will be under
    private int age;
    public ArrayList anOrder; //List for a person's order
    public double totalBill;
    boolean fullMealDiscount = false; //Tag to see if someone already has or doesn't have a full meal



    //One order creation will represent one person/group ordering from the menu.
    //Age will be used for any alcohol drink orders
    public Invoice(String orderName, int age){

        this.orderName = orderName;
        this.age = age;
        anOrder = new ArrayList<Item>();
        totalBill = 0;

    }

    public void add(MenuComponent menu, MenuComponent item) throws Exception {

        //Checks to see if person is ordering an alcoholic drink and is >= 18 years of age
        if(item.getIsAlcoholic() && this.age < 18){
            System.out.println("Must be at least 18 to drink " + item.getName() + "!");
            System.out.println();
            return;
        }

        //If the menu contains the item, add it to the invoice order
        if(menu.getComponent(item)){
            anOrder.add(item);
            //Check to see if the meal is a full meal, the extra check is there to see if the discount
            //towards the dessert within the full meal has already been calculated
            if(isFullMeal() && !(fullMealDiscount) ){

                double dessertCost = 0;
                for(int i = 0; i < anOrder.size(); i++){
                    MenuComponent dessert = (MenuComponent) anOrder.get(i);

                    //Check to see if a dessert item is also the item of the day
                    //and apply discount.
                    if(dessert.getType().equals("Dessert") && dessert.getItemOfTheDay()){
                        double temp = dessert.getPrice() * menu.getDiscountPercentage();
                        dessertCost = dessertCost + temp;
                        totalBill = totalBill + dessertCost;
                        continue;
                    }
                    if(dessert.getType().equals("Dessert")){
                        dessertCost = dessertCost + dessert.getPrice(); //Calculate dessert cost
                    }

                    //Calculate discount on dessert and recalculate late bill
                    dessertCost = dessertCost / 2.0;
                    totalBill = totalBill + dessertCost;

                }

                fullMealDiscount = true; //Toggle discount to true so it won't enter full meal discount again.
            }
            //Apply discount if item of the day
            else if(item.getItemOfTheDay()){
                double temp = item.getPrice() * menu.getDiscountPercentage();
                totalBill = totalBill + temp;
            }

            else {
                totalBill = totalBill + item.getPrice(); //Increment the bill
            }
        }
        //If here then, the item does not exist on the menu
        else{
            throw new Exception(item.getName() + " " + item.getDescription() + " does not exist on the menu!");
        }

    }
    //remove function that removes an item from a given menu
    public void remove(MenuComponent menu, MenuComponent item) throws Exception {

        if(menu.getComponent(item)){
            anOrder.remove(item);
            totalBill = totalBill - item.getPrice();
        }
        else{
            throw new Exception(item.getName() + " " + item.getDescription() + " is not on the menu!");
        }

    }
    //Pay function
    public boolean pay(double amount) throws Exception {


        if(amount != totalBill){
            throw new Exception("Don't pay more or less than the actual bill total!");
        }

        totalBill = totalBill - amount;

        return true;
    }

    //Uses iterator to print the invoice that someone ordered from a menu
    public void printOrderFromMenu(MenuComponent menu) {

        Iterator orderIterator = createIterator();
        System.out.println(getOrderName(menu));

        while (orderIterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) orderIterator.next();
            if(menuComponent.getItemOfTheDay() ){
                double temp = menuComponent.getPrice() * menu.getDiscountPercentage();

                System.out.println("Item of the day! " + menuComponent.getType() + " - " + menuComponent.getName() + " $" + menuComponent.getPrice() + " Discount Price: $" + temp);
            }
            else if(menuComponent.getType().equals("Dessert") && fullMealDiscount){
                System.out.println(menuComponent.getType() + " - " + menuComponent.getName() + " $" + menuComponent.getPrice() + " Discount Price b/c full meal (1 time): $" + (menuComponent.getPrice()/2));
            }

            else{
                System.out.println(menuComponent.getType() + " - " + menuComponent.getName() + " $" + menuComponent.getPrice());

            }
        }
        //Display bill
        System.out.println("Total Bill: " + totalBill);
        System.out.println();
    }

    public Iterator createIterator(){
        return anOrder.iterator();
    }

    //Helper method
    //Will go through invoice and see if the person ordered a full meal
    public boolean isFullMeal(){
        boolean appetizerCount = false;
        boolean mainCount = false;
        boolean dessertCount = false;

        for(int i = 0; i < anOrder.size(); i++){

            MenuComponent item = (MenuComponent) anOrder.get(i);

            if(item.getType().equals("Appetizer")){
                appetizerCount = true;
            }
            else if(item.getType().equals("Main")){
                mainCount = true;
            }

            else if(item.getType().equals("Dessert")){
                dessertCount = true;
            }
            else{
                continue;
            }
        }

        if(appetizerCount && mainCount && dessertCount){

            return true;
        }

        return false;
    }

    public String getOrderName(MenuComponent menu){
        return this.orderName + "'s order from " + menu.getName();
    }

    public double getTotalBill(){
        return this.totalBill;
    }

    public ArrayList getAnOrder(){
        return this.anOrder;
    }



}
