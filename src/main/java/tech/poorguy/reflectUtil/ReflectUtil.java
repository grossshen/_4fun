package tech.poorguy.reflectUtil;

import org.w3c.dom.*;
import tech.poorguy.User;
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
        Document document = DOMUtil.parse("C:\\work\\tqhy\\_4fun\\src\\main\\java\\Bean.xml");
        NodeList nodeList = DOMUtil.selectNodeListByTag(document, "bean");
        Element element = (Element) nodeList.item(0);
        String className = element.getAttribute("class");
        User user = (User) initClassWithFullName(className);
        user.setNickName("max");
        System.out.println(user.getNickName());
    }
}
