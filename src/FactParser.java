import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XmlParser
{
	private NodeList nodeList;

	@Override
	public void LoadXmlDocument(String fullpath) {
		 try {

			 	FileInputStream file = new FileInputStream(new File(fullpath));
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);

				doc.getDocumentElement().normalize();
				
				nodeList = doc.getElementsByTagName("Fact");
				
			    } catch (Exception e) {
			    	System.out.println("Error occured during initialization");
			    }
	}
    public FactRepository getFactRepository()
    {
        String filename = "src/knowledgebase.xml";
        String description = "";
        LoadXmlDocument(filename);
        FactRepository repository = new FactRepository();
        for(int i = 0; i<nodeList.getLength(); i++)
        {
        	Node node = nodeList.item(i);

            Node tempNode = ((Element) node).getElementsByTagName("Description").item(0);
            description = ((Element)tempNode).getAttribute("value");

            String factId = ((Element)node).getAttribute("id");

            Fact fact = new Fact(description);
            fact.setId(factId);

            repository.addFact(fact);
        }
        	return repository;
    }
}
