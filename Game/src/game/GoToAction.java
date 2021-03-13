
package game;


public class GoToAction extends Action{
    int move;
  //  int square;
  //  boolean is_back;
    
    public GoToAction(int move){
        this.move=move; 
    }
    @Override
    public void act(Refugee refugee){
        
        refugee.moveTo(move);
      
    }
}
