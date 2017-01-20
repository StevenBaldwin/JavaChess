package com.stevenbaldwin.board.TESTS;
//  Created by Steven J Baldwin  on 2016-10-25.

import com.stevenbaldwin.*;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Perft_TESTS {
    @Test
    public void startingPosPerft(){
        Game game = new Game(new Board(StartingConfiguration.getDEFAULT()));
        ArrayList<Piece > allPieces = new ArrayList<>(20);
        Piece[][] board = game.getGameBoard().getGamePieces();


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].getType()!= PieceType.BLANK && board[i][j].getColour()== Colour.WHITE){
                    allPieces.add(board[i][j]);
                }
            }
        }
        assertEquals(20,BoardEvaluator.getAllPseudoLegalMoves(allPieces,game.gameBoard).size());

    }



}
