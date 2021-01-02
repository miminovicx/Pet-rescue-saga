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

public  class GraphicalMenu extends JPanel
{

  MenuItem play;
  MenuItem help;
  MenuItem quit;
  public GraphicalMenu ()
  {
    JPanel mainPane = new JPanel();
    this.setLayout(null);
    Font font = new Font("Arial",Font.BOLD,40);
    this.play = new MenuItem("Jouer", font);
    this.help = new MenuItem("Aide", font);
    this.quit = new MenuItem("Quitter", font);
    this.play.setBounds(210,110,200, 60);
    this.play.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.play.setHorizontalAlignment(JLabel.CENTER);
    this.play.setVerticalAlignment(JLabel.CENTER);
    this.help.setBounds(210,180,200, 60);
    this.help.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.help.setHorizontalAlignment(JLabel.CENTER);
    this.help.setVerticalAlignment(JLabel.CENTER);
    this.quit.setBounds(210,250,200, 60);
    this.quit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.quit.setHorizontalAlignment(JLabel.CENTER);
    this.quit.setVerticalAlignment(JLabel.CENTER);
    this.add(play);
    this.add(help);
    this.add(quit);
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
