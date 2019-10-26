package rwoo.study.spark.function;

import org.apache.spark.api.java.function.Function;
import scala.Tuple2;

public class CustomFunction implements Function<Iterable<String>, Tuple2<String, Double>> {
    @Override
    public Tuple2<String, Double> call(Iterable<String> v) throws Exception {
        return new Tuple2<>(v.toString(), 1.0);
    }
}
