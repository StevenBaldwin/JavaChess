package com.stevenbaldwin;

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import com.stevenbaldwin.pieces.Piece;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by Steven on 2016-10-16.
 */
public class PawnPromotion_TEST {
    @Test
    public void pawnPromition(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ','K','B','Q','A','B','K','R'},
      /*1*/{'p','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{' ','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };
        ViewController vc = new ViewController(new CommandLineView(), new Game(new Board(DEFAULT)));
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
       vc.game.gameBoard.executeMove(1,0,0,0);

        Point potentialPromotion =vc.game.gameBoard.tilesEligibleForPawnPromotion();
        if(potentialPromotion!=null){
            vc.game.performPawnPromotion(potentialPromotion,'q');
        }
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        Piece[][] currentPieces = vc.game.gameBoard.getGamePieces();
        assertTrue(currentPieces[0][0].getType()== PieceType.QUEEN && currentPieces[0][0].getColour()== Colour.WHITE);
    }
    @Test
    public void pawnPromitionAndCapture(){
        final char[][] DEFAULT ={
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{' ','K','B','Q','A','B','K','R'},
      /*1*/{'p','P','P','P','P','P','P','P'},
      /*2*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*3*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*4*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*5*/{' ',' ',' ',' ',' ',' ',' ',' '},
      /*6*/{' ','p','p','p','p','p','p','p'},
      /*7*/{'r','k','b','q','a','b','k','r'},
        };
        ViewController vc = new ViewController(new CommandLineView(), new Game(new Board(DEFAULT)));
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        vc.game.gameBoard.executeMove(1,0,0,1);

        Point potentialPromotion =vc.game.gameBoard.tilesEligibleForPawnPromotion();
        if(potentialPromotion!=null){
            vc.game.performPawnPromotion(potentialPromotion,'q');
        }
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
        Piece[][] currentPieces = vc.game.gameBoard.getGamePieces();
        assertTrue(currentPieces[0][1].getType()== PieceType.QUEEN && currentPieces[0][1].getColour()== Colour.WHITE);
    }
}
