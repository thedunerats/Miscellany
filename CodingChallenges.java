package com.revature;

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
	
	public int smallestMissingPositiveInt(int arr[]) {
		int missingNo;
		
		return missingNo;
		
	}
	
	public static void main(String[] args) {
		LookAndSay(6); //FIXME: not sure why this needs to be static.
	}

}
