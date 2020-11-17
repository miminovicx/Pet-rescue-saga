package levelpack;
import java.util.LinkedList;
import levelpack.Level;
import levelpack.Animal;
import java.lang.Math;
/**
 * Classe représentant le plateau de jeu
 */
public class Field implements java.io.Serializable
{
  //private static final long serialVersionUID = 51335434354l;
  private int width;
  private int height;
  private FieldElement [][] elements;
  public static int nbBlockSuppr; //=0
  public static int animalsSaved = 0;
/**
*Méthode pour obtenir la largeur du plateau
*@return la largeur du plateau
*/
  public int getWidth()
  {
    return (this.width);
  }
  /**
  *Méthode pour obtenir la hauteur du plateau
  *@return la hauteur du plateau
  */
  public int getHeight()
  {
    return (this.height);
  }
  /**
  *Méthode pour obtenir le tableau des éléments du plateau
  *@return la hauteur du plateau
  */
  public FieldElement[][] getElements()
  {
    return (this.elements);
  }
  /**
  *Méthode pour obtenir le tableau des éléments du plateau
  *@param width hauteur du plateau
  */
  public void setWidth(int width)
  {
    this.width = width;
  }
/**
 * Met à jour la hauteur du plateau
 * @method setHeight
 * @param  height    nouvelle hauteur
 */
  public void setHeight(int height)
  {
    this.height = height;
  }

  /**
   * Met à jour le tableau des éléments
   * @method setElements
   * @param  [][]elements [description]
   */
  public void setElements(FieldElement [][]elements)
  {
    this.elements = elements;
  }
  /**
   * Constructeur du plateau
   * @method Field
   * @param  width  largeur
   * @param  height hauteur
   */
  public Field(int width, int height)
  {
    this.width = width;
    this.height = height;
    this.elements = new FieldElement[width][height];
  }
  /**
   * Ajoute un élément au plateau
   * @method putElement
   * @param  element    élément qui doit être ajouté
   */
  public void putElement(FieldElement element)
  {
    this.elements[element.getX()][element.getY()] = element;
  }
  /**
   * Enlève un élément au plateau
   * @method removeElement
   * @param  x             abscisse de l'élément a enlever
   * @param  y             ordonnée de l'élément a enlever
   */
  public void removeElement(int x, int y)
  {
    this.elements[x][y] = this.elements[x][y].transform();
  }
  /**
   * Méthode qui affiche un plateau
   * @method toString
   * @return la chaîne affiché
   */
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
  /**
   * Cette méthode permet d'échanger deux élément
   * @method swap
   * @param  x    abscisse du premier élément
   * @param  y    ordonnée du premier élément
   * @param  x1   abscisse du deuxième élément
   * @param  y1   ordonnée du deuxième élément
   */
  public void swap(int x, int y, int x1, int y1)
  {
    FieldElement tmp = this.elements[x][y];
    this.elements[x][y] = this.elements[x1][y1];
    this.elements[x1][y1] = tmp;
  }
/**
 * Cette méthode permet de faire descendre l'élément dont les coordonnees sont données en parametres
 * @method getDown
 * @param  x       abscisse de l'élément
 * @param  y       ordonnée de l'élément
 */
  public void getDown(int x, int y)
  {
    if (x + 1 < this.height)
    this.swap(x,y,x + 1,y);
  }
  /**
   * Cette méthode permet de mettre à jour le plateau en faisant descendre les element qui ont des cases vides endesous
   * @method update
   */
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
  /**
   * Cette méthode permet savoir si une colonne est vide
   * @method isEmpty
   * @param  k       coordonnees de la colonne
   * @return         vrai si la colonne est vide
   */
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
  /**
   * Cette methode permet d'échanger deux colonnes
   * @method swapColumn
   * @param  a          coordonné de la première colonne
   * @param  b          coordonné de la première colonne
   */
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
  /**
   * Cette méthode décale toutes les colonne vides vers la gauche
   * @method moveColumns
   */
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
  /**
   * Cette méthode permet de savoir si un element peut être supprié
   * @method deletable
   * @param  x         abscisse de l'élément à tester
   * @param  y         ordonnée de l'élément à tester
   * @return           vrai si l'élément peut être supprimé (i.e si au moins un des éléments voisins est de la même couleur)
   */
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


  public void move(int x, int y,boolean delete)
  {
    if(!delete)
    {
      return;
    }
    else
    {
      if(this.elements[x][y] instanceof SquaredBlock) //a defaut d'avoir une classe SimpleBlock
      {
        return;
      }
      else
      {
        int col = this.elements[x][y].getColor();
        removeElement(x,y);
        nbBlockSuppr++;
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
        simplifySquared(x,y);
      }
    }
  }

  public void remove(int x, int y)
  {
    nbBlockSuppr = 0;
    if(this.deletable(x,y))
    {
      move(x,y,true);
    }

    move(x,y,false);

  }
  /**
   * Cette méthode permet de savoir si on a perdu
   * @method Lost1
   * @return vrai si il n'y a plus d'élément que l'on peut supprimé
   */
  // public boolean Lost1()     //end of game because there's no delete possible
  // {
  //   boolean found = false;
  //   for(int i = 0; i<width && found!=true;i++)
  //   {
  //     for(int j = 0; j<width && found!=true;j++)
  //     {
  //       if(this.deletable(i,j) == true)
  //           {
  //           found = true; //il y a une combinaison possible
  //           }
  //     }
  //   }
  //   return !found;
  // }
  /**
   * Cette méthode permet de transformer les blocks grillagés en blocks simples
   * @method simplifySquared
   * @param  x               [description]
   * @param  y               [description]
   */
  public void simplifySquared(int x,int y)
  {
    if( (x+1 < width) && (this.elements[x+1][y] instanceof SquaredBlock ))
    {
      this.removeElement(x+1,y);
    }
    if( (x-1 >= 0) && (this.elements[x-1][y] instanceof SquaredBlock))
    {
      this.removeElement(x-1,y);
    }
    if( (y+1 < width) && (this.elements[x][y+1] instanceof SquaredBlock))
    {
      this.removeElement(x,y+1);
    }
    if( (y-1 >= 0) && (this.elements[x][y-1] instanceof SquaredBlock))
    {
      this.removeElement(x,y-1);
    }
  }
  /**
   * Cette méthode permet de mettre à jour le plateau
   * @method updateFinal
   * @param  x           [description]
   * @param  y           [description]
   */
  public void updateFinal(int x, int y)
  {
    this.remove(x,y);
    this.update();
    this.moveColumns();
    this.saveAnimal();
  }
  /**
   * Cette méthode enlève les animaux de la dernière ligne et les ajoute au nombre d'animaux sauvés
   * @method saveAnimal
   */
  public void saveAnimal()
  {
    for(int j=0; j < width ; j++)
    {
      if(this.elements[width - 1][j].getColor() == -1)
      {
        // removeAnimal(width - 1,j);
        this.elements[width-1][j] = new Block(width-1,j,0);
        animalsSaved ++;
      }
    }
  }
  /**
   * Cette méthode permet de calculer le score à partir du nombre de blocks supprimmés
   * @method scoreComputation
   * @param  deletedBlocks    le nombre de blocks supprimés
   * @return                  le nombre de points gagnés
   */
  public int scoreComputation(int deletedBlocks)
  {
    return (10 * (int)Math.pow(deletedBlocks,2));
  }
}
