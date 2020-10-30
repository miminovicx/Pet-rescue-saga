import pack.Environment;
import levelpack.FieldElement;
import pack.Player;
import levelpack.Block;
import levelpack.SquaredBlock;
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

    //squaredString("FieldElement Test");
    FieldElement element0 = new Block(0,0,1);
    FieldElement element1 = new Block(0,1,2);
    FieldElement element2 = new Block(0,2,2);
    FieldElement element3 = new Block(1,0,3);
    FieldElement element4 = new Block(1,1,5);
    FieldElement element5 = new Block(1,2,5);
    FieldElement element6 = new Block(2,0,4);
    FieldElement element7 = new SquaredBlock(2,1,4,true);
    FieldElement element8 = new SquaredBlock(2,2,2,true);
    // System.out.println(element);
    System.out.println("-------------------------------------------------------");
    // System.out.println();

    squaredString("Field Test");
    Field field = new Field(3,3);
    field.putElement(element0);
    field.putElement(element1);
    field.putElement(element2);
    field.putElement(element3);
    field.putElement(element4);
    field.putElement(element5);
    field.putElement(element6);
    field.putElement(element7);
    field.putElement(element8);

    System.out.println(field);
    System.out.println("-------------------------------------------------------");
    System.out.println();

    squaredString("LevelTest");
    int [] tab = {1000,1500,3000};
    Level lvl = new Level(0,0,0,field,false, tab);
    System.out.println(lvl);
    System.out.println("-------------------------------------------------------");
    System.out.println();

    squaredString("Player Test");
    Player player = new Player("Sevi", 5, 100);
    System.out.print(player);
    System.out.println("-------------------------------------------------------");
    System.out.println();

    squaredString("Environment Test");
    Environment environment = new Environment(player,tab);
    System.out.println(environment);
    System.out.println("-------------------------------------------------------");
    System.out.println();
   }
}
