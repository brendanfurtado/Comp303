//Name: Brendan Furtado
//ID: 260737867

//Class to be printed by the table
//Can be anything not just food
public class Food{

    private String name;
    private int calories;
    private int carbs;
    private int protein;
    private int fat;

    Food(String name, int carbs, int fat, int protein){
        this.name = name;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
    }


    public int getCarbs(){
        return this.carbs;
    }

    public int getFat(){
        return this.fat;
    }

    public int getProtein(){
        return this.protein;
    }

    public int getCalories() {
        this.calories = (4 * carbs) + (9 * fat) + (4 * protein);
        return calories;
    }

    public String getNameString(){ return this.name; }


    public String getProteinString(){
        return " " + this.getProtein();

    }
    public String getCarbsString(){
        return " " + this.getCarbs();

    }
    public String getFatString(){
        return " " + this.getFat();

    }
    public String getCaloriesString(){
        return " " + ((4 * carbs) + (9 * fat) + (4 * protein)) + " cal";

    }

}
