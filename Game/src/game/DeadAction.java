
package game;

public class DeadAction extends Action{
    @Override
    public void act(Refugee refugee){
       if(refugee.sq==10){
           
           if(!refugee.extra_life){               
               System.out.println("Δυστυχώς δεν κατάφερες να επιβιώσεις στο ταξίδι σου στην θάλασσα. Βγαίνεις από το παιχνίδι."); //**
               refugee.alive=false;
           } 
           else{
               System.out.println("\n\nΕίχες όμως στην κατοχή σου ένα σωσίβιο ως επιπλέον ζωή. \nΑυτό σου έσωσε την ζωή. Συνεχίζεις το παιχνίδι."); //**
               refugee.extra_life=false;
           }
       } 
       else{
          // System.out.println("Συγχαρητήρια!! Κέρδισες στο παιχνίδι.");
           refugee.win=true;
       }
           
    }   
}
