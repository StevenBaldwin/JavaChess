package com.stevenbaldwin;

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Steven on 2016-10-16.
 */
public class CheckMate_TEST {
    @Test
    public void checkMate(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ',' ',' ','B','A','B','K','R'},
      /*1*/{'p','P',' ',' ','P',' ','P','P'},
      /*2*/{' ',' ',' ','p','p',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{' ','p','p','p',' ','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };
        ViewController vc = new ViewController(new CommandLineView(), new Game(new Board(DEFAULT)));
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
                vc.game.gameBoard.executeMove(2,3,1,3);
        Piece[][] currentPieces = vc.game.gameBoard.getGamePieces();
        assertTrue(vc.game.isInCheckMate(Colour.BLACK));
    }
    @Test
    public void checkMateNot(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ','K','B',' ','A','B','K','R'},
      /*1*/{'p','P',' ',' ','P',' ','P','P'},
      /*2*/{' ',' ',' ','p','p',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{' ','p','p','p',' ','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };
        ViewController vc = new ViewController(new CommandLineView(), new Game(new Board(DEFAULT)));
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        vc.game.gameBoard.executeMove(2,3,1,3);
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        System.out.println(vc.game.gameBoard.isWhitePlayersTurn());


        Piece[][] currentPieces = vc.game.gameBoard.getGamePieces();
        assertFalse(vc.game.isInCheckMate(Colour.BLACK));
    }


}
