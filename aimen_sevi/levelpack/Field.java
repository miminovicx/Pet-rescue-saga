package levelpack;
import java.util.LinkedList;
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

  public void swapColumn(int a, int b)
  {
    int temp;
    for(int i = 0 ; i<width ; i++)                 //parcours chaque ligne
    {
      temp = this.elements[i][a].getColor();
      this.elements[i][a].setColor(this.elements[i][b].getColor());
      this.elements[i][b].setColor(temp);
    }
  }

  public void moveColumns()
  {
    for (int k = 0 ; k < height ; k++ )
    {
      for(int j = 0 ; j < width - 1 ; j++)           //doit parcourir chaque colonne
      {
        if(this.isEmpty(j))                          //si la colonne est vide on la decale a droite
        {
          swapColumn(j,j+1);
        }
      }
    }
  }

  public boolean deletable(int x , int y)
  {
    if ( this.elements[x][y] instanceof SquaredBlock || this.elements[x][y].getColor() == 0) //SquaredBlock
    {
      return false;
    }
          //SimpleBlock

      if( x + 1 < width)   //les conditions sont ici pour ne pas sortir des limites du tableau
      {
        if( this.elements[x][y].getColor() == this.elements[x + 1][y].getColor() )
        {
          return true;
        }
      }
      if(x - 1 >= 0)
      {
        if( this.elements[x][y].getColor() == this.elements[x - 1][y].getColor() )
        {
          return true;
        }
      }
      if(y + 1 < width)
      {
        if( this.elements[x][y].getColor() == this.elements[x][y + 1].getColor() )
        {
          return true;
        }
      }
      if(y - 1 >= 0)
      {
        if( this.elements[x][y].getColor() == this.elements[x][y - 1].getColor() )
        {
          return true;
        }
      }
      return false;
  }


  // public LinkedList elementsToRemove (int x , int y)
  // {
  //   LinkedList <FieldElement> list = new LinkedList();
  //   int up = x + 1 ;
  //   int down = x - 1 ;
  //   int right = y + 1 ;
  //   int left = y - 1 ;
  //   if(up < width)   //les conditions sont ici pour ne pas sortir des limites du tableau
  //   {
  //     if( this.elements[x][y].getColor() == this.elements[up][y].getColor() )
  //     {
  //       list.add(this.elements[up][y]);
  //   }
  //   if(down >= 0)
  //   {
  //     if( this.elements[x][y].getColor() == this.elements[down][y].getColor() )
  //     {
  //       list.add(this.elements[down][y]);
  //       elementsToRemove(down,y);
  //     }
  //   }
  //   if(right < width)
  //   {
  //     if( this.elements[x][y].getColor() == this.elements[x][right].getColor() )
  //     {
  //       list.add(this.elements[x][right]);
  //       elementsToRemove(x,right);
  //     }
  //   }
  //   if(left >= 0)
  //   {
  //     if( this.elements[x][y].getColor() == this.elements[x][left].getColor() )
  //     {
  //       list.add(this.elements[x][left]);
  //       elementsToRemove(x,left);
  //     }
  //   }
  // return list;
  // }



  // }
  // public void move(int x , int y)
  // {
  //   // LinkedList removebleElements <FieldElement> = new LinkedList();
  //   if( !deletable(x,y) )
  //   {
  //     return;
  //   }
  //   else
  //   {
  //       removeElement(x,y);
  //       move(x + 1 , y);      //appel en haut
  //       move(x - 1 , y);      //appel en bas
  //       move(x , y + 1);      //appel a droite
  //       move(x , y - 1);      //appel a gauche
  //
  //   }
  // }

  public void move(int x, int y,boolean delete)
  {
    if(!delete)
    {
      return;
    }
    else
    {
      int col = this.elements[x][y].getColor();
      removeElement(x,y);
      if( (x+1 < width) && (col == this.elements[x+1][y].getColor()) )
      {
        move(x+1,y,true);
      }
      if( (x-1 >= 0) && (col == this.elements[x-1][y].getColor()) )
      {
          move(x-1,y,true);
      }
      if( (y+1 < width) && (col == this.elements[x][y+1].getColor()) )
      {
        move(x,y+1,true);
      }
      if( (y-1 >= 0) && (col == this.elements[x][y-1].getColor()) )
      {
        move(x,y-1,true);
      }

    }
  }

  public void remove(int x, int y)
  {
    if(this.deletable(x,y))
    {
      move(x,y,true);
    }

    move(x,y,false);

  }

  public boolean Lost1()     //end of game because there's no delete possible
  {
    boolean possible = false;
    int i = 0;
    int j = 0;
    while(!possible && i < width)
    {
      while(!possible && j < width)
      {
        possible = this.deletable(i,j);
      }
    }
    return possible;
  }
}
