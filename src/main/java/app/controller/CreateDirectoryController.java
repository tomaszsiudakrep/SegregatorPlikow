package app.controller;

import app.data.Folders;

public class CreateDirectoryController {

    Folders folders = new Folders();

    public void createAllFolders() {
        folders.createDevFolder();
        folders.createHomeFolder();
        folders.createTestFolder();
    }
}
