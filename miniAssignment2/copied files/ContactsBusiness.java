//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal, Assignment 2

public class ContactsBusiness extends ContactsInfo {

    private String address;
    private String businessName;


    public ContactsBusiness(String name, String phoneNumber, String address, String businessName){

        //Business contact characteristics
        super(name, phoneNumber);
        this.address = address;
        this.businessName = businessName;
        setType("Business");

    }

    public String getAddress(){
        return this.address;
    }

    public String getBusinessName(){
        return this.businessName;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    public void setBusinessName(String newBusinessName){
        this.businessName = newBusinessName;
    }

    //Overrides method in ContactsInfo.java
    public String toString(){
        return (super.toString() + "\n" + address + "\n" + businessName);
    }

    //See super class (ContactsInfo.java) for implementation
    public String toFormattedString() {
        String s = String.format("%s%34s%16s%22s", this.getType(), this.getName(), this.getPhoneNumber(), this.getAddress());
        return s;
    }

}
