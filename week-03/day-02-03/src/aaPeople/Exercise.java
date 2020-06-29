package aaPeople;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.function.Predicate;
import org.junit.platform.commons.util.CollectionUtils;

public class Exercise {


  public static void main(String[] args) {

    List<Person> people = Arrays.asList(
        new Person("Charles","Dickens", 60),
        new Person("Lewis", "Carroll", 42),
        new Person("Thomas", "Carlyle", 51),
        new Person("Charlotte", "Bronte", 45),
        new Person("Matthew", "Arnold", 39)
    );

    people.sort((Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));

    Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

    people.sort(new Comparator<Person>() {
      @Override
      public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
      }
    });

    printAll(people);
    System.out.println();
    print(people, "D");

    System.out.println("Count = " + CollectionUtils.toStream(people).count());

    printWithLambda(people, person -> person.getLastName().startsWith("A"));

    printConditionally(people, new MyCondition() {
      @Override
      public boolean teszt(Person p) {
        return p.getLastName().startsWith("C");
      }
    });
  }

  private static void printConditionally(List<Person> people, MyCondition myCondition) {
    for (Person p : people) {
      if (p.getFirstName().startsWith("C")) {
        System.out.println(p.getFirstName() + " " + p.getLastName());
      }
    }
  }

  private static void printWithLambda(List<Person> people, Predicate<Person> predicate) {
    for (Person p: people) {
      if (predicate.test(p)) {
        System.out.println(p.getFirstName() + " " + p.getLastName());
      }
    }
  }

  public static void printAll(List<Person> people){
    for (Person person : people) {
      System.out.println(person.getFirstName() + " " + person.getLastName() + ", " + person.getAge());
    }
  }

  public static void print(List<Person> people, String c){
    for (Person person : people) {
      if (person.getLastName().startsWith(c))
      System.out.println(person.getFirstName() + " " + person.getLastName() + ", " + person.getAge());
    }
  }

  interface MyCondition {
    boolean teszt(Person p);
  }

  }


