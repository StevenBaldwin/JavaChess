package com.stevenbaldwin.board.TESTS;

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Steven on 2016-10-05.
 */
public class isKingSafe_TEST {
    @Test
    public void isKingSafe() throws Exception {
        final char[][] DEFAULT = {
                //////// 0   1   2   3   4   5   6   7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', 'a', 'b', 'k', 'r'},

        };
        Board board = new Board(DEFAULT);
        TestCase.assertEquals(true, BoardEvaluator.isKingSafe(Colour.WHITE,board));
    }
    @Test
    public void isKingSafe2() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', 'a', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', ' ', 'b', 'k', 'r'},

        };
        Board board = new Board(DEFAULT);
        assertEquals(false,BoardEvaluator.isKingSafe(Colour.WHITE,board));
    }
    @Test
    public void isKingSafe3() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', ' ', 'P', ' ', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', 'a', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', ' ', 'b', 'k', 'r'},

        };
        Board board = new Board(DEFAULT);
        assertEquals(false,BoardEvaluator.isKingSafe(Colour.WHITE,board));
    }
    @Test
    public void isKingSafe4() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', ' ', 'P', ' ', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', 'k', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', 'a', 'b', ' ', 'r'},

        };
        Board board = new Board(DEFAULT);
        assertEquals(false,BoardEvaluator.isKingSafe(Colour.BLACK,board));
    }
    @Test
    public void isKingSafe5() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', ' ', 'P', ' ', 'P', ' '},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', ' '},
       /* 7*/   {'r', 'k', ' ', 'q', ' ', 'b', ' ', 'a'},

        };
        Board board = new Board(DEFAULT);
        assertEquals(false,BoardEvaluator.isKingSafe(Colour.WHITE,board));
    }
    @Test
    public void isKingSafe6() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', 'Q', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', ' ', 'P', ' ', 'P', 'P'},
       /* 2*/   {'a', ' ', ' ', ' ', ' ', 'k', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', ' ', 'b', ' ', 'r'},

        };
        Board board = new Board(DEFAULT);
        assertEquals(false,BoardEvaluator.isKingSafe(Colour.WHITE,board));
    }
    @Test
    public void isKingSafe7() throws Exception {
        final char[][] DEFAULT = {
         //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', ' ', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', ' ', 'P', ' ', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', 'k', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', 'Q', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', 'a', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', ' ', 'b', ' ', ' '},

        };
        Board board = new Board(DEFAULT);
        assertEquals(false,BoardEvaluator.isKingSafe(Colour.WHITE,board));
    }
    @Test
    public void isKingSafe8() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', ' ', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', ' ', 'P', ' ', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', 'k', ' ', ' '},
       /* 3*/   {'a', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', 'Q', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {'r', 'k', ' ', 'q', ' ', 'b', ' ', ' '},

        };
        Board board = new Board(DEFAULT);
        assertEquals(true,BoardEvaluator.isKingSafe(Colour.WHITE,board));
    }
    @Test
    public void isKingSafe9() throws Exception {
        final char[][] DEFAULT = {
                //////// 0    1    2    3    4    5    6    7
       /* 0*/   {'R', 'K', 'B', ' ', 'A', 'B', 'K', 'R'},
       /* 1*/   {'P', 'P', 'P', 'r', 'P', 'k', 'P', 'P'},
       /* 2*/   {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
       /* 3*/   {' ', ' ', 'b', ' ', ' ', ' ', ' ', ' '},
       /* 4*/   {' ', ' ', ' ', ' ', 'Q', ' ', ' ', ' '},
       /* 5*/   {' ', ' ', ' ', ' ', 'a', ' ', ' ', ' '},
       /* 6*/   {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
       /* 7*/   {' ', 'k', ' ', 'q', ' ', 'b', ' ', ' '},

        };
        Board board = new Board(DEFAULT);
        assertEquals(true,BoardEvaluator.isKingSafe(Colour.BLACK,board));
    }
}
