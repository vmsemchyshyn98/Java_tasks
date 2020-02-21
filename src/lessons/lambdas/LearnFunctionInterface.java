package lessons.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LearnFunctionInterface {
    public static void main(String[] args) {
        Convertable convertable = new Convertable() {
            @Override
            public int convert(String value) {
                return Integer.parseInt(value);
            }
        };

        convertable = (String value) -> Integer.parseInt(value);

        convertable = (String value) -> Integer.parseInt(value) + 56;

        run(convertable);
        run(value -> Integer.parseInt(value));
        run(Integer::parseInt);

//        System.out.println(convertable.convert("45"));

//        convertable = value -> Integer.parseInt(value);

//        convertable = Integer::parseInt;

      /*  Mathable<String, Integer> mathable = value -> Integer.toBinaryString(value);

        System.out.println(mathable.convertToBinaryCode(10));*/
    }

    public static void run(Convertable convertable) {

    }

}

class CommonFunctionInterfaces {
    public static void main(String[] args) {
        Function<String, Integer> function = value -> Integer.parseInt(value);

        Supplier<String> supplier = () -> "Hello";

        Consumer<String> consumer = value -> System.out.println(value);
    }
}

@FunctionalInterface
interface Convertable {
    int convert(String value);

    default void print1() {

    }

    private void print() {

    }
}

@FunctionalInterface
interface Mathable<T, F> {
    T convertToBinaryCode(F value);
}
