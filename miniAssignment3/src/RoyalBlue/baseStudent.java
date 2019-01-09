//Student Name: Brendan Furtado
//ID: 260737867

//Will be used in the Student class
// it will force the Student class to support the methods listed below

public abstract class baseStudent {
    public String name;
    public String uniqueIdentifier;
    public char type; //F == full; P == part


    //Will return true if the student is a full time student and false otherwise
    public boolean isFullTime() {
        return false;
    }

    //Will return true if the student is a part time student and false otherwise
    public boolean isPartTime() {
        return false;
    }

    public abstract String toString();


}
