package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import pack.*;
import levelpack.Level;
/**
 * Classe représentant le panel à la fin d'un niveau
 */
public  class GraphicalResult extends JPanel
{
  MenuItem back;
  JLabel result;
  JLabel score;
  JLabel bestScore;
  JPanel mainPane;
  JLabel unlocked;
  JPanel starsResult;
  JLabel star1;
  JLabel star2;
  JLabel star3;
  /**
   * Constructeur du panel à la fin d'un niveau
   * @method GraphicalResult
   * @param  result          la chaîne permettant de savoir si on a gangé ou perdu
   * @param  score           le score obtenu à la fin du niveau
   * @param  bestScore       le meilleur score qu'on a pour ce niveau
   * @param  unlocked        savoir si on a déverouillé le prochain niveau
   * @param  stars           le nombre d'étoiles remportées
   * @param  objectif        l'objectif qu'il fallait atteindre (utile en cas de perte)
   * @param  animalsRescued  le nombre d'animeaux qu'on a sauvé (utile en cas de perte)
   * @param  animalsToRescue le nombre d'animeaux qu'il fallait sauver (utile en cas de perte)
   */
  public GraphicalResult (String result, int score, int bestScore, boolean unlocked, int stars,int objectif, int animalsRescued, int animalsToRescue)
  {
    this.mainPane = new JPanel();
    this.mainPane.setLayout(null);
    this.setLayout(new BorderLayout());
    this.result = new JLabel(result);
    Font titleFont = new Font("Arial",Font.BOLD,75);
    this.result.setFont(titleFont);
    if(result.equals("GAGNÉ"))
    {
      this.wonPane(score,bestScore,unlocked,stars);
    }
    else
    {
      this.lostPane(score,objectif,animalsRescued,animalsToRescue);
    }

    Font font = new Font("Arial",Font.BOLD,60);
    this.back = new MenuItem("Retour", font);
    this.back.setBounds(160,440,280, 60);
    this.back.setForeground(Color.BLACK);
    this.back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.back.setHorizontalAlignment(JLabel.CENTER);
    this.back.setVerticalAlignment(JLabel.CENTER);


    this.mainPane.add(this.back);
    this.add(mainPane, BorderLayout.CENTER);
  }
  /**
   * Cette méthode construit l'affichage si on gagne le niveau
   * @method wonPane
   * @param  score     le score qu'on a atteint
   * @param  bestScore le meilleur socre qu'on a pour ce niveau
   * @param  b         boolean permettant de savoir si on a dévérrouillé le prochain niveau
   * @param  stars     le nombre d'etoiles remportées
   */
  public void wonPane(int score, int bestScore, boolean b, int stars)
  {
    Font font = new Font("Arial",Font.ITALIC,20);
    this.result.setBounds(150,30,300, 110);
    this.result.setHorizontalAlignment(JLabel.CENTER);
    this.result.setVerticalAlignment(JLabel.CENTER);
    this.result.setForeground(Color.GREEN);
    this.mainPane.add(this.result);

    this.score = new JLabel("Score : " + score);
    this.score.setFont(font);
    this.score.setBounds(150,150,300, 110);
    this.score.setHorizontalAlignment(JLabel.CENTER);
    this.score.setVerticalAlignment(JLabel.CENTER);
    this.score.setForeground(Color.BLACK);
    this.mainPane.add(this.score);

    this.bestScore = new JLabel("Meilleur score : " + bestScore);
    this.bestScore.setFont(font);
    this.bestScore.setBounds(150,180,300, 110);
    this.bestScore.setHorizontalAlignment(JLabel.CENTER);
    this.bestScore.setVerticalAlignment(JLabel.CENTER);
    this.bestScore.setForeground(Color.BLACK);
    this.mainPane.add(this.bestScore);

    this.starsResult = new JPanel();
    this.starsResult.setBounds(125,250,350,100);
    this.displayStars(stars);

    if(b)
    {
      this.unlocked = new JLabel("Vous avez dévérouillé le niveau suivant");
      this.unlocked.setFont(font);
      this.unlocked.setBounds(100,310,400, 110);
      this.unlocked.setHorizontalAlignment(JLabel.CENTER);
      this.unlocked.setVerticalAlignment(JLabel.CENTER);
      this.unlocked.setForeground(Color.BLACK);
      this.mainPane.add(this.unlocked);
    }
    //affichage du score du niveau
    //affichage du nombre d'etoiles
    //affichage du meilleur score du joueur pour ce niveau
    //si le niveau suivant était verouillé alors afficher 'niveau suivant déverouillé'
  }
  /**
   * Cette méthode construit l'affichage si on perd le niveau
   * @method lostPane
   * @param  score          le score obtenu
   * @param  objectif       l'objectif à atteindre
   * @param  animalsRescued le nombre d'animeaux sauvés
   * @param  animalsToSave  le nombre d'animeaux qu'il fallait sauver
   */
  public void lostPane( int score, int objectif, int animalsRescued, int animalsToSave)
  {
    Font font = new Font("Arial",Font.ITALIC,20);
    this.result.setBounds(150,30,300, 110);
    this.result.setHorizontalAlignment(JLabel.CENTER);
    this.result.setVerticalAlignment(JLabel.CENTER);
    this.result.setForeground(Color.RED);
    this.mainPane.add(this.result);

    this.score = new JLabel("Score : " + score + " / " + objectif);
    this.score.setFont(font);
    this.score.setBounds(150,150,300, 110);
    this.score.setHorizontalAlignment(JLabel.CENTER);
    this.score.setVerticalAlignment(JLabel.CENTER);
    this.score.setForeground(Color.BLACK);
    this.mainPane.add(this.score);

    this.bestScore = new JLabel("Animaux sauvés : " + animalsRescued + " / " + animalsToSave);
    this.bestScore.setFont(font);
    this.bestScore.setBounds(150,180,300, 110);
    this.bestScore.setHorizontalAlignment(JLabel.CENTER);
    this.bestScore.setVerticalAlignment(JLabel.CENTER);
    this.bestScore.setForeground(Color.BLACK);
    this.mainPane.add(this.bestScore);

    // this.starsResult = new JPanel();
    // this.starsResult.setBounds(125,250,350,100);
    // this.displayStars(stars);
  }
  /**
   * Cette méthode permet l'affichage des étoiles
   * @method displayStars
   * @param  a            le nombre d'étoiles à afficher
   */
  public void displayStars(int a)
  {
    ImageIcon greyStar = new ImageIcon("../ressources/images/star.png");
    ImageIcon yellowStar = new ImageIcon("../ressources/images/yellow_star.png");

    switch (a)
    {
      case 1:
      try {
        this.star1 = new JLabel(yellowStar);
        this.star2 = new JLabel(greyStar);
        this.star3 = new JLabel(greyStar);
        this.starsResult.add(star1);
        this.starsResult.add(star2);
        this.starsResult.add(star3);
      }
      catch (Exception e) {
        System.out.println("image non trouvé");
      }
      break;

      case 2:
      try {
        this.star1 = new JLabel(yellowStar);
        this.star2 = new JLabel(yellowStar);
        this.star3 = new JLabel(greyStar);
        this.starsResult.add(star1);
        this.starsResult.add(star2);
        this.starsResult.add(star3);
      }
      catch (Exception e) {
        System.out.println("image non trouvé");
      }
      break;

      case 3:
      try {
        this.star1 = new JLabel(yellowStar);
        this.star2 = new JLabel(yellowStar);
        this.star3 = new JLabel(yellowStar);
        this.starsResult.add(star1);
        this.starsResult.add(star2);
        this.starsResult.add(star3);
      }
      catch (Exception e) {
        System.out.println("image non trouvé");
      }
      break;
    }
    mainPane.add(starsResult);
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
