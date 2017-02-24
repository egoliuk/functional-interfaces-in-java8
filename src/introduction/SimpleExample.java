package introduction;


/**
 * Created by yevgen on 23.02.17.
 */
public class SimpleExample {
    public static void main(String[] args) {

//        SimpleFI instanceOfFI = new SimpleFI() {
//            @Override
//            public void apply() {
//                System.out.println("Hello world!");
//            }
//        };

        SimpleFI instanceOfFI = () -> System.out.println("Hello world!");
        instanceOfFI.apply();

        GenericFI<String, Integer> toInteger = str -> Integer.valueOf(str);
        System.out.println(toInteger.apply("123").getClass().getTypeName());

        eval("123", str -> Integer.valueOf(str));
    }

    /**
     * Helper method to evaluate functional interface on the given argument and display results
     *
     * @param str is a arguments for functional method.
     * @param toInteger is a function that accepts String value argument and produces a Integer value result.
     */
    public static void eval(String str, GenericFI<String, Integer> toInteger) {
        System.out.println(toInteger.apply(str));
    }
}
