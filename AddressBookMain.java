package Com.BridgeLabz.Collection;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBookMain {

    Collection<Address> address;

    AddressBookMain(){
        address = new LinkedList<>();
    }

    void addContact(){
        Address add = new Address();
        Scanner scr = new Scanner(System.in);
        System.out.println("Enter First Name");
        add.setName(scr.next());
        System.out.println("Enter Last Name");
        add.setLastName(scr.next());
        System.out.println("Enter Address");
        add.setAddress(scr.next());
        System.out.println("Enter City");
        add.setCity(scr.next());
        System.out.println("Enter State");
        add.setState(scr.next());
        System.out.println("Enter Zip");
        add.setZip(scr.next());
        System.out.println("Enter Email");
        add.setEmail(scr.next());
        System.out.println("Enter Phone Number");
        add.setPhoneNumber(scr.next());

        address.add(add);
        System.out.println("Entry Added");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Program");




    }
}
