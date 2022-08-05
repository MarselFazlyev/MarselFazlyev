public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected Condition ageCondition;
    protected Condition cityCondition;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setAgeCondition(Condition ageCondition) {
        this.ageCondition = ageCondition;
    }

    public void setCityCondition(Condition cityCondition) {
        this.cityCondition = cityCondition;
    }

    public void setAge(int age) {
        this.age = age;
        this.ageCondition = Condition.KNOWN;
    }

    public void setCity(String city) {
        this.city = city;
        this.cityCondition = Condition.KNOWN;
    }

    private boolean hasAge() {
        return this.ageCondition == Condition.KNOWN;
    }

    public boolean hasAdress() {
        if (this.cityCondition == Condition.KNOWN) {
            System.out.println("Город проживания: " + this.city + ".");
            return true;
        } else {
            System.out.println("Город проживания неизвестен");
            return false;
        }
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age++;
            System.out.println("C твоим " + this.age + " Днем Рождения, всех благ, " + this.name + "!");
        } else
            System.out.println("Возраст неизвестен,с днем Рождения поздравить не удастся :(");

    }

    public PersonBuilder newChildBuilder() {

        return new PersonBuilder().setSurname(this.surname).setAge(0).setCity(this.city);
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "\nname=" + name +
                "\nsurname=" + surname +
                "\nage=" + age +
                "\nageCondition=" + ageCondition +
                "\ncityCondition=" + cityCondition +
                "\ncity=" + city +
                '}';
    }
}


