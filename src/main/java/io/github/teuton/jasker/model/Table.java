package io.github.teuton.jasker.model;

import java.util.ArrayList;
import java.util.List;

import io.github.teuton.jasker.haml.AttributeListAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table<T> extends MapItem {

	@XmlAttribute
	@XmlJavaTypeAdapter(value = AttributeListAdapter.class)	
	private List<String> fields = new ArrayList<>();
	
	@XmlAttribute
	private String sequence;
	
	@XmlElement(name = "row")
	private List<Row> rows = new ArrayList<>();

	public List<String> getFields() {
		return fields;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public List<Row> getRows() {
		return rows;
	}
	
	public int getColumnsCount() {
		return fields.size();
	}
	
	public int getRowsCount() {
		return rows.size();
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
		return "Table [fields=" + fields + ", sequence=" + sequence + ", rows=" + rows + "]";
	}

}
