package levelpack;
/**
 * Cette classe représente un block bonus c'est à dire un bloc qui multiplie par deux le score lorsque il est supprimé
 */
class BonusBlock extends Block
{
  boolean twoTimes;
  /**
   * Constructeur d'un BonusBlock
   * @method BonusBlock
   * @param  x          abscisse
   * @param  y          ordonée
   * @param  color      couleur entre 0 et 5
   */
  public BonusBlock(int x, int y, int color)
  {
    super(x, y,color);
    this.twoTimes = true;
  }
  /**
   * Cette méthode permet d'afficher un BonusBlock
   * @method toString
   * @return chaîne qui sera affiché
   */
  public String toString()
  {
    return (super.toString() + "x2");
  }
}
