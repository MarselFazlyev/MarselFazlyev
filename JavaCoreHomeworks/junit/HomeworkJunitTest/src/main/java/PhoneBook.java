import java.util.*;


public class PhoneBook {
    private Map<String, List<Contact>> phonebook = new HashMap<>();

    public Map<String, List<Contact>> getPhonebook() {return phonebook;}

    public boolean createGrouptoPhoneBook(String nameOfGroup) {
        if (phonebook.containsKey(nameOfGroup)) return false;
        phonebook.put(nameOfGroup, new ArrayList<>());
        return true;
    }


    public boolean addContacttoGroups(Contact contact, String... namesOfGroups) {
        for (String n : namesOfGroups) {
            if (!phonebook.containsKey(n)) return false;
            phonebook.get(n).add(contact);
        }
        return true;
    }

    public Optional<List<Contact>> getContactsofGroup(String nameOfGroup) {
        return Optional.ofNullable(phonebook.get(nameOfGroup));
    }

    public Optional<Contact> searchContact(long number) {
        for (List<Contact> spisok : phonebook.values()) {
            for (Contact c : spisok) {
                if (number == c.getNumber()) {
                    return Optional.of(c);

                }
            }
        }
        return Optional.empty();
    }


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Map.Entry<String, List<Contact>> a : phonebook.entrySet()) {
            b.append("Группа: " + a.getKey() + "\nCписок контактов: " + a.getValue());
        }
        return b.toString();

    }


}








