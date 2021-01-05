import environment_player_pack.Environment;
import environment_player_pack.Launcher;
import environment_player_pack.Player;
import levelpack.FieldElement;
import levelpack.Block;
import levelpack.SquaredBlock;
import levelpack.WoodBlock;
import levelpack.Animal;
import levelpack.Level;
import levelpack.Field;
import gui.*;

public class LevelCreator
{

  public static void main(String[] args)
  {
    //LEVEL 1
    Field field1 = new Field(5,5,5);

    FieldElement level1Element0  = new Block(0,0,1);
    FieldElement level1Element1  = new Animal(0,1);
    FieldElement level1Element2  = new Block(0,2,2);
    FieldElement level1Element3  = new Block(0,3,2);
    FieldElement level1Element4  = new Block(0,4,2);
    FieldElement level1Element5  = new Block(1,0,1);
    FieldElement level1Element6  = new Block(1,1,2);
    FieldElement level1Element7  = new Block(1,2,2);
    FieldElement level1Element8  = new Block(1,3,1);
    FieldElement level1Element9  = new Block(1,4,2);
    FieldElement level1Element10 = new Block(2,0,1);
    FieldElement level1Element11 = new Block(2,1,2);
    FieldElement level1Element12 = new Block(2,2,5);
    FieldElement level1Element13 = new Block(2,3,2);
    FieldElement level1Element14 = new Block(2,4,1);
    FieldElement level1Element15 = new Block(3,0,2);
    FieldElement level1Element16 = new Block(3,1,1);
    FieldElement level1Element17 = new Block(3,2,2);
    FieldElement level1Element18 = new Block(3,3,2);
    FieldElement level1Element19 = new Block(3,4,2);
    FieldElement level1Element20 = new Block(4,0,2);
    FieldElement level1Element21 = new Block(4,1,2);
    FieldElement level1Element22 = new Block(4,2,1);
    FieldElement level1Element23 = new Block(4,3,1);
    FieldElement level1Element24 = new Block(4,4,1);

    field1.putElement(level1Element0);
    field1.putElement(level1Element1);
    field1.putElement(level1Element2);
    field1.putElement(level1Element3);
    field1.putElement(level1Element4);
    field1.putElement(level1Element5);
    field1.putElement(level1Element6);
    field1.putElement(level1Element7);
    field1.putElement(level1Element8);
    field1.putElement(level1Element9);
    field1.putElement(level1Element10);
    field1.putElement(level1Element11);
    field1.putElement(level1Element12);
    field1.putElement(level1Element13);
    field1.putElement(level1Element14);
    field1.putElement(level1Element15);
    field1.putElement(level1Element16);
    field1.putElement(level1Element17);
    field1.putElement(level1Element18);
    field1.putElement(level1Element19);
    field1.putElement(level1Element20);
    field1.putElement(level1Element21);
    field1.putElement(level1Element22);
    field1.putElement(level1Element21);
    field1.putElement(level1Element23);
    field1.putElement(level1Element24);

    int[] paliersLevel1 = {700,1500,2400};

    Level level1 = new Level(field1, paliersLevel1, 1);
    level1.save();

    //LEVEL 2

    Field field2 = new Field(5,5,5);

    FieldElement level2Element0  = new Animal(0,0);
    FieldElement level2Element1  = new Block(0,1,1);
    FieldElement level2Element2  = new Animal(0,2);
    FieldElement level2Element3  = new Block(0,3,3);
    FieldElement level2Element4  = new Animal(0,4);
    FieldElement level2Element5  = new Block(1,0,1);
    FieldElement level2Element6  = new Block(1,1,2);
    FieldElement level2Element7  = new Block(1,2,2);
    FieldElement level2Element8  = new Block(1,3,4);
    FieldElement level2Element9  = new Block(1,4,1);
    FieldElement level2Element10 = new Block(2,0,2);
    FieldElement level2Element11 = new Block(2,1,1);
    FieldElement level2Element12 = new Block(2,2,2);
    FieldElement level2Element13 = new WoodBlock(2,3);
    FieldElement level2Element14 = new Block(2,4,1);
    FieldElement level2Element15 = new Block(3,0,2);
    FieldElement level2Element16 = new Block(3,1,3);
    FieldElement level2Element17 = new Block(3,2,1);
    FieldElement level2Element18 = new Block(3,3,1);
    FieldElement level2Element19 = new Block(3,4,2);
    FieldElement level2Element20 = new Block(4,0,3);
    FieldElement level2Element21 = new Block(4,1,3);
    FieldElement level2Element22 = new Block(4,2,1);
    FieldElement level2Element23 = new Block(4,3,2);
    FieldElement level2Element24 = new Block(4,4,2);

    field2.putElement(level2Element0);
    field2.putElement(level2Element1);
    field2.putElement(level2Element2);
    field2.putElement(level2Element3);
    field2.putElement(level2Element4);
    field2.putElement(level2Element5);
    field2.putElement(level2Element6);
    field2.putElement(level2Element7);
    field2.putElement(level2Element8);
    field2.putElement(level2Element9);
    field2.putElement(level2Element10);
    field2.putElement(level2Element11);
    field2.putElement(level2Element12);
    field2.putElement(level2Element13);
    field2.putElement(level2Element14);
    field2.putElement(level2Element15);
    field2.putElement(level2Element16);
    field2.putElement(level2Element17);
    field2.putElement(level2Element18);
    field2.putElement(level2Element19);
    field2.putElement(level2Element20);
    field2.putElement(level2Element21);
    field2.putElement(level2Element22);
    field2.putElement(level2Element21);
    field2.putElement(level2Element23);
    field2.putElement(level2Element24);

    int[] paliersLevel2 = {1000,2500,3600};

    Level level2 = new Level(field2, paliersLevel2, 3);
    level2.save();

    //LEVEL 3

    Field field3 = new Field(5,6,5);

    FieldElement level3element0  = new WoodBlock(0,0);       //creation des level3elements du field
    FieldElement level3element1  = new Animal(0,1);
    FieldElement level3element2  = new Block(0,2,2);
    FieldElement level3element3  = new Block(0,3,5);
    FieldElement level3element4  = new Animal(0,4);
    FieldElement level3element5  = new WoodBlock(0,5);
    FieldElement level3element8  = new Block(1,0,1);
    FieldElement level3element9  = new Block(1,1,4);
    FieldElement level3element10 = new Block(1,2,5);
    FieldElement level3element11 = new WoodBlock(1,3);
    FieldElement level3element12 = new Block(1,4,1);
    FieldElement level3element13 = new Block(1,5,1);
    FieldElement level3element16 = new Block(2,0,3);
    FieldElement level3element17 = new Block(2,1,5);
    FieldElement level3element18 = new Block(2,2,5);
    FieldElement level3element19 = new WoodBlock(2,3);
    FieldElement level3element20 = new Block(2,4,1);
    FieldElement level3element21 = new Block(2,5,3);
    FieldElement level3element24 = new Block(3,0,3);
    FieldElement level3element25 = new Block(3,1,4);
    FieldElement level3element26 = new Block(3,2,2);
    FieldElement level3element27 = new WoodBlock(3,3);
    FieldElement level3element28 = new Block(3,4,3);
    FieldElement level3element29 = new Block(3,5,3);
    FieldElement level3element32 = new WoodBlock(4,0);
    FieldElement level3element33 = new Block(4,1,4);
    FieldElement level3element34 = new WoodBlock(4,2);
    FieldElement level3element35 = new Block(4,3,4);
    FieldElement level3element36 = new Block(4,4,1);
    FieldElement level3element37 = new WoodBlock(4,5);

    field3.putElement(level3element0);             //ajout des level3elements au tableau
    field3.putElement(level3element1);
    field3.putElement(level3element2);
    field3.putElement(level3element3);
    field3.putElement(level3element4);
    field3.putElement(level3element5);
    field3.putElement(level3element8);
    field3.putElement(level3element9);
    field3.putElement(level3element10);
    field3.putElement(level3element11);
    field3.putElement(level3element12);
    field3.putElement(level3element13);
    field3.putElement(level3element16);
    field3.putElement(level3element17);
    field3.putElement(level3element18);
    field3.putElement(level3element19);
    field3.putElement(level3element20);
    field3.putElement(level3element21);
    field3.putElement(level3element24);
    field3.putElement(level3element25);
    field3.putElement(level3element26);
    field3.putElement(level3element27);
    field3.putElement(level3element28);
    field3.putElement(level3element29);
    field3.putElement(level3element32);
    field3.putElement(level3element33);
    field3.putElement(level3element34);
    field3.putElement(level3element35);
    field3.putElement(level3element36);
    field3.putElement(level3element37);


    int[] paliersLevel3 = {1400,2250,2500};

    Level level3 = new Level(field3, paliersLevel3, 2);
    level3.save();


    //LEVEL 4

    Field field4 = new Field(6,6,3);

    FieldElement level4element0  = new WoodBlock(0,0);       //creation des level4elements du field
    FieldElement level4element1  = new Animal(0,1);
    FieldElement level4element2  = new Animal(0,2);
    FieldElement level4element3  = new Animal(0,3);
    FieldElement level4element4  = new Animal(0,4);
    FieldElement level4element5  = new WoodBlock(0,5);
    FieldElement level4element8  = new WoodBlock(1,0);
    FieldElement level4element9  = new Block(1,1,2);
    FieldElement level4element10 = new Block(1,2,3);
    FieldElement level4element11 = new Block(1,3,3);
    FieldElement level4element12 = new Block(1,4,4);
    FieldElement level4element13 = new WoodBlock(1,5);
    FieldElement level4element16 = new Block(2,0,1);
    FieldElement level4element17 = new Block(2,1,1);
    FieldElement level4element18 = new Block(2,2,2);
    FieldElement level4element19 = new Block(2,3,3);
    FieldElement level4element20 = new Block(2,4,4);
    FieldElement level4element21 = new Block(2,5,4);
    FieldElement level4element24 = new Block(3,0,3);
    FieldElement level4element25 = new Block(3,1,2);
    FieldElement level4element26 = new Block(3,2,3);
    FieldElement level4element27 = new Block(3,3,3);
    FieldElement level4element28 = new Block(3,4,1);
    FieldElement level4element29 = new Block(3,5,1);
    FieldElement level4element32 = new WoodBlock(4,0);
    FieldElement level4element33 = new Block(4,1,1);
    FieldElement level4element34 = new Block(4,2,4);
    FieldElement level4element35 = new Block(4,3,4);
    FieldElement level4element36 = new Block(4,4,5);
    FieldElement level4element37 = new WoodBlock(4,5);
    FieldElement level4element40 = new WoodBlock(5,0);
    FieldElement level4element41 = new Block(5,1,1);
    FieldElement level4element42 = new Block(5,2,1);
    FieldElement level4element43 = new Block(5,3,5);
    FieldElement level4element44 = new Block(5,4,5);
    FieldElement level4element45 = new WoodBlock(5,5);
    field4.putElement(level4element0);
    field4.putElement(level4element1);
    field4.putElement(level4element2);
    field4.putElement(level4element3);
    field4.putElement(level4element4);
    field4.putElement(level4element5);
    field4.putElement(level4element8);
    field4.putElement(level4element9);
    field4.putElement(level4element10);
    field4.putElement(level4element11);
    field4.putElement(level4element12);
    field4.putElement(level4element13);
    field4.putElement(level4element16);
    field4.putElement(level4element17);
    field4.putElement(level4element18);
    field4.putElement(level4element19);
    field4.putElement(level4element20);
    field4.putElement(level4element21);
    field4.putElement(level4element24);
    field4.putElement(level4element25);
    field4.putElement(level4element26);
    field4.putElement(level4element27);
    field4.putElement(level4element28);
    field4.putElement(level4element29);
    field4.putElement(level4element32);
    field4.putElement(level4element33);
    field4.putElement(level4element34);
    field4.putElement(level4element35);
    field4.putElement(level4element36);
    field4.putElement(level4element37);
    field4.putElement(level4element40);
    field4.putElement(level4element41);
    field4.putElement(level4element42);
    field4.putElement(level4element43);
    field4.putElement(level4element44);
    field4.putElement(level4element45);




    int[] paliersLevel4 = {1000,2500,4600};

    Level level4 = new Level(field4, paliersLevel4, 4);
    level4.save();


    // Field field1 = new Field(8,8,5);
    //
    // FieldElement element0  = new Animal(0,0);       //creation des elements du field
    // FieldElement element1  = new Block(0,1,1);
    // FieldElement element2  = new Animal(0,2);
    // FieldElement element3  = new Block(0,3,2);
    // FieldElement element4  = new Animal(0,4);
    // FieldElement element5  = new Block(0,5,3);
    // FieldElement element6  = new Animal(0,6);
    // FieldElement element7  = new Animal(0,7);
    // FieldElement element8  = new Block(1,0,2);
    // FieldElement element9  = new Block(1,1,3);
    // FieldElement element10 = new Block(1,2,2);
    // FieldElement element11 = new Block(1,3,2);
    // FieldElement element12 = new Block(1,4,2);
    // FieldElement element13 = new Block(1,5,2);
    // FieldElement element14 = new Block(1,6,2);
    // FieldElement element15 = new Block(1,7,2);
    // FieldElement element16 = new Block(2,0,2);
    // FieldElement element17 = new Block(2,1,2);
    // FieldElement element18 = new Block(2,2,2);
    // FieldElement element19 = new Block(2,3,2);
    // FieldElement element20 = new Block(2,4,2);
    // FieldElement element21 = new Block(2,5,2);
    // FieldElement element22 = new Block(2,6,2);
    // FieldElement element23 = new Block(2,7,2);
    // FieldElement element24 = new Block(3,0,2);
    // FieldElement element25 = new Block(3,1,2);
    // FieldElement element26 = new Block(3,2,2);
    // FieldElement element27 = new Block(3,3,2);
    // FieldElement element28 = new Block(3,4,2);
    // FieldElement element29 = new Block(3,5,2);
    // FieldElement element30 = new Block(3,6,2);
    // FieldElement element31 = new Block(3,7,2);
    // FieldElement element32 = new Block(4,0,2);
    // FieldElement element33 = new Block(4,1,2);
    // FieldElement element34 = new Block(4,2,2);
    // FieldElement element35 = new Block(4,3,2);
    // FieldElement element36 = new Block(4,4,2);
    // FieldElement element37 = new Block(4,5,2);
    // FieldElement element38 = new Block(4,6,2);
    // FieldElement element39 = new Block(4,7,2);
    // FieldElement element40 = new Block(5,0,1);
    // FieldElement element41 = new Block(5,1,1);
    // FieldElement element42 = new Block(5,2,2);
    // FieldElement element43 = new WoodBlock(5,3);
    // FieldElement element44 = new Block(5,4,3);
    // FieldElement element45 = new Block(5,5,2);
    // FieldElement element46 = new Block(5,6,2);
    // FieldElement element47 = new Block(5,7,2);
    // FieldElement element48 = new Block(6,0,2);
    // FieldElement element49 = new Block(6,1,2);
    // FieldElement element50 = new Block(6,2,2);
    // FieldElement element51 = new Block(6,3,2);
    // FieldElement element52 = new Block(6,4,2);
    // FieldElement element53 = new Block(6,5,2);
    // FieldElement element54 = new Block(6,6,2);
    // FieldElement element55 = new Block(6,7,2);
    // FieldElement element56 = new Block(7,0,2);
    // FieldElement element57 = new Block(7,1,2);
    // FieldElement element58 = new Block(7,2,2);
    // FieldElement element59 = new Block(7,3,2);
    // FieldElement element60 = new Block(7,4,2);
    // FieldElement element61 = new Block(7,5,2);
    // FieldElement element62 = new Block(7,6,2);
    // FieldElement element63 = new Block(7,7,2);
    // field1.putElement(element0);             //ajout des elements au tableau
    // field1.putElement(element1);
    // field1.putElement(element2);
    // field1.putElement(element3);
    // field1.putElement(element4);
    // field1.putElement(element5);
    // field1.putElement(element6);
    // field1.putElement(element7);
    // field1.putElement(element8);
    // field1.putElement(element9);
    // field1.putElement(element10);
    // field1.putElement(element11);
    // field1.putElement(element12);
    // field1.putElement(element13);
    // field1.putElement(element14);
    // field1.putElement(element15);
    // field1.putElement(element16);
    // field1.putElement(element17);
    // field1.putElement(element18);
    // field1.putElement(element19);
    // field1.putElement(element20);
    // field1.putElement(element21);
    // field1.putElement(element22);
    // field1.putElement(element21);
    // field1.putElement(element23);
    // field1.putElement(element24);
    // field1.putElement(element25);
    // field1.putElement(element26);
    // field1.putElement(element27);
    // field1.putElement(element28);
    // field1.putElement(element29);
    // field1.putElement(element30);
    // field1.putElement(element31);
    // field1.putElement(element32);
    // field1.putElement(element33);
    // field1.putElement(element34);
    // field1.putElement(element35);
    // field1.putElement(element36);
    // field1.putElement(element37);
    // field1.putElement(element38);
    // field1.putElement(element39);
    // field1.putElement(element40);
    // field1.putElement(element41);
    // field1.putElement(element42);
    // field1.putElement(element43);
    // field1.putElement(element44);
    // field1.putElement(element45);
    // field1.putElement(element46);
    // field1.putElement(element47);
    // field1.putElement(element48);
    // field1.putElement(element49);
    // field1.putElement(element50);
    // field1.putElement(element51);
    // field1.putElement(element52);
    // field1.putElement(element53);
    // field1.putElement(element54);
    // field1.putElement(element55);
    // field1.putElement(element56);
    // field1.putElement(element57);
    // field1.putElement(element58);
    // field1.putElement(element59);
    // field1.putElement(element60);
    // field1.putElement(element61);
    // field1.putElement(element62);
    // field1.putElement(element63);
    // int[] paliers = {100,300,600};
    // //
    // FieldElement elementa  = new Block(0,0,1);       //creation des elements du field
    // FieldElement elementb  = new Block(0,1,2);
    // FieldElement elementc  = new Animal(0,2);
    // FieldElement elementd  = new Block(1,0,1);
    // FieldElement elemente  = new Block(1,1,2);
    // FieldElement elementf  = new Block(1,2,2);
    // FieldElement elementg  = new Block(2,0,1);
    // FieldElement elementh  = new Block(2,1,2);
    // FieldElement elementi  = new Block(2,2,2);
    //
  //   Field field2 = new Field(3,3,3);
  //   field2.putElement(elementa);             //ajout des elements au tableau
  //   field2.putElement(elementb);
  //   field2.putElement(elementc);
  //   field2.putElement(elementd);
  //   field2.putElement(elemente);
  //   field2.putElement(elementf);
  //   field2.putElement(elementg);
  //   field2.putElement(elementh);
  //   field2.putElement(elementi);
  //   //
  //   //  Level level1 = new Level(field1, paliers, 5);
  //   // level1.save();
  //
  //   Level level2 = new Level(field2, paliers, 1);
  //   level2.save();
  }
}
