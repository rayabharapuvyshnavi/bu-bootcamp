
import java.util.*;

public class ContactManager{

    static HashMap<String , Contact> contacts = new HashMap<>();

    public String getContact(String name){
        Contact contact = contacts.get(name);
        return (contact == null ) ?  "Contact Not Found" : contact.toString();
    }

    public static void main(String [] abs){
        
        ContactManager cm = new ContactManager();

        contacts.put("Vyshnavi", new Contact("Vyshnavi", "2121212121"));
        contacts.put("Sushrith", new Contact("Sushrith", "2546376543"));
        contacts.put("Raju", new Contact("Raju", "2634648647"));
        contacts.put("Jyothi", new Contact("Jyothi", "2675467896"));
        contacts.put("Kruthika", new Contact("Kruthika", "2765639872"));
        
        System.out.println(cm.getContact("Kruthika"));
        System.out.println(cm.getContact("Swetha"));
        System.out.println("");



        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        sorted.sort((a,b) -> a.getName().compareTo(b.getName()));
        System.out.println("Sorted List: ");
        for(Contact c : sorted){
            System.out.println(c);
        }
        
    }
}