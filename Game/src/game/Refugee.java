
package game;

/**
 *
 * @author polyxeni
 */
public class Refugee implements MoneyGiver, MoneyReceiver{
    String name;
    int money;
    int sq;
    boolean alive;
    boolean extra_life;
    int turn_time;
    int roll;
    boolean win;
    int exp;
    public Refugee(){
        name=" ";
        money=0;
        sq=0;
        alive=true;
        extra_life=false;
        turn_time=0;
        roll=0;
        win=false;
        exp=0;
    }
    @Override
    public void receiveMoney(int rec){
       money+=rec; 
    }
    
    
    @Override
    public int giveMoney(int give) throws NoMoneyException{
            money-=give;
            if(money<=0)
                throw new NoMoneyException("Δυστυχώς σου τελείωσαν τα λεφτά. Είσαι εκτός!");
            exp+=give;
        return give;
    }
    
    public boolean moveTo(int move){
        
            if( (sq+move)<=39){
                sq+=move;
                return false;
            }
            else{
                System.out.println("Με την ζαριά σου ξεπέρασες το 39. Επιστρέφεις στην θέση σου.");
                return true;
            }

    }
    public void setName(String name){
        this.name=name;
    }
    public int getSquare(){
        return sq;
    }
    
    @Override
    public String toString(){
        return "My name is " + name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMoney(){
        return money;
    }
    public void setSquare(int sq){
        this.sq=sq;
    }
    
}
