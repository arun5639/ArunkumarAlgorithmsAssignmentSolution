package com.Learning.BinarySearch;

//Array - Binary Search

public class BinarySearch {
	
	public boolean binarySearch(double item, double array []) {
	
		int first = 0;
		int last = array.length - 1;
		int middle = (first + last)/2;
		boolean isFound = false;
		
		while( first <= last )
	    {
	       if ( array[middle] < item )
	    	   first = middle + 1;
	       else if ( array[middle] == item ){
	    	   isFound = true;
	    	   break;
	       }
	       else {
	    	   last = middle - 1;
	       }
	       middle = (first + last)/2;
	    }
	 
		if (first > last)
			isFound=false;
		
		return isFound;
	}
}

