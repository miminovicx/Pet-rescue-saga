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
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;
public  class GraphicalEnivronnement extends JPanel
{
  private Environment environnement;
  MenuItem back;
  MenuItem [] levelsLabels;
  public GraphicalEnivronnement (String nickName)
  {
    this.environnement = new Environment();
    this.environnement.fillLevelTab();
    this.environnement.createPlayer(nickName);
    this.levelsLabels = new MenuItem[this.environnement.getLevels().length];
    this.setLayout(new BorderLayout());
    JPanel titleLevelPane = new JPanel();
    JPanel levelsMenuPane = new JPanel();
    JPanel playerPane = new JPanel();
    JLabel playerNickName = new JLabel(this.environnement.getPlayer().getNickName());
    playerPane.setLayout(new GridLayout(2,2));
    levelsMenuPane.setLayout(null);
    JLabel titleLevel = new JLabel("Niveaux");
    Font titleFont = new Font("Arial",Font.BOLD,100);
    titleLevel.setFont(titleFont);
    titleLevelPane.add(titleLevel);
    Font font = new Font("Arial",Font.BOLD,40);
    this.back = new MenuItem("Retour", true, font);
    playerPane.add(playerNickName);
    int i = 0;
    for(i = 0; i < levelsLabels.length; i++)
    {
      levelsLabels[i] = new MenuItem("Niveau " + this.environnement.getLevels()[i].getNum(),true,font);
      levelsLabels[i].setBounds(170,0 + (i + 1) * 65,280,60);
      levelsLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
      levelsLabels[i].setHorizontalAlignment(JLabel.CENTER);
      levelsLabels[i].setVerticalAlignment(JLabel.CENTER);
      levelsMenuPane.add(levelsLabels[i]);
    }
    back.setBounds(170,20 + (i + 1) * 65,280, 60);
    back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    back.setHorizontalAlignment(JLabel.CENTER);
    back.setVerticalAlignment(JLabel.CENTER);
    levelsMenuPane.add(back);

    System.out.println("pseudo : " + this.environnement.getPlayer().getNickName());
    this.add(titleLevelPane, BorderLayout.NORTH);
    this.add(titleLevelPane, BorderLayout.NORTH);
    this.add(levelsMenuPane, BorderLayout.CENTER);
    this.add(playerPane, BorderLayout.SOUTH);
  }

  public Environment getEnvironment()
  {
    return (this.environnement) ;
  }
}