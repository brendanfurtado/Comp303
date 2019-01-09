//Student Name: Brendan Furtado
//Student ID: 260737867

//The leaf class that also extends the MenuComponent interface
//Possesses all the descriptions/characteristics of an item (e.g food/drink product)
public class Item extends MenuComponent {

    //Details of a food or drink
    private String name;
    private String description;
    private String type; //Used for type of food (Appetizer, MainCourse, Dessert, Side-dish, Drink)
    private int price;
    private boolean isAlcoholic;
    private boolean isItemOfTheDay = false;


    public Item(String type, String name, String description, boolean alcoholic, int price) throws Exception {

        //Types are strict
        if(!(type.equals("Appetizer") || type.equals("Main") || type.equals("Dessert") || type.equals("Side") || type.equals("Drink"))){
            throw new Exception("Improper type of food, Enter 'Appetizer', 'Main', 'Dessert, or 'Side'.");
        }

        //check so you don't make food alcohol.
        if(!(type.equals("Drink")) && alcoholic){
            throw new Exception("Only a drink can be alcoholic!");
        }

        this.type = type; //Substitute Appetizer, main (course), dessert, drink to type
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAlcoholic = alcoholic;

    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public int getPrice(){
        return this.price;
    }

    public boolean getItemOfTheDay(){
        return this.isItemOfTheDay;
    }

    public void setItemOfTheDay(boolean set){
        isItemOfTheDay = set;
    }


    public boolean getIsAlcoholic(){
        return this.isAlcoholic;
    }



}
