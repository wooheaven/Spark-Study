package rwoo.study.spark.function;

import org.apache.spark.api.java.function.Function2;

public class CustomFunction2Sum implements Function2<Double, Double, Double> {
    @Override
    public Double call(Double x, Double y) throws Exception {
        return x + y;
    }
}
