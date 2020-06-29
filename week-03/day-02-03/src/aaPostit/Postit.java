package aaPostit;

  class Sharpie{
  private String color;
  private float width;
  private float inkAmount;

  public Sharpie(String color, float width){
    this.color = color;
    this.width = width;
    this.inkAmount = 100;
  }

    public Sharpie() {

    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public float getWidth() {
      return width;
    }

    public void setWidth(float width) {
      this.width = width;
    }

    public float getInkAmount() {
      return inkAmount;
    }

    public void setInkAmount(float inkAmount) {
      this.inkAmount = inkAmount;
    }

    public float use(float decrease){
    inkAmount -= decrease;
    return inkAmount;
  }
}

//Create Sharpie class
//We should know about each sharpie their color (which should be a string),
// width (which will be a floating point number), inkAmount (another floating point number)
//    When creating one, we need to specify the color and the width
//    Every sharpie is created with a default 100 as inkAmount
//    We can use() the sharpie objects
//    which decreases inkAmount

public class Postit {
  private Colors backgroundColor;
  private String text;
  private Colors textColor;

  public static void print(Postit postit) {
    System.out.println("backgroundColor = " + postit.backgroundColor + ", text = " + postit.text + ", textColor = " + postit.textColor);
  }

  public static void main(String[] args) {

    Sharpie sharpie = new Sharpie();
    sharpie.use(2);
    System.out.println(sharpie.getInkAmount());

    Sharpie sharpie1 = new Sharpie("green", 3);
    sharpie1.use(2);
    System.out.println(sharpie1.getInkAmount());
    System.out.println(sharpie1.use(3));

    Postit postit1 = new Postit();

    postit1.text = "Idea 1";
    postit1.backgroundColor = Colors.ORANGE;
    postit1.textColor = Colors.BLUE;

    var postit2 = new Postit();

    postit2.textColor = Colors.BLUE;
    postit2.text = "Awesome";
    postit2.backgroundColor = Colors.PINK;

    var postit3 = new Postit();
    postit3.text = "Superb!";
    postit3.backgroundColor = Colors.YELLOW;
    postit3.textColor = Colors.BLACK;

    System.out.println(postit1.toString());
    postit1.print();
    print(postit1);

  }

  @Override
  public String toString() {
    return "Postit{" +
        "backgroundColor='" + backgroundColor + '\'' +
        ", text='" + text + '\'' +
        ", textColor='" + textColor + '\'' +
        '}';
  }

  public void print() {
    System.out.println("backgroundColor = " + backgroundColor + ", text = " + text + ", textColor = " + textColor);
  }
}
