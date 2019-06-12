//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods

import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameOfLifeGrid {




public static void main(String[] args) { 
	
	final int COLUMNS = 20;
	final int ROWS = 20;
	boolean initialArray[][] = new boolean[COLUMNS][ROWS]; 
	boolean newArray[][] = new boolean[COLUMNS][ROWS]; 
	boolean swap[][] = new boolean[COLUMNS][ROWS];
	
	//Checks arrays to see boolean values and draw appropriately 
	for(int column=1; column<COLUMNS; column++) {
		   for (int row=1; row<ROWS; row++) {
			   double xCoord = ((double)column / COLUMNS);
			   double yCoord = ((double)row / ROWS);
			   StdDraw.square(xCoord, yCoord, .1);
		   }
	}
}			   
			   
//0	StdDraw.square(.025, .025, .025);
//1	StdDraw.square(.025, .075, .025);
//2	StdDraw.square(.025, .125, .025);
//3	StdDraw.square(.025, .175, .025);
//4   StdDraw.square(.025, .225, .025);

//Draws a blank grid


//Draws grid with any true array indexes being a filled square
//public static void reDrawGrid() {
//	   newArray[1][3] = true;
//for(int j=0; j<arraySize; j++) {
//for (int i=0; i<arraySize; i++) {
//
//	   double xCoord = i / arraySize;
//	   double yCoord = j / arraySize;
//	   int xInt = (int)i;
//	   int yInt = (int)j;
//				   if(newArray[xInt][yInt] == false) {
//					   StdDraw.square(xCoord, yCoord, 1.0);
//     			   }else{
//					   
//					  
//					   StdDraw.filledSquare(xCoord, yCoord, 1.0);
//				   }
//				   
//			   }
//		}
//	}
//


}