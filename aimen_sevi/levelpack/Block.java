package levelpack;
public class Block extends FieldElement
{
  private int color;

  public int getColor()
  {
    return (this.color);
  }

  public void setColor(int color)
  {
    this.color = color;
  }

  public Block(int x, int y, int color)
  {
    super(x, y);
    this.color = color;
  }

  public String toString()
  {
    switch(this.color)
    {
      case 0:
      {
        return ("-");
      }
      case 1:
      {
        return ("r");
      }
      case 2:
      {
        return ("b");
      }
      case 3:
      {
        return ("y");
      }
      case 4:
      {
        return ("g");
      }
      case 5:
      {
        return ("p");
      }
      default:
        return ("");
    }
  }

  @Override
  public Block transform()
  {
      return ( new Block ( this.getX() , this.getY() ,0));
  }
}
