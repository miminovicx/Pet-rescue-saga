package levelpack;
/**
 * Classe abstraite representant un élément du plateau
 */
public abstract class FieldElement
{
  private int x;
  private int y;
  public boolean del = false;

  public int getX()
  {
    return (this.x);
  }

  public int getY()
  {
    return (this.y);
  }
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


  public abstract String toString();

  public int getColor(){return -1;}
}
