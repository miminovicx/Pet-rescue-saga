package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;
/**
 * Classe permettant de démarrer le programme
 */
public class Launcher
{
  static Scanner ans = new Scanner(System.in);

  /**
   * Cette méthode représente la gameLoop (boucle pricipale du jeu)
   * @method gameLoop
   */
  public static void gameLoop()
  {
    System.out.print("BONJOUR ! \uD83D\uDE04\nPseudo : ");
    String pseudo;
    pseudo = ans.nextLine();
    menu(pseudo);



  }

  /**
   * Cette methode affiche le menu principal du jeu
   * @param pseudo le pseudo du joueur
   */
  public static void menu(String pseudo)
  {
    System.out.println("\tMENU");
    System.out.println("1- Jouer");
    System.out.println("2- Aide");
    System.out.println("3- Quitter");
    choose(pseudo);
  }

  /**
   * Cette methode permet de prendre un choix du menu
   * @param pseudo pseudo du joueur
   */
  public static void choose(String pseudo)
  {
    char answer;
    System.out.print("Que souhaitez-vous faire ? ");
    answer = ans.nextLine().charAt(0);
    switch(answer)
    {
      case '1' :
      play(pseudo);
      break;

      case '2' :
      System.out.println("\033[1mRégles du jeu :\033[0m\nVous devez \033[1msauver les animaux ! \033[0mPour cela il faut faire exploser les blocs \033[1men dessous\033[0m");
      System.out.println("Vous pouvez faire exploser \033[1mun ou plusieurs blocs\033[0m de la \033[1mmême couleur\033[0m s'ils sont deux ou plus à être voisins.");
      System.out.println("Vous avez \033[1mgagné\033[0m si vous avez \033[1msauvé tous les animaux\033[0m et avez atteint le \033[1mscore objectif.\033[0m");
      System.out.println("Le jeu \033[1ms'arrête\033[0m si vous avez \033[1mgagné\033[0m ou s'il n'y a \033[1mplus de blocs à exploser\033[0m");
      System.out.println("A chaque niveau gagné, vous \033[1mdéverrouiller le suivant\033[0m");
      System.out.println("Vous avez un nombre d'\033[1métoiles\033[0m pour chaque niveau gagné \033[1mselon votre score\033[0m");
      System.out.println("Une vie vous est otée à chaque fois que vous perdez");
      choose(pseudo);
      break;

      case '3' :
      char rep;
      do {
        System.out.print("Voulez-vous vraiment quitter ? (o/n) ");
        rep = ans.nextLine().charAt(0);
      } while (rep != 'o' && rep != 'n');
      if(rep == 'o')
      {
        System.out.println("A bientot \uD83E\uDD0D");
        System.exit(0);
      }
      else
      {
        choose(pseudo);
      }
      break;

      default :
      choose(pseudo);
      break;
    }
  }

 /**
  * Cette methode initialise l'environnement
  * @param  pseudo pseudo du joueur
  * @return        l'environnement de jeu avec le tableau des niveaux initialisé
  */
  public static Environment initialiseEnv(String pseudo)
  {
    Environment env = new Environment();
    // System.out.print("Pseudo : ");
    // String answer;
    // answer = ans.nextLine();
    env.createPlayer(pseudo);
    env.fillLevelTab();
    // lifeRegenerator(env);
    return (env);
  }

  /**
   * Cette methode permet de jouer au jeu
   * @param pseudo pseudo du joueur qui joue
   */
  public static void play(String pseudo)
  {
    Environment env = initialiseEnv(pseudo);
    // System.out.println()
    System.out.println(env);
    env.chooseLevel();
    System.out.println(env.getPlayer());
    menuContinuer(pseudo);
    // menu();
  }

  /**
   * Cette methode permet de demander si on veut continuer de jouer
   * @param pseudo pseudo du joueur qui joue
   */
  public static void menuContinuer(String pseudo)
  {
    char answer;
    do
    {
      System.out.print("Voulez vous continuer à jouer ? (o/n) ");
      answer = ans.nextLine().charAt(0);
    }
    while(answer != 'o' && answer != 'n');

    if(answer == 'o')
    {
      play(pseudo);
    }
    else
    {
      menu(pseudo);
    }

  }

  }
