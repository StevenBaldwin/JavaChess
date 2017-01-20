package com.stevenbaldwin.pieces.TESTS;

import com.stevenbaldwin.Move;
import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Steven on 2016-09-25.
 */
public class RookTest {
    @Test
    public void isLegalMove_TEST() throws Exception {
        final char[][] DEFAULT ={
         //////// 0   1   2   3   4   5   6   7
       /* 0*/   {'R','K','B','Q','A','B','K','R'},
       /* 1*/   {'P','P','P','P','P','P','P','P'},
       /* 2*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 3*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 4*/   {' ',' ',' ',' ',' ',' ',' ',' '},
       /* 5*/   {'r',' ',' ',' ',' ',' ',' ',' '},
       /* 6*/   {'p','p','p','p','p','p','p','p'},
       /* 7*/   {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(DEFAULT);

     //  assertEquals(true, board.isStandardMoveLegal(5,0,1,0));

        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,0));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,1));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,2));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,3));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,4));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,5));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,6));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,0,7));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,1,0));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,1,1));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,1,2));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,1,3));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,1,4));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,1,5));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,1,6));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,1,7));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,2,0));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,2,1));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,2,2));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,2,3));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,2,4));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,2,5));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,2,6));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,2,7));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,3,0));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,3,1));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,3,2));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,3,3));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,3,4));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,3,5));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,3,6));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,3,7));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,4,0));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,4,1));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,4,2));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,4,3));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,4,4));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,4,5));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,4,6));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,4,7));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,5,0));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,5,1));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,5,2));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,5,3));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,5,4));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,5,5));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,5,6));
        assertEquals(true , board.isStandardMoveLegal( 5 , 0 ,5,7));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,0));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,1));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,2));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,3));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,4));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,5));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,6));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,6,7));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,0));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,1));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,2));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,3));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,4));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,5));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,6));
        assertEquals(false , board.isStandardMoveLegal( 5 , 0 ,7,7));
    }

    @Test
    public void generateAllPseudoLegalMoves() throws Exception {
        final char[][] DEFAULT = {
          /////// 0    1    2    3    4    5    6    7
       /* 0*/   {' ', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', ' ', 'P', 'P', 'P', 'P', 'P'},
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
        expectedMoves.add(new Move(2,1,2,0));
        expectedMoves.add(new Move(2,1,3,1));
        expectedMoves.add(new Move(2,1,2,2));
        expectedMoves.add(new Move(2,1,2,3));




        Assert.assertEquals(expectedMoves,gameBoard[2][1].generateAllPseudoLegalMoves(board));
    }

    @Test
    public void generateAllPseudoLegalMoves2() throws Exception {
        final char[][] DEFAULT = {
          /////// 0    1    2    3    4    5    6    7
       /* 0*/   {' ', 'K', 'B', ' ', ' ', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', ' ', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', 'P', 'r', 'A', ' ', ' '},
       /* 3*/   {' ', 'p', ' ', ' ', 'Q', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', 'a', 'b', 'k', 'r'},
        };


        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(2,4,1,4));
        expectedMoves.add(new Move(2,4,3,4));
        expectedMoves.add(new Move(2,4,2,3));
        expectedMoves.add(new Move(2,4,2,5));





        Assert.assertEquals(expectedMoves,gameBoard[2][4].generateAllPseudoLegalMoves(board));
    }
    @Test
    public void generateAllPseudoLegalMoves3() throws Exception {
        final char[][] DEFAULT = {
          /////// 0    1    2    3    4    5    6    7
       /* 0*/   {' ', 'K', 'B', ' ', ' ', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', ' ', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', 'P', 'R', 'A', ' ', ' '},
       /* 3*/   {' ', 'p', ' ', ' ', 'Q', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', 'a', 'b', 'k', 'r'},
        };


        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();


        Assert.assertEquals(expectedMoves,gameBoard[2][4].generateAllPseudoLegalMoves(board));
    }
    @Test
    public void generateAllPseudoLegalMoves4() throws Exception {
        final char[][] DEFAULT = {
          /////// 0    1    2    3    4    5    6    7
       /* 0*/   {' ', 'K', 'B', ' ', ' ', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', ' ', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', 'P', ' ', 'A', ' ', ' '},
       /* 3*/   {' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', 'r', ' ', ' ', ' ', 'Q', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', 'a', 'b', 'k', 'r'},
        };


        Board board = new Board(DEFAULT);
        Piece[][] gameBoard = board.getGamePieces();
        HashSet<Move> expectedMoves = new HashSet<>();
        expectedMoves.add(new Move(5,2,5,0));
        expectedMoves.add(new Move(5,2,5, 1));
        expectedMoves.add(new Move(5,2,5, 3));
        expectedMoves.add(new Move(5,2,5, 4));
        expectedMoves.add(new Move(5,2,5, 5));
        expectedMoves.add(new Move(5,2,5, 6));
        expectedMoves.add(new Move(5,2,4, 2));
        expectedMoves.add(new Move(5,2,3, 2));
        expectedMoves.add(new Move(5,2,2, 2));
        expectedMoves.add(new Move(5,2,1, 2));
        expectedMoves.add(new Move(5,2,0, 2));



        Assert.assertEquals(expectedMoves,gameBoard[5][2].generateAllPseudoLegalMoves(board));
    }


}