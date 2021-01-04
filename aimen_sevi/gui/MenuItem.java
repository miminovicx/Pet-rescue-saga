package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import levelpack.Level;
import environment_player_pack.*;
import java.util.Scanner;
/**
 * Classe représentant un bouton du menu
 */
public class MenuItem extends JLabel
{
  /**
   * Constructeur pour les boutons du menu
   * @method MenuItem
   * @param  label    le contenu du bouton
   * @param  font     la police du contenu
   */
  MenuItem(String label,Font font)
  {
    super(label);
    this.setOpaque(true);
    this.setForeground(Color.BLACK);
    this.setBackground(Color.GRAY);
    this.setFont(font);
  }

  // public void paint(Graphics g) {
	// 	super.paint(g);
	// 	Color c = g.getColor();
	// 	g.setColor(Color.RED);
	// 	g.fillRect(0,0,2800,8000);
	// 	g.setColor(Color.BLUE);
	// }
}
