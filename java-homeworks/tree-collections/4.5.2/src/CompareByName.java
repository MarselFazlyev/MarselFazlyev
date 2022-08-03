import java.util.Comparator;

public class CompareByName implements Comparator<Candidate> {
    @Override
    public int compare(Candidate o1, Candidate o2) {
        return o1.getFullname().compareTo(o2.getFullname());
    }
}
