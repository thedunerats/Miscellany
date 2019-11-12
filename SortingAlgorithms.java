package com.revature;

public class SortingAlgorithms {

    /* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
	// low = starting index
	// high = array.length() - 1; ending index
	// last element is the pivot every time
	// the sizes of the partitions vary depending on the array passed in
	 static int partition(int arr[], int low, int high) 
	 { 
	     int pivot = arr[high];  // set the pivot value
	     int i = (low-1); // index of smaller element 
	     for (int j=low; j<high; j++)  // iterate through entire array
	     { 
	         // If current element is smaller than the pivot 
	         if (arr[j] < pivot) 
	         { 
	             i++; // increments every time an entry smaller than the pivot is found
	             // also ensures that nothing left of the pivot gets moved during the iteration,
	             // since it only increments when it finds something smaller.
	
	             // swap arr[i] and arr[j] 
	             int temp = arr[i]; 
	             arr[i] = arr[j]; 
	             arr[j] = temp; 
	             // swaps the element with the previous element if its smaller than the pivot
	             // the smaller elements get moved to the left side of the array 
	         } 
	     } 
	
	     // swap arr[i+1] and arr[high] (or pivot) 
	     // ensures that the pivot goes to the correct place every time.
	     // everything smaller than the pivot will be on its left.
	     int temp = arr[i+1]; 
	     arr[i+1] = arr[high]; 
	     arr[high] = temp; 
	
	     return i+1; // compensates for the -1 done to the index when it was passed it.
	 } 
	
	
	 /* The main function that implements QuickSort() 
	   arr[] --> Array to be sorted, 
	   low  --> Starting index, 
	   high  --> Ending index */
	 //This partitions the array recursively.
	 static void QuickSort(int arr[], int low, int high) 
	 { 
	     if (low < high)  // stops when the array is sorted.
	     { 
	         /* pi is partitioning index, arr[pi] is  
	           now at right place */
	         int pi = partition(arr, low, high); 
	
	         // Recursively sort elements before 
	         // partition and after partition 
	         QuickSort(arr, low, pi-1);  // the size of the partitions change, depending on where the 
	         QuickSort(arr, pi+1, high);  //pivot is placed.  they will get smaller until the 
	         							// array is sorted.
	         
	         // The first one is the lower partition.
	         // tHe second one is the upper partition.
	         // In the first partition, the upper bound of the partition approaches 0.
	         // In the second partition, the lower bound of the partition approaches the uppermost index.
	     } 
	 } 
	
	 /* A utility function to print array of size n */
	 static void printArray(int arr[]) 
	 { 
	     int n = arr.length; 
	     for (int i=0; i<n; ++i) 
	         System.out.print(arr[i]+" "); 
	     System.out.println(); 
	 } 
	 
	public static int smallestMissingPositiveInt(int arr[]) {
			int missingNo = 0; //returns result
			int counter = 1; // used as a placeholder for counting
				
			int n = arr.length;
			QuickSort(arr,0,n-1);
			for (int i = 0; i < n; i++) {
				if (arr[i] > 0) { // only checking positive integers
					
					if (arr[i] != counter) { // first positive integer not in array
						missingNo = counter;  // output
						break; //kick out of the loop
					}
					counter++; // increments for every sequential positive integer found
				}
			}
			
			return missingNo;
			
		}
	 
	    // Driver program (may move this to another class)
	    public static void main(String args[]) 
	    { 
	        int arr[] = {10, 7, 8, 9, 1, 5, 2, 4}; 
	        int n = arr.length; 
	  
	        SortingAlgorithms.QuickSort(arr, 0, n-1); 
	        // NOTE TO SELF: You may as well make methods you don't want to change static.
	        // i.e. if you don't want to overload it. Makes everything simpler.
	  
	        System.out.println("sorted array"); 
	        printArray(arr); 
	        
	        int q = smallestMissingPositiveInt(arr);
	        System.out.println(q);
	        
	    } 
	 


	
}
