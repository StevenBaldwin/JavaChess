package com.stevenbaldwin;/**
 * Created by Steven on 2016-11-05.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIView extends Application {

    public GUIView() throws IOException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,800,600);
        Image faviconImage = new Image(getClass().getClassLoader().getResource("JChessTransparent.png").toString());
        primaryStage.setTitle("Pawn Star (Chess)");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(faviconImage);
        primaryStage.setResizable(false);
        primaryStage.show();


    }


}
