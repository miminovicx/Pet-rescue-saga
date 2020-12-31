package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import levelpack.Level;
import pack.*;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;
public class FirstView extends JFrame //implements MouseAdapter
{
  static GraphicalEnivronnement levelsPane;
  public FirstView()
  {
    //mainPane
    JPanel contains = new JPanel();
    CardLayout c1 = new CardLayout();
    contains.setLayout(c1);
    JPanel firstView = new JPanel();
    JPanel homePane = new JPanel();
    GraphicalResult won = new GraphicalResult("GAGNÉ");
    GraphicalResult lost = new GraphicalResult("PERDU");
    NickName nickNamePane = new NickName();
    firstView.setLayout(new BorderLayout());
    homePane.setLayout(new BorderLayout());
    JPanel firstViewMenuPane = new JPanel();
    JPanel menuPane = new JPanel();
    JPanel titlePane = new JPanel();
    firstViewMenuPane.setLayout(null);
    menuPane.setLayout(null);
    JLabel title = new JLabel("PetRescue");
    Font titleFont = new Font("Arial",Font.BOLD,100);
    Font firstViewFont = new Font("Arial",Font.BOLD,25);
    title.setFont(titleFont);
    titlePane.add(title);
    Font font = new Font("Arial",Font.BOLD,40);
    MenuItem pseudo = new MenuItem("Pseudo : ", true, font);
    MenuItem back = new MenuItem("Retour", true, font);

    // JTextField userName = new JTextField(10);
    // userName.setFont(font);
    /*GraphicalEnivronnement*/ levelsPane = new GraphicalEnivronnement(/*userName.getText()*/ "miminovicx");
    GraphicalLevel level_1_Pane = new GraphicalLevel(1);
    GraphicalLevel level_2_Pane = new GraphicalLevel(2);
    MenuItem start = new MenuItem("Commencer", true, font);
    MenuItem play = new MenuItem("Jouer", true, font);
    MenuItem help = new MenuItem("Aide", true, font);
    MenuItem quit = new MenuItem("Quitter", true, font);
    MenuItem firstViewQuit = new MenuItem("Quitter", true, font);

    start.setBounds(600/2 - 100, 600/2 - 50,280,60);
    start.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    start.setHorizontalAlignment(JLabel.CENTER);
    quit.setVerticalAlignment(JLabel.CENTER);
    // pseudo.setBounds(200, 0, 135, 50);
    // userName.setBounds(200,60,100,30);
    play.setBounds(210,110,200, 60);
    play.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    play.setHorizontalAlignment(JLabel.CENTER);
    play.setVerticalAlignment(JLabel.CENTER);
    help.setBounds(210,180,200, 60);
    help.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    help.setHorizontalAlignment(JLabel.CENTER);
    help.setVerticalAlignment(JLabel.CENTER);
    quit.setBounds(210,250,200, 60);
    quit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    quit.setHorizontalAlignment(JLabel.CENTER);
    quit.setVerticalAlignment(JLabel.CENTER);
    firstViewQuit.setBounds(600/2 - 100, 600/2 + 20,280,60);
    firstViewQuit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    firstViewQuit.setHorizontalAlignment(JLabel.CENTER);
    firstViewQuit.setVerticalAlignment(JLabel.CENTER);
    firstViewMenuPane.add(start);
    firstViewMenuPane.add(firstViewQuit);
    // menuPane.add(pseudo);
    // menuPane.add(userName);
    menuPane.add(play);
    menuPane.add(help);
    menuPane.add(quit);
    play.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        // GraphicalEnivronnement levelsPane = new GraphicalEnivronnement(userName.getText());
        c1.show(contains,"3");
      }
      public void mouseEntered(MouseEvent e)
      {
        play.setForeground(new Color(0,150,0));
      }
      public void mouseExited(MouseEvent e)
      {
        play.setForeground(new Color(0,0,0));
      }
    });

    help.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        JOptionPane.showMessageDialog(FirstView.this,Launcher.helpDisplay(),"Aide", JOptionPane.DEFAULT_OPTION);
      }
      public void mouseEntered(MouseEvent e)
      {
        help.setForeground(new Color(0,0,255));

      }
      public void mouseExited(MouseEvent e)
      {
        help.setForeground(new Color(0,0,0));
      }
    });
    nickNamePane.next.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        if (!(nickNamePane.nickName.getText().equals("")))
        {
          //nickNamePane.next.setForeground(new Color(0,0,0));
          // FirstView.this.levelsPane = new GraphicalEnivronnement(NickName.nickName.getText());
          c1.show(contains, "2");
        }
        else
        {

        }
      }
      public void mouseEntered(MouseEvent e)
      {
        nickNamePane.next.setForeground(new Color(0,0,255));

      }
      public void mouseExited(MouseEvent e)
      {
        nickNamePane.next.setForeground(Color.BLACK);
      }
    });
    addListener(contains, c1,start,new Color(0,150,0),"nickname");
    addQuitListener(firstViewQuit, new Color(255,0,0));
    addQuitListener(quit, new Color(255,0,0));
    //addListener(contains, c1,levelsPane.levelsLabels[0],new Color(0,150,0),"4");
    levelsPane.levelsLabels[0].addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        //level_1_Pane = new GraphicalLevel(1);
        c1.show(contains, "4");
      }
      public void mouseEntered(MouseEvent e)
      {
        levelsPane.levelsLabels[0].setForeground(Color.WHITE);
      }
      public void mouseExited(MouseEvent e)
      {
        levelsPane.levelsLabels[0].setForeground(new Color(0,0,0));
      }
    });

    levelsPane.levelsLabels[1].addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        //level_2_Pane = new GraphicalLevel(2);
        c1.show(contains, "5");
      }
      public void mouseEntered(MouseEvent e)
      {
        levelsPane.levelsLabels[1].setForeground(Color.WHITE);
      }
      public void mouseExited(MouseEvent e)
      {
        levelsPane.levelsLabels[1].setForeground(new Color(0,0,0));
      }
    });
    // addListener(contains, c1,levelsPane.levelsLabels[1],new Color(0,150,0),"5");
    addListener(contains, c1,nickNamePane.back,new Color(0,150,0),"1");
    addListener(contains, c1,levelsPane.back,new Color(0,150,0),"2");
    addListener(contains, c1,level_1_Pane.back,new Color(0,150,0),"3");
    addListener(contains, c1,level_2_Pane.back,new Color(0,150,0),"3");
    addListener(contains, c1,won.back,new Color(0,150,0),"3");
    addListener(contains, c1,lost.back,new Color(0,150,0),"3");
