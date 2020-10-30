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
        return ("R");
      }
      case 2:
      {
        return ("B");
      }
      case 3:
      {
        return ("Y");
      }
      case 4:
      {
        return ("G");
      }
      case 5:
      {
        return ("P");
      }
      default:
        return ("");
    }
  }
}
