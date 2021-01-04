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
  private static final long serialVersionUID = 1L;
  private static int id = 1;
  private final int num;
  private  Field field;
  private int[] palier;
  private int score;
  private int animalsToRescue;
  static Scanner sc;

  /**
  * Consructeur d'un niveau
  * @method Level
  * @param  field           plateau de jeu du niveau
  * @param  palier          tableau de trois entiers représentant chacun un objectif à atteindre pour avoir des étoiles
  * @param  animalsToRescue le nombre d'animaux qui doivent être sauvé pour réussir le niveau
  */
  public Level(Field field, int[] palier, int animalsToRescue)
  {
    this.num = id;
    this.field = field;
    this.palier = palier;
    this.score = 0;
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

  public int getScore()
  {
    return this.score;
  }

  public Field getField()
  {
    return this.field;
  }

  public int[] getPalier()
  {
    return this.palier;
  }

  public int getAnimalsToRescue()
  {
    return (this.animalsToRescue) ;
  }

  /**
  * Cette méthode permet de jouer un niveau
  * @method play
  */
  public void play(Player player)
  {
    if(player.getUnlocked()[this.id - 1])
    {
      displayPreLevel(player);
      System.out.println(this.field);
      int[] coordonnees;
      do
      {
        if(useBooster())
        {
          this.chooseBooster(player);
        }

        if(!this.Lost0() && !this.Won0())
        {
          coordonnees = this.react();
          int a = this.field.updateFinal(coordonnees[0], coordonnees[1]);
          if(a >= 1)
          {
            System.out.println("Animal sauvé !\n");
            this.score += 1000*a;
          }
          this.score += field.scoreComputation(field.nbBlockSuppr);
          System.out.println("Score : " + this.score + "\n");
          System.out.println(this.field);
        }

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
        if(this.id < player.getUnlocked().length)
        {
          player.setUnlocked(this.id);
        }
        this.win();
        Level toSave = Level.use("../Data/Levels/level_" + this.id + ".ser");
        if(this.score > player.getBestScore()[this.num - 1])
        {
          player.setBestScore(this.score, this.num - 1);
          System.out.println("Nouveau meilleur score : " + this.score);
        }
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
    System.out.println("\nQuel bloc voulez-vous supprimer ?");
    do {
      System.out.format("Veuillez choisir une colonne entre 0 et %d : ",this.field.getHeight() - 1);
      a = sc.nextInt();
      System.out.format("Veuillez choisir une ligne entre %d et %d : ", this.field.firstLineToDisplay() , ( this.field.firstLineToDisplay() + this.field.getInterval() - 1  ) );
      b = sc.nextInt();
    } while ((b < this.field.firstLineToDisplay() ) || (b > (this.field.firstLineToDisplay() + this.field.getInterval() -1) ) || (a < 0) || (a > this.field.getHeight() - 1));
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
    // res += "*********************\n";
    res += "\u001B[31m      PERDU     \u001B[0m*\n*Score  : " + this.score + "       *\n*Animaux sauvé : " + this.field.animalsSaved + "/" +this.animalsToRescue;
    // res += "\n;
    System.out.println(res);
  }
  /**
  * Cette méthode affiche un message si le niveau est gagné
  * @method win
  */
  public void win()
  {
    String res = "";
    // res += "*********************\n";
    res += "\u001B[32m      GAGNÉ     \u001B[0m \nScore  : " + this.score + "       \nAnimaux sauvé : " + this.field.animalsSaved + "/" +this.animalsToRescue;
    System.out.println(res);
    this.displayStars(this.score);

    // res += "*\n*********************";

  }
  /**
  * Cette méthode permet d'afficher un niveau
  * @method toString
  * @return chaîne affiché lorsque l'on un niveau avec System.out.println()
  */
  public String toString()
  {
    String res = "";
    res += "Niveau : " + this.num + "\nObjectif : " + this.score + "\n\n";
    res += this.field.toString();
    return (res);
  }

  public void displayPreLevel(Player player)
  {
    System.out.println("Objectif : " + this.palier[0]);
    int bestScore = player.getBestScore()[this.num - 1];
    System.out.println("Meilleur score : " + bestScore);
    this.displayStars(bestScore);
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
    for(int i = this.field.firstLineToDisplay(); i < this.field.firstLineToDisplay() + this.field.getInterval() && found!=true;i++)
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
            System.out.println("Sur quelle colonne voulez vous l'utiliser ? \uD83D\uDE80");
            System.out.print("Veuillez entrer un x : ");
            a = sc.nextInt();
            } while (a < 0 || a > this.field.getHeight() - 1);
            player.removeRocket();
            this.field.useRocket(a);
            this.score += 300;
          }
          else
          {
            System.out.println("Vous n'avez pas assez de fusées \uD83D\uDE80");
            chooseBooster(player);
          }
        break;

        case 2 :
          if(player.getBoost()[1] > 0)
          {
              int a;
              do {
              System.out.print("Sur quelle ligne voulez vous l'utiliser ? \uD83E\uDE83");
              a = sc.nextInt();
            } while (a < this.field.firstLineToDisplay() - 1 || a > this.field.firstLineToDisplay() + this.field.getInterval() -1);
              player.removeBoomerang();
              this.field.useBoomerang(a);
              this.score += 300;
          }
          else
          {
            System.out.println("Vous n'avez pas assez de boomerangs \uD83E\uDE83");
            chooseBooster(player);
          }
        break;

        case 3 :
          if(player.getBoost()[2] > 0)
          {
            int a;
            int b;
            do {
            System.out.println("Quel bloc voulez-vous supprimer ? \uD83D\uDD28");
            System.out.print("Veuillez choisir une colonne : ");
            a = sc.nextInt();
            System.out.print("Veuillez choisir une ligne : ");
            b = sc.nextInt();
          } while ( (a < 0) || (a > this.field.getHeight()) || (b < this.field.firstLineToDisplay() ) || (b > (this.field.firstLineToDisplay() + this.field.getInterval() -1) ));
            player.removePickaxe();
            this.field.usePickaxe(b,a);
            this.score += 50;
            // System.out.println(this.field);
            // this.field.updateSemiFinal();
            // System.out.println(this.field);
          }
          else
          {
            System.out.println("Vous n'avez pas assez de marteaux \uD83D\uDD28");
            chooseBooster(player);
          }
        break;

        case 4 :
          if(player.getBoost()[3] > 0)
          {
            int a;
            int b;
            do {
            System.out.println("Quel bloc voulez-vous supprimer ? \uD83C\uDF88");
            System.out.print("Veuillez choisir une colonne : ");
            a = sc.nextInt();
            System.out.print("Veuillez entrer une ligne : ");
            b = sc.nextInt();
          } while ( (a < 0) || (a > this.field.getHeight()) || (b < this.field.firstLineToDisplay() ) || (b > (this.field.firstLineToDisplay() + this.field.getInterval() -1) ));
            player.removeBallons();
            this.field.useBallon(b,a);
            this.score += 600;
          }
          else
          {
            System.out.println("Vous n'avez pas assez de ballons \uD83C\uDF88");
            chooseBooster(player);
          }
        break;

      }
      this.field.updateSemiFinal();
      System.out.println(this.field);
    }

  public void displayStars(int score)
  {
      int s = 0;
      if(score > this.palier[0])
      {
        s = 1;
      }
      if(score > this.palier[1])
      {
        s = 2;
      }
      if(score > this.palier[2])
      {
        s = 3;
      }
      String res = "";
      for(int i = 0; i < s; i++)
      {
        res += "\u2B50 ";
      }
      if(s == 0)
      {
        res = "0";
      }
      res += "\n";
      System.out.println("Etoiles : " + res);
      // System.out.println(this.field);
    }

    public void playBot()
    {
      int a;
      int b;
      do {
        a = (int)(Math.random() * (this.field.getHeight()));
        b = this.field.firstLineToDisplay() + (int)(Math.random() * ((this.field.getInterval())));
        if(this.field.deletable(a,b))
        {
          System.out.println("Suppression du bloc : \nColonne : " + b + "\nLigne : " + a + "\n");
          this.field.updateFinal(a,b);
          this.score += field.scoreComputation(field.nbBlockSuppr);
          System.out.println(this.field);
        }
      } while(!this.Lost0() && !this.Won0());
      if(this.Won0())
      {
        System.out.println("Le bot a gagné\nScore : "+ this.score +"\n");
        this.displayStars(this.score);
      }
      else if(this.Lost0())
      {
        System.out.println("Le bot a perdu\nScore : " + this.score);

      }
      this.field.animalsSaved = 0;
    }

  }
