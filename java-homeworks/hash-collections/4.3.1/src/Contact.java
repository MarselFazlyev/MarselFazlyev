public class Contact {
    private String name;
    private Long number;

    public Contact(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Контакт{" +
                "имя->'" + name + '\'' +
                ", номер->" + number +
                '}';
    }
}
