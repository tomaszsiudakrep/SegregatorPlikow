package app.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class ChooseFile {

    String pathHome = "C:\\segregator\\HOME";
    String pathTest = "C:\\segregator\\TEST\\";
    String pathDev = "C:\\segregator\\DEV\\";
    ArrayList<File> files;
    public static int countTest = 0;
    public static int countDev = 0;
    StatisticsSettings statisticsSettings = new StatisticsSettings();


    public void moveFileToAnotherFolder() throws IOException {
        files = new ArrayList<>();
        File repo = new File(pathHome);
        File[] fileList = repo.listFiles();

        for (File var: fileList) {
            String pathToFile = var.toString();

            String extension = checkExtension(pathToFile);
            String name = checkFileName(pathToFile);

            if (extension.equals(".xml")) {
                var.renameTo(new File(pathDev + name + extension));
                countDev++;
            } else if (extension.equals(".jar")){
                BasicFileAttributes attr = Files.readAttributes(var.toPath(), BasicFileAttributes.class);
                if (attr.creationTime().toMillis() % 2 == 0) {
                    var.renameTo(new File(pathDev + name + extension));
                    countDev++;
                } else {
                    var.renameTo(new File(pathTest + name + extension));
                    countTest++;
                }
            } else {
                System.out.println("Do nothing");
            }
            statisticsSettings.saveSettings();
        }

    }

    public String checkExtension(String file) {
        String filePath = file.substring(file.indexOf("."));
        return filePath;
    }

    public String checkFileName(String file) {
        String name = file.substring(19, file.indexOf("."));
        return name;
    }
}
