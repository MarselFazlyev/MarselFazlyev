import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsAnything.anything;

@DisplayName("PhoneBookHamcrestTest Class")
public class PhoneBookHamcrestTest {


    @BeforeAll
    public static void initiation() {
        System.out.println("Начало тестирования  класса Phonebook c помощью средств библиотеки Hamcrest");
    }

    @BeforeEach
    public void initBefeoreEach() {
        System.out.println("Начало теста");
    }

    @AfterEach
    public void exit() {
        System.out.println("Тест завершен");
    }

    @AfterAll
    public static void completion() {
        System.out.println("Завершение  тестирования  методов класса Phonebook");
    }

    @Test
    public void createGrouptoPhoneBook() {
        PhoneBook phoneBookTest = new PhoneBook();
        String testGroup = "ТестГруппа";
        phoneBookTest.createGrouptoPhoneBook(testGroup);
        assertThat(phoneBookTest.getPhonebook(), Matchers.hasKey("ТестГруппа"));
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
        assertThat(actual1, Matchers.is(false));
        assertThat(actual2, Matchers.is(true));
    }

    @Test
    public void nameOfGroupShouldBeNotNull() {
        PhoneBook phoneBookTest = new PhoneBook();
        String test = "Test";
        phoneBookTest.getPhonebook().put(test, new ArrayList<>());
        for (Map.Entry<String, List<Contact>> a : phoneBookTest.getPhonebook().entrySet()) {
            assertThat(a.getKey(), Matchers.notNullValue());
        }
    }

    @Test
    public void contactShouldbeReturnIfNumberIsPresent() {
        PhoneBook phoneBook = new PhoneBook();
        String testGroup = "TestGroup";
        Contact contact = new Contact("TestName", 8_987_654_3210L);
        phoneBook.createGrouptoPhoneBook(testGroup);
//        можно сделать mock  с помощью Mockito.
        phoneBook.addContacttoGroups(contact, testGroup);
        Optional<Contact> actual = phoneBook.searchContact(8_987_654_3210L);
        Contact contact1 = null;
        if (actual.isPresent()) {
            contact1 = actual.get();
        }
        assertThat(contact1, Matchers.is(contact));


    }

    @Test
    public void searchContactShouldReturnEmptyOptional() {
        long number = 4_000_000_0001L;
        PhoneBook phoneBook = new PhoneBook();
        assertThat(phoneBook.searchContact(number), Matchers.equalTo(Optional.empty()));
    }


}
