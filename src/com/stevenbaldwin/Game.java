package com.stevenbaldwin;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.pieces.Knight;
import com.stevenbaldwin.pieces.Piece;
import com.stevenbaldwin.pieces.Queen;
import com.stevenbaldwin.pieces.Rook;

import java.awt.*;
import java.io.Serializable;
import java.util.HashSet;

public class Game implements Serializable {

  public   Board gameBoard;
    public Game(Board gameBoard){
        this.gameBoard = gameBoard;

    }

    protected boolean isInCheckMate(Colour colour){
        if(colour==Colour.WHITE && !BoardEvaluator.isKingSafe(colour,gameBoard) && gameBoard.isWhitePlayersTurn()){
          HashSet<Move> allMoves = BoardEvaluator.getAllPseudoLegalMoves(BoardEvaluator.getActivePiecesOfAlliance(Colour.WHITE,gameBoard.getGamePieces()),gameBoard);
            for(Move m: allMoves){
                if (BoardEvaluator.isKingSafeAfterMove(Colour.WHITE,gameBoard,m)){
                    return false;
                }
            }

            return true;
        }
        if(colour==Colour.BLACK && !BoardEvaluator.isKingSafe(colour,gameBoard) && !gameBoard.isWhitePlayersTurn()){
            HashSet<Move> allMoves = BoardEvaluator.getAllPseudoLegalMoves(BoardEvaluator.getActivePiecesOfAlliance(Colour.BLACK,gameBoard.getGamePieces()),gameBoard);
            for(Move m: allMoves){
                System.out.println(m);
                if(m.equals(new Move(0,4,0,3))){
                    BoardEvaluator.isKingSafeAfterMove(Colour.BLACK,gameBoard,m);
                }
                if (BoardEvaluator.isKingSafeAfterMove(Colour.BLACK,gameBoard,m)){
                    return false;
                }
            }

            return true;
        }
        return false;
    }


    public Board getGameBoard() {
        return gameBoard;
    }

    public void performPawnPromotion(Point tilePositionOfPromotion, char c) {
        int row = (int) tilePositionOfPromotion.getX();
        int col = (int) tilePositionOfPromotion.getY();
        Colour colour;
        colour = getColourOfPromotedPiece(row);


        Piece newPiece = getNewPieceType(row,col,colour,c);
        Piece[][] actualPieces = gameBoard.getGamePieces();
        actualPieces[row][col] = newPiece;
    }

    private Piece getNewPieceType(int row, int col, Colour colour, char c) {
        Piece newPiece;
        switch (c) {
            case 'q':
                newPiece = new Queen(colour,row,col);
                break;
            case 'k':
                newPiece = new Knight(colour,row,col);
                break;
            case 'r':
                newPiece = new Rook(colour,row,col);
                break;
            default:
                throw new IllegalStateException("Promotion type not supported");

        }
        return newPiece;
    }

    private Colour getColourOfPromotedPiece(int row) {
        Colour colour;
        switch (row){
            case 0:
                colour = Colour.WHITE;
                break;
            case 7:
                colour = Colour.BLACK;
                break;
            default:
                throw new IllegalStateException("Pawn Promotion Not Eligible");

        }
        return colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return gameBoard != null ? gameBoard.equals(game.gameBoard) : game.gameBoard == null;

    }

    @Override
    public int hashCode() {
        return gameBoard != null ? gameBoard.hashCode() : 0;
    }
}