level_1_Pane.fieldLevelPane.addMouseListener(new MouseAdapter()
{
  public void mouseClicked(MouseEvent e)
  {
    if (level_1_Pane.level.Won0())
    {
      if(level_1_Pane.level.getScore() > FirstView.levelsPane.getEnvironment().getPlayer().getBestScore()[0])
      {
        FirstView.levelsPane.getEnvironment().getPlayer().setBestScore(level_1_Pane.level.getScore(),0);
        //afficher le nouveau best score
        System.out.println("Nouveau meilleur score : " + level_1_Pane.level.getScore());
      }
      level_1_Pane.level.setScore(0);
      level_2_Pane.level.getField().animalsSaved = 0;
      level_1_Pane.setEmptyStars();
      level_1_Pane.save(1);
      c1.show(contains,"won");

      FirstView.levelsPane.getEnvironment().getPlayer().save();
    }
    else if (level_1_Pane.level.Lost0())
    {
      c1.show(contains,"lost");
      FirstView.levelsPane.getEnvironment().getPlayer().save();
    }
    // FirstView.levelsPane.getEnvironment().getPlayer().save();
  }
  public void mouseEntered(MouseEvent e)
  {

  }
  public void mouseExited(MouseEvent e)
  {

  }
});

level_2_Pane.fieldLevelPane.addMouseListener(new MouseAdapter()
{
  public void mouseClicked(MouseEvent e)
  {
    if (level_2_Pane.level.Won0())
    {
      //level_2_Pane = level_2_Pane.reset();
      //level_2_Pane.level.use("../Data/Levels/level_2.ser");
      if(level_2_Pane.level.getScore() > FirstView.levelsPane.getEnvironment().getPlayer().getBestScore()[1])
      {
        FirstView.levelsPane.getEnvironment().getPlayer().setBestScore(level_2_Pane.level.getScore(),1);
        //afficher le nouveau best score
        System.out.println("Nouveau meilleur score : " + level_2_Pane.level.getScore());
      }
      level_2_Pane.level.setScore(0);
      level_2_Pane.level.getField().animalsSaved = 0;
      level_2_Pane.setEmptyStars();
      level_2_Pane.save(2);
      FirstView.levelsPane.getEnvironment().getPlayer().save();  //la lgine qui sauvegarde le joueur après avoir joué
      c1.show(contains,"won");

    }
    else if (level_2_Pane.level.Lost0())
    {
      c1.show(contains,"lost");
      FirstView.levelsPane.getEnvironment().getPlayer().save();
    }
  }
  public void mouseEntered(MouseEvent e)
  {

  }
  public void mouseExited(MouseEvent e)
  {

  }
});

    firstView.add(titlePane, BorderLayout.NORTH);
    firstView.add(firstViewMenuPane, BorderLayout.CENTER);
    homePane.add(titlePane, BorderLayout.NORTH);
    homePane.add(menuPane,BorderLayout.CENTER);
    contains.add(firstView,"1");
    contains.add(nickNamePane,"nickname");
    contains.add(homePane,"2");
    contains.add(levelsPane,"3");
    contains.add(level_1_Pane,"4");
    contains.add(level_2_Pane,"5");
    contains.add(won,"won");
    contains.add(lost,"lost");

    c1.show(contains,"1");
    this.setContentPane(contains);
    this.setTitle("PetRescue");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(600,600);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  /**
   * Cette méthode permet d'ajouter un listener au boutons qui permetttent de quitter le jeu
   * @method addQuitListener
   * @param  label           le bouton qui reçois le listener
   * @param  focused         couleur du bouton lorsque la souris passe dessus
   */
  public  void addQuitListener(JLabel label, Color focused)
  {
    label.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        System.exit(0);
      }
      public void mouseEntered(MouseEvent e)
      {
        label.setForeground(focused);
      }
      public void mouseExited(MouseEvent e)
      {
        label.setForeground(new Color(0,0,0));
      }
    });
  }
  /**
   * Cette méthode permet d'ajouter un listener aux boutons qui permetttent de naviguer dans les différentes vues
   * @method addListener
   * @param  container   le conteneur de la fenêtre
   * @param  layout      le layout du conteneur
   * @param  label       le bouton qui reçoit le listener
   * @param  focused     couleur du bouton lorsque la souris passe dessus
   * @param  panel       la vue vers laquelle on va
   */
  public  void addListener(JPanel container, CardLayout layout, JLabel label, Color focused, String panel)
  {
    label.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        layout.show(container, panel);
      }
      public void mouseEntered(MouseEvent e)
      {
        label.setForeground(focused);
      }
      public void mouseExited(MouseEvent e)
      {
        label.setForeground(new Color(0,0,0));
      }
    });
  }
}
