package levelpack;
/**
 * Classe abstraite representant un élément du plateau
 */
public abstract class FieldElement
{
  private int x;
  private int y;
  public boolean del = false;

  public int getX()
  {
    return (this.x);
  }

  public int getY()
  {
    return (this.y);
  }
  
  public FieldElement (int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public void setColor(int color) {};

  public Block transform(){return null;}


  public abstract String toString();

  public int getColor(){return -1;}
}
