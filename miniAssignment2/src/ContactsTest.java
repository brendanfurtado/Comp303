//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal, Assignment 2

public class ContactsTest {
    public static void main(String[] args)throws Exception{

        try {

            //Test for object constructors (ContactsAcquaintance, ContactsBusiness, ContactsFriend)
            //Since ContactsInfo is an abstract class and cannot be instantiated, we test the
            // constructors that inherited the class.
            //All constructor tests will technically test if each type successfully extends from ContactsInfo (the abstract class)

            //ContactsAcquaintance constructor tests, parameters: String name, String phonenumber
            System.out.println("Test cases for Constructor <<ContactsAcquaintance()>> : ");

            //It is impossible to input anything other than a String, so we will test if we can successfully create
            // a contact of type acquaintance.
            ContactsAcquaintanceTest("24352345","Dave");
            ContactsAcquaintanceTest("Brendan", "123452345");
            System.out.println();

            //ContactsBusiness constructor tests, parameters: String name, String phonenumber, String businessAddress, String businessName
            ContactsBusinessTest("Bob", "12345678", "McGill University", "Tech inc.");
            ContactsBusinessTest("231342134", "#$&@)$!", "McGill UniversityMcGill UniversityMcGill University", "Tech inc!");
            System.out.println();

            //ContactsFriend constructor tests, parameters: String name, String phonenumber, String address, String birthday
            ContactsFriendTest("Adam", "12345678", "Sherbrooke", "Sept 21");
            ContactsFriendTest("Bob", "", "University", "January");
            System.out.println();


            //Tests for methods in ContactsBook.java class

            //Constructor test for ContactsBook() should create a HashMap that acts as a phone book to store contacts
            System.out.println("Test cases for Constructor <<ContactsBook()>> : ");
            ContactsBook phoneBook1Test = new ContactsBook();

            //Check to see if the ContactsBook object is correctly created
            ContactsBookTest(phoneBook1Test); //Should expect to see an empty phoneBook
            System.out.println();


            //Testing storeContact method within ContactsBook.java (also tests getContact see helper test method)
            //Parameters: (String key, String ContactsInfo contact)
            //In order for test to verify it works, need to have String key equal to String name when making contact type
            ContactsInfo contact1 = new ContactsFriend("Bob", "", "University", "January");
            ContactsBook phoneBook2Test = new ContactsBook();

            //See method storeContactTest for details
            storeContactTest(phoneBook2Test,"Bob",contact1);
            storeContactTest(phoneBook2Test,"Dave",contact1); //Should return succeed, showing that multiple keys can access a particular contact info
                                                                //Dave will possess Bob's values


        }catch(Exception e){
            throw new Exception(e);
        }

    }//End of main

    public static void ContactsBookTest(ContactsBook phoneBook){

        try {

            //If the size isn't zero, then the phone book was never created and the constructor failed
            if(phoneBook.getSize() == 0) {

                System.out.println("Arguments: <<phone book>> Result: <<Empty phone book successfully created>> ");

            }
            else {
                System.out.println("Arguments: <<phone book>> Result: <<Empty phone book unsuccessfully created>> ");
            }

        } catch(Exception e) {
            System.out.println("Arguments: <<phone book>> Result: <<Empty phone book unsuccessfully created>> ");
        }
    }

    //We're not testing for the name because in my data structure I allow for duplicates, so name retrieval may fail.
    public static void ContactsAcquaintanceTest(String name, String phoneNumber){

        try{

            ContactsInfo contactTest = new ContactsAcquaintance(name, phoneNumber);

            //It is impossible to input anything other than a String, so we will test if we can successfully create
            // a contact of type acquaintance.
            if(contactTest.getType().equals("Acquaintance")){
                System.out.println("Arguments: <<" + name + "," + phoneNumber + ">> Result: <<Acquaintance contact successfully created>> ");
            }

            //A contact of type Acquaintance was not successfully created
            else{
                System.out.println("Arguments: <<" + name + "," + phoneNumber + ">> Result: <<Acquaintance contact unsuccessfully created>> ");

            }

        }catch(Exception e){
            System.out.println("Arguments: <<" + name + "," + phoneNumber + ">> Result: <<Acquaintance contact unsuccessfully created>> ");
        }
    }

    public static void ContactsBusinessTest(String name, String phoneNumber, String businessAddress, String businessName){

        try{

            ContactsInfo contactTest = new ContactsBusiness(name, phoneNumber, businessAddress, businessName);

            //It is impossible to input anything other than a String, so we will test if we can successfully create
            // a contact of type business.
            if(contactTest.getType().equals("Business")){
                System.out.println("Arguments: <<" + name + "," + phoneNumber + "," + businessAddress + "," + businessName + ">> Result: <<Business contact successfully created>> ");
            }

            //A contact of type Business was not successfully created
            else{
                System.out.println("Arguments: <<" + name + "," + phoneNumber + "," + businessAddress + "," + businessName + ">> Result: <<Business contact unsuccessfully created>> ");

            }

        }catch(Exception e){
            System.out.println("Arguments: <<" + name + "," + phoneNumber + "," + businessAddress + "," + businessName + ">> Result: <<Business contact unsuccessfully created>> ");
        }
    }

    public static void ContactsFriendTest(String name, String phoneNumber, String address, String birthday){

        try{

            ContactsInfo contactTest = new ContactsFriend(name, phoneNumber, address, birthday);

            //It is impossible to input anything other than a String, so we will test if we can successfully create
            // a contact of type friend.
            if(contactTest.getType().equals("Friend")){
                System.out.println("Arguments: <<" + name + "," + phoneNumber + "," + address + "," + birthday + ">> Result: <<Friend contact successfully created>> ");
            }

            //A contact of type friend was not successfully created
            else{
                System.out.println("Arguments: <<" + name + "," + phoneNumber + "," + address + "," + birthday + ">> Result: <<Friend contact unsuccessfully created>> ");

            }

        }catch(Exception e){
            System.out.println("Arguments: <<" + name + "," + phoneNumber + "," + address + "," + birthday + ">> Result: <<Friend contact unsuccessfully created>> ");
        }
    }


    //In order to test if a contact was successfully stored, I had to use the getContact(String key) that
    // returns a ContactsInfo object with all its information
    //So this test, essentially tests both methods storeContact and getContact
    public static void storeContactTest(ContactsBook phoneBook, String key, ContactsInfo contact){

        try {

            //Place user input inside the phone book
            phoneBook.storeContact(key, contact);
            ContactsInfo addContact;

            //If the key (name) was successfully stored, it would not return null. null would only return if the
            // phonebook did not contain the contact key, i.e the key is wrong or it was never stored.
            if ((addContact = phoneBook.getContact(key)) != null){
                System.out.println("Arguments: <<" + "key:"+ key + "," + "contact name: " + addContact.getName() + ">> Result: <<Storing contact succeeded>> ");
            }
            else {
                System.out.println("Arguments: <<" + "key:"+ key + "," + "contact name: " + addContact.getName() + ">> Result: <<Storing contact failed, unable to get contact>> ");
            }
        }catch (Exception e){
            System.out.println("Exception thrown unable to get contact");

        }

    }
}
