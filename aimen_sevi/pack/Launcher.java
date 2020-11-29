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
    System.out.print("Pseudo : ");
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
    System.out.println("*******MENU********");
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
    answer = ans.nextLine().charAt(0);
    switch(answer)
    {
      case '1' :
      play(pseudo);
      break;

      case '2' :
      System.out.println("HELP MEEEEEEE");
      choose(pseudo);
      break;

      case '3' :
      System.exit(0);
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

  // public static void lifeRegenerator(Environment env)
  // {
  //   Date date = new Date();
  //   Timer t = new Timer();
  //   t.schedule(new TimerTask()
  //   {
  //     @Override
  //     public void run()
  //     {
  //       // env.getPlayer().heal();
  //       // System.out.println(env.getPlayer().getLifePoints());
  //       if(env.getPlayer().getLifePoints() < 5)
  //       {
  //         env.getPlayer().setLifePoints(env.getPlayer().getLifePoints() + 1);
  //         // System.out.println("Vie ajoutée" + env.getPlayer().getLifePoints());
  //       }
  //
  //     }
  //   } , date, 199000);  //toutes les 30s
  // }
}
