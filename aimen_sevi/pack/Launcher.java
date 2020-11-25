package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;
public class Launcher
{
  static Scanner ans = new Scanner(System.in);
  public static void gameLoop()
  {
    System.out.print("Pseudo : ");
    String pseudo;
    pseudo = ans.nextLine();

    menu(pseudo);



  }

  public static void menu(String pseudo)
  {
    System.out.println("*******MENU********");
    System.out.println("1- Jouer");
    System.out.println("2- Aide");
    System.out.println("3- Quitter");
    choose(pseudo);
  }

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
