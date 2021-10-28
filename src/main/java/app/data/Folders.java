package app.data;

import java.io.File;

public class Folders {

    public final String localization = "C:\\segregator\\";

    public boolean createHomeFolder() {
        boolean result = false;
        File file1 = new File(localization + "HOME");
        result = file1.mkdir();
        if (result) {
            System.out.println("Folder is created.");
            result = true;
        }
        return result;
    }

    public boolean createDevFolder() {
        boolean result = false;
        File file1 = new File(localization + "DEV");
        result = file1.mkdir();
        if (result) {
            System.out.println("Folder is created.");
            result = true;
        }
        return result;
    }

    public boolean createTestFolder() {
        boolean result = false;
        File file1 = new File(localization + "TEST");
        result = file1.mkdir();
        if (result) {
            System.out.println("Folder is created.");
            result = true;
        }
        return result;
    }
}
