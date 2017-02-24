package introduction;

import java.time.LocalDate;

/**
 * Created by yevgen on 20.02.17.
 */
public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Person() {
        this.firstName = "No name";
        this.lastName = "No last name";
        this.birthday = LocalDate.now();
    }

    public Person(String first, String last, String birthday) {
        this.firstName = first;
        this.lastName = last;
        this.birthday = LocalDate.parse(birthday.subSequence(0, birthday.length()));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = (now.minusYears(this.birthday.getYear())).getYear();
        if (this.birthday.getDayOfYear() > now.getDayOfYear()){
            age--;
        }
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " is " + getAge() + " years old.";
    }
}
