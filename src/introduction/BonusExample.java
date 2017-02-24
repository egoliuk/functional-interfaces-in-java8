package introduction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yevgen on 22.02.17.
 */
public class BonusExample {
    public static void main(String[] args) {

        System.out.println(LocalDate.now());

        List<Person> persons  = new ArrayList<>();
        persons.add(new Person("Richard", "Dawkins", "1941-03-26"));
        persons.add(new Person("Richard", "Feynman", "1918-05-11"));
        persons.add(new Person("Douglas", "Hofstadter", "1945-02-15"));
        persons.add(new Person("Martin", "Odersky", "1958-09-15"));

        Predicate<Person> oldStylePredicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                if(person.getFirstName().equals("Richard")) return true;
                else return false;
            }
        };

        Predicate<Person> newStylePredicate = person -> "Richard".equals(person.getFirstName());
        eval(persons, newStylePredicate, "Print all persons named Richard:");

        Predicate<Person> predicateByAge = person -> person.getAge() < 75;
        eval(persons, predicateByAge, "Print a list of persons under the age of 75:");

        System.out.println("Print persons named Douglas and under the age of 90:");
        persons.stream()
                .filter(person -> person.getAge() < 90
                        && person.getFirstName().equals("Douglas"))
                .forEach(s -> System.out.println(s));
    }

    /**
     * Helper method to evaluate predicate on the given argument and display results
     *
     * @param persons is a collection of Persons for predicate.
     * @param predicate is boolean-valued function which we are testing.
     * @param banner is a header of output info.
     */
    public static void eval(List<Person> persons, Predicate<Person> predicate, String banner) {
        System.out.println(banner);
        persons.stream()
                .filter(predicate)
                .forEach(s -> System.out.println(s));
//        Java 7 code style
//        for (Person p : persons) {
//            if (predicate.test(p)) {
//                System.out.println(p);
//            }
//        }
        System.out.println("\n");
    }

}
