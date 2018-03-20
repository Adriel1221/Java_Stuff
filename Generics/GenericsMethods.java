package genericsstack;

/**
 *
 * @author Adriel.Camargo001
 */
public class GenericMethods {
    public static void main(String[] arg){
        Integer[] integers = {1, 2, 3, 4, 5};
        String[] strings = {"London", "Paris", "New York" };
        
        GenericMethods.<Integer>print(integers);
        GenericMethods.<String>print(strings);
    }
    
    public static <E> void print(E[] list){
        for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
            System.out.println();
    }
}
