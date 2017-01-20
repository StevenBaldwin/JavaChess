package com.stevenbaldwin.board;
//  Created by Steven J Baldwin  on 2016-09-16.

import com.rits.cloning.Cloner;
import com.stevenbaldwin.Game;
import com.stevenbaldwin.Move;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import com.stevenbaldwin.pieces.Blank;
import com.stevenbaldwin.pieces.Piece;
import com.stevenbaldwin.pieces.PieceUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BoardEvaluator implements Serializable {


    private BoardEvaluator(){
        throw new RuntimeException("Cannot Instantiate BoardEvaluator!");
    }

  public static boolean isCastleEligible(Colour kingColour, int kingFinalRow, int kingFinalColumn, Board board){ //should be finished!
      Piece[][] pieces = board.getGamePieces();
        if(!isKingSafe(kingColour,board)){
            return false;
        }
        if(!areTilesBetweenKingAndRookEmpty(kingColour,kingFinalColumn,pieces)){
            return false;
        }
        if(haveCastlingPiecesMoved(kingColour,pieces)){
            return false;
        }
        if(!doesDestinationMatchKingColour(kingColour,kingFinalRow ,kingFinalColumn)){
            return false;
        }
        if(areTilesTravelledThroughInCheck(kingColour,kingFinalRow,kingFinalColumn,board)){
            return false;
        }
    return true;
    }

    public static boolean isEnPassantEligible(Piece attackingPawn, int destinationRow, int destinationCol,Move lastMove, Piece[][] board){
       if(attackingPawn.getType()!=PieceType.PAWN){
            return false;
        }
        if(!wasLastMoveAPawnMoveOfOpposingColour(attackingPawn,lastMove,board)){
            return false;
        }
        if(!lastMoveWasADoubleJump(lastMove)){
            return false;
        }
        if(!isOpponentInCorrectPositionForEnpassantCapture(attackingPawn,destinationRow,destinationCol,lastMove)){
            return false;
        }

        return true;
    }

    private static boolean isOpponentInCorrectPositionForEnpassantCapture(Piece attackingPawn, int destinationRow, int destinationCol, Move lastMove) {
   Colour attackingPawnColour = attackingPawn.getColour();
        final int capturePawnRow = lastMove.getEnd().x;
        final int capturePawnCol = lastMove.getEnd().y;
        if(destinationCol!=capturePawnCol){
            return false;
        }

        if(attackingPawnColour==Colour.BLACK && capturePawnRow==4){
    return true;
        }
        else if(attackingPawnColour==Colour.WHITE && capturePawnRow==3){
    return true;
        }
return false;
    }


    private static boolean lastMoveWasADoubleJump(Move lastMove) {
        final int startingRow = lastMove.getStart().x;
        final int endingRow = lastMove.getEnd().x;
        final int rowMovement = Math.abs(endingRow-startingRow);

        return rowMovement==2;
    }

    private static boolean wasLastMoveAPawnMoveOfOpposingColour(Piece atttackingPawn, Move lastMove, Piece[][] board) {

        Point lastMovePosition = lastMove.getEnd();
        Colour requiredPawnCaptureColour = returnOpposingAlliance(atttackingPawn.getColour());
        return board[lastMovePosition.x][lastMovePosition.y].getType()==PieceType.PAWN &&board[lastMovePosition.x][lastMovePosition.y].getColour() ==requiredPawnCaptureColour;
    }

    private static boolean areTilesTravelledThroughInCheck(Colour kingColour, int kingFinalRow, int kingFinalColumn, Board board) {
     HashSet<Point> tilesTravelledThroughDuringCastle = getTilesTravelledThroughAndOnWhichAreAttacked(kingColour,  kingFinalRow,  kingFinalColumn, board.getGamePieces());
        Colour opposingColour = returnOpposingAlliance(kingColour);

       return doMovesAttackSquare(tilesTravelledThroughDuringCastle,board.getGamePieces(),getAllPseudoLegalMoves(getActivePiecesOfAlliance(opposingColour,board.getGamePieces()),board));
    }

    private static HashSet<Point> getTilesTravelledThroughAndOnWhichAreAttacked(Colour kingColour, int kingFinalRow, int kingFinalColumn, Piece[][] board) {
        HashSet<Point> squaresKingMovesThrough = new HashSet<>(2);
        if(kingColour==Colour.WHITE && kingFinalColumn==6){
            squaresKingMovesThrough.add(new Point(7,5));
            squaresKingMovesThrough.add(new Point(7,6));
        }
       else if(kingColour==Colour.WHITE && kingFinalColumn==2){
            squaresKingMovesThrough.add(new Point(7,2));
            squaresKingMovesThrough.add(new Point(7,3));
        }
        else if(kingColour==Colour.BLACK && kingFinalColumn==2){
            squaresKingMovesThrough.add(new Point(0,2));
            squaresKingMovesThrough.add(new Point(0,3));
        }
        else if(kingColour==Colour.BLACK && kingFinalColumn==6){
            squaresKingMovesThrough.add(new Point(0,5));
            squaresKingMovesThrough.add(new Point(0,6));
        }
        else {
            throw new RuntimeException("illegal Castle Request, control flow should have stopped this");
        }
        return squaresKingMovesThrough;
    }
    private static boolean areTilesBetweenKingAndRookEmpty(Colour kingColour, int kingFinalColumn, Piece[][] board) {
        if(kingColour==Colour.WHITE && kingFinalColumn==6){
                return PieceUtils.isBoardTileEmpty(board,7,5) &&  PieceUtils.isBoardTileEmpty(board,7,6);
        }
        else if(kingColour==Colour.WHITE && kingFinalColumn==2){
            return PieceUtils.isBoardTileEmpty(board,7,1) &&  PieceUtils.isBoardTileEmpty(board,7,2)&&  PieceUtils.isBoardTileEmpty(board,7,3);
        }
        else if(kingColour==Colour.BLACK && kingFinalColumn==2){
            return PieceUtils.isBoardTileEmpty(board,0,1) &&  PieceUtils.isBoardTileEmpty(board,0,2)&&  PieceUtils.isBoardTileEmpty(board,0,3);
        }
        else if(kingColour==Colour.BLACK && kingFinalColumn==6){
            return PieceUtils.isBoardTileEmpty(board,0,5) &&  PieceUtils.isBoardTileEmpty(board,0,6);
        }
        return false;
    }

    private static boolean doesDestinationMatchKingColour(Colour kingColour, int kingFinalRow, int kingFinalColumn) {
        return kingColour == Colour.BLACK && kingFinalRow == 0 && (kingFinalColumn == 2 || kingFinalColumn == 6) || kingColour == Colour.WHITE && kingFinalRow == 7 && (kingFinalColumn == 2 || kingFinalColumn == 6);
    }

    private static boolean haveCastlingPiecesMoved(Colour kingColour, Piece[][] board){
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(board[row][col].getColour()==kingColour && (board[row][col].getType()==PieceType.KING || board[row][col].getType()==PieceType.ROOK) && board[row][col].hasMovedFromStartingPosition()){
                  return true;
                }
            }
        }
        return false;
    }

    public static boolean isKingSafe(final Colour colourOfKing, Board board){
        ArrayList<Piece> opposingPieces;
        Colour opposingColour = returnOpposingAlliance(colourOfKing);
        opposingPieces = getActivePiecesOfAlliance(opposingColour,board.getGamePieces());
        HashSet<Move> opposingMoves = getAllPseudoLegalMoves(opposingPieces,board);

        
        return !doMovesCaptureKing(colourOfKing,board.getGamePieces(),opposingMoves);
    }


    public static boolean isKingSafeAfterMove(final Colour colourOfKing,Board board, Move move){
        Board boardClone = SerializationUtils.clone(board);
        Piece[][] piecesClone = boardClone.getGamePieces();

        int startingRow = move.getStart().x;
        int startingCol = move.getStart().y;
        int endingRow = move.getEnd().x;
        int endingCol = move.getEnd().y;

        Piece pieceToMove = (piecesClone[startingRow][startingCol])                                                                                                                                                                                                              ;


        pieceToMove.setX_position(endingRow);
        pieceToMove.setY_position(endingCol);

        piecesClone[startingRow][startingCol] = new Blank(startingRow,startingCol);


        piecesClone[endingRow][endingCol] = pieceToMove;
        boardClone.setPiecesOnBoard(piecesClone);



        return isKingSafe(colourOfKing,boardClone);
    }

    public static boolean isInStalemate(final Colour colour, Game game){

        Game copyOfGame = SerializationUtils.clone(game);
        Set<Move> possibleMoves = getAllPseudoLegalMoves(getActivePiecesOfAlliance(colour,copyOfGame.gameBoard.getGamePieces()),copyOfGame.gameBoard);
        Set<Move> newPossibleMoves = new HashSet<>(possibleMoves.size());
        newPossibleMoves.addAll(possibleMoves);
        for(Move m : newPossibleMoves){
            Cloner cloner = new Cloner();
            Game loopCopy = cloner.deepClone(game);


            if(loopCopy.gameBoard.executeMove(m)){
                return false;
            }
        }
        return true;
    }


    private static boolean doMovesCaptureKing(final Colour colourOfKing,Piece[][] board, HashSet<Move> opposingMoves ){
        HashSet<Point> kingLocation = new HashSet<>(1);
        kingLocation.add(getKingLocation(colourOfKing,board));
        return doMovesAttackSquare(kingLocation,board,opposingMoves);
    }

    private static boolean doMovesAttackSquare(HashSet<Point> friendlyPositions, Piece[][] board, HashSet<Move> opposingMoves ){
        for (Move move: opposingMoves){
            if(friendlyPositions.contains(move.getEnd())){
            //    System.out.println("Move that can take the square" + move.toString());
                return true;
            }
        }
        return false;
    }

    private static Point getKingLocation(final Colour colourOfKing, Piece[][] board){
        Point kingLocation = new Point();
        for (int row = 0; row < 8 ; row++) {
            for (int col = 0; col <8 ; col++) {
                if(board[row][col].getType()==PieceType.KING && board[row][col].getColour()==colourOfKing){
                    kingLocation.setLocation(row,col);
                    return kingLocation;
                }
            }
        }
        throw new IllegalStateException("King not found on board");
    }

    public static ArrayList<Piece> getActivePiecesOfAlliance(Colour colour, Piece[][] board){
        ArrayList<Piece> opposingPieces = new ArrayList<>();

        for (int row = 0; row < 8 ; row++) {
            for (int col = 0; col <8 ; col++) {
                if(board[row][col].getColour()==colour){
                    opposingPieces.add(board[row][col]);
                }
            }
        }
        return opposingPieces;
    }

    public static HashSet<Move> getAllPseudoLegalMoves(ArrayList<Piece> pieces, Board board){

        HashSet<Move> allMoves = new HashSet<>();
        for(Piece piece: pieces){
            allMoves.addAll(piece.generateAllPseudoLegalMoves(board));
        }
        return allMoves;
    }

    private static Colour returnOpposingAlliance(Colour colour){
        if(colour==Colour.WHITE){
            return Colour.BLACK;
        }
        else if(colour == Colour.BLACK){
            return Colour.WHITE;
        }
        else{
            throw new IllegalArgumentException("Colour must be black or white");
        }
    }



    public static boolean isStraightPathValid(Piece pieceToMove, final int x_destination, final int y_destination, Piece[][] board){
      final int x_initial = pieceToMove.getX_position();
      final int y_initial = pieceToMove.getY_position();
        if ((x_initial < 0 || x_initial > 7) || (x_destination < 0 || x_destination > 7) || (y_initial < 0 || y_initial > 7) || (y_destination < 0 || y_destination > 7)) {
        throw new IllegalStateException("Piece position/destination requirements are out of range");

        }

        boolean horizontalPathDirection = true;
        if(x_destination!=x_initial){
            horizontalPathDirection = false;
        }


        if(x_initial!=x_destination && y_initial!=y_destination){
            return false; // the path is not straight
        }

        if(horizontalPathDirection){
            ///
      return isHorizontalPathValid(pieceToMove, y_destination, board);
        }
        ///
        else {
     return isVerticalPathValid(pieceToMove, x_destination, board);

        }



    }

    private static boolean isHorizontalPathValid(Piece pieceToMove, int y_destination, Piece[][] board){
          final  int y_initial = pieceToMove.getY_position();
          final int row = pieceToMove.getX_position();
            boolean decrementThroughBoard = (y_initial>=y_destination); //

                if(decrementThroughBoard){
                    for(int i= y_initial-1; i>y_destination; i--){
                        if(board[row][i].getType()!= PieceType.BLANK){ //if leading spaces up to the final destination are not blank, then the path is not valid
                            return false;
                        }
                    }

                    if(board[row][y_destination].getColour()==pieceToMove.getColour()){ //if the final location is not blank or an enemy piece
                        return false;
                    }

                }
            else{
                    for(int i= y_initial+1; i<y_destination; i++){
                        if(board[row][i].getType() != PieceType.BLANK){
                            return false;
                        }
                    }

                    if(board[row][y_destination].getColour()==pieceToMove.getColour()){
                        return false; //horizontal path - increment - last piece is the same colour
                    }


                }
        return true;
    }

    private static boolean isVerticalPathValid(Piece pieceToMove, int x_destination, Piece[][] board){
        final int x_initial = pieceToMove.getX_position();
        final int column = pieceToMove.getY_position();
        boolean decrementThroughBoard = (x_initial>=x_destination);

        if(decrementThroughBoard){
            for(int i=x_initial-1; i>x_destination; i--){
                if(board[i][column].getType() != PieceType.BLANK){
                    return false;
                }
            }
            if(board[x_destination][column].getColour() == pieceToMove.getColour()){
                return false;
            }

        }

        else {
            for(int i=x_initial+1; i<x_destination; i++){
                if(board[i][column].getType() != PieceType.BLANK){
                    return false;
                }
            }
            if((board[x_destination][column].getColour() == pieceToMove.getColour())){
                return false;
            }

        }

        return true;
    }

    public static boolean isDiagonalPathValid(Piece pieceToMove, final int x_destination, final int y_destination, Piece[][] board){
        final int x_initial = pieceToMove.getX_position();
        final int y_initial = pieceToMove.getY_position();
        final int x_offset = x_destination-x_initial;
        final int y_offset = y_destination-y_initial;
        final int decrementX;
        final int decrementY;

            if(Math.abs(x_offset)!=Math.abs(y_offset)){
            return false;
            }
        if(x_offset<0){
            decrementX = -1;
        }
        else {
            decrementX = 1;
        }
        if(y_offset<0){
            decrementY= -1;
        }
        else {
            decrementY = 1;
        }
        for(int i=1; i<Math.abs(x_offset); i++){
            if(board[x_initial + i*decrementX][y_initial + i*decrementY].getType()!=PieceType.BLANK){
                return false;
            }
        }
        if(board[x_destination][y_destination].getColour()== pieceToMove.getColour()){
            return false;
        }

return true;
    }


    public static Point returnRookPositionBeforeCastling(int x_destination, int y_destination) {
        Point rookPositionBeforeCastlingMove =new Point();
        if (x_destination==7){
            if(y_destination==6){
                rookPositionBeforeCastlingMove.setLocation(7,7);
            }
            else if(y_destination==2){
                rookPositionBeforeCastlingMove.setLocation(7,0);
            }
        }
        else if(x_destination==0){
            if(y_destination==6){
                rookPositionBeforeCastlingMove.setLocation(0,7);
            }
            else if(y_destination==2){
                rookPositionBeforeCastlingMove.setLocation(0,0);
            }

        }
        return rookPositionBeforeCastlingMove;
    }
    public static Point returnRookPositionAfterCastling(int x_destination, int y_destination) {
        Point rookPositionAfterCastlingMove =new Point();
        if (x_destination==7){
            if(y_destination==6){
                rookPositionAfterCastlingMove.setLocation(7,5);
            }
            else if(y_destination==2){
                rookPositionAfterCastlingMove.setLocation(7,3);
            }
        }
        else if(x_destination==0){
            if(y_destination==6){
                rookPositionAfterCastlingMove.setLocation(0,5);
            }
            else if(y_destination==2){
                rookPositionAfterCastlingMove.setLocation(0,3);
            }

        }
        return rookPositionAfterCastlingMove;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
