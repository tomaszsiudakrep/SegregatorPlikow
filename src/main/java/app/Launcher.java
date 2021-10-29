package app;

import app.controller.CreateDirectoryController;
import app.controller.ExitController;
import app.controller.SelectDirectoryController;
import app.data.BackgroundSettings;
import app.data.ChooseFile;
import app.data.SelectDirectory;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Launcher extends Application {

    BackgroundSettings backgroundSettings = new BackgroundSettings();
    ExitController exitController = new ExitController();
    ChooseFile chooseFile;
    CreateDirectoryController createDirectoryController = new CreateDirectoryController();
    SelectDirectoryController selectDirectoryController = new SelectDirectoryController();
    public static Label chosenLocalizationLabel;
    public static Button createFoldersButton;
    public static Button segregateFilesButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridMenu = new GridPane();
            gridMenu.setAlignment(Pos.CENTER);
            gridMenu.setBackground(backgroundSettings.defaultBackground());

        Button selectDirectoryToCreateNewFoldersButton = new Button("Select directory");
            selectDirectoryToCreateNewFoldersButton.setPrefWidth(200);
            selectDirectoryToCreateNewFoldersButton.setPrefHeight(50);
        chosenLocalizationLabel = new Label();
            chosenLocalizationLabel.setPrefWidth(200);
            chosenLocalizationLabel.setPrefHeight(25);
            chosenLocalizationLabel.setStyle("-fx-text-fill: white");
        createFoldersButton = new Button("Create directory");
            createFoldersButton.setPrefWidth(200);
            createFoldersButton.setPrefHeight(50);
            createFoldersButton.setDisable(true);
        Button exitMenuButton = new Button("Exit");
            exitMenuButton.setPrefWidth(200);
            exitMenuButton.setPrefHeight(50);
        segregateFilesButton = new Button("Segregate files");
            segregateFilesButton.setPrefWidth(200);
            segregateFilesButton.setPrefHeight(50);
            segregateFilesButton.setDisable(true);

        gridMenu.add(selectDirectoryToCreateNewFoldersButton, 10, 5);
        gridMenu.add(chosenLocalizationLabel, 10, 8);
        gridMenu.add(createFoldersButton, 10, 10);
        gridMenu.add(segregateFilesButton, 10, 15);
        gridMenu.add(exitMenuButton, 10, 20);

        Scene sceneMenu = new Scene(gridMenu, BackgroundSettings.width, BackgroundSettings.height, Color.BLACK);
        primaryStage.setScene(sceneMenu);
        primaryStage.setTitle("Files binder");
        primaryStage.setResizable(false);
        primaryStage.show();

        selectDirectoryToCreateNewFoldersButton.setOnAction(event -> selectDirectoryController.selectDirectoryMain());
        createFoldersButton.setOnAction(event -> createDirectoryController.createAllFolders());
        exitMenuButton.setOnAction(actionEvent -> exitController.exit());
        segregateFilesButton.setOnAction(event -> {
            try {
                chooseFile = new ChooseFile();
                chooseFile.moveFileToAnotherFolder();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }
}
