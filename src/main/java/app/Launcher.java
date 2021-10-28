package app;

import app.controller.CreateDirectoryController;
import app.controller.ExitController;
import app.data.BackgroundSettings;
import app.data.ChooseFile;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Launcher extends Application {

    BackgroundSettings backgroundSettings = new BackgroundSettings();
    ExitController exitController = new ExitController();
    CreateDirectoryController createDirectoryController = new CreateDirectoryController();
    ChooseFile chooseFile = new ChooseFile();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridMenu = new GridPane();
            gridMenu.setAlignment(Pos.CENTER);
            gridMenu.setBackground(backgroundSettings.defaultBackground());

        Button createFoldersButton = new Button("Create directory");
            createFoldersButton.setPrefWidth(150);
            createFoldersButton.setPrefHeight(50);
        Button exitMenuButton = new Button("Exit");
            exitMenuButton.setPrefWidth(150);
            exitMenuButton.setPrefHeight(50);
        Button segregateFilesButton = new Button("Segregate files");
            segregateFilesButton.setDisable(true);
            segregateFilesButton.setPrefWidth(150);
            segregateFilesButton.setPrefHeight(50);

        gridMenu.add(createFoldersButton, 10, 10);
        gridMenu.add(segregateFilesButton, 10, 15);
        gridMenu.add(exitMenuButton, 10, 20);

        Scene sceneMenu = new Scene(gridMenu, BackgroundSettings.width, BackgroundSettings.height, Color.BLACK);
        primaryStage.setScene(sceneMenu);
        primaryStage.setTitle("Segregator plikow");
        primaryStage.setResizable(false);
        primaryStage.show();

        createFoldersButton.setOnAction(event -> {
            createDirectoryController.createAllFolders();
            segregateFilesButton.setDisable(false);
            createFoldersButton.setDisable(true);
        });
        exitMenuButton.setOnAction(actionEvent -> exitController.exit());
        segregateFilesButton.setOnAction(event -> {
            try {
                chooseFile.moveFileToAnotherFolder();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }
}
