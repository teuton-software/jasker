package io.github.teuton.jasker.haml;

import java.io.File;

import io.github.teuton.jasker.ruby.Ruby;

public class HAML {
	
	private static final String BIN_PATH = "rubygems/bin/haml";
	
	/**
	 * Executes "haml" command with specified arguments using "." as working directory
	 * @param args Arguments for haml command tool
	 * @return HAML output
	 */
	private static String execute(String ... args) {
		return Ruby.run(BIN_PATH, args);
	}
	
	/**
	 * Converts HAML into XHTML
	 * @param input HAML file
	 * @return XHTML string
	 */
	public static String hamlToXhtml(File input) {
		return execute("--format", "xhtml", input.getAbsolutePath());
	}

}