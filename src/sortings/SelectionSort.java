/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Runnable;
import java.lang.Thread;

/**
 *
 * @author Josh
 */
public class SelectionSort implements SortingStrategy
{
    public int i,j, temp;
    
    @Override
    public void Sort(int[] array)
    {
       
        new Thread(()->{
            
            for(j = 0; j < array.length - 1; j++)
            {
                int min = j;
                for(i = j + 1; i < array.length; i++)
                {
                    if(array[i] < array[min])
                    {
                        min = i;
                    }
                }
                if(min != j)
                {
                    temp = array[min];
                    array[min] = array[j];
                    array[j] = temp;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex)
                    {
                       
                    }
                }
             
            }
        }).start();
        
    }
    
}
