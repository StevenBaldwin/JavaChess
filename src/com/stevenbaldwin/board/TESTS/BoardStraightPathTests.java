package com.stevenbaldwin.board.TESTS;


import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.pieces.Piece;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BoardStraightPathTests {
@Test
    public void defaultBoardEvalStraightPath_TEST(){
    final char[][] DEFAULT ={
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
Piece[][] chessPieces  = board.getGamePieces();

    TestCase.assertEquals(true, BoardEvaluator.isStraightPathValid(chessPieces[6][0],5,0,chessPieces)); //p
    assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[6][0],6,1,chessPieces)); //p
    assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[6][0],5,1,chessPieces)); // p

}
    @Test
    public void alternativeBoardEvalStraightPath_TEST1(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'P',' ','P','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 3*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 4*/ {'r','p',' ',' ',' ',' ',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ','p','p','p','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(true,BoardEvaluator.isStraightPathValid(chessPieces[4][0],1,0,chessPieces));

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[4][0],0,0,chessPieces)); //

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[4][0],4,1,chessPieces));





    }

    @Test
    public void alternativeBoardEvalStraightPath_TEST2(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'P','r','P','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 3*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 4*/ {' ','p',' ',' ',' ',' ',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ','p','p','p','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(true,BoardEvaluator.isStraightPathValid(chessPieces[1][1],1,0,chessPieces)); //

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[1][1],0,0,chessPieces)); //

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[1][1],1,3,chessPieces)); //

    }

    @Test
    public void alternativeBoardEvalStraightPath_TEST3(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'r',' ',' ','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 3*/ {' ','P',' ',' ',' ',' ',' ',' '},
                /* 4*/ {'P','p','P','p',' ',' ',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ','p','p','p','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[4][3],4,1,chessPieces)); //


    }

    @Test
    public void alternativeBoardEvalStraightPath_TEST4(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'r',' ',' ','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 3*/ {' ','P',' ',' ',' ',' ',' ',' '},
                /* 4*/ {'P','p','P','p',' ',' ',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ','p','p','p','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[7][4],7,3,chessPieces)); //
        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[7][4],6,3,chessPieces)); //
        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[7][4],7,4,chessPieces)); //
        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[7][4],6,5,chessPieces)); //
        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[7][4],7,5,chessPieces)); //


    }

    @Test
    public void alternativeBoardEvalStraightPath_TEST5(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'r',' ',' ','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ','p',' ',' ',' ',' '},
                /* 3*/ {' ','P',' ',' ',' ',' ',' ',' '},
                /* 4*/ {'P','p','P','p',' ','p',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ',' ','p',' ','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[1][3],4,3,chessPieces)); //
        assertEquals(true,BoardEvaluator.isStraightPathValid(chessPieces[4][3],4,2,chessPieces)); //
        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[4][3],0,3,chessPieces)); //
        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[4][3],4,5,chessPieces)); //
        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[4][3],2,3,chessPieces)); //


    }

    @Test
    public void alternativeBoardEvalStraightPath_TEST6(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'r',' ',' ','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ','p',' ',' ',' ',' '},
                /* 3*/ {' ','P',' ',' ',' ',' ',' ',' '},
                /* 4*/ {'P','p','P','p',' ','p',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ',' ','p',' ','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[1][3],4,3,chessPieces)); //



    }
    @Test
    public void alternativeBoardEvalStraightPath_TEST7(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'r',' ',' ','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ','p',' ',' ',' ',' '},
                /* 3*/ {' ','P',' ',' ',' ',' ',' ',' '},
                /* 4*/ {'P','p','P','p',' ','p',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ',' ','p',' ','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[1][3],4,3,chessPieces)); //



    }
    @Test
    public void alternativeBoardEvalStraightPath_TEST8(){
        final char[][] setup ={
                //////// 0   1   2   3   4   5   6   7
                /* 0*/ {'R','K','B','Q','A','B','K','R'},
                /* 1*/ {'r',' ',' ','P','P','P','P','P'},
                /* 2*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 3*/ {' ','P',' ',' ',' ',' ',' ',' '},
                /* 4*/ {'P','p','P','R',' ','p',' ',' '},
                /* 5*/ {' ',' ',' ',' ',' ',' ',' ',' '},
                /* 6*/ {' ',' ','p',' ','p','p','p','p'},
                /* 7*/ {' ','k','b','q','a','b','k','r'},
        };
        Board board = new Board(setup);
        Piece[][] chessPieces  = board.getGamePieces();

        assertEquals(false,BoardEvaluator.isStraightPathValid(chessPieces[1][3],4,3,chessPieces)); //



    }

}
