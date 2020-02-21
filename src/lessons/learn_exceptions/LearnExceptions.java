package lessons.learn_exceptions;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLDataException;

public class LearnExceptions {


    public static void throwException() {
        try {
            if (1 == 1) {
                throw new IOException("I'm IOE");
            }

            if (1 != 2) {
                throw new Exception("I'm E");
           }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void multiCatch() {
        try {
            if (1 == 1) {
                //connect to database

//                Runtime.getRuntime().exit(5);

                throw new IOException("I'm IOE");

                //close connect to database

//                System.out.println();

            }

            if (1 != 2) {
                throw new SQLDataException("I'm E");
            }

        } catch (IOException | SQLDataException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
            //close connect to database always
        }
    }

    public static void reThrowException() throws SQLDataException {
        try {
            if (1 == 1) {

                throw new IOException("I'm IOE");

            }


        } catch (IOException e) {
        } finally {
            System.out.println("Finally");
            throw new SQLDataException("");

            //close connect to database always
        }
    }

    public static int returnAndException() {
        try {
            if (1 == 1) {

                return 5;
            }


        } finally {
            return 45;
        }
    }

    public static void throwOurException() {
        try {
            throw new VovaException("My exception");
        } catch (VovaException e) {
//            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
//        System.out.println(returnAndException());

        throwOurException();
    }
}

class VovaException extends FileAlreadyExistsException {
    public VovaException(String file) {
        super(file);
    }

}
