//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal, Assignment 2

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;


public class ContactsMain {

    public static void main(String[] args) throws Exception{

        try {

            ContactsBook contactBook = new ContactsBook(); //contactBook possess a hashmap data structure

            //Will be used for user input
            Scanner enterContacts = new Scanner(System.in);

            System.out.println("Welcome to your contact book! Please enter one of three types of contacts: Acquaintance, Business, or Friend");

            //Loop to prompt user to input their contacts
            while (true) {
                System.out.print("Enter 'A' for an acquaintance, 'B' for business, 'F' for friends or return to quit: ");

                String contactType = enterContacts.nextLine();

                //User wants to create a new acquaintance contact
                if (contactType.equalsIgnoreCase("A")) {

                    //User enters details for an acquaintance contact
                    System.out.print("Enter Acquaintance Name: ");
                    String name = enterContacts.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = enterContacts.nextLine();

                    ContactsAcquaintance newAcquaintanceContact = new ContactsAcquaintance(name, phoneNumber);


                    contactBook.storeContact(name, newAcquaintanceContact); //Store new contact in contact book


                }

                //User wants to create a new business contact
                else if (contactType.equalsIgnoreCase("B")) {

                    //User enters details for a business contact
                    System.out.print("Enter Name: ");
                    String name = enterContacts.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = enterContacts.nextLine();

                    System.out.print("Enter Business Address: ");
                    String address = enterContacts.nextLine();

                    System.out.print("Enter Business Name: ");
                    String businessName = enterContacts.nextLine();

                    ContactsBusiness newBusinessContact = new ContactsBusiness(name, phoneNumber, address, businessName);

                    contactBook.storeContact(name, newBusinessContact); //Store new contact in contact book


                } else if (contactType.equalsIgnoreCase("F")) {


                    //User enters details for a friend contact
                    System.out.print("Enter Friend's Name: ");
                    String name = enterContacts.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = enterContacts.nextLine();

                    System.out.print("Enter Friend's Address: ");
                    String address = enterContacts.nextLine();

                    System.out.print("Enter Friend's Birthday: ");
                    String birthday = enterContacts.nextLine();

                    ContactsFriend newFriendContact = new ContactsFriend(name, phoneNumber, address, birthday);

                    contactBook.storeContact(name, newFriendContact); //Store new contact in contact book


                }
                //If the user clicked return, then it will quit out of adding contacts loop
                else if (contactType.equals("")) {
                    System.out.println("You have quit entering contacts.");
                    System.out.println();
                    break;
                }

            }//End of entering contacts loop


            //Loop asking user if they want to either Find a contact or List the whole contact book

            while (true) {
                System.out.println("Search for a contact in the contact book or list all contacts? Enter 'S' for search, 'L' for listing and return to quit");
                String userAnswer = enterContacts.nextLine();

                if (userAnswer.equalsIgnoreCase("S")) {

                    System.out.print("Please enter the contact name you would like to search information for: ");
                    String name = enterContacts.nextLine();


                    //If the contact exists, display all details.
                    ContactsInfo value = contactBook.getContact(name);

                    //If the contact doesn't exist
                    if (value == null) {
                        System.out.println("Contact " + name + " not found.");
                    }

                    //Otherwise print all the values of a contact (Name, phone number, address, etc.)
                    else {
                        System.out.println(value.toString());
                    }
                    continue; //Jump back to top of loop and get user input
                }

                //User wants to list contacts
                if (userAnswer.equalsIgnoreCase("L")) {

                    //Create an array list that possesses the values of each contact in the list
                    ArrayList<String> contactList = contactBook.getContactList();

                    //Create an iterator that will traverse the list and print the formatted values in a table
                    Iterator<String> arrayIterator = contactList.iterator();

                    while (arrayIterator.hasNext()) {

                        String contact = arrayIterator.next();
                        System.out.println(contact);

                    }
                    continue;
                }
                //User hits return to quit program
                if (userAnswer.equals("")) {
                    System.out.println("You have quit the program.");
                    break;
                }

            }


        }catch(Exception e){
            throw new Exception(e);
        }
    }

}
