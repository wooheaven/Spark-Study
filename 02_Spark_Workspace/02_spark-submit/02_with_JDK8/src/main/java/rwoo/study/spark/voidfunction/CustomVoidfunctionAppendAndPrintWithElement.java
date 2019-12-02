package rwoo.study.spark.voidfunction;

import org.apache.spark.api.java.function.VoidFunction;

import java.io.FileWriter;
import java.io.IOException;

public class CustomVoidfunctionAppendAndPrintWithElement implements VoidFunction<Integer> {
    private static void append(Integer v) throws IOException {
        FileWriter f = new FileWriter("src/test/resources/input/ForeachTest/input.txt", true);
        f.write("num = " + v + "\n");
        f.close();
    }

    @Override
    public void call(Integer v) throws Exception {
        append(v);
        System.out.println(v);
    }
}
