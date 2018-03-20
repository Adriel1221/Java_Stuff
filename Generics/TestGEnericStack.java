package genericsstack;

/**
 * @author Adriel.Camargo001
 */
public class TestGenericsStack {
    
    static public void main (String[] arg){
        GenericsStack<Integer> gs = new GenericsStack<Integer>();
        
        System.out.println(gs.getSize());
        
    }
}
