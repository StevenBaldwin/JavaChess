package com.stevenbaldwin.pieces;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;

import java.io.Serializable;
import java.util.HashSet;

import static com.stevenbaldwin.enums.PieceType.KING;

public class King extends Piece  implements Serializable {

    private boolean movedFromStartingPosition;
    public King(Colour colour, int x_position, int y_position) {
        super(colour, x_position, y_position);
    }


    public Piece copy() {
        King copy = new King(this.getColour(),this.getX_position(),this.getY_position());
        if(this.movedFromStartingPosition){
            copy.setMovedFromStartingPosition(true);
        }
        if(!this.movedFromStartingPosition){
            copy.setMovedFromStartingPosition(false);
        }
        return copy;
    }
    @Override
    public PieceType getType() {
        return KING;
    }

    @Override
    public boolean move(int x_destination, int y_destination, Piece[][] board) {
        return false;
    }

    @Override
    public boolean isLegalMove(int x_destination, int y_destination, Board board) {


        return  isPathValid(x_destination, y_destination, board.getGamePieces()) && (BoardEvaluator.isKingSafeAfterMove(this.getColour(),board, new Move(this.getX_position(),this.getY_position(),x_destination,y_destination)));

    }

    @Override
    protected boolean isPathValid(int x_destination, int y_destination, Piece[][] board) {
        final int x_movement = Math.abs(x_destination - this.x_position);
        final int y_movement = Math.abs(y_destination - this.y_position);
        return (board[x_destination][y_destination].getColour()!=this.getColour()
                && x_movement<=1
                && y_movement<=1);
    }

    @Override
    public HashSet<Move> generateAllPseudoLegalMoves(Board board) {
        HashSet<Move> kingMoves = new HashSet<>();
        final int currentXPosition = this.getX_position();
        final int currentYPosition = this.getY_position();

        int[] positionalArray = {-1,0,1};
        for(int i =0; i<positionalArray.length; i++){
            for(int j=0; j<positionalArray.length; j++){
                final boolean isAValidPositionalChange = positionalArray[i]!=0 || positionalArray[j]!=0;

                if(isAValidPositionalChange && PieceUtils.isBoardTileEligibleForMove(board.getGamePieces(),currentXPosition+positionalArray[i],currentYPosition+positionalArray[j],this)){
                    kingMoves.add(new Move(currentXPosition,currentYPosition,currentXPosition+positionalArray[i], currentYPosition+positionalArray[j]));
                }

            }
        }

        return kingMoves;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        King king = (King) o;

        return movedFromStartingPosition == king.movedFromStartingPosition;

    }

    @Override
    public int hashCode() {
        return (movedFromStartingPosition ? 1 : 0);
    }
}
