package io.github.teuton.jasker.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlMixed;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Row {

	@XmlElement(name = "col")
	private List<String> cols = new ArrayList<>();
	
	@XmlMixed
	private List<String> values = new ArrayList<>();

	public List<String> getCols() {
		return cols;
	}
	
	public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
		// process mixed text (converts text into a "col")
		if (cols.isEmpty() && !values.isEmpty()) {
			values.stream()
				.map(String::trim)
				.filter(s -> !s.isEmpty())
				.forEach(cols::add);
		}
		values.clear();
	}

	@Override
	public String toString() {
		return "Row [cols=" + getCols() + "]";
	}

}
