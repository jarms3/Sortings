/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josh
 */
public class SelectionSort implements SortingStrategy
{
    public int i,j;
    boolean unsorted = true;
    
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
                    try {
                        int temp = array[min];
                        array[min] = array[j];
                        array[j] = temp;
                        Thread.sleep(1000);
                    } catch (InterruptedException ex)
                    {
                       
                    }
                }
                
            }
        }).start();
        unsorted = false;
    }
    
}
