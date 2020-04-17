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

    public boolean addContact (Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already in the agenda");
            return false;
        }
        list.add(contact);
        return true;
    }

    public boolean deleteContact (Contact contact) {
        int position = findContact(contact);
        if (position >= 0) {
            deleteContact(position);
            System.out.println("Contact from position " + (position + 1) + " deleted");
            return true;
        }
        System.out.println("Could not find contact " + contact.getName() );
        return false;
    }

    public boolean modifyContact (Contact oldC, Contact newC) {
        int position = findContact(oldC);
        if (position >= 0) {
            System.out.println(oldC.getName() + " with number " + oldC.getNumber() + " will be overwritten by " +
                    newC.getName() + " with number " + newC.getNumber());
            this.list.set(position, newC);
            return true;
        }
        else System.out.println("No changes have been made to the list " + oldC.getName() + " was not found");
        return false;
    }

    public void printContacts () {
        System.out.println("Your " + list.size() + " contact(s) are:");
        for (int i = 0; i < list.size(); i++) System.out.println((i + 1) + ". " + list.get(i).getName()
                + " " + list.get(i).getNumber());
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

    public String queryContact (Contact contact) {
        if (findContact(contact) >= 0) return contact.getName();
        else return null;
    }

    public Contact queryContact (String name) {
        int position = findContact(name);
        if (position >= 0) return this.list.get(position);
        return null;
    }

    // private methods

    private int findContact(Contact contact) {
        return this.list.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < this.list.size(); i++) {
            Contact contact = this.list.get(i);
            if (contact.getName().equals(name)) return i;
        }
        return -1;
    }

    private void deleteContact (int position) {
        list.remove(position);
    }
}