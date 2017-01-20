package com.stevenbaldwin;//  Created by Steven J Baldwin  on 2016-09-15.

import java.io.Serializable;

public class StartingConfiguration  implements Serializable {
   final static char[][] DEFAULT ={
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

   public static char[][] getDEFAULT() {
      return DEFAULT;
   }
}
