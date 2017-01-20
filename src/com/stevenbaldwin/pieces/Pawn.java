package com.stevenbaldwin.pieces;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;

import java.io.Serializable;
import java.util.HashSet;

import static com.stevenbaldwin.enums.PieceType.PAWN;

public class Pawn extends Piece implements Serializable {
   private final PieceType type = PAWN;
    private static final int WHITE_STARTING_ROW = 6;
    private static final int BLACK_STARTING_ROW = 1;
    private boolean movedFromStartingPosition;

    public Pawn(Colour colour, int x_position, int y_position) {
        super(colour, x_position, y_position);

    }

    public Piece copy() {
        Pawn copy = new Pawn(this.getColour(),this.getX_position(),this.getY_position());
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
        return ( areCoordinatesValidForPawn(x_destination, y_destination)
                &&((isStartingMoveEligible(x_destination, y_destination, board))
                || isCaptureMoveEligible(x_destination, y_destination, board)
                || isStandardAdvanceEligible(x_destination, y_destination, board)));
    }



    private boolean isStandardAdvanceEligible(int x_destination, int y_destination, Piece[][] board){
       if(y_destination== this.getY_position()) {
           if (board[x_destination][y_destination].getColour() != Colour.NONE) {
               return false;
           }
           if (this.getColour() == Colour.WHITE && x_destination == (this.getX_position() - 1)) {
               return true;
           } else if (this.getColour() == Colour.BLACK && x_destination == (this.getX_position() + 1)) {
               return true;
           }
       }
      return false;

    }

    private boolean isStartingMoveEligible(int x_destination, int y_destination, Piece[][] board){
    if(y_destination == this.getY_position() && PieceUtils.isBoardTileEmpty(board,x_destination,y_destination) ) {
    if ((this.getColour() == Colour.WHITE) && this.getX_position() == 6 && (x_destination - this.getX_position()) == -2 && board[5][y_destination].getColour() == Colour.NONE) {
        return true;
    } else if ((this.getColour() == Colour.BLACK) && this.getX_position() == 1 && (x_destination - this.getX_position()) == 2 && board[2][y_destination].getColour() == Colour.NONE) { //blk piece moves forward two rows
        return true;
    }
    }
        return false;
    }

    private boolean areCoordinatesValidForPawn(int x_destination, int y_destination){
        final int x_offset = Math.abs(x_destination - this.getX_position());
        final int y_offset = Math.abs(y_destination - this.getY_position());

        return (x_offset<=2
                && x_offset>0
                && (y_offset==0 || y_offset==1));
    }
    private boolean isCaptureMoveEligible(int x_destination, int y_destination, Piece[][] board){
        final int y_offset =Math.abs(this.getY_position()-y_destination);
        final int x_movement = x_destination-this.getX_position();
        if(this.getColour()==Colour.BLACK && x_movement != 1){
            return false;
        }
        else if ((this.getColour()==Colour.WHITE && x_movement != -1)){
            return false;
        }
        return board[x_destination][y_destination].getColour()!= this.getColour()
                &&(board[x_destination][y_destination].getColour()!=Colour.NONE)
                && y_offset==1;

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
        return  isPathValid(x_destination, y_destination, board.getGamePieces())
                &&(BoardEvaluator.isKingSafeAfterMove(this.getColour(),board, new Move(this.getX_position(),this.getY_position(),x_destination,y_destination)));
    }

    @Override
    public HashSet<Move> generateAllPseudoLegalMoves(Board board) {
        Piece[][] pieces = board.getGamePieces();
        HashSet<Move> pawnMoves = new HashSet<>(2);

        pawnMoves.addAll(generatePseudoLegalAdvancementMoves(pieces));
        pawnMoves.addAll(generatePseudoLegalCaptureMoves(pieces));
        pawnMoves.addAll(generatePseduoLegalStartingMoves(pieces));
        if(!board.getPerformedMoves().empty()) {
            pawnMoves.addAll(generatePseduoLegalEnPassantMoves(board));
        }

        return pawnMoves;
    }

