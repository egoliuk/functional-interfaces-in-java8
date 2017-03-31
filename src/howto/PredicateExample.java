package howto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yevgen on 20.02.17.
 */
public class PredicateExample {

    public static void main(String[] args) {

        /** Create a collection of integers to demonstrate. */
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        /** Create a predicate to checks whether the integer is an even number. */
        Predicate<Integer> predicateForEvenNumbers = n -> n % 2 == 0;
        eval(integers, predicateForEvenNumbers, "Print even numbers:");

        /** Print even numbers greater than 5 */
        Predicate<Integer> predicateGreaterThanFive = n -> n > 5;
        eval(integers,
            predicateForEvenNumbers.and(predicateGreaterThanFive),
            "Print even numbers greater than 5:");

        /** Print the same */
        eval(integers, n -> n % 2 == 0 && n > 5, "Print the same:");

        /** Print odd numbers */
        eval(integers, predicateForEvenNumbers.negate(), "Print odd numbers:");

        /** Print true if a collection contains more than five or less than three integers */
        Predicate<List<Integer>> isMoreThanFive  = (list)-> list.size() > 5;
        Predicate<List<Integer>> isLessThanThree  = (list)-> list.size() < 3;

        System.out.println("Print \"true\" if one of the conditions is satisfied\n"
                +isMoreThanFive.or(isLessThanThree).test(integers));

        /** Print all even numbers or odd numbers greater than 5 */
        eval(integers,
            predicateForEvenNumbers
                    .or(predicateForEvenNumbers
                    .negate()
                    .and(predicateGreaterThanFive)),
            "Print all even numbers or odd numbers greater than 5:");
    }

    /**
     * Helper method to evaluate predicate on the given argument and display results
     *
     * @param list      is a collection of arguments for predicate.
     * @param predicate is boolean-valued function which we are testing.
     * @param banner    is a header of output info.
     */
    public static void eval(List<Integer> list, Predicate<Integer> predicate, String banner) {
        System.out.println(banner);
        list.stream()
                .filter(predicate)
                .forEach(s -> System.out.println(s));
        System.out.println("\n");
    }
}
