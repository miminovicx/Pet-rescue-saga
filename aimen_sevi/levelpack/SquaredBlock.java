package levelpack;
class SquaredBlock extends FieldElement
{
  private boolean locked;

  public boolean getLocked()
  {
    return (this.locked);
  }

  public void setLocked(boolean locked)
  {
    this.locked = locked;
  }

  public SquaredBlock(int x, int y, int color, boolean locked)
  {
    super(x, y, color);
    this.locked = locked;
  }

  public String toString()
  {
    if (this.locked)
      return (super.toString().toLowerCase());
    return (super.toString());
  }
}
