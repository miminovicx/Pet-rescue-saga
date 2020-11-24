package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
public class Environment
{
  private Player player;
  private static Level[] levels;

  public Environment (Player player , Level [] levels)
  {
    this.levels = levels;
    this.player = player;
  }

  public Environment()
  {
    this.levels = null;
    this.player = null;
  }


  public static Level[] getLevels()
  {
    return (levels);
  }

  public Player getPlayer()
  {
    return (this.player);
  }

  public void setLevels(Level[] levels)
  {
    this.levels = levels;
  }

  public void setPlayer(Player player)
  {
    this.player = player;
  }

  public String toString()
  {
    return (this.player.toString() + displayLevels());
  }
  /**
   * Cette méthode recupère le joueur sauvegardé ou en crée un nouveau
   * @method createPlayer
   * @param  nickName     pseudo du joueur
   */
  public void createPlayer(String nickName)
  {
    String path = "../Data/"+ nickName + ".ser";
    File donnee = new File(path);
    if (donnee.exists())
    {
      this.player = Player.use(path);
    }
    this.player = new Player(nickName, 5, 0);
  }
  /**
   * Cette méthode initialise le tableau des niveaux
   * @method fillLevelTab
   */
  public void fillLevelTab()
  {
    String dataDirectoryPath = "../Data/Levels/";
    File dataDirectory = new File(dataDirectoryPath);
    Level [] levels;
    if(dataDirectory.exists())
    {
      if(dataDirectory.isDirectory())
      {
        File [] savedLevels = dataDirectory.listFiles();
        levels = new Level[savedLevels.length];
        // System.out.println(Arrays.toString(levels));
        for (int i = 0; i < savedLevels.length;i++)
        {
          levels[i] = Level.use(dataDirectoryPath + savedLevels[i].getName());
          // System.out.println(savedLevels[i]);
          // System.out.println(Arrays.toString(levels));
        }
        // System.out.println(Arrays.toString(levels));
        this.levels = levels;
        for(int i=0; i < levels.length ; i++)
        {
            int index = i;
            for (int j = i + 1; j < levels.length; j++)
            {
                 if (levels[j].getNum() < levels[index].getNum()){
                      index = j;
                 }
            }

            Level min = levels[index];
            levels[index] = levels[i];
            levels[i] = min;
        }
      }
      else
      {
        System.err.println("Récuperation dans un fichier et pas un répertoire");
        System.exit(1);
      }
    }
    else
    {
      System.err.println("Le repertoire de savegarde n'existe pas");
      System.exit(1);
    }


  }

  public String displayLevels()
  {
    String s = "";
    for(int i = 0; i < levels.length ; i++)
    {
      if(levels[i].getUnlocked())
      {
        s += levels[i].getNum() + "\n";
      }
      else
      {
        s +="*\n";
      }
    }
    return s;
  }

  public void play(int i)
  {
    String rep;
    Scanner reponse = new Scanner(System.in);
    do
    {
      System.out.println("Voulez-vous jouer le niveau " + (i + 1) + " ? (o/n)");
      rep = reponse.nextLine();
    }
    while (rep.charAt(0) != 'o' && rep.charAt(0) != 'n');
    if(rep.charAt(0) == 'o')
    {
      if (this.player.getLifePoints() > 0 && this.levels[i].getUnlocked())
      {
        this.levels[i].play();
        if(this.levels[i].getSucceded())
        {
          unlock(i + 1);
        }
        else
        {
          this.player.setLifePoints(this.player.getLifePoints() - 1);
        }
      }
      else
      {
        System.out.println("Niveau verrouillé");
      }
    }
    else
    {
      this.chooseLevel();
    }

  }

  public static void unlock(int a)
  {
    if(a < levels.length)
     levels[a].setUnlocked(true);
  }

  public void chooseLevel()
  {
    System.out.print("veuillez choisir un niveau à jouer : ");
    this.play(player.getScanner().nextInt() - 1);
  }
}
