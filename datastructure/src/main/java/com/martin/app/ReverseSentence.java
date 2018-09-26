package com.martin.app;

public class ReverseSentence {

	public static String reverseWords2(String sentence) {
		StringBuilder sb = new StringBuilder(sentence.length() + 1);
		String[] words = sentence.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]).append(' ');
		}
		sb.setLength(sb.length() - 1);  // Strip trailing space
		return sb.toString();
	}

	public static void main(String[] args)
	{

		System.out.println(reverseWords2("This is fucking good day"));
	}

}
