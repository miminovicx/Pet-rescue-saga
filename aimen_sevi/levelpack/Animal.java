package levelpack;
/**
 * Classe représentant les animaux que l'on doit sauver
 */
public class Animal extends Block
{
  // private int a;
  public static final String bearEmoji = "\uD83D\uDC3B";
  public Animal(int x, int y)
  {
    super(x, y, -1);
    // this.a = 1 + (int)Math.random()*(1);
  }

  /**
   * Cette méthode supprime un animal
   * @method removeAnimal
   * @param  x            abscisse
   * @param  y            ordonné
   * @return              block représentant la case vide
   */
  public Block removeAnimal(int x,int y)
  {
    return ( new Block (x,y,0));
  }

  public Block transform()
  {
      return (this);
  }

  // public String toString()
  // {
    // if(this.a == 1)
    // {
    //   return(this.bearEmoji);
    // }
    // else if(this.a == 2)
    // {
    //   return(" A ");
    // }
    // return("");
  // }
}
