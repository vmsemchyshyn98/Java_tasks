package homework.file_manager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileManager {

    public static final String EXTENSION_TXT = ".txt";


    public void create(Path path, String text) throws IOException {

        // Path path = Paths.get("./", "files", fileName + ".txt");

        if (Files.isDirectory(path)) {
            Files.createDirectory(Paths.get(path.toString()));
            System.out.println("is directory");
        }
        Files.write(path, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println("File is created");
    }

    private String read(Path path) throws IOException {
        return new String(Files.readAllBytes(path));
    }

    public void convertTxtFileToPdf(Path pathToTxt) throws IOException, DocumentException {
        Document document = new Document();

        String nameOfPdf = pathToTxt.toString();//./Poem.txt!!!

        String commonPath = nameOfPdf.split(".txt")[0];

        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(commonPath + ".pdf"));
        document.open();
        document.add(new Paragraph(read(pathToTxt)));
        document.close();
        pdfWriter.close();
    }

    /*
     * root -> Temp folder(New.txt file)
     * */

    public void copyFiles(Path source, Path target) throws IOException {
        // Path source = Paths.get("./", "files", fileName + ".txt");
        //  Path target = Paths.get("./", "files/" + copiedFile + ".txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

    }

    public void delete(Path path) throws IOException {

        if (Files.isDirectory(path) || Files.exists(path)) {
            Files.walkFileTree(path, new DeleteVisitor());
        }
    }

    public void rename(Path source, Path target) throws IOException {
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        delete(source);
    }


    public void showFileOrDir(Path path) throws IOException {
        Files.walkFileTree(path, new ShowVisitor());
    }
}


class DeleteVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        return delete(file);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return delete(dir);
    }

    private FileVisitResult delete(Path fileOrDir) {
        try {
            Files.delete(fileOrDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return FileVisitResult.CONTINUE;
    }
}

class ShowVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toFile().getName());
        return show(file);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

        System.out.println("Directory:" + dir.toFile().getName());
        return show(dir);
    }


    private FileVisitResult show(Path fileOrDir) {
        Files.exists(fileOrDir);

        return FileVisitResult.CONTINUE;
    }
}
