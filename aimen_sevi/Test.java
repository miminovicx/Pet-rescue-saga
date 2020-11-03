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


    FieldElement element0  = new Animal(0,0,0);       //creation des elements du field
    FieldElement element1  = new Block(0,1,1);
    FieldElement element2  = new Block(0,2,2);
    // FieldElement element3  = new Block(0,3,1);
    FieldElement element4  = new Block(1,0,1);
    FieldElement element5  = new Block(1,1,2);
    FieldElement element6  = new Block(1,2,3);
    // FieldElement element7  = new Block(1,3,1);
    FieldElement element8  = new Block(2,0,4);
    FieldElement element9  = new Block(2,1,1);
    FieldElement element10 = new Block(2,2,4);
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

    // squaredString("Test remove");
    // field.remove(2,1);
    // System.out.println(field);
    // field.update();
    // System.out.println(field);

    System.out.println(field.Lost1());




    // squaredString("Test deletable ");
    // int k=1;
    // for(int i = 0 ; i< field.getWidth() ; i++)
    // {
    //
    //   for (int j = 0 ; j < field.getWidth() ;j++)
    //   {
    //     System.out.println ("bloc "+k+" "+field.deletable(i,j) );
    //     k++;
    //   }
    // }
    //
    //   squaredString("Test f");
    //   field.move(1,1,false);
    //   System.out.println(field);



    // squaredString("LevelTest");
    // int [] tab = {1000,1500,3000};
    // Level lvl = new Level(0,0,0,field,false, tab);
    // System.out.println(lvl);
    // System.out.println("-------------------------------------------------------");
    // System.out.println();

    // squaredString("Player Test");
    // Player player = new Player("Sevi", 5, 100);
    // System.out.print(player);
    // System.out.println("-------------------------------------------------------");
    // System.out.println();
    //
    // squaredString("Environment Test");
    // Environment environment = new Environment(player,tab);
    // System.out.println(environment);
    // System.out.println("-------------------------------------------------------");
    // System.out.println();


    // squaredString("Test remove");
    // field.removeElement(0,0);             //suppression de quelques blocs
    // field.removeElement(1,0);
    // field.removeElement(2,0);
    // field.removeElement(3,0);
    // field.removeElement(0,2);
    // field.removeElement(1,2);
    // field.removeElement(2,2);
    // field.removeElement(3,2);
    //field.removeElement(1,2);
    // System.out.println (field);
    // System.out.println("-------------------------------------------------------");
    //field.removeElement(3,3);
    // System.out.println (field);         //test du remove
    // System.out.println("-------------------------------------------------------");
    // System.out.println();


    // squaredString("Test update");
    // field.removeElement(0,2);
    // System.out.println (field);
    // System.out.println("-------------------------------------------------------");
    // field.update();                     //updateGeneral
    // System.out.println (field);         //affichage pour tester le update
    // System.out.println("-------------------------------------------------------");
    //
    // System.out.println();
    // squaredString("Test isEmpty");
    // System.out.println(field.isEmpty(2));
    // System.out.println("-------------------------------------------------------");
    // System.out.println();

    // squaredString("Test moveColumns");
    // field.moveColumns();
    // System.out.println(field);
//if(this)
   }
}
