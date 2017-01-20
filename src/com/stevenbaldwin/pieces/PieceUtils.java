package com.stevenbaldwin.pieces;

import com.stevenbaldwin.Move;
import com.stevenbaldwin.enums.Colour;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Created by Steven on 2016-09-27.
 */
public class PieceUtils implements Serializable {

    private PieceUtils(){
        throw new RuntimeException("cannot instantiate Piece Utils!");
    }

    public static HashSet<Move> generateAllPseudoLegalDiagonalMoves(Piece[][] board, Piece pieceToGenerateMoves){
        HashSet<Move> allLegalBishopMoves = new HashSet<>();
        allLegalBishopMoves.addAll(PieceUtils.generateAllNorthDiagonalPseudoLegalMoves(board, pieceToGenerateMoves));
        allLegalBishopMoves.addAll(generateAllSouthDiagonalPseudoLegalMoves(board, pieceToGenerateMoves));



        return allLegalBishopMoves;
    }

    private static HashSet<Move> generateAllNorthDiagonalPseudoLegalMoves(Piece[][] board, Piece pieceToGenerateMoves){
        HashSet<Move> northPseudoLegalMoves = new HashSet<>();
        boolean northWestPathOpen = true;
        boolean northEastPathOpen = true;
        final int x_position = pieceToGenerateMoves.getX_position();
        final int y_position = pieceToGenerateMoves.getY_position();
        int yPositionSpread =1;
        for(int row = x_position-1; row>=0; row--){

            final int eastComponent = y_position - yPositionSpread;

            if(isBoardTileEligibleForMove(board, row, eastComponent,pieceToGenerateMoves) && northWestPathOpen){
                northPseudoLegalMoves.add(new Move(x_position,y_position,row, eastComponent));
            }

            northWestPathOpen = isPathOpen(board, row, eastComponent, northWestPathOpen,pieceToGenerateMoves);

            final int westComponent = y_position + yPositionSpread;

            if(isBoardTileEligibleForMove(board, row, westComponent, pieceToGenerateMoves) && northEastPathOpen){
                northPseudoLegalMoves.add(new Move(x_position,y_position,row, westComponent));
            }
            northEastPathOpen = isPathOpen(board, row, westComponent, northEastPathOpen, pieceToGenerateMoves);
            yPositionSpread++;
        }
        return northPseudoLegalMoves;
    }




    private static HashSet<Move> generateAllSouthDiagonalPseudoLegalMoves(Piece[][] board,Piece pieceToGenerateMoves){

        HashSet<Move> southPseudoLegalMoves = new HashSet<>();
        boolean southWestPathOpen = true;
        boolean southEastPathOpen = true;
        final int x_position = pieceToGenerateMoves.getX_position();
        final int y_position = pieceToGenerateMoves.getY_position();
        int yPositionSpread =1;
        for(int row = x_position+1; row<=7; row++){
            final int eastComponent = y_position - yPositionSpread;

            if(isBoardTileEligibleForMove(board, row, eastComponent ,pieceToGenerateMoves) && southWestPathOpen ){
                southPseudoLegalMoves.add(new Move(x_position,y_position,row, eastComponent));
            }
            southWestPathOpen = isPathOpen(board,row,eastComponent,southWestPathOpen, pieceToGenerateMoves);
            final int westComponent = y_position + yPositionSpread;

            if(isBoardTileEligibleForMove(board, row, westComponent, pieceToGenerateMoves) && southEastPathOpen ){
                southPseudoLegalMoves.add(new Move(x_position,y_position,row, westComponent));
            }
            southEastPathOpen = isPathOpen(board,row,westComponent,southEastPathOpen, pieceToGenerateMoves);
            yPositionSpread++;
        }
        return southPseudoLegalMoves;
    }

    private static boolean isPathOpen(Piece[][] board, int row, int column, boolean currentPathBoolean, Piece pieceToGenerateMoves) {
        boolean pathOpen= true;
        if(!currentPathBoolean){ //ensures that the current path boolean will change from true to false once and can't change back!
            return false;
        }
        if((!isBoardTileEligibleForMove(board, row, column, pieceToGenerateMoves) || board[row][column].getColour() == pieceToGenerateMoves.getOpposingColour()) ){
            pathOpen = false;
        }
        return pathOpen;
    }

