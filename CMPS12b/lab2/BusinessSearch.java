import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import static java.lang.System.*;

class BusinessSearch{
	
	public static void main(String[] args) throws IOException{
	
	if (args.length>0){
		if (isFile(args[0])==true){
	
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		String N  = in.readLine();
		int n = Integer.parseInt(N);
		String[] businesses = new String[n];

		while(true){		

		for (int i=0; i<businesses.length;i++){

				String name = in.readLine();
				if(name ==null) break;
				businesses[i]=name;
			
		}
		break;
		} 
		in.close();
		

		mergeSort(businesses);	
		
	
		Scanner sc = new Scanner(System.in);
		String companySearch;
		String end = new String(" ");
		String[] result = new String[0];
		String wrong = new String("null");
		int queries=0;
		int notFound=0;

		while(sc.hasNextLine()){	
		companySearch = sc.nextLine();		
		
		if(companySearch.equals(end)){
		System.out.println(queries + " total queries, " + notFound + " not found");
		System.exit(0);	
		}
		try{
				
		
		result = (binarySearch(businesses,0,businesses.length,companySearch));	
		String[] results = new String[result.length];
		for(int i = 0; i < result.length; i++){
			results[i]=result[i];
		}	
		
		
		if(results[1].equals(wrong)){	
		System.out.println(results[0]);
		queries++;
		} else {
		System.out.println(results[1]);
		notFound++;
		}
		 
		
		}  catch (ArrayIndexOutOfBoundsException e){
				System.out.println("NOT FOUND");
				notFound++;		
		}
		
	
	
	}
	}
} else {
	printHelp();
}
}
	
	public static void mergeSort(String[] companies){
		if (companies.length>=2) {
			String[] left = new String[companies.length / 2];
			String[] right = new String[companies.length-companies.length/2];
			
			for (int i = 0;i < left.length;i++){
				left[i] = companies[i];
			}
			
			for (int i = 0; i < right.length;i++){
				right[i] = companies[i+companies.length/2];
			}
		
			mergeSort(left);
			mergeSort(right);
			merge(companies,left,right);
		}
	}
// http://stackoverflow.com/questions/20795158/sorting-names-using-merge-sort Ashish Aggarwal. MergeSort AND merge functions. merge -> ignoring case sentivity, takes string array and splits it into two and rearranges elements from lowest to highest. mergeSort ->takes merge results and places them into new array where it it is arranged from lowest to highest.
// 
	public static void merge(String[] companies, String[] left, String[] right){
		int a = 0;
		int b = 0;
		
		for (int i=0; i < companies.length; i++)
			if (b >= right.length || (a <left.length && left[a].compareToIgnoreCase(right[b])<0)){
				companies[i] = left[a];
				a++;
			} else {
				companies[i] = right[b];
				b++;
			}
	}
	
	public static String[] binarySearch(String[] array, int lowerBound, int upperBound, String key){
		int position;
		String[] done = new String[array.length];
		String next = new String(" ");	
		String[] compInfo=new String[2];
		String boom;
		int temp = upperBound;
	
		for(int i=0; i<array.length;i++){
				String arrayInfo = array[i];
				String[] splitInfo = arrayInfo.split(",");
				done[i] = splitInfo[0];
		
		}
	 
		position = (lowerBound + upperBound)/2;	
		
		while ((done[position]!=key) && (lowerBound<=upperBound)){
			if (done[position].compareTo(key)>0){
				upperBound = position -1;
			} else {
				lowerBound = position + 1;
			}
			position = (lowerBound + upperBound)/2;
		} 
		
		
		if (done[position].equals(key)){
			
			String finish = array[position];
			compInfo[0] = new String(finish.substring(finish.length()-13,finish.length()));
			compInfo[1]= new String("null");
		} else {
			compInfo[0] = new String("null");
			compInfo[1] = new String("NOT FOUND");
		}
	
		
			return compInfo;
	
}
// http://www.coderanch.com/t/558079/java/java/Binary-search-sorted-array-strings Luke Stamper w/ John Jai. Binary Search with my own variations. takes String key from user input and centers it in the middle of a sorted array. if the key doesn't match the position, searches if the key is higher or lower. If higher, makes position the key position -1. If lower, vice versa. Keeps loop until key matches position unless key isn't found, prints NOT FOUND.
//
	public static boolean isFile(String s){
		String x=s;
		return true;
	}	
	
	static void printHelp(){
		System.out.println("Usage: BusinessSearch businessDB");
		System.exit(0);
	}

	
}
