package tech.poorguy.domUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


/**
 * @Date 9/28/2019 2:20 PM
 * @Mail 494939649@qq.com
 **/
public class DOMUtil {
    private static DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    public static Document parse(String filePath) {
        Document document = null;
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static NodeList selectNodeListByTag(Document document,String tagName) {
        Element rootElement = document.getDocumentElement();
        return rootElement.getElementsByTagName(tagName);
    }

    public static NodeList selectBeanNodeListFromBeansXml(String path) {
        Document document = parse(path);
        return selectNodeListByTag(document, "bean");
    }

    public static void main(String[] args) {
        DOMUtil parser = new DOMUtil();
        Document document = parser.parse("C:\\work\\tqhy\\_4fun\\src\\main\\java\\Bean.xml");
        Element rootElement = document.getDocumentElement();

        NodeList childNodes = rootElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            //node节点:1 为tag节点，3为text
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //element node
            }
            if (node.getNodeType() == Node.TEXT_NODE) {
                //text node
            }
        }

        NodeList nodeList = rootElement.getElementsByTagName("bean");
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String id = element.getAttribute("id");
                System.out.println(id);
                System.out.println(element.getTextContent());
            }
        }
    }
}
