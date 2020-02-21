import com.itextpdf.text.DocumentException;
import homework.file_manager.FileManager;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileManagerTest {
    FileManager fileManager = new FileManager();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Test
    public void shouldCreateFile() throws IOException {
        File file = folder.newFolder("files");

        Path path = Paths.get(file.toString(), "file1.txt");

        fileManager.create(path, "Hello");
        Assert.assertTrue(Files.exists(path));

    }

    @Test
    public void shouldConverTxtToPdf() throws IOException, DocumentException {
        File file = folder.newFolder("pdf");

        Path path = Paths.get(file.toString(), "pdfFile.txt");

        Files.createFile(path);

        Files.write(path, "Hello".getBytes());

        fileManager.convertTxtFileToPdf(path);
        String text=Files.readAllLines(path).toString();
        System.out.println(text);

        Assert.assertTrue(Files.exists(path));
        Assert.assertTrue(text.equals("[Hello]"));


    }


    @Test
    public void shouldCopyFile() throws IOException {
        File file = folder.newFolder("File");

        File file2 = folder.newFolder("newFile");

        Files.createFile(Paths.get(file.toString(), "File.txt"));

        Path path1 = Paths.get(file.toString(), "File.txt");

        Path path2 = Paths.get(file2.toString(), "newFile.txt");

        fileManager.copyFiles(path1, path2);

        Assert.assertTrue(Files.exists(path2));
    }


    @Test
    public void shouldDeleteFilesOrDirectory() throws IOException {
        File file = folder.newFolder("File");
        Path path1 = Paths.get(file.toString());
        fileManager.delete(path1);
        Assert.assertFalse(Files.exists(path1));
    }


    @Test
    public void shouldRenameFiles() throws IOException {
        File file = folder.newFolder("File");


        Path path1 = Paths.get(file.toString(), "newFile1.txt");
        Path path2 = Paths.get(file.toString(), "newFile2.txt");
        Files.createFile(path1);


        fileManager.rename(path1, path2);

        Assert.assertTrue(Files.exists(path2));
    }

}
