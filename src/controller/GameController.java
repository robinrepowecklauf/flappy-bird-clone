package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {

  private final int delay = 50;

  public Timer timer;

  public GameController() {

    timer = new Timer(delay, new TimerListener());
  }

  private class TimerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
  }
}
