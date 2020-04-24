package pirates;

public class BattleApp {
  public static void main(String[] args) {
    Ship ship1= new Ship();
    Ship ship2 = new Ship();

    ship1.fillShip();
    ship2.fillShip();

    represent(ship1);
    represent(ship2);

    ship1.getShip().get(0).isDead();
    ship1.getShip().get(0).howsItGoingMate();
    ship1.getShip().get(0).howsItGoingMate();

    boolean firstWins = ship1.battle(ship2);
    System.out.println("---------------------------");
    System.out.println((firstWins ? "First" : "Second") + " ship wins the battle");
    System.out.println("---------------------------");

    represent(ship1);
    represent(ship2);
  }

  public static void represent(Ship ship){
    System.out.println("The ship's crew is " + ship.getShip().size());
    System.out.println("The captain consumed rum " + ship.getShip().get(0).rumLevel + " times.");
    if (ship.getShip().get(0).isPassedOut || ship.getShip().get(0).isDead){
      System.out.println("The captain is not available.");
    }
    int pirateCount=0;
    for (int i = 1; i < ship.getShip().size(); i++) {
      if (!ship.getShip().get(i).isDead || !ship.getShip().get(i).isPassedOut){
        pirateCount++;
      }
    }
    System.out.println("The number of alive pirates in the crew is " + pirateCount);
    System.out.println();
  }
}
