package com.stevenbaldwin.pieces.TESTS;

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by Steven on 2016-09-25.
 */
public class KingTest {
    @Test
    public void isLegalMove() throws Exception {
        final char[][] DEFAULT ={
         //////// 0   1   2   3   4   5   6   7
       /* 0*/   {'R','K','B','Q','A','B','K','R'},

       /* 1*/   {'P','P','P','P','P','P','P','P'},

       /* 2*/   {' ',' ',' ',' ',' ',' ',' ',' '},

       /* 3*/   {' ',' ',' ',' ',' ',' ',' ',' '},

       /* 4*/   {' ',' ',' ',' ','a',' ',' ',' '},

       /* 5*/   {' ',' ',' ',' ',' ',' ',' ',' '},

       /* 6*/   {'p','p','p','p','p','p','p','p'},

       /* 7*/   {'r','k','b','q',' ','b','k','r'},
        };
        Board board = new Board(DEFAULT);

        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,0,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,1,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,2,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,3,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,3,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,3,2));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,3,3));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,3,4));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,3,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,3,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,3,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,4,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,4,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,4,2));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,4,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,4,4));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,4,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,4,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,4,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,5,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,5,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,5,2));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,5,3));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,5,4));
        assertEquals(true , board.isStandardMoveLegal( 4 , 4 ,5,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,5,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,5,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,6,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 4 ,7,7));

    }

    @Test
    public void generateAllPseudoLegalMoves() throws Exception {
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
        final int x = 7;
        final int y = 4;

        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(x,y,6,5));


        Assert.assertEquals(expectedMoves,gameBoard[x][y].generateAllPseudoLegalMoves(board));
    }
    @Test
    public void generateAllPseudoLegalMoves2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', 'k', 'b', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', 'p', ' ', ' ', 'a', 'p', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', ' ', 'p', 'p'},
       /* 7*/   {'r', ' ', ' ', 'q', ' ', 'b', 'k', 'r'},
        };
        final int x = 4;
        final int y = 4;

        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(x,y,3,3 ));
        expectedMoves.add(new Move(x,y, 3,4 ));
        expectedMoves.add(new Move(x,y, 3,5 ));
        expectedMoves.add(new Move(x,y, 4,3 ));
        expectedMoves.add(new Move(x,y, 5,3 ));
        expectedMoves.add(new Move(x,y, 5, 4));
        expectedMoves.add(new Move(x,y, 5,5 ));


        Assert.assertEquals(expectedMoves,gameBoard[x][y].generateAllPseudoLegalMoves(board));
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
        final int x = 4;
        final int y = 3;

        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(x,y, 3,2  ));
        expectedMoves.add(new Move(x,y, 3, 3 ));
        expectedMoves.add(new Move(x,y, 3,4  ));
        expectedMoves.add(new Move(x,y, 4,2  ));
        expectedMoves.add(new Move(x,y, 4,4  ));
        expectedMoves.add(new Move(x,y, 5, 2 ));
        expectedMoves.add(new Move(x,y, 5, 3 ));
        expectedMoves.add(new Move(x,y, 5,4  ));



        Assert.assertEquals(expectedMoves,gameBoard[x][y].generateAllPseudoLegalMoves(board));
    }

}