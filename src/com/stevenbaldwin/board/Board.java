package com.stevenbaldwin.board;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.Move;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import com.stevenbaldwin.pieces.*;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static com.stevenbaldwin.enums.Colour.BLACK;
import static com.stevenbaldwin.enums.Colour.WHITE;

public final class Board  implements Serializable{
    ///FIELDS
   private boolean whitePlayersTurn =true;

    private  Stack<Move> performedMoves;
 private    ArrayList<Piece> capturedPieces;
    private Piece[][] piecesOnBoard;
    public Board(char[][] startingBoard){
        piecesOnBoard = new Piece[8][8];
        fillStartingBoard(startingBoard);
        performedMoves = new Stack<>();
        capturedPieces = new ArrayList<>();
    }

    public void setPiecesOnBoard(Piece[][] piecesOnBoard) {
        this.piecesOnBoard = piecesOnBoard;
    }

    public ArrayList<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public Stack<Move> getPerformedMoves() {
        return performedMoves;
    }

    ///METHODS
    public Piece[][] getGamePieces() {
        return piecesOnBoard;
    }

    public boolean isWhitePlayersTurn() {
        return whitePlayersTurn;
    }

    private boolean isCorrectTurn(Piece pieceToMove){
            if (pieceToMove.getColour()==WHITE && whitePlayersTurn){
                return true;
            }
            else if(pieceToMove.getColour()==BLACK && !whitePlayersTurn){
                return true;
            }
            else { ///TODO FIX THIS, only used for debugging!!!
                return false;
            }
        }
    public boolean executeMove(Move move){
        return executeMove(move.getStart().x,move.getStart().y,move.getEnd().x,move.getEnd().y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (whitePlayersTurn != board.whitePlayersTurn) return false;
        if (capturedPieces != null ? !capturedPieces.equals(board.capturedPieces) : board.capturedPieces != null)
            return false;
        return Arrays.deepEquals(piecesOnBoard, board.piecesOnBoard);

    }

    @Override
    public int hashCode() {
        int result = (whitePlayersTurn ? 1 : 0);
        result = 31 * result + (capturedPieces != null ? capturedPieces.hashCode() : 0);
        result = 31 * result + Arrays.deepHashCode(piecesOnBoard);
        return result;
    }

    public boolean executeMove(int x_initial, int y_initial, int x_destination, int y_destination){
        Piece pieceToMove = piecesOnBoard[x_initial][y_initial];
        Colour colourOfPieceToMove = pieceToMove.getColour();
        if(isCorrectTurn(pieceToMove) && isStandardMoveLegal(x_initial, y_initial, x_destination, y_destination)) {
            if (PieceUtils.isBoardTileOccupiedByOpponent(piecesOnBoard, x_destination, y_destination, piecesOnBoard[x_initial][y_initial])) {
                capturedPieces.add(piecesOnBoard[x_destination][y_destination]);
            }
            movePiece(x_initial, y_initial, x_destination, y_destination);
            toggleTurn();
            return true;

        }
        //non-standard moves
       else if(pieceToMove.getType()!= PieceType.BLANK && isCorrectTurn(pieceToMove)) {
            if (BoardEvaluator.isCastleEligible(colourOfPieceToMove, x_destination, y_destination, this)) {
                return performCastle(x_initial, y_initial, x_destination, y_destination);
            }
            else if  (!performedMoves.empty() && BoardEvaluator.isEnPassantEligible(pieceToMove, x_destination, y_destination, performedMoves.peek(), piecesOnBoard)) {
                return performEnPassant(x_initial, y_initial, x_destination, y_destination, colourOfPieceToMove);

            }
        }

        return false;
    }

    private boolean performEnPassant(int x_initial, int y_initial, int x_destination, int y_destination, Colour colourOfPieceToMove) {
        int removePieceAtRow;
        if(colourOfPieceToMove==BLACK){
            removePieceAtRow = x_destination - 1;
        }
        else if(colourOfPieceToMove==WHITE){
            removePieceAtRow = x_destination+1;
        }
        else {
            throw new IllegalStateException("empty tile cannot perform enpassant!");
        }

        removePieceFromBoard(removePieceAtRow, y_destination);
        movePiece(x_initial, y_initial, x_destination, y_destination);
        toggleTurn();
        return true;
    }

    private boolean performCastle(int x_initial, int y_initial, int x_destination, int y_destination) {
        Point rookBeforeCastlePosition = BoardEvaluator.returnRookPositionBeforeCastling(x_destination, y_destination);
        Point rookAfterCastlePosition = BoardEvaluator.returnRookPositionAfterCastling(x_destination, y_destination);
        movePiece(rookBeforeCastlePosition.x, rookBeforeCastlePosition.y, rookAfterCastlePosition.x, rookAfterCastlePosition.y);

        performedMoves.pop(); //castling rook doesn't count as a move!
        movePiece(x_initial, y_initial, x_destination, y_destination);
        toggleTurn();
        return true;
    }

    public Point tilesEligibleForPawnPromotion() {
        for (int col = 0; col < 8; col++) {
            if(piecesOnBoard[0][col].getType()==PieceType.PAWN && piecesOnBoard[0][col].getColour()==WHITE){
                return new Point(0,col);
            }
            if(piecesOnBoard[7][col].getType()==PieceType.PAWN && piecesOnBoard[7][col].getColour()==BLACK){
                return new Point(7,col);
            }
        }
        return null;
    }

    private void movePiece(int x_initial, int y_initial, int x_destination, int y_destination){
        piecesOnBoard[x_initial][y_initial].setX_position(x_destination);
        piecesOnBoard[x_initial][y_initial].setY_position(y_destination);
        Piece movedPiece = piecesOnBoard[x_initial][y_initial];
        movedPiece.setMovedFromStartingPosition(true);
        piecesOnBoard[x_initial][y_initial] = new Blank(x_initial,y_initial);
        piecesOnBoard[x_destination][y_destination] = movedPiece;
        Move performedMove = new Move(x_initial,y_initial,x_destination,y_destination);

        performedMoves.push(performedMove);

    }
    private void toggleTurn(){
whitePlayersTurn = !whitePlayersTurn;
}
    private void removePieceFromBoard(int row, int col){
        capturedPieces.add(piecesOnBoard[row][col]);
        piecesOnBoard[row][col] = new Blank(row,col);
    }

    public boolean isStandardMoveLegal(final int x_start, final int y_start, final int x_destination, final int y_destination){
        if(x_start<0 || x_start>7 || y_start<0 || y_start>7 || x_destination<0 || x_destination>7 || y_destination<0 || y_destination>7){
            return false;
        }
        return piecesOnBoard[x_start][y_start].isLegalMove(x_destination,y_destination,this);
    }

    public Piece[][] getGameBoardClone(){
        return piecesOnBoard.clone();
    }





    private void fillStartingBoard(char[][] startingBoard) {

     for(int row =0; row<8; row++){
         for(int col =0; col<8; col++){
            switch (startingBoard[row][col]){
                case ' ':
                    piecesOnBoard[row][col] = new Blank(row,col);
                    break;
                case 'R':
                    piecesOnBoard[row][col] = new Rook(BLACK,row,col);
                    break;
                case 'r':
                    piecesOnBoard[row][col] = new Rook(WHITE,row,col);
                    break;
                case 'A':
                    piecesOnBoard[row][col] = new King(BLACK,row,col);
                    break;
                case 'a':
                    piecesOnBoard[row][col] = new King(WHITE,row,col);
                    break;
                case 'Q':
                    piecesOnBoard[row][col] = new Queen(BLACK,row,col);
                    break;
                case 'q':
                    piecesOnBoard[row][col] = new Queen(WHITE,row,col);
                    break;
                case 'B':
                    piecesOnBoard[row][col] = new Bishop(BLACK,row,col);
                    break;
                case 'b':
                    piecesOnBoard[row][col] = new Bishop(WHITE,row,col);
                    break;
                case 'P':
                    piecesOnBoard[row][col] = new Pawn(BLACK,row,col);
                    break;
                case 'p':
                    piecesOnBoard[row][col] = new Pawn(WHITE,row,col);
                    break;
                case 'K':
                    piecesOnBoard[row][col] = new Knight(BLACK,row,col);
                    break;
                case 'k':
                    piecesOnBoard[row][col] = new Knight(WHITE,row,col);
                    break;
                default:
                    throw new RuntimeException("Invalid Input");
                }




            }
         }
     }


 } // end of class


