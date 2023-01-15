package Com.BridgeLabz.Collection;


import java.util.Collection;
import java.util.LinkedList;

public class AddressBookMain {

    Collection<Address> address;

    AddressBookMain(){
        address = new LinkedList<Address>();
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Program");

    }
}
