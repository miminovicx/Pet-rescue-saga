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
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class NickName extends JPanel
{
  public  static JTextField nickName;
  MenuItem next;
  MenuItem back;
  public NickName ()
  {
    this.setLayout(null);
    Font font = new Font("Arial",Font.BOLD,40);
    this.next = new MenuItem("Continuer", true, font);
    this.back = new MenuItem("Retour", true, font);
    this.next.setHorizontalAlignment(JLabel.CENTER);
    this.next.setVerticalAlignment(JLabel.CENTER);
    this.back.setHorizontalAlignment(JLabel.CENTER);
    this.back.setVerticalAlignment(JLabel.CENTER);
    this.nickName = new JTextField(10);
    this.nickName.setFont(font);
    this.nickName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.next.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.nickName.setBounds(180,160,280,60);
    this.next.setBounds(180,250,280,60);
    this.back.setBounds(180,320,280,60);
    this.add(nickName);
    this.add(next);
    this.add(back);
    // mainPane.add(this.nickName);
    // mainPane.add(this.next);
    // mainPane.add(this.back);
    //this.add(mainPane, BorderLayout.CENTER);
  }
  public static String getNickName()
  {
    return (nickName.getText());
  }
}
