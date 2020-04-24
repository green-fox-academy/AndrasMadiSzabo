package objects.postIt;

public class Main {
  public static void main(String[] args) {

  PostIt idea = new PostIt("orange", "blue", "Idea 1");
  PostIt awesome = new PostIt("pink", "black", "Awesome");
  PostIt superb = new PostIt("yellow", "green", "Superb!");

    System.out.println(idea.getBackgroundColor());
    idea.setBackgroundColor("piros");
    System.out.println(idea.getBackgroundColor());
    awesome.setText("lilac");
    System.out.println(awesome.getText());

  }
}
