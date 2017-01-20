package com.stevenbaldwin.pieces;

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;

import java.io.Serializable;
import java.util.Set;

import static com.stevenbaldwin.enums.PieceType.ROOK;

public class Rook extends Piece implements Serializable {
       private final PieceType type = ROOK;
    private boolean movedFromStartingPosition;

    public Rook(Colour colour, int x_position, int y_position) {
        super(colour, x_position, y_position);

    }
    public Piece copy() {
        Rook copy = new Rook(this.getColour(),this.getX_position(),this.getY_position());
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
    public PieceType getType() {
        return this.type;
    }

    @Override
    public boolean move(int x_destination, int y_destination, Piece[][] board) {
        return false;

    }

    @Override
    public boolean isLegalMove(int x_destination, int y_destination, Board board) {

        return  BoardEvaluator.isStraightPathValid(this,x_destination,y_destination,board.getGamePieces())
                && (BoardEvaluator.isKingSafeAfterMove(this.getColour(),board, new Move(this.getX_position(),this.getY_position(),x_destination,y_destination)));
    }

    @Override
    public Set<Move> generateAllPseudoLegalMoves(Board board) {
        return PieceUtils.generateAllPseudoLegalStraightMoves(board.getGamePieces(), this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rook rook = (Rook) o;

        if (movedFromStartingPosition != rook.movedFromStartingPosition) return false;
        return type == rook.type;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (movedFromStartingPosition ? 1 : 0);
        return result;
    }
}

//
//    Castling is permissible if and only if all of the following conditions hold (Schiller 2003:19):
//
//        The king and the chosen rook are on the player's first rank.[3]
//        Neither the king nor the chosen rook has previously moved.
//        There are no pieces between the king and the chosen rook.
//        The king is not currently in check.
//        The king does not pass through a square that is attacked by an enemy piece.[4]
//        The king does not end up in check. (True of any legal move.)