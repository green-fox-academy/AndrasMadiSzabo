package com.gf.foxclub.services;

import com.gf.foxclub.models.Fox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter

@Service
public class FoxService {

  private List<Fox> foxList = new ArrayList<>(Arrays.asList(
      new Fox("Karak"),
      new Fox("Foxi")));

  public Fox getFoxByName(String name) {
    Optional<Fox> optionalFox = foxList.stream()
        .filter(fox -> fox.getName().equals(name))
        .findFirst();
    return optionalFox.orElse(null);
  }

  public void addFox(String name) {
    Fox myFox = new Fox(name);
    System.out.println(myFox.getName());
    System.out.println(foxList);
    foxList.add(myFox);
    System.out.println(myFox.getName());
    System.out.println(foxList);
  }
  

}
