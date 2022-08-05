import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshhold;

    public Filter(int treshhold) {
        this.treshhold = treshhold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer integer : source) {
            if (integer > treshhold) {
                result.add(integer);
                logger.log("Число прошло фильтрацию и записано в результирующий список");
            } else logger.log("Число не прошло фильтрацию");
        }
        return result;


    }
}
