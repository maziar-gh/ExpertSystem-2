import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;

public class test2 extends XmlParser {
	
	private NodeList nodeList;
	
	@Override
	public void LoadXmlDocument(String fullpath) {
		 try {

			 	FileInputStream file = new FileInputStream(new File(fullpath));
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);

				doc.getDocumentElement().normalize();
				
				nodeList = doc.getElementsByTagName("Rule");
				
			    } catch (Exception e) {
			    	System.out.println("Error occured during initialization");
			    }
	}
    public RuleRepository getRuleRepository()
    {
        String filename = "src/Rules.xml";
        LoadXmlDocument(filename);
        RuleRepository repository = new RuleRepository();
        for(int i = 0; i<nodeList.getLength(); i++)
        {
        	Node node = nodeList.item(i);

    		if (node.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) node;

    			System.out.println("Rule id : " + eElement.getAttribute("id"));
    			System.out.println("Question : " + eElement.getElementsByTagName("question").item(0).getTextContent());
    		}
        }
        return repository;
        }

}
