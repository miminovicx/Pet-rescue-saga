package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import levelpack.Level;
import pack.*;
import java.util.Scanner;
/**
 * Classe représentant le menu jouer comportant les boutons jouer aide et quitter
 */
public  class PlayMenu extends JPanel
{
  JLabel nickName;
  MenuItem play;
  MenuItem help;
  MenuItem quit;
  /**
   * Constructeur du menu jouer
   * @method PlayMenu
   */
  public PlayMenu ()
  {
    this.setLayout(null);

    Font font = new Font("Arial",Font.BOLD,40);

    this.play = new MenuItem("Jouer", font);
    this.play.setBounds(200, 80 ,200, 60);
    this.play.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.play.setHorizontalAlignment(JLabel.CENTER);
    this.play.setVerticalAlignment(JLabel.CENTER);

    this.help = new MenuItem("Aide", font);
    this.help.setBounds(200,150,200, 60);
    this.help.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.help.setHorizontalAlignment(JLabel.CENTER);
    this.help.setVerticalAlignment(JLabel.CENTER);

    this.quit = new MenuItem("Quitter", font);
    this.quit.setBounds(200,220,200, 60);
    this.quit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.quit.setHorizontalAlignment(JLabel.CENTER);
    this.quit.setVerticalAlignment(JLabel.CENTER);


    this.add(play);
    this.add(help);
    this.add(quit);
  }
  /**
   * Méthode permettant d'ajouter le pseudo au panel
   * @method setNickName
   * @param  s           le pseudo à ajouter
   */
  public void setNickName(String s)
  {
      this.nickName = new JLabel(s);
      this.nickName.setFont(new Font("Arial", Font.ITALIC, 30));
      this.nickName.setBounds(200, 410, 200, 45);
      this.nickName.setHorizontalAlignment(JLabel.CENTER);
      this.nickName.setVerticalAlignment(JLabel.CENTER);
      this.add(nickName);
  }

  // public void paint(Graphics g)
  // {
  //     // Appel de la méthode paintComponent de la classe mère
  //     super.paintComponent(g);
  //     // Conversion en un contexte 2D
  //     Graphics2D g2 = (Graphics2D) g;
  //     try
  //     {
  //       String path = "../ressources/images/bg.png";
  //       InputStream is = new BufferedInputStream(new FileInputStream(path));
  //       Image image = ImageIO.read(is);
  //       g2.drawImage(image,0,0,null);
  //     }
  //     catch (Exception l_e)
  //     {
  //       System.out.println("fichier introuvable");
  //     }
  //     // Utilisation de g2
  // }
}
