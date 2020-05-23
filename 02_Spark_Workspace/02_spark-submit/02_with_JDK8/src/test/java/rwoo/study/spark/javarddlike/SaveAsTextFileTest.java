package rwoo.study.spark.javarddlike;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SaveAsTextFileTest {
    private JavaSparkContext sc;
    private FileSystem fs;
    private JavaRDD<Integer> rddA;
    private String pathStr;
    private Path path;

    @Before
    public void setUp() throws IOException {
        sc = new JavaSparkContext("local[*]", "JavaRDDLike.saveAsTextFile");
        fs = FileSystem.get(sc.hadoopConfiguration());
        pathStr = new File("./src/test/resources/SaveAsTextFile").getCanonicalPath();
        path = new Path(pathStr);
        if (fs.exists(path)) {
            fs.delete(path, true);
        }
        rddA = sc.parallelize(Arrays.asList(2, 1, 4), 2);
    }

    @After
    public void after() throws IOException {
        assertEquals(Arrays.asList(2, 1, 4), rddA.collect());
        customPrint(fs, path);
        sc.close();
    }

    @Test
    public void testSaveAsTextFile() {
        rddA.saveAsTextFile(pathStr);
    }

    private void customPrint(FileSystem fs, Path path) throws IOException {
        RemoteIterator<LocatedFileStatus> tmp = fs.listFiles(path, true);
        while (tmp.hasNext()) {
            System.out.println(tmp.next().getPath().toString());
        }
    }
}
