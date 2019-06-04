//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods

import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameOfLifeGrid {

int arraySize = 10; 
boolean initialArray[][] = new boolean[arraySize][arraySize]; 
boolean newArray[][] = new boolean[arraySize][arraySize]; 


public static void main(String[] args) { 
	
	// Creates the main window
    JFrame mainWindow = new JFrame("The Game of Life");
    mainWindow.setSize(750, 750);
    mainWindow.setVisible(true);
   
    StdDraw.square(0.2, 0.8, 0.1);
    
    
    

  
} 



}