package levelpack;
public class SquaredBlock extends Block
{
  private boolean locked = true;

  // public boolean getLocked()
  // {
  //   return (this.locked);
  // }
  //
  // public void setLocked(boolean locked)
  // {
  //   this.locked = locked;
  // }

  public SquaredBlock(int x, int y, int color)
  {
    super(x, y, color);
  }

  @Override
  public Block transform()
  {
      return ( new Block ( this.getX(), this.getY(), this.getColor() ) );
  }

  public String toString()
  {
    // if (this.locked)
      return (super.toString().toUpperCase());
    //return (super.toString());
  }
}
