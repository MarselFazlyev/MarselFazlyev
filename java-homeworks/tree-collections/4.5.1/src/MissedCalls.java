import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, Long> missedCalls = new TreeMap<>();

    public void addMissedCall(Long number) {
        missedCalls.put(LocalDateTime.now(), number);
    }


    public void printMissedCalls(PhoneBook phoneBook) {
        for (Map.Entry<LocalDateTime, Long> mc : missedCalls.entrySet()) {
            if (phoneBook.searchContactByNumber(mc.getValue())!=null) {
                System.out.println(mc.getKey() + " " + phoneBook.searchContactByNumber(mc.getValue()).getName());
            } else {
                System.out.println(mc.getKey() + " " + mc.getValue() + " Неизвестный номер");

            }

        }
    }
}



