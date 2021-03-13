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
public interface MoneyGiver {
    public int giveMoney(int give) throws NoMoneyException;
  
}
