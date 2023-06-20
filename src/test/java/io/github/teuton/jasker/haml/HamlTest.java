package io.github.teuton.jasker.haml;

import java.io.File;

import org.junit.Test;

public class HamlTest {

	private static final File RESOURCES = new File("src/test/resources").getAbsoluteFile();

	@Test
	public void testHamlToXhtml() throws Exception {
		File hamlFile = new File(RESOURCES, "demo1/input.haml");
		String xhtml = HAML.hamlToXhtml(hamlFile);
		System.out.println(xhtml);
	}

}