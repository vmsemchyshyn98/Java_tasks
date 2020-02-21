package homework.work_with_files.writer;

public abstract class Writer implements Writable {

    protected String modifyText(String text) {
        return text.concat(" I'm ready for writting to file");
    }

}