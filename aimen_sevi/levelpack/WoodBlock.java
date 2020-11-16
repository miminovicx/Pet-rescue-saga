package levelpack;
/**
* Cette classe représente un bloc de bois (imobile et impossible à supprimmer)
*/
class WoodBlock extends FieldElement
{
  /**
  * Constructeur d'un WoodBlock
  * @method WoodBlock
  * @param  x         abscisse
  * @param  y         ordonée
  */
  public WoodBlock(int x, int y)
  {
    super(x, y);
  }
  /**
  * Cette méthode permet d'afficher un WoodBlock
  * @method toString
  * @return chaîne qui sera affiché
  */
  public String toString()
  {
    return ("\\");
  }
}
