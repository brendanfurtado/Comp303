//Name: Brendan Furtado
//ID: 260737867

//column Strategy that uses getItem to retrieve the different column variables
//In the context of food, the strategy helps dynamically change the columns according to what
//the client wants on the table.
public interface ColumnStrategyI<T> {

    String getItem(T f);

}

class Name implements ColumnStrategyI {


    @Override
    public String getItem(Object f) {
        return ((Food)f).getName();
    }
}

class Calories implements ColumnStrategyI {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getCalories() + " cal";
        return s;
    }
}

class Carbs implements ColumnStrategyI {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getCarbs();
        return s;
    }
}

class Fat implements ColumnStrategyI {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getFat();
        return s;
    }
}

class Protein implements ColumnStrategyI {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getProtein();
        return s;
    }
}

