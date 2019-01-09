//Student Name: Brendan Furtado
//Student ID: 260737867

//Main class that tests has all the object creation and operations with menu and ordering
// food.

public class Driver {

    public static void main(String args[]) throws Exception {

        Menu menu = new Menu("Alfredo's");

        Item salad = new Item("Appetizer", "Salad", "Romaine Salad", false, 100 );
        Item secondItem =  new Item("Appetizer", "Onion Soup", "French Onion Soup",false,  50 );
        Item beer = new Item("Drink", "Molson", "Beer", true,20 );
        Item steak = new Item("Main", "New York Strip", "Juicy Steak", false, 500);
        Item chocolate = new Item("Dessert", "Chocolate", "Dark chocolate", false, 10);


        menu.add(salad);
        menu.add(secondItem);
        menu.add(beer);
        menu.add(steak);
        menu.add(chocolate);
        menu.setItemOfTheDay(secondItem);
        menu.printMenu();

        //Full meal + item of the day example
        //If it were discounted, the total bill would equal $560
        //With full meal and item of the day discounts it should equal 25 + 500 + 5 = 530
        //For items of the day, the discount is automatically set at 50% within menu.java
        Invoice order1 = new Invoice("Brendan", 20);
        order1.add(menu, secondItem);
        order1.add(menu, steak);
        order1.add(menu, chocolate);
        order1.add(menu,chocolate); //With an addition of another dessert new price should be 540

        //Print's out customer's order
        order1.printOrderFromMenu(menu);
        order1.pay(540); //If pay is not exact exception is thrown telling you to enter proper amount

        System.out.println("Total bill for : " + order1.getOrderName(menu) + ": $" + order1.getTotalBill());
        System.out.println();

        ///////////EXAMPLE2
        //Another example of a menu and order
        Menu menu2 = new Menu("Java's");
        //Drinks
        Item water = new Item("Drink", "water", "H20", false, 5);
        Item vodka = new Item("Drink", "Vodka", "Hard alcohol", true, 20);
        Item pepsi = new Item("Drink", "Pepsi", "Like coca cola", false, 5);


        //Main
        Item chicken = new Item("Main", "Chicken", "Roasted Chicken", false, 50);
        //steak//
        Item fish = new Item("Main", "Fish", "Salmon", false, 50);

        //Sides
        Item potatoes = new Item("Side", "Potatoes", "Mashed potatoes", false, 10);
        Item fries = new Item("Side", "Fries", "French", false, 10);
        Item rice = new Item("Side", "Rice", "Soft rice", false, 10);

        //Appetizers
        //Sides
        Item cheese = new Item("Side", "Potatoes", "Mashed potatoes", false, 10);
        Item bread = new Item("Side", "Fries", "French", false, 10);
        //salad//

        //Desserts
        //Chocolate//
        Item IceCream = new Item("Dessert", "ice cream", "chocholate", false, 10);
        Item fruit = new Item("Dessert", "Fruit", "melons", false, 10);


        menu2.add(IceCream);
        menu2.add(fruit);
        menu2.add(chicken);
        menu2.add(steak);
        menu2.add(fish);
        menu2.add(pepsi);
        menu2.add(vodka);
        menu2.add(potatoes);
        menu2.add(fries);
        menu2.add(rice);
        menu2.add(water);
        menu2.setItemOfTheDay(IceCream);
        menu2.add(salad);
        menu2.add(cheese);
        menu2.add(bread);
        menu2.add(chocolate);


        //If order any alcohol drink, it will throw an error
        Invoice newOrder = new Invoice("Bob", 17);
        newOrder.add(menu2, fries);
        newOrder.add(menu2, chicken);
        newOrder.add(menu2, water);
        newOrder.add(menu2, salad );
        newOrder.add(menu2, chocolate);
        newOrder.printOrderFromMenu(menu2);

        menu2.remove(bread);
        menu2.printMenu(); //checks to see if removal works

    }

}
