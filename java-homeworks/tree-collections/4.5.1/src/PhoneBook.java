import java.util.*;


public class PhoneBook {
    private Map<String, List<Contact>> phonebook = new HashMap<>();

    public boolean createGrouptoPhoneBook(String nameOfGroup) {
        if (phonebook.containsKey(nameOfGroup)) return false;
        phonebook.put(nameOfGroup, new ArrayList<Contact>());
        return true;
    }

    public boolean addContacttoGroups(Contact contact, String... namesOfGroups) {
        for (String n : namesOfGroups) {
            if (!phonebook.containsKey(n)) return false;
            phonebook.get(n).add(contact);
        }
        return true;
    }

    /*public List<Contact> getContactsofGroup(String nameOfGroup) {
        if (phonebook.get(nameOfGroup) == null) return null;
        return phonebook.get(nameOfGroup);
    }

    public String getNameOfContact(Contact contact) {
        for (List<Contact> spisok : phonebook.values()) {
            for (Contact c : spisok) {
                if (c.getNumber().equals(contact.getNumber())) {
                    return contact.getName();
                }
            }
        }
        return null;
    }*/

    public Contact searchContactByNumber(Long number) {
        for (List<Contact> spisok : phonebook.values()) {
            for (Contact c : spisok) {
                if (c.getNumber().equals(number)) {
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Мои группы : " + phonebook.keySet() + " и их контакты :" + phonebook.entrySet();
    }
}








