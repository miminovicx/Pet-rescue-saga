import pack.Environment;
import levelpack.FieldElement;
import pack.Player;
import levelpack.Block;
import levelpack.SquaredBlock;
import levelpack.Animal;
import levelpack.Level;
import levelpack.Field;
public class Test
{
  public static void squaredString(String str)
  {
    String line = "=";
    System.out.print("*" + line.repeat(str.length()) + "*\n");
    System.out.print("*" + str + "*\n");
    System.out.print("*" + line.repeat(str.length()) + "*\n");
  }
  public static void main(String[] args)
  {


    FieldElement element0  = new Block(0,0,1);       //creation des elements du field
    FieldElement element1  = new Block(0,1,1);
    FieldElement element2  = new SquaredBlock(0,2,2);
    // FieldElement element3  = new Block(0,3,1);
    FieldElement element4  = new SquaredBlock(1,0,1);
    FieldElement element5  = new SquaredBlock(1,1,2);
    FieldElement element6  = new SquaredBlock(1,2,3);
    // FieldElement element7  = new Block(1,3,1);
    FieldElement element8  = new SquaredBlock(2,0,4);
    FieldElement element9  = new SquaredBlock(2,1,1);
    FieldElement element10 = new SquaredBlock(2,2,4);
    // FieldElement element11 = new Block(2,3,1);
    // FieldElement element12 = new Block(3,0,1);
    // FieldElement element13 = new Block(3,1,1);
    // FieldElement element14 = new Block(3,2,1);
    // FieldElement element15 = new Block(3,3,1);


    System.out.println("-------------------------------------------------------");
    System.out.println();

    squaredString("Field Test");
    Field field = new Field(3,3);
    field.putElement(element0);             //ajout des elements au tableau
    field.putElement(element1);
    field.putElement(element2);
    // field.putElement(element3);
    field.putElement(element4);
    field.putElement(element5);
    field.putElement(element6);
    // field.putElement(element7);
    field.putElement(element8);
    field.putElement(element9);
    field.putElement(element10);
    // field.putElement(element11);
    // field.putElement(element12);
    // field.putElement(element13);
    // field.putElement(element14);
    // field.putElement(element15);
    System.out.println(field);          //test de l'affichage du field apres ajout des elements
    System.out.println("-------------------------------------------------------");
    System.out.println();

    //squaredString("Test remove");
     field.remove(0,0);
    // System.out.println(field);
    // field.update();
    // System.out.println(field);

    //System.out.println(field.Lost1());

    //field.simplifySquared(0,1);
    // field.removeElement(0,2);
    System.out.println(field);


   }
}
