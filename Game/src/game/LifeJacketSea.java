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
public class LifeJacketSea extends Action{
    @Override
    public void act(Refugee refugee){
       refugee.extra_life=true; 
    }
}
