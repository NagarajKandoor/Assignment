package com.assignment.processproperty;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.assignment.exceptions.PropertyException;

/**
 * @author Nagaraj
 *
 */
public class ProcessProperties {

	private HashMap<String, String> properties;

	public HashMap<String, String> getProperties(String fileName) throws PropertyException, IOException {
		properties = new HashMap<String, String>();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
			Properties prop = new Properties();
			if (input == null) {
				new PropertyException("Unable to locate file: " + fileName);
			}
			prop.load(input);
			for (final String name : prop.stringPropertyNames()) {
				properties.put(name, prop.getProperty(name));
			}
		}
		return properties;
	}
}
