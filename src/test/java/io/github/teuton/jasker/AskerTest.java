package io.github.teuton.jasker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class AskerTest {

	private static final File RESOURCES = new File("src/test/resources").getAbsoluteFile();
	private static final String VERSION = ResourceBundle.getBundle("jasker").getString("asker.version");

//	@Test
//	public void testVersion() {
//		assertEquals(VERSION, Asker.version());
//	}

	@Test
	public void testFileSuccess() throws Exception {
		File tempDir = new File(System.getProperty("java.io.tmpdir"));
		File outputDir = new File(tempDir, "output");
		File inputFile = new File(RESOURCES, "acdc.haml");
		Asker.file(tempDir, inputFile);
		assertTrue(outputDir.exists());
		assertTrue(new File(outputDir, "acdc.yaml").exists());
		assertTrue(new File(outputDir, "acdc-doc.txt").exists());
		assertTrue(new File(outputDir, "acdc-gift.txt").exists());
		assertTrue(new File(outputDir, "acdc-log.txt").exists());
		assertTrue(new File(outputDir, "acdc-moodle.xml").exists());
		System.out.println(outputDir);
//		Thread.sleep(2000L); // waits 2 secs till files are unlocked by asker
//		FileUtils.deleteDirectory(outputDir);
	}
	
//	@Test(expected = Exception.class)	
//	public void testFileNotExist() throws Exception {
//		File inputFile = new File("not-exist.haml");
//		Asker.file(inputFile);
//	}
//	
//	@Test(expected = Exception.class)	
//	public void testFileBadInput() throws Exception {
//		File inputFile = new File(RESOURCES, "error/bad.haml");
//		Asker.file(inputFile);
//	}
//
//	@Test
//	public void testCheckSuccess() {
//		File inputFile = new File(RESOURCES, "acdc.haml");
//		assertNull(Asker.check(inputFile));
//	}
//
//	@Test
//	public void testCheckFail() {
//		File inputFile = new File(RESOURCES, "error/bad.haml");
//		assertNotNull(Asker.check(inputFile));
//	}
//
//	@Test
//	public void testInit() throws Exception {
//		File tempDir = new File(System.getProperty("java.io.tmpdir"));
//		File iniFile = new File(tempDir, "asker.ini");
//		Asker.init(tempDir);
//		assertTrue(iniFile.exists());
//		iniFile.delete();
//	}
//	
//	@Test
//	public void testCreate() throws Exception {
//		File tempDir = new File(System.getProperty("java.io.tmpdir"));
//		File testDir = new File(tempDir, "test");		
//		File hamlFile = new File(testDir, "example-concept.haml");		
//		Asker.create(testDir);
//		assertTrue(hamlFile.exists());
//		FileUtils.deleteDirectory(testDir);
//	}

}