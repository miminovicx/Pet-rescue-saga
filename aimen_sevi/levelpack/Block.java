package levelpack;
/**
 * Classe représentant un bloc
 */
public class Block extends FieldElement
{
  private int color;
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
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
      case -1:
      {
        return ("A");
      }
      case 0:
      {
        return ("-");
      }
      case 1:
      {
        return (ANSI_RED + "r" + ANSI_RESET);
      }
      case 2:
      {
        return (ANSI_BLUE + "b" + ANSI_RESET);
      }
      case 3:
      {
        return (ANSI_YELLOW + "y" + ANSI_RESET);
      }
      case 4:
      {
        return (ANSI_GREEN + "g" + ANSI_RESET);
      }
      case 5:
      {
        return (ANSI_PURPLE + "p" + ANSI_RESET);
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
