package lessons.for_test;

import java.io.IOException;
import java.util.Random;

public class Calculator {
    public int sum(int v1, int v2) {
        return v1 + v2;
    }

    public int sumRandom(int v1) {
        return v1 + getRandom();
    }

    public static int getRandom() {
        return new Random().nextInt(50);//25
    }

    public void throwException() throws IOException {
        throw new IOException("Class not found");
    }

    public void print() {
        System.out.println("Hello world");
    }
}
