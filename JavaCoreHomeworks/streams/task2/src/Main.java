import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Cергей", "Александр", "Петр", "Валерий", "Яша", "Франк", "Оля", "Даша", "Вера");
        List<String> lastnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown", "Tyson", "Baden");
        Collection<Person> allPersons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            allPersons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    lastnames.get(new Random().nextInt(lastnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }
        long count = allPersons.stream().filter(person -> person.getAge() < 18).count(); // количество несовершеннолетних
        System.out.println("Количество несовершеннолетних в городе Paradise составляет: " + count + " человек.");


        List<String> prizyvniki = allPersons.stream().filter(person -> person.getSex() == Sex.MAN) // фамилии призывников
                .filter(person -> person.getAge() < 27 && person.getAge() >= 18).map(Person::getFamily).limit(10).collect(Collectors.toList());
        System.out.println(prizyvniki);


        List<Person> rabotosposobnye = allPersons.stream().filter(person -> {
            // отсортированные по фамилии работоспосоные люди
            if (person.getSex() == Sex.WOMAN) {
                return person.getAge() < 60 && person.getAge() >= 18;
            } else return person.getAge() < 65 && person.getAge() >= 18;
        }).sorted(new PersonsLastnameComparator()).limit(100).collect(Collectors.toList());
        System.out.println(rabotosposobnye);





    }
}
