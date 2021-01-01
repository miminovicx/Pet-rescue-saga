package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import levelpack.Level;
import pack.*;
import levelpack.*;
import java.util.Arrays;
import java.io.File;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

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
  public  class FieldLevelPane extends JPanel
  {
    public void paint(Graphics g)
    {
      Graphics2D g2 = (Graphics2D) g;
      int x ;
      int y ;
      for (int i = 0; i < GraphicalLevel.this.level.getField().getWidth(); i++)
      {
        for (int j = 0; j < GraphicalLevel.this.level.getField().getHeight(); j++)
        {
          x = 51 * j;
          y = 51 * i;
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
            if (i == GraphicalLevel.this.level.getField().getWidth() - 1 && j == GraphicalLevel.this.level.getField().getHeight() - 1)
            {
              try
              {
                String ballonPath = "../ressources/images/ballon.png";
                InputStream ballonStream = new BufferedInputStream(new FileInputStream(ballonPath));
                Image ballon = ImageIO.read(ballonStream);
                g2.drawImage(ballon,x - 45,y + 55,null);

                String springPath = "../ressources/images/spring.png";
                InputStream springStream = new BufferedInputStream(new FileInputStream(springPath));
                Image spring = ImageIO.read(springStream);
                g2.drawImage(spring,x + 10,y + 55,null);

                String rocketPath = "../ressources/images/rocket.png";
                InputStream rocketStream = new BufferedInputStream(new FileInputStream(rocketPath));
                Image rocket = ImageIO.read(rocketStream);
                g2.drawImage(rocket,x - 100,y + 55,null);

                String pickaxePath = "../ressources/images/pickaxe.png";
                InputStream pickaxeStream = new BufferedInputStream(new FileInputStream(pickaxePath));
                Image pickaxe = ImageIO.read(pickaxeStream);
                g2.drawImage(pickaxe,x - 45,y + 115,null);
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
  public GraphicalLevel (int numero)
  {
    super();
    this.level = Level.use("../Data/Levels/level_" + numero + ".ser");
   this.score.setText("Score : " + level.getScore());
    this.setLayout(/*new BorderLayout()*/null);
    this.fieldLevelPane.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
          int blockX = e.getX();
          int blockY = e.getY();
        if ((blockY < level.getField().getWidth() * 51) && (blockX < level.getField().getHeight() *51))
        {

          int b = blockX / 50;
          int a = blockY / 50;
          level.getField().updateFinal(a,b);
          try
          {
            Thread.sleep(250);
          }
          catch (InterruptedException exp)
          {
            exp.printStackTrace();
          }
          level.setScore(level.getScore() + level.getField().scoreComputation(level.getField().nbBlockSuppr));
          System.out.println("Score : " + level.getScore());
          GraphicalLevel.this.score.setText("Score : " + level.getScore());
          GraphicalLevel.this.setStars(level.getScore());
      }

      // if (((blockY >= level.getField().getWidth() * 51)  &&  ((blockY >= level.getField().getWidth() * 51 + 50)) && (blockX < level.getField().getHeight() *51 + 55))
      // {
      //
      // }

      }


      public void mouseEntered(MouseEvent e)
      {
      }
      public void mouseExited(MouseEvent e)
      {
      }
    });

    JPanel levelMenuPane = new JPanel();
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
    JPanel southPane = new JPanel(new GridLayout(1,2));
    southPane.add(score);
    southPane.add(levelMenuPane);
    JLabel titleLevel = new JLabel("Niveau " + this.level.getNum());
    Font titleFont = new Font("Arial",Font.BOLD,100);
    titleLevel.setFont(titleFont);
    titleLevelPane.add(titleLevel);
    Font font = new Font("Arial",Font.BOLD,20);
    this.back = new MenuItem("Retour", true, font);
    levelMenuPane.add(back);
    northPane.add(titleLevelPane);
    northPane.add(starsLevelPane);
    southPane.add(levelMenuPane);
    northPane.setBounds(50, 0,500,200);
    fieldLevelPane.setBounds(600/2 - 100, 200,400,400);
    // this.add(northPane, BorderLayout.NORTH);
    // this.add(fieldLevelPane, BorderLayout.CENTER);
    // this.add(southPane, BorderLayout.SOUTH);
    this.add(northPane);
    this.add(fieldLevelPane);
    //this.add();
  }
  // public GraphicalLevel reset()
  // {
  //   GraphicalLevel reset = new GraphicalLevel(this.level.getNum());
  //   return (reset);
  // }
  public void save (int num)
  {
    this.level = Level.use("../Data/Levels/level_" + num + ".ser");

  }

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
  }
// }
