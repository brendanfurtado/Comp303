public class Food {

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

    public String getName(){
        return this.name;

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

    /*
    public String getCalories(){
        return this.calories + " cal";
    }
    */

    public String calcCalories(){
        this.calories = 4 * carbs + 9 * fat + 4 * protein;
        return this.calories + " cal";
    }

    public String toString(){
        String s = String.format("%6s", this.getName());
        String s2 = String.format("%7s", this.calcCalories());
        return s + "  " + s2 ;
        //return this.getName() + "  " + this.calcCalories();
    }

}
