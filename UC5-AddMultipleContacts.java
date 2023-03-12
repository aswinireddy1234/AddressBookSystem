package addressbooksystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class AddressBookSystem {

    private static final ArrayList<ArrayList<String>> address_book = new ArrayList<>();

    public void createContacts(ArrayList<String> contact) {

        AddressBook.address_book.add(contact);

        for (ArrayList<String> i : AddressBook.address_book) {
            for (String j : i) {
                System.out.println(j);
            }
        }
    }
    public void addContact(){
        ArrayList <String> contact = enterContactDetails();
        createContacts(contact);
    }
    // Asks to enter all the details of person
    public ArrayList enterContactDetails(){
        ArrayList <String> contact = new ArrayList <String>();

        System.out.println("Enter the first name: ");
        Scanner sc1 = new Scanner(System.in);
        String first_name = sc1.next();
        contact.add(first_name);

        System.out.println("Enter the last name: ");
        Scanner sc2 = new Scanner(System.in);
        String last_name = sc2.next();
        contact.add(last_name);

        System.out.println("Enter the address: ");
        Scanner sc3 = new Scanner(System.in);
        String address = sc3.next();
        contact.add(address);

        System.out.println("Enter the city name: ");
        Scanner sc4 = new Scanner(System.in);
        String city = sc4.next();
        contact.add(city);

        System.out.println("Enter the state's name: ");
        Scanner sc5 = new Scanner(System.in);
        String state = sc5.next();
        contact.add(state);

        System.out.println("Enter the zip: ");
        Scanner sc6 = new Scanner(System.in);
        String zip = sc6.next();
        contact.add(zip);

        System.out.println("Enter the phone number: ");
        Scanner sc7 = new Scanner(System.in);
        String phone_num = sc7.next();
        contact.add(phone_num);

        System.out.println("Enter the email ID: ");
        Scanner sc8 = new Scanner(System.in);
        String email = sc8.next();
        contact.add(email);

        return contact;
    }
    public int searchExistingContact(String search_pers){
        int index = -1;
        int temp_index = -1;
        for (ArrayList <String> i:AddressBook.address_book){
            // find index of arraylist in which the given name is there
            temp_index ++;
            for (String j:i){
                // if name is found
                if (j.equals(search_pers)){
                    index = temp_index;
                    break;
                }
            }
        }
        return index;
    }
    public void editExistingContact(){
        System.out.println("Enter the name of the person whose details you "+ "want to be changed");
        Scanner sc = new Scanner(System.in);
        String search_person = sc.next();
        int index = searchExistingContact(search_person);
        System.out.println("Found the name, Kindly enter new details ");
        ArrayList <String> contact = enterContactDetails();
        AddressBook.address_book.set(index, contact);
        }
    public void deleteExistingContact(){
        System.out.println("Enter the name of the person whose details you " + "want to be deleted");
        Scanner sc = new Scanner(System.in);
        String search_person = sc.next();
        // Fetch the index of person in address book
        int index = searchExistingContact(search_person);
        // delete the details of person
        AddressBook.address_book.remove(index);
    }

    public void addMultiplePerson(){

        System.out.println("Enter the number of persons whose details you want " + "to add to the address book");

        Scanner sc = new Scanner(System.in);

        int no_of_person = sc.nextInt();

        for (int i=1;i<=no_of_person;i++){
            addContact();

        }

    }
    public static void main(String []args) {
        System.out.println("Welcome to Address Book Program!");
        AddressBook addressbook = new AddressBook();
        addressbook.enterContactDetails();
        addressbook.editExistingContact();
        addressbook.deleteExistingContact();
        addressbook.addMultiplePerson();
    }
}
