package com.project.test;

import java.util.ArrayList;

/**
 * Word Information
 * This Object represents the word Occurrences and the exactly sentences of them.
 * @author alacomba
 *
 */
public class WordInfo {
	private String word;
	private ArrayList<Integer> sentenceIndexes;
	private int totalOccurrences;

	
	public WordInfo(String word) {
		super();
		this.word=word;
		sentenceIndexes = new ArrayList<Integer>();
	}	

	public void incrementOccurrence(int sentenceIndex) {
		this.sentenceIndexes.add(sentenceIndex);		
		totalOccurrences++;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<Integer> getSentenceIndexes() {
		return sentenceIndexes;
	}

	public void setSentenceIndexes(ArrayList<Integer> sentenceIndexes) {
		this.sentenceIndexes = sentenceIndexes;
	}

	public int getTotalOccurrences() {
		return totalOccurrences;
	}

	public void setTotalOccurrences(int totalOccurrences) {
		this.totalOccurrences = totalOccurrences;
	}

	@Override
	public String toString() {
		return "WordInfo [word=" + word + ", sentenceIndexes=" + sentenceIndexes + ", totalOccurrences="
				+ totalOccurrences + "]";
	}
}
