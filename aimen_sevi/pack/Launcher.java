package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;
public class Launcher
{
  static Scanner ans = new Scanner(System.in);
  public static void gameLoop()
  {

    //affichage menu
    menu();
    // char answer;
    // answer = ans.nextLine().charAt(0);
    // switch(answer)
    // {
    //   case '1' :
    //   //jouer
    //   break;
    //   case '2' :
    //   //help
    //   break;
    //   case '3' :
    //   System.exit(0);
    //   break;
    //   default :
    //   //rappel methode
    //   break;
    // }

    // Environment env = new Environment();
    // do
    // {
    //   env.fillLevelTab();
    //   env.createPlayer("aim");
    //   env.chooseLevel();
    //   System.out.print("Voulez-vous continuer le jeu?(o/n)");
    //   answer = ans.next().charAt(0);
    // }
    // while(answer == 'o');
    // System.out.println("À la prochaine...");
    // System.exit(0);
  }

  public static void menu()
  {
    System.out.println("*******MENU********");
    System.out.println("1- Jouer");
    System.out.println("2- Aide");
    System.out.println("3- Quitter");
    choose();
  }

  public static void choose()
  {
    char answer;
    answer = ans.nextLine().charAt(0);
    switch(answer)
    {
      case '1' :
      play();
      break;

      case '2' :
      System.out.println("HELP MEEEEEEE");
      choose();
      break;

      case '3' :
      System.exit(0);
      break;

      default :
      choose();okok
      break;
    }
  }

  public static Environment initialiseEnv()
  {
    Environment env = new Environment();
    System.out.print("Pseudo : ");
    String answer;
    answer = ans.nextLine();
    env.createPlayer(answer);
    env.fillLevelTab();
    return (env);
  }

  public static void play()
  {
    Environment env = initialiseEnv();
    // System.out.println()
    System.out.println(env);
    env.chooseLevel();
    menuContinuer();
    // menu();
  }

  public static void menuContinuer()
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
      play();
    }
    else
    {
      menu();
    }

  }

  public static void lifeRegenerator()
  {
    Timer t = new Timer();
    t.schedule(new TimerTask()
    {
      @Override
      public void run()
      {
        env.getPlayer().heal();
        System.out.println(env.getPlayer());
      }
    } , 0, 10000);
  }
}
