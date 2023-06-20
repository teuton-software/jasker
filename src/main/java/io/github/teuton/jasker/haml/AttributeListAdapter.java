package io.github.teuton.jasker.haml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class AttributeListAdapter extends XmlAdapter<String, List<String>>{

	@Override
	public List<String> unmarshal(String value) throws Exception {
		if (value == null || value.isEmpty()) return new ArrayList<>();
		return Arrays.asList(value.split(",")).stream().map(String::trim).collect(Collectors.toList());
	}

	@Override
	public String marshal(List<String> value) throws Exception {
		return StringUtils.join(value, ", ");
	}

}
