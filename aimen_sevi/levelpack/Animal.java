package levelpack;
/**
 * Classe représentant les animaux que l'on doit sauver
 */
public class Animal extends Block
{
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

  public Block transform()
  {
      return (this);
  }
}
