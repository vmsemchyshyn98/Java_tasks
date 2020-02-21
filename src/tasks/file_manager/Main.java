package homework.file_manager;


import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException {

        FileManager fileManager = new FileManager();

        Path path = Paths.get("./files/newFile.txt");

        Path path2 = Paths.get("./files/newFile11.txt");

        Path path3 = Paths.get("./files/newFile33");


       fileManager.create(path3,"dddd");


    }


}
