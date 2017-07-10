package bsptraining.xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author fan
 */
public class ParseXml {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
// parse an XML document into a DOM tree
      DocumentBuilder parser = null;
      try {
         parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      } catch (ParserConfigurationException ex) {
         Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
      }
      Document document = null;
      try {
         document = parser.parse(new File("D:\\NetBeans\\Training\\java-sources\\BspApps\\src\\bsptraining\\xml\\test.xml"));
      } catch (SAXException ex) {
         Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
      }

      // create a SchemaFactory capable of understanding WXS schemas
      SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

      // load a WXS schema, represented by a Schema instance
      Source schemaFile = new StreamSource(new File("D:\\NetBeans\\Training\\java-sources\\BspApps\\src\\bsptraining\\xml\\test.xsd"));
      Schema schema = null;
      try {
         schema = factory.newSchema(schemaFile);
      } catch (SAXException ex) {
         Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
      }

      // create a Validator instance, which can be used to validate an instance document
      Validator validator = schema.newValidator();

      // validate the DOM tree
      try {
         try {
            validator.validate(new DOMSource(document));
         } catch (IOException ex) {
            Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, null, ex);
            return;
         }
      } catch (SAXException e) {
         Logger.getLogger(ParseXml.class.getName()).log(Level.SEVERE, "instance document is invalid!");
         return;
      }
      Logger.getLogger(ParseXml.class.getName()).log(Level.INFO, "instance document is valid!");
   }

}
