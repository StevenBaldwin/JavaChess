package com.stevenbaldwin;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.PGNDataTests.PGNMove;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import com.stevenbaldwin.pieces.Piece;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class ViewController implements Serializable {
    CommandLineView view;
    Game game;
    public ViewController(CommandLineView view, Game game){
        this.view=view;
        this.game=game;
    }

//    public static void main(String args[]){
//
//
//        ViewController vc = new ViewController(new CommandLineView(), new Game(new Board(StartingConfiguration.DEFAULT)));
//
//        Point eligiblePromotionTile = vc.game.gameBoard.tilesEligibleForPawnPromotion();
//
//    }

    public void executePGNMoves(List<PGNMove> whiteMoves, List<PGNMove> blackMoves){
        for (int move = 0; move<lengthOfLongerList(whiteMoves,blackMoves); move++){
            PGNMove whiteMove = whiteMoves.get(move);
            PGNMove blackMove = blackMoves.get(move);
            executeSingularMove(whiteMove, Colour.WHITE);
            executeSingularMove(blackMove, Colour.BLACK);


        }

    }

    private void executeSingularMove(PGNMove move, Colour pieceToMoveColour) {
        PieceType pieceTypeToMove = move.getPieceToMove();
        final int startingRow = move.getStartingRow();
        final int startingCol = move.getStartingCol();
        Point destination = move.getDestination();
        final int rowDestination = (int)destination.getX();
        final int colDestination = (int)destination.getY();
        char promotion = move.getPromotion(); //todo implement;
        if(startingRow>=0 && startingCol>=0){
            game.gameBoard.executeMove(startingRow,startingCol,rowDestination,colDestination);
            CommandLineView.printBoardToConsole(game.getGameBoard().getGamePieces());
        }
        if(startingRow>=0){
            Piece[][] piecesOnBoard = game.gameBoard.getGamePieces();
            for (int col = 0; col < 8; col++) {
                if(piecesOnBoard[startingRow][col].getColour().equals(pieceToMoveColour) && piecesOnBoard[startingRow][col].getType().equals(pieceTypeToMove) && game.gameBoard.executeMove(startingRow,col,rowDestination,colDestination)){
                    CommandLineView.printBoardToConsole(game.getGameBoard().getGamePieces());
                    break;
                }
            }
        }
        if(startingCol>=0){
            Piece[][] piecesOnBoard = game.gameBoard.getGamePieces();
            for (int row = 0; row < 8; row++) {
                if(piecesOnBoard[row][startingCol].getColour().equals(pieceToMoveColour) && piecesOnBoard[row][startingCol].getType().equals(pieceTypeToMove) && game.gameBoard.executeMove(row,startingCol,rowDestination,colDestination)){
                    CommandLineView.printBoardToConsole(game.getGameBoard().getGamePieces());
                    break;
                }
            }
        }
        else {
            Piece[][] piecesOnBoard = game.gameBoard.getGamePieces();
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if(piecesOnBoard[row][col].getColour().equals(pieceToMoveColour) && piecesOnBoard[row][col].getType().equals(pieceTypeToMove) && game.gameBoard.executeMove(row,col,rowDestination,colDestination)){
                        CommandLineView.printBoardToConsole(game.getGameBoard().getGamePieces());
                        break;
                    }

                }
            }

        }

    }

    private static int lengthOfLongerList(List list1, List list2){
        return (list1.size()>list2.size()) ? list1.size(): list2.size();
    }

}
