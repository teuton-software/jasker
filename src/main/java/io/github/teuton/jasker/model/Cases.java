package io.github.teuton.jasker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Cases {

	@XmlAttribute(name = "sep")
	private String separator;

	@XmlAttribute(name = "varnames")
	private String value;
	
	@XmlTransient
	private List<String> varnames = new ArrayList<>();

	@XmlElement(name = "case")
	private List<String> cases = new ArrayList<>();

	public List<String> getCases() {
		return cases;
	}
	
	public void beforeMarshal(Marshaller marshaller) {
		String separator = (this.separator != null && !this.separator.isEmpty()) ? this.separator : ",";
		value = StringUtils.join(varnames, separator + " ");
	}

	public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
		String separator = (this.separator != null && !this.separator.isEmpty()) ? this.separator : ",";
		varnames = Arrays.asList(value.split(separator))
			.stream()
			.map(varname -> varname.trim())
			.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Cases [separator=" + separator + ", varnames=" + varnames + ", cases=" + cases + "]";
	}

}
