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
  //private Booster [] boosters;
  private int coins;
  private transient Scanner scan;

  public  String getNickName()
  {
    return (this.nickName);
  }

  public int getLifePoints()
  {
    return (this.lifePoints);
  }

  public Scanner getScanner()
  {
    return (this.scan);
  }
  // public Booster [] getBoosters()
  // {
  //   return (this.boosters);
  // }

  public int getCoins()
  {
    return (this.coins);
  }

  public  void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  public void setLifePoints(int lifePoints)
  {
    this.lifePoints = lifePoints;
  }

  // public void setBoosters(Booster [] boosters)
  // {
  //   this.boosters = boosters;
  // }

  public void setCoins(int coins)
  {
    this.coins = coins;
  }

  public Player(String nickName, int lifePoints, /*Booster[] boosters,*/ int coins)
  {
    this.nickName = nickName;
    this.lifePoints = lifePoints;
    //this.boosters = boosters;
    this.coins = coins;
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
  public String toString()
  {
    return ("Pseudo : " + this.nickName + "\n" +
            "Points de vie : " + this.lifePoints + "\n" +
            "Pièces de monaie : " + this.coins + "\n");
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
