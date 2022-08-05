
import org.junit.jupiter.api.*;
import java.util.ArrayList;


@DisplayName("PhoneBookTest Class")
public class PhoneBookTest {



    @BeforeAll
    public static void initiation() {
        System.out.println("Начало тестирования  работы методов класса Phonebook");
    }

    @BeforeEach
    public void initBefeoreEach() {

        System.out.println("Начало теста");
    }

    @AfterEach
    public void exit() {
        System.out.println("Тест пройден");
    }

    @AfterAll
    public static void completion() {
        System.out.println("Завершение  тестирования  работы методов класса Phonebook");

    }

    @Test
    @DisplayName(value = "PhoneBookTest Class")
    public void createGrouptoPhoneBook() {
        PhoneBook phoneBookTest = new PhoneBook();
        String testGroup = "ТестГруппа";
        phoneBookTest.createGrouptoPhoneBook(testGroup);
        Assertions.assertTrue(phoneBookTest.getPhonebook().containsKey(testGroup), "Тест метода createGrouptoPhoneBook не пройден!");
    }

    @Test
    public void addContacttoGroups() {
        PhoneBook phoneBookTest = new PhoneBook();
        Contact contact = new Contact("TestName", 8_987_654_3210L);
        String testGroup1 = "Home";
        String testGroup2 = "Job";
        String testGroup3 = null;
        phoneBookTest.getPhonebook().put("Job", new ArrayList<>());
        phoneBookTest.getPhonebook().put(testGroup3, new ArrayList<>());
        boolean actual1 = phoneBookTest.addContacttoGroups(contact, testGroup1);
        boolean actual2 = phoneBookTest.addContacttoGroups(contact, testGroup2);
        Assertions.assertFalse(actual1);
        Assertions.assertTrue(actual2);
    }

    @Test
    public void nameOfGroupShouldBeNotNull() {
        PhoneBook phoneBookTest = new PhoneBook();
        Assertions.assertFalse(phoneBookTest.getPhonebook().containsKey(null));

    }


}
