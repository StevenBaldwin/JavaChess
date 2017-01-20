package com.stevenbaldwin.pieces.TESTS;

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;

//  Created by Steven J Baldwin  on 2016-09-22.

public class KnightTest {
    @Test
    public void isLegalMove_TEST() throws Exception {
        final char[][] DEFAULT ={
         //////// 0   1   2   3   4   5   6   7
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


        assertEquals(true , board.isStandardMoveLegal(7,1,5,2));
        assertEquals(false , board.isStandardMoveLegal(-1,1,5,2));
    }
    @Test
    public void isLegalMove_TEST2() throws Exception {
        final char[][] DEFAULT ={
         //////// 0   1   2   3   4   5   6   7
       /* 0*/   {'R','K','B','Q','A','B','K','R'},
       /* 1*/   {'P','P','P','P','P','P','P','P'},
       /* 2*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 3*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 4*/   {' ',' ','k',' ',' ',' ',' ',' '},
       /* 5*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 6*/   {'p','p','p','p','p','p','p','p'},
       /* 7*/   {'r',' ','b','q','a','b','k','r'},
           //////// 0   1   2   3   4   5   6   7
//       /* 0*/   {'R','K','B','Q','A','B','K','R'},
//       /* 1*/   {'P','P','P','P','P','P','P','P'},
//       /* 2*/   {' ','x',' ','x',' ',' ',' ',' '},
//       /* 3*/   {'x',' ',' ',' ','x',' ',' ',' '},
//       /* 4*/   {' ',' ','k',' ',' ',' ',' ',' '},
//       /* 5*/   {'x',' ',' ',' ','x',' ',' ',' '},
//       /* 6*/   {'p','p','p','p','p','p','p','p'},
//       /* 7*/   {'r',' ','b','q','a','b','k','r'},
        };
        Board board = new Board(DEFAULT);


        assertEquals(true , board.isStandardMoveLegal( 4,2, 3,0));
        assertEquals(true , board.isStandardMoveLegal( 4,2, 2,1));
        assertEquals(true , board.isStandardMoveLegal( 4,2, 2,3));
        assertEquals(true , board.isStandardMoveLegal( 4,2, 3,4));
        assertEquals(true , board.isStandardMoveLegal( 4,2, 5,0));
        assertEquals(true , board.isStandardMoveLegal( 4,2, 5,4));

        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,0));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,1));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,3));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,4));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 0,7));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,0));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,1));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,3));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,4));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 1,7));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 2,0));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 2,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 2,4));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 2,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 2,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 2,7));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 3,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 3,3));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 3,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 3,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 3,7));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,0));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,1));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,3));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,4));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 4,7));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 5,1));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 5,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 5,3));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 5,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 5,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 5,7));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,0));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,1));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,3));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,4));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 6,7));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,0));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,1));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,2));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,3));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,4));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,5));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,6));
        assertEquals(false , board.isStandardMoveLegal( 4,2, 7,7));
    }
    @Test
    public void generateAllPseudoLegalMoves() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', 'b', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', 'p', ' ', ' ', ' ', 'p', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', 'a', 'b', 'k', 'r'},
        };


        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(7,1,5,2));
        expectedMoves.add(new Move(7,1,5,0));

        Assert.assertEquals(expectedMoves,gameBoard[7][1].generateAllPseudoLegalMoves(board));
    }
    @Test
    public void generateAllPseudoLegalMoves2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', 'k', 'b', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', 'p', ' ', ' ', ' ', 'p', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', 'p', 'p'},
       /* 7*/   {'r', ' ', ' ', 'q', 'a', 'b', 'k', 'r'},
        };
        final int x = 2;
        final int y = 2;

        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(x,y,0,1));
        expectedMoves.add(new Move(x,y,1,0));
        expectedMoves.add(new Move(x,y,0,3));
        expectedMoves.add(new Move(x,y,1,4));
        expectedMoves.add(new Move(x,y,3,0));
        expectedMoves.add(new Move(x,y,3,4));
        expectedMoves.add(new Move(x,y,4,3));

        Assert.assertEquals(expectedMoves,gameBoard[x][y].generateAllPseudoLegalMoves(board));
    }


}