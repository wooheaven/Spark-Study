package rwoo.study.spark.comparator;

import java.io.Serializable;
import java.util.Comparator;

public class CustomComparatorLowerCase implements Comparator<String>, Serializable {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
