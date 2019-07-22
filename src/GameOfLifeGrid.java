
//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods

public class GameOfLifeGrid {

	final static int COLUMNS = 20;
	final static int ROWS = 20;
	final static int GENERATIONS = 500;
	static boolean initialArray[][] = new boolean[COLUMNS][ROWS];
	static boolean newArray[][] = new boolean[COLUMNS][ROWS];
	static boolean swapArray[][];

	public static void main(String[] args) {

		//Exploder Tester
		initialArray[5][1] = true;
		initialArray[6][1] = true;
		initialArray[7][1] = true;
		initialArray[8][1] = true;
		initialArray[9][1] = true;
		initialArray[10][1] = true;
		initialArray[11][1] = true;
		
		//Simple test
		initialArray[6][1] = true;
		initialArray[17][5] = true;
		initialArray[18][5] = true;
		initialArray[16][5] = true;
		initialArray[18][6] = true;
		
		//single cell test
		initialArray[15][12] = true;

		drawGrid(initialArray);

		runLifeLogic();
	}

//Makes calls to StdDraw to appropriately draw grid based off array booleans 
	public static void drawGrid(boolean[][] array) {
		
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

//Actual Life Logic
	public static void runLifeLogic() {

		for (int generation = 0; generation < GENERATIONS; generation++) {

			for (int column = 0; column < COLUMNS; column++) {

				for (int row = 0; row < ROWS; row++) {
					
					int cellNeighborCount = neighborCheck(column, row);
					
					// If cell is alive
					if (initialArray[column][row]) {
						
						// doesCellDie
						if (cellNeighborCount == 1 || cellNeighborCount == 0 || cellNeighborCount >= 4) {
							newArray[column][row] = false;
						}else {
							newArray[column][row] = true;
						}

						// Else the cell is dead..
					} else {

						// doesCellComeToLife
						if (cellNeighborCount == 3) {
							newArray[column][row] = true;
						}else {
							newArray[column][row] = false;
						}

					} // END ELSE

				} // END ROW LOOP

			} // END COLUMN LOOP

			swapArray = newArray;
			newArray = initialArray;
			initialArray = swapArray;
			drawGrid(newArray);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
			}//END try

			
		} // END GEN LOOP
		
	}//END runLifeLogic();

	public static int neighborCheck(int column, int row) {
		
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
	}

}// END CLASS GameOfLifeGrid