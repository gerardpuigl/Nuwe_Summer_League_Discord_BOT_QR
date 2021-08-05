package io.nuwe.DiscordBotQR.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class Validator {
	public static void validateURL(String url) throws MalformedURLException {
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			throw new MalformedURLException("The input \"" + url + "\" isn't a valid url [should include https://]"); 
		}
	}
}
