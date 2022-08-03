public class Candidate implements Comparable<Candidate> {
    private String fullname;
    private Character gender;
    private Integer age;
    private Integer relevance;
    private Integer rating;

    public Candidate(String fullname, Character gender, Integer age, Integer relevance, Integer rating) {
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
        this.relevance = relevance;
        this.rating = rating;
    }

    public String getFullname() {
        return fullname;
    }

    public Character getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Integer getRelevance() {
        return relevance;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public int compareTo(Candidate o) {
        if (relevance < o.relevance) return -1;
        else if (relevance > o.relevance) return 1;
        else {
            return rating.compareTo(o.rating);
        }
    }

    @Override
    public String toString() {
        return fullname + " Пол " + gender + " Возраст " + age + " Релевантность " + relevance + " Оценка " + rating;
    }
}



