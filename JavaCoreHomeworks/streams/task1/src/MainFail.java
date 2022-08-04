import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainFail {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));
        /*List<Integer> list2 = new ArrayList<>();
        for (int i : list) {
            if (i <= 0 || i % 2 != 0) {i -= i;}
            if (i != 0) {list2.add(i);}
        }
        list2.sort(Integer::compareTo);
        System.out.println(list2);*/
        Iterator<Integer> Iterator = list.listIterator();
        while (Iterator.hasNext()) {
            Integer nextInteger = Iterator.next();
            if (nextInteger % 2 != 0 || nextInteger <= 0) {
                Iterator.remove();
            }
        }
        list.sort(Integer::compareTo);
        System.out.println(list);


    }
}
