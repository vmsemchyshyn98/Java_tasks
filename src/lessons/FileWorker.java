package lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWorker {
    public static void main(String[] args) throws IOException {

//        Path path = Paths.get("./", "run", "Poem.txt");
        Path path = Paths.get("./run/Poem.txt");

//        Files.write(path, "Hello, Vova".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        byte[] bytes = Files.readAllBytes(path);

        Files.createDirectory(Paths.get("./fortask"));

        BufferedReader reader = Files.newBufferedReader(path);

System.out.println(bytes);
 /*       String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        new Date();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusDays(5);
*/
//        System.out.println(new String(bytes));
    }
}
