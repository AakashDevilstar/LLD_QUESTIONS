import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Data_Structure.Pair;
import Model.Board;
import Model.PieceType;
import Model.Player;
import Model.PlayingPiece;
import Model.PlayingPieceO;
import Model.PlayingPieceX;

public class TicTacToeGame {
	Deque<Player> players;
	Board gameBoard;
	
	public void intializeGame() {
		players=new LinkedList<>();
		
		PlayingPieceO noughtsPiece=new PlayingPieceO();
		Player player2=new Player("Player2",noughtsPiece);
		
		PlayingPieceX cross=new PlayingPieceX();
		Player player1=new Player("Player1",cross);
		
		players.add(player1);
		players.add(player2);
		
		gameBoard=new Board(3);
	}
	
	public String startGame(){
		
		boolean winner=true;
		while(winner) {
			Player playturn=players.removeFirst();
			gameBoard.PrintBoard();
			List<Pair> freespaces=gameBoard.getFreeCells();
			if(freespaces.isEmpty()) {
				winner=false;
				continue;
			}
			
			System.out.print("Player:"+playturn.name+"Enter Row,Columns: ");
			
			//
			Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);
            //
            
            boolean pieceAddedSuccessfully=gameBoard.addPiece(inputRow,inputColumn,playturn.playingpiece);
            if(!pieceAddedSuccessfully) {
            	System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playturn);
                continue;
            }
            players.addLast(playturn);
            boolean winner1=isThereWinner(inputRow,inputColumn,playturn.playingpiece.pieceType);
            if(winner1) {
            	return playturn.name;
            }
		}
		return "Tie";
	}
	
	public boolean isThereWinner(int row, int column,PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;

	}
	
}