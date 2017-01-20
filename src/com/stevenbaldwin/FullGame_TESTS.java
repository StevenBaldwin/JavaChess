package com.stevenbaldwin;
//  Created by Steven J Baldwin  on 2016-10-25.

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FullGame_TESTS {
    @Test
    public void TEST1(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{'R','K','B','Q','A','B','K','R'},
      /*1*/{'P','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{'p','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };

        final char[][] EXPECTED ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ',' ',' ',' ',' ',' ','A',' '},
      /*1*/{'P',' ',' ',' ',' ','P',' ','P'},
      /*2*/{' ',' ','B',' ','P',' ','P',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ','p','q',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ','p',' ',' ',' '},
      /*6*/{'Q','k',' ',' ',' ','p','p','p'},
      /*7*/{' ',' ',' ',' ',' ',' ','a',' '},
        };
        List<Move> moves =  PGNtoCoordinates.getListOfMovesFromFile("Kramnik-Aronian_MOVE.txt");

        ViewController vc = new ViewController(new CommandLineView(),new Game(new Board(DEFAULT)));
        for(Move m: moves){
            assertTrue(vc.game.gameBoard.executeMove(m));
        }
        Piece[][] expectedBoard = new Board(EXPECTED).getGamePieces();
        assertEquals(expectedBoard,vc.game.gameBoard.getGamePieces());
    }
    @Test
    public void TEST1_withAddedErrors(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{'R','K','B','Q','A','B','K','R'},
      /*1*/{'P','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{'p','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };

        final char[][] EXPECTED ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ',' ',' ',' ',' ',' ','A',' '},
      /*1*/{'P',' ',' ',' ',' ','P',' ','P'},
      /*2*/{' ',' ','B',' ','P',' ','P',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ','p','q',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ','p',' ',' ',' '},
      /*6*/{'Q','k',' ',' ',' ','p','p','p'},
      /*7*/{' ',' ',' ',' ',' ',' ','a',' '},
        };
        List<Move> moves =  PGNtoCoordinates.getListOfMovesFromFile("Kramnik-Aronian_MOVE_falseMovesIncluded.txt");

        ViewController vc = new ViewController(new CommandLineView(),new Game(new Board(DEFAULT)));
        for(Move m: moves){
            vc.game.gameBoard.executeMove(m);
        }
        Piece[][] expectedBoard = new Board(EXPECTED).getGamePieces();
        assertEquals(expectedBoard,vc.game.gameBoard.getGamePieces());
    }

    @Test
    public void TEST2(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{'R','K','B','Q','A','B','K','R'},
      /*1*/{'P','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{'p','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };


        final char[][] EXPECTED ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*1*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ','B','p',' ',' ',' ',' ',' '},
      /*4*/{'P',' ',' ','a','P','A',' ',' '},
      /*5*/{'p',' ',' ',' ','k',' ',' ',' '},
      /*6*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*7*/{' ',' ',' ',' ',' ',' ',' ',' '},
        };
        List<Move> moves =  PGNtoCoordinates.getListOfMovesFromFile("KasparovCHESSGP.txt");

        ViewController vc = new ViewController(new CommandLineView(),new Game(new Board(DEFAULT)));
        for(Move m: moves){

            assertTrue(vc.game.gameBoard.executeMove(m));
            CommandLineView.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        }
        Piece[][] expectedBoard = new Board(EXPECTED).getGamePieces();
        assertEquals(expectedBoard,vc.game.gameBoard.getGamePieces());
    }
    @Test
    public void TEST2_WithAddedErrors(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{'R','K','B','Q','A','B','K','R'},
      /*1*/{'P','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{'p','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };


        final char[][] EXPECTED ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*1*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ','B','p',' ',' ',' ',' ',' '},
      /*4*/{'P',' ',' ','a','P','A',' ',' '},
      /*5*/{'p',' ',' ',' ','k',' ',' ',' '},
      /*6*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*7*/{' ',' ',' ',' ',' ',' ',' ',' '},
        };
        List<Move> moves =  PGNtoCoordinates.getListOfMovesFromFile("KasparovCHESSGP_false.txt");

        ViewController vc = new ViewController(new CommandLineView(),new Game(new Board(DEFAULT)));
        for(Move m: moves){

            vc.game.gameBoard.executeMove(m);
            CommandLineView.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        }
        Piece[][] expectedBoard = new Board(EXPECTED).getGamePieces();
        assertEquals(expectedBoard,vc.game.gameBoard.getGamePieces());
    }


    @Test
    public void TEST3(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{'R','K','B','Q','A','B','K','R'},
      /*1*/{'P','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{'p','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };


        final char[][] EXPECTED ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*1*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*2*/{' ',' ',' ',' ','r',' ','P',' '},
      /*3*/{' ',' ','A',' ',' ',' ','P',' '},
      /*4*/{' ','P',' ',' ',' ',' ','p',' '},
      /*5*/{' ','p',' ','B',' ','p',' ',' '},
      /*6*/{' ',' ',' ','a',' ','K',' ',' '},
      /*7*/{' ',' ',' ',' ',' ',' ',' ',' '},
        };
        List<Move> moves =  PGNtoCoordinates.getListOfMovesFromFile("FischerSpassky.txt");

        ViewController vc = new ViewController(new CommandLineView(),new Game(new Board(DEFAULT)));
        for(Move m: moves){

            assertTrue(vc.game.gameBoard.executeMove(m));
            CommandLineView.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        }
        Piece[][] expectedBoard = new Board(EXPECTED).getGamePieces();
        assertEquals(expectedBoard,vc.game.gameBoard.getGamePieces());
    }

    @Test
    public void TEST4(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{'R','K','B','Q','A','B','K','R'},
      /*1*/{'P','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{'p','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };

        final char[][] EXPECTED ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ',' ',' ',' ',' ',' ',' ','r'},
      /*1*/{' ',' ',' ',' ',' ',' ',' ','p'},
      /*2*/{' ',' ',' ','A',' ',' ',' ',' '},
      /*3*/{' ','P',' ',' ',' ',' ','P',' '},
      /*4*/{' ',' ',' ',' ','a',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{' ','p',' ',' ',' ',' ',' ',' '},
      /*7*/{' ',' ',' ',' ',' ','R',' ',' '},
        };
        List<Move> moves =  PGNtoCoordinates.getListOfMovesFromFile("FischerKasparov.txt");

        ViewController vc = new ViewController(new CommandLineView(),new Game(new Board(DEFAULT)));
        for(Move m: moves){

            assertTrue(vc.game.gameBoard.executeMove(m));
            CommandLineView.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        }
        Piece[][] expectedBoard = new Board(EXPECTED).getGamePieces();
        assertEquals(expectedBoard,vc.game.gameBoard.getGamePieces());
    }
}
