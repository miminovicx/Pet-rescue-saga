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
  private static final long serialVersionUID = 1L;
  private int width;
  private int height;
  private FieldElement [][] elements;
  public static int nbBlockSuppr;
  public static int animalsSaved = 0;
  private int intervalle = 3;  //represente le nombre de lignes a afficher

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
  *@return l'ensemble des elements sous forme de tableau
  */
  public FieldElement[][] getElements()
  {
    return (this.elements);
  }

  /**
   * Méthode pour obtenir la valeur de l'intervalle
   * @return la valeur de l'intervalle
   */
  public int getIntervalle()
  {
    return this.intervalle;
  }
  /**
   * Met à jour la longueur du plateau
   * @method setWidth
   * @param  width    nouvelle largeur
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
   * @param  [][]elements nouveau tableau
   */
  public void setElements(FieldElement [][]elements)
  {
    this.elements = elements;
  }
  /**
   * Constructeur du plateau
   * @method Field
   * @param  width  hauteur
   * @param  height largeur
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
   * Enlève un élément du plateau
   * @method removeElement
   * @param  x             abscisse de l'élément a enlever
   * @param  y             ordonnée de l'élément a enlever
   */
  public void removeElement(int x, int y)
  {
    if(this.elements[x][y].getColor()!= -1 && this.elements[x][y].getColor() != -2)
    this.elements[x][y] = this.elements[x][y].transform();
  }


  /**
   * Cette méthode permet d'échanger deux éléments
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
    if (x + 1 < this.width) //c'etait height
    this.swap(x,y,x + 1,y);
  }
  /**
   * Cette méthode permet de mettre à jour le plateau en faisant descendre les element qui ont des cases vides endesous
   * @method update
   */
  public void update()
  {
    for (int k = 0 ; k < width ; k ++) //etait height
    {
      for(int j = width - 1 ;j > 0; j--) //etait height
      {
        for (int i = 0 ; i < height; i++) //etait width
        {
          if(this.elements[j-1][i].getColor () != -2 && this.elements[j][i].getColor() == 0)  //Changé
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
   * @method columnIsEmpty
   * @param  k       coordonnees de la colonne
   * @return         vrai si la colonne est vide
   */
  public boolean columnIsEmpty(int k)
  {
      // if(this.elements[width - 1][k].getColor() == 0) //si le dernier element de la colonne est vide apres update
      // {
      //   return true;                                //donc toute la colonne est vide
      // }
      // else
      // {
      //   return false;                               //sinon il y a un element au moins donc n'est pas vide
      // }
      for(int i=0; i < this.width; i++)
      {
        if(this.elements[i][k].getColor() != 0 || this.elements[i][k].getColor() != -2)
        {
          return false;
        }
      }
      return true;
  }
  /**
   * Cette methode permet d'échanger deux colonnes
   * @method swapColumn
   * @param  a          coordonné de la première colonne
   * @param  b          coordonné de la deuxieme colonne
   */
  public void swapColumn(int a, int b)
  {
    int temp;
    for(int i = 0 ; i < width ; i++)                 //parcours chaque ligne
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
        if(this.columnIsEmpty(j))                          //si la colonne est vide on la decale a droite
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
    if (this.elements[x][y].getColor() == -2 || this.elements[x][y] instanceof SquaredBlock || this.elements[x][y].getColor() == 0) //WoodBlock or SquaredBlock or empty
    {
      return false;
    }
          //SimpleBlock

      if( x + 1 < (this.firstLineToDisplay() + this.intervalle))   //les conditions sont ici pour ne pas sortir des limites du tableau
      {
        if( this.elements[x][y].getColor() == this.elements[x + 1][y].getColor() )
        {
          return true;
        }
      }
      if(x - 1 >= this.firstLineToDisplay())
      {
        if( this.elements[x][y].getColor() == this.elements[x - 1][y].getColor() )
        {
          return true;
        }
      }
      if(y + 1 < height) //width
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

  /**
   * Cette methode permet de supprimer un ensemble de blocs
   * @param x      [abscisse du bloc choisi]
   * @param y      [ordonnée du bloc choisi]
   * @param delete [boolean pour l'appel recursif]
   */
  public void move(int x, int y,boolean delete)
  {
    if(!delete)
    {
      return;
    }
    else
    {
      if(this.elements[x][y].getColor() == -1 || this.elements[x][y].getColor() == -2 || this.elements[x][y] instanceof SquaredBlock) //a defaut d'avoir une classe SimpleBlock
      {
        return;
      }
      else
      {
        int col = this.elements[x][y].getColor();
        removeElement(x,y);
        nbBlockSuppr++;
        if( (x+1 < (this.firstLineToDisplay() + this.intervalle) ) && (col == this.elements[x+1][y].getColor()) )
        {
          move(x+1,y,true);
        }
        if( (x-1 >= this.firstLineToDisplay() ) && (col == this.elements[x-1][y].getColor()) )
        {
            move(x-1,y,true);
        }
        if( (y+1 < height) && (col == this.elements[x][y+1].getColor()) )
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

  /**
   * Cette methode permet de supprimer les elements s'ils sont supprimables
   * @param x [abscisse]
   * @param y [ordonnée]
   */
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
   * Cette méthode permet de transformer les blocs grillagés en blocs simples
   * @method simplifySquared
   * @param  x               [abscisse]
   * @param  y               [ordonnée]
   */
  public void simplifySquared(int x,int y)
  {
    if( (x+1 < (this.firstLineToDisplay() + this.intervalle)) && (this.elements[x+1][y] instanceof SquaredBlock ))
    {
      this.removeElement(x+1,y);
    }
    if( (x-1 >= this.firstLineToDisplay() ) && (this.elements[x-1][y] instanceof SquaredBlock))
    {
      this.removeElement(x-1,y);
    }
    if( (y+1 < height) && (this.elements[x][y+1] instanceof SquaredBlock))
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
   * @param  x           [abscisse]
   * @param  y           [ordonnée]
   */
  public boolean updateFinal(int x, int y)
  {
    this.remove(x,y);
    this.update();
    this.moveColumns();
    return this.saveAnimal();
  }

  /**
   * Cette methode permet de mettre a jour le plateau sans supprimer de block
   * A utiliser après les boosters par exemple
   */
  public void updateSemiFinal()
  {
    this.update();
    this.moveColumns();
    this.saveAnimal();
  }
  /**
   * Cette méthode enlève les animaux de la dernière ligne et les ajoute au nombre d'animaux sauvés
   * @method saveAnimal
   */
  public boolean saveAnimal()
  {
    for(int j=0; j < height ; j++)
    {
      if(this.elements[width - 1][j].getColor() == -1)
      {
        // removeAnimal(width - 1,j);
        System.out.println(this);
        this.elements[width-1][j] = new Block(width-1,j,0);
        animalsSaved ++;
        // System.out.println("\tANIMAL SAUVE ! \n");
        return true;
      }
    }
    return false;
  }
  /**
   * Cette méthode permet de calculer le score à partir du nombre de blocs supprimmés
   * @method scoreComputation
   * @param  deletedBlocks    le nombre de blocs supprimés
   * @return                  le nombre de points gagnés
   */
  public int scoreComputation(int deletedBlocks)
  {
    return (10 * (int)Math.pow(deletedBlocks,2));
  }

  /**
   * Méthode qui affiche un plateau
   * @method toString
   * @return la chaîne affiché
   */
  public String toString()
  {
    String res = "  ";
    for(int i = 0; i < this.height; i++)
    {
      res += "  " + String.valueOf(i);
    }
    res += "\n" ;
    int min = this.firstLineToDisplay();
    for(int i = min; i < (min + this.intervalle);i++)
    {
        res += " " + String.valueOf(i) + " ";
        for(int j=0; j<this.height ; j++)
        {
          res += this.elements[i][j].toString() + " " ;
        }
        res+="\n";
      }
      return res;

  }

  /**
   * Cette methode teste si la ligne entrée en parametre est vide
   * @param  a  la ligne a verifier
   * @return   true si la ligne est vide
   */
  public boolean lineIsEmpty(int a)
  {
    for(int i=0; i < this.height; i++)
    {
      if(this.elements[a][i].getColor() != 0 || this.elements[a][i].getColor() != -2)
      {
        return false;
      }
    }
    return true;
  }

  /**
   * Cette methode permet de savoir quelle est la premiere ligne a afficher
   * @return la ligne a afficher en premier
   */
  public int firstLineToDisplay()
  {
    int i = 0;
    boolean empty = true;
    while(i < this.width - intervalle && this.lineIsEmpty(i))
    {
      i++;
    }
    return i;
  }

  public void useRocket(int a)
  {
    for(int i = this.firstLineToDisplay() ; i < (this.firstLineToDisplay() + this.intervalle) ; i ++)
    {
      removeElement(i,a);
    }
  }

  public void useBoomerang(int a)
  {
    for(int i = 0 ; i < this.height ; i ++)
    {
      removeElement(a,i);
    }
  }

  public void usePickaxe(int a, int b)
  {
    removeElement(a,b);
  }

  public void useBallon(int a, int b)
  {
    int color = this.elements[a][b].getColor();
    for(int i = this.firstLineToDisplay() ; i < (this.firstLineToDisplay() + this.intervalle) ; i ++)
    {
      for(int j = 0 ; j < this.height ; j ++)
      {
        if(this.elements[i][j].getColor() == color)
        {
          removeElement(i,j);
        }
      }
    }
  }
}
