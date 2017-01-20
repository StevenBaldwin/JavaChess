package com.stevenbaldwin.pieces;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;

import java.io.Serializable;
import java.util.HashSet;

import static com.stevenbaldwin.enums.PieceType.KNIGHT;

public class Knight extends Piece implements Serializable {
     private final PieceType type = KNIGHT;
    private boolean movedFromStartingPosition;

    public Knight(Colour colour, int x_position, int y_position) {
        super(colour, x_position, y_position);

    }


    public Piece copy() {
        Knight copy = new Knight(this.getColour(),this.getX_position(),this.getY_position());
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
        return this.type;
    }

    @Override
    public boolean move(final int x_destination,final int y_destination, Piece[][] board) {
//        int x_movement = Math.abs(x_destination-this.getX_position());
//        int y_movement = Math.abs(y_destination-this.getX_position());
//
//        if(BoardEvaluator.isKingSafe(this.getColour(),board) && (x_movement==1 || x_movement==2) && (y_movement==1 || y_movement==2)){
//            return true;
//        }
//
            return false;

    }

    @Override
    protected boolean isPathValid(int x_destination, int y_destination, Piece[][] board) {
        final int x_movement = Math.abs(x_destination - this.getX_position());
        final int y_movement = Math.abs(y_destination - this.getY_position());
        return ((x_movement==1 || x_movement==2)
                && (y_movement==1 || y_movement==2)
                && board[x_destination][y_destination].getColour()!=this.getColour()
                && x_movement!=y_movement);
    }



    @Override
    public boolean isLegalMove(int x_destination, int y_destination, Board board) {

        return isPathValid(x_destination, y_destination, board.getGamePieces())
                && BoardEvaluator.isKingSafeAfterMove(this.getColour(),board, new Move(this.getX_position(),this.getY_position(),x_destination,y_destination));


    }

    @Override
    public HashSet<Move> generateAllPseudoLegalMoves(Board board) {
        Piece[][] pieces = board.getGamePieces();
   HashSet<Move> knightMoves = new HashSet<>();
        final int currentXPosition = this.getX_position();
        final int currentYPosition = this.getY_position();

        int[] positionalArray = {-2,-1,1,2};
        for(int i =0; i<positionalArray.length; i++){
            for(int j=0; j<positionalArray.length; j++){
                final boolean isAValidPositionalChange = Math.abs(positionalArray[i]) != Math.abs(positionalArray[j]);

                    if(isAValidPositionalChange && PieceUtils.isBoardTileEligibleForMove(pieces,currentXPosition+positionalArray[i],currentYPosition+positionalArray[j],this)){
                        knightMoves.add(new Move(currentXPosition,currentYPosition,currentXPosition+positionalArray[i], currentYPosition+positionalArray[j]));
                    }

            }
        }

        return knightMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Knight knight = (Knight) o;

        if (movedFromStartingPosition != knight.movedFromStartingPosition) return false;
        return type == knight.type;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (movedFromStartingPosition ? 1 : 0);
        return result;
    }
}
