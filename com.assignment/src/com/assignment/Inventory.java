package com.assignment;

import java.io.IOException;
import java.util.HashMap;

import com.assignment.exceptions.PropertyException;
import com.assignment.processproperty.ProcessProperties;

/**
 * @author Nagaraj
 *
 */
public class Inventory {

	private ProcessProperties processProperties;

	/**
	 * @param processProperties
	 */
	public Inventory(ProcessProperties processProperties) {
		super();
		this.processProperties = processProperties;
	}

	public HashMap<String, String> getInventory(final String fileName) throws PropertyException, IOException {
		return processProperties.getProperties(fileName);
	}
}
