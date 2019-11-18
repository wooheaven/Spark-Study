package rwoo.study.spark.function;

import org.apache.spark.api.java.function.Function2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomFunction2IndexSum implements Function2<Integer, Iterator<String>, Iterator<String>> {
    @Override
    public Iterator<String> call(Integer splitIndex, Iterator<String> partition) throws Exception {
        int sum = 0;
        while (partition.hasNext()) {
            sum += Integer.parseInt(partition.next());
        }
        List<String> partitionSum = new ArrayList<>();
        partitionSum.add(splitIndex + " : " + sum);
        return partitionSum.iterator();
    }
}
