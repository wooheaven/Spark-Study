package rwoo.study.spark.pairflatmapfunction;

import com.google.common.collect.Iterables;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomPairFlatMapFunction implements PairFlatMapFunction<Tuple2<String, Iterable<String>>, String, Tuple2<String, Double>> {
    @Override
    public Iterator<Tuple2<String, Tuple2<String, Double>>> call(Tuple2<String, Iterable<String>> items) throws Exception {
        List<Tuple2<String, Tuple2<String, Double>>> myContributions = new ArrayList<>();
        items._2().forEach(dest ->
                myContributions.add(new Tuple2<>(items._1(), new Tuple2<>(dest, 1.0 / Iterables.size(items._2()))))
        );
        return myContributions.iterator();
    }
}
