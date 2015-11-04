package com.prefect.gameworld;

import java.util.Vector;

public class WordList {
	Vector<String> words;
	public WordList() {
		words = new Vector<String>(1000, 200);
	}

	public void addWord(String s) {
		boolean success = words.add(s);
	}

	public boolean listContains(String s) {
		return words.contains(s);
	}

	private String getRandom() {
		int num = (int)Math.round(Math.random() * words.size());
		num--;
		if (num < 0)
		    num = 0;
		return (String)words.get(num);
	}

	public String getRandWord() {
		String s = this.getRandom();
		char[] charArray;
		int i = 0;

		charArray = s.toCharArray();

		while (i < charArray.length) {
		    char a = charArray[i];
		    int num = (int)Math.round(Math.random() * charArray.length);
		    num --;
		    if (num < 0)
			num = 1;
		    if (num != i) {
			charArray[i] = charArray[num];
			charArray[num] = a;
			i++;
		    }
		}
		
		s = new String(charArray);
		return s;
	}

	public String getLetterString() {
		String s = "";
		char[] charArray;
		int i = 0;

		while (s.length() < 20)  {
		    s.concat(this.getRandom());
		}
		charArray = s.toCharArray();
		
		while (i < charArray.length) {
		    char a = charArray[i];
		    int num = (int)Math.round(Math.random() * charArray.length);
		    if (num != i) {
		    	charArray[i] = charArray[num];
		    	charArray[num] = a;
		    	i++;
		    }
		}

		s = new String(charArray);
		return s;
	}



		

}
