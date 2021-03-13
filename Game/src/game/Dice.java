
package game;

import java.util.Random;
public class Dice {
    private int value;
    
    Random rnd = new Random();

    private final int MAX_VALUE;
    
    public Dice(int maxValue)
    {
        MAX_VALUE = maxValue;
    }

    public int getMaxValue()
    {
        return MAX_VALUE;
    }

    public int getValue()
    {
        return value;
    }

    public void throwDice()
    {        
        value = rnd.nextInt(MAX_VALUE) + 1;
    }
}
