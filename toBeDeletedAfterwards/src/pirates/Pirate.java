package pirates;

public class Pirate {

  int rumLevel;
  protected boolean isPassedOut;
  protected boolean isDead;
  protected boolean isCaptain;

  public void drinkSomeRum() {
    if (isDead) {
      System.out.println("he's dead");
    } else {
      rumLevel++;
    }
  }

  public void howsItGoingMate() {
    if (isDead) {
      System.out.println("he's dead");
    } else if (rumLevel < 2) {
      System.out.println("Pour me anudder!");
    } else {
      System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
      isPassedOut = true;
    }
  }

  public void die() {
    isDead = true;
  }

  public void brawl(Pirate otherPirate) {
    int chance = (int) (Math.random() * 3 + 1);
    if (chance == 1) {
      this.isDead = true;
    } else if (chance == 2) {
      otherPirate.isDead = true;
    } else {
      this.isPassedOut = true;
      otherPirate.isPassedOut = true;
    }
  }

  public boolean isDead() {
    return isDead;
  }

  public void setDead(boolean dead) {
    isDead = dead;
  }

  public boolean isPassedOut() {
    return isPassedOut;
  }

  public void setPassedOut(boolean passedOut) {
    isPassedOut = passedOut;
  }

  public int getRumLevel() {
    return rumLevel;
  }

  public void setRumLevel(int rumLevel) {
    this.rumLevel = rumLevel;
  }
}
