package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;
public class Launcher
{
  public static void gameLoop()
  {
    Environment env = new Environment();
    char answer;
    Scanner ans = new Scanner(System.in);
    do
    {
      env.fillLevelTab();
      env.createPlayer("aim");
      env.chooseLevel();
      System.out.print("Voulez-vous continuer le jeu?(o/n)");
      answer = ans.next().charAt(0);
    }
    while(answer == 'o');
    System.out.println("À la prochaine...");
    System.exit(0);
  }
}
