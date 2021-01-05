package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;
import environment_player_pack.*;
import levelpack.Level;
/**
 * Classe représentant le premier menu affiché
 */
public  class HomeMenu extends JPanel
{

  MenuItem start;
  MenuItem quit;
  /**
   * Constructeur du premier menu affiché
   * @method HomeMenu
   */
  public HomeMenu ()
  {
    this.setLayout(new BorderLayout());


    JLabel title = new JLabel("Pet Rescue");
    Font titleFont = new Font("Arial",Font.ITALIC,50);
    title.setFont(titleFont);
    title.setForeground(Color.GRAY);
    title.setHorizontalAlignment(JLabel.CENTER);

    JPanel menu = new JPanel(null);

    Font font = new Font("Arial",Font.BOLD,40);

    this.start = new MenuItem("Commencer", font);
    this.start.setBounds(160, 100, 280, 60);
    this.start.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.start.setHorizontalAlignment(JLabel.CENTER);

    this.quit = new MenuItem("Quitter", font);
    this.quit.setBounds(160, 175, 280, 60);
    this.quit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.quit.setHorizontalAlignment(JLabel.CENTER);

    menu.add(start);
    menu.add(quit);

    this.add(title,BorderLayout.NORTH);
    this.add(menu,BorderLayout.CENTER);

  }

}
