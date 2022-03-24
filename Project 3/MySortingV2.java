/*
* ID: 6388014
* FullName: Waris Damkham
* Section: 1
* */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MySortingV2 {

    //TODO: You are free to write any helper function

    private static <T> void mergeSort(T[] arr, Comparator<T> comparator,int low, int high,T[] key) 
    {
		if(low < high)
		{
			int mid = (low+high)/2; // find middle point  
			// Sort first and second halves
			mergeSort(arr,comparator,low,mid,key);
			mergeSort(arr,comparator,mid + 1,high,key);
			// Merge the sorted halves
			merge(arr,comparator,low,mid,high,key);
		}
    }
    private static <T> void merge(T[] arr, Comparator<T> comparator,int low, int middle, int high,T[] key) 
    {
    	 int k = low;
         int putItBack = high - low + 1;
         int midUp = middle + 1;
         while (low <= middle && midUp <= high) 
         {
             if (comparator.compare(arr[low], arr[midUp]) > 0) 
             {
                 key[k] = arr[midUp];
                 midUp++;
             } else 
             {
                 key[k] = arr[low];
                 low++;
             }
             k++;
         }
         while (low <= middle) 
         {
             key[k++] = arr[low++];
         }
         while (midUp <= high) 
         {
             key[k++] = arr[midUp++];
         }
         for (int i = 0; i < putItBack; i++, high--) 
         {
             arr[high] = key[high];
         }
    }
	private static <T> void swap(T[] array, int index1, int index2) // Swap function for Quicksort
	{ 
        T key = array[index1];
        array[index1] = array[index2];
        array[index2] = key;
    }
	private static <T> void quick(T[] array, Comparator<T> cc,Random RNG, int low, int end) // sort function for Quicksort
	{
		if(end - low >=2)
    	{
    		int pivot = RNG.nextInt(end - low) + low;
    		swap(array, low , pivot);
    	}
    	int i = low +1;
    	int j = end -1;
    	while(i <= j)
    	{
    		if(cc.compare(array[i], array[low]) <= 0)
    		{
    			i++;
    		}
    		else
    		{
    			if(cc.compare(array[j], array[low]) > 0)
    			{
    				j--;
    			}
    			else
    			{
    				swap(array,i++,j--);
    			}
    		}
    	}
    	swap(array,low,j);
    	if(low < j)
    	{
    		quick(array,cc,RNG,low,j); // call itself to sort the left group
    	}
    	if(end > i)
    	{
    		quick(array,cc,RNG,i,end); // call itself to sort the right group
    	}
	}
	
    static <T> void insertionSort(T[] array, Comparator<T> cc){
        //TODO: insertion Sort
    	for(int i = 1; i< array.length; i++)
    	{
    		T key = array[i];
    		int j = i-1;
    		while(j > -1 && cc.compare(key, array[j]) < 0)
    		{
    			array[j + 1] = array[j];
    			j--;
    		}
    		array[j + 1] = key;
    	}
    }

    static <T> void quickSort(T[] array, Comparator<T> cc){
        //TODO: quick sort
    	Random RNG = new Random();
    	int n = array.length;
    	int low = 0;
    	int end = n-1;
		quick(array, cc, RNG, low, end);
    }

    @SuppressWarnings("unchecked")
	static <T> void mergeSort(T[] array, Comparator<T> cc){
        //TODO: merge sort
    	T[] key = (T[]) new Object[array.length];
        mergeSort(array, cc, 0, array.length - 1,key);
    	
    }

    public static void main(String[] args) {
        Integer[] a = { 6,4,1,8,3,2,7,5};
        Integer[] b = { 3,2,7,5,6,4,1,8};
        Integer[] c = { 6,4,7,5,1,8,3,2};

        //TODO: uncomment for testing
        System.out.println("Insertion sort");
        System.out.println(Arrays.toString(a));
        insertionSort(a, Integer::compare);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(a));
//
        System.out.println("quick sort");
        System.out.println(Arrays.toString(b));
        quickSort(b, Integer::compare);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(b));
//
        System.out.println("merge sort");
        System.out.println(Arrays.toString(c));
        mergeSort(c, Integer::compare);
        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(c));
    }

}
