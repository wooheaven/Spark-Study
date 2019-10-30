package rwoo.study.spark.util;

import java.io.File;

public class FileUtil {
    public static void deleteDirectory(File file) {
        File[] subFiles = file.listFiles();
        if(null != subFiles) {
            for (File subfile : subFiles) {
                deleteDirectory(subfile);
            }
        }
        file.delete();
    }
}
