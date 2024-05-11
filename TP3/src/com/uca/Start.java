package com.uca;

public class Start {

	//Start class
	public static void main(String[] args) {

		RomanNumber roman = new RomanNumber("IV");
		System.out.println(roman.getValue());
		System.out.println(roman.getRoman());

		RomanNumber number = new RomanNumber(14);
		System.out.println(number.getRoman());
		System.out.println(number.getValue());

		try {
			String romanStr = RomanConverter.getRomanFromNumber(2022);
			System.out.println("2022 en chiffres romains s'écrit : " + romanStr);

			int value = RomanConverter.getNumberFromRoman("MMXXII");
			System.out.println("MMXXII en entier : " + value);
		} catch (IllegalArgumentException e) {
			System.out.println("Erreur: " + e.getMessage());
		}
	}
}