

public interface columnStrategy<T> {

    String getItem(T f);

}

class Name implements columnStrategy {


    @Override
    public String getItem(Object f) {
        return ((Food)f).getName();
    }
}

class Calories implements columnStrategy {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getCalories();
        return s;
    }
}

class Carbs implements columnStrategy {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getCarbs();
        return s;
    }
}

class Fat implements columnStrategy {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getFat();
        return s;
    }
}

class Protein implements columnStrategy {

    @Override
    public String getItem(Object f) {

        String s = "" + ((Food)f).getProtein();
        return s;
    }
}

