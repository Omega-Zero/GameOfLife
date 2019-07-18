
//Jeffrey's Java Implenetation of the Game of Life using StdDraw class methods


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
	}// END drawGrid()

//Actual Life Logic
	public static void runLifeLogic() {


		for (int generation = 0; generation < GENERATIONS; generation++) {

			for (int column = 0; column < COLUMNS; column++) {

				for (int row = 0; row < ROWS; row++) {

					// If cell is alive
					if (initialArray[column][row]) {

						// array bounds check
							
							//doesCellDie
							if(neighborCheck(column, row) == 1 || neighborCheck(column, row) == 0 || neighborCheck(column, row) >= 4 ) {
								newArray[column][row] = false;
							}else {
								newArray[column][row] = true;
							}
							
							
						
						
						// Else the cell is dead..
						}else {

								// doesCellComeToLife
								if (neighborCheck(column, row) == 3) {
									newArray[column][row] = true;
								} else {
									newArray[column][row] = false;
								}

							} // END ELSE 

					}//END ROW LOOP

				} // END COLUMN LOOP
			drawGrid(newArray);
			swapArray = initialArray;
			initialArray = newArray;
			newArray = swapArray;
				
			} // END GEN LOOP
	}

	public static int neighborCheck(int column, int row) {
		int totalNeighbors = 0;
		if (column - 1 != -1 && row - 1 != -1 && column + 1 != COLUMNS && row + 1 != ROWS) {
			
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
			
		}
		return totalNeighbors;
		
	}
	
	}// END CLASS GameOfLifeGrid
