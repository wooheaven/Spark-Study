package rwoo.study.spark.voidfunction;

import org.apache.spark.api.java.function.VoidFunction;

import java.io.FileWriter;
import java.util.Iterator;

public class CustomVoidfunctionAppendAndPrintWithIterator implements VoidFunction<Iterator<Integer>> {
    @Override
    public void call(Iterator<Integer> iter) throws Exception {
        FileWriter f = new FileWriter("src/test/resources/input/ForeachPartitionTest/input.txt", true);
        f.write("for each partition -> iterator = \n");
        System.out.println("for each partition -> iterator = ");
        while (iter.hasNext()) {
            String element = iter.next().toString();
            f.write("for each partition -> iterator -> element = " + element + "\n");
            System.out.println("for each partition -> iterator -> element = " + element);
        }
        f.close();
    }
}
