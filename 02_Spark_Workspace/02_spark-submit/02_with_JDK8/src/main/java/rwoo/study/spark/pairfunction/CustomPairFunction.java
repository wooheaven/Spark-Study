package rwoo.study.spark.pairfunction;

import com.google.common.collect.Iterables;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

public class CustomPairFunction implements PairFunction<Tuple2<String, Iterable<String>>, String, Tuple2<Iterable<String>, Double>> {
    @Override
    public Tuple2<String, Tuple2<Iterable<String>, Double>> call(Tuple2<String, Iterable<String>> items) throws Exception {
        return new Tuple2<>(items._1(), new Tuple2<>(items._2(), 1.0 / Iterables.size(items._2())));
    }
}
