package com.assignment;

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
class ProcessActivePromotionsTest {

	/**
	 * @throws java.lang.Exception
	 */
	private ProcessActivePromotions processPro;
	@BeforeEach
	void setUp() throws Exception {
		ProcessProperties properties = new ProcessProperties();
		processPro =  new ProcessActivePromotions(properties);
	}

	@Test
	final void test() throws PropertyException, IOException {
		assertEquals(3, processPro.getActivePromotions("ActivePromotions.properties").size());
	}

}
