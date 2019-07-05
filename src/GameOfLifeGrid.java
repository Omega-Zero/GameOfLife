
//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOfLifeGrid {

	final static int COLUMNS = 20;
	final static int ROWS = 20;
	final static int GENERATIONS = 500;
	static boolean initialArray[][] = new boolean[COLUMNS][ROWS];
	static boolean newArray[][] = new boolean[COLUMNS][ROWS];
	static boolean swapArray[][];
	
	public static void main(String[] args) {
		
		
		initialArray[5][1] = true;
		initialArray[6][1] = true;
		
		initialArray[17][5] = true;
		initialArray[18][5] = true;
		initialArray[16][5] = true;
		initialArray[18][6] = true;
		
		initialArray[15][12] = true;
		
		drawGrid(initialArray);
		
		runLifeLogic();
		
		
		

//	newArray = initialArray;
//
//	drawGrid(newArray);

	}

//Makes calls to StdDraw to appropriately draw grid based off array booleans 
	public static void drawGrid(boolean[][] array) {

		for (int column = 0; column < COLUMNS; column++) {
			for (int row = 0; row < ROWS; row++) {
				double xCoord = ((double) column * .05) + .025;
				double yCoord = ((double) row * .05) + .025;
				if (array[column][row] == true) {
					StdDraw.filledSquare(xCoord, yCoord, .025);
				} else {
					StdDraw.square(xCoord, yCoord, .025);
				}
				
			}
		}
	}//END drawGrid()
	
	

//Actual Life Logic
	public static void runLifeLogic() {

		int totalNeighbors = 0;

		for (int generation = 0; generation < GENERATIONS; generation++) {

			for (int column = 0; column < COLUMNS; column++) {

				for (int row = 0; row < ROWS; row++) {

					// If cell is alive
					if (initialArray[column][row]) {

						// array bounds check
						if (column - 1 != -1 && row - 1 != -1 && column + 1 != COLUMNS && row + 1 != ROWS) {

							// Check all its neighbors and tick variable appropriately
							totalNeighbors = 0;
							if (initialArray[column - 1][row - 1]) {
								totalNeighbors = totalNeighbors + 1;
							}
							if (initialArray[column][row - 1]) {
								totalNeighbors = totalNeighbors + 1;
							}
							if (initialArray[column + 1][row - 1]) {
								totalNeighbors = totalNeighbors + 1;
							}
							if (initialArray[column - 1][row]) {
								totalNeighbors = totalNeighbors + 1;
							}
							if (initialArray[column + 1][row]) {
								totalNeighbors = totalNeighbors + 1;
							}
							if (initialArray[column - 1][row + 1]) {
								totalNeighbors = totalNeighbors + 1;
							}
							if (initialArray[column][row + 1]) {
								totalNeighbors = totalNeighbors + 1;
							}
							if (initialArray[column + 1][row + 1]) {
								totalNeighbors = totalNeighbors + 1;
							}
						
							// After neighbor checks, if cell has exactly 3 of neighbors...
							if (totalNeighbors <= 1) {
								newArray[column][row] = false;
								totalNeighbors = 0;
							} else if (totalNeighbors >= 4) {
								newArray[column][row] = false;
								totalNeighbors = 0;
							} else {
								newArray[column][row] = true;
								totalNeighbors = 0;
							}
						}//END LIVE CELL BOUNDSCHECK
							
						// Else the cell is dead..
						}else {
							totalNeighbors = 0;
							// if row/column are in bounds
							if (column - 1 != -1 && row - 1 != -1 && column + 1 != COLUMNS && row + 1 != ROWS) {
								// check neighbors
								if (initialArray[column - 1][row - 1]) {
									totalNeighbors = totalNeighbors + 1;
								}
								if (initialArray[column][row - 1]) {
									totalNeighbors = totalNeighbors + 1;
								}
								if (initialArray[column + 1][row - 1]) {
									totalNeighbors = totalNeighbors + 1;
								}
								if (initialArray[column - 1][row]) {
									totalNeighbors = totalNeighbors + 1;
								}
								if (initialArray[column + 1][row]) {
									totalNeighbors = totalNeighbors + 1;
								}
								if (initialArray[column - 1][row + 1]) {
									totalNeighbors = totalNeighbors + 1;
								}
								if (initialArray[column][row + 1]) {
									totalNeighbors = totalNeighbors + 1;
								}
								if (initialArray[column + 1][row + 1]) {
									totalNeighbors = totalNeighbors + 1;
								}

								// If cell has 3 neighbors it comes to life else remains dead
								if (totalNeighbors == 3) {
									newArray[column][row] = true;
									totalNeighbors = 0;
								} else {
									newArray[column][row] = false;
									totalNeighbors = 0;

								}

							} // END DEADCELL BOUNDS CHECK

						}//END LIVE/DEAD IF CHECK

					}//END ROW LOOP

				} // END COLUMN LOOP
			
			
			swapArray = initialArray;
			initialArray = newArray;
			newArray = swapArray;
			drawGrid(newArray);
			System.out.println(initialArray[5][1]);
			
			} // END GEN  LOOP

//redraw array from newArray after every generation
			
			


	}// END METHOD runLifeLogic()

}// END CLASS GameOfLifeGrid
