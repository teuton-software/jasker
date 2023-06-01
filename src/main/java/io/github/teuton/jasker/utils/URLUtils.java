package io.github.teuton.jasker.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class URLUtils {
	
	public static URL newUrl(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			return null;
		}
	}

}
