package com.company;

// Samith Hasan

import java.util.*;

public class ContactList implements Iterable<Contact>{
    public static void main(String[] args) {
        // testing in main method
        Contact contact = new Contact("Samith", "Hasan", "9172832782", "2900 Bedford", "New York", "NY");
        Contact contact2 = new Contact("Sa", "Hasa", "3475302125", "2900 Bedford", "New York", "NY");
        Contact contact3 = new Contact("Sam", "Asan", "9176229100", "2900 Bedford", "New York", "NY");

        Contact[] con = new Contact[2];
        con[0] = contact;
        con[1] = contact2;
        Contact[] con1 = new Contact[1];
        con1[0] = contact3;

        ContactList z = new ContactList(con);
        ContactList y = new ContactList(con1);
        ContactList x = new ContactList(con);
        System.out.println("--------------"); //added these lines to make output easier to read
        System.out.println(z);
        System.out.println(z.get(1));
        System.out.println(z.size());

        System.out.println("--------------");
        System.out.println(y.add(contact2));
        System.out.println(y);
        System.out.println(y.remove(contact2));
        System.out.println(y);

        System.out.println("--------------");
        z.iterator();

        System.out.println("--------------");
        System.out.println(z.findByLastName("Hasan"));
        System.out.println("--------------");
        System.out.println(z.findByPhoneNumber("35"));
        System.out.println("--------------");
        System.out.println(z.findAllByLastInitial('M'));
        System.out.println("--------------");
        System.out.println(z.findAllByCity("New York"));
        System.out.println("--------------");
        System.out.println(z.equals(x));
    }
    

    private ArrayList<Contact> contactlist = new ArrayList<Contact>();

//constructor with empty arraylist
    public ContactList() {
        contactlist.clear();
    }

// constructor that uses an array of Contacts in order to initialize the ContactList
    public ContactList(Contact[] contacts) {
        List z = Arrays.asList(contacts);
        contactlist.addAll(z);
        Collections.sort(contactlist);

    }

// method that searches for a particular contact by last name, and returns a reference to the Contact using binary search
    public Contact findByLastName(String last) {
        int low = 0;
        int high = contactlist.size() - 1;
        int mid = (low + high)  / 2;

        while (low <= high) {
            mid = (low + high)  / 2;

            if (contactlist.get(mid).getLastName().compareTo(last) < 0) {
                low = mid + 1;
            } else if (contactlist.get(mid).getLastName().compareTo(last) > 0) {
                high = mid - 1;
            } else {
                return contactlist.get(mid);
            }
        }
        return null;
    }

// method that searches for a Contact by phone number
    public Contact findByPhoneNumber(String phone) {
        for (Contact c : contactlist){
            if(c.getPhoneNumber().equals(phone)) {
                   return c;       }
        }

        return null;
    }

// A method that searches for and returns a ContactList containing all Contacts with a last name starting with a particular letter
    public ContactList findAllByLastInitial(char ch) {
        ContactList z = new ContactList();
        for (Contact c : contactlist){
            if(c.getLastName().charAt(0) == ch) {
                z.add(c);             }
        }         return z;
    }


// A method that searches for and returns a ContactList containing all Contacts that live in a particular city
    ContactList findAllByCity(String city) {
        ContactList z = new ContactList();
        for (Contact c : contactlist){
            if(c.getCity().equalsIgnoreCase(city)) {
                z.add(c);             }
        }         return z;
    }

    // A method that allows you to add a Contact to the ContactList
    public boolean add(Contact c) {
        if (contactlist.contains(c)) {
            return false;
        } else {
            boolean z = contactlist.add(c);
            Collections.sort(contactlist);
            return z;
        }
    }

    // A method that returns the size of the ContactList
    public int size() {
        return contactlist.size();
    }

    // A method that allows you to remove and return a Contact from the ContactList
     public Contact remove(Object obj){
        if (obj instanceof Contact){
        contactlist.remove(obj);
        Collections.sort(contactlist);
         return (Contact) obj;
     }
     else return null;
     }



     // A method that allows the client to get a Contact from the ContactList by index
    public Contact get(int index) {
        return contactlist.get(index);
    }

    // An overridden equals() method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ContactList) {
            ContactList z = (ContactList) obj;
            return contactlist.equals(z.contactlist);
        } else return false;
    }

// An overridden toString() method that creates a representation for a ContactList
    @Override
    public String toString() {
        String contacts = "";
        contacts = contactlist.toString();
        return contacts;
    }

    // An iterator() method that allows you to iterate through a ContactList.
    // Made it so that it shows the position of the contact and then the contact
    public Iterator<Contact> iterator(){

    Iterator<Contact> iter = contactlist.iterator();
        int i= 1;
        while (iter.hasNext()) {
            System.out.println(i + ". " +  iter.next() );
            i++;
        }
        return iter;
    }


}
