package io.github.teuton.jasker.haml;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import io.github.teuton.jasker.model.Code;
import io.github.teuton.jasker.model.Concept;
import io.github.teuton.jasker.model.Map;
import io.github.teuton.jasker.model.Problem;

public class HamlTest {

	private static final File RESOURCES = new File("src/test/resources").getAbsoluteFile();

	@Test
	public void testHamlToXhtml() throws Exception {
		File hamlFile = new File(RESOURCES, "acdc.haml");
		assertThat(HAML.hamlToXhtml(hamlFile), containsString("<map context='music, band' lang='en' version='1'>"));
	}
	
	@Test
	public void testLoadHaml() throws Exception {
		File hamlFile = new File(RESOURCES, "acdc.haml");
		Map map = Map.loadFromHaml(hamlFile);
		assertEquals(7, map.getItems().size());
		assertEquals(2, map.getItems().stream().filter(item -> item instanceof Concept).count());
		assertEquals(3, map.getItems().stream().filter(item -> item instanceof Code).count());
		assertEquals(2, map.getItems().stream().filter(item -> item instanceof Problem).count());
	}

}