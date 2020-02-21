package homework.work_with_files;


import homework.work_with_files.reader.User;
import homework.work_with_files.writer.Admin;


public class Main {

    public static void main(String[] args) {

        String text="Hello";

        Admin admin = new Admin();
        admin.write(text);


        User user = new User();
        user.read(text);


    }
}
