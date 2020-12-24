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
      this.player = new Player(nickName, 5);
    }

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
      if(levels[i].getUnlocked())
      {
        s += levels[i].getNum() + " ";
      }
      else
      {
        s += levels[i].getNum() + "*";
      }
    }
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

    System.out.println("Niveau " + (i+1) + "!\nNombre d'étoiles : " + this.levels[i].getStars() + "\nDernier score : " + this.levels[i].getLastScore() + "\n");
    do
    {
      System.out.print("Voulez-vous jouer le niveau " + (i + 1) + " ? (o/n) ");
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
          this.player.save();
        }
      }
      else
      {
        if (this.player.getLifePoints() == 0)
        {
          System.out.println("Vous n'avez pas assez de vie pour jouer");
        }
        if(!this.levels[i].getUnlocked())
        {
          System.out.println("Niveau verrouillé");
        }
      }

    }
    else
    {
      this.chooseLevel();
    }

  }
  /**
   * Cette méthode permet de déverrouiller un niveau
   * @method unlock
   * @param  a      numéro du niveau à déverrouiller
   */
  public static void unlock(int a)
  {
    if(a < levels.length)
    {

      levels[a].setUnlocked(true);
      levels[a].save();
    }
  }
  /**
   * Cette méhode permet de choisir le niveau que l'on veut jouer elle permet de gérer le décalage par rappot aux indices du tableau
   * @method chooseLevel
   */
  // public void chooseLevel()
  // {
  //   System.out.print("veuillez choisir un niveau à jouer : ");
  //   this.play(player.getScanner().nextInt() - 1);
  // }
  public void chooseLevel()
  {
    int n = 0;
    System.out.print("veuillez choisir un niveau à jouer : ");
    n = player.getScanner().nextInt();
    while ((n <= 0) || (n > 5)) //5 correspond au nombre de niveaux
    {
      System.out.print("Niveau indisponible\nVeuillez choisir un autre niveau à jouer : ");
      n = player.getScanner().nextInt();
    }
    this.play(n - 1);
  }
}