    private HashSet<Move> generatePseduoLegalEnPassantMoves(Board board) {
        Piece[][] pieces = board.getGamePieces();
        HashSet<Move> enPassantMoves = new HashSet<>(0);
        final int destinationRow = this.getX_position() + PieceUtils.properRowMovementForPawn(this,1);
        final int currentColumn = this.getY_position();
        if(BoardEvaluator.isEnPassantEligible(this,destinationRow,currentColumn+1, board.getPerformedMoves().peek(),pieces)){
            enPassantMoves.add(new Move(this.getX_position(),this.getY_position(),destinationRow,currentColumn+1));
        }
        if(BoardEvaluator.isEnPassantEligible(this,destinationRow,currentColumn-1, board.getPerformedMoves().peek(),pieces)){
            enPassantMoves.add(new Move(this.getX_position(),this.getY_position(),destinationRow,currentColumn-1));
        }
        return enPassantMoves;
    }

    private HashSet<Move> generatePseudoLegalCaptureMoves(Piece[][] board){
        HashSet<Move> captureMoves = new HashSet<>(1);
        final int currentRow = this.getX_position();
        final int currentColumn = this.getY_position();

        final int destinationRow = PieceUtils.properRowMovementForPawn(this,1) + currentRow;

        final int attackColumnEast = currentColumn + 1;
        if( PieceUtils.areCoordinatesInBounds(destinationRow,attackColumnEast) && PieceUtils.isBoardTileOccupiedByOpponent(board,destinationRow, attackColumnEast,this) ){
             captureMoves.add(new Move(currentRow,currentColumn,destinationRow, attackColumnEast));
         }
        final int attackColumnWest = currentColumn - 1;
        if(PieceUtils.areCoordinatesInBounds(destinationRow,attackColumnWest) && PieceUtils.isBoardTileOccupiedByOpponent(board,destinationRow, attackColumnWest,this) ){
            captureMoves.add(new Move(currentRow,currentColumn,destinationRow, attackColumnWest));
        }
            //TODO: implement enpassant!
        return captureMoves;
    }
    private HashSet<Move> generatePseudoLegalAdvancementMoves(Piece[][] board){
        HashSet<Move> advancementMoves = new HashSet<>(1);
        final int currentRow = this.getX_position();
        final int currentColumn = this.getY_position();


            final int rowOneForward = PieceUtils.properRowMovementForPawn(this,1) + currentRow;
            if((rowOneForward!= -1 && rowOneForward!= 8) && PieceUtils.isBoardTileEmpty(board, rowOneForward, currentColumn)){
                advancementMoves.add(new Move(currentRow,currentColumn,rowOneForward,currentColumn));
            }



return advancementMoves;
    }

    private HashSet<Move> generatePseduoLegalStartingMoves(Piece[][] board){
         final int currentRow = this.getX_position();
        final int currentColumn = this.getY_position();
        HashSet<Move> startingMoves = new HashSet<>(2);
        if(this.getColour()==Colour.WHITE && currentRow ==WHITE_STARTING_ROW){
            final int rowOneForward = PieceUtils.properRowMovementForPawn(this,1) + currentRow;
            if(PieceUtils.isBoardTileEmpty(board, rowOneForward, currentColumn)){
                startingMoves.add(new Move(currentRow,currentColumn,rowOneForward,currentColumn));
            }
            final int rowTwoForward = PieceUtils.properRowMovementForPawn(this,2) + currentRow;
            if(PieceUtils.isBoardTileEmpty(board, rowTwoForward, currentColumn)){
                startingMoves.add(new Move(currentRow,currentColumn,rowTwoForward,currentColumn));
            }
        }
        if(this.getColour()==Colour.BLACK && currentRow ==BLACK_STARTING_ROW){
            final int rowOneForward = PieceUtils.properRowMovementForPawn(this,1) + currentRow;
            if(PieceUtils.isBoardTileEmpty(board, rowOneForward, currentColumn)){
                startingMoves.add(new Move(currentRow,currentColumn,rowOneForward,currentColumn));
            }
            final int rowTwoForward = PieceUtils.properRowMovementForPawn(this,2) + currentRow;
            if(PieceUtils.isBoardTileEmpty(board, rowTwoForward, currentColumn)){
                startingMoves.add(new Move(currentRow,currentColumn,rowTwoForward,currentColumn));
            }
        }

        return startingMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pawn pawn = (Pawn) o;

        if (movedFromStartingPosition != pawn.movedFromStartingPosition) return false;
        return type == pawn.type;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (movedFromStartingPosition ? 1 : 0);
        return result;
    }
}
