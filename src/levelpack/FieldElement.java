package levelpack;
/**
 * Classe abstraite representant un élément du plateau
 */
public abstract class FieldElement implements java.io.Serializable
{
  private static final long serialVersionUID = 1L;
  private int x;
  private int y;
  public boolean del = false;

  /**
   * Construit un objet de type FieldElement
   * @method FieldElement
   * @param  x            abscisse
   * @param  y            ordonée
   */
  public FieldElement (int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  /**
   * Cette méthode permet de récuperer l'abscisse d'un FieldElement
   * @return un entier (l'abscisse)
   */
  public int getX()
  {
    return (this.x);
  }

  /**
   * Cette méthode permet de récuperer la coordonnees d'un FieldElement
   * @return un entier (la coordonnee)
   */
  public int getY()
  {
    return (this.y);
  }

  /**
   * Cette méthode permet de changer la couleur d'un FieldElement
   * @method setColor
   * @param  color    la nouvelle couleur
   */
  public void setColor(int color) {};

  /**
   * Cette méthode permet transformer un FieldElement
   * @method transform
   * @return un objet de type Block
   */
  public Block transform(){return null;}

  /**
   * Méthode déstinée à afficher un FieldElement ( à redéfinir dans les sous-classes)
   * @method toString
   * @return la chaîne qui décrit l'élément
   */
  public abstract String toString();

  /**
   * Méthode permettant de connaître la couleur d'un FieldElement
   * @method getColor
   * @return [-1]
   */
  public int getColor(){return -1;}

/**
 * Cette méthode permet de connaitre l'emoji a afficher
 * @return l'emoji 2 par défaut
 */
  public int getEmoji(){return 2;}
}
