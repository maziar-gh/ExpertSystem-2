import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
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
				
				nodeList = doc.getElementsByTagName("Rule");
				
			    } catch (Exception e) {
			    	System.out.println("Error occured during initialization");
			    }
	}


}
