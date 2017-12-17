package com.project.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.util.StringUtils;
import org.tartarus.snowball.ext.porterStemmer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test Exercise
 * @author alacomba
 *
 */

public class Test {

	private static HashMap<String,WordInfo> resultMap = new HashMap<>();
	private static int sentenceIndex = 0;
	private static List<String> excludedWords = Arrays.asList("a","the","and","of","in","be","also","as");

	public static String entryText1="consign consigned consigning consignment consist consisted consistency consistent consistently consisting consists consolation consolations consolatory console consoled consoles consolidate consolidated consolidating"; 
	public static String entryText= "After a century of decline, tiger numbers are on the rise. At least 3,890 tigers remain in the wild, but much more work is needed to protect this species that’s still vulnerable to extinction. Demand for tiger parts in some Asian countries is resulting in poaching and trade that will empty forests of the last wild tigers.\n" + 
			"\n" + 
			"Three tiger subspecies—Bali, Javan, and Caspian—have already been wiped out. The South China tiger is on its way to extinction. All of the five other remaining subspecies are in danger of the same fate if we don’t act now. Together, we can save the tiger for future generations.\n" + 
			"\n" + 
			"Your donation will help WWF to protect and connect tiger habitats on a massive scale, support and increase antipoaching efforts, and clamp down on tiger trade.";
	public static void main(String[] args) {
		parseText(entryText);
		Map<String, WordInfo> treeMap = new TreeMap<String, WordInfo>(resultMap);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			WordsResult result = new WordsResult();
			result.setResults(treeMap.values());
			json = mapper.writeValueAsString(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(json);
	}


	public static void parseText(String text) {	
		String[] paragraphs = text.split("\n");
		for (String paragraph : paragraphs) {
			String[] sentences = paragraph.split("\\.");
			parseSentences(sentences);			
		}
	}

	/**
	 * Parse each sentence
	 * @param sentences
	 */
	private static void parseSentences(String[] sentences) {
		for (String sentence : sentences) {
			String[] words = sentence.split(" ");
			for (String word : words) {
				parseWord(word);					
			}
			sentenceIndex++;
		}
	}

	/**
	 * Parse a word, first we exclude if word is a not permited word, then we stem the word using Porter Stemmer. 
	 * @param word
	 */
	private static void parseWord(String word) {
		//There some words that we must exclude from the process
		word = removeSpecialCharacters(word);

		if(!excludedWords.contains(word)&&!StringUtils.isEmpty(word)) {

			porterStemmer porter = new porterStemmer();
			porter.setCurrent(word);
			porter.stem();
			String current = porter.getCurrent();

			if(!resultMap.containsKey(current)) {
				resultMap.put(current, new WordInfo(current));
			}
			resultMap.get(current).incrementOccurrence(sentenceIndex);				

		}		
	}

	private static String removeSpecialCharacters(String word) {
		return word.replaceAll("[^a-zA-Z0-9]+","");
	}

}
