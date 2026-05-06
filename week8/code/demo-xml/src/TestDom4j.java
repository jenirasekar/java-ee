import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.List;

public class TestDom4j {

   @Test
   public void testRead() throws Exception{
       // 读取配置文件
       SAXReader saxReader = new SAXReader();

       InputStream resourceAsStream =TestDom4j.class.getClassLoader().getResourceAsStream("jdbc.xml");
       Document document = saxReader.read(resourceAsStream);

       Element rootElement = document.getRootElement();
       System.out.println(rootElement.getName());

       List<Element> elements = rootElement.elements();
       for (Element element :elements){
           System.out.println(element.getName());
           Attribute idAttribute = element.attribute("id");
           System.out.println(idAttribute.getName()+"="+idAttribute.getValue());
           List<Element> eles = element.elements();
           for (Element ele :eles){
               System.out.println(ele.getName()+":"+ele.getText());
           }
       }






    }
}
