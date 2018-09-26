//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal, Assignment 2

public class ContactsFriend extends ContactsInfo {

    private String address;
    private String birthday;

    public ContactsFriend(String name, String phoneNumber, String address, String birthday) {

        //Friend contact characteristics
        super(name, phoneNumber);
        this.address = address;
        this.birthday = birthday;
        setType("Friend");

    }

    public String getAddress(){
        return this.address;
    }

    public String getBirthday(){
        return this.birthday;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    public void setBirthday(String newBirthday){
        this.birthday = newBirthday;
    }

    //Overrides method in ContactsInfo.java
    public String toString(){
        return (super.toString() + "\n" + address + "\n" + birthday);
    }

    //See super class (ContactsInfo.java) for implementation
    public String toFormattedString() {
        String s = String.format("%s%36s%16s%22s%16s", this.getType(), this.getName(), this.getPhoneNumber(), this.getAddress(), this.getBirthday());
        return s;
    }

}
