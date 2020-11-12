package levelpack;
import java.util.Scanner;
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

  public void play()
  {
    System.out.println(this);

    int[] coordonnees;
    do
    {

      coordonnees = this.react();
      this.field.updateFinal(coordonnees[0], coordonnees[1]);
      //this.score += field.scoreComputation(field.nbBlockSuppr);
      this.field.update();
      System.out.println(this.field);
      System.out.println(this.field.deletable(2,1));

    }
    while(!this.field.Lost1()); //&& this.field.animalsSaved < animalsToRescue); //&& score < objectif
  }

  private int [] react()
  {
    int [] coordonnees = new int[2];
    System.out.format("veuillez donner un x entre 0 et %d",this.field.getWidth() - 1);
    coordonnees[0] = sc.nextInt();
    System.out.format("veuillez donner un y entre 0 et %d",this.field.getHeight() - 1);
    coordonnees[1] = sc.nextInt();
    return (coordonnees);
  }
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
