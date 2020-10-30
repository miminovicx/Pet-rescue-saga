package levelpack;
public class Field
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

  public FieldElement[][] getElements()
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

  public void putElement(FieldElement element)
  {
    this.elements[element.getX()][element.getY()] = element;
  }
  public String toString()
  {
    int i = 0;
    int j = 0;
    String res = "";
     res += "*".repeat(this.width * 4) + "\n" ;

    for(i=0;i<this.width;i++)
    {
      for(j=0;j<this.height;j++)
      {
        res += this.elements[i][j].toString() + " " ;
      }
      res+="\n";
      }
      res += "*".repeat(this.width * 3) + "\n";
    return (res);
  }
}
