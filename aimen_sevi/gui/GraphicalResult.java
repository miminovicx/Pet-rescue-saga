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
  JLabel score;
  JLabel bestScore;
  JPanel mainPane;
  public GraphicalResult (String result, Player player, int score, int bestScore)
  {
    this.mainPane = new JPanel();
    this.mainPane.setLayout(null);
    this.setLayout(new BorderLayout());
    this.result = new JLabel(result);
    this.score = new JLabel("Score : " + score);
    this.bestScore = new JLabel("Meilleur score : " + bestScore);
    Font titleFont = new Font("Arial",Font.BOLD,75);
    this.result.setFont(titleFont);
    // this.result.setBounds(150,120,300, 110);
    // this.result.setHorizontalAlignment(JLabel.CENTER);
    // this.result.setVerticalAlignment(JLabel.CENTER);
    if(result.equals("GAGNÉ")) this.wonPane(player,score,true); //this.result.setForeground(new Color (0,150,0));
    else this.lostPane(player,score,true);//this.result.setForeground(new Color (255,0,0));
    Font font = new Font("Arial",Font.BOLD,40);
    this.back = new MenuItem("Retour", font);
    this.back.setBounds(160,440,280, 60);
    this.back.setForeground(Color.BLACK);
    this.back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.back.setHorizontalAlignment(JLabel.CENTER);
    this.back.setVerticalAlignment(JLabel.CENTER);
    // this.mainPane.add(this.result);
    this.mainPane.add(this.back);
    this.add(mainPane, BorderLayout.CENTER);
  }

  public void wonPane(Player player, int score, boolean b)
  {
    Font font = new Font("Arial",Font.ITALIC,15);
    this.result.setBounds(150,30,300, 110);
    this.result.setHorizontalAlignment(JLabel.CENTER);
    this.result.setVerticalAlignment(JLabel.CENTER);
    this.result.setForeground(Color.GREEN);
    this.mainPane.add(this.result);

    this.score.setFont(font);
    this.score.setBounds(150,150,300, 110);
    this.score.setHorizontalAlignment(JLabel.CENTER);
    this.score.setVerticalAlignment(JLabel.CENTER);
    this.score.setForeground(Color.BLACK);
    this.mainPane.add(this.score);

    this.bestScore.setFont(font);
    this.bestScore.setBounds(150,180,300, 110);
    this.bestScore.setHorizontalAlignment(JLabel.CENTER);
    this.bestScore.setVerticalAlignment(JLabel.CENTER);
    this.bestScore.setForeground(Color.BLACK);
    this.mainPane.add(this.bestScore);
    //affichage du score du niveau
    //affichage du nombre d'etoiles
    //affichage du meilleur score du joueur pour ce niveau
    //si le niveau suivant était verouillé alors afficher 'niveau suivant déverouillé'
  }

  public void lostPane( Player player, int score, boolean b)
  {
    this.result.setBounds(150,30,300, 110);
    this.result.setHorizontalAlignment(JLabel.CENTER);
    this.result.setVerticalAlignment(JLabel.CENTER);
    this.result.setForeground(Color.RED);
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
