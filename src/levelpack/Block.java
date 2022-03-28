package levelpack;
/**
 * Classe représentant un bloc
 */
public class Block extends FieldElement
{
  private int color;
  private int emoji;
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String bearEmoji = "\uD83D\uDC3B";
  public static final String rabbitEmoji = "\uD83D\uDC30";
  public static final String koalaEmoji = "\uD83D\uDC28";
  public static final String pandaEmoji = "\uD83D\uDC3C";
  public static final String babyChickEmoji = "\uD83D\uDC25";
  /**
   * Cette méthode permet d'obtenir la couleur d'un bloc
   * @method getColor
   * @return entier représentant la couleur
   */
  public int getColor()
  {
    return (this.color);
  }
  /**
   * Cette méthode permet de changer la couleur d'un bloc
   * @method setColor
   * @param  color    nouvelle couleur
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
    if(this instanceof Animal)
    {
      emoji = (int)(1 + (Math.random()*5));
    }
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
      case -2:
      {
        return("\u274C"); //croix qui indique que c'est un element immobile
      }
      case -1:
      {
        if(this.emoji == 1)
        {
          return(this.bearEmoji);
        }
        else if(this.emoji == 2)
        {
          return(this.rabbitEmoji);
        }
        else if(this.emoji == 3)
        {
          return(this.koalaEmoji);
        }
        else if(this.emoji == 4)
        {
          return(this.pandaEmoji);
        }
        else if(this.emoji == 5)
        {
          return(this.babyChickEmoji);
        }
        return(this.babyChickEmoji);
      }
      case 0:
      {
        return (" -");
      }
      case 1:
      {
        return ("\uD83D\uDFE5");
      }
      case 2:
      {
        return("\uD83D\uDFE6");
      }
      case 3:
      {
        return("\uD83D\uDFE8");
      }
      case 4:
      {
        return("\uD83D\uDFE9");
      }
      case 5:
      {
        return("\uD83D\uDFEA");
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

  /**
   * Cette méthode permet de récuperer l'emoji ou l'image à afficher
   * @return un eniter représentant l'emoji
   */
  public int getEmoji()
  {
    return this.emoji;
  }
}
