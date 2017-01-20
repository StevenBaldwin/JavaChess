package com.stevenbaldwin.board.TESTS;
//  Created by Steven J Baldwin  on 2016-10-07.

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

public class Castling_TESTS {
    @Test
    public void improperMovement_TEST() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},

        };

        Board board = new Board(DEFAULT);
       board.executeMove(6,4,4,4);
        board.executeMove(7,5,5,3);
        board.executeMove(7,6,5,5);
        board.executeMove(7,4,7,5);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        Assert.assertEquals(false, BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));

    }
    @Test
    public void properMovement_TEST() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},

        };

        Board board = new Board(DEFAULT);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(6,4,4,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,0,2,0);
        board.executeMove(7,5,5,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(2,0,3,0);
        board.executeMove(7,6,5,5);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(true,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void properPosition_TEST() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},

        };

        Board board = new Board(DEFAULT);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(6,4,4,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(7,5,5,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(7,6,5,5);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.WHITE,6,6,board));


    }
    @Test
    public void properPosition_TEST2() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},

        };

        Board board = new Board(DEFAULT);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(6,4,4,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(7,5,5,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(7,6,5,5);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.BLACK,1,3,board));


    }
    @Test
    public void areTilesBetweenKingAndRookEmpty() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},

        };

        Board board = new Board(DEFAULT);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(6,4,4,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(7,5,5,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(7,6,5,5);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(7,7,7,6);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void areTilesBetweenKingAndRookEmpty2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},

        };

        Board board = new Board(DEFAULT);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        board.executeMove(6,4,4,4);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,0,2,0);

        board.executeMove(7,5,5,3);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(2,0,3,0);

        board.executeMove(7,6,5,5);
        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(true,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void areTilesBetweenKingAndRookInCheck() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', 'R', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void areTilesBetweenKingAndRookInCheck2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'B'},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void isKingInCheck() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', 'B', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void isKingInCheck2() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', 'B', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(true,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void isSquareThreatened() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', ' ', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', 'K', ' ', 'B', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());

        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));


    }
    @Test
    public void performCastle() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', 'B', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        assertEquals(true,BoardEvaluator.isCastleEligible(Colour.WHITE,7,6,board));

        board.executeMove(7,4,7,6);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        Piece[][] gameBoard = board.getGamePieces();
        assertTrue(gameBoard[7][5].getType()== PieceType.ROOK &&gameBoard[7][5].getColour()== Colour.WHITE);
        assertTrue(gameBoard[7][6].getType()== PieceType.KING &&gameBoard[7][6].getColour()== Colour.WHITE);


    }
    @Test
    public void performCastleBlack() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', ' ', ' ', ' ', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', 'B', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        assertEquals(true,BoardEvaluator.isCastleEligible(Colour.BLACK,0,2,board));
        board.executeMove(6,2,5,2);

        board.executeMove(0,4,0,2);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        Piece[][] pieces = board.getGamePieces();

        assertTrue(pieces[0][2].getType()==PieceType.KING && pieces[0][2].getColour()==Colour.BLACK);
        assertTrue(pieces[0][3].getType()==PieceType.ROOK && pieces[0][3].getColour()==Colour.BLACK);
    }
    @Test
    public void performCastleUnderThreatBlack() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', ' ', ' ', ' ', 'A', 'B', 'K', ' '},
       /* 1*/   {'P', 'P', 'b', 'P', 'P', ' ', ' ', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', 'B', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', ' ', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', ' ', ' ', 'r'},

        };

        Board board = new Board(DEFAULT);

        CommandLineView.printBoardToConsole(board.getGamePieces());
        assertEquals(false,BoardEvaluator.isCastleEligible(Colour.BLACK,0,2,board));

        board.executeMove(0,4,0,1);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        Piece[][] pieces = board.getGamePieces();

        assertTrue(pieces[0][4].getType()==PieceType.KING && pieces[0][4].getColour()==Colour.BLACK);
        assertTrue(pieces[0][0].getType()==PieceType.ROOK && pieces[0][0].getColour()==Colour.BLACK);
    }
}
