package levelpack;
/**
 * Classe représentant un bloc grillagé
 */
public class SquaredBlock extends Block
{

  /**
   * Constructeur de SquaredBlock
   * @method SquaredBlock
   * @param  x            abscisse
   * @param  y            ordonnée
   * @param  color        couleur du bloc grillagé
   */
  public SquaredBlock(int x, int y, int color)
  {
    super(x, y, color);
  }

  /**
   * Cette méthode permet de transformer un bloc grillagé en block simple
   * @method transform
   * @return bloc simple correspondant
   */
  @Override
  public Block transform()
  {
      return ( new Block ( this.getX(), this.getY(), this.getColor() ) );
  }

  /**
   * Cette méthode permet d'afficher un bloc grillagé
   * @method toString
   * @return la chaîne correspondante (première lettre de la couleur en majuscule)
   */
  public String toString()
  {
      return (super.toString().toUpperCase());
  }
}
