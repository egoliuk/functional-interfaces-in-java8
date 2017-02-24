package howto;

import java.util.function.Supplier;

/**
 * Created by yevgen on 20.02.17.
 */
public class SupplierExample {
    public static void main(String[] args) {

        /** Print "Hello world!" */
        Supplier<String> supplier  = () -> "Hello world!";
        System.out.println(supplier.get());
    }
}
