package Com.BridgeLabz.Collection;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookMain {

    List<Address> contact = new ArrayList<>();

    Map city = new Hashtable<String,List<String>>();
    Map state = new Hashtable<String,List<String>>();

    @Override
    public boolean equals(Object o){
        for (int i=0;i< contact.size();i++) {
            Address e = (Address) contact.get(i);
            if(e.getName() == o){
                return true;
            }
        }
        return false;
    }

    public void addEntry(Scanner scr){


        System.out.println("Enter First Name");
        String firstname = scr.next();
        if(!equals(firstname)) {
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
            contact.add(new Address(firstname, lastName, address, city, state, zip, phoneNumber, email));

            System.out.println("Do you want to add more address press Y to add more N to stop add");
            char addmore = scr.next().charAt(0);
            switch (addmore) {
                case 'Y':
                    addEntry(scr);
                    break;
                case 'N':
                    return;
                default:
                    System.out.println("Please enter correct");
            }
        }else{
            System.out.println("Data already exist");
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

    void viewPersons(){
        Map<String,List<String>> nameByCity =
                contact.stream().collect(Collectors.groupingBy(Address::getCity, TreeMap::new,Collectors.mapping(Address::getName,Collectors.toList())));
        nameByCity.forEach((city, names) -> System.out.println(city+ " has " +"persons "+ names));
        Map<String,List<String>> nameByState =
                contact.stream().collect(Collectors.groupingBy(Address::getState, TreeMap::new,Collectors.mapping(Address::getName,Collectors.toList())));
        nameByState.forEach((state, names) -> System.out.println(state+ " has " +" persons "+ names));
        city.putAll(nameByCity);
        state.putAll(nameByState);
    }

    void searchByCityOrStateWithNumberOfPerson(){


        Map<String,Long> countCity = contact.stream().collect(Collectors.groupingBy(Address::getCity, TreeMap::new, Collectors.counting()));
        countCity.forEach((city, count) -> System.out.println(city+ " has " +"Number of persons "+ count));
        Map<String,Long> countState = contact.stream().collect(Collectors.groupingBy(Address::getCity, TreeMap::new, Collectors.counting()));
        countState.forEach((state, count) -> System.out.println(state+ " has " +"Number of persons "+ count));

    }

    void dictionaryOfCityAndState(){

    }
    public static void main(String[] args) {
        AddressBookMain entry = new AddressBookMain();
        Scanner scr = new Scanner(System.in);
        entry.addEntry(scr);
        entry.searchByCityOrStateWithNumberOfPerson();
        entry.viewPersons();
        scr.close();





    }

}
