import levelpack.*;
import levelpack.FieldElement;
import pack.Player;
// import levelpack.Level;
// import levelpack.Field;
// import levelpack.FieldElements;
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

    squaredString("FieldElement Test");
    FieldElement element = new FieldElement(0,0);
    FieldElement element1 = new FieldElement(0,1);
    // FieldElement element2 = new FieldElement(1,0);
    // FieldElement element3 = new FieldElement(1,1);
    System.out.println(element);
    System.out.println("-------------------------------------------------------");
    System.out.println();

    squaredString("Field Test");
    Field field = new Field(2,2);
    field.putElement(element);
    field.putElement(element1);
    //field.putElement(element2);
    //field.putElement(element3);
    System.out.print(field);
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
  }
}
