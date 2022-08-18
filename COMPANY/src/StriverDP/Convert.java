package StriverDP;

import java.util.Iterator;
import java.util.List;

public class Convert {



    //Best way TO CONVERT AN ARRAYLIST TO ARRAY-Primitive type
    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

}
