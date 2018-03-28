package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Adriel.Camargo001
 */
public class BinarySearch {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int key;
        int [] list = {1,5,9,3,4,6,7};
        Arrays.sort(list);
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i]);
        }
        System.out.println();
        
        System.out.println("Enter key");
        key = input.nextInt();
        
        //System.out.println(binarySearch(list, key)); // While loop to solve recursion
    }
    
    
    public static int recusiveBinarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;
        return recusiveBinarySearch(list, key, low, high);
    }
    
    private static int recusiveBinarySearch(int[] list, int key, int low, int high){
        if (low < high)
            return - low - 1;
        int mid = (low + high)/2;
        if (key < list[mid])
            return recusiveBinarySearch(list, key, high, high);
        else if (key == list[mid])
            return mid;
        else 
            return recusiveBinarySearch(list, key, mid+1, high);
    }
    
    public static int binarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;
        
        while(high >= low){
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if(key == list[mid])
                return mid;
            else 
                low = mid + 1;
        }
        
        return -low -1;
    }
}
