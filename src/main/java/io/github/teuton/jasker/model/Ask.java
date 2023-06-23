package io.github.teuton.jasker.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Ask {

	@XmlElement
	private String text;

	@XmlElement
	private String answer;

	@XmlElement(name = "step")
	private List<String> steps = new ArrayList<>();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getSteps() {
		return steps;
	}

	@Override
	public String toString() {
		return "Ask [text=" + text + ", answer=" + answer + ", steps=" + steps + "]";
	}

}
