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

public  class HomeMenu extends JPanel
{

  MenuItem start;
  MenuItem quit;
  public HomeMenu ()
  {
    this.setLayout(new BorderLayout());


    JLabel title = new JLabel("PetRescue");
    Font titleFont = new Font("Arial",Font.ITALIC,75);
    title.setFont(titleFont);
    title.setForeground(Color.GRAY);
    title.setHorizontalAlignment(JLabel.CENTER);

    JPanel menu = new JPanel(null);

    Font font = new Font("Arial",Font.BOLD,40);

    this.start = new MenuItem("Commencer", font);
    this.start.setBounds(160, 100, 280, 60);
    this.start.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.start.setHorizontalAlignment(JLabel.CENTER);

    this.quit = new MenuItem("Quitter", font);
    this.quit.setBounds(160, 175, 280, 60);
    this.quit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.quit.setHorizontalAlignment(JLabel.CENTER);

    menu.add(start);
    menu.add(quit);

    this.add(title,BorderLayout.NORTH);
    this.add(menu,BorderLayout.CENTER);

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
