package pack;
import java.io.*;
import java.util.Scanner;
/**
 * Classe représentant le joueur
 */
public class Player implements java.io.Serializable
{
  //private static final long serialVersionUID = 544354344438484l;
  private String nickName;
  private int lifePoints;


  private transient Scanner scan;

/**
 * Cette methode permet de recuperer le pseudo du joueur
 * @return le pseudo du joueur
 */
  public  String getNickName()
  {
    return (this.nickName);
  }

  /**
   * Cette methode permet de recuperer le nombre de vies du joueur
   * @return nombre de vies du joueur
   */
  public int getLifePoints()
  {
    return (this.lifePoints);
  }

  /**
   * Cette methode permet de recuperer le scanner
   * @return un scanner
   */
  public Scanner getScanner()
  {
    return (this.scan);
  }

  /**
   * Cette methode permet de donner un pseudo au joueur
   * @param nickName pseudo du joueur
   */
  public  void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  /**
   * Cette methode permet d'initialiser le nombre de vies du joueur
   * @param lifePoints le nombre de vies
   */
  public void setLifePoints(int lifePoints)
  {
    this.lifePoints = lifePoints;
  }




/**
 * Constructeur de Player
 * @param nickName   pseudo du joueur
 * @param lifePoints nombre de vies du joueur
 */
  public Player(String nickName, int lifePoints)
  {
    this.nickName = nickName;
    this.lifePoints = lifePoints;
    this.scan = new Scanner(System.in);
  }
  /**
   * Cette méthode permet de récuperer les points de vie
   * @method heal
   */
  public void heal()
  {
    if(this.lifePoints < 5)
    {
      this.lifePoints++;
    }
  }
  /**
   * Cette methode permet d'afficher le joueur
   * @return le pseudo et le nombre de points de vies du joueur
   */
  public String toString()
  {
    return ("Pseudo : " + this.nickName + "\n" +
            "Points de vie : " + this.lifePoints + "\n");
  }
  /**
   * Cette méthode permet de rendre le joueur persistant
   * @method save
   */
  public void save()
  {
    String filePath = "../Data/" + this.nickName + ".ser";
    try
    {
      FileOutputStream fileOut = new FileOutputStream(filePath);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(this);
      out.close();
      fileOut.close();
    }
    catch (IOException i)
    {
      i.printStackTrace();
    }
  }
  /**
   * Cette méthode permet d'utiliser un joueur savegardé dans le disque
   * @method use
   * @param  path chemin du fichier dans lequel le joueur est sauvegardé
   * @return      un objet de type jouer qui correspond au fichier
   */
  public  static Player use(String path)
  {
    Player player = null;
    try
    {
      FileInputStream fileIn = new FileInputStream(path);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      player = (Player) in.readObject();
      in.close();
      fileIn.close();
    }
    catch (IOException i)
    {
      throw new IllegalArgumentException(String.format("Couldn't read player at : %s", path), i);
    }
    catch (ClassNotFoundException e)
    {
      throw new IllegalArgumentException("This litterally cannot happen. What have you done ???", e);
    }
    player.scan = new Scanner(System.in);
    return (player);
  }
}
