public class bubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] data =  new int[1000];
        
        for (int i = 0; i < data.length; i++){
            data[i] = (int )(Math.random() * 50 + 1);
            System.out.print(data[i]+" ");
        }
        
        System.out.println("");
        bubbleSort(data);
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i]+ " ");
        }
    }
    
    public static void bubbleSort(int[] data){
        boolean swap;
        do {
            swap = false;
            for(int i = 0; i < data.length -1; i++){
                if(data[i] > data[i+1]){
                    swap (data, i, i+1);
                    swap = true;
                }
            }
        }while(swap);
    }
    
    public static void swap(int[] data, int i, int j){
        int temp = data[j];
        data[j] = data[i];
        data[i] = temp;
    }
}
