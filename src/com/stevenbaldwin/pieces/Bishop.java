package com.stevenbaldwin.pieces;//  Created by Steven J Baldwin  on 2016-09-15.


import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;

import java.io.Serializable;
import java.util.HashSet;

import static com.stevenbaldwin.enums.PieceType.BISHOP;


public class Bishop extends Piece implements Serializable {
   private final PieceType type = BISHOP;
    private boolean movedFromStartingPosition;

    public Bishop(Colour colour, int x_position, int y_position) {
        super(colour, x_position, y_position);

    }

    public Piece copy() {
        Bishop copy = new Bishop(this.getColour(),this.getX_position(),this.getY_position());
        if(this.movedFromStartingPosition){
            copy.setMovedFromStartingPosition(true);
        }
        if(!this.movedFromStartingPosition){
            copy.setMovedFromStartingPosition(false);
        }
        return copy;
    }
    @Override
    protected boolean isPathValid(int x_destination, int y_destination, Piece[][] board) {
        return false;
    }

    @Override
    public boolean move(int x_destination, int y_destination, Piece[][] board) {
    return false;
    }

    @Override
    public boolean isLegalMove(int x_destination, int y_destination, Board board) {

        return BoardEvaluator.isDiagonalPathValid(this, x_destination, y_destination, board.getGamePieces())
                && BoardEvaluator.isKingSafeAfterMove(this.getColour(),board, new Move(this.getX_position(),this.getY_position(),x_destination,y_destination));


    }

    @Override
    public HashSet<Move> generateAllPseudoLegalMoves(Board board) {


   return PieceUtils.generateAllPseudoLegalDiagonalMoves(board.getGamePieces(),this);
    }


    @Override
    public PieceType getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bishop bishop = (Bishop) o;

        if (movedFromStartingPosition != bishop.movedFromStartingPosition) return false;
        return type == bishop.type;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (movedFromStartingPosition ? 1 : 0);
        return result;
    }
}
