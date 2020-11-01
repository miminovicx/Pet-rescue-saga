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

  public void removeElement(int x, int y)
  {
    this.elements[x][y] = this.elements[x][y].transform();
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

  public void swap(int x, int y, int x1, int y1)
  {
    FieldElement tmp = this.elements[x][y];
    this.elements[x][y] = this.elements[x1][y1];
    this.elements[x1][y1] = tmp;
  }

  public void getDown(int x, int y)
  {
    if (x + 1 < this.height)
    this.swap(x,y,x + 1,y);
  }

  // public void update ()
  // {
  //   int j = 0;
  //   while(this.elements[this.height-1][j].getColor()==0)
  //   {
  //   for(int i = this.height - 1; i > 0; i--)
  //   {
  //     j = i-1;
  //     if(this.elements[i][0] instanceof Block)
  //     {
  //       if(this.elements[i][0].getColor() == 0)
  //       {
  //         this.swap(i, 0, i - 1, 0);
  //       }
  //     }
  //   }
  //   j--;
  // }
  //   }
  // public void updateColumn (int a,int b,int k)
  // {
  //   int i = a;
  //
  //   while (this.elements[i][k].getColor() != 0 && i != b)
  //   // for (int i = 0 ; i < this.height - 1 ; i++)
  //   // {
  //   //   if(this.elements[i][0] instanceof Block)
  //   //   {
  //   //     if(this.elements[i + 1][0].getColor() == 0)
  //   //     {
  //   //       this.getDown(i,0);
  //   //     }
  //   // }
  //   i++;
  //   if(i != this.width)
  //   {
  //     for (int j = i - 1 ; j >= 0; j--)
  //     {
  //       this.getDown(j,k);
  //     }
  //   }
  //
  // }
  //
  // public void updateColumn2 (int k)
  // {
  //   // a=0;
  //   // b=this.width-1;
  //   int i=0;
  //   for(int s=3;s>=0;s--)
  //   {
  //   this.updateColumn(i,s,k);
  //   i++;
  //   }
  // }
  // public void update()
  // {
  //   for(int i=0 ; i< this.width ; i++)
  //   {
  //     this.updateColumn2(i);
  //   }
  // }
  public void update()
  {
    for (int k = 0 ; k < height ; k ++)
    {
      for(int j = height - 1 ;j > 0; j--)
      {
        for (int i = 0 ; i < width; i++)
        {
          if(this.elements[j][i].getColor() == 0)
          {
            this.getDown(j - 1, i);
          }
        }
      }
    }

    this.moveColumns();
  }

  public boolean isEmpty(int k)
  {
      if(this.elements[width - 1][k].getColor() == 0) //si le dernier element de la colonne est vide apres update
      {
        return true;                                //donc toute la colonne est vide
      }
      else
      {
        return false;                               //sinon il y a un element au moins donc n'est pas vide
      }
  }

  public void swipeColumn(int a, int b)
  {
    int temp;
    for(int i = 0 ; i<width ; i++) //parcours chaque ligne
    {
      temp = this.elements[i][a].getColor();
      this.elements[i][a].setColor(this.elements[i][b].getColor());
      this.elements[i][b].setColor(temp);
    }
  }

  public void moveColumns()
  {
    for(int j = 0 ; j < width - 1 ; j++) //doit parcourir chaque colonne
    {
      if(this.isEmpty(j))                //si la colonne est vide on la decale a droite
      {
        swipeColumn(j,j+1);
      }
    }
  }
}
