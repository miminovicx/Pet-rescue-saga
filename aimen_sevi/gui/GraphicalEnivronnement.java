package gui;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import java.awt.*;
import levelpack.Level;
import pack.*;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

public  class GraphicalEnivronnement extends JPanel
{
  private Environment environnement;
  MenuItem back;
  MenuItem [] levelsLabels;
  JLabel playerNickName;
  public GraphicalEnivronnement (Environment environnement)
  {
    this.environnement = environnement;
    this.levelsLabels = new MenuItem[this.environnement.getLevels().length];
    this.setLayout(new BorderLayout());

    JLabel titleLevel = new JLabel("Niveaux");
    Font titleFont = new Font("Arial",Font.ITALIC,75);
    titleLevel.setFont(titleFont);

    JPanel titleLevelPane = new JPanel();
    titleLevelPane.add(titleLevel);
    this.add(titleLevelPane, BorderLayout.NORTH);

    JPanel levelsMenuPane = new JPanel();
    levelsMenuPane.setLayout(null);


    JPanel playerPane = new JPanel();

    this.playerNickName = new JLabel(this.environnement.getPlayer().getNickName());
    this.playerNickName.setFont(new Font("Arial", Font.ITALIC, 30));
    this.playerNickName.setBounds(200, 410, 200, 45);
    this.playerNickName.setHorizontalAlignment(JLabel.CENTER);
    this.playerNickName.setVerticalAlignment(JLabel.CENTER);
    this.add(playerNickName);
    Font font = new Font("Arial",Font.BOLD,40);
    this.back = new MenuItem("Retour", font);
    playerPane.add(this.playerNickName);
    int i = 0;
    for(i = 0; i < levelsLabels.length; i++)
    {
      levelsLabels[i] = new MenuItem("Niveau " + this.environnement.getLevels()[i].getNum(),font);
      levelsLabels[i].setBounds(160,0 + (i + 1) * 65,280,60);
      levelsLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
      levelsLabels[i].setHorizontalAlignment(JLabel.CENTER);
      levelsLabels[i].setVerticalAlignment(JLabel.CENTER);
      levelsMenuPane.add(levelsLabels[i]);
    }
    back.setBounds(160,20 + (i + 1) * 65,280, 60);
    back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    back.setHorizontalAlignment(JLabel.CENTER);
    back.setVerticalAlignment(JLabel.CENTER);
    levelsMenuPane.add(back);

    System.out.println("pseudo : " + this.environnement.getPlayer().getNickName());
    this.add(levelsMenuPane, BorderLayout.CENTER);
    this.add(playerPane, BorderLayout.SOUTH);
  }
  public void setNickName(String nickname)
  {
    this.playerNickName.setText(nickname);
  }
  public Environment getEnvironment()
  {
    return (this.environnement) ;
  }
  // public void paint(Graphics g) {
	// 	super.paint(g);
	// 	Color c = g.getColor();
	// 	// g.setColor(Color.RED);
  //   g.setColor(Color.BLUE);
	// 	g.fillRect(0,0,2800,8000);
	// }
}
