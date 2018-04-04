public class insertionSort {
 
    public static void main(String[] args) {
        int [] data =  new int[10];
        
        for (int i = 0; i < data.length; i++){
            data[i] = (int )(Math.random() * 50 + 1);
            System.out.print(data[i]+" ");
        }
        
        System.out.println("");
        
        insertionSort(data);
        
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]+ " ");
        }
    }
    
    
    
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
          /** insert list[i] into a sorted sublist list[0..i-1] so 	that list[0..i] is sorted. */
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
              list[k + 1] = list[k];
            }

            // Insert the current element into list[k+1]
            list[k + 1] = currentElement;
        }
    }
}
