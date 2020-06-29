package aaPockemon;

import pokemon.Pokemon;

public class Pockemon {
  String name;
  public String type = "";
  String effectiveAgainst;

  public void Pokemon(String name, String type, String effectiveAgainst) {
    this.name = name;
    this.type = type;
    this.effectiveAgainst = effectiveAgainst;
  }

  boolean isEffectiveAgainst(Pokemon anotherPokemon) {
    return this.effectiveAgainst.equals(anotherPokemon.type);
  }
}
