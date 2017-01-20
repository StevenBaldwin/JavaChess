package com.stevenbaldwin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven on 2016-10-22.
 */
public class PGNtoCoordinates {
    private static final By PGNTextBox = By.cssSelector("#pgnStringForm > textarea");
    private static final By board = By.cssSelector("#demo-container");
    private static final  By firstSquare = By.cssSelector("#demo-s07");
    private static final By nextMoveButton = By.cssSelector("#demo-forward");
    private static final By enterPGNText = By.cssSelector("#insertPGN");
    private static final By startSquare = By.xpath("//*[contains(@class,\"ct-from-square\")]");
    private static final By endSquare = By.xpath("//*[contains(@class,\"ct-to-square\")]");

    private static final String pgnGame = "1. e4 e5 2. Nf3 Nf6 3. d4 Nxe4 4. Nxe5 d5 5. Nd2 Nxd2 6. Bxd2 Bd6 7. Qf3 Be6 8. O-O-O Nd7 9. Re1 Nxe5 10. dxe5 Be7 11. Qg3 g6 12. Qb3 Qc8 13. Bh6 c6 14. Bd3 Qc7 15. Qa4 Qb6 16. Be3 Qb4 17. Qxb4 Bxb4 18. c3 Be7 19. f4 Kd7 20. Rd1 f6 21. Bd4 Rhf8 22. g3 fxe5 23. Bxe5 Bd6 24. Rde1 Bf5 25. Kd2 Bxd3 26. Kxd3 Rae8 27. Bxd6 Kxd6 28. Rhf1 Re6 29. Rxe6+ Kxe6 30. Re1+ Kd6 31. Re5 h6 32. h4 b6 33. Ke3 a5 34. g4 b5 35. a3 b4 36. axb4 axb4 37. cxb4 Rb8 38. h5 g5 39. Rf5 gxf4+ 40. Rxf4 Ke5 41. Kf3 d4 42. Rf5+ Ke6 43. b5 cxb5 44. Ke4 Rg8 45. Rf4 Rd8 46. Kd3 Rd5 47. Rxd4 Rg5 48. Ke3 Ke5 49. Rb4 Kd6 50. Kf4 Rd5 51. Re4 Rg5 52. Re8 Rg7 53. Rh8 Rf7+ 54. Ke4 Rf6 55. g5 hxg5 56. h6 Rf1 57. h7 1-0\n";

//    public  static void main(String args[])throws IOException{
//        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("FischerKasparov.txt")));
//        List<Move> moves = getAllMoves(pgnGame);
//        for(Move m:moves){
//            bw.write(m.toString());
//            bw.newLine();
//        }
//
//        bw.flush();
//        bw.close();
//
//
//
//
//   }



    static List<Move> getListOfMovesFromFile(String fileName){
        List<Move> moves = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            while ((line=br.readLine())!=null){
                moves.add(lineToMove(line));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moves;
    }

    private static Move lineToMove(String line){
        line = line.replaceAll("\\D+","");
        return new Move(Character.getNumericValue(line.charAt(0)),Character.getNumericValue(line.charAt(1)),Character.getNumericValue(line.charAt(2)),Character.getNumericValue(line.charAt(3)));
    }

    public static List<Move> getAllMoves(String pgnFile){
        String moves = "";
        System.setProperty("webdriver.chrome.driver",
                "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://chesstempo.com/pgn-viewer.html");
        driver.findElement(PGNTextBox).sendKeys(pgnGame);
        driver.findElement(enterPGNText).click();
        while (!driver.findElement(nextMoveButton).getAttribute("src").contains("disabled")) {
            driver.findElement(nextMoveButton).click();
            moves = moves + "START:" + driver.findElement(startSquare).getAttribute("id") + " \n";
            moves = moves + "END:" + driver.findElement(endSquare).getAttribute("id") + " \n";
        }
        return convertStringToMoves(moves);

    }

    private static List<Move> convertStringToMoves(String moves){
        List<Move> allMovesList = new ArrayList<>();
        moves = moves.replaceAll("START:","").replaceAll("END:","").replaceAll("demo-","").replaceAll("s","");
        String[] allMoves = moves.split("\\s+");
        for(String move: allMoves){
            move.replaceAll("\\s+","");
            System.out.println(move);
        }
        for (int index = 0; index < allMoves.length-1; index+=2) {
            allMovesList.add(new Move(ctFormatToMyFormat(allMoves[index]),ctFormatToMyFormat(allMoves[index+1])));
        }
        for (Move m: allMovesList){
            System.out.println(m);
        }

        return allMovesList;
    }

    private static Point ctFormatToMyFormat(String digs){
        return new Point(rowConversion(digs.charAt(1)), colConversion(digs.charAt(0)));
    }

    private static int colConversion(char c) {
        return Character.getNumericValue(c);
    }

    private static int rowConversion(char c) {
        return Math.abs(Character.getNumericValue(c)-7);
    }
}
