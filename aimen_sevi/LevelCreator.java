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

public class LevelCreator
{
  // public static Level createLevel()
  // {
  //   Scanner sc = new Scanner(System.in);
  //   System.out.print("Veuiilez donner la largeur du plateau : ");
  //   int width = sc.nextInt();
  //   System.out.print("Veuiilez donner la longueur du plateau : ");
  //   int height = sc.nextInt();
  //   Field field = new Field(width, height);
  //   for(int i = 0; i < width;i++)
  //   {
  //     for(int j = 0 ; j < height; j++)
  //     {
  //       System.out.println("1 - Block");
  //       System.out.println("2 - Obstacle");
  //       System.out.println("3 - Animal");
  //       System.out.println("4 - Block Cadrillé");
  //       int ans = sc.nextInt();
  //       switch(ans)
  //       {
  //         case 1:
  //         int color = sc.nextInt();
  //         Block block = new Block(i,j,color);
  //         field.putElement(i,j)
  //           break;
  //         case 2:
  //           break;
  //         case 3:
  //           break;
  //         case 4:
  //           break;
  //       }
  //     }
  //   }
  //
  // }
  public static void main(String[] args)
  {
    Field field1 = new Field(8,8,5);

    FieldElement element0  = new Animal(0,0);       //creation des elements du field
    FieldElement element1  = new Block(0,1,1);
    FieldElement element2  = new Animal(0,2);
    FieldElement element3  = new Block(0,3,2);
    FieldElement element4  = new Animal(0,4);
    FieldElement element5  = new Block(0,5,3);
    FieldElement element6  = new Animal(0,6);
    FieldElement element7  = new Animal(0,7);
    FieldElement element8  = new Block(1,0,2);
    FieldElement element9  = new Block(1,1,3);
    FieldElement element10 = new Block(1,2,2);
    FieldElement element11 = new Block(1,3,2);
    FieldElement element12 = new Block(1,4,2);
    FieldElement element13 = new Block(1,5,2);
    FieldElement element14 = new Block(1,6,2);
    FieldElement element15 = new Block(1,7,2);
    FieldElement element16 = new Block(2,0,2);
    FieldElement element17 = new Block(2,1,2);
    FieldElement element18 = new Block(2,2,2);
    FieldElement element19 = new Block(2,3,2);
    FieldElement element20 = new Block(2,4,2);
    FieldElement element21 = new Block(2,5,2);
    FieldElement element22 = new Block(2,6,2);
    FieldElement element23 = new Block(2,7,2);
    FieldElement element24 = new Block(3,0,2);
    FieldElement element25 = new Block(3,1,2);
    FieldElement element26 = new Block(3,2,2);
    FieldElement element27 = new Block(3,3,2);
    FieldElement element28 = new Block(3,4,2);
    FieldElement element29 = new Block(3,5,2);
    FieldElement element30 = new Block(3,6,2);
    FieldElement element31 = new Block(3,7,2);
    FieldElement element32 = new Block(4,0,2);
    FieldElement element33 = new Block(4,1,2);
    FieldElement element34 = new Block(4,2,2);
    FieldElement element35 = new Block(4,3,2);
    FieldElement element36 = new Block(4,4,2);
    FieldElement element37 = new Block(4,5,2);
    FieldElement element38 = new Block(4,6,2);
    FieldElement element39 = new Block(4,7,2);
    FieldElement element40 = new Block(5,0,1);
    FieldElement element41 = new Block(5,1,1);
    FieldElement element42 = new Block(5,2,2);
    FieldElement element43 = new WoodBlock(5,3);
    FieldElement element44 = new Block(5,4,3);
    FieldElement element45 = new Block(5,5,2);
    FieldElement element46 = new Block(5,6,2);
    FieldElement element47 = new Block(5,7,2);
    FieldElement element48 = new Block(6,0,2);
    FieldElement element49 = new Block(6,1,2);
    FieldElement element50 = new Block(6,2,2);
    FieldElement element51 = new Block(6,3,2);
    FieldElement element52 = new Block(6,4,2);
    FieldElement element53 = new Block(6,5,2);
    FieldElement element54 = new Block(6,6,2);
    FieldElement element55 = new Block(6,7,2);
    FieldElement element56 = new Block(7,0,2);
    FieldElement element57 = new Block(7,1,2);
    FieldElement element58 = new Block(7,2,2);
    FieldElement element59 = new Block(7,3,2);
    FieldElement element60 = new Block(7,4,2);
    FieldElement element61 = new Block(7,5,2);
    FieldElement element62 = new Block(7,6,2);
    FieldElement element63 = new Block(7,7,2);
    field1.putElement(element0);             //ajout des elements au tableau
    field1.putElement(element1);
    field1.putElement(element2);
    field1.putElement(element3);
    field1.putElement(element4);
    field1.putElement(element5);
    field1.putElement(element6);
    field1.putElement(element7);
    field1.putElement(element8);
    field1.putElement(element9);
    field1.putElement(element10);
    field1.putElement(element11);
    field1.putElement(element12);
    field1.putElement(element13);
    field1.putElement(element14);
    field1.putElement(element15);
    field1.putElement(element16);
    field1.putElement(element17);
    field1.putElement(element18);
    field1.putElement(element19);
    field1.putElement(element20);
    field1.putElement(element21);
    field1.putElement(element22);
    field1.putElement(element21);
    field1.putElement(element23);
    field1.putElement(element24);
    field1.putElement(element25);
    field1.putElement(element26);
    field1.putElement(element27);
    field1.putElement(element28);
    field1.putElement(element29);
    field1.putElement(element30);
    field1.putElement(element31);
    field1.putElement(element32);
    field1.putElement(element33);
    field1.putElement(element34);
    field1.putElement(element35);
    field1.putElement(element36);
    field1.putElement(element37);
    field1.putElement(element38);
    field1.putElement(element39);
    field1.putElement(element40);
    field1.putElement(element41);
    field1.putElement(element42);
    field1.putElement(element43);
    field1.putElement(element44);
    field1.putElement(element45);
    field1.putElement(element46);
    field1.putElement(element47);
    field1.putElement(element48);
    field1.putElement(element49);
    field1.putElement(element50);
    field1.putElement(element51);
    field1.putElement(element52);
    field1.putElement(element53);
    field1.putElement(element54);
    field1.putElement(element55);
    field1.putElement(element56);
    field1.putElement(element57);
    field1.putElement(element58);
    field1.putElement(element59);
    field1.putElement(element60);
    field1.putElement(element61);
    field1.putElement(element62);
    field1.putElement(element63);
    int[] paliers = {100,300,600};

    FieldElement elementa  = new Block(0,0,2);       //creation des elements du field
    FieldElement elementb  = new Block(0,1,2);
    FieldElement elementc  = new Animal(0,2);
    FieldElement elementd  = new Block(1,0,2);
    FieldElement elemente  = new Block(1,1,2);
    FieldElement elementf  = new Block(1,2,2);
    FieldElement elementg  = new Block(2,0,2);
    FieldElement elementh  = new Block(2,1,2);
    FieldElement elementi  = new Block(2,2,2);

    Field field2 = new Field(3,3,3);
    field2.putElement(elementa);             //ajout des elements au tableau
    field2.putElement(elementb);
    field2.putElement(elementc);
    field2.putElement(elementd);
    field2.putElement(elemente);
    field2.putElement(elementf);
    field2.putElement(elementg);
    field2.putElement(elementh);
    field2.putElement(elementi);

     Level level1 = new Level(field1, paliers, 5);
    level1.save();

    Level level2 = new Level(field2, paliers, 1);
    level2.save();
  }
}
