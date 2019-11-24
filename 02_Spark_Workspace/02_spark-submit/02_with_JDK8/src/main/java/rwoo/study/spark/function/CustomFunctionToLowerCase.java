package rwoo.study.spark.function;

import org.apache.spark.api.java.function.Function;

public class CustomFunctionToLowerCase implements Function<String, String> {
    @Override
    public String call(String v) throws Exception {
        return v.toLowerCase();
    }
}
