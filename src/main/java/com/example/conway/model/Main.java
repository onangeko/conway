package com.example.conway.model;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GameBoardView;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {
        GameBoardView gameBoardView = new GameBoardView(stage);
        Scene scene = new Scene(gameBoardView);
        stage.setTitle("Conway Game Of Life");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        gameBoardView.buildAndSetGameLoop();
        gameBoardView.start();

    }



    public static void main(String[] args) { launch(); }
}
