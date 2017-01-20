package com.stevenbaldwin.board.TESTS;
//  Created by Steven J Baldwin  on 2016-10-06.

import com.stevenbaldwin.CommandLineView;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class executeMove_TEST {
    @Test
    public void executeMoves() throws Exception {
        final char[][] DEFAULT = {
                {'R','K','B','Q','A','B','K','R'},
                {'P','P','P','P','P','P','P','P'},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {' ',' ',' ',' ',' ',' ',' ',' '},
                {'p','p','p','p','p','p','p','p'},
                {'r','k','b','q','a','b','k','r'},
        };


        Board board = new Board(DEFAULT);
        board.executeMove(6,2,5,2);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,0,2,0);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(5,2,4,2);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(2,0,3,0);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(4,2,3,2);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(3,0,4,0);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(3,2,2,2);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(4,0,5,0);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(2,2,1,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(0,3,1,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,3,0,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        ArrayList<Point> actualCapturedPieceCoordinates = new ArrayList<>();
        for (Piece capPiece: board.getCapturedPieces()) {
            actualCapturedPieceCoordinates.add(capPiece.getPostion());
        }

        ArrayList<Point> expectedCapturedPieceCoordinates = new ArrayList<>();
        expectedCapturedPieceCoordinates.add(new Point(1,3));
        expectedCapturedPieceCoordinates.add(new Point(1,3));

        assertEquals(expectedCapturedPieceCoordinates,actualCapturedPieceCoordinates);
    }


}
