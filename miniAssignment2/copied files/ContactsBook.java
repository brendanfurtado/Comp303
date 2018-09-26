//Name: Brendan Furtado
//ID: 260737867
//Course: Comp 303, Vybihal, Assignment 2

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

// I chose to use a hashmap to represent the underlying data structure of a contact book to optimize searching.
// Searching is the most frequently used function in a contact book hence it is necessary to optimize that function.

//Additionally I use a linkedlist to store duplicate name contacts. This allows the same person to show up
// as an friend or business contact.
// Although the hashmap is more complicated and possibly takes up more memory than a simple ArrayList, searching is
// a lot faster, especially on a large scale.


public class ContactsBook {

    private HashMap<String, LinkedList<ContactsInfo>> phoneBook;

    //Allocate a hashmap using String as the Key and LinkedList of objects as a value.
    //This allows us to store contacts with duplicate names.

    public ContactsBook() throws Exception {  // throws exception if it cannot allocate the hashmap

        try {

            phoneBook = new HashMap<String, LinkedList<ContactsInfo>>();

        }catch (Exception e){
            throw new Exception(e);
        }
    }

    //Returns size of phoneBook that ContactsBook constructor created
    public int getSize(){
        return phoneBook.size();
    }


    // stores a linked list of contact nodes for a given key.

    public void storeContact(String key, ContactsInfo contact){

       //First get the list from the phonebook using the key provided.
       LinkedList<ContactsInfo>  hashlist  = (LinkedList<ContactsInfo>) phoneBook.get(key);

       //If no key found in phonebook we create a new linked list, add contact then update hashmap value
       if (hashlist == null) {
           LinkedList linkedlist = new LinkedList<ContactsInfo>();
           linkedlist.add(contact);
           phoneBook.put(key,  linkedlist);
           return;
       }


       //If the linkedlist is not null then we are inserting a duplicate record.
       //Just add the contact to the existing linked list and push it back to the hashmap using the key.

       hashlist.add(contact);
       phoneBook.put(key, hashlist);

   }//End of store contact


    //Returns the first node in the linked list associated with the key
    // the linked list allows duplicate keys to be stored. however only the first is returned on the call to get

    public ContactsInfo getContact(String key) {

        LinkedList<ContactsInfo> list;

        list = phoneBook.get(key);

        if (list == null) {
            return null;
        }

        // if the list is not null then it has at least one element in it.
        //Just return the first name found in the linked list
        return list.get(0);

    }

    //Iterates over the entire hashmap phoneBook and prints all elements
    //There are two iterators used; one to iterate over all the keys in the table,
    //the second to iterate over all the values in the linkedlist. These will be duplicate names but different contact types
    // the strings are stored in an array list and returned to the calling method.

    // by returning an arraylist, the calling method is spared from having to know about the underlying storage
    // of the phonebook.

    public ArrayList<String> getContactList() throws Exception{

        try {

            //Create a set and enter all the keys in the hashmap by calling keySet();
            //Create an iterator that iterates over all the keys in the set
            Set<String> keyset = phoneBook.keySet();
            Iterator<String> tableIterator = keyset.iterator();

            LinkedList<ContactsInfo> linkedlist;
            Iterator<ContactsInfo> listIterator;

            //This arraylist is used to store the formatted values of each contact object (from a toFormattedString() call)
            // so when we later create an iterator to print the contacts, it will be formatted like a table
            ArrayList<String> formattedContacts = new ArrayList<String>();

            while (tableIterator.hasNext()) {

                String key = tableIterator.next();

                //Now we have a key so we call the get method to return the LinkedList for that key
                linkedlist = (LinkedList<ContactsInfo>) phoneBook.get(key);

                //Now iterate over the link list
                listIterator = linkedlist.listIterator();

                while (listIterator.hasNext()) {
                    ContactsInfo temp = (ContactsInfo) listIterator.next();
                    formattedContacts.add(temp.toFormattedString()); //temp will return a formatted string that is
                                                                    // based on the values of a certain contact type
                }


            }//End of table iterator
            return formattedContacts;

        }catch(Exception e){
            throw new Exception(e);
        }

    }

}//End of class
