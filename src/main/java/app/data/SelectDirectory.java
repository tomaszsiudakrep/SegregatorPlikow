package app.data;

import app.Launcher;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class SelectDirectory {

    DirectoryChooser directoryChooser;
    public static String selectedDirectory;

    public boolean selectDirectoryFolder() {
        boolean result = false;
        directoryChooser = new DirectoryChooser();
        File sd = directoryChooser.showDialog(null);
        if (sd != null) {
            selectedDirectory = sd.getAbsolutePath();
            Launcher.createFoldersButton.setDisable(false);
            Launcher.segregateFilesButton.setDisable(false);
            result = true;
        }
        return result;
    }

    public void showSelectedDirectory() {
        Launcher.chosenLocalizationLabel.setText(selectedDirectory);
    }
}
