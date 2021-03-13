/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author polyxeni
 */
public class GiverEntity extends GenInfo implements MoneyGiver {
    
    public GiverEntity(String name){
        this.name=name;
        money=10000;
    }
    
    @Override
    public int giveMoney(int give){
        money-=give;
        return give;
    }
}
