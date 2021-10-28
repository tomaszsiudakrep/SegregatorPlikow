package app.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StatisticsSettings {

    String pathHome = "C:\\segregator\\HOME\\";
    private int count = 0;

    public void saveSettings() throws FileNotFoundException, UnsupportedEncodingException {
        count = ChooseFile.countDev + ChooseFile.countTest;
        PrintWriter writer = new PrintWriter(new File(pathHome + "count.txt"));
        writer.println("All move files: " + count);
        writer.println("Count dev: " + ChooseFile.countDev);
        writer.println("Count test: " + ChooseFile.countTest);
        writer.close();
    }
}
