import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone myAgenda = new MobilePhone();

    public static void main (String[] args) {
        myAgenda.printMenu();
        while (true) {
            int choice = 0;
            choice = scan.nextInt(); scan.nextLine();
            switch (choice) {
                case 1:
                    myAgenda.printContacts(); break;
                case 2:
                    addContact(); break;
                case 3:
                    deleteContact(); break;
                case 4:
                    modifyContact(); break;
                case 5:
                    findContact(); break;
                default: break;
            }
            if (choice == 0) break;
        }
    }

    private static void addContact () {
        System.out.println("Insert name");
        String name = scan.nextLine();
        System.out.println("Insert phone number");
        String number = scan.nextLine();
        Contact contact = Contact.createContact(name, number);
        if (myAgenda.isContactDuplicate(contact)) {
            System.out.println("New contact added " + name + " " + number);
        }
    }

    private static void deleteContact () {
        System.out.println("Input the name you want to delete");
        String name = scan.nextLine();
        Contact contact = myAgenda.queryContact(name);
        if (contact == null) System.out.println("Contact not found");
        else
            myAgenda.deleteContact(contact);
    }

    private static void modifyContact () {
        System.out.println("Input the name you want to modify - original");
        String name = scan.nextLine();
        System.out.println("Input the name you want to change to ");
        Contact existingContactRecord = myAgenda.queryContact(name);
        if (existingContactRecord == null) System.out.println("Contact not found");

        System.out.println("Insert name");
        String nameNew = scan.nextLine();
        System.out.println("Insert phone number");
        String number = scan.nextLine();
        Contact contactNew = Contact.createContact(nameNew, number);
        if (myAgenda.modifyContact(existingContactRecord, contactNew))
            System.out.println("Successfully  updated record");
        else
            System.out.println("Error updating contact");
    }

    private static void findContact () {
        System.out.println("Input the name you want to modify - original");
        String name = scan.nextLine();
        System.out.println("Input the name you want to change to ");
        Contact existingContactRecord = myAgenda.queryContact(name);
        if (existingContactRecord == null) System.out.println("Contact not found");
        else
            System.out.println(name + " with number" + existingContactRecord.getNumber() +  " was found in the phone's agenda");
    }
}