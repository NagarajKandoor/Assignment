package com.assignment.propertytest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.exceptions.PropertyException;
import com.assignment.processproperty.ProcessProperties;

/**
 * @author Nagaraj
 *
 */
class ProcessPropertiesTest {
	private ProcessProperties processProperties;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		processProperties = new ProcessProperties();
	}

	/**
	 * Test method for
	 * {@link com.assignment.processproperty.ProcessProperties#getProperties(java.lang.String)}.
	 * @throws IOException 
	 * @throws PropertyException 
	 */
	@Test
	final void testGetProperties() throws PropertyException, IOException {
		assertEquals(4,processProperties.getProperties("ProductNameValue.properties").size());
	}
}
