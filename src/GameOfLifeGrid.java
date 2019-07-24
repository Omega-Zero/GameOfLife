
//Jeffrey's Java implementation of the Game of Life using StdDraw class methods
import java.util.Random;

public class GameOfLifeGrid {

	final static int GENERATIONS = 500;

	public static void main(String[] args) {

	
		letThereBeLife();
	
	}

	
	
	//Generates life by changing booleans in 2D initialArray
	public static void letThereBeLife() {
		int COLUMNS = 20;
		int ROWS = 20;
		int desiredRandomCells = 100;
		
		boolean initialArray[][] = new boolean[COLUMNS][ROWS];
		boolean newArray[][] = new boolean[COLUMNS][ROWS];
		boolean swapArray[][] = new boolean[COLUMNS][ROWS];
		
		// Exploder Tester
//		initialArray[5][1] = true;
//		initialArray[6][1] = true;
//		initialArray[7][1] = true;
//		initialArray[8][1] = true;
//		initialArray[9][1] = true;
//		initialArray[10][1] = true;
//		initialArray[11][1] = true;

		// Simple test
//		initialArray[6][1] = true;
//		initialArray[17][5] = true;
//		initialArray[18][5] = true;
//		initialArray[16][5] = true;
//		initialArray[18][6] = true;

		// single cell test
//		initialArray[15][12] = true;
		
		//Generates random life cells based off desired # of grid filled
		for (int currentRandomCells = 0; currentRandomCells < desiredRandomCells; currentRandomCells++) {
			Random randomLife = new Random();

			int lifeColumn = randomLife.nextInt(COLUMNS);
			int lifeRow = randomLife.nextInt(ROWS);
			initialArray[lifeColumn][lifeRow] = true;
		}
		
		runLifeLogic(initialArray, newArray, swapArray, COLUMNS, ROWS);
	}
	
	
	
	/**
	 * Method uses StdDraw to draw the life grid on jFrame based off given 2D boolean array.
	 * 
	 * @param array - 2D array that will be drawn to screen
	 * @param COLUMNS -  the column count size for the overall grid
	 * @param ROWS -  the row count size for the overall grid
	 */
	public static void drawGrid(boolean[][] array, int COLUMNS, int ROWS) {

		StdDraw.clear();
		StdDraw.enableDoubleBuffering();

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

		StdDraw.show();

	}// END drawGrid()

	
	

	
	/**
	 * Method that calls neighborCheck() and drawGrid() to simulate John Conway's Game of Life Logic that is calculated within method. 
	 *          
	 *               ---IF LOGIC--- 
	 *     - For a space that is 'populated': -
	 * Each cell with one or no neighbors dies, as if by solitude.
	 * Each cell with four or more neighbors dies, as if by overpopulation.
	 * Each cell with two or three neighbors survives.
	 * 
	 *    - For a space that is 'empty' or 'unpopulated' -
	 * Each cell with three neighbors becomes populated.
	 * 				---------------
	 * 
	 * @param initialArray - 2D boolean array that represents the currently displayed life grid
	 * @param newArray - 2D boolean array that represents the life grid for the next incoming generation
	 * @param swapArray - 2D boolean array that acts as a place holder for when generations are swapping between initialArray and newArray
	 * @param COLUMNS -  the column count size for the overall grid
	 * @param ROWS -  the row count size for the overall grid
	 */
	public static void runLifeLogic(boolean[][] initialArray, boolean[][] newArray, boolean[][] swapArray, int COLUMNS, int ROWS) {



		for (int generation = 0; generation < GENERATIONS; generation++) {

			for (int column = 0; column < COLUMNS; column++) {

				for (int row = 0; row < ROWS; row++) {

					int cellNeighborCount = neighborCheck(initialArray, column, COLUMNS, row, ROWS);

					// If cell is alive
					if (initialArray[column][row]) {

						// doesCellDie
						if (cellNeighborCount == 1 || cellNeighborCount == 0 || cellNeighborCount >= 4) {
							newArray[column][row] = false;
						} else {
							newArray[column][row] = true;
						}

						// Else the cell is dead..
					} else {

						// doesCellComeToLife
						if (cellNeighborCount == 3) {
							newArray[column][row] = true;
						} else {
							newArray[column][row] = false;
						}

					} // END ELSE

				} // END ROW LOOP

			} // END COLUMN LOOP

			swapArray = newArray;
			newArray = initialArray;
			initialArray = swapArray;
			drawGrid(newArray, COLUMNS, ROWS);

			try {
				Thread.sleep(500);runLifeLogic(initialArray, newArray, swapArray, COLUMNS, ROWS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // END try

		} // END GEN LOOP

	}// END runLifeLogic();

	
	
	
	/**
	 * Method that when passed a 2D array and cell location in array will return the neighbors of the cell
	 * 
	 * @param initialArray - 2D boolean array that represents the currently displayed life grid
	 * @param column - the current column number for the cell being neighborchecked
	 * @param COLUMNS - the column count size for the overall grid
	 * @param row - the current row number for the cell being neighborchecked 
	 * @param ROWS - the row count size for the overall grid
	 * @return the number of "true" neighbor cells around the cell in question
	 */	
	public static int neighborCheck(boolean[][] initialArray, int column, int COLUMNS, int row, int ROWS) {

		int totalNeighbors = 0;

		if (column - 1 != -1 && row - 1 != -1) {
			if (initialArray[column - 1][row - 1]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}

		if (row - 1 != -1) {
			if (initialArray[column][row - 1]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}

		if (column + 1 != COLUMNS && row - 1 != -1) {
			if (initialArray[column + 1][row - 1]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}

		if (column - 1 != -1) {
			if (initialArray[column - 1][row]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}

		if (column + 1 != COLUMNS) {
			if (initialArray[column + 1][row]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}

		if (column - 1 != -1 && row + 1 != ROWS) {
			if (initialArray[column - 1][row + 1]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}

		if (row + 1 != ROWS) {
			if (initialArray[column][row + 1]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}

		if (column + 1 != COLUMNS && row + 1 != ROWS) {
			if (initialArray[column + 1][row + 1]) {
				totalNeighbors = totalNeighbors + 1;
			}
		}
		return totalNeighbors;
	}//End class neighborCheck()
	
	

	
	
}// END CLASS GameOfLifeGrid