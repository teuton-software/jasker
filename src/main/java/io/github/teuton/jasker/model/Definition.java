package io.github.teuton.jasker.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Definition {

	@XmlAttribute
	private DefinitionType type = DefinitionType.text;

	@XmlValue
	private String value;

	public DefinitionType getType() {
		return type;
	}

	public void setType(DefinitionType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Definition [type=" + type + ", value=" + value + "]";
	}

}
