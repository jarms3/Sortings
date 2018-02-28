/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.Random;
/**
 *
 * @author Josh
 */
public class Model 
{
    private int[] intArray;
    private int arraySize;
    public Random rand = new Random();
    
    public void reset(int size)
    {
        arraySize = size;
    }
    
    public void getUnsortedList()
    {
        int aSize = get();
        intArray = new int[aSize];
        
        for(int j = 0; j < aSize; j++)
        {
            intArray[j] = j;
        }
        for (int i = (aSize - 1); i >= 1; i--)
        {
            int n = rand.nextInt(aSize - 1) + 1;
            int temp = intArray[i];
            intArray[i] = intArray[n];
            intArray[n] = temp;
        }
        
    }
    
    public void set(int size)
    {
        arraySize = size;
    }
    
    public int get()
    {
        return arraySize;
    }
    public int[] getArray()
    {
        return intArray;
    }
}
