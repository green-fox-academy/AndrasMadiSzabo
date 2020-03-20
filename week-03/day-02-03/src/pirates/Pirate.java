package pirates;

public class Pirate {

    private boolean isDead;
    private boolean passOut;
    private boolean isCaptain;
    int nrOfDrinks;

    public Pirate() {
    }

    public void drinkSomeRum() {
            nrOfDrinks++;
    }

    public void howsItGoingMate() {
        if (nrOfDrinks < 4 && !this.isDead) {
            System.out.println("\"Pour me anudder!\"");
            drinkSomeRum();
        } else if (this.isDead){
            System.out.println("He is dead!");
        } else {
            System.out.println("\"Arghh, I'ma Pirate. How d'ya d'ink its goin?\"");
            this.setPassOut(true);
            }
        }

    public void die() {
        this.isDead = true;
        System.out.println("He is dead.");;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isPassOut() {
        return passOut;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setPassOut(boolean passOut) {
        this.passOut = passOut;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public void brawl(Pirate pirate2) {
        // check if they are alive or passed out

        int chance = (int) Math.floor(Math.random() * 3);
        if (chance == 0) {
            this.die();
            System.out.println("This piarate died.");;
        } else if (chance == 1) {
            pirate2.die();
            System.out.println("The other pirate died.");;
        } else {
            this.setPassOut(true);
            pirate2.setPassOut(true);
            System.out.println("Both pirates passed out.");
        }
    }

}
