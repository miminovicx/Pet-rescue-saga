package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
/**
 * Classe représentant l'Environment dans lequel évolue le jouer
 */
public class Environment
{
  private Player player;
  private static Level[] levels;
  /**
   * Constructeur d'un Environment
   * @method Environment
   * @param  player      joueur qui evolue dans l'environnement
   * @param  levels      ensemble des niveaux constituant l'environnement
   */
  public Environment (Player player , Level [] levels)
  {
    this.levels = levels;
    this.player = player;
  }
  /**
   * Constructeur par défaut d'un environnement
   * @method Environment
   */
  public Environment()
  {
    this.levels = null;
    this.player = null;
  }
  /**
   * Getteur qui permet d'obtenir l'ensemble des niveaux
   * @method getLevels
   * @return l'ensemble des niveaux sous forme de tableau
   */
  public static Level[] getLevels()
  {
    return (levels);
  }
  /**
   * Getteur qui permet d'obtenir le joueur lié à l'environnement
   * @method getPlayer
   * @return le joueur lié à l'environnement
   */
  public Player getPlayer()
  {
    return (this.player);
  }
  /**
   * Setteur qui permet de spécifier un tableau de niveaux qui constiuera l'environnement
   * @method setLevels
   * @param  levels    le nouveau tableau de niveaux
   */
  public void setLevels(Level[] levels)
  {
    this.levels = levels;
  }
  /**
   * Setteur qui permet de spécifier un joueur qui évoluera dans l'environnement
   * @method setPlayer
   * @param  player    le nouveau joueur qui évoluera dans l'environnement
   */
  public void setPlayer(Player player)
  {
    this.player = player;
  }
  /**
   * Méthode permettant d'afficher l'environnement
   * @method toString
   * @return la chaîne qui sera affchée
   */
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
      // this.player = Player.use(path);
      this.setPlayer(Player.use(path));
    }
    else
    {
      this.player = new Player(nickName);

    }
    // this.player.save();

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
        for (int i = 0; i < savedLevels.length;i++)
        {
          levels[i] = Level.use(dataDirectoryPath + savedLevels[i].getName());
        }
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

  /**
   * Cette méthode permet d'afficher l'ensemble des niveaux
   * @method displayLevels
   * @return chaîne affichée
   */
  public String displayLevels()
  {
    String s = "";
    for(int i = 0; i < levels.length ; i++)
    {
      if(this.player.getUnlocked()[i])
      {
        if(this.player.getBestScore()[i] == 0)
        {
          s += "\033[0;33m      Niveau " + levels[i].getNum() + "\u001B[0m" + "\n"; //en jaune
        }
        else
        {
          s += "\u001B[32m      Niveau " + levels[i].getNum() + "\u001B[0m" + "\n"; //en vert
        }
      }
      else
      {
        s += "\u001B[31m      Niveau " + levels[i].getNum() + "\u001B[0m\n"; //en rouge
      }
    }
    s += Launcher.WHITE_BOLD_BRIGHT + "      Retour(0)\n" + Launcher.RESET;
    return s;
  }


  /**
   * Méthode permettant de jouer un niveau
   * @method play
   * @param  i    le numéro du niveau que l'on souhaite jouerVoulez-vous jouer
   */
  public void play(int i)
  {
    String rep;
    Scanner reponse = new Scanner(System.in);

    System.out.println("\n- Niveau " + (i+1) + " !\n");
      if (this.player.getUnlocked()[i])
      {
        this.levels[i].play(this.player);
        this.player.save();
      }
      else
      {
        System.out.println("Niveau verrouillé ");
      }

  }

  /**
   * Cette méhode permet de choisir le niveau que l'on veut jouer elle permet de gérer le décalage par rappot aux indices du tableau
   * @method chooseLevel
   */
  public int chooseLevel()
  {
    int n = 0;
    System.out.print("Veuillez choisir un niveau à jouer : ");
    n = player.getScanner().nextInt();
    while ((n < 0) || (n > this.levels.length)) //5 correspond au nombre de niveaux
    {
      System.out.print("Niveau indisponible\nVeuillez choisir un autre niveau à jouer : ");
      n = player.getScanner().nextInt();
    }
    return n;
    // this.play(n - 1);
  }
}
