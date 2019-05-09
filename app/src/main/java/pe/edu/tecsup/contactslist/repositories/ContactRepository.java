package pe.edu.tecsup.contactslist.repositories;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.contactslist.models.Contact;

public class ContactRepository {

    private static List<Contact> contacts = new ArrayList<>();

    static {
        contacts.add( new Contact(100, "Bembos", "bembos@hotmail.com", "bembos") );
        contacts.add( new Contact(200, "Burguer King", "burguerking@gmail.com", "burguer") );
        contacts.add( new Contact(300, "Chinawok", "chinawok@gmail.com", "china") );
        contacts.add( new Contact(400, "Pizza Hut", "pizzahut@gmail.com", "hut") );
        contacts.add( new Contact(500, "McDonald's", "mcdonals@gmail.com", "mcd") );
        contacts.add( new Contact(600, "Papa Johns", "papajohns@gmail.com", "papaj") );
        contacts.add( new Contact(700, "KFC", "kfc@gmail.com", "kfc") );
        contacts.add( new Contact(800, "Popeyes", "popeyes@gmail.com", "popeyes") );
        contacts.add( new Contact(900, "Starbucks", "starbucks@gmail.com", "star") );


    }

    public static List<Contact> getContacts() {
        return contacts;
    }

    public static Contact getContactById(Integer id){
        for (Contact contact: contacts) {
            if(contact.getId().equals(id)) {
                return contact;
            }
        }
        return null;
    }
}
