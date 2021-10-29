package app.controller;

import app.data.SelectDirectory;

public class SelectDirectoryController {

    SelectDirectory selectDirectory = new SelectDirectory();

    public void selectDirectoryMain() {
        selectDirectory.selectDirectoryFolder();
        selectDirectory.showSelectedDirectory();
    }
}
