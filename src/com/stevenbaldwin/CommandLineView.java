package com.stevenbaldwin;//  Created by Steven J Baldwin  on 2016-09-15.

import com.stevenbaldwin.enums.ConsoleColour;
import com.stevenbaldwin.pieces.Piece;

import java.io.Serializable;
import java.util.Scanner;

import static com.stevenbaldwin.enums.Colour.WHITE;
import static com.stevenbaldwin.enums.PieceType.*;


public class CommandLineView implements Serializable {
   static   Scanner sc = new Scanner(System.in);
    public CommandLineView(){

    }
public static char requiredPawnPromotion(){
    System.out.println("What piece do you want to promote to?");
    System.out.println("Queen: q");
    System.out.println("Rook: r");
    System.out.println("Knight: k");
//    String requestedPiece = sc.next("\\p{Alnum}{5}");
//    char c = requestedPiece.charAt(0);
    return 'q';
}

    public static void printBoardToConsole(Piece[][] board){

//        System.out.println("  a b c d e f g h");
        System.out.println(ConsoleColour.PURPLE.toString() + "  0 1 2 3 4 5 6 7" +  ConsoleColour.RESET.toString());
        for(int row =0; row<8; row++){
            System.out.print(ConsoleColour.PURPLE.toString() + row  + " " + ConsoleColour.RESET.toString());
            for(int col =0; col<8; col++){
                System.out.print(ConsoleColour.BOLD.toString());
                System.out.print(ConsoleColour.GREEN.toString());
                if((row+col)%2==0){
                    System.out.print(ConsoleColour.BACKGROUND_BLACK.toString());
                }
                if((row+col)%2!=0){
                    System.out.print(ConsoleColour.BACKGROUND_RED.toString());
                }

                if(board[row][col].getType().equals(KING)){
                    if(board[row][col].getColour().equals(WHITE)){
                    //    System.out.print(ConsoleColour.RED.toString());
                        System.out.print("a ");
                    }
                    else {
                      //  System.out.print(ConsoleColour.CYAN.toString());
                        System.out.print("A ");
                    }

                    }
               else if(board[row][col].getType().equals(BISHOP)){
                    if(board[row][col].getColour().equals(WHITE)){
                     //   System.out.print(ConsoleColour.RED.toString());

                        System.out.print("b ");
                    }
                    else {
                     //   System.out.print(ConsoleColour.CYAN.toString());
                        System.out.print("B ");
                    }

                }
                else if(board[row][col].getType().equals(ROOK)){
                    if(board[row][col].getColour().equals(WHITE)){
                       // System.out.print(ConsoleColour.RED.toString());

                        System.out.print("r ");
                    }
                    else {
                        //System.out.print(ConsoleColour.CYAN.toString());
                        System.out.print("R ");
                    }

                }
                else if(board[row][col].getType().equals(QUEEN)){
                    if(board[row][col].getColour().equals(WHITE)){
                        //System.out.print(ConsoleColour.RED.toString());

                        System.out.print("q ");
                    }
                    else {
                        //System.out.print(ConsoleColour.CYAN.toString());
                        System.out.print("Q ");
                    }

                }
                else if(board[row][col].getType().equals(PAWN)){
                    if(board[row][col].getColour().equals(WHITE)){
                        //System.out.print(ConsoleColour.RED.toString());
                        System.out.print("p ");
                    }
                    else {
                        //System.out.print(ConsoleColour.CYAN.toString());
                        System.out.print("P ");
                    }

                }
                else if(board[row][col].getType().equals(KNIGHT)){
                    if(board[row][col].getColour().equals(WHITE)){
                        //System.out.print(ConsoleColour.RED.toString());

                        System.out.print("k ");

                    }
                    else {
                        //System.out.print(ConsoleColour.CYAN.toString());
                        System.out.print("K ");
                    }

                }
                else {
                    System.out.print("  ");
                }
                System.out.print(ConsoleColour.RESET.toString());
                }//inner loop



            System.out.println();
            }//outer loop
        System.out.println("\n");
        }
    }


