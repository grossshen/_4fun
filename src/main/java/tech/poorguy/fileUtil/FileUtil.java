package tech.poorguy.fileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 9/28/2019 4:37 PM
 * @Mail 494939649@qq.com
 **/
public class FileUtil {
    public static List<String> getClassNameByDir(String dirPath) throws Exception {
        File file = new File(dirPath);
        assert file.isDirectory();
        File[] files = file.listFiles();
        assert files != null;
        return Arrays.stream(files).filter(File::isFile).map(File::getPath).collect(Collectors.toList());
    }
    public static List<String> getRelativeClassNameByDir(String dirPath) throws Exception {
        File file = new File(dirPath);
        assert file.isDirectory();
        File[] files = file.listFiles();
        assert files != null;
        return Arrays.stream(files).filter(File::isFile).map(x-> getRelativePathForClassLoader(x.getAbsolutePath())).collect(Collectors.toList());
    }

    public static String getRelativePathByAbsolutePath(String basePath, String path) {
        return new File(basePath).toURI().relativize(new File(path).toURI()).getPath();
    }
    public static String getRelativePathForClassLoader(String path) {
        String basePath=FileUtil.class.getClassLoader().getResource("").getPath();
        return new File(basePath).toURI().relativize(new File(path).toURI()).getPath().
                replaceAll("/","\\.").
                replaceAll("\\\\","\\").
                replace(".class","");
    }


}
