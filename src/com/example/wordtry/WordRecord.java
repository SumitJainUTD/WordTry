package com.example.wordtry;

public class WordRecord {
	
	private String word;
	private String meaning;
	private String sentence;
	
	public WordRecord (String word, String meaning, String sentence ){
		this.word = word;
		this.meaning = meaning;
		this.sentence = sentence;
	}
	
	public String getWord(){ return word;}
	public String getMeaning(){ return meaning;}
	public String getSentence(){ return sentence;}
	
	public void setWord(String word){ this.word = word;}
	public void setMeaning(String meaning){ this.meaning = meaning;}
	public void setSentence(String sentence){ this.sentence = sentence;}
	
	

}
