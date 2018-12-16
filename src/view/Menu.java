package view;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame {

  public Menu() {
    JFrame menu = new JFrame("Flappy Bird");

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.add(new JLabel(new ImageIcon("src/images/background.png")));
    menu.pack();
    menu.setVisible(true);
    menu.setResizable(false);
  }

}

