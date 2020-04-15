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

    public static void addContact () {
        System.out.println("Insert name");
        String name = scan.nextLine();
        System.out.println("Insert phone number");
        String number = scan.nextLine();
        Contact contact = new Contact(name, number);
        myAgenda.addContact(contact);
        // folosind acest cod ajung sa imi fie create contacte gen:
        // Contact@2a2d45ba Contact@2a5ca609 si nu inteleg de ce
        // sa fie acestea referintele din memorie?
    }

    public static void deleteContact () {
        System.out.println("Input name of the contact you want deleted");
        String input = scan.nextLine();
        myAgenda.deleteContact(input);
    }

    public static void modifyContact () {
        System.out.println("Input the name you want to modify - original");
        String name = scan.nextLine();
        System.out.println("Input the name you want to change to ");
        // aici nu e gata inca
    }

    public static void findContact () {
        System.out.println("Input name you want to find");
        String name = scan.nextLine();
        if (myAgenda.findContact2(name)) System.out.println(name + " was found in the phone's agenda");
        else System.out.println(name + " was not found in the phone's agenda");
        // aici nu e gata inca
    }
}
