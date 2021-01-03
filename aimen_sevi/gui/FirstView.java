package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import levelpack.Level;
import pack.*;
import java.io.File;
/**
 * Classe représentant la première fenêtre affichée
 */
public class FirstView extends JFrame
{
  static GraphicalEnvironment levelsPane;
  GraphicalResult[] won;
  GraphicalResult[] lost;
  GraphicalLevel[] level_Pane;
  JPanel contains;
  CardLayout c1;
  /**
   * Constructeur de la première fenêtre affiché
   * @method FirstView
   */
  public FirstView()
  {
    this.won = new GraphicalResult[5];
    this.lost = new GraphicalResult[5];
    level_Pane = new GraphicalLevel[5];
    contains = new JPanel();
    this.c1 = new CardLayout();
    contains.setLayout(this.c1);
    HomeMenu homeMenu = new HomeMenu();

    JLabel score = new JLabel();
    JPanel homePane = new JPanel();
    NickName nickNamePane = new NickName();

    homePane.setLayout(new BorderLayout());
    JPanel firstViewMenuPane = new JPanel();
    JPanel menuPane = new JPanel();
    JPanel titlePane = new JPanel();
    firstViewMenuPane.setLayout(null);
    menuPane.setLayout(null);
    JLabel title = new JLabel("PetRescue");
    Font titleFont = new Font("Arial",Font.ITALIC,75);
    Font firstViewFont = new Font("Arial",Font.ITALIC,25);
    title.setFont(titleFont);
    title.setForeground(Color.GRAY);
    titlePane.add(title);
    Font font = new Font("Arial",Font.BOLD,40);



    PlayMenu menu = new PlayMenu();


    menu.play.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        FirstView.this.c1.show(contains,"3");
      }
      public void mouseEntered(MouseEvent e)
      {
        menu.play.setForeground(Color.GREEN);
      }
      public void mouseExited(MouseEvent e)
      {
        menu.play.setForeground(new Color(0,0,0));
      }
    });

    menu.help.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        JOptionPane.showMessageDialog(FirstView.this,Launcher.helpDisplay(),"Aide", JOptionPane.DEFAULT_OPTION);
      }
      public void mouseEntered(MouseEvent e)
      {
        menu.help.setForeground(new Color(0,0,255));

      }
      public void mouseExited(MouseEvent e)
      {
        menu.help.setForeground(new Color(0,0,0));
      }
    });

    nickNamePane.next.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        if (!(nickNamePane.nickName.getText().equals("")))
        {
          FirstView.this.levelsPane = new GraphicalEnvironment(Launcher.initialiseEnv(nickNamePane.nickName.getText()));
          menu.setNickName(nickNamePane.nickName.getText());

          contains.add(levelsPane,"3");

          graphicalLevelsInitialize();
          levelListener(0,FirstView.levelsPane.getEnvironment().getPlayer(),contains,FirstView.this.c1,"4");
          levelListener(1,FirstView.levelsPane.getEnvironment().getPlayer(),contains,FirstView.this.c1,"5");
          levelsPaneAddListener(0);
          levelsPaneAddListener(1);

          addListener(contains, FirstView.this.c1,levelsPane.back,Color.WHITE,"2");
          addListener(contains, FirstView.this.c1,level_Pane[0].back,Color.WHITE,"3");
          addListener(contains, FirstView.this.c1,level_Pane[1].back,Color.WHITE,"3");
          FirstView.this.c1.show(contains, "2");
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


    addListener(contains, this.c1,homeMenu.start,Color.GREEN,"nickname");
    addQuitListener(homeMenu.quit, new Color(255,0,0));
    addQuitListener(menu.quit, new Color(255,0,0));
    addListener(contains, this.c1,nickNamePane.back,Color.WHITE,"1");
    // addListener(contains, c1,this.won.back,new Color(0,150,0),"3");
    // addListener(contains, c1,this.lost.back,new Color(0,150,0),"3");


    homePane.add(titlePane, BorderLayout.NORTH);
    homePane.add(menu,BorderLayout.CENTER);
    contains.add(homeMenu,"1");
    contains.add(nickNamePane,"nickname");
    contains.add(homePane,"2");
    // contains.add(this.won,"won");
    // contains.add(this.lost,"lost");

    this.c1.show(contains,"1");
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
  /**
   * Cette méthode génère les niveaux graphiques
   * @method lvlGenerator
   * @param  num          le numero du niveau
   * @param  player       le joueur
   * @param  contains     le ContentPane de la fenêtre
   * @param  destination  le panel à afficher
   * @return              le niveau généré
   */
  public GraphicalLevel lvlGenerator(int num, Player player, JPanel contains, String destination)
  {
    GraphicalLevel lvl = new GraphicalLevel(num, player);
    contains.add(lvl,destination);
    //contains.add(level_Pane[1],"5");
    return (lvl);
  }

  public void levelListener(int num, Player player, JPanel contains, CardLayout c1, String destination)
  {
    FirstView.levelsPane.levelsLabels[num].addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {

        if(player.getUnlocked()[num])//level_Pane[0] = new GraphicalLevel(1);
          FirstView.this.c1.show(contains, destination);
      }
      public void mouseEntered(MouseEvent e)
      {
        if(player.getUnlocked()[num])
        {
          if(player.getBestScore()[num] == 0)
          {
              FirstView.levelsPane.levelsLabels[num].setForeground(Color.YELLOW);
          }
          else
          {
            FirstView.levelsPane.levelsLabels[num].setForeground(Color.GREEN);
          }
        }
        else
        {
          FirstView.levelsPane.levelsLabels[num].setForeground(Color.RED);
        }
      }
      public void mouseExited(MouseEvent e)
      {
        FirstView.levelsPane.levelsLabels[num].setForeground(new Color(0,0,0));
      }
    });
  }

  // public void result (GraphicalLevel lvl)
  // {
  //   FirstView.this.won = new GraphicalResult("GAGNÉ",FirstView.this.levelsPane.getEnvironment().getPlayer(),level_Pane[0].level.getScore(),FirstView.levelsPane.getEnvironment().getPlayer().getBestScore()[0]);
  //   FirstView.this.lost = new GraphicalResult("PERDU",FirstView.this.levelsPane.getEnvironment().getPlayer(),level_Pane[0].level.getScore(),FirstView.levelsPane.getEnvironment().getPlayer().getBestScore()[0]);
  //   addListener(contains, c1,FirstView.this.won.back,new Color(0,150,0),"3");
  //   addListener(contains, c1,FirstView.this.lost.back,new Color(0,150,0),"3");
  //   contains.add(FirstView.this.won,"won");
  //   contains.add(FirstView.this.lost,"lost");
  // }

  public void graphicalLevelsInitialize()
  {
    int b = 4;
    for(int i = 0; i < 2; i++)
    {
      this.level_Pane[i] = new GraphicalLevel(i+1 , this.levelsPane.getEnvironment().getPlayer());
      contains.add(level_Pane[i], String.valueOf(b) );
      b++;
    }

  }

  public void levelsPaneAddListener(int i)
  {
    level_Pane[i].fieldLevelPane.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        if (level_Pane[i].level.Won0())
        {
          boolean b = false;
          if(level_Pane[i].level.getScore() > FirstView.levelsPane.getEnvironment().getPlayer().getBestScore()[i])
          {
            FirstView.levelsPane.getEnvironment().getPlayer().setBestScore(level_Pane[i].level.getScore(),i);

          }
          if(!levelsPane.getEnvironment().getPlayer().getUnlocked()[i+1] && i+1 <= 5)
          {
            levelsPane.getEnvironment().getPlayer().setUnlocked(i+1);
            b = true;
          }

          int stars = 0;
          if(level_Pane[i].level.getScore() > level_Pane[i].level.getPalier()[0])
          {
            stars = 1;
          }
          if(level_Pane[i].level.getScore() > level_Pane[i].level.getPalier()[1])
          {
            stars = 2;
          }
          if(level_Pane[i].level.getScore() > level_Pane[i].level.getPalier()[2])
          {
            stars = 3;
          }

          FirstView.this.won[i] = new GraphicalResult("GAGNÉ",FirstView.this.level_Pane[i].level.getScore(),FirstView.this.levelsPane.getEnvironment().getPlayer().getBestScore()[i], b, stars ,0,0,0);
          // FirstView.this.lost[i] = new GraphicalResult("PERDU",FirstView.this.level_Pane[i].level.getScore(),0, false, 0, level_Pane[i].level.getPalier()[0], FirstView.this.level_Pane[i].level.getField().animalsSaved, level_Pane[i].level.getAnimalsToRescue() );
          level_Pane[i].level.setScore(0);
          level_Pane[i].score.setText("Score : 0");
          addListener(contains, FirstView.this.c1,FirstView.this.won[i].back,Color.WHITE,"3");
          // addListener(contains, FirstView.this.c1,FirstView.this.lost[i].back,Color.WHITE,"3");
          level_Pane[i].level.getField().animalsSaved = 0;
          level_Pane[i].setEmptyStars();
          level_Pane[i].save(i+1);
          contains.add(FirstView.this.won[i],"won");
          // contains.add(FirstView.this.lost[i],"lost");

          try
          {
            Thread.sleep(250);
          }
          catch (InterruptedException exp)
          {
            exp.printStackTrace();
          }
          FirstView.this.c1.show(contains,"won");

          FirstView.levelsPane.getEnvironment().getPlayer().save();
        }
        else if (level_Pane[i].level.Lost0())
        {
          // FirstView.this.won[i] = new GraphicalResult("GAGNÉ",FirstView.this.level_Pane[i].level.getScore(),FirstView.this.levelsPane.getEnvironment().getPlayer().getBestScore()[i], false, 0 ,0,0,0);
          // addListener(contains, FirstView.this.c1,FirstView.this.won[i].back,Color.WHITE,"3");
          FirstView.this.lost[i] = new GraphicalResult("PERDU",FirstView.this.level_Pane[i].level.getScore(),0, false, 0, level_Pane[i].level.getPalier()[0], FirstView.this.level_Pane[i].level.getField().animalsSaved, level_Pane[i].level.getAnimalsToRescue() );
          addListener(contains, FirstView.this.c1,FirstView.this.lost[i].back,Color.WHITE,"3");
          contains.add(FirstView.this.lost[i],"lost");
          // contains.add(FirstView.this.won[i],"won");
          level_Pane[i].level.setScore(0);
          level_Pane[i].level.getField().animalsSaved = 0;
          level_Pane[i].setEmptyStars();
          level_Pane[i].save(i+1);
          try
          {
            Thread.sleep(250);
          }
          catch (InterruptedException exp)
          {
            exp.printStackTrace();
          }
          FirstView.this.c1.show(contains,"lost");
        }
        FirstView.levelsPane.getEnvironment().getPlayer().save();
      }
      public void mouseEntered(MouseEvent e)
      {

      }
      public void mouseExited(MouseEvent e)
      {

      }
    });
  }
}
