package tech.poorguy.springLikeUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tech.poorguy.domUtil.DOMUtil;
import tech.poorguy.reflectUtil.ReflectUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Date 9/28/2019 3:24 PM
 * @Mail 494939649@qq.com
 **/
public class BeanContainer {
    public static Map<String,Object> beanMap=new HashMap<String, Object>();

    public static void loadBeans(String path) {
        NodeList beanNodeList = DOMUtil.selectBeanNodeListFromBeansXml(path);
        for (int i = 0; i < beanNodeList.getLength(); i++) {
            Element item = (Element) beanNodeList.item(i);
            beanMap.put(item.getAttribute("id"), ReflectUtil.initClassWithFullName(item.getAttribute("class")));
        }
    }

    public static Object getBean(String beanId) {
        return beanMap.get(beanId);
    }
    public static void main(String[] args){
        loadBeans("C:\\work\\tqhy\\_4fun\\src\\main\\java\\Bean.xml");
        System.out.println(getBean("userMax"));
        System.out.println(getBean("userPg"));
    }
}
