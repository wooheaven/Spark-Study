package rwoo.study.spark.example;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class WordCountTest {
    private WordCount wordCount;
    private String[] args;

    @Before
    public void setUp() throws Exception {
        wordCount = new WordCount();
        args = new String[3];
        args[2] = "local[*]";
        args[0] = "src/test/resources/input";
    }

    @Test
    public void testWordCountResultFile() throws Exception {
        args[1] = "src/test/resources/output";
        this.deleteDirectory(new File(args[1]));
        wordCount.main(args);
    }

    private void deleteDirectory(File file) {
        File[] subFiles = file.listFiles();
        if(null != subFiles) {
            for (File subfile : subFiles) {
                deleteDirectory(subfile);
            }
        }
        file.delete();
    }
}