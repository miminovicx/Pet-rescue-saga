package levelpack;
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
    id++;
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
