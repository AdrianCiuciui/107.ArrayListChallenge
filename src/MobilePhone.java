import java.util.ArrayList;

public class MobilePhone {
    
    private ArrayList<Contact> list;

    //public methods

    public MobilePhone () {
        this.list = new ArrayList<Contact>();
    }

    public ArrayList <Contact> getList () {
        return list;
    }

    public void addContact (Contact contact) {
        this.list.add(contact);
    }

    public void deleteContact (String contact) {
        int position = findContact(contact);
        if (position >= 0) deleteContact(position);
        System.out.println("Contact from position " + position + "deleted");
    }

//    public void modifyContact (Contact oldC, Contact newC) {
//        int position = findContact(oldC);
//        if (position >= 0) {
//            System.out.println(oldC.getName() + " with number " + oldC.getNumber() + " will be overwritten by:");
//            modifyContact(position, newC);
//        }
//        else System.out.println("No changes have been made to the list");
//    }

    public void printContacts () {
        System.out.println("Your " + list.size() + " contact(s) are:");
        for (int i = 0; i< list.size(); i++) System.out.println((i+1) + ". " + list.get(i));
    }

    public void printMenu () {
        System.out.println("This is the Menu - choose what to do by inputting a number.\n" +
                "0. quit\n" +
                "1. display contacts\n" +
                "2. add contact\n" +
                "3. delete contact\n" +
                "4. edit contact.\n" +
                "5. search contact");
    }

    public boolean findContact2(String name) {
        return findContact(name) >= 0;
    }

    // private methods

    private int findContact(String name) {
        return list.indexOf(name);
    }

    private void deleteContact (int position) {
        list.remove(position);
    }

    private void modifyContact (int position, Contact newC) {
        list.set(position, newC);
        System.out.println(newC.getName() + " with number " + newC.getNumber());
    }




}