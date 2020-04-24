package pirates2;

import java.util.Random;

public class Pirate {
  protected int intoxicationLevel;
  private boolean isPassedOut;
  private boolean isDead;
  protected boolean isCaptain;

  public Pirate(boolean isCaptain) {
    this.isCaptain = isCaptain;
  }

  public void drinkSomeRum() {
    if (isDead) {
      System.out.println("he's dead");
    } else {
      intoxicationLevel++;
    }
  }

  public void howsItGoingMate() {
    if (intoxicationLevel <= 4) {
      System.out.println("Pour me anudder!");
    } else {
      System.out.println("Pour me anudder!");
      isPassedOut = true;
      intoxicationLevel--;
    }
  }

  public void die() {
    isDead = true;
  }

  public void brawl(Pirate otherPirate) {
    Random random = new Random();
    int chance = random.nextInt(3);
    if (chance == 0){
      this.isDead=true;
    }else if (chance == 1){
      otherPirate.isDead=true;
    }else {
      this.isPassedOut=true;
      otherPirate.isPassedOut=true;
    }
  }

  public int chance() {
    Random random = new Random();
    int chanceValue = random.nextInt(2);
    return chanceValue;
  }

}
