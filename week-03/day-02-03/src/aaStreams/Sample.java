package aaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
  public static List<Person> createPeople(){
    return Arrays.asList(
        new Person("Sara", Gender.FEMALE, 20),
        new Person("Sara", Gender.FEMALE, 22),
        new Person("Bob", Gender.MALE, 20),
        new Person("Paula", Gender.FEMALE, 32),
        new Person("Paul", Gender.MALE, 32),
        new Person("Jack", Gender.MALE, 2),
        new Person("Jack", Gender.MALE, 72),
        new Person("Jill", Gender.FEMALE, 12)
    );
  }

  public static void main(String[] args) {
    List<Person> people = createPeople();

    people.stream()
            .filter(person -> person.getAge() > 18)
            .filter(person -> person.getGender().equals(Gender.FEMALE))
            .forEach(s -> System.out.println(s.getName().toUpperCase()));

    System.out.println();
    //List<String> names =
        people.stream()
        .filter(person -> person.getAge() > 18)
        .filter(person -> person.getGender().equals(Gender.FEMALE))
        .map(Person::getName)
            .map(String::toUpperCase)
        .forEach(System.out::println);
    //System.out.println(names);

    System.out.println();
    for (Person p : people) {
      if (p.getAge() > 18 && p.getGender().equals(Gender.FEMALE)) {
        System.out.println(p.getName().toUpperCase());
      }
    }

  }
}
