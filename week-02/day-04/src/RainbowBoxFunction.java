import javax.swing.*;

import java.awt.*;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
    public static void mainDraw(Graphics graphics) {
        // Create a square drawing function that takes 3 parameters:
        // The square size, the fill color, graphics
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).

  /*      for (int i = 0; i < 10; i++) {

            int size = 200 - i * 30;
            Color rectColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

            drawSquares(size, rectColor, graphics);

        }*/

        Color[] fillColors = {Color.RED, Color.orange, Color.yellow, Color.green, Color.BLUE, new Color(75, 0, 130), new Color(128, 0, 128)};

        for (int i = 0; i < fillColors.length; i++) {
            int size = 200 - i * 30;
            Color rectColor = fillColors[i];

            drawSquares(size, rectColor, graphics);

        }
    }

    public static void drawSquares(int size, Color rectColor, Graphics graphics) {
        graphics.setColor(rectColor);
        graphics.fillRect(WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, size, size);
    }

    /*
        Questions:

        I cannot draw squares on each other (solved)

        but how to do indigo and violet etc
        Color fillColor = new Color(Color.);

        should I define the above given colors and loop them?
*/
    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}