package levelpack;
public class Animal extends FieldElement
{
  public Animal(int x, int y)
  {
    super(x, y);
  }

  public String toString()
  {
      return ("A*");
  }

  public Block removeAnimal(int x,int y)
  {
    return ( new Block (x,y,0));
  }
}
