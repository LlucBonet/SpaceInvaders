package tp.p1.game;

import tp.p1.util.MyStringUtil;

public class BoardPrinter extends GamePrinter {
	
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	
	public BoardPrinter () {
		super(Game.DIM_Y, Game.DIM_X);
		this.numRows = Game.DIM_Y;
		this.numCols = Game.DIM_X;		
		//encodeGame(game);
	}
	
	public void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				// vuestro código aquí
				board[i][j] = game.positionToString(i, j);
			}
		}
	}
	
	public String toString() {

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;
		
		String cellDelimiter = MyStringUtil.repeat(hDelimiter, cellSize);
		
		String rowDelimiter = vIntersect + MyStringUtil.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtil.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;
		
		String margin = MyStringUtil.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<numCols; j++)
					str.append( MyStringUtil.centre(board[i][j], cellSize)).append(vDelimiter);
				if (i != numRows - 1) str.append(lineDelimiter);
				else str.append(lineEdge);	
		}
		
		return str.toString();
	}

	@Override
	public String setGame(Game game) {
		// TODO Auto-generated method stub
		encodeGame(game);	
		String setGame = game.infoToString() + this.toString();
		return setGame;
	}

	@Override
	public void printGame() {
		// TODO Auto-generated method stub
	}
	
}

