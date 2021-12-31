package com.Learning.MergeDsc;

//Merge Sort - Descending Order

public class MergeDsc {
	
	public void mergeSortDsc(double array[], int begin, int end)
	{
	    if (begin >= end)
	        return; 
	  
	    int mid = begin + (end - begin) / 2;
	    mergeSortDsc(array, begin, mid);
	    mergeSortDsc(array, mid + 1, end);
	    mergeDsc(array, begin, mid, end);
	}
	
	void mergeDsc(double array[], int left, int mid, int right)
	{
	    int arr1Size = mid - left + 1;
	    int arr2Size = right - mid;
	  
	    
	    double [] arr1 = new double[arr1Size];
	    double [] arr2 = new double[arr2Size];
	  
	  
	    for (int i=0; i<arr1Size; i++)
	        arr1[i] = array[left + i];
	    for (int j=0; j<arr2Size; j++)
	        arr2[j] = array[mid + 1 + j];
	  
	    int arr1Index = 0, arr2Index = 0, arr3Index = left;
	  
	    while (arr1Index < arr1Size && arr2Index < arr2Size) {
	        if (arr1[arr1Index] >= arr2[arr2Index]) {
	            array[arr3Index] = arr1[arr1Index];
	            arr1Index++;
	        }
	        else {
	            array[arr3Index] = arr2[arr2Index];
	            arr2Index++;
	        }
	        arr3Index++;
	    }
	    
	    
	    while (arr1Index < arr1Size) {
	        array[arr3Index] = arr1[arr1Index];
	        arr1Index++;
	        arr3Index++;
	    }
	   
	    
	    while (arr2Index < arr2Size) {
	        array[arr3Index] = arr2[arr2Index];
	        arr2Index++;
	        arr3Index++;
	    }
	}
}
