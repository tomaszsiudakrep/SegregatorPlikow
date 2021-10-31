package app.controller;

import app.Launcher;
import app.data.Folders;

public class CreateDirectoryController {

    Folders folders = new Folders();

    public void createFolder() {
        folders.createHomeFolder();
        String folderNameNew = folders.getFolderName().replace(" ", "").toUpperCase();
        boolean result = folders.createFolder(folderNameNew);
        if (result) Launcher.nameOfFolderTextField.clear();
    }
}
