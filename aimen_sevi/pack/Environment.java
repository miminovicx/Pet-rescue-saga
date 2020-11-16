package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
public class Environment
{
  private Player player;
  private Level[] levels;

  public Environment (Player player , Level [] levels)
  {
    this.levels = levels;
    this.player = player;
  }

  public Level[] getLevels()
  {
    return (this.levels);
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
    return (this.player.toString() + Arrays.toString(this.levels));
  }
  /**
   * Cette méthode recupère le joueur sauvegardé ou en crée un nouveau
   * @method createPlayer
   * @param  nickName     pseudo du joueur
   * @return              le joueur sauvegardé si il'y en a un ou un nouveau sinon
   */
  public Player createPlayer(String nickName)
  {
    String path = "../Data/"+ nickName + ".ser";
    File donnee = new File(path);
    if (donnee.exists())
    {
      return (Player.use(path));
    }
    return (new Player(nickName, 5, 0));
  }
  /**
   * Cette méthode initialise le tableau des niveaux
   * @method fillLevelTab
   * @return tableau des niveaux
   */
  public Level[] fillLevelTab()
  {
    String dataDirectoryPath = "../Data/Levels";
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
        return (levels);
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
    return (null);
  }
}
