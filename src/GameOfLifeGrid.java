//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods

import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameOfLifeGrid {

static int arraySize = 10; 
static int column = arraySize;
static int row = arraySize;
static boolean initialArray[][] = new boolean[column][row]; 
static boolean newArray[][] = new boolean[column][row]; 


public static void main(String[] args) { 
	
	drawGrid();
    

  
} 

//Draws a blank grid
public static void drawGrid() {
	
	for(double j=0.00; j<arraySize; j++) {
		   for (double i=0.00; i<arraySize; i++) {
			   double arraySizeDouble = new Double(arraySize);
			   double xCoord = i / arraySizeDouble;
			   double yCoord = j / arraySizeDouble;
			   StdDraw.square(xCoord, yCoord, 0.5);
		   }
	 } 
}



}