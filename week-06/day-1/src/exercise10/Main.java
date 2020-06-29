package exercise10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<GreenFox> foxes = new ArrayList<>(Arrays.asList(
        new GreenFox("Foxi", Color.GREEN, 4),
        new GreenFox("Fixi", Color.RED, 3),
        new GreenFox("Fuxi", Color.SILVER, 4),
        new GreenFox("Faxi", Color.GREEN, 5),
        new GreenFox("Faxi", Color.RED, 5),
        new GreenFox("Faxi", Color.GREEN, 4)
        ));

    foxes.stream()
        .filter(f -> f.getColor() == Color.GREEN)
        .forEach(f -> System.out.println(f.getName()));

    System.out.println("----------");

    foxes.stream()
        .filter(f -> f.getColor() == Color.GREEN && f.getAge() < 5)
        .forEach(f -> System.out.println(f.getName()));

    System.out.println("----------");

    Map<Color, Long> greenFoxColorMap = foxes.stream()
        .collect(Collectors.groupingBy(GreenFox::getColor, Collectors.counting()));
    greenFoxColorMap.forEach((k,v) -> System.out.println(k + ": " + v));

  }
}
