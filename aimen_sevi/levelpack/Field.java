package aimen_sevi.levelpack;
public class Field extends Level
{
  private int width;
  private int height;
  private FieldElement [][] elements;


  public int getWidth()
  {
    return (this.width);
  }

  public int getHeight()
  {
    return (this.height);
  }

  public FieldElement getElements()
  {
    return (this.elements);
  }

  public void setWidth(int width)
  {
    this.width = width;
  }

  public void setHeight(int height)
  {
    this.height = height;
  }

  public void setElements(FieldElement [][]elements)
  {
    this.elements = elements;
  }

  public Field(int width, int height)
  {
    this.width = width;
    this.height = height;
    this.elements = new FieldElement[width][height];
  }

  public String toString()
  {
    int i = 0;
    int j = 0;
    String res = "";
    while (i < this.width)
    {
      while (j < this.height)
      {
        res += this.elements[i][j].toString() + ' ';
      }
      res += "\n";
    }
  }
}
