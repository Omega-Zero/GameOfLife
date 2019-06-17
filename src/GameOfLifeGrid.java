//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods

import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameOfLifeGrid {




public static void main(String[] args) { 
	
	final int COLUMNS = 20;
	final int ROWS = 20;
	final int GENERATIONS = 500;
	
	boolean initialArray[][] = new boolean[COLUMNS][ROWS]; 
	boolean newArray[][] = new boolean[COLUMNS][ROWS]; 
	boolean swap[][] = new boolean[COLUMNS][ROWS];
	
	
//	StdDraw.square(.025, .025, .025);
	//StdDraw.square(.025, .075, .025);
	//Checks arrays to see boolean values and draw appropriately 
	for(int column=0; column<COLUMNS; column++) {
		   for (int row=0; row<ROWS; row++) {
			   double xCoord = ((double)column * .05) + .025;
			   double yCoord = ((double)row * .05) + .025;
			   initialArray[5][1] = true;
			   	if(initialArray[column][row]) {
			   		StdDraw.filledSquare(xCoord, yCoord, .025);
			   	}else {
			   		StdDraw.square(xCoord, yCoord, .025);
			   	}
			 
		   }
	}
	
	//Actual Life Logic
for (int generation = 0; generation < GENERATIONS; generation++) {
	for(int column=0; column<COLUMNS; column++) {
		   for (int row=0; row<ROWS; row++) {
			   int totalNeighbors = 0;
			   
			   //If cell is alive
			   if(initialArray[column][row]) {
				   
			   
					if (column+1 <= COLUMNS) {
				   //Check all its neighbors and tick variable appropriatly 
				   	
				      if(initialArray[column-1][row-1]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column][row-1]) {
						   totalNeighbors = totalNeighbors + 1;					   
					   }
					   if(initialArray[column+1][row-1]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column-1][row]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column+1][row]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column-1][row+1]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column][row+1]) {
						   totalNeighbors = totalNeighbors + 1;					   
					   }
					   if(initialArray[column+1][row+1]) {
						   totalNeighbors = totalNeighbors + 1;
				       }
					}
				//After neighbor checks, if cell has a certain 3 of neighbors...
					if (totalNeighbors < 2) {
						initialArray[column][row] = false;
					}else if(totalNeighbors>3) {
						initialArray[column][row] = false;
					}else {
						initialArray[column][row] = true;
					}
			
				//Else the cell is dead..
			    }else {
			    	//check neighbors  
			    	   if(initialArray[column-1][row-1]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column][row-1]) {
						   totalNeighbors = totalNeighbors + 1;					   
					   }
					   if(initialArray[column+1][row-1]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column-1][row]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column+1][row]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column-1][row+1]) {
						   totalNeighbors = totalNeighbors + 1;
					   }
					   if(initialArray[column][row+1]) {
						   totalNeighbors = totalNeighbors + 1;					   
					   }
					   if(initialArray[column+1][row+1]) {
						   totalNeighbors = totalNeighbors + 1;
				       }
					//If cell has 3 neighbors it comes to life else remains dead
					if (totalNeighbors == 3) {
						initialArray[column][row] = true;
					}else{
						initialArray[column][row] = false;
					}
		
			    }
			  
		   }
	}
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

