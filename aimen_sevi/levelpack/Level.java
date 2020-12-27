package levelpack;
import java.io.*;
import java.util.Scanner;
import levelpack.Field;
import pack.Environment;
import pack.Player;

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
  // private transient Scanner sc;
  static Scanner sc;
  private boolean unlocked;


  /**
  * Consructeur d'un niveau
  * @method Level
  * @param  stars           nobre d'étoiles (entre 0 et 3)
  * @param  score           score du niveau
  * @param  field           plateau de jeu du niveau
  * @param  palier          tableau de trois entiers représentant chacun un objectif à atteindre pour avoir des étoiles
  * @param  animalsToRescue le nombre d'animaux qui doivent être sauvé pour réussir le niveau
  */
  public Level(int score, Field field, int[] palier, int animalsToRescue)
  {
    this.num = id;
    this.stars = 0;
    this.score = score;
    this.field = field;
    this.palier = palier;
    this.animalsToRescue = animalsToRescue;
    this.sc = new Scanner(System.in);
    id++;
  }

  /**
   * Cette methode permet d'obtenir le numero du niveau
   * @return num du niveau
   */
  public int getNum()
  {
    return (this.num) ;
  }


  public int getStars()
  {
    return (this.stars);
  }

  public void setStars(int stars)
  {
    this.stars = stars;
  }



  /**
  * Cette méthode permet de jouer un niveau
  * @method play
  */
  public void play(Player player)
  {
    if(player.getUnlocked()[this.id - 1])
    {
      System.out.println(this);

      int[] coordonnees;
      do
      {
        if(useBooster())
        {
          this.chooseBooster(player);
        }

        coordonnees = this.react();
        this.field.updateFinal(coordonnees[0], coordonnees[1]);
        // this.field.remove(coordonnees[0],coordonnees[1]);
        // System.out.println(this.field);
        // this.field.updateSemiFinal();
        this.score += field.scoreComputation(field.nbBlockSuppr);
        System.out.println(this.field);

      }
      while(!this.Lost0() && !this.Won0());
      if(this.Lost0())
      {
        Level toSave = Level.use("../Data/Levels/level_" + this.id + ".ser");
        this.lost();
        toSave.field.animalsSaved = 0 ;
        toSave.save();

      }
      if(this.Won0())
      {
        player.setUnlocked(this.id);
        Level toSave = Level.use("../Data/Levels/level_" + this.id + ".ser");
        this.win();
        toSave.field.animalsSaved = 0 ;
        toSave.save();
      }

    }
    else
    {
      System.out.println("Indisponible");
    }
  }


  /**
  * Cette méthode permet de demander les coordonnees de la case à jouer
  * @method react
  * @return tableau de deux entiers le premier étant l'abscisse et le second étant l'ordonée
  */
  private int [] react()
  {
    int [] coordonnees = new int[2];
    int a;
    int b;
    do {
      System.out.format("veuillez donner un x entre 0 et %d : ",this.field.getHeight() - 1);
      a = sc.nextInt();
      System.out.format("veuillez donner un y entre %d et %d : ", this.field.firstLineToDisplay() , ( this.field.firstLineToDisplay() + this.field.getIntervalle() - 1  ) );
      b = sc.nextInt();
    } while ((b < this.field.firstLineToDisplay() ) || (b > (this.field.firstLineToDisplay() + this.field.getIntervalle() -1) ) || (a < 0) || (a > this.field.getHeight() - 1));
      System.out.println(""); //laisse une ligne vide
    coordonnees[0] = b;
    coordonnees[1] = a;
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
    res += "\u001B[31m *\tPERDU\t    * \u001B[0m \n*Score  : " + this.score + "       *\n*Animaux sauvé : " + this.field.animalsSaved + "/" +this.animalsToRescue;
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
    res += "\u001B[32m *\tGAGNÉ\t    * \u001B[0m \n*Score  : " + this.score + "       *\n*Animaux sauvé : " + this.field.animalsSaved + "/" +this.animalsToRescue;
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
    //if(succeded)
    res += "Level : " + this.num + "\nStars :" + this.stars + "\nObjectif : " + this.score + "\n\n";
    // else
    // res += "Level : " + this.num + "\nStars :" + this.stars + "\nObjectif : " + this.score + "\n\n";
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
  * Cette methode permet de recuperer un niveau depuis le disque
  * @method use
  * @param  path le chemin dans lequel se trouve le niveau
  * @return      le niveau sauvegardé sous forme d'objet
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
    for(int i = this.field.firstLineToDisplay(); i < this.field.firstLineToDisplay() + this.field.getIntervalle() && found!=true;i++)
    {
      for(int j = 0; j<this.field.getHeight() && found!=true;j++)
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

 /**
  * Cette methode d'initialiser le score du niveau
  * @param s le score
  */
  public void setScore(int s)
  {
    this.score = s;
  }

  private boolean useBooster()
  {
    char rep;
    Scanner ans = new Scanner(System.in);
    do {
      System.out.print("Voulez vous utiliser un booster ? (o/n) ");
      rep = ans.nextLine().charAt(0);
    } while (rep != 'o' && rep != 'n');


    if(rep == 'o')
    {
      return true;
    }
    return false;
  }

  private void chooseBooster(Player player)
  {

      player.displayBoosters();
      int answer;
      do {
        System.out.print("Quel booster voulez-vous utiliser ? (1/2/3/4/0) ");
        answer = sc.nextInt();
      } while ((answer < 0) || (answer > 4));

      switch(answer)
      {

        case 1 :
          if(player.getBoost()[0] > 0)
          {
            int a;
            do
            {
            System.out.println("Sur quelle colonne voulez vous utiliser ? ");
            System.out.print("Veuillez entrer un x : ");
            a = sc.nextInt();
            } while (a < 0 || a > this.field.getHeight() - 1);
            player.removeRocket();
            this.field.useRocket(a);
          }
          else
          {
            System.out.println("Vous n'avez pas assez de fusées");
            chooseBooster(player);
          }
        break;

        case 2 :
          if(player.getBoost()[1] > 0)
          {
              int a;
              do {
              System.out.print("Sur quelle ligne voulez vous utiliser ? ");
              a = sc.nextInt();
            } while (a < this.field.firstLineToDisplay() - 1 || a > this.field.firstLineToDisplay() + this.field.getIntervalle() -1);
              player.removeSpring();
              this.field.useSpring(a);
          }
          else
          {
            System.out.println("Vous n'avez pas assez de ressors");
            chooseBooster(player);
          }
        break;

        case 3 :
          if(player.getBoost()[2] > 0)
          {
            int a;
            int b;
            do {
            System.out.println("Quel bloc voulez-vous supprimer ?");
            System.out.print("Veuillez entrer un x : ");
            a = sc.nextInt();
            System.out.print("Veuillez entrer un y : ");
            b = sc.nextInt();
          } while ( (a < 0) || (a > this.field.getHeight()) || (b < this.field.firstLineToDisplay() ) || (b > (this.field.firstLineToDisplay() + this.field.getIntervalle() -1) ));
            player.removePickaxe();
            this.field.usePickaxe(b,a);
            // System.out.println(this.field);
            // this.field.updateSemiFinal();
            // System.out.println(this.field);
          }
          else
          {
            System.out.println("Vous n'avez pas assez de marteaux");
            chooseBooster(player);
          }
        break;

        case 4 :
          if(player.getBoost()[3] > 0)
          {
            int a;
            int b;
            do {
            System.out.println("Quel bloc voulez-vous supprimer ?");
            System.out.print("Veuillez entrer un x : ");
            a = sc.nextInt();
            System.out.print("Veuillez entrer un y : ");
            b = sc.nextInt();
          } while ( (a < 0) || (a > this.field.getHeight()) || (b < this.field.firstLineToDisplay() ) || (b > (this.field.firstLineToDisplay() + this.field.getIntervalle() -1) ));
            player.removeBallons();
            this.field.useBallon(b,a);
          }
          else
          {
            System.out.println("Vous n'avez pas assez de ballons");
            chooseBooster(player);
          }
        break;

      }
      System.out.println(this.field);
      this.field.updateSemiFinal();
      System.out.println(this.field);
    }
  }
