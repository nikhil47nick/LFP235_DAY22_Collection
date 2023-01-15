package Com.BridgeLabz.Collection;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    ArrayList contact = new ArrayList<Address>();


    public void addEntry(Scanner scr){
        System.out.println("Enter First Name");
        String firstname = scr.next();
        System.out.println("Enter Last Name");
        String lastName = scr.next();
        System.out.println("Enter Address");
        String address = scr.next();
        System.out.println("Enter state");
        String state = scr.next();
        System.out.println("Enter city");
        String city = scr.next();
        System.out.println("Enter zip");
        String zip = scr.next();
        System.out.println("Enter Phone number");
        String phoneNumber = scr.next();
        System.out.println("Enter email");
        String email = scr.next();
        contact.add(new Address( firstname, lastName, address, city, state, zip, phoneNumber, email));

        System.out.println("Do you want to add more address press Y to add more N to stop add");
        char addmore = scr.next().charAt(0);
        switch (addmore){
            case 'Y':addEntry(scr);
            break;
            case 'N':return;
            default:
                System.out.println("Please enter correct");
        }

    }

    public void removeEntry(String name){

        for (int i=0;i< contact.size();i++) {
            Address e = (Address) contact.get(i);
            if(e.getName().equals(name)){
                contact.remove(i);
            }
        }
    }

    public int search(String name){
        for (int i=0;i< contact.size();i++) {
            Address e = (Address) contact.get(i);
            if(e.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void display(){

        for (int i=0;i< contact.size();i++) {

            Address e = (Address) contact.get(i);
            e.show();
            System.out.println("");

        }
    }

    public void editContact(Scanner scr){
        System.out.println("Enter name to edit details");
        String name = scr.next();
        int pos = search(name);
        if(pos >= 0){
            Address e = (Address) contact.get(pos);
            System.out.println("Please Enter a number to edit details \n 0-First Name \n 1-Last Name \n 2-address \n 3-city \n 4-state \n 5-zip \n 6-phone number \n7-email" );
            int n = scr.nextInt();
            System.out.println("Please enter updates details");
            e.setValue(n,scr.next());

            contact.remove(pos);
            contact.add(pos,e);
        }else{
            System.out.println("Name not found");
        }

    }


    public static void main(String[] args) {
        AddressBookMain new1 = new AddressBookMain();
        Scanner scr = new Scanner(System.in);
        new1.addEntry(scr);
        new1.display();
        System.out.println("Enter name to delete");

        String name = scr.next();
        new1.removeEntry(name);
        scr.close();
    }

}
