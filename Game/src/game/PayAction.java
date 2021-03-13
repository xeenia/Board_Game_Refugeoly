
package game;



public class PayAction extends Action{
    
    int exp;
   
    
    public PayAction(int exp){
        this.exp=exp;
        
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void act(Refugee refugee) {
            try{
                refugee.giveMoney(exp);
            }catch(NoMoneyException e){
                System.out.println(e.getMessage());   
            }
             
        
        
      
    }
}
