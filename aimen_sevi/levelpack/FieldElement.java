package levelpack;
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
  //
  // public void setX(int x)
  // {
  //   this.x = x;
  // }
  //
  // public void setY(int y)
  // {
  //   this.y = y;
  // }
  //
  public FieldElement (int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public abstract void setColor(int color);


  public abstract Block transform();
  // {
  //   return (null);
  // }


  public abstract String toString();
  // {
  //   if(this == null)
  //     return("NA");
  //   return ("FE");
  // }

  public abstract int getColor();
}
