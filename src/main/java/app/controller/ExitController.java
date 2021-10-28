package app.controller;

import javafx.application.Platform;

public class ExitController {

    public void exit() {
        Platform.exit();
        System.exit(0);
    }
}
