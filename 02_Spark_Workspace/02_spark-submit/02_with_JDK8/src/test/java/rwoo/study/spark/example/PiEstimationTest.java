package rwoo.study.spark.example;

import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.util.FileUtil;

import java.io.File;

public class PiEstimationTest extends FileUtil {
    private PiEstimation piEstimation;
    private String[] args;

    @Before
    public void setUp() throws Exception {
        piEstimation = new PiEstimation();
        args = new String[3];
        args[0] = "src/test/resources/input/PiEstimation/numbers.txt";
        args[1] = "src/test/resources/output/PiEstimation";
        args[2] = "local[*]";
        this.deleteDirectory(new File(args[1]));
    }

    @Test
    public void test_PiEstimation() throws Exception {
        piEstimation.main(args);
    }
}