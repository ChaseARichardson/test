import java.io.File;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.*;

// YOOOOO WHAT's UP CHASE

public class ExtensionSorter {
    public static void main(String[] args) {
        String path = "C:\\Users\\samva\\Downloads\\";
        File file = new File(path);
        File downloadDir[] = file.listFiles();
        Arrays.sort(downloadDir);
        for (File e : downloadDir) {
            if (e.isFile()) {
                // String last = e.getAbsolutePath().lastIndexOf(",")
                String[] temp = e.getAbsolutePath().split("\\.(?=[^.]*$)", 2);
                System.out.println("this is full " + e.getAbsolutePath());
                // System.out.println("this is 1 " + temp[0]);
                // System.out.println("this is 2 " + temp[1]);
                File f = new File("C:\\Users\\samva\\Downloads\\" + temp[temp.length - 1]);

                if (f.mkdir()) {
                    System.out.println("Directory is created");
                    try {
                        File fileLoc = new File("C:\\Users\\samva\\Downloads\\" + temp[temp.length-1] + "\\"+ e.getName());
                        Files.move(e.toPath(), fileLoc.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("file move successful");
                    } catch (IOException p) {
                        System.out.println("not successful");
                        p.printStackTrace();
                    }
                } else {
                    System.out.println("Directory cannot be created");
                    try {
                        File fileLoc = new File("C:\\Users\\samva\\Downloads\\" + temp[temp.length-1] + "\\"+ e.getName());
                        Files.move(e.toPath(), fileLoc.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("file move successful");
                    } catch (IOException p) {
                        System.out.println("not successful");
                        p.printStackTrace();
                    }
                }
            }
            // Consider directory sort, although would be stupid

        }
    }
}