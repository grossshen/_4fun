package tech.poorguy.pathUtil;

/**
 * @Date 9/28/2019 2:35 PM
 * @Mail 494939649@qq.com
 **/
public class PathUtil {
    public static String getClassPath() {
        return PathUtil.class.getClassLoader().getResource("").getPath();
    }

    public static void main(String[] args){
        String classPath = PathUtil.getClassPath();
        System.out.println(classPath);
    }
}
