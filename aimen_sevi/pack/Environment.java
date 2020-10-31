package pack;
import java.util.Arrays;
public class Environment
{
  private Player player;
  private int[] levels;

  public Environment (Player player , int [] levels)
  {
    this.levels = levels;
    this.player = player;
  }

  public int[] getLevels()
  {
    return (this.levels);
  }

  public Player getPlayer()
  {
    return (this.player);
  }

  public void setLevels(int[] levels)
  {
    this.levels = levels;
  }

  public void setPlayer(Player player)
  {
    this.player = player;
  }

  public String toString()
  {
    return (this.player.toString() + Arrays.toString(this.levels));
  }

  public Player createPlayer(String nickName)
  {
    return (new Player(nickName, 5, 0));
  }
}
