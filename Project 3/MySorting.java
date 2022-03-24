/*
* ID: 6388014
* FullName: Waris Damkham
* Section: 1
* */
import java.util.Arrays;
import java.util.Comparator;

public class MySorting {

    //TODO: You are free to write any helper function
	private static <T> void qswap(T[] array, int index1, int index2) // Swap function for Quicksort
	{ 
        T key = array[index1];
        array[index1] = array[index2];
        array[index2] = key;
    }
	
	private static <T> void quick(T[] array, Comparator<T> cc, int low, int end) // The function that implements QuickSort
	{
		if(low < end)
		{
			int pi = qpart(array,cc,low,end); // Function to set pi into right place
			quick(array,cc, low, pi - 1); // call itself to sort the left group
	        quick(array,cc, pi + 1, end); // call itself to sort the right group
		}
	}
	
	private static <T> int qpart(T[] array, Comparator<T> cc, int low, int end)// Function to place the element at correct position in sorted array
	{
		// T type pivot (Element to be placed at right position)
		T pivot = array[end];
		int i =(low-1);
		for(int j = low;j <= end-1;j++)
		{
			if(cc.compare(array[j], pivot) <= 0)
			{
				// Increment index of smaller element than the pivot
				i++;
				qswap(array,i,j);
			}
		}
		qswap(array,i+1,end);
		return (i+1);
	}
	
	private static <T> void msort(T[] array, Comparator<T> cc,int low, int end)// The function that implements MergeSort
	{
		if (low < end) 
		{
			// Find the middle point
            int middle = low + (end - low) / 2;
            // Sort first and second halves
            msort(array, cc, low, middle);
            msort(array, cc, middle + 1, end);
            // Merge the sorted halves
            merge(array, cc, low, middle, end);
        }
	}
	
	@SuppressWarnings("unchecked")
	private static <T> void merge(T[] array, Comparator<T> cc,int l,int m ,int e)// Merges two subarrays of array
	{
		int k = l; // Initial index of merged subarray array
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
        int n2 = e - m;
        // Create temp T arrays 
        T[] L = (T[]) new Object[String.valueOf(n1).length()+100];
        T[] R = (T[]) new Object[String.valueOf(n2).length()+100];
        // Copy data to temp T arrays
        for (int i = 0; i < n1; ++i)
        {
            L[i] = array[l + i];
        }
        for (int j = 0; j < n2; ++j)
        {
            R[j] = array[m + 1 + j];
        }
        // Initial indexes of first and second subarrays
        int i = 0; 
        int j = 0;
        while (i < n1 && j < n2) 
        {
            if (cc.compare(L[i], R[j]) < 0) 
            {
                array[k] = L[i];
                i++;
            }
            else 
            {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any 
        while (i < n1) 
        {
            array[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any 
        while (j < n2) 
        {
            array[k] = R[j];
            j++;
            k++;
        }
	}
	
	static <T> void insertionSort(T[] array, Comparator<T> cc)
	{
	    //TODO: insertion Sort
		for(int i = 1; i< array.length; i++)
	    {
	    	T key = array[i];
	    	int j = i-1;
	    	while(j > -1 && cc.compare(key, array[j]) < 0)// Move elements of array, that are greater than key, to one position ahead of their current position
	    	{
	    		array[j + 1] = array[j];
	    		j--;
	    	}
	    	array[j + 1] = key;
	    }
	}
	
    static <T> void quickSort(T[] array, Comparator<T> cc)
    {
        //TODO: quick sort
    	int n = array.length;
    	int low = 0;
    	int end = n-1;
    	quick(array,cc,low,end);
    }

    static <T> void mergeSort(T[] array, Comparator<T> cc)
    {
        //TODO: merge sort
    	int n = array.length;
    	int end = n-1;
    	msort(array,cc,0,end);
    }

    public static void main(String[] args) 
    {
        Integer[] a = { 6,4,1,8,3,2,7,5};
        Integer[] b = { 3,2,7,5,6,4,1,8};
        Integer[] c = { 6,4,7,5,1,8,3,2};
        //TODO: uncomment for testing
        System.out.println("Project 3: Sorting with the Generic datatype");
        System.out.println("-------------------------");
        System.out.println("insertion sort");
        System.out.println(Arrays.toString(a));
        insertionSort(a, Integer::compare);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(a));
        System.out.println("-------------------------");
        System.out.println("quick sort");
        System.out.println(Arrays.toString(b));
        quickSort(b, Integer::compare);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(b));
        System.out.println("-------------------------");
        System.out.println("merge sort");
        System.out.println(Arrays.toString(c));
        mergeSort(c, Integer::compare);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(c));
    }

}
