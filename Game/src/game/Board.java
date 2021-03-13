
package game;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Board {
    private int num;
    int flag=0;
    ArrayList<Square> sq = new ArrayList<>();
     
    
    public void addSquare(int num, String text, char[] code) throws FileNotFoundException{
        Square square = new Square(text,num);
        square.addActs(code);
        sq.add(square);
        
    }
    
    public String getSquare(int number){
        return sq.get(number).text;
    }
    
    public void getInSquare(Refugee refugee,ReceiverEntity rec, GiverEntity ngo){
        int currentMoney=refugee.money;
        int currentPlace=refugee.getSquare();
        sq.get(refugee.sq).act(refugee);
        if(currentPlace==1)
            ;
        else if(sq.get(refugee.sq).getMoney()>=0){
            rec.money+=(currentMoney-refugee.money);
        }
        else if(sq.get(refugee.sq).getMoney()==-1000&&flag==0){
            ngo.money-=1000;
            flag++;
            
        }
    }
}
