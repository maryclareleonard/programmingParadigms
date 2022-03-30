//import static java.util.Arrays.asList;
import java.util.*;

public final class FlattenList {
    public static List<Object> flatten(List<Object> passedList) {
        List<Object> finalList = new LinkedList<Object>();
        flatten(passedList,finalList);
        return finalList;
    }

    public static void flatten (List<?> passedList, List<Object> finalList) {
        for (Object item : passedList) {
            if (item instanceof List<?>) { //remove the extra [] and [[]] (lists within the list)
                flatten((List<?>)item, finalList);
            } else {
                if (item != null) {
                    finalList.add(item);
                } else{
                }
            }
        }
    }
}
