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
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public  class GraphicalResult extends JPanel
{
  MenuItem back;
  JLabel result;
  public GraphicalResult (String result)
  {
    this.removeAll();
    repaint();
    JPanel mainPane = new JPanel();
    mainPane.removeAll();
    mainPane.setLayout(new GridLayout(2,1));
    this.setLayout(new BorderLayout());
    this.result = new JLabel(result);
    Font titleFont = new Font("Arial",Font.BOLD,100);
    this.result.setFont(titleFont);
    this.result.setHorizontalAlignment(JLabel.CENTER);
    this.result.setVerticalAlignment(JLabel.CENTER);
    if(result.equals("GAGNÉ")) this.result.setForeground(new Color (0,150,0));
    else this.result.setForeground(new Color (255,0,0));
    Font font = new Font("Arial",Font.BOLD,20);
    this.back = new MenuItem("Retour", true, font);
    this.back.setHorizontalAlignment(JLabel.CENTER);
    this.back.setVerticalAlignment(JLabel.CENTER);
    mainPane.add(this.result);
    mainPane.add(this.back);
    this.add(mainPane, BorderLayout.CENTER);
  }

  // public void paint(Graphics g)
  // {
  //     // Appel de la méthode paintComponent de la classe mère
  //     super.paintComponent(g);
  //     // Conversion en un contexte 2D
  //     Graphics2D g2 = (Graphics2D) g;
  //     try
  //     {
  //       String path = "../ressources/images/bg.png";
  //       InputStream is = new BufferedInputStream(new FileInputStream(path));
  //       Image image = ImageIO.read(is);
  //       g2.drawImage(image,0,0,null);
  //     }
  //     catch (Exception l_e)
  //     {
  //       System.out.println("fichier introuvable");
  //     }
  //     // Utilisation de g2
  // }
}
