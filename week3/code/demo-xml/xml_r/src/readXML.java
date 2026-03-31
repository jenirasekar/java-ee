import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.List;

public class readXML {
    public static void main(String[] args) throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("C:\\important\\汇报\\台州学院\\JAVAEE\\code\\demo-xml\\xml_r\\resource\\students.xml"));
        Element rootElement = document.getRootElement();
        List<Element> sonElementList = rootElement.elements("student");

        for (Element sonElement :sonElementList){
            String name = sonElement.elementText("name");
            String age = sonElement.elementText("age");
            System.out.println("name:" + name + ", age:" + age);
        }
    }
}
