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
	
	protected static void nthSmallestInteger(int[] arr) {
		
	}
	
	
	public static void isInAlphabeticalOrder(String...a) {
		//takes in variable arguments
		// nested for loop, input behaves like a 2-D array
		
		//MISSING: needs to add arbitrary alphabetical order
		// MISSING: needs to check word list to see if words are ordered.
		// need to make the order completely modular.
		// may or may not do this.
		// CODING CHALLENGE: 11/11/2019
		
		System.out.println("In which alphabetical order?");
		Scanner scan = new Scanner(System.in);
		String order = scan.nextLine();
		
		boolean isFinished = false; //detects an early exit from inner loop
		
		// FIXME: compare characters in same position, but in subsequent strings.
		// may input strings with different lengths.
		// It will most likely throw an out of index exception, need to catch it / handle it
		// or make a custom exception
		// will probably need to check for a null value early.
		// might apply this fix by changing the outer loop to a regular loop, since it will only 
		// iterate length() - 1 times.
		
		System.out.println(a.length);
		
		//check order
		switch (order) {
			case "forward":			// the length method in the next line is for an array.
				for (int i = 0; i < a.length -1; i++) { //iterates through all the string pairs provided
					for (int j = 0; j < a[i].length(); j++) { //iterates through characters in the current string
						// if the 2 strings differ in length
						// i.e. if the next string is shorter than the current one
						// might throw an exception
						// NOTE: continue moves to the next iteration of a loop.
						
						// the inner loop breaks if it doesn't find anything out of order.
						// it should only iterate through the entire string if the 
						// characters are identical.
						
						//FIXME: hitting a[2] when it should not be happening.
						if (a[i].charAt(j) < a[i + 1].charAt(j)) {
							break; // in order; moves on to next pair of strings
						}
	
						if (a[i].charAt(j) > a[i + 1].charAt(j)) { // out of order
							isFinished = true;
							System.out.println(false);
							break; // exit the loop
						}
						
						if (j + 1 == a[i+1].length()) { // check for the end of next string
							// to avoid an out of bounds exception
							break; // move to the next iteration of the outer loop.
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
				for (int i = 0; i < a.length -1; i++) { //iterates through all the string pairs provided
					for (int j = 0; j < a[i].length(); j++) { //iterates through characters in the current string
						// if the 2 strings differ in length
						// i.e. if the next string is shorter than the current one
						// might throw an exception
						// NOTE: continue moves to the next iteration of a loop.
						
						// the inner breaks if it doesn't find anything out of order.
						// it should only iterate through the entire string if the 
						// characters are identical.
						
						//FIXME: hitting a[2] when it should not be happening.
						if (a[i].charAt(j) > a[i + 1].charAt(j)) {
							break; // in order; moves on to next pair of strings
						}
	
						if (a[i].charAt(j) < a[i + 1].charAt(j)) { // out of order
							isFinished = true;
							System.out.println(false);
							break; // exit the loop
						}
						
						if (j + 1 == a[i+1].length()) { // check for the end of next string
							// to avoid an out of bounds exception
							break; // move to the next iteration of the outer loop.
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
			
			default:
				System.out.println("That's not a good input.");
				break;
		}

	}

	
	public static void main(String[] args) {
		//	isInAlphabeticalOrder("vabcde","abcde","Your mamma");  //FIXME:  undo this later.
		//working for forward. reverse is working too.
			isInAlphabeticalOrder("alpha", "yankee");
			System.out.println('A' < 'a'); // i think this compares ASCII values. this returns true.
	    } 


}