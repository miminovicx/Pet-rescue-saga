package levelpack;
import java.io.*;
import java.util.Scanner;
import levelpack.Field;
import pack.Environment;
/**
* Classe représentant un niveau
*/
public class Level implements java.io.Serializable
{
  private static final long serialVersionUID = 42l;
  private static int id=1;
  private final int num;
  private int stars;
  private int score;
  private int lastScore;
  private  Field field; //
  private transient Field fieldCopy;
  private boolean succeded = true;
  private int[] palier;
  private int animalsToRescue;
  private transient Scanner sc;
  private boolean unlocked;
  /**
  * Consructeur d'un niveau
  * @method Level
  * @param  stars           nobre d'étoiles (entre 0 et 3)
  * @param  score           score du niveau
  * @param  lastScore       dérnier score (si le niveau n'a jamais été joué cette attribut vaut 0)
  * @param  field           plateau de jeu du niveau
  * @param  succeded        booléen permetant de savoir si on a déjà gagné le niveau
  * @param  palier          tableau de trois entiers représentant chacun un objectif à atteindre pour avoir des étoiles
  * @param  animalsToRescue le nombre d'animaux qui doivent être sauvé pour réussir le niveau
  */
  public Level(int stars, int score, int lastScore, Field field, boolean succeded, int[] palier, int animalsToRescue)
  {
    this.num = id;
    this.stars = stars;
    this.score = score;
    this.lastScore = lastScore;
    this.field = field;
    //this.playingField = field;
    this.succeded = succeded;
    this.palier = palier;
    this.animalsToRescue = animalsToRescue;
    this.sc = new Scanner(System.in);
    this.unlocked = unlocked;
    id++;
  }

  public int getNum()
  {
    return (this.num) ;
  }

  public boolean getSucceded()
  {
    return (this.succeded);
  }

  public boolean getUnlocked()
  {
    return (this.unlocked);
  }

  public void setUnlocked(boolean unlocked)
  {
    this.unlocked = unlocked;
  }

  /**
  * Cette méthode permet de jouer un niveau
  * @method play
  */
  public void play()
  {
    if(this.unlocked)
    {
      System.out.println(this);

      int[] coordonnees;
      do
      {
        this.fieldCopy = this.field;
        coordonnees = this.react();
        this.field.updateFinal(coordonnees[0], coordonnees[1]);
        this.score += field.scoreComputation(field.nbBlockSuppr);
        // this.field.update();
        System.out.println(this.field);

      }while(!this.Lost0() && !this.Won0());
      if(this.Lost0())
      {
        this.lost();
      }
      if(this.Won0())
      {
        Environment.unlock(this.getNum());
        this.succeded = true;
        this.win();
      }
    }
    else
    {
      System.out.println("Indisponible");
    }
    this.field = this.fieldCopy;
    //this.save();
  }
  /**
  * Cette méthode permet de demander les coordonnees de la case à jouer
  * @method react
  * @return tableau de deux entiers le premier étant l'abscisse et le second étant l'ordonée
  */
  private int [] react()
  {
    int [] coordonnees = new int[2];
    System.out.format("veuillez donner un x entre 0 et %d\n",this.field.getWidth() - 1);
    coordonnees[0] = sc.nextInt();
    System.out.format("veuillez donner un y entre 0 et %d\n",this.field.getHeight() - 1);
    coordonnees[1] = sc.nextInt();
    return (coordonnees);
  }
  /**
  * Cette méthode affiche un message si le niveau est perdu
  * @method lost
  */
  public void lost()
  {
    String res = "";
    res += "*********************\n";
    res += "*\tPERDU\t    *\n*Score  : " + this.score + "       *\n*Animaux sauvé : " + this.field.animalsSaved + "/" +this.animalsToRescue;
    res += "*\n*********************";
    System.out.println(res);
  }
  /**
  * Cette méthode affiche un message si le niveau est gagné
  * @method win
  */
  public void win()
  {
    String res = "";
    res += "*********************\n";
    res += "*\tGAGNÉ\t    *\n*Score  : " + this.score + "       *\n*Animaux sauvé : " + this.field.animalsSaved + "/" +this.animalsToRescue;
    res += "*\n*********************";
    System.out.println(res);
  }
  /**
  * Cette méthode permet d'afficher un niveau
  * @method toString
  * @return chaîne affiché lorsque l'on un niveau avec System.out.println()
  */
  public String toString()
  {
    String res = "";
    if(succeded)
    res += "Level : " + this.num + "\nStars :" + this.stars + "\nObjectif : " + this.score + "\nLast score : " + this.lastScore + "\n\n";
    else
    res += "Level : " + this.num + "\nStars :" + this.stars + "\nObjectif : " + this.score + "\n\n";
    res += this.field.toString();
    return (res);
  }
  /**
  * Cette méthode permet de rendre les niveaux persistants
  * @method save
  */
  public void save()
  {
    String filePath = "../Data/Levels/level_"+ this.num + ".ser";
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
  * [use description]
  * @method use
  * @param  path [description]
  * @return      [description]
  */
  public  static Level use(String path)
  {
    Level level = null;
    try
    {
      FileInputStream fileIn = new FileInputStream(path);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      level = (Level) in.readObject();
      in.close();
      fileIn.close();
    }
    catch (IOException i)
    {
      throw new IllegalArgumentException(String.format("Couldn't read level at : %s", path), i);
    }
    catch (ClassNotFoundException e)
    {
      throw new IllegalArgumentException("This litterally cannot happen. What have you done ???", e);
    }
    level.sc= new Scanner(System.in);
    return (level);
  }
  /**
  * Cette methode permet de savoir si on a encore des combinaisons possibles
  * @return vrai si il n'y a plus d'élément que l'on peut supprimé
  */
  public boolean Lost1()     //end of game because there's no delete possible
  {
    boolean found = false;
    for(int i = 0; i<this.field.getWidth() && found!=true;i++)
    {
      for(int j = 0; j<this.field.getWidth() && found!=true;j++)
      {
        if(this.field.deletable(i,j) == true)
        {
          found = true; //il y a une combinaison possible
        }
      }
    }
    return (!found);
  }

  /**
  * Cette methode permet de savoir si on a atteint le score minimal pour gagner le niveau
  * @return vrai si on a pas atteint l'objectif
  */
  public boolean Lost2()
  {
    return (this.score < palier[0]);
  }

  /**
  * Cette methode permet de savoir si on a sauvé assez d'animaux
  * @return vrai si on n'a pas sauvé assez d'animaux
  */
  public boolean Lost3()
  {
    return(this.field.animalsSaved < this.animalsToRescue);
  }

  /**
  * Cette methode permet de savoir si on a perdu
  * @return vrai si on a perdu
  */
  public boolean Lost0()
  {
    return ( this.Lost1() && ( this.Lost2() || this.Lost3() ) );
  }

  /**
  * Cette methode permet de savoir si on a gagné
  * @return vrai si on a gagnLevelé
  */
  public boolean Won0()
  {
    if(this.field.animalsSaved == this.animalsToRescue && score >= palier[0] )
    {
      return true;
    }
    return false;
  }

  public void setScore(int s)
  {
    this.score = s;
  }
  // public stavoid unlock(int a)
  // {
  //   Level[] l = Environment.getLevels();
  //
  // }

}
