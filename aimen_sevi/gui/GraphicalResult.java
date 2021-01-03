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
    JPanel mainPane = new JPanel();
    mainPane.setLayout(null);
    this.setLayout(new BorderLayout());
    this.result = new JLabel(result);
    Font titleFont = new Font("Arial",Font.BOLD,75);
    this.result.setFont(titleFont);
    // this.result.setBounds(150,120,300, 110);
    // this.result.setHorizontalAlignment(JLabel.CENTER);
    // this.result.setVerticalAlignment(JLabel.CENTER);
    if(result.equals("GAGNÉ")) this.wonPane(); //this.result.setForeground(new Color (0,150,0));
    else this.lostPane();//this.result.setForeground(new Color (255,0,0));
    Font font = new Font("Arial",Font.BOLD,40);
    this.back = new MenuItem("Retour", font);
    this.back.setBounds(160,440,280, 60);
    this.back.setForeground(Color.BLACK);
    this.back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.back.setHorizontalAlignment(JLabel.CENTER);
    this.back.setVerticalAlignment(JLabel.CENTER);
    mainPane.add(this.result);
    mainPane.add(this.back);
    this.add(mainPane, BorderLayout.CENTER);
  }

  public void wonPane()
  {
    this.result.setBounds(90,120,300, 110);
    this.result.setHorizontalAlignment(JLabel.CENTER);
    this.result.setVerticalAlignment(JLabel.CENTER);
    this.result.setForeground(new Color(0,150,0));
    //affichage du score du niveau
    //affichage du nombre d'etoiles
    //affichage du meilleur score du joueur pour ce niveau
    //si le niveau suivant était verouillé alors afficher 'niveau suivant déverouillé'
  }

  public void lostPane()
  {
    this.result.setBounds(90,120,300, 110);
    this.result.setHorizontalAlignment(JLabel.CENTER);
    this.result.setVerticalAlignment(JLabel.CENTER);
    this.result.setForeground(new Color (255,0,0));
    //affichage du score et de l'objectif
    //affichage du nb d'animaux sauvés et du nb d'animaux qu'il fallait sauver
  }


  // public void paint(Graphics g) {
	// 	super.paint(g);
	// 	Color c = g.getColor();
	// 	g.setColor(Color.RED);
	// 	g.fillRect(0,0,2800,8000);
	// 	g.setColor(Color.BLUE);
	// }

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
