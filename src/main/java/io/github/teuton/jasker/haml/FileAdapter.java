package io.github.teuton.jasker.haml;

import java.io.File;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class FileAdapter extends XmlAdapter<String, File>{

	@Override
	public File unmarshal(String value) throws Exception {
		return new File(value);
	}

	@Override
	public String marshal(File file) throws Exception {
		return file.getPath().replaceAll("\\\\", "/");
	}

}
