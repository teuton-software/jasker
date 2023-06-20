package io.github.teuton.jasker.model;

import java.io.File;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Code extends MapItem {

	@XmlElement
	private String type;
	
	@XmlElement
	private File path;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getPath() {
		return path;
	}

	public void setPath(File path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Code [type=" + type + ", path=" + path + "]";
	}

}
