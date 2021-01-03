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
  private int[] boost;
  private boolean[] unlocked;
  private int[] bestScore;


  private transient Scanner scan;

  /**
  * Constructeur de Player
  * @param nickName   pseudo du joueur
  */
  public Player(String nickName)
  {
    this.nickName = nickName;
    this.scan = new Scanner(System.in);
    this.boost = new int[4];
    this.boost[0] = 3; //pour les fusées càd les suppression de colonnes
    this.boost[1] = 3; //pour les ressors qui suppr les lignes
    this.boost[2] = 3; //pour les marteaux qui suppr un seul bloc
    this.boost[3] = 3; //ballons

    this.unlocked = new boolean[5];
    this.unlocked[0] = true;
    this.unlocked[1] = false;
    this.unlocked[2] = false;
    this.unlocked[3] = false;
    this.unlocked[4] = false;

    this.bestScore = new int[5];
    this.bestScore[0] = 0;
    this.bestScore[1] = 0;
    this.bestScore[2] = 0;
    this.bestScore[3] = 0;
    this.bestScore[4] = 0;
  }


/**
 * Cette methode permet de recuperer le pseudo du joueur
 * @return le pseudo du joueur
 */
  public  String getNickName()
  {
    return (this.nickName);
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
   * Cette méthode permet de recuperer le tableau de boosters
   * @return un tableau d'entiers
   */
  public int[] getBoost()
  {
    return this.boost;
  }

  /**
   * Cette méthode permet d'initialiser le nombre de boosters
   * @param a la quantité de boosters
   * @param b le type de booster
   */
  public void setBoost(int a, int b)
  {
    this.boost[b] = a;
  }

  /**
   * Cette méthode permet de recuperer le tableau des etats des niveaux des joueurs
   * @return un tableau de booleens
   */
  public boolean[] getUnlocked()
  {
    return this.unlocked;
  }

  /**
   * Cette méthode permet de deverouiller un niveau
   * @param a le niveau à deverouiller
   */
  public void setUnlocked(int a)
  {
    if(a >= 0 && a < 5)
    {
      this.unlocked[a] = true;
    }
  }

  /**
   * Cette méthode permet de recuperer le tableau des meilleurs scores du joueur
   * @return un tableau d'entiers
   */
  public int[] getBestScore()
  {
    return this.bestScore;
  }

  /**
   * Cette méthode permet de mettre à jour le best score
   * @param a le score
   * @param b le niveau
   */
  public void setBestScore(int a, int b)
  {
    this.bestScore[b] = a;
  }


  /**
   * Cette methode permet d'afficher le joueur
   * @return le pseudo et le nombre de points de vies du joueur
   */
  public String toString()
  {
    return ("Pseudo : " + this.nickName + "\n");
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

  /**
   * Cette méthode permet d'afficher les boosters
   */
  public void displayBoosters()
  {
    System.out.println("1- Fusées    \uD83D\uDE80 : " + this.boost[0]);
    System.out.println("2- Boomerang \uD83E\uDE83 : " + this.boost[1]);
    System.out.println("3- Marteau   \uD83D\uDD28 : " + this.boost[2]);
    System.out.println("4- Ballons   \uD83C\uDF88 : " + this.boost[3]);
    System.out.println("0- Aucun \n");
  }

  /**
   * Cette methode retire une fusée au joueur
   */
  public void removeRocket()
  {
    this.boost[0]--;
  }

  /**
   * Cette methode retire un boomerang au joueur
   */
  public void removeBoomerang()
  {
    this.boost[1]--;
  }

  /**
   * Cette methode retire un marteau au joueur
   */
  public void removePickaxe()
  {
    this.boost[2]--;
  }

  /**
   * Cette methode retire un ballon au joueur
   */
  public void removeBallons()
  {
    this.boost[3]--;
  }

}
