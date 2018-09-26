//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal, Assignment 2

public class ContactsAcquaintance extends ContactsInfo {


    public ContactsAcquaintance(String name, String phoneNumber){

        //Acquaintance contact characteristics
        super(name, phoneNumber);
        setType("Acquaintance");

    }

    //Overrides method in ContactsInfo.java
    public String toString(){
        return (super.toString());
    }

    //See super class (ContactsInfo.java) for implementation
    public String toFormattedString() {
        String s = String.format("%s%30s%16s", this.getType(), this.getName(), this.getPhoneNumber());
        return s;
    }

}




