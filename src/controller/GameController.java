package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.GameModel;
import view.GamePanel;

public class GameController implements ActionListener {

  private GameModel model;
  private GamePanel view;

  public Timer timer;
  private final int delay = 35;

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
}
