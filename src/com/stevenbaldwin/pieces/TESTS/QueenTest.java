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
public class QueenTest {
    @Test
    public void isLegalMove() throws Exception {
        final char[][] DEFAULT ={
         //////// 0   1   2   3   4   5   6   7
       /* 0*/   {'R','K','B','Q','A','B','K','R'},
       /* 1*/   {'P','P','P','P','P','P','P','P'},
       /* 2*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 3*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 4*/   {' ',' ',' ','q',' ',' ',' ',' '},
       /* 5*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 6*/   {'p','p','p','p','p','p','p','p'},
       /* 7*/   {'r','k','b',' ','a','b','k','r'},
        };
        Board board = new Board(DEFAULT);
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,0,7));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,1,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,1,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,1,2));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,1,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,1,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,1,5));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,1,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,1,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,2,0));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,2,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,2,2));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,2,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,2,4));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,2,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,2,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,2,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,3,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,3,1));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,3,2));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,3,3));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,3,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,3,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,3,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,3,7));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,4,0));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,4,1));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,4,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,4,3));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,4,4));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,4,5));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,4,6));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,4,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,5,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,5,1));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,5,2));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,5,3));
        assertEquals(true , board.isStandardMoveLegal( 4 , 3 ,5,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,5,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,5,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,5,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,6,7));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,0));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,1));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,2));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,3));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,4));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,5));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,6));
        assertEquals(false , board.isStandardMoveLegal( 4 , 3 ,7,7));
    }
    @Test
    public void generateAllPseudoLegalMoves() throws Exception {
        final char[][] DEFAULT = {
          /////// 0    1    2    3    4    5    6    7
       /* 0*/   {' ', 'K', 'B', ' ', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'Q', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', 'R', ' ', 'p', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', 'a', 'b', 'k', 'r'},
        };


        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(1,2,0 ,3 ));
        expectedMoves.add(new Move(1,2,2,2));
        expectedMoves.add(new Move(1,2,2,3));
        expectedMoves.add(new Move(1,2, 3,2 ));
        expectedMoves.add(new Move(1,2, 4, 2));
        expectedMoves.add(new Move(1,2, 5, 2));
        expectedMoves.add(new Move(1,2, 6,2 ));






        Assert.assertEquals(expectedMoves,gameBoard[1][2].generateAllPseudoLegalMoves(board));
    }
}