package levelpack;
/**
 * Classe représentant les animaux que l'on doit sauver
 */
public class Animal extends Block
{
  public static final String bearEmoji = "\uD83D\uDC3B";
  /**
   * Cette méthode permet de construire un animal
   * @param x abscisse
   * @param y ordonné
   */
  public Animal(int x, int y)
  {
    super(x, y, -1);
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

  /**
   * Cette méthode permet de transformer un animal
   * @return lui même car un animal ne peut pas etre transformé
   */
  public Block transform()
  {
      return (this);
  }

}
