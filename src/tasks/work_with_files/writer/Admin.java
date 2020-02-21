package homework.work_with_files.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Admin extends Writer {

    @Override
    public void write(String text) {
        Path path = Paths.get("./Poem.txt");

        text = modifyText(text);

        try {
            Files.write(path, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

