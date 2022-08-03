import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        MissedCalls m = new MissedCalls();

        Contact[] allMycontacts = new Contact[]{
                new Contact("Оля", 89234567890L),
                new Contact("Петя", 89851524675L),
                new Contact("Даша", 89271234567L),
                new Contact("Сергей", 89264563217L),
                new Contact("Петр", 89213451278L)
        };

        phoneBook.createGrouptoPhoneBook("Job");
        phoneBook.createGrouptoPhoneBook("Home");

        phoneBook.addContacttoGroups(allMycontacts[0], "Job");
        phoneBook.addContacttoGroups(allMycontacts[1], "Home");
        phoneBook.addContacttoGroups(allMycontacts[2], "Job", "Home");
        phoneBook.addContacttoGroups(allMycontacts[3], "Job", "Home");
        phoneBook.addContacttoGroups(allMycontacts[4], "Home");

        while (true) {
            System.out.println("Введите пропущенный вызов или end для завершения.");
            String input = s.nextLine();
            if (input.equals("end")) break;
            Long number = Long.parseLong(input);
            m.addMissedCall(number);
        }

        m.printMissedCalls(phoneBook);


    }


}
