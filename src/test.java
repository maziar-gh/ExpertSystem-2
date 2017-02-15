import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;

public class test {
	
	private static NodeList nodeList;
	
	public static void main(String [] args) {
	
	    try {

	    	File fXmlFile = new File("src/RuleSet.xml");
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);

	    	doc.getDocumentElement().normalize();

	    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	    	NodeList nList = doc.getElementsByTagName("Rule");

	    	System.out.println("----------------------------");

	    	for (int temp = 0; temp < nList.getLength(); temp++) {

	    		Node nNode = nList.item(temp);

	    		System.out.println("\nCurrent Element :" + nNode.getNodeName());

	    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	    			Element eElement = (Element) nNode;

	    			System.out.println("Rule id : " + eElement.getAttribute("id"));
	    			System.out.println("Question : " + eElement.getElementsByTagName("Question").item(0).getTextContent());
	    		}
	    	}
	        } catch (Exception e) {
	    	e.printStackTrace();
	        }
	      }
}
