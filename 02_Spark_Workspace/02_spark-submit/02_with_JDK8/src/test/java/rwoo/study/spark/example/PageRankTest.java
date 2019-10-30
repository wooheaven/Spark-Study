package rwoo.study.spark.example;

import org.junit.Before;
import org.junit.Test;
import rwoo.study.spark.util.FileUtil;

import java.io.File;

public class PageRankTest extends FileUtil {
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
        this.deleteDirectory(new File(args[1]));
    }

    @Test
    public void testPageRanks() throws Exception {
        pageRank.main(args);
    }
}