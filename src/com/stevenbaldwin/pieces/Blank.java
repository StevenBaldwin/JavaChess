package com.stevenbaldwin.pieces;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;

import java.io.Serializable;
import java.util.Set;

import static com.stevenbaldwin.enums.PieceType.BLANK;

public class Blank extends Piece  implements Serializable {
    PieceType type = BLANK;

    public Blank(int x_position, int y_position) {
        super(Colour.NONE, x_position, y_position);

    }

    public Piece copy() {
       return new Blank(this.getX_position(),this.getY_position());
    }

    @Override
    public Set<Move> generateAllPseudoLegalMoves(Board board) {
        return null;
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

        return false;
    }


    @Override
    public PieceType getType() {

        return BLANK;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blank blank = (Blank) o;

        return type == blank.type;

    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }
}