    public static HashSet<Move> generateAllPseudoLegalStraightMoves(Piece[][] board, Piece piece){
        HashSet<Move> pseudoLegalStraightMoves = new HashSet<>();
    final int originalRow = piece.getX_position();
    final int originalColumn = piece.getY_position();
        boolean westPathOpen = true;
        boolean eastPathOpen = true;
        boolean northPathOpen = true;
        boolean southPathOpen = true;

        for(int i=1; i<=7; i++){

            final int eastPathColumn = originalColumn + i;
            if(isBoardTileEligibleForMove(board, originalRow, eastPathColumn,piece) && eastPathOpen ){
                pseudoLegalStraightMoves.add(new Move(originalRow,originalColumn,originalRow, eastPathColumn));
            }
            eastPathOpen = isPathOpen(board,originalRow, eastPathColumn,eastPathOpen,piece);


            final int westPathColumn = originalColumn - i;
            if(isBoardTileEligibleForMove(board, originalRow, westPathColumn,piece) && westPathOpen ){
                pseudoLegalStraightMoves.add(new Move(originalRow,originalColumn,originalRow, westPathColumn));
            }
            westPathOpen = isPathOpen(board,originalRow, westPathColumn,westPathOpen,piece);

            final int northPathRow = originalRow - i;
            if(isBoardTileEligibleForMove(board, northPathRow, originalColumn  ,piece) && northPathOpen ){
                pseudoLegalStraightMoves.add(new Move(originalRow,originalColumn, northPathRow, originalColumn));
            }
            northPathOpen = isPathOpen(board, northPathRow,originalColumn,northPathOpen,piece);

            final int southPathRow = originalRow + i;
            if(isBoardTileEligibleForMove(board, southPathRow, originalColumn  ,piece) && southPathOpen ){
                pseudoLegalStraightMoves.add(new Move(originalRow,originalColumn, southPathRow, originalColumn));
            }
            southPathOpen = isPathOpen(board, southPathRow,originalColumn ,southPathOpen,piece);

        }
        return pseudoLegalStraightMoves;
    }

    public static boolean isBoardTileEligibleForMove(Piece[][] board, int row, int column, Piece pieceToGenerateMoves){

        return areCoordinatesInBounds(row,column) && (isBoardTileOccupiedByOpponent(board, row, column, pieceToGenerateMoves) || isBoardTileEmpty(board, row, column));

    }

    public static boolean isBoardTileEmpty(Piece[][] board, int row, int column){
        if(! areCoordinatesInBounds(row,column)){
            System.out.println(row + "  "  + column);
            throw new IllegalStateException("Out of bounds (isBoardTileEmpty)");
        }
        return board[row][column].getColour()==Colour.NONE;
//        if(board[row][column].getColour()==Colour.NONE){
//            return true;
//        }
//        else {
//            return false;
//        }
    }

    public static boolean isBoardTileOccupiedByOpponent(Piece[][] board, int row, int column, Piece friendlyPiece){

        if(!areCoordinatesInBounds(row,column)) {

    throw new IllegalStateException("Out of bounds isBoardTileOccupiedByOpponent");
        }
        Colour friendlyColour = friendlyPiece.getColour();
        Colour destinationColour = board[row][column].getColour();
            if (friendlyColour == Colour.WHITE && destinationColour == Colour.BLACK && areCoordinatesInBounds(row, column)) {
                return true;
            }
            if (friendlyColour == Colour.BLACK && destinationColour == Colour.WHITE && areCoordinatesInBounds(row, column)) {
                return true;
            }

        else {
            return false;
        }
    }

    public static int properRowMovementForPawn(Pawn pawn, int amountOfMovement){
        if(!(amountOfMovement== 1 || amountOfMovement==2)){
            throw new IllegalStateException("Pawn can only ever move one or two rows forward!");
        }
        Colour alliance = pawn.getColour();
        if(alliance==Colour.WHITE){
            return - Math.abs(amountOfMovement);
        }
         else if (alliance == Colour.BLACK){
            return Math.abs(amountOfMovement);
        }
        else {
            throw new IllegalStateException("Unknown Colour of Pawn");
        }

    }
    public static boolean areCoordinatesInBounds(int x, int y){
        return (x>=0 && x<=7 && y>=0 && y<=7);
    }
}
