package rwoo.study.spark.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PageRankTest {
    private PageRank pageRank;
    private String[] args;

    @Before
    public void setUp() throws Exception {
        pageRank = new PageRank();
        args = new String[4];
        args[0] = "src/test/resources/input/pageLinks.txt";
        args[1] = "src/test/resources/output/pageRanks";
        args[2] = "2";
        args[3] = "local[*]";
    }

    @Test
    public void testPageRanks() throws Exception {
        this.deleteDirectory(new File(args[1]));
        pageRank.main(args);
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