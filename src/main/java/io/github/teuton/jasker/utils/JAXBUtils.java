package io.github.teuton.jasker.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.helpers.XMLFilterImpl;

public class JAXBUtils {
	
	public static XMLFilter newNamespaceFilter(String namespace) {
		
		return new XMLFilterImpl() {
			 
//		    @Override
//		    public void endElement(String uri, String localName, String qName) throws SAXException {
//		        super.endElement(namespace, localName, qName);
//		    }
		 
		    @Override
		    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		        super.startElement(namespace, localName, qName, atts);
		    }
		 
		};
		
	}

}
