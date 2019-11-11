package com.revature;

import java.util.Scanner;

public class CodingChallenges {

	public CodingChallenges() {
		// TODO Auto-generated constructor stub
	}
	
	protected static void LookAndSay(int n) {
		switch (n) {
			case 1:
				System.out.println("Term 1: 1");
				break;
			case 2:
				System.out.println("Term 2: 11");
				break;
		}
		// create the base case
		StringBuilder previousTerm = new StringBuilder("11"); 
		
		//create a temp to store values from the loop
		StringBuilder currentTerm = new StringBuilder("");
		
		int count = 1; //placeholder for instances of like value
		
		for(int i = 3; i <= n; i++) { // # of terms
			for (int j = 0; j < previousTerm.length() - 1; j++) { //size of previous term
				if (previousTerm.charAt(j + 1) != previousTerm.charAt(j)) { //if next term is different
					currentTerm.append(Integer.toString(count)); //instances of repeat character
					currentTerm.append(previousTerm.charAt(j)); // the number repeated
					count = 1; //reset for next set of repeating integers
					if (j + 1 == previousTerm.length() - 1) { //if the end of the term is reached
						currentTerm.append(Integer.toString(count)); //instances of repeat character
						currentTerm.append(previousTerm.charAt(j+1)); // the number repeated
					}
				} else {
					count++; //increment counter, instances of repeated integer
					if (j + 1 == previousTerm.length() - 1) { //if the previous term ends with repeated integers
						currentTerm.append(Integer.toString(count)); //instances of repeat character
						currentTerm.append(previousTerm.charAt(j)); // the number repeated
					}
				}
			}
			System.out.println("Term " + i + ": " + currentTerm);  //print the current term in sequence;
			System.out.println("Previous term: " + previousTerm); //testing
			
			int prevLength = previousTerm.length();
			int currLength = currentTerm.length();
			
			for (int k = 0; k < prevLength; k++) {
				previousTerm.deleteCharAt(0); //reset the current term for next iteration
			}	
			previousTerm.append(currentTerm); // necessary for each iteration
		
			for (int w = 0; w < currLength; w++) { //FIXME: loop not iterating all the way.
				currentTerm.deleteCharAt(0); //reset the current term for next iteration
			}	//NOTE: the length of the stringbuilder changes dynamically. had to account for this.
			count = 1; //reset for the next term in the sequence
		}
		
	}
	
	
	public static void isInAlphabeticalOrder(String...a) {
		//takes in variable arguments
		// nested for loop, input behaves like a 2-D array
		
		//MISSING: needs to add arbitrary alphabetical order
		// need to make the order completely modular.
		// may or may not do this.
		// CODING CHALLENGE: 11/11/2019
		
		System.out.println("In which alphabetical order?");
		Scanner scan = new Scanner(System.in);
		String order = scan.nextLine();
		
		boolean isFinished = false; //detects an early exit from inner loop
		
		//check order
		switch (order) {
			case "forward":
				for (String word: a) { //iterates through all the strings provided
					for (int j = 0; j < word.length() - 1; j++) { //iterates through characters in the string
						if (word.charAt(j) > word.charAt(j+1)) {
							isFinished = true;
							System.out.println(false);
							break; // exit the loop
						}
					}
					if (isFinished) { //checks for an early exit in the inner loop
						break;
					}
				}
				if (!isFinished) {
					System.out.println(true); //will only occur if an early exit does not occur
				}
				scan.close();
				break;  //close scanner and exit the loop
			
			case "reverse":
				for (String word: a) { //iterates through all the strings provided
					for (int j = 0; j < word.length() - 1; j++) { //iterates through characters in the string
						if (word.charAt(j) < word.charAt(j+1)) {
							isFinished = true;
							System.out.println(false);
							break; // exit the loop
						}
					}
					if (isFinished) { //checks for an early exit in the inner loop
						break;
					}
				}
				if (!isFinished) {
					System.out.println(true); //will only occur if an early exit does not occur
				}
				scan.close();
				break;
		}

	}

	
	public static void main(String[] args) {
		//	isInAlphabeticalOrder("vabcde","abcde","Your mamma");  //FIXME:  undo this later.
		//working for forward. reverse is working too.
			isInAlphabeticalOrder("zyx","srq");
	    } 


}
