package project.pkg1;
import java.awt.BorderLayout;
import java.util.*;
/**
 *
 * @author Adriel
 */
public class Project1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        double [][] seat_arrange = new double [][]{
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {10, 10, 20, 20, 20, 20, 20, 20, 10, 10},
            {20, 20, 30, 30, 40, 40, 30, 30, 20, 20},
            {20, 30, 30, 40, 50, 50, 40, 30, 30, 20},
            {30, 40, 50, 50, 50, 50, 50, 50, 40, 30},
        };
        while(count < 90){ 
            System.out.println("\t\tWelcome to Muvico");
            System.out.println("---------------------------------------------------------------");
            System.out.println("");
            System.out.println("if u want a resevation chose '1' to seach by seats.\n"
                             + "Enter '2' to seach by price");
            int choise = input.nextInt();

            
                switch(choise){                
                    case 1: 
                            System.out.println("Enter first the info");
                            System.out.print("Row: ");
                            int row = input.nextInt()-1;
                            System.out.print("Column: ");
                            int column = input.nextInt()- 1;
                            if(seat_arrange[row][column] == 0){
                                System.out.println("Seat sold");
                                count++;
                            }
                            if(seat_arrange[row][column] != 0){
                                System.out.println("Your seat have been reserved");
                                seat_arrange[row][column] = 0;
                            }
                        break;
                    case 2: 
                            boolean found = false;
                            System.out.println("enter the price u r looking 4 ");
                            System.out.print("price: ");
                            double price = input.nextDouble();
                            for(int i = 0; i < seat_arrange.length;i++){
                                for(int j = 0; j < seat_arrange[i].length;j++){
                                    if(seat_arrange[i][j] == price){
                                        found = true;
                                        System.out.println("the abalible seat with respect to price is at: "
                                        + "row:"+(i+1) +" and "+ "column:"+(j+1));
                                        seat_arrange[i][j] = 0;                                        
                                        count++;
                                        break;
                                    }
                                }
                                if(found){
                                    break;
                                }
                            }
                            if(!found){
                                System.out.println("Seat not found");
                            }        
                }
            }
            
    }            
}
    
