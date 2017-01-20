package com.stevenbaldwin;

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import org.junit.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven on 2016-10-19.
 */
public class PGNDataTests {
    @Test
    public void gameTest() throws IOException {
        final char[][] DEFAULT = {
///////////* 0   1   2   3   4   5   6   7 */
      /*0*/{'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
      /*1*/{'p', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
      /*2*/{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      /*3*/{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      /*4*/{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      /*5*/{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      /*6*/{'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
      /*7*/{'r', 'k', 'b', 'q', 'a', 'b', 'k', 'r'},
        };

        ViewController vc = new ViewController(new CommandLineView(), new Game(new Board(DEFAULT)));
        vc.view.printBoardToConsole(vc.game.gameBoard.getGamePieces());
      List<PGNMove> whitePGNMoves =  getWhitePiecePGNMoves(new File("Kramnik-Aronian.pgn"));
        List<PGNMove> blackPGNMoves =  getBlackPiecePGNMoves(new File("Kramnik-Aronian.pgn"));
        for (int i = 0; i < whitePGNMoves.size(); i++) {
            System.out.println(whitePGNMoves.get(i));
        }
       vc.executePGNMoves(whitePGNMoves,blackPGNMoves);
    }

    private static List<PGNMove> getWhitePiecePGNMoves(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String allGameData = "";
        while ((line = br.readLine()) != null) {
            allGameData = allGameData + line;
        }

        allGameData = allGameData.replaceAll("\\d+\\.", "").replaceAll("x", "").replaceAll("\\+", "").replaceAll("#", "");
        List<String> whiteMoves = new ArrayList<>();
        String[] individualMoves = allGameData.split("\\s+");
        for (int i = 0; i < individualMoves.length; i += 2) {
            whiteMoves.add(individualMoves[i].replaceAll("\\s+", ""));
        }

        return stringsToPGNMove(whiteMoves,Colour.WHITE);
    }
    private static List<PGNMove> getBlackPiecePGNMoves(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String allGameData = "";
        while ((line = br.readLine()) != null) {
            allGameData = allGameData + line;
        }

        allGameData = allGameData.replaceAll("\\d+\\.", "").replaceAll("x", "").replaceAll("\\+", "").replaceAll("#", "");
        List<String> blackMoves = new ArrayList<>();
        String[] individualMoves = allGameData.split("\\s+");
        for (int i = 1; i < individualMoves.length; i += 2) {
            blackMoves.add(individualMoves[i].replaceAll("\\s+", ""));
        }
       return stringsToPGNMove(blackMoves,Colour.BLACK);
    }

    private static List<PGNMove> stringsToPGNMove(List<String> moves, Colour colour) {
        List<PGNMove> pgnMoves = new ArrayList<>();
        for (String move : moves) { //promotions!!!
            if (move.equals("0-0") || move.equals("O-O")) {
                if (colour == Colour.WHITE) {
                    pgnMoves.add(new PGNMove(PieceType.KING, new Point(7, 6)));
                    break;
                } else {
                    pgnMoves.add(new PGNMove(PieceType.KING, new Point(0, 6)));
                    break;
                }
            } else if (move.equals("0-0-0") || move.equals("O-O-O")) {
                if (colour == Colour.WHITE) {
                    pgnMoves.add(new PGNMove(PieceType.KING, new Point(7, 2)));
                    break;
                } else {
                    pgnMoves.add(new PGNMove(PieceType.KING, new Point(0, 2)));
                    break;
                }
            } else if (move.length() == 2) {
                Point destination = new Point(SANCharToMyInt(move.charAt(0)), SANIntToMyInt(move.charAt(1)));
                pgnMoves.add(new PGNMove(PieceType.PAWN, destination));
                break;
            } else if (move.length() == 3) {
                PieceType pieceType;
                if (isAllLowerCase(move)) {
                    pieceType = PieceType.PAWN;
                    if (Character.isAlphabetic(move.charAt(0))) {
                        int startingColumn = SANCharToMyInt(move.charAt(0));
                        Point destinaiton = new Point(SANCharToMyInt(move.charAt(1)), SANIntToMyInt(move.charAt(2)));
                        pgnMoves.add(new PGNMove(pieceType, destinaiton, -1, startingColumn));
                        break;
                    } else if (Character.isDigit(move.charAt(0))) {
                        int startingRow = SANIntToMyInt(move.charAt(0));
                        Point destinaiton = new Point(SANCharToMyInt(move.charAt(1)), SANIntToMyInt(move.charAt(2)));
                        pgnMoves.add(new PGNMove(pieceType, destinaiton, startingRow, -1));
                        break;

                    }

                } else {
                    pieceType = pieceCharToPieceType(move.charAt(0));
                    Point destinaiton = new Point(SANCharToMyInt(move.charAt(1)), SANIntToMyInt(move.charAt(2)));
                    pgnMoves.add(new PGNMove(pieceType, destinaiton));
                    break;
                }
            } else if (move.length() == 4) {
                if (Character.isLowerCase(move.charAt(0))) { //pawn promotion
                    Point destination = new Point(SANCharToMyInt(move.charAt(0)), SANIntToMyInt(move.charAt(1)));
                    char promotion = move.charAt(3);
                    pgnMoves.add(new PGNMove(PieceType.PAWN, destination, promotion));
                    break;

                } else {
                    PieceType pieceType = pieceCharToPieceType(move.charAt(0));
                    if (Character.isDigit(move.charAt(1))) {
                        int startingRow = SANIntToMyInt(move.charAt(1));
                        Point destination = new Point(SANCharToMyInt(move.charAt(2)), SANIntToMyInt(move.charAt(3)));
                        pgnMoves.add(new PGNMove(pieceType, destination, startingRow, -1));
                        break;

                    } else {
                        int startingCol = SANCharToMyInt(move.charAt(1));
                        Point destination = new Point(SANCharToMyInt(move.charAt(2)), SANIntToMyInt(move.charAt(3)));
                        pgnMoves.add(new PGNMove(pieceType, destination, -1, startingCol));
                        break;
                    }
                }

            }

        }
        return pgnMoves;
    }


    private static boolean isAllLowerCase(String move) {
        return (move.equals(move.toLowerCase()));
    }

    private static PieceType pieceCharToPieceType(char c) {
        switch (c) {
            case 'N':
                return PieceType.KNIGHT;
            case 'B':
                return PieceType.BISHOP;
            case 'R':
                return PieceType.ROOK;
            case 'K':
                return PieceType.KING;
            case 'Q':
                return PieceType.QUEEN;
            default:
                throw new IllegalStateException("No piece type matches");
        }
    }

    private static int SANIntToMyInt(char sanChar) {
        int sanInt = Character.getNumericValue(sanChar);
        return Math.abs(sanInt - 8);
    }

    private static int SANCharToMyInt(char sanChar) {
        switch (sanChar) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;

        }
        throw new IllegalArgumentException("illegal char");
    }

    public static class PGNMove {
        private PieceType pieceToMove;
        private Point destination;
        private char promotion;
        private int startingRow = -1;
        private int startingCol = -1;

        @Override
        public String toString() {
            return "PGNMove{" +
                    "pieceToMove=" + pieceToMove +
                    ", destination=" + destination.toString() +
                    ", promotion=" + promotion +
                    ", startingRow=" + startingRow +
                    ", startingCol=" + startingCol +
                    '}';
        }

        public PGNMove(PieceType pieceToMove, Point destination, char promotion, int startingRow, int startingCol) {
            this.pieceToMove = pieceToMove;
            this.destination = destination;
            this.promotion = promotion;
            this.startingRow = startingRow;
            this.startingCol = startingCol;
        }

        public PGNMove(PieceType pieceToMove, Point destination, char promotion) {
            this.pieceToMove = pieceToMove;
            this.destination = destination;
            this.promotion = promotion;
        }

        public PGNMove(PieceType pieceToMove, Point destination) {
            this.pieceToMove = pieceToMove;
            this.destination = destination;
        }

        public PGNMove(PieceType pieceToMove, Point destination, int startingRow, int startingCol) {
            this.pieceToMove = pieceToMove;
            this.destination = destination;
            this.promotion = promotion;
            this.startingRow = startingRow;
            this.startingCol = startingCol;
        }


        public PieceType getPieceToMove() {
            return pieceToMove;
        }

        public void setPieceToMove(PieceType pieceToMove) {
            this.pieceToMove = pieceToMove;
        }

        public Point getDestination() {
            return destination;
        }

        public void setDestination(Point destination) {
            this.destination = destination;
        }

        public char getPromotion() {
            return promotion;
        }

        public int getStartingRow() {
            return startingRow;
        }

        public int getStartingCol() {
            return startingCol;
        }
    }
}

