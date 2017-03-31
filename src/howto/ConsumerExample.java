package howto;

import java.util.function.Consumer;

/**
 * Created by yevgen on 20.02.17.
 */
public class ConsumerExample {
    public static void main(String[] args) {

        /** Print "Hello world!" */
        System.out.println("Print \"Hello world!\":");
        Consumer<String> simpleCunsumer = str -> System.out.println(str);
        simpleCunsumer.accept("Hello world!");

        /** At first, print "Hello world!" in upperCase, and then print "Hello world!" in lowerCase: */
        System.out.println("Use andThen method:");
        Consumer<String> firstToUpperCase = str -> System.out.print(str.toUpperCase() + "\n");
        Consumer<String> secondToLowerCase = str -> System.out.print(str.toLowerCase());
        firstToUpperCase.andThen(secondToLowerCase).accept("Hello, world!");
    }
}

