package app.data;

import java.io.File;

public class Folders {

    public boolean createHomeFolder() {
        boolean result = false;
        File file1 = new File(SelectDirectory.selectedDirectory + "\\HOME");
        result = file1.mkdir();
        if (result) {
            result = true;
        }
        return result;
    }

    public boolean createDevFolder() {
        boolean result = false;
        File file1 = new File(SelectDirectory.selectedDirectory + "\\DEV");
        result = file1.mkdir();
        if (result) {
            result = true;
        }
        return result;
    }

    public boolean createTestFolder() {
        boolean result = false;
        File file1 = new File(SelectDirectory.selectedDirectory + "\\TEST");
        result = file1.mkdir();
        if (result) {
            result = true;
        }
        return result;
    }
}
