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
public class MergeSort implements SortingStrategy
{

    @Override
    public void Sort(int[] array) 
    {
        mergeSort(array, 0, array.length - 1);
    }
    void merge(int arr[], int l, int m, int r)
    {
            
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;
 
        int[] left = new int[n1];
        int[] right = new int[n2];
 
        for (i = 0; i < n1; i++)
            left[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];
 
        i = 0; 
        j = 0; 
        k = l; 
        
            
        
        while (i < n1 && j < n2)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            
            k++;
           
        }
 
        while (i < n1)
        {
            arr[k] = left[i];
            
            i++;
            k++;
        }
 
        while (j < n2)
        {
            arr[k] = right[j];
            j++;
            k++;
           
        }
        
       
        
        
        
    }
 
    void mergeSort(int arr[], int l, int r)
    {
        
            if (l < r)
            {
                int m = (r+l)/2;
            
                mergeSort(arr, l, m);
                mergeSort(arr, m+1, r);
               
                merge(arr, l, m, r);
                 
                new Thread(()->{
                System.out.println("1");
                 try {
                    Thread.sleep(100);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
                }
               }).start();
            }
        
        
    }
    
}
