
package game;

public class ReceiverEntity extends GenInfo implements MoneyReceiver{
    
    public ReceiverEntity(String name){
        this.name=name;
        money=0;
    }
    
    @Override
    public void receiveMoney(int rec){
        money+=rec;
    } 
    
    public int playerExp(int m){
        return 10000-m;
    }
}
