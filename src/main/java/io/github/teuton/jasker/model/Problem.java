package io.github.teuton.jasker.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Problem extends MapItem {

	@XmlElement(name = "desc")
	private String description;

	@XmlElement
	private Cases cases;

	@XmlElement(name = "ask")
	private List<Ask> asks = new ArrayList<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Cases getCases() {
		return cases;
	}

	public List<Ask> getAsks() {
		return asks;
	}

	@Override
	public String toString() {
		return "Problem [description=" + description + ", cases=" + cases + ", asks=" + asks + "]";
	}

}
