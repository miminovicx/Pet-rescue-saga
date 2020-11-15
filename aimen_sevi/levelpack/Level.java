package levelpack;
import java.util.Scanner;
/**
 * Classe représentant un niveau
 */
public class Level
{
  private static int id=1;
  private final int num;
  private int stars;
  private int score;
  private int lastScore;
  private Field field;
  private boolean succeded = true;
  private int[] palier;
  private int animalsToRescue;
  private Scanner sc;
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
    this.succeded = succeded;
    this.palier = palier;
    this.animalsToRescue = animalsToRescue;
    this.sc = new Scanner(System.in);
    id++;
  }
  /**
   * Cette méthode permet de jouer un niveau
   * @method play
   */
  public void play()
  {
    System.out.println(this);

    int[] coordonnees;
    do
    {

      coordonnees = this.react();
      this.field.updateFinal(coordonnees[0], coordonnees[1]);
      this.score += field.scoreComputation(field.nbBlockSuppr);
      // this.field.update();
      System.out.println(this.field);

    }
    while(this.field.Lost1()==false); //&& this.field.animalsSaved < animalsToRescue); //&& score < objectif
    if(this.field.Lost1())
    {
      this.lost();
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
}
