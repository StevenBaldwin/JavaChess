package com.stevenbaldwin.board.TESTS;
//  Created by Steven J Baldwin  on 2016-09-20.

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.pieces.Piece;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BoardDiagonalPathTests {
    @Test
    public void defaultBoardDiagonal_TEST(){
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
        Piece[][] chessPieces  = board.getGamePieces();

        TestCase.assertEquals(false , BoardEvaluator.isDiagonalPathValid(chessPieces[6][0],5,0,chessPieces)); //p
        assertEquals(false , BoardEvaluator.isDiagonalPathValid(chessPieces[6][0],8,1,chessPieces)); //p


    }

    @Test
    public void alternateBoardDiagonal_TEST() {
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
        Piece[][] chessPieces = board.getGamePieces();

        assertEquals(false, BoardEvaluator.isDiagonalPathValid(chessPieces[4][3], 6, 4, chessPieces)); //p
        assertEquals(true, BoardEvaluator.isDiagonalPathValid(chessPieces[4][3], 6, 5, chessPieces)); //p

    }
    @Test
    public void alternateBoardDiagonal_TEST2() {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', 'P', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', 'p', 'P', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', 'p', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', ' ', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},
        };
        Board board = new Board(DEFAULT);
        Piece[][] chessPieces = board.getGamePieces();

        assertEquals(false, BoardEvaluator.isDiagonalPathValid(chessPieces[4][3], 2, 1, chessPieces)); //p
        assertEquals(true, BoardEvaluator.isDiagonalPathValid(chessPieces[4][3], 1, 6, chessPieces)); //p

    }
    @Test
    public void alternateBoardDiagonal_TEST3() {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', 'P', ' ', ' ', ' ', 'p', ' ', ' '},
       /* 3*/   {' ', ' ', ' ', 'P', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', 'p', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', ' ', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},
        };
        Board board = new Board(DEFAULT);
        Piece[][] chessPieces = board.getGamePieces();

        assertEquals(false, BoardEvaluator.isDiagonalPathValid(chessPieces[4][3], 2, 5, chessPieces)); //p
        assertEquals(false, BoardEvaluator.isDiagonalPathValid(chessPieces[4][3], 1, 0, chessPieces)); //p

    }
    }
