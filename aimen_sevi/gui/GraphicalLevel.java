package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import environment_player_pack.*;
import levelpack.*;
// import levelpack.Level;
/**
 * Classe représentant un niveau graphique
 */
public  class GraphicalLevel extends JPanel
{

  Level level;
  Level save;
  MenuItem back;
  JPanel fieldLevelPane = new FieldLevelPane();
  JLabel star1;
  JLabel star2;
  JLabel star3;
  JLabel score = new JLabel("Score : 0");
  /**
   * Classe interne représentant le plateau de jeu
   */
  public  class FieldLevelPane extends JPanel
  {
    /**
     * Cette méthode permet de dessiner le plateau
     * @method paint
     * @param  g     l'objet permettant d'éffectuer les dessins
     */
    public void paint(Graphics g)
    {
      score.setFont(new Font("Arial",Font.ITALIC,20));
      score.setBounds(15, 475,500,25);

      GraphicalLevel.this.add(score);
      Graphics2D g2 = (Graphics2D) g;
      int x ;
      int y ;
      int a = (600 - GraphicalLevel.this.level.getField().getHeight()*51)/2;
      for (int i = GraphicalLevel.this.level.getField().firstLineToDisplay(); i < GraphicalLevel.this.level.getField().firstLineToDisplay() + GraphicalLevel.this.level.getField().getInterval(); i++)
      {
        for (int j = 0; j < GraphicalLevel.this.level.getField().getHeight(); j++)
        {
          x = a + (51 * j);
          y = 51 * (i - GraphicalLevel.this.level.getField().firstLineToDisplay()) ;
          switch(GraphicalLevel.this.level.getField().getElements()[i][j].getColor())
          {
            case -2: //WoodBlock
            try
            {
              String path = "../ressources/images/woodBlock.png";
              InputStream is = new BufferedInputStream(new FileInputStream(path));
              Image image = ImageIO.read(is);
              g2.drawImage(image,x,y,null);
            }
            catch (Exception l_e)
            {
              System.out.println("fichier introuvable");
            }
            break;
            //g2.setColor(Color.BLACK);
            case -1:
            // g2.fillRect(x,y,50,50);
            g2.setColor(new Color(238,238,238));
            if(GraphicalLevel.this.level.getField().getElements()[i][j].getEmoji() == 1)
            {
              try
              {
                String path = "../ressources/images/chien.png";
                InputStream is = new BufferedInputStream(new FileInputStream(path));
                Image image = ImageIO.read(is);
                g2.drawImage(image,x,y,null);
              }
              catch (Exception l_e)
              {
                System.out.println("fichier introuvable");
              }
            }
            else if(GraphicalLevel.this.level.getField().getElements()[i][j].getEmoji() == 2)
            {
              try
              {
                String path = "../ressources/images/Poule.png";
                InputStream is = new BufferedInputStream(new FileInputStream(path));
                Image image = ImageIO.read(is);
                // g2.fillRect(x,y,50,50);
                g2.drawImage(image,x,y,null);
              }
              catch (Exception l_e)
              {
                System.out.println("fichier introuvable");
              }
            }
            else if(GraphicalLevel.this.level.getField().getElements()[i][j].getEmoji() == 3)
            {
              try
              {
                String path = "../ressources/images/Cochon.png";
                InputStream is = new BufferedInputStream(new FileInputStream(path));
                Image image = ImageIO.read(is);
                // g2.fillRect(x,y,50,50);
                g2.drawImage(image,x,y,null);
              }
              catch (Exception l_e)
              {
                System.out.println("fichier introuvable");
              }
            }
            else if(GraphicalLevel.this.level.getField().getElements()[i][j].getEmoji() == 4)
            {
              try
              {
                String path = "../ressources/images/Mouton.png";
                InputStream is = new BufferedInputStream(new FileInputStream(path));
                Image image = ImageIO.read(is);
                // g2.fillRect(x,y,50,50);
                g2.drawImage(image,x,y,null);
              }
              catch (Exception l_e)
              {
                System.out.println("fichier introuvable");
              }
            }
            else if(GraphicalLevel.this.level.getField().getElements()[i][j].getEmoji() == 5) //on verra
            {
              try
              {
                String path = "../ressources/images/chien.png"; //a changer
                InputStream is = new BufferedInputStream(new FileInputStream(path));
                Image image = ImageIO.read(is);
                // g2.fillRect(x,y,50,50);
                g2.drawImage(image,x,y,null);
              }
              catch (Exception l_e)
              {
                System.out.println("fichier introuvable");
              }
            }
            break;
            case 0:
            g2.setColor(new Color(238,238,238));
            break;

            case 1:
            //g2.setColor(Color.RED);
            try
            {
              String path = "../ressources/images/red.png";
              InputStream is = new BufferedInputStream(new FileInputStream(path));
              Image image = ImageIO.read(is);
              g2.drawImage(image,x,y,null);
            }
            catch (Exception l_e)
            {
              System.out.println("fichier introuvable");
            }
            break;
            case 2:
            //g2.setColor(Color.BLUE);
            try
            {
              String path = "../ressources/images/blue.png";
              InputStream is = new BufferedInputStream(new FileInputStream(path));
              Image image = ImageIO.read(is);
              g2.drawImage(image,x,y,null);
            }
            catch (Exception l_e)
            {
              System.out.println("fichier introuvable");
            }
            break;
            case 3:
            //g2.setColor(Color.YELLOW);
            try
            {
              String path = "../ressources/images/yellow.png";
              InputStream is = new BufferedInputStream(new FileInputStream(path));
              Image image = ImageIO.read(is);
              g2.drawImage(image,x,y,null);
            }
            catch (Exception l_e)
            {
              System.out.println("fichier introuvable");
            }

            break;
            case 4:
            g2.setColor(Color.GREEN);

            break;
            case 5:
            g2.setColor(Color.MAGENTA);
            break;

          }
          if(GraphicalLevel.this.level.getField().getElements()[i][j].getColor() == 5 || GraphicalLevel.this.level.getField().getElements()[i][j].getColor() == 0)
          {
            g2.fillRect(x,y,50,50);
          }
          if(i == GraphicalLevel.this.level.getField().firstLineToDisplay() + GraphicalLevel.this.level.getField().getInterval() - 1 && j == GraphicalLevel.this.level.getField().getHeight()  - 1)
          {
            int k = GraphicalLevel.this.level.getField().getInterval() * 51;
            try
            {
              String ballonPath = "../ressources/images/ballon.png";
              InputStream ballonStream = new BufferedInputStream(new FileInputStream(ballonPath));
              Image ballon = ImageIO.read(ballonStream);
              g2.drawImage(ballon, 275, k + 10 ,null);

              String springPath = "../ressources/images/spring.png";
              InputStream springStream = new BufferedInputStream(new FileInputStream(springPath));
              Image spring = ImageIO.read(springStream);
              g2.drawImage(spring, 330 , k + 10 ,null);


              String rocketPath = "../ressources/images/rocket.png";
              InputStream rocketStream = new BufferedInputStream(new FileInputStream(rocketPath));
              Image rocket = ImageIO.read(rocketStream);
              g2.drawImage(rocket, 220, k + 10 ,null);

              String pickaxePath = "../ressources/images/pickaxe.png";
              InputStream pickaxeStream = new BufferedInputStream(new FileInputStream(pickaxePath));
              Image pickaxe = ImageIO.read(pickaxeStream);
              g2.drawImage(pickaxe, 275, k + 60 ,null);
            }
            catch (Exception ballon_e)
            {
              System.out.println("fichier introuvable");
            }
          }
        }
      }
    }
  }
  /**
   * Constructeur d'un niveau graphique
   * @method GraphicalLevel
   * @param  numero         le numero du niveau
   * @param  player         le joueur qui joue le niveau
   */
  public GraphicalLevel (int numero, Player player)
  {
    super();
    this.level = Level.use("../Data/Levels/level_" + numero + ".ser");
    this.score.setText("Score : " + level.getScore());
    this.setLayout(/*new BorderLayout()*/null);
    int c = (600 - GraphicalLevel.this.level.getField().getHeight()*51)/2;
    this.fieldLevelPane.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        repaint();
        int blockX = e.getX();
        int blockY = e.getY();
        if ((blockY < GraphicalLevel.this.level.getField().getInterval() * 51) && (blockX > c) && (blockX < level.getField().getHeight() *51 + c) )
        {
          int b = (blockX - c) / 51 ;
          int a = (blockY / 51) + GraphicalLevel.this.level.getField().firstLineToDisplay();
          int c = level.getField().updateFinal(a,b);
          if(c >= 1)
          {
            level.setScore(level.getScore() + c*1000);
            GraphicalLevel.this.score.setText("Score : " + level.getScore());
          }
          repaint();

          try
          {
            Thread.sleep(250);
          }
          catch (InterruptedException exp)
          {
            exp.printStackTrace();
          }
          level.setScore(level.getScore() + level.getField().scoreComputation(level.getField().nbBlockSuppr));
          GraphicalLevel.this.score.setText("Score : " + level.getScore());
          GraphicalLevel.this.setStars(level.getScore());
        }
        int k = GraphicalLevel.this.level.getField().getInterval() * 51 + 10;
        if ((blockY > k && blockY < k + 50) && (blockX > 220   && blockX < 262))
        {
          if(player.getBoost()[0] > 0)
          {
            int a;
            do
            {
              a = Integer.parseInt(JOptionPane.showInputDialog(null, "Vous avec encore " + player.getBoost()[0] + " fusées.\nVeuillez choisir une colonne entre 0 et " + (level.getField().getHeight() - 1) + " :       "));
            }
            while (a < 0 || a >= level.getField().getWidth());
            player.removeRocket();
            repaint();
            level.getField().useRocket(a);
            repaint();
            level.setScore(level.getScore() + 300);
            repaint();
            GraphicalLevel.this.score.setText("Score : " + level.getScore());
            repaint();
            GraphicalLevel.this.setStars(level.getScore());
            repaint();
            level.getField().updateSemiFinal();
            repaint();
            try
            {
              Thread.sleep(250);
            }
            catch (InterruptedException exp)
            {
              exp.printStackTrace();
            }
          }
          else
          {
            noBoosters("fusées");
          }

        }
        else if ((blockY > k && blockY < k + 50) && (blockX > 275 && blockX < 315)) //Ballons
        {
          if(player.getBoost()[3] > 0)
          {
            int a;
            do
            {
              a = Integer.parseInt(JOptionPane.showInputDialog(null, "Vous avec encore " + player.getBoost()[3] + " ballons.\nVeuillez choisir une ligne entre " + level.getField().firstLineToDisplay() + " et " + (level.getField().firstLineToDisplay() + level.getField().getInterval() - 1) + " : "));
            }
            while (a < level.getField().firstLineToDisplay() || a >= level.getField().firstLineToDisplay() + level.getField().getInterval());
            int b ;
            do
            {
              b = Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez choisir une colonne entre 0 et " + (level.getField().getHeight() - 1)  + " :       "));
            } while (b < 0 || b >= level.getField().getHeight());
            player.removeBallons();
            level.getField().useBallon(a,b);
            level.setScore(level.getScore() + 600);
            GraphicalLevel.this.score.setText("Score : " + level.getScore());
            GraphicalLevel.this.setStars(level.getScore());
            level.getField().updateSemiFinal();

            repaint();
            try
            {
              Thread.sleep(250);
            }
            catch (InterruptedException exp)
            {
              exp.printStackTrace();
            }
          }
          else
          {
            noBoosters("ballons");
          }
        }
        else if ((blockY > k && blockY < k + 50) && (blockX > 330 && blockX < 372)) //ressors
        {
          if(player.getBoost()[1] > 0)
          {
            int a ;
            do
            {
              a = Integer.parseInt(JOptionPane.showInputDialog(null, "Vous avez encore " + player.getBoost()[1] + " ressors.\nVeuillez choisir une ligne entre " + level.getField().firstLineToDisplay() + " et " + (level.getField().firstLineToDisplay() + level.getField().getInterval() - 1) + " : "));
            }
            while (a < 0 || a >= level.getField().getHeight());
            player.removeBoomerang();
            level.getField().useBoomerang(a);
            level.setScore(level.getScore() + 300);
            GraphicalLevel.this.score.setText("Score : " + level.getScore());
            GraphicalLevel.this.setStars(level.getScore());
            level.getField().updateSemiFinal();
            repaint();
            try
            {
              Thread.sleep(250);
            }
            catch (InterruptedException exp)
            {
              exp.printStackTrace();
            }

          }
          else
          {
            noBoosters("ressors");
          }
        }

        else if ((blockY > k + 55  && blockY < k + 55 + 46) && (blockX > 275 && blockX < 315)) //marteaux
        {
          if(player.getBoost()[2] > 0)
          {
            int a = 0;
            do
            {
              a = Integer.parseInt(JOptionPane.showInputDialog(null, "Vous avez encore " + player.getBoost()[2] + " marteaux.\nVeuillez choisir une ligne entre " + level.getField().firstLineToDisplay() + " et " + (level.getField().firstLineToDisplay() + level.getField().getInterval() - 1) + " : "));
            }
            while (a < 0 || a >= level.getField().getWidth());
              int b = 0;
            do
            {
              b = Integer.parseInt(JOptionPane.showInputDialog(null, "Veuillez choisir une colonne entre 0 et " + (level.getField().getHeight() - 1) + " :   "));
            } while (b < 0 || b >= level.getField().getHeight());
            player.removePickaxe();
            level.getField().usePickaxe(a,b);
            level.setScore(level.getScore() + 50);
            GraphicalLevel.this.score.setText("Score : " + level.getScore());
            GraphicalLevel.this.setStars(level.getScore());
            level.getField().updateSemiFinal();
            repaint();

            try
            {
              Thread.sleep(250);
            }
            catch (InterruptedException exp)
            {
              exp.printStackTrace();
            }

          }
          else
          {
            noBoosters("marteaux");
          }
        }
        repaint();
      }


