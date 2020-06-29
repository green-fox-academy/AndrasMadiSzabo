package aaPeople;

import static aaPeople.Exercise.print;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javax.sound.midi.Soundbank;
import org.junit.platform.commons.util.CollectionUtils;

public class ExerciseLambda {

      public static void main(String[] args) {

        List<Person> people = Arrays.asList(
            new Person("Charles","Dickens", 60),
            new Person("Lewis", "Carroll", 42),
            new Person("Thomas", "Carlyle", 51),
            new Person("Charlotte", "Bronte", 45),
            new Person("Matthew", "Arnold", 39)
        );

        people.forEach(System.out::print);
        System.out.println();

        System.out.println(
            people.stream()
            .filter(person -> person.getLastName().startsWith("C"))
            .count()
        );

        people.sort((Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName()));

        Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        people.sort(new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
            return o1.getLastName().compareTo(o2.getLastName());
          }
        });

        System.out.println("Print with Consumer");
        perform(people, person -> System.out.println(person.getFirstName()));
        print(people, "D");
        System.out.println();

        System.out.println("Count = " + CollectionUtils.toStream(people).count());

        printWithLambda(people, person -> person.getLastName().startsWith("A"));

        System.out.println("Starts with C: ");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("Print all: ");
        printConditionally(people, p -> true);
      }

      private static void printConditionally(List<Person> people, MyCondition myCondition) {
        for (Person p : people) {
          if (myCondition.teszt(p)) {
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

      public static void perform(List<Person> people, Consumer<Person> consumer){
        for (Person person : people) {
          consumer.accept(person);
        }
      }

      interface MyCondition {
        boolean teszt(Person p);
      }

    }




