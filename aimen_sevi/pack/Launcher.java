package pack;
import levelpack.Level;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

/**
 * Classe permettant de démarrer le programme
 */
public class Launcher
{
  static Scanner ans = new Scanner(System.in);
  // public static final reset;
  public static final String CYAN = "\033[0;36m";
  public static final String RESET = "\033[0m";
  public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";
  public static final String bearEmoji = "\uD83D\uDC3B";
  public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
  public static final String RED_BOLD = "\033[1;31m";
  public static final String GREEN_BOLD = "\033[1;32m";
  public static final String YELLOW_BOLD = "\033[1;33m";
  public static final String WHITE_UNDERLINED = "\033[4;37m";

  /**
   * Cette méthode représente la gameLoop (boucle pricipale du jeu)
   * @method gameLoop
   */
  public static void gameLoop()
  {
    System.out.print("\n\t" + CYAN_BOLD_BRIGHT + "Pet Rescue Saga 2.0 " + bearEmoji + RESET + "\n- Pseudo : ");
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
    System.out.println(WHITE_UNDERLINED + "\n\tMENU" + RESET);
    System.out.println("1- " + GREEN_BOLD + "Jouer" + RESET);
    System.out.println("2- " + YELLOW_BOLD + "Aide" + RESET);
    System.out.println("3- " + RED_BOLD + "Quitter\n" + RESET);
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
    System.out.println("");
    switch(answer)
    {
      case '1' :
        play(pseudo);
      break;

      case '2' :
        // menuAide();
        System.out.println(WHITE_UNDERLINED + "\n\tRégles du jeu" + RESET + "\033[0m\nVous devez \033[1msauver les animaux ! \033[0mPour cela il faut faire exploser les blocs \033[1men dessous\033[0m");
        System.out.println("Vous pouvez faire exploser \033[1mun ou plusieurs blocs\033[0m de la \033[1mmême couleur\033[0m s'ils sont deux ou plus à être voisins.");
        System.out.println("Vous avez \033[1mgagné\033[0m si vous avez \033[1msauvé tous les animaux\033[0m et avez atteint le \033[1mscore objectif.\033[0m");
        System.out.println("Le jeu \033[1ms'arrête\033[0m si vous avez \033[1mgagné\033[0m ou s'il n'y a \033[1mplus de blocs à exploser\033[0m");
        System.out.println("Les niveaux gagnés sont affichés"+ GREEN_BOLD + " en vert" + RESET);
        System.out.println("Les niveaux déverouillés mais pas encore gagnés sont affichés" + YELLOW_BOLD + " en jaune" + RESET);
        System.out.println("Les niveaux verrouillés sont affichés" + RED_BOLD + " en rouge" + RESET);
        System.out.println("A chaque niveau gagné, vous \033[1mdéverrouiller le suivant\033[0m");
        System.out.println("Vous avez un nombre d'\033[1métoiles\033[0m pour chaque niveau gagné \033[1mselon votre score\033[0m\n");
        choose(pseudo);
        menu(pseudo);
      break;

      case '3' :
        char rep;
        do {
          System.out.print("Voulez-vous vraiment quitter ? (o/n) ");
          rep = ans.nextLine().charAt(0);
        } while (rep != 'o' && rep != 'n');
        if(rep == 'o')
        {
          System.out.println("\nA bientot " + pseudo + " \uD83E\uDD0D");
          System.exit(0);
        }
        else
        {
          menu(pseudo);
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
    env.createPlayer(pseudo);
    env.fillLevelTab();
    return (env);
  }

  /**
   * Cette methode permet de jouer au jeu
   * @param pseudo pseudo du joueur qui joue
   */
  public static void play(String pseudo)
  {
    Environment env = initialiseEnv(pseudo);
    System.out.println(env.displayLevels());
    int choice = env.chooseLevel();
    if(choice ==  0)
    {
      menu(pseudo);
    }
    else
    {
      if(env.getPlayer().getUnlocked()[choice - 1] == true)
      {
        System.out.println("1 - Regarder le BOT essayer ! ");
        System.out.println("2 - Essayer vous-mêmes ! ");
        System.out.print("Que souhaitez-vous faire : ");
        Scanner scanner = new Scanner(System.in);
        int a;
        do {
          a = scanner.nextInt();
        } while (a != 1 && a != 2);
        if(a == 1)
        {
          env.playRobot(choice-1);
        }
        else
        {
          env.play(choice - 1);
        }
      }
    }
    System.out.println(env.getPlayer());
    play(pseudo);
  }


  /**
   * Cette méthode permet d'afficher l'aide
   * @return une chaine représentant l'aide à afficher
   */
  public static String helpDisplay()
  {
    return "AIDEAIDEAIDEAIDEAIDEAIDEAIDEAIDE";
  }


}
