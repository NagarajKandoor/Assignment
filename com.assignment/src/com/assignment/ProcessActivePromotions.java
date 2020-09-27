package com.assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.assignment.exceptions.PropertyException;
import com.assignment.model.Promotion;
import com.assignment.processproperty.ProcessProperties;

/**
 * @author Nagaraj
 *
 */
public class ProcessActivePromotions {

	private ProcessProperties properties;
	private List<Promotion> activePromotions;
	Pattern filename = Pattern.compile("(?<before>.*)\\sfor\\s(?<after>.*)");

	/**
	 * @param properties
	 */
	public ProcessActivePromotions(ProcessProperties properties) {
		this.properties = properties;
	}

	public List<Promotion> getActivePromotions(final String fileName) throws PropertyException, IOException {
		activePromotions = new ArrayList<Promotion>();
		HashMap<String, String> promotions = properties.getProperties(fileName);
		for (Map.Entry<String, String> promotion : promotions.entrySet()) {
			Matcher matcher = filename.matcher(promotion.getValue().trim());
			while (matcher.find()) {
				activePromotions.add(promotionFactory(matcher.group("before"),
						Integer.valueOf(matcher.group("after").trim()), Integer.valueOf(promotion.getKey().trim())));
			}
		}
		return activePromotions;
	}

	public static Promotion promotionFactory(String productName, int promotionValue, int quantity) {
		Promotion activePro = new Promotion(productName.replace("'s", ""), promotionValue, quantity);
		return activePro;
	}
}
