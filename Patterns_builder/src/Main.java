public class Main {
    public static void main(String[] args) {
        Person person = PersonBuilder.create()
                .setName("Диана")
                .setSurname("Иванова")
                .setAge(12)
                .setCity("Москва")
                .build();

        person.happyBirthday();

        person.hasAdress();

        System.out.println(person);
        System.out.println(person.newChildBuilder().build());

    }


}
