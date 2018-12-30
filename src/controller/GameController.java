package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import model.GameModel;
import view.GamePanel;

import static java.awt.event.KeyEvent.VK_SPACE;

public class GameController implements ActionListener, KeyListener {

  private GameModel model;
  private GamePanel view;

  public Timer timer;
  private final int delay = 20;

  public GameController(GameModel model, GamePanel view) {

    this.model = model;
    this.view = view;

    timer = new Timer(delay, this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    model.movePipes();
    view.repaint();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == VK_SPACE) {
      model.jump();
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
