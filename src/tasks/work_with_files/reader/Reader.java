package homework.work_with_files.reader;

public abstract class Reader implements Readable {

    protected String modifyText(String text) {
        return text.concat("I'm from file");
    }




}
