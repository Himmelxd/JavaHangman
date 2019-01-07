//Felix Beichler
package de.himmelxd.hangman;

import java.util.LinkedList;
import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		byte doomsdayClock = 7;													//Die Anzahl übriger Versuche
		String wordToFind;														//Eingegebenes Word oder Phrase zum Finden
		int wordLengthWithoutSpace = 0;											//Die Gesamtlänge ohne Bindestriche und Leerzeichen
		LinkedList<Character> charsToFind = new LinkedList<Character>();		//Liste mit den übrigen zu erratenden Buchstaben
		LinkedList<Character> guessedWrongChars = new LinkedList<Character>();	//Liste mit den falschen bereits gerratenden Buchstaben
		Scanner inputScanner = new Scanner(System.in);

		Graphics.clear(30);		//30 leere Zeilen

		System.out.println("Enter the word or phrase that should be guessed:");
		wordToFind = inputScanner.nextLine();

		while (!isWordAlphabetical(wordToFind)) {								//Überprüfen, ob alle Buchstaben erlaubte Buchstaben sind (z.B. != ä, ö , ü) und bis dem so ist erneut Fragen
			System.out.println("Please only use the english alphabet\nEnter the word or phrase that should be guessed:");
			wordToFind = inputScanner.nextLine();
		}

		Graphics.clear(30);

		for (int i = 0; wordToFind.length() > i; i++) {
			if (wordToFind.charAt(i) != ' ' && wordToFind.charAt(i) != '-') {
				wordLengthWithoutSpace++;
				if (!charsToFind.contains(wordToFind.charAt(i))) {
					charsToFind.add(Character.toLowerCase(wordToFind.charAt(i)));
				}
			}
		}

		System.out.println("Length: " + wordLengthWithoutSpace);

		while (charsToFind.size() > 0 && doomsdayClock > 0) {
			Graphics.drawHang(doomsdayClock);
			System.out.println("");
			System.out.println(Graphics.wordCurrently(charsToFind, wordToFind));
			System.out.println(guessedWrongChars);

			/* Question to User */
			Character guess = Character.toLowerCase(inputScanner.next().charAt(0));

			Graphics.clear(30);

			if (charsToFind.contains(guess)) {
				charsToFind.remove(guess);
				System.out.println("Correct!");
			} else {
				doomsdayClock -= 1;
				if (wordToFind.contains(guess.toString())) {
					System.out.println("Wrong! You already guessed '" + guess + "' correctly");
				} else {
					if (guessedWrongChars.contains(guess)) {
						System.out.println("Wrong! You already know that the Word does not contain '" + guess + "'");
					} else {
						guessedWrongChars.add(guess);
						System.out.println("Wrong! The Word does not contain '" + guess + "'");
					}
				}
			}
		}

		if (charsToFind.size() == 0) {
			System.out.println(Graphics.wordCurrently(charsToFind, wordToFind));
			Graphics.drawManWin();
			System.out.println("You made it");
			inputScanner.close();
		}
		if (doomsdayClock <= 0) {
			Graphics.drawHang(0);
			System.out.println("The word or phrase you had to find was: '" + wordToFind + "'\n" + charsToFind.size() + " character missing");
			inputScanner.close();
		}

	}

	private static boolean isWordAlphabetical(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!(Character.isAlphabetic(word.charAt(i)) || word.charAt(i) == ' ' || word.charAt(i) == '-')) {
				return false;
			}
		}
		return true;
	}

}
