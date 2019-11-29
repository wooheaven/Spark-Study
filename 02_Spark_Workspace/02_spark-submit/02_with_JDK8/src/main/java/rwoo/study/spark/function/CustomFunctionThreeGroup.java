package rwoo.study.spark.function;

import org.apache.spark.api.java.function.Function;

public class CustomFunctionThreeGroup implements Function<Integer, Integer> {
    @Override
    public Integer call(Integer v) throws Exception {
        return v % 3;
    }
}
