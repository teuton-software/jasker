package io.github.teuton.jasker;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.github.teuton.jasker.ruby.Ruby;

import static io.github.teuton.jasker.utils.StringUtils.clearColorCodes;

public class Asker {
	
	private static final String BIN_PATH = "rubygems/bin/asker"; 
	private static final Pattern VERSION_PATTERN = Pattern.compile("asker version (.*).*");

	/**
	 * Executes "asker" command with specified arguments and using the specified working directory 
	 * @param workingDirectory Working directory
	 * @param args Arguments for asker
	 * @return Asker output
	 */
	private static String execute(File workingDirectory, String ... args) {
		return Ruby.run(BIN_PATH, new StringWriter(), workingDirectory, args).toString();
	}

	/**
	 * Executes "asker" command with specified arguments using "." as working directory
	 * @param args Arguments for asker command tool
	 * @return Asker output
	 */
	private static String execute(String ... args) {
		return Ruby.run(BIN_PATH, args);
	}
	
	/**
	 * Build output files from HAML/YAML/XML input file specifying output directory
	 * @param outputDir Output directory
	 * @param filePath HAML/YAML/XML file
	 * @return Asker output
	 * @throws Exception If something went wrong
	 */
	public static String file(File outputDir, File filePath) throws Exception {
		Writer errorWriter = new StringWriter();
		String output = Ruby.run(
				BIN_PATH,						// asker bin path 
				new StringWriter(), 			// output
				errorWriter, 					// error
				outputDir, 						// working directory
				"file", 						// asker command
				filePath.getAbsolutePath()		// directory (check command argument)
		).toString();
		output = clearColorCodes(output);
		String error = clearColorCodes(errorWriter.toString());
		if (error.isEmpty() && output.contains("[ERROR]")) {
			error = output;
		}
		if (!error.isEmpty()) {
			throw new Exception(error);
		}
		return output;
	}
	
	/**
	 * Build output files from HAML/YAML/XML input file, writing output in current directory (.)
	 * @param filePath HAML/YAML/XML file
	 * @return Asker output
	 * @throws Exception If something went wrong
	 */
	public static String file(File filePath) throws Exception {
		return file(new File("."), filePath);
	}
	
	/**
	 * Check HAML/YAML/XML input file syntax
	 * @param filePath HAML/YAML/XML file
	 * @return Asker error or null if syntax is ok! 
	 */
	public static String check(File filePath) {
		Writer errorWriter = new StringWriter();
		String output = Ruby.run(
				BIN_PATH,						// asker bin path 
				new StringWriter(), 			// output
				errorWriter, 					// error
				null, 							// working directory
				"check", 						// asker command
				filePath.getAbsolutePath()		// directory (check command argument)
		).toString();
		output = clearColorCodes(output);
		String error = clearColorCodes(errorWriter.toString());
		if (error.isEmpty() && !output.contains("Syntax OK!")) {
			error = output;
		}
		if (!error.isEmpty()) {
			return error;
		}
		return null;
	}

	/**
	 * Create default INI config file
	 * @param directory Destination directory for INI file
	 * @return Asker output
	 */
	public static String init(File directory) {
		return execute(directory, "init");
	}

	/**
	 * Create default INI config file in current directory (.)
	 * @return Asker output
	 */
	public static String init() {
		return execute("init");
	}

	/**
	 * Create Asker demo input files
	 * @param directory Destination directory
	 * @return Asker output
	 */
	public static String create(File directory) {
		return execute("new", directory.getAbsolutePath());
	}

	/**
	 * Gets asker command version
	 * @return Asker version
	 */
	public static String version() {
		String output = execute("version");
		Matcher m = VERSION_PATTERN.matcher(output.trim());
		return m.matches() ? m.group(1) : null;
	}
	
}
