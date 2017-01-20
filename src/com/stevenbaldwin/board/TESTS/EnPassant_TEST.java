package com.stevenbaldwin.board.TESTS;
//  Created by Steven J Baldwin  on 2016-10-11.

import com.stevenbaldwin.CommandLineView;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnPassant_TEST {
    @Test
    public void isEnPassantEligible() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', 'p', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', ' ', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);
        board.executeMove(6,0,5,0);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,3,3,3);


        Piece[][] gamePieces = board.getGamePieces();

        Assert.assertEquals(true, BoardEvaluator.isEnPassantEligible(gamePieces[3][4],2,3,board.getPerformedMoves().peek(),gamePieces));


    }
    @Test
    public void isEnPassantEligible2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', 'p', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', ' ', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,0,5,0);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,3,3,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());


        Piece[][] gamePieces = board.getGamePieces();

        assertEquals(true,BoardEvaluator.isEnPassantEligible(gamePieces[3][4],2,3,board.getPerformedMoves().peek(),gamePieces));


    }
    @Test
    public void isEnPassantEligible3() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', 'p', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', ' ', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,0,5,0);
        board.executeMove(1,4,2,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(2,4,3,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());



        Piece[][] gamePieces = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isEnPassantEligible(gamePieces[3][5],2,4,board.getPerformedMoves().peek(),gamePieces));


    }
    @Test
    public void isEnPassantEligible5() throws Exception {
        final char[][] DEFAULT = {
///////////////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', 'p', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', ' ', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);
        board.executeMove(6,0,5,0); //useless white move
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,4,3,4);

        CommandLineView.printBoardToConsole(board.getGamePieces());



        Piece[][] gamePieces = board.getGamePieces();

        assertEquals(true,BoardEvaluator.isEnPassantEligible(gamePieces[3][5],2,4,board.getPerformedMoves().peek(),gamePieces));


    }
    @Test
    public void isEnPassantEligible4() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', 'p', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', ' ', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,0,5,0);
        board.executeMove(1,4,3,4);

        CommandLineView.printBoardToConsole(board.getGamePieces());



        Piece[][] gamePieces = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isEnPassantEligible(gamePieces[3][5],2,6,board.getPerformedMoves().peek(),gamePieces));


    }
    @Test
    public void isEnPassantEligible6() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', 'p', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', ' ', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,0,5,0);
        board.executeMove(1,4,3,4);

        CommandLineView.printBoardToConsole(board.getGamePieces());



        Piece[][] gamePieces = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isEnPassantEligible(gamePieces[3][5],2,5,board.getPerformedMoves().peek(),gamePieces));


    }
    @Test
    public void isEnPassantEligible7() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {' ', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {'P', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,1,4,1);

        CommandLineView.printBoardToConsole(board.getGamePieces());



        Piece[][] gamePieces = board.getGamePieces();

        assertEquals(true,BoardEvaluator.isEnPassantEligible(gamePieces[4][0],5,1,board.getPerformedMoves().peek(),gamePieces));


    }
    @Test
    public void isEnPassantEligible8() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {' ', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {'P', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,1,5,1);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(5,1,4,1);



        Piece[][] gamePieces = board.getGamePieces();
        assertEquals(false,BoardEvaluator.isEnPassantEligible(gamePieces[4][0],5,1,board.getPerformedMoves().peek(),gamePieces));

    }
    @Test
    public void isEnPassantPerformed() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {' ', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {'P', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,1,4,1);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(4,0,5,1);
        Piece[][] gamePieces = board.getGamePieces();
        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertTrue(gamePieces[4][1].getType()== PieceType.BLANK);
        assertTrue(gamePieces[5][1].getType()== PieceType.PAWN && gamePieces[5][1].getColour()== Colour.BLACK);




    }
}
