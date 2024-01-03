package com.company;


//Samith Hasan
//CISC 3130

public class Contact implements Comparable<Contact> {
// shows class implements Comparable interface

    //main method to show the execution of the contact class
    public static void main(String[] args) {
        Contact contact = new Contact("Samith","Hasan", "9172832782", "2900 Bedford", "Brooklyn", "NY" );
        Contact contact2 = new Contact("Samith","Hasan", "9172832782", "2900 Bedford", "Brooklyn", "NY" );
        Contact contact3 = new Contact("Samith","Hasan", "9172832782");
        Contact contact4 = new Contact("Ari","Hasan", "9172832782");
        contact.updateContact("Ari","Mer", "9172832782", "2900 Bedford", "Brooklyn", "NY"); // updateContact to change the contact
        System.out.println(contact); // prints out with toString method created
        System.out.println(contact.equals(contact2)); // compares contacts with equal method created
        System.out.println(contact2.equals(contact3));
        System.out.println(contact.compareTo(contact2)); // last name of “another” is lexicographically first (M<H) = 1
        System.out.println(contact2.compareTo(contact3)); // last names are the same and the first names are the same = 0
        System.out.println(contact2.compareTo(contact)); //  last name of “another” is lexicographically second (H>M)  = -1
        System.out.println(contact4.compareTo(contact3)); // compares first names since last name is the same (A>S) = -1
        System.out.println(contact3.compareTo(contact4)); // // compares first names since last name is the same (S<A) = 1
        System.out.println(contact.getFirstName()); // using accessor methods
        System.out.println(contact.getLastName());
        System.out.println(contact.getPhoneNumber());
        System.out.println(contact.getStreetAddress());
        System.out.println(contact.getCity());
        System.out.println(contact.getState());
    }
    //output of main method:
   /* Ari Mer  Phone Number: 9172832782
      2900 Bedford
      Brooklyn,NY
      false
      true
      1
      0
     -1
     -1
     1
     Ari
     Mer
     9172832782
     2900 Bedford
     Brooklyn
     NY */

// the private data needed
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String streetAddress;
    private String city;
    private String state;

    // the constructors that are required
    public Contact(String firstName, String lastName, String phoneNumber, String streetAddress, String city, String state){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
    }

    public Contact(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

//overridden toString and equals methods
    @Override
    public String toString() {
      return this.firstName + " " + this.lastName + "  Phone Number: " + this.phoneNumber + "\n" + this.streetAddress + "\n" + this.city + "," + this.state;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Contact){
        Contact z = (Contact)obj;
        return (this.getFirstName().equals( z.getFirstName())  && this.getLastName().equals(z.getLastName()));}
       else return false;
    }

// setContact Method to change the contact depending on which constructor has been used
    public void updateContact(String firstName, String lastName, String phoneNumber, String streetAddress, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
    }
    public void updateContact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
// accessor methods created for elements of the contact object
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }


 // the compareTo method that compares first names and last names and returns an integer based on which contact is lexicographically first
    public int compareTo(Contact another) {
        if (this.getLastName().compareTo(another.getLastName()) > 0) {
            return 1;}
        else if(this.getLastName().compareTo(another.getLastName()) < 0){
            return -1;
        }
        else if (this.getFirstName().compareTo(another.getFirstName()) > 0){
            return 1;}
        else if (this.getFirstName().compareTo(another.getFirstName()) < 0){
            return -1;}
        else return 0;
    }
}
