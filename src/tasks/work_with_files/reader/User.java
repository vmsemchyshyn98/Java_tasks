package homework.work_with_files.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class User extends Reader {



    @Override
    public void read(String text) {
        Path path = Paths.get("./Poem.txt");

        try {
            text = new String(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        text=modifyText(text);
        System.out.println(text);
    }
}
