package pack;
public class Player
{
  private String nickName;
  private int lifePoints;
  //private Booster [] boosters;
  private int coins;

  public  String getNickName()
  {
    return (this.nickName);
  }

  public int getLifePoints()
  {
    return (this.lifePoints);
  }

  // public Booster [] getBoosters()
  // {
  //   return (this.boosters);
  // }

  public int getCoins()
  {
    return (this.coins);
  }

  public  void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  public void setLifePoints(int lifePoints)
  {
    this.lifePoints = lifePoints;
  }

  // public void setBoosters(Booster [] boosters)
  // {
  //   this.boosters = boosters;
  // }

  public void setCoins(int coins)
  {
    this.coins = coins;
  }

  public Player(String nickName, int lifePoints, /*Booster[] boosters,*/ int coins)
  {
    this.nickName = nickName;
    this.lifePoints = lifePoints;
    //this.boosters = boosters;
    this.coins = coins;
  }

  public String toString()
  {
    return ("Pseudo : " + this.nickName + "\n" +
            "Points de vie : " + this.lifePoints + "\n" +
            "Pièces de monaie : " + this.coins + "\n");
  }
}
