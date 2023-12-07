package erikbissell.com.WebChess;

public class Chessboard {

    private Piece[][] board;
    public Chessboard(){
        board = new Piece[8][8];
        initializeEmptyBoard();
        initializeStartingBoard();
    }
    public void initializeEmptyBoard(){
        for (int rank = 0; rank < 8; rank++){
            for (int file = 0; file < 8; file++){
                board[rank][file] = new EmptySquare(rank,file);
            }
        }
    }
    public void initializeStartingBoard(){
        //Black Major and Minor Pieces
        board[0][0] = new Rook(0, 0, false);
        board[0][1] = new Knight(0, 1, false);
        board[0][2] = new Bishop(0, 2, false);
        board[0][3] = new Queen(0, 3, false);
        board[0][4] = new King(0, 4, false);
        board[0][5] = new Bishop(0, 5, false);
        board[0][6] = new Knight(0, 6, false);
        board[0][7] = new Rook(0, 7, false);
        //Black Pawns
        for (int j = 0; j < 8; j++) {
            board[1][j] = new Pawn(1, j, false);
        }
        //White Major and Minor Pieces
        board[7][0] = new Rook(7, 0, true);
        board[7][1] = new Knight(7, 1, true);
        board[7][2] = new Bishop(7, 2, true);
        board[7][3] = new Queen(7, 3, true);
        board[7][4] = new King(7, 4, true);
        board[7][5] = new Bishop(7, 5, true);
        board[7][6] = new Knight(7, 6, true);
        board[7][7] = new Rook(7, 7, true);
        //White Pawns
        for (int j = 0; j < 8; j++) {
            board[6][j] = new Pawn(6, j, true);
        }   
    }
    public Piece[][] getBoard(){
        return board;
    }
    public boolean movePiece(int sourceRow, int sourceCol, int destRow, int destCol){
        
        if(board[sourceRow][sourceCol].isValidMove(destRow, destCol,board)){
            return true;
        }
        
        return false;
    }
}