package tech.poorguy.reflectUtil;

import org.w3c.dom.*;
import tech.poorguy.bean.User;
import tech.poorguy.domUtil.DOMUtil;

/**
 * @Date 9/28/2019 2:59 PM
 * @Mail 494939649@qq.com
 **/
public class ReflectUtil {
    public static String getClassFullName(Class clazz) {
        return clazz.getName();
    }

    public static Object initClassWithFullName(String fullName) {
        try {
            return Class.forName(fullName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        String name = ReflectUtil.class.getName();
        String packageName = ReflectUtil.class.getPackage().getName();
        System.out.println(name);
        System.out.println(packageName);
    }
}
