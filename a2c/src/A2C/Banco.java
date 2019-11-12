package A2C;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Node;


public class Banco {

	public String local_usuarios = "users.xml";
	public String local_esquecimentos = "forgets.xml";
	public String local_verificador = "verifications.xml";

	public void iniciar() throws ParserConfigurationException, TransformerException {
		
		

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        // root element
        Element root = document.createElement("users");
        document.appendChild(root);
		
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(local_usuarios));
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
        
	}
	
	public void usuario_criar(String nome ) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		File fXmlFile = new File(local_usuarios);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
	 
		doc.getDocumentElement().normalize();
	 
		  Element n = doc.createElement("Usuario");

	        //set id attribute
	        n.setAttribute("id", "0");

	   
	        n.appendChild(elemento(doc, n, "nome", nome));

	   
	        
		
		 DOMSource domSource = new DOMSource(doc);
	        StreamResult streamResult = new StreamResult(new File(local_usuarios));
	        
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        transformer.transform(domSource, streamResult);
	}
	
	private static Node elemento(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
	

}
