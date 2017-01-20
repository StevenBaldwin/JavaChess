package com.stevenbaldwin;

import com.stevenbaldwin.board.Board;
import com.stevenbaldwin.board.BoardEvaluator;
import com.stevenbaldwin.enums.Colour;
import com.stevenbaldwin.enums.PieceType;
import com.stevenbaldwin.pieces.Piece;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.apache.commons.lang3.time.StopWatch;

import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Steven on 2016-11-13.
 */
public class Controller  implements Initializable{
   @FXML
    TilePane tilePane = new TilePane();
    @FXML
    Rectangle playerIndicator;
    @FXML
    TilePane whiteTilePane;
    @FXML
    TilePane blackTilePane;
    @FXML
    Button restartButton;
    @FXML
    Text time = new Text("time");

    @FXML private Game game;
   @FXML private Stack<Point> boardClicks = new Stack<>();
   @FXML private ArrayList<ToggleButton> buttonsWithEffects = new ArrayList<>();
    private int sizeOfCapturedPieces = 0;
    private Color highlightColour = Color.rgb(255,242,0);
    StopWatch stopWatch = new StopWatch();
    Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            time.setText(formatTime(stopWatch.getTime()));
        }
    }));


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        game = new Game(new Board(StartingConfiguration.getDEFAULT()));
        stopWatch = new StopWatch();
        stopWatch.start();
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();

    }

    private String formatTime(long millis){
     return   String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        );
    }

    @FXML
    private Point clickOrigin(MouseEvent e){
        ToggleButton buttonClick = (ToggleButton) e.getSource();
        removeButtonEffect();
        buttonClick.setEffect(new InnerShadow(20,highlightColour));
        buttonsWithEffects.add(buttonClick);
        Point origin = getArrayPosition(buttonClick);
        boardClicks.push(origin);
        if(boardClicks.size()==2 && boardClicks.get(0).equals(boardClicks.get(1))){
            boardClicks.clear();
        }
        if(boardClicks.size()==2){
            Point start = boardClicks.get(0);
            Point end = boardClicks.get(1);
            Move move = new Move(start,end);
            game.gameBoard.executeMove(move);
            boardClicks.clear();
        }
        updateView();


      return origin;
    }

    private void removeButtonEffect(){
        if(boardClicks.size()==0) {
            for (ToggleButton tile : buttonsWithEffects) {
                tile.setEffect(null);
            }
        }
    }

    private void updateView(){
        checkForCheckmate();
       checkForStalemate();
        paintBoard();
        checkForPawnPromotion();
        updateTurnIndicator();
        updateCapturedPieces();
    }

    private void checkForStalemate() {
        if(game.gameBoard.isWhitePlayersTurn() && BoardEvaluator.isInStalemate(Colour.WHITE,game)){
          paintBoard();
            triggerDraw();
        }
        if(!game.gameBoard.isWhitePlayersTurn() && BoardEvaluator.isInStalemate(Colour.BLACK,game)){
          paintBoard();
            triggerDraw();
        }
    }

    private void updateCapturedPieces() {
        if(sizeOfCapturedPieces!=game.gameBoard.getCapturedPieces().size()){
            try {
                addPieceToCapturedView(game.gameBoard.getCapturedPieces().get(game.gameBoard.getCapturedPieces().size() - 1));
            }
            catch (ArrayIndexOutOfBoundsException e){

            }
        }
        sizeOfCapturedPieces = game.gameBoard.getCapturedPieces().size();
    }

    private void triggerDraw(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Stalemate Reached");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to restart?");

        ButtonType buttonTypeOne = new ButtonType("Restart");

        ButtonType buttonTypeTwo = new ButtonType("Exit Program");


        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            restart();
        } else if (result.get() == buttonTypeTwo) {
            System.exit(0);
        }
    }
    @FXML
    private void restart(){
        game = new Game(new Board(StartingConfiguration.getDEFAULT()));
        whiteTilePane.getChildren().clear();
        blackTilePane.getChildren().clear();
        paintBoard();
        playerIndicator.setFill(Color.WHITE);
        removeButtonEffect();
        stopWatch.reset();
        stopWatch.start();

    }

    private void addPieceToCapturedView(Piece piece) {
        Colour colour =piece.getColour();
        PieceType pieceType = piece.getType();
        if(colour==Colour.WHITE){
            if(pieceType==PieceType.ROOK){
                ImageView pane = new ImageView("w_rook.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                whiteTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.PAWN){
                ImageView pane = new ImageView("w_pawn.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                whiteTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.KING){
                ImageView pane = new ImageView("w_king.png");
                pane.setFitWidth(50);
                 pane.setFitHeight(50);
                whiteTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.KNIGHT){
                ImageView pane = new ImageView("w_knight.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                whiteTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.QUEEN){
                ImageView pane = new ImageView("w_queen.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                whiteTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.BISHOP){
                ImageView pane = new ImageView("w_bishop.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                whiteTilePane.getChildren().add(pane);
            }

        }
        else if(colour==Colour.BLACK){
            if(pieceType==PieceType.ROOK){
                ImageView pane = new ImageView("b_rook.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                blackTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.PAWN){
                ImageView pane = new ImageView("b_pawn.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);

                blackTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.KING){
                ImageView pane = new ImageView("b_king.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                blackTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.KNIGHT){
                ImageView pane = new ImageView("b_knight.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                blackTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.QUEEN){
                ImageView pane = new ImageView("b_queen.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                blackTilePane.getChildren().add(pane);
            }
            else if(pieceType==PieceType.BISHOP){
                ImageView pane = new ImageView("b_bishop.png");
                pane.setFitWidth(50);
                pane.setFitHeight(50);
                blackTilePane.getChildren().add(pane);
            }

        }

    }



    private void checkForCheckmate(){
      if (game.isInCheckMate(Colour.BLACK)){
          paintBoard();
         endGame("Black");
      }
        if (game.isInCheckMate(Colour.WHITE)){
            paintBoard();
            endGame("White");
        }
    }

    private void checkForPawnPromotion(){
        if(game.gameBoard.tilesEligibleForPawnPromotion()!=null){
            game.performPawnPromotion(game.gameBoard.tilesEligibleForPawnPromotion(), requiredPromotion());
        }
        paintBoard();

    }

    private void paintBoard() {
        Piece[][] pieces = game.gameBoard.getGamePieces();
        List<Node> tiles = tilePane.getChildren();
        for(Node node: tiles){
            ToggleButton button = (ToggleButton) node;
            Point point = getArrayPosition(button);
            Piece piece = pieces[point.x][point.y];
            setPieceImageOnButton(piece,button);
        }
    }

    private char requiredPromotion(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Promotion");
        alert.setHeaderText(null);
        alert.setContentText("Choose your promotion");

        ButtonType buttonTypeOne = new ButtonType("Queen");
        ButtonType buttonTypeTwo = new ButtonType("Rook");
        ButtonType buttonTypeThree = new ButtonType("Knight");


        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            return 'q';
        } else if (result.get() == buttonTypeTwo) {
            return 'r';
        } else if (result.get() == buttonTypeThree) {
            return 'k';
        }
        throw new IllegalStateException("You Must Promote");
    }

    private void endGame(String loser){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle( loser + " has lost!");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to restart?");

        ButtonType buttonTypeOne = new ButtonType("Restart");

        ButtonType buttonTypeTwo = new ButtonType("Exit Program");


        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            restart();
            restart();
        } else if (result.get() == buttonTypeTwo) {
            System.exit(0);
        }


    }



    private void updateTurnIndicator(){
        if(game.gameBoard.isWhitePlayersTurn()){
            playerIndicator.setFill(Color.WHITE);
        }
        else {
            playerIndicator.setFill(Color.BLACK);
        }
    }

    private void setPieceImageOnButton(Piece piece, ToggleButton button){
        Colour colour =piece.getColour();
        PieceType pieceType = piece.getType();
        if(colour==Colour.WHITE){
            if(pieceType==PieceType.ROOK){
                button.setId("w-rook");
            }
           else if(pieceType==PieceType.PAWN){
                button.setId("w-pawn");
            }
            else if(pieceType==PieceType.KING){
                button.setId("w-king");
            }
            else if(pieceType==PieceType.KNIGHT){
                button.setId("w-knight");
            }
            else if(pieceType==PieceType.QUEEN){
                button.setId("w-queen");
            }
            else if(pieceType==PieceType.BISHOP){
                button.setId("w-bishop");
            }

        }
        else if(colour==Colour.BLACK){
            if(pieceType==PieceType.ROOK){
                button.setId("b-rook");
            }
            else if(pieceType==PieceType.PAWN){
                button.setId("b-pawn");
            }
            else if(pieceType==PieceType.KING){
                button.setId("b-king");
            }
            else if(pieceType==PieceType.KNIGHT){
                button.setId("b-knight");
            }
            else if(pieceType==PieceType.QUEEN){
                button.setId("b-queen");
            }
            else if(pieceType==PieceType.BISHOP){
                button.setId("b-bishop");
            }

        }
        else {
            button.setId("");
        }
    }



    private Point getArrayPosition(ToggleButton button){
        final int buttonXLocation = (int) button.getLayoutY();
        final int buttonYLocation = (int) button.getLayoutX();
        final int buttonWidth = (int) button.getWidth();
        final int buttonHeight= (int) button.getHeight();
        final int col = buttonYLocation/buttonWidth;
        final int row = buttonXLocation/buttonHeight;
        return new Point(row,col);
    }
}
