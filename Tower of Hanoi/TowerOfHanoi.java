package towersofhanoi;

import java.util.Scanner;

/**
 *
 * @author Adriel.Camargo001
 */
public class TowersOfHanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of disks: ");
        int n = input.nextInt();
        
        System.out.println("The moves are");
        moveDisk(n, 'A', 'B', 'C');
    }
    
    
    public static void moveDisk(int n, char fromTower, char toTower, char auxTower){
        int count  = 0;
        if (n==1){
            
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        }
            
        else {
            
            moveDisk(n-1, fromTower, auxTower, toTower);
            
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveDisk(n-1, auxTower, toTower, fromTower);
        }
    }
}
