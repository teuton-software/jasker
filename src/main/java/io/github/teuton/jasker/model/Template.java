package io.github.teuton.jasker.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Template {
	
	@XmlTransient
	private Table parent;

	@XmlElement(name = "row")
	private List<Row> rows = new ArrayList<>();
	
	@XmlAnyAttribute
	private java.util.Map<String, String> attributes = new HashMap<>();

	public List<String> getFields() {
		return parent.getFields();
	}

	public List<Row> getRows() {
		return rows;
	}
	
	public int getColumnsCount() {
		return getFields().size();
	}
	
	public int getRowsCount() {
		return rows.size();
	}
	
	public java.util.Map<String, String> getAttributes() {
		return attributes;
	}
	
	public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
		this.parent = (Table) parent;
	}
	
	public String getValue(int row, int col) {
		if (row < 0 || row >= getRowsCount()) {
			throw new IllegalArgumentException("Invalid row " + row);
		}
		if (col < 0 || col >= getColumnsCount()) {
			throw new IllegalArgumentException("Invalid count " + col);
		}
		return rows.get(row).getCols().get(col);
	}

	@Override
	public String toString() {
		return "Template [rows=" + rows + ", attributes=" + attributes + "]";
	}
	
}
