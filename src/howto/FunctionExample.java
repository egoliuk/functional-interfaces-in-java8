package howto;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by yevgen on 20.02.17.
 */
public class FunctionExample {
    public static void main(String[] args) {

        /** For example, this Function can be applied to return a result of multiplying an integer by itself (a square) */
        System.out.println("This Function returns a square of an integer:");
        Function<Integer, Integer> square = i -> i*i;
        System.out.println("The square of 3 is the number " + square.apply(3));

        /** The following example demonstrate result of andThen method
         *
         * The function square can be applied to calculate a square of an integer
         * and then function factorial (represented by input param)
         * will calculate a factorial of a previous result. */
        Function<Integer, Integer> factorial = i -> {
            int result=1;
            for (int j = 1; j <= i; j++) {
                result *= j;
            }
            return result;
        };
        System.out.println("\nThis Function use andThen:");
        System.out.println("It is identical to the mathematical expression (n^2)!\n" +
                "The result of (3^2)! is "+ square.andThen(factorial).apply(3));

        /** The following example demonstrate result of compose method
         *
         * In this case, compose method returns a composed function
         * that first calculate a factorial of an input integer,
         * and then calculate a square of a previous result. */
        System.out.println("\nThis Function use compose:");
        System.out.println("It is identical to the mathematical expression (n!)^2\n" +
                "The result of (3!)^2 is "+ square.compose(factorial).apply(3));

        /** UnaryOperator is a specialization of Function for the case where the operand and result are of the same type. */
        System.out.println("\nCompare UnaryOperator with Function");
        UnaryOperator<Integer> unaryOperatorSqrt = i -> i * i;
        System.out.println(unaryOperatorSqrt.apply(2));

        /** The same result with Function. */
        Function<Integer, Integer> functionSqrt = i -> i * i;
        System.out.println(functionSqrt.apply(2));
    }
}
