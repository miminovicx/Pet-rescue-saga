import pack.Environment;
import pack.Launcher;
import levelpack.FieldElement;
import pack.Player;
import levelpack.Block;
import levelpack.SquaredBlock;
import levelpack.WoodBlock;
import levelpack.Animal;
import levelpack.Level;
import levelpack.Field;
import java.util.TimerTask;
import java.util.Timer;
import gui.*;

public class LevelGenerator
{
  public static void main(String[] args)
  {
    FieldElement element0  = new Animal(0,0);       //creation des elements du field
    FieldElement element1  = new Block(0,1,1);
    FieldElement element2  = new Block(0,2,1);
    FieldElement element3  = new Block(1,0,2);
    FieldElement element4  = new WoodBlock(1,1);
    FieldElement element5  = new Block(1,2,3);
    FieldElement element6  = new Block(2,0,2);
    FieldElement element7  = new Block(2,1,2);
    FieldElement element8 = new Block(2,2,-2);
    Field field1 = new Field(3,3);
    field1.putElement(element0);             //ajout des elements au tableau
    field1.putElement(element1);
    field1.putElement(element2);
    field1.putElement(element3);
    field1.putElement(element4);
    field1.putElement(element5);
    field1.putElement(element6);
    field1.putElement(element7);
    field1.putElement(element8);
    int[] paliers = {0,300,400};

    FieldElement elementa  = new Block(0,0,-2);       //creation des elements du field
    FieldElement elementb  = new Block(0,1,2);
    FieldElement elementc  = new Animal(0,2);
    FieldElement elementd  = new Block(1,0,2);
    FieldElement elemente  = new Block(1,1,2);
    FieldElement elementf  = new Block(1,2,2);
    FieldElement elementg  = new Block(2,0,2);
    FieldElement elementh  = new Block(2,1,2);
    FieldElement elementi  = new Block(2,2,2);

    Field field2 = new Field(3,3);
    field2.putElement(elementa);             //ajout des elements au tableau
    field2.putElement(elementb);
    field2.putElement(elementc);
    field2.putElement(elementd);
    field2.putElement(elemente);
    field2.putElement(elementf);
    field2.putElement(elementg);
    field2.putElement(elementh);
    field2.putElement(elementi);

     Level level1 = new Level(0, field1, paliers, 1);
    level1.save();

    Level level2 = new Level(0, field2, paliers, 1);
    level2.save();
  }
}