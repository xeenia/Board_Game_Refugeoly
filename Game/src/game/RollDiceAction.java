
package game;

import java.util.Scanner;


public class RollDiceAction extends Action{
    Dice dice = new Dice(6);
  
    @Override
    public void act(Refugee refugee){
        Scanner ch = new Scanner(System.in);
        System.out.println("Πάτα το 1 για να ξανα ρίξεις το ζάρι.");
        System.out.print("Πάτα: ");
        int k=ch.nextInt();
        dice.throwDice();
       
        System.out.println("Ζάρι: "+dice.getValue());
        refugee.moveTo((refugee.sq==22)?(-(dice.getValue())):dice.getValue());
        refugee.roll++;
    }
    
    
    
}
