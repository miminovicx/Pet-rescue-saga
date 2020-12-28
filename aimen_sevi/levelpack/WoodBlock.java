package levelpack;
/**
* Cette classe représente un bloc de bois (immobile et impossible à supprimmer)
*/
public class WoodBlock extends Block
{
  /**
  * Constructeur d'un WoodBlock
  * @method WoodBlock
  * @param  x         abscisse
  * @param  y         ordonée
  */
  public WoodBlock(int x, int y)
  {
    super(x, y, -2);
  }


  public Block transform()
  {
      return (this);
  }
}
