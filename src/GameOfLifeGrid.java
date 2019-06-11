//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods

import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameOfLifeGrid {

static int arraySize = 20; 
static int column = arraySize;
static int row = arraySize;
static boolean initialArray[][] = new boolean[column][row]; 
static boolean newArray[][] = new boolean[column][row]; 


public static void main(String[] args) { 
	
	//drawGrid();
reDrawGrid();
//0	StdDraw.square(.025, .025, .025);
//1	StdDraw.square(.025, .075, .025);
//2	StdDraw.square(.025, .125, .025);
//3	StdDraw.square(.025, .175, .025);
//4   StdDraw.square(.025, .225, .025);
} 

//Draws a blank grid
public static void drawGrid() {
	
	for(double j=1.00; j<arraySize+1; j++) {
		   for (double i=1.00; i<arraySize+1; i++) {
			   double arraySizeDouble = new Double(arraySize);
			   double xCoord = (i / arraySizeDouble) - 1;
			   double yCoord = (j / arraySizeDouble) - 1;
			   StdDraw.square(xCoord, yCoord, 1.0);
		   }
	 } 
}

//Draws grid with any true array indexes being a filled square
public static void reDrawGrid() {
	   newArray[1][3] = true;
for(double j=1.00; j<(double)arraySize+1; j++) {
for (double i=1.00; i<(double)arraySize+1; i++) {
	   double arraySizeDouble = new Double(arraySize) + 1.00;
	   double xCoord = (i / arraySizeDouble) - 1;
	   double yCoord = (j / arraySizeDouble) - 1;
	   int xInt = (int)i;
	   int yInt = (int)j;
				   if(newArray[xInt][yInt] == false) {
					   StdDraw.square(xCoord, yCoord, 1.0);
     			   }else{
					   
					  
					   StdDraw.filledSquare(xCoord, yCoord, 1.0);
				   }
				   
			   }
		}
	}

}