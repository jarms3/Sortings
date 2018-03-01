/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import java.lang.Runnable;
import java.lang.Thread;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author Josh
 */
public class SortingsController implements Initializable
{
    ObservableList<String> algorithmList = FXCollections.observableArrayList("Merge Sort", "Selection Sort");
    
    @FXML
    private Pane viewPane;
    
    @FXML
    private Text Algorithms;
    
    @FXML
    private ComboBox algorithmComboBox;
    
    @FXML
    private Text arraySizeText;
    
    @FXML
    private Slider sizeSlider;
    
    @FXML
    private Text sizeText;
    
    @FXML
    private Button sortButton;
    
    @FXML
    private Button resetButton;
    
    public Model mod = new Model();
    
    public MergeSort sort = new MergeSort();
    
    public SelectionSort sorty = new SelectionSort();
    
    public boolean click = false;
    
    
    public void arraySizeBar_ValueChanged(MouseEvent event)
    {
        sizeText.setText(Double.toString(Math.rint(sizeSlider.getValue())));
        
        mod.set((int)Math.rint(sizeSlider.getValue()));
        mod.getUnsortedList();
    }
    public void sortBtn_Click()
    {
        setSortStrategy();
        
    }
    public void test()
    {
        setSortStrategy();
    }
    public void resetBtn_Click()
    {
        sizeSlider.setValue(1);
        sizeText.setText(Double.toString(Math.rint(sizeSlider.getValue())));
        mod.reset((int)Math.rint(sizeSlider.getValue()));
    }
    
    public void setSortStrategy()
    {
         if(algorithmComboBox.getValue() == "Merge Sort")
            sort.Sort(mod.getArray());
         else if(algorithmComboBox.getValue() == "Selection Sort")
            sorty.Sort(mod.getArray());
         
    }
    
    public void getRectangles()
    {
        new Thread(()->{
            while(true)
            {
                Platform.runLater(()->{
                    viewPane.getChildren().clear();
        
                    for(int i = 1; i < (int)sizeSlider.getValue(); i++)
                    {
                        Rectangle rect = new Rectangle();
            
                        double w = viewPane.getWidth()/sizeSlider.getValue();
            
                        double h = mod.getArray()[i]*3;
            
                        double x = w*i;
                        double y = viewPane.getHeight() - mod.getArray()[i]*3;
            
                        rect.setWidth(w);
                        rect.setHeight(h);
            
                        rect.setLayoutX(x);
                        rect.setLayoutY(y);
            
                        rect.setFill(RED);
                        viewPane.getChildren().add(rect);
                    }
                
                   
            
                });
                try {
                        Thread.sleep(100);
                                } catch (InterruptedException ex) {
                        Logger.getLogger(SortingsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
        }).start();
        
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        algorithmComboBox.setItems(algorithmList);
        algorithmComboBox.setValue("Choose Algorithm");
        
        this.getRectangles();
    }
    
}
