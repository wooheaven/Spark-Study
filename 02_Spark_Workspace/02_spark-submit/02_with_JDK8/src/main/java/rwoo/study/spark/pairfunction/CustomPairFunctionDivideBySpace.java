package rwoo.study.spark.pairfunction;

import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

public class CustomPairFunctionDivideBySpace implements PairFunction<String, String, String> {
    @Override
    public Tuple2<String, String> call(String v) throws Exception {
        String[] fields = v.split(" ");
        return new Tuple2<>(fields[0], fields[1]);
    }
}