      public void mouseEntered(MouseEvent e)
      {
      }
      public void mouseExited(MouseEvent e)
      {
      }
    });

    // JPanel levelMenuPane = new JPanel();
    JPanel northPane = new JPanel(new GridLayout(2,1));
    JPanel titleLevelPane = new JPanel();
    JPanel starsLevelPane = new JPanel();
    try {
      ImageIcon image = new ImageIcon("../ressources/images/star.png");
      this.star1 = new JLabel(image);
      this.star2 = new JLabel(image);
      this.star3 = new JLabel(image);
      starsLevelPane.add(star1);
      starsLevelPane.add(star2);
      starsLevelPane.add(star3);
    }
    catch (Exception e) {
      System.out.println("image non trouvé");
    }
    // score.setFont(new Font("Arial",Font.ITALIC,20));
    // score.setBounds(15, 475,200,25);
    // JPanel southPane = new JPanel(new FlowLayout());
    // southPane.add(score);
    // southPane.add(levelMenuPane);
    JLabel titleLevel = new JLabel("Niveau " + this.level.getNum());
    Font titleFont = new Font("Arial",Font.ITALIC,75);
    titleLevel.setFont(titleFont);
    titleLevelPane.add(titleLevel);
    Font font = new Font("Arial",Font.BOLD,20);
    this.back = new MenuItem("Retour", font);
    // levelMenuPane.add(back);
    northPane.add(titleLevelPane);
    northPane.add(starsLevelPane);
    // southPane.add(levelMenuPane);
    northPane.setBounds(50, 0,500,200);
    // fieldLevelPane.setBounds(75, 200,600,400);
    fieldLevelPane.setBounds(0, 200,600,400);
    this.add(northPane);
    this.add(fieldLevelPane);
    this.add(score);
    // this.add(southPane);
    // this.add(levelMenuPane);

  }
  /**
   * Cette méthode permet de sauvegarder le niveau
   * @method save
   * @param  num  le numéro du niveau à sauvegarder
   */
  public void save (int num)
  {
    this.level = Level.use("../Data/Levels/level_" + num + ".ser");

  }
  /**
   * Cette méthode permet l'affichage des étoiles vides
   * @method setEmptyStars
   */
  public void setEmptyStars()
  {
    try
    {
      ImageIcon image = new ImageIcon("../ressources/images/star.png");
      this.star1.setIcon(image);
      this.star2.setIcon(image);
      this.star3.setIcon(image);
    }
    catch (Exception l_e)
    {
      l_e.printStackTrace();
    }
  }
  /**
   * Cette méthode permt d'afficher le bon nombre d'étoile en fonction du score actuel
   * @method setStars
   * @param  score    le score actuel
   */
  public void setStars(int score)
  {
    if (score > level.getPalier()[0])
    {
      try
      {
        ImageIcon image = new ImageIcon("../ressources/images/yellow_star.png");
        GraphicalLevel.this.star1.setIcon(image);
      }
      catch (Exception l_e)
      {
        l_e.printStackTrace();
      }
    }
    if (score >= level.getPalier()[1])
    {
      try
      {
        ImageIcon image = new ImageIcon("../ressources/images/yellow_star.png");
        GraphicalLevel.this.star2.setIcon(image);
      }
      catch (Exception l_e)
      {
        l_e.printStackTrace();
      }

    }

    if (score >= level.getPalier()[2])
    {
      try
      {
        ImageIcon image = new ImageIcon("../ressources/images/yellow_star.png");
        GraphicalLevel.this.star3.setIcon(image);
      }
      catch (Exception l_e)
      {
        l_e.printStackTrace();
      }
    }
    fieldLevelPane.repaint();
  }

  public void noBoosters(String s)
  {
    JOptionPane.showMessageDialog(null,"Vous n'avez plus de " + s ,"Boosters", JOptionPane.DEFAULT_OPTION);
  }

  //
  // public void paint(Graphics g) {
	// 	super.paint(g);
	// 	Color c = g.getColor();
	// 	// g.setColor(Color.RED);
  //   g.setColor(Color.BLUE);
	// 	g.fillRect(0,0,2800,8000);
	// }
}
