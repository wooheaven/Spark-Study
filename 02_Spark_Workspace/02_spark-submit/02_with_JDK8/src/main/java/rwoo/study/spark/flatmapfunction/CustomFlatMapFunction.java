package rwoo.study.spark.flatmapfunction;

import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomFlatMapFunction implements FlatMapFunction<Iterator<Integer>, Integer> {
    @Override
    public Iterator<Integer> call(Iterator<Integer> partition) throws Exception {
        List<Integer> partitionSum = new ArrayList<>();
        int sum = 0;
        while (partition.hasNext()) {
            sum += partition.next();
        }
        partitionSum.add(sum);
        return partitionSum.iterator();
    }
}
