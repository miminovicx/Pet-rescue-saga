package levelpack;
public class Level
{
  private int id;
  private final int num;
  private int stars;
  private int score;
  private int lastScore;
  private Field field;
  private boolean succeded=true;
  private int[] palier;
  public Level(int stars, int score, int lastScore, Field field, boolean succeded, int[] palier)
  {
    this.num = id;
    this.stars = stars;
    this.score = score;
    this.lastScore = lastScore;
    this.field = field;
    this.succeded = succeded;
    this.palier = palier;
    id++;
  }
  public String toString()
  {
    String res = "";
    if(succeded)
      res += "Level : " + this.num + "\nStars :" + this.stars + "\nObjectif : " + this.score + "\nLast score : " + this.lastScore + "\n\n";
    else
      res += "Level : " + this.num + "\nStars :" + this.stars + "\nObjectif : " + this.score + "\n\n");
    res += this.field.toString();
    return (res);
  }
}
