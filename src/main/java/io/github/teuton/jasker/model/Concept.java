package io.github.teuton.jasker.model;

import java.util.ArrayList;
import java.util.List;

import io.github.teuton.jasker.haml.AttributeListAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Concept extends MapItem {

	@XmlElement(required = true)
	@XmlJavaTypeAdapter(value = AttributeListAdapter.class)
	private List<String> names = new ArrayList<>();
	
	@XmlElement
	@XmlJavaTypeAdapter(value = AttributeListAdapter.class)
	private List<String> tags = new ArrayList<>();
	
	@XmlElement(name = "def")
	private List<Definition> definitions = new ArrayList<>();
	
	@XmlElement(name = "table")
	private List<Table<String>> tables = new ArrayList<>();

	public List<String> getNames() {
		return names;
	}

	public List<String> getTags() {
		return tags;
	}

	public List<Definition> getDefinitions() {
		return definitions;
	}

	public List<Table<String>> getTables() {
		return tables;
	}

	@Override
	public String toString() {
		return "Concept [names=" + names + ", tags=" + tags + ", definitions=" + definitions + ", tables=" + tables + "]";
	}

}
