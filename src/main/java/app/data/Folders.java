package app.data;

import app.Launcher;

import java.io.File;

public class Folders {

    public boolean createHomeFolder() {
        boolean result = false;
        File file1 = new File(SelectDirectory.selectedDirectory + "\\MainFolder");
        result = file1.mkdir();
        if (result) {
            result = true;
        }
        return result;
    }

//    public boolean createDevFolder() {
//        boolean result = false;
//        File file1 = new File(SelectDirectory.selectedDirectory + "\\DEV");
//        result = file1.mkdir();
//        if (result) {
//            result = true;
//        }
//        return result;
//    }
//
//    public boolean createTestFolder() {
//        boolean result = false;
//        File file1 = new File(SelectDirectory.selectedDirectory + "\\TEST");
//        result = file1.mkdir();
//        if (result) {
//            result = true;
//        }
//        return result;
//    }

    public boolean createFolder(String folderName) {
        boolean result = false;
        File file1 = new File(SelectDirectory.selectedDirectory + "\\" + folderName);
        result = file1.mkdir();
        if (result) {
            result = true;
        }
        return result;
    }

    public String getFolderName() {
        return Launcher.nameOfFolderTextField.getText();
    }
}
