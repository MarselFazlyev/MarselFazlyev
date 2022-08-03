import java.util.Objects;

public class Student {
    private String name;
    private String group_number;
    private int id;

    public Student(String name, String group_number, int id) {
        this.name = name;
        this.group_number = group_number;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getGroup_number() {
        return group_number;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Студент : " + name +
                "\nГруппа : " + group_number +
                "\nНомер студбилета : " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
