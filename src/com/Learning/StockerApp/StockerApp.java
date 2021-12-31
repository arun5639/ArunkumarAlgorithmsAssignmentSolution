package com.Learning.StockerApp;

import com.Learning.MergeAsc.*;
import com.Learning.MergeDsc.*;
import com.Learning.BinarySearch.*;
import java.util.Scanner;

public class StockerApp {
	
	static double shrPrice [];
	static boolean shrTrend [];	
	static int num=0;
	static MergeAsc msa = new MergeAsc();
	static MergeDsc msd = new MergeDsc();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		getInput(sc);	
		performOperations(sc);		
		sc.close();

	}
	
	public static void getInput(Scanner sc) {		
		
		System.out.println("Enter the No. of companies");
		num = sc.nextInt();
		
		shrPrice = new double[num];
		shrTrend = new boolean[num];
		
		for(int i=0; i<num; i++) {
			
			System.out.println("Enter the current stock price of Company - "+(i+1));
			shrPrice[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			shrTrend[i] = sc.nextBoolean();			
		}		
	}
	
	public static void performOperations(Scanner sc) {
		
		boolean isExit = false;
		int opt=0;
		
		while(!isExit) {
			
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("---------------------------------------------------------------------------");
			
			opt = sc.nextInt();
			
			switch(opt){
				case 1:
					msa.mergeSortAsc(shrPrice,0,num-1);
					System.out.println("Stock prices in ascending order are :");
					display(opt);
					break;
				case 2:
					msd.mergeSortDsc(shrPrice, 0, num-1);
					System.out.println("Stock prices in descending order are :");
					display(opt);
					break;
				case 3:
					System.out.print("Total no of companies whose stock price rose today : ");
					display(opt);
					break;
				case 4:
					System.out.print("Total no of companies whose stock price declined today : ");
					display(opt);
					break;
				case 5:
					msa.mergeSortAsc(shrPrice,0,num-1);
					System.out.println("Enter the key value");
					double searchItem = sc.nextDouble();
					BinarySearch bs = new BinarySearch();
					if(bs.binarySearch(searchItem, shrPrice) == true)
						System.out.println("Stock of value "+searchItem+" is present");
					else
						System.out.println("Value not found");
					break;
				case 0:
					isExit = true;
					System.out.println("Exited successfully");
					break;					
			}
		}		
	}

	public static void display(int opt) {		
		
		if (opt == 1 || opt == 2) {			
			for(double shrPriceVal : shrPrice) {
				System.out.print(shrPriceVal+" ");
			}		
			System.out.println();
		}
		
		if (opt == 3) {
			int total =0;
			for(boolean shrTrendVal : shrTrend) {
				if (shrTrendVal == true)
					total++;
			}	
			System.out.println(total);			
		}
		
		if (opt == 4) {
			int total =0;
			for(boolean shrTrendVal : shrTrend) {
				if (shrTrendVal == false)
					total++;
			}	
			System.out.println(total);			
		}		
	}
}
