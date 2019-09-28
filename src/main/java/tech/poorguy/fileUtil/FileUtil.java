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
}
