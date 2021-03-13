
package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Square extends Board{
     final String text;
     final int number;
    
    File file = new File("RuleCode.txt");
    ArrayList<acts> actions = new ArrayList<>();
    
    public Square(String text, int number){
        this.text=text;
        this.number=number;
    }
    public void putBack(){
        actions.get(0).roll=1;
    }
    public void getText(){
        System.out.println(number + " " + text);
    }
    
    @SuppressWarnings("empty-statement")
    public void addActs(char[] code) throws FileNotFoundException{
        
        int[] arr = new int[7]; // δημηιουργούμε πίνακα που θα περιέχει όλα τα στοιχεία του κουτιού που θα πέσουμε
        int count=0; // μετράει τον αριθμό των ακεραίων που θα έχει το ποσό που θα του περνάμε
        int num = 1; // "πολλαπλασιαστής" που θα έχει μέγεθος του ακέραιου
        int num2 = -1; // μετράει τα κόμματα
        boolean neg=false; // αν είναι αρνητικός ή όχι
        
        for(int j=0;(num2+1)<7;num=1,count=0,neg=false){ // κάνει επανάληψη και επεξεργάζεται κάθε αριθμό που πρέπει να βάλει σε στον πίνακα
            while(code[j++]!=','){
                if(code[j-1]=='-')
                    count--;
                count++;
            }  
            for(int k=1;k<count;k++){
                num*=10;
            } 
            if(','==code[j-1]){
                num2++;
            }
          
            for(int l=j-(count+1);num>0;num/=10,l++){
           
                if(l!=0&&code[l-1]=='-')
                    neg=true;
                arr[num2]+=num*(code[l]-'0');
            }
            if(neg)
                arr[num2]*=-1;
        }
        acts a = new acts(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6]);
        actions.add(a);
    }

    public int getMoney(){
        return actions.get(0).pay_money;
    }
    
    public void act(Refugee refugee){
       if(actions.get(0).alive==0){
           Action ow = new DeadAction();
           ow.act(refugee);
       }
       if(actions.get(0).pay_money<0){
           Action rec = new ReceiveAction();
           rec.act(refugee);
       }  
       else if(actions.get(0).pay_money!=0){
           char b='Β';
           if(refugee.sq==26){
               System.out.println("Έχετε δύο επιλογές.\nΕπιλογή Α: Πληρώνετε επιπλέον 1500$ την Mafia και ξαναρίχνετε.\nΕπιλογή Β: Δεν πληρώνετε και περιμένε 2 γύρους.");
               Scanner ch = new Scanner(System.in);
               System.out.print("\nΑπάντηση με Α ή Β: ");
               do{
                   if(b!='Α'&&b!='Β')
                        System.out.print("Παρακαλώ, πληκτρολογείστε σωστά την απάντηση σας. Απάντηση με Α ή Β:");
                   b=ch.next().charAt(0);
               }while(b!='Α'&&b!='Β');
               if(b=='Α'){
                   actions.get(0).roll=1;
                   actions.get(0).stays=0;
               }    
               else{
                   actions.get(0).roll=0;
                   actions.get(0).stays=2;
               }        
           }
           Action pay = new PayAction((b=='Α')?actions.get(0).pay_money+1500:actions.get(0).pay_money);
           pay.act(refugee);
           
       }
       if(actions.get(0).extra_life==1){
           Action extra = new LifeJacketSea();
           extra.act(refugee);
       }
       if(actions.get(0).roll==1){
           Action rollit = new RollDiceAction();
           rollit.act(refugee);
       }
       if(actions.get(0).move!=0){
           Action moveit = new GoToAction(actions.get(0).move);
           moveit.act(refugee);
       } 
       if(actions.get(0).stays!=0){
           Action stayit = new StayAction();
           stayit.act(refugee);
       }
       
    }
}
