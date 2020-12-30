package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import levelpack.Level;
import pack.*;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;
public class MenuItem extends JLabel
{
  boolean active;
  MenuItem(String label, boolean active, Font font)
  {
    super(label);
    this.active = active;
    this.setOpaque(true);
    // this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.setBackground(Color.GRAY);
    this.setFont(font);
  }
}
