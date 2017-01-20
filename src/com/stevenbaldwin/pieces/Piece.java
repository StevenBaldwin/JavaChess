package com.stevenbaldwin.pieces;

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;

import java.awt.*;
import java.io.Serializable;
import java.util.Set;

public abstract class Piece implements Serializable {

private Colour colour;
private PieceType type;
int x_position;
int y_position;
private boolean movedFromStartingPosition;
private long identifier;

    public boolean hasMovedFromStartingPosition() {
        return movedFromStartingPosition;
    }

    public void setMovedFromStartingPosition(boolean movedFromStartingPosition) {
        this.movedFromStartingPosition = movedFromStartingPosition;
    }

    public Piece(Colour colour, int x_position, int y_position){

        this.colour=colour;
        this.x_position = x_position;
        this.y_position = y_position;
        setMovedFromStartingPosition(false);
        identifier = System.nanoTime();
    }



    public abstract PieceType getType();



    public Colour getColour() {
        return colour;
    }

    public abstract Set<Move> generateAllPseudoLegalMoves(Board board);

    public abstract boolean move(int x_destination, int y_destination, Piece[][] board);

    public abstract boolean isLegalMove( int x_destination, int y_destination, Board board);

//  TODO:  public abstract boolean generateAllLegalMoves()

    public void setColour(Colour colour) {
        this.colour = colour;
    }


    protected abstract boolean isPathValid(int x_destination, int y_destination, Piece[][] board);

    public int getX_position() {
        return x_position;
    }

    public Point getPostion(){
        return new Point(this.getX_position(), this.getY_position());
    }

    public Colour getOpposingColour(){
        if(this.colour == Colour.BLACK){
            return Colour.WHITE;
        }
        else if(this.colour == Colour.WHITE){
            return Colour.BLACK;
        }
        else {
            throw new IllegalStateException("THere is no opposing colour to the blank pieces");
        }
    }

    public void setX_position(int x_position) {
        this.x_position = x_position;
    }

    public int getY_position() {
        return y_position;
    }

    public void setY_position(int y_position) {
        this.y_position = y_position;
    }

    @Override
    public String toString() {

  return  "[colour : " + this.getColour() + "] [type : " + this.getType() + "] [location = " + this.getX_position()+","+ this.getY_position() + "]";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (x_position != piece.x_position) return false;
        if (y_position != piece.y_position) return false;
        if (movedFromStartingPosition != piece.movedFromStartingPosition) return false;
        if (identifier != piece.identifier) return false;
        if (colour != piece.colour) return false;
        return type == piece.type;

    }

    @Override
    public int hashCode() {
        int result = colour != null ? colour.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + x_position;
        result = 31 * result + y_position;
        result = 31 * result + (movedFromStartingPosition ? 1 : 0);
        result = 31 * result + (int) (identifier ^ (identifier >>> 32));
        return result;
    }
}
