
package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    
    public static void main(String[] args) throws FileNotFoundException, Exception{
       
        Dice dice = new Dice(6);
        Menu menu = new Menu();
        
        GiverEntity NGO_Bank = new GiverEntity("NGO BANK");
        ReceiverEntity mafia = new ReceiverEntity("Mafia Bank");
        Board board = new Board();
        
        File boardfile = new File("BoardRules.txt");
        File codefile = new File("RuleCode.txt");
        
        Scanner boardsc = new Scanner(boardfile);
        FileReader fr = new FileReader(codefile); 
        
        char k; 
        int j=0;
        char[] to_array = new char[24];
        
        for(int i=0 ; i<40 ; i++,j=0){
            while((k=(char) fr.read())!='\n'){
                to_array[j++]=k;
            }
            board.addSquare(i,boardsc.nextLine(),to_array);
            
        }
        int playersNum;
        int number_players=0;
        
        while (true) {
            System.out.printf("\n\t\t\t\t%s\n", menu.name);
            System.out.println(menu.text);
            int l=menu.getChoice();
            ArrayList<Refugee> refugee = new ArrayList<>();
            
            switch (l) {
                case 2:
                    
                    File f1 = new File("Saves.txt");
                    Scanner scan = new Scanner(System.in);
                    BufferedReader br = new BufferedReader(new FileReader(f1)); 
                    BufferedReader br2 = new BufferedReader(new FileReader(f1));
                    if((br2.readLine())==null){
                        System.out.println("Δεν έχεις ξανακάνει save;");
                        break;
                    }
                    else
                        System.out.println("Ποιο παιχνίδι θες να παίξεις πάλι φίλε;");
                    
                    String st;
                    int flag1=0;
                    while ((st = br.readLine()) != null) {
                      if(st.contains("_SAVE"))
                          flag1++;
                      if(st.contains("<")){
                       ;
                      }
                      else if(st.contains("end")){
                        ;
                      }
                      else
                        System.out.println(st); 
                    
                    }
                    
                    BufferedReader br1 = new BufferedReader(new FileReader(f1));
                    int choise;
                    do{
                    System.out.print("Επιλογή: ");
                    choise = scan.nextInt();
                    }while((choise<0)||(choise>flag1));
                    
                    System.out.println();
                    while ((st = br1.readLine())!=null){

                        if(st.contains(choise+"_SAVE"))
                            break;
                        
                    }
                    
                    
                    while ((st = br1.readLine())!=null) {
                            if(st.contains("end"))
                                break;
                            if(!st.contains("<"))
                                continue;

                            if(st.contains("<")){
                             
                                char[] ch = new char[st.length()]; 

                                for (int i = 0; i < st.length(); i++) { 
                                    ch[i] = st.charAt(i); 
                                } 

                                int i=1,kati=1;

                                String name="" ;
                                int pay = 0,sq = 0,alive = 0,turn = 0,roll = 0, mafia1=0,ngo1=0,extra_life=0;
                                int exp = 0;
                                do{
                                    if(ch[i]==',')
                                    {
                                        kati++;
                                    }
                                    else{
                                        if(kati==1)
                                          name+=ch[i];
                                        else if(kati==2||kati==3||kati==4||kati==5||kati==6)
                                        {
                                            int times=0;
                                            int multy10=1;
                                            int num=0;

                                            while(ch[i++]!=',')
                                            {
                                                times++;
                                            }  

                                            for(int p=1;p<times;p++)
                                                multy10*=10;

                                            for(int temp=i-(times+1) ; multy10>0 ; multy10/=10,temp++)
                                            {
                                                num+=multy10*(ch[temp]-'0');
                                            }
                                            if(kati==2)
                                                pay=num;
                                            else if(kati==3)
                                                exp=num;
                                            else if(kati==4)
                                                sq=num;
                                            else if(kati==5)
                                                mafia.money=num;
                                            else if(kati==6)
                                                NGO_Bank.money=num;
                                            i--;
                                            kati++;
                                        }
                                        else 
                                        {
                                            if(kati==7)
                                                alive=ch[i]-'0';
                                            if(kati==8)
                                                extra_life=ch[i]-'0';
                                            if(kati==9)
                                                turn=ch[i]-'0';
                                            if(kati==10)
                                                roll=ch[i]-'0';
                                        }
                                    }
                                    i++;
                                }while(ch[i]!='>');
                             
                                Refugee m = new Refugee();

                                refugee.add(m);
                                
                                refugee.get(number_players).name=name;
                            
                                refugee.get(number_players).money=pay;
                                refugee.get(number_players).sq=sq;
                                refugee.get(number_players).exp=exp;
                                 
                                if(alive==1)
                                    refugee.get(number_players).alive=true;
                                else
                                    refugee.get(number_players).alive=false;
                                
                                if(extra_life==1)
                                    refugee.get(number_players).extra_life=true;
                                
                                else
                                    refugee.get(number_players).extra_life=false;
                                
                                refugee.get(number_players).turn_time=turn;
                                refugee.get(number_players).roll=roll;
                               
                                number_players++;
                          }  
                        
                    }
                    
                    
                    
                case 1:
                        
                    playersNum=number_players;
                    Scanner scanf = new Scanner(System.in);
                    if(l==1){
                        
                        menu.getBasicRules();
                        playersNum=menu.getPlayers();
                    
                        
                        String n;
                        for(int i=0;i<playersNum;i++){

                            System.out.printf("Όνομα %dου παίχτη: ",i+1);
                            n = scanf.next();
                            Refugee m = new Refugee();

                            refugee.add(m);
                            refugee.get(i).name=n;
                            refugee.get(i).money=10000;
                            refugee.get(i).sq=0;
                        }
                    
                        menu.spreadMoney();
                    }
                    int who=0;
                    int fl=0,fl2=0,i,f3=0;
                    while(true){

                        if(who==(playersNum))
                            who=0;
                        for(i=0,fl=fl2=f3=0;i<playersNum;i++){
                            if(refugee.get(i).win)
                            fl++;
                            if(!refugee.get(i).alive)
                                fl2++;
                            if(refugee.get(i).money<=0)
                                f3++; 
                            
                        }
                        if((fl+fl2+f3)==playersNum)
                                break;
                        if(refugee.get(who).win){
                            who++;
                            continue;
                        }
                        if((refugee.get(who).alive)&&(refugee.get(who).money>0))
                        {
                            System.out.println("\n\n");
                            System.out.println("\n\n\n\n\n\n\n\n");
                            menu.entityInfo(mafia,NGO_Bank);
                            System.out.println("----------------------------------------------");
                            menu.startGame(playersNum,refugee.get(who));
                            
                            if(refugee.get(who).turn_time!=0){
                               refugee.get(who).turn_time--;
                               System.out.println("Δεν παίζεις αυτόν τον γύρο");
                               who++;
                               continue;
                            }

                            System.out.println("Πάτα οποιοδήποτε πλήκτρο(εκτός του Ε) για να ρίξεις το ζάρι ή Ε για αποθήκευση ή/και έξοδο.\n");
                            System.out.print("Πάτα: ");
                            char ch = scanf.next().charAt(0);
                            if(ch=='Ε'||ch=='ε'){
                                System.out.println("Θα ήθελες να αποθηκεύσεις το παιχνίδι σου;(Ν|Ο)");
                                ch = scanf.next().charAt(0);
                                if(ch=='Ν'||ch=='ν'){
                                    SaveGame sv= new SaveGame();
                                    sv.SaveMe(refugee,mafia,NGO_Bank);
                                }
                                System.out.println("Θα ήθελες να βγεις από το παιχνίδι;(Ν|Ο)");
                                ch = scanf.next().charAt(0);
                                if(ch=='Ν'||ch=='ν'){
                                    System.exit(0); 
                                }
                                
                                System.out.println("\n\nΠάτα οποιοδήποτε πλήκτρο(εκτός του Ε) για να ρίξεις το ζάρι ή Ε για αποθήκευση ή/και έξοδο.\n");
                                System.out.print("Πάτα: ");
                                ch = scanf.next().charAt(0);
                            
                            }


                            dice.throwDice();
                            int val = dice.getValue();
                            
                            System.out.println("\nΖάρι: "+val);
                            if(refugee.get(who).moveTo(val)){
                               ;
                            }
                            else{
                                System.out.print("\nΒρίσκεσαι στο τετράγωνο: ");


                                System.out.println(refugee.get(who).sq+"\n\n");
                                System.out.println(board.getSquare(refugee.get(who).sq));

                                board.getInSquare(refugee.get(who),mafia, NGO_Bank);
                                while(refugee.get(who).roll!=0){
                                  System.out.print("\nΒρίσκεσαι στο τετράγωνο: ");
                                  System.out.println(refugee.get(who).sq+"\n");
                                  System.out.println(board.getSquare(refugee.get(who).sq));
                                  board.getInSquare(refugee.get(who),mafia,NGO_Bank);
                                  refugee.get(who).roll--;
                                }
                                board.flag=0;
                            }   
                        }
                        who++;
                        
                    }
 
                default:
                    System.exit(0); 
            }
        }
       
    }
    
}
