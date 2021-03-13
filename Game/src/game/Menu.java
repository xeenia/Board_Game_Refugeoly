
package game;

import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    String text;
    String name;
    public Menu(){
        name="Refugeoly";
        text="Το Refugeoly είναι ένα σοβαρό παιχνίδι όπου ο κύριος σκοπός του δεν είναι "
                + "μόνο\nη διασκέδαση αλλά και η κατανόηση της ανθρωπιστικής κρίσης. "
                + "\n"
                + "Το παιχνίδι αυτό είναι έτσι σχεδιασμένο με σκοπό να γίνει αντιληπτό "
                + "το δραματικό ταξίδι \nτων προσφύγων κατά την προσπάθεια τους να μπουν σε "
                + "μια χώρα ασύλου. Παίζοντας το Refugeoly \nθα έχετε την ευκαιρία να γίνετε "
                +  " πρόσφυγες και να βρεθείτε αντιμέτωποι με \nτις πραγματικές  συνθήκες "
                + "όπου ένας πρόσφυγας βιώνει μέχρι το σημείο προορισμού του.";
    }
    
    public int getChoice()
    {
        Scanner ch = new Scanner(System.in);
        
        int k=1;
        System.out.printf("\n\t\t 1) Νέο Παινίδι\t 2) Φόρτωση Παιxνιδιού\t 3) Έξοδος\nΑπάντηση: ");
        do
        {
            if(k<1||k>3)
                System.out.println("Έγινε ένα λάθος κατά την πληκτρολόγηση, ξαναγράψτε την επιλογή σας.\nΑπάντηση: ");
            k=ch.nextInt();
        }while(k<1||k>3);
        return k;
    }
    
    public void getBasicRules(){
        char arrow=0x21B3;
        System.out.println(arrow + " Εάν ένας παίχτης χάσει όλα τα λεφτά του βγαίνει από το παιχνίδι.");
        System.out.println(arrow + " Για να κερδίσετε το παιχνίδι πρέπει να φτάσετε στο σημείο 39 (Σπίτι).\n  Έαν ρίξετε το ζάρι και προσπεράσετε το 39, τότε πρέπει να ξαναγυρίσετε στην θέση σας.");
        System.out.println(arrow + " Για περισσότερους κανόνες επιλέξτε το ταδε λολ");
        
    }
    public void result(Refugee refugee){
        System.out.println("----------------------------------------------");
        System.out.println("\n\n"+refugee.getName()+"\n\nΠήγες στην θέση "+ refugee.getSquare() +".");
        
        
    }
    public void clearScreen(){
        System.out.println("\n\n\n\n\n\n\n\n\n");
    }
    
    public int getPlayers(){
        char lChe=0x2308, lFloo=0x230A;
        char rChe=0x2309, rFloo=0x230B;
        char num1=0x2460, num2=0x2461, num3=0x2462, num4=0x2463;
        Scanner ch = new Scanner(System.in);
        int k=1;
        String l;
        
        do{
            if(k<1||k>4)
                System.out.println("Μπορείτε να επιλέξετε μέχρι 4 παίκτες. Ξαναεπιλέξτε.");
            System.out.println("\t\t\t\t Παίχτες:\n\n");
            System.out.println("\t"+ num1 + "\t\t" + num2 + "\t\t\t" + num3 + "\t\t" + num4);
            System.out.print("\nΑπάντηση: ");
            k=ch.nextInt();
//            if(k>=1&&k<=4){
//                System.out.println("Είστε σίγουροι ότι επιλέξατε τον σωστό αριθμό παικτών;\nΠληκτρολογείστε με ένα ΝΑΙ ή ΟΧΙ.");
//                l=ch.next();
//                do{
//                    if("ΟΧΙ".equals(l)||"οχι".equals(l)||"όχι".equals(l)||"ΌΧΙ".equals(l)){
//                        k=-1;
//                        break;
//                    }
//                    else if("ΝΑΙ".equals(l)||"ναι".equals(l)||"Ναι".equals(l))
//                        break;
//                    else{
//                        System.out.println("Έγινε κάποιο ορθογραφικό λαθος, ξαναγράψτε σωστά την απάντηση σας.");
//                        System.out.print("Απάντηση: ");
//                        l=ch.next();
//                    }
//                }while(true);
//            }
        }while(k<1||k>4);
        return k;
    }
    
    public void spreadMoney(){
        char bullet_op=0x2219;
        System.out.printf("\n\nΚάθε παίχτης παίρνει από: \n%c 8x500$\n%c 30x100$\n%c 3x1000$\nΣυνολικά 10.000$\n\n",bullet_op,bullet_op,bullet_op);
        System.out.printf("Η τράπεζα NGO ξεκινάει με 10.000$\nH Mafia ξεκινάει με 0$.\n\n");
    }
    
    public void entityInfo(ReceiverEntity maf, GiverEntity bank){
        System.out.print(bank.name+": "+bank.money +"$");
        System.out.println("\t"+maf.name+": "+maf.money+"$");
    }
    public void startGame(int players_num,Refugee refugee){
        
      System.out.println(refugee.name+":");
      System.out.printf("%c %d$ ",(char)0x2217,refugee.money);
      System.out.println();
      if(refugee.extra_life)
         System.out.printf("%c %s  \n",(char)0x2217,"Έχεις ένα σωσίβιο στην κατοχή σου"); 
      if(refugee.turn_time==1||refugee.turn_time==2)
         System.out.printf("%c %d %s  \n",(char)0x2217,refugee.turn_time,(refugee.turn_time==2)?"γύρους":"γύρο"); 
      char ch=0x2217;
      System.out.println("\n");
      System.out.println("Your expenses:"+refugee.exp);
      System.out.println("\n");
      System.out.println("Βρίσκεσαι στο τετράγωνο: "+refugee.sq+"\n");
     
    }
    public void results(ArrayList<Refugee> refugee){
        System.out.println("Νικητές:\n");
        for(int i=0;i<4;i++){
            if(refugee.get(i).win)
                System.out.println("~ "+refugee.get(i).getName());
                
        }
        System.out.println("Έχασαν:\n");
        for(int i=0;i<4;i++){
            if((!refugee.get(i).alive)||(refugee.get(i).getMoney()<=0))
                System.out.println("~ "+refugee.get(i).getName());
        }
    }
    
}