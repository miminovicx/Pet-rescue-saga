package levelpack;
/**
 * Classe représentant un bloc
 */
public class Block extends FieldElement
{
  private int color;
  /**
   * Cette méthode permet d'obtenir la couleur d'un bloc
   * @method getColor
   * @return entier entre 0 et 5 représentant une couleur
   */
  public int getColor()
  {
    return (this.color);
  }
  /**
   * Cette méthode permet de changer la couleur d'un bloc
   * @method setColor
   * @param  color    nouvelle couleur entre 0 et 5
   */
  public void setColor(int color)
  {
    this.color = color;
  }
  /**
   * Constructeur d'un bloc
   * @method Block
   * @param  x     abscisse
   * @param  y     ordonné
   * @param  color couleur
   */
  public Block(int x, int y, int color)
  {
    super(x, y);
    this.color = color;
  }
  /**
   * Cette méthode permet de produire un affichage pour un bloc
   * @method toString
   * @return la chaîne de caractères qui sera affiché quand on appélle System.out.println()
   */
  public String toString()
  {
    switch(this.color)
    {
      case 0:
      {
        return ("-");
      }
      case 1:
      {
        return ("r");
      }
      case 2:
      {
        return ("b");
      }
      case 3:
      {
        return ("y");
      }
      case 4:
      {
        return ("g");
      }
      case 5:
      {
        return ("p");
      }
      default:
        return ("");
    }
  }
  /**
   * Cette méthode permet de supprimmer un bloc
   * @method transform
   * @return une case vide
   */
  @Override
  public Block transform()
  {
      return ( new Block ( this.getX() , this.getY() ,0));
  }
}
