//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal, Assignment 2


//Abstract class that contains methods used in all types of contacts; acquaintance, business, friends
public abstract class ContactsInfo {

    //Can declare constant fields
    //These elements are universal across all types of contacts
    private String name;
    private String phoneNumber;
    private String type; //Will be used to distinguish types of contacts between Acquaintance, Business and Friend


    public ContactsInfo(String name, String phone){

        this.name = name;
        this.phoneNumber = phone;

    }


    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return name + "\n" + phoneNumber;
    }

    //This method is used in the getContactList() method in ContactsBook.java
    //It helps format the contact information stored in a ContactsInfo object.
    //I made this the only abstract method because across the different types of contacts
    // the format is implemented differently. For example an Acquaintance doesn't have a birthday value.
    abstract public String toFormattedString();

}





