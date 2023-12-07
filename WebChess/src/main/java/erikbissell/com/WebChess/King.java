package erikbissell.com.WebChess;

import com.fasterxml.jackson.annotation.JsonProperty;

public class King extends Piece {
    public King (int initialRank, int initialFile, boolean isWhite){
        super(initialRank, initialFile, isWhite);
        super.setNickName('K');


    }
    public boolean isValidMove(int newRank, int newFile, Piece[][] board){
        return true;
    }
    public boolean move(int newRank, int newFile, Piece[][] board){
        return true;
    }
    public boolean isValidCapture(int newRank, int newFile, Piece[][] board){
        return true;
    }
    public boolean capture(int newRank, int newFile, Piece[][] board){
        return true;
    }
    
    @Override
    public char getNickName(){
        return nickName;
    }
    @Override
    public String toString(){
        return "King";
    }

}
