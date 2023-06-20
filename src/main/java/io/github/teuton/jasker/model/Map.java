package io.github.teuton.jasker.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.io.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

import io.github.teuton.jasker.haml.AttributeListAdapter;
import io.github.teuton.jasker.haml.HAML;
import io.github.teuton.jasker.utils.JAXBUtils;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.UnmarshallerHandler;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchema;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(value = { Concept.class, Code.class, Problem.class })
public class Map {
	
	public static final String NAMESPACE;
	public static final String SCHEMA_LOCATION;
	
	static {
		Package p = Map.class.getPackage();
		XmlSchema xs = p.getAnnotation(XmlSchema.class);
		NAMESPACE = xs.namespace();
		SCHEMA_LOCATION = xs.location().split(" ")[1];
	}

	@XmlAttribute
	private String lang;
	
	@XmlAttribute
	@XmlJavaTypeAdapter(value = AttributeListAdapter.class)
	private List<String> context = new ArrayList<>();
	
	@XmlAttribute
	private String version;	

	@XmlElementRef
	private List<MapItem> items = new ArrayList<>();

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public List<String> getContext() {
		return context;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<MapItem> getItems() {
		return items;
	}
	
	@Override
	public String toString() {
		return "Map [lang=" + lang + ", context=" + context + ", version=" + version + ", items=" + items + "]";
	}

	public void saveToXhtml(File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(this.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, NAMESPACE + " " + SCHEMA_LOCATION);
		marshaller.marshal(this, file);
	}
	
	private static Map loadFromXhtml(Reader reader) throws Exception {
		
        // Create the JAXBContext
        JAXBContext jc = JAXBContext.newInstance(Map.class);
  
        // Set the parent XMLReader on the XMLFilter
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();

        // Set UnmarshallerHandler as ContentHandler on XMLFilter
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setEventHandler(e -> false);

        UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();

        // Create xml input source from reader
        InputSource is = new InputSource(reader);
        
        // Create the XMLFilter
        XMLFilter filter = JAXBUtils.newNamespaceFilter(NAMESPACE);        
        filter.setParent(xr); 
        filter.setContentHandler(unmarshallerHandler);
    	filter.parse(is);
 
		return (Map) unmarshallerHandler.getResult();		
	}
	
	public static Map loadFromXhtml(String xml) throws Exception {
		return loadFromXhtml(new StringReader(xml));		
	}
	
	public static Map loadFromXhtml(File xmlFile) throws Exception {
		return loadFromXhtml(new FileReader(xmlFile, StandardCharsets.UTF_8));		
	}
	
	public static Map loadFromHaml(String haml) throws Exception {
		File hamlFile = Files.createTempFile("jasker", "haml").toFile();
		FileUtils.write(hamlFile, haml, StandardCharsets.UTF_8);
		Map map = loadFromHaml(hamlFile);
		hamlFile.delete();
		return map;
	}

	public static Map loadFromHaml(File hamlFile) throws Exception {
		if (!hamlFile.exists()) {
			throw new FileNotFoundException(hamlFile.getAbsolutePath());
		}
		return loadFromXhtml(HAML.hamlToXhtml(hamlFile));		
	}
	
	public static void main(String[] args) throws Exception {
		
//		Concept c1 = new Concept();
//		c1.getNames().add("AC/DC");
//		
//		Map saveMap = new Map();
//		saveMap.setLang("es");
//		saveMap.setVersion("1.0");
//		saveMap.getContext().add("rock");
//		saveMap.getContext().add("band");
//		saveMap.getItems().add(c1);
//		
//		saveMap.save(new File("test.xml"));

//		File hamlFile = new File("src/test/resources/input.haml");
//		Map map = loadFromHaml(hamlFile);
//		System.out.println(map);

		File xmlFile = new File("src/test/resources/input.xml");
		Map map = loadFromXhtml(xmlFile);
		System.out.println(map);		
		map.saveToXhtml(new File("output.xml"));

//		File badHamlFile = new File("src/test/resources/bad.haml");
//		System.out.println(loadFromHaml(badHamlFile));
//		
//		File xhtmlFile = new File("sample.xml");
//		System.out.println(loadFromXhtml(xhtmlFile));
		
		
	}

}
