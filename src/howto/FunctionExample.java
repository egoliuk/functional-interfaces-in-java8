package howto;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by yevgen on 20.02.17.
 */
public class FunctionExample {
    public static void main(String[] args) {

        /** For example, this Function can be applied to return Integer from String */
        System.out.println("This Function return Integer from String:");
        Function<String, Integer> toInteger = str -> Integer.valueOf(str);
        System.out.println("Result type is " + toInteger.apply("123").getClass().getTypeName());

        /** This Function parse String to Integer and then call method andThen() and return String from Integer */
        System.out.println("This Function parse String to Integer " +
                "and then call method andThen() and return String from Integer:");
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println("Result type is " + backToString.apply("123").getClass().getTypeName());

        Function<Integer, String> converter = (integer) -> Integer.toString(integer);
        Function<String, Integer> reverse = (string) -> Integer.parseInt(string);

        /** Code examples with andThen method  */
        System.out.println("This Function use andThen:");
        System.out.println(converter.apply(42).length());
        System.out.println(converter.andThen(reverse).apply(42));

        /** Code examples with compose method */
        System.out.println("This Function use compose:");
        System.out.println(converter.apply(777).length());
        System.out.println(converter.compose(reverse).apply("777"));

        /** Function identity returns a function that always returns its input argument */
        Function<Integer, Integer> id = Function.identity();
        System.out.println("Function identity returns a function that always returns its input argument:");
        System.out.println(id.apply(3));
        System.out.println(id.apply(3).getClass().getTypeName());

        /** UnaryOperator is a specialization of Function for the case where the operand and result are of the same type. */
        UnaryOperator<Integer> unaryOperator = integer -> integer * integer;
        System.out.println(unaryOperator.apply(2));

        /** Code examples with BinaryOperator */
        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2;
        System.out.println("Sum -> " + adder.apply(3, 4));
        BinaryOperator<Integer> getMin = BinaryOperator.minBy((n1, n2) -> n1 > n2 ? 1 : n1 == n2 ? 0 : -1);
        System.out.println("Min value -> " + getMin.apply(2, 3));
        BinaryOperator<Integer> getMax = BinaryOperator.maxBy((n1, n2) -> n1 > n2 ? 1 : n1 == n2 ? 0 : -1);
        System.out.println("Max value -> " + getMax.apply(2, 3));
    }
}
