package model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.GameBoardView;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {
        //
        GameBoardView gameBoardView = new GameBoardView();
        Scene scene = new Scene(gameBoardView,gameBoardView.getPrefWidth(),gameBoardView.getPrefHeight());
        stage.setTitle("Conway Game Of Life");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.show();
    }



    public static void main(String[] args) { launch(); }
}
