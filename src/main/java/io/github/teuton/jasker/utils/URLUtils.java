package io.github.teuton.jasker.utils;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLUtils {
	
	public static URL createURL(String url) {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			return null;
		}
	}
	
	public static boolean isValidURL(String url) {
	    try {
	        new URL(url).toURI();
	        return true;
	    } catch (MalformedURLException e) {
	        return false;
	    } catch (URISyntaxException e) {
	        return false;
	    }
	}

}
