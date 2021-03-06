package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
	grid = new Mark[width][width];
        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
         for (int i=0; i<= grid.length; i++){
            for (int j=0; j<= grid[i].length; j++) {
                grid[i][j]= Mark.EMPTY;
            }
            
        }
        
}
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
	if (isValidSquare(row, col) && !isSquareMarked(row, col)) {
			if (xTurn) {
				grid[row][col] = Mark.X;
				xTurn = !xTurn;
				return true;
			}
			else {
				grid[row][col] = Mark.O;
				xTurn = !xTurn;
				return true;
			}
		}
        return false; /* remove this line! */
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
	    if((row >= 0) && (row < width)) {
			
				if((col >= 0) && (col < width)) {
					return true;
				}
		}

        return false; /* remove this line! */
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */

        return !grid[row][col].equals(Mark.EMPTY);
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
	if (isValidSquare(row, col)) {
			
			return grid[row][col];
		
}
        return null; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */

        if(isMarkWin(Mark.O)) {
			return Result.O;	
		}else if (isMarkWin(Mark.X)) {
			return Result.X;
		}else if (isTie()) {
			return Result.TIE;
		}
		else {
			return Result.NONE;
		}

	}

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
boolean won;
		//column
		for(int col = 0; col <width; ++col) {
			won = true;
			for(int row = 0; row < width; ++row) {
			if (grid[row][col] != mark) {
					
					won = false;
				}
			}
			if (won) {
			return true;
			}
		}
		
		for (int row = 0; row < width; ++row) {
		won = true;
		for (int col = 0; col < width; ++col) {
			if(grid[row]col] !=mark) {
				won = false;
				}
			}
			if (won) {
			retun true;
			}
		}
		// diagonal L to R
		won = true;
		for (int i = 0; i < width; ++i) {
			if (grid[i][width - i - 1] != mark) {
				won = false;
			}
		}
		if (won) {
		return true;
		}
		
		// diagonal R to L
		won = true;
		for (int i = 0; i < width; ++i) {
		if(grid[i][i] != mark){
			won = false;
			}
		}
		if (won) {
		return true;
		}



}
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
		boolean full = true;
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < width; ++j) {
				if (getMark(i, j) == Mark.EMPTY)
					full = false;
			}
		}
		if (!full)
			return false;
return !((isMarkWin(Mark.X)) || (isMarkWin(Mark.O)));
      
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}
