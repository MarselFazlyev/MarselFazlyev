import java.util.Random;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Contact[] allMycontacts = new Contact[10]; //создание  масиива контактов с помощью статического метода createContact
        for (int i = 0; i < 10; i++) allMycontacts[i] = createContact();

        phoneBook.createGrouptoPhoneBook("Job");//создание группы контактов;
        phoneBook.createGrouptoPhoneBook("Home");
        phoneBook.createGrouptoPhoneBook("Chill");

        addOrNotContactToGroup(phoneBook, allMycontacts, "Job", "Home", "Chill");
        //добавление рандомно контакта в разные группы;

        System.out.println(phoneBook.getContactsofGroup("лррп")); // несуществующая группа
        System.out.println(phoneBook.getContactsofGroup("Home")); // существующая группа

        System.out.println(phoneBook.searchContact(8_912_456_78_01L));//тест метода searchContact
        // для несуществующего номера в записной книжке
        System.out.println(phoneBook.searchContact(allMycontacts[0].getNumber()));//тест метода searchContact
        // для существующего номера в записной книжке

    }

    private static Contact createContact() {
        String[] names = new String[]{
                "Grisha", "Pasha", "Olya", "Masha", "Sasha", "Ignat", "Gomer", "Michael", "Taburetka", "Innokentiy"};
        long[] teleNumbers = new long[]{
                8_912_456_78_00L,
                8_913_033_78_01L,
                8_914_146_78_02L,
                8_922_877_78_03L,
                8_925_000_78_04L,
                8_927_123_78_05L,
                8_917_462_78_06L,
                8_914_961_78_07L,
                8_916_023_78_08L,
                8_961_320_87_09L,
                8_982_153_18_10L,
        };
        Random r = new Random();
        return new Contact(names[r.nextInt(names.length)], teleNumbers[r.nextInt(teleNumbers.length)]);
    }

    private static void addOrNotContactToGroup(PhoneBook phoneBook, Contact[] contacts, String... namesOfGroups) {
        Random random = new Random();
        for (Contact c : contacts) {
            for (String n : namesOfGroups) {
                if (random.nextBoolean()) {
                    phoneBook.addContacttoGroups(c, n);
                }
            }

        }

    }


}










