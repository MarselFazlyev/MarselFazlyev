import java.util.NavigableSet;
import java.util.TreeSet;

public class Storage {
    private NavigableSet<Candidate> storage = (new TreeSet<Candidate>()).descendingSet();

    public void addCandidate(Candidate candidate) {
        storage.add(candidate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Candidate candidate : storage) {
            sb.append(candidate);
            sb.append("\n");
        }
        return sb.toString();

    }
}
