package com.stevenbaldwin.pieces.TESTS;

import com.stevenbaldwin.CommandLineView;
import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Steven on 2016-09-25.
 */
public class PawnTest {
    @Test
    public void isLegalMove() throws Exception {
        final char[][] DEFAULT ={
         //////// 0   1   2   3   4   5   6   7
       /* 0*/   {'R','K','B','Q','A','B','K','R'},
       /* 1*/   {'P',' ','P',' ','P','P','P','P'},
       /* 2*/   {' ','P',' ','P',' ',' ',' ',' '},
       /* 3*/   {' ',' ','p',' ',' ',' ',' ',' '},
       /* 4*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 5*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 6*/   {'p',' ','p','p','p','p','p','p'},
       /* 7*/   {'r','k','b','q','a','b','k','r'},
        };
        Board board = new Board(DEFAULT);
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,0));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,1));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,2));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,0,7));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,0));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,1));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,2));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,1,7));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,2,0));
        assertEquals(true , board.isStandardMoveLegal( 3 , 2 ,2,1));
        assertEquals(true , board.isStandardMoveLegal( 3 , 2 ,2,2));
        assertEquals(true , board.isStandardMoveLegal( 3 , 2 ,2,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,2,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,2,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,2,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,2,7));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,0));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,1));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,2));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,3,7));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,0));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,1));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,2));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,4,7));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,0));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,1));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,2));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,5,7));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,0));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,1));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,2));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,6,7));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,0));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,1));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,2));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,3));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,4));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,5));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,6));
        assertEquals(false , board.isStandardMoveLegal( 3 , 2 ,7,7));

    }

    @Test
    public void isLegalMove2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', ' ', 'P', ' ', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', 'P', ' ', 'P', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},
        };
        Board board = new Board(DEFAULT);

        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,1));
        assertEquals(true , board.isStandardMoveLegal( 6 , 2 ,4,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,1));
        assertEquals(true , board.isStandardMoveLegal( 6 , 2 ,5,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,7));
    }

    @Test
    public void isLegalMove3() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', ' ', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', 'P', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},
        };
        Board board = new Board(DEFAULT);

        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,0,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,1,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,2,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,3,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,1));
        assertEquals(true , board.isStandardMoveLegal( 6 , 2 ,4,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,4,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,1));
        assertEquals(true , board.isStandardMoveLegal( 6 , 2 ,5,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,5,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,6,7));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,0));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,1));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,2));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,3));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,4));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,5));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,6));
        assertEquals(false , board.isStandardMoveLegal( 6 , 2 ,7,7));
    }

    @Test
    public void generateAllPseudoLegalMoves() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', ' ', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', 'k', 'b', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', 'p', ' ', 'A', 'a', 'p', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', 'p', 'p'},
       /* 7*/   {'r', ' ', ' ', 'q', ' ', 'b', 'k', 'r'},
        };
        final int row = 1;
        final int col = 4;

        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(row,col,2,3));
        expectedMoves.add(new Move(row,col,2,4));
        expectedMoves.add(new Move(row,col,3,4));

        Assert.assertEquals(expectedMoves,gameBoard[row][col].generateAllPseudoLegalMoves(board));
    }
    @Test
    public void generateAllPseudoLegalMoves2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', ' ', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', 'k', 'b', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', 'p', ' ', 'A', 'a', 'p', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', 'p', 'p'},
       /* 7*/   {'r', ' ', ' ', 'q', ' ', 'b', 'k', 'r'},
        };
        final int row = 6;
        final int col = 4;

        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(row,col,5,4));



        Assert.assertEquals(expectedMoves,gameBoard[row][col].generateAllPseudoLegalMoves(board));
    }
    @Test
    public void generateAllPseudoLegalMoves3() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', ' ', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', 'k', 'b', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', 'p', ' ', 'A', 'a', 'p', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', 'p', 'p'},
       /* 7*/   {'r', ' ', ' ', 'q', ' ', 'b', 'k', 'r'},
        };
        final int row = 6;
        final int col = 6;

        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(row,col,5,6));
        expectedMoves.add(new Move(row,col,4,6));



        Assert.assertEquals(expectedMoves,gameBoard[row][col].generateAllPseudoLegalMoves(board));
    }

    @Test
    public void doublePawnJumpCapture() throws Exception {
        final char[][] DEFAULT ={
///////////////// 0   1   2   3   4   5   6   7
       /* 0*/   {'R','K','B','Q','A','B','K','R'},
       /* 1*/   {'P','P','P','P','P','P','P','P'},
       /* 2*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 3*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 4*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 5*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 6*/   {'p','p','p','p','p','p','p','p'},
       /* 7*/   {'r','k','b','q','a','b','k','r'},

        };


        Board board = new Board(DEFAULT);
        CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(6,2,4,2);CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,7,3,7);CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(4,2,3,2);CommandLineView.printBoardToConsole(board.getGamePieces());
        board.executeMove(1,2,3,2);CommandLineView.printBoardToConsole(board.getGamePieces());


       Piece[][] pieces = board.getGamePieces();
       assertTrue(pieces[3][2].getColour()== Colour.WHITE);

    }

}