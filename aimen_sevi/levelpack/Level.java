package levelpack;
public class Level
{
private int num;
private int stars;
private int score;
private int lastScore;
private Field field;
private boolean succeded;
private int[] palier;
  public Level(int num,int stars,int score,int lastScore,Field field,boolean succeded,int[] palier)
  {
    this.num = num;
    this.stars = stars;
    this.score = score;
    this.lastScore = lastScore;
    this.field = field;
    this.succeded = succeded;
    this.palier = palier;
  }
  public String toString()
  {
    if(succeded)
    {
    return("Level : "+this.num+"\nStars :"+this.stars+"\nScore : "+this.score);
    }
  }

}
