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
  JLabel nickNameAsk;
  JTextField nickName;
  MenuItem next;
  MenuItem back;
  public NickName ()
  {
    this.setLayout(null);

    Font font = new Font("Arial",Font.BOLD,40);
    Font font2 = new Font("Arial",Font.ITALIC,40);

    this.nickNameAsk = new JLabel("Pseudo");
    this.nickNameAsk.setFont(font2);

    this.nickNameAsk.setBounds(160, 100, 280, 60);
    this.nickNameAsk.setHorizontalAlignment(JLabel.CENTER);
    this.nickNameAsk.setVerticalAlignment(JLabel.CENTER);

    this.nickName = new JTextField(10);
    this.nickName.setFont(font2);
    this.nickName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.nickName.setBounds(160,160,280,60);
    this.nickName.setHorizontalAlignment(JLabel.CENTER);

    this.next = new MenuItem("Continuer", font);
    this.back = new MenuItem("Retour", font);

    this.next.setHorizontalAlignment(JLabel.CENTER);
    this.next.setVerticalAlignment(JLabel.CENTER);
    this.next.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.next.setBounds(160,250,280,60);

    this.back.setHorizontalAlignment(JLabel.CENTER);
    this.back.setVerticalAlignment(JLabel.CENTER);
    this.back.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
    this.back.setBounds(160,320,280,60);

    this.add(nickNameAsk);
    this.add(nickName);
    this.add(next);
    this.add(back);
    // mainPane.add(this.nickName);
    // mainPane.add(this.next);
    // mainPane.add(this.back);
    //this.add(mainPane, BorderLayout.CENTER);
    next.addMouseListener(new MouseAdapter()
    {
      public void mouseClicked(MouseEvent e)
      {
        // GraphicalEnivronnement.this.levelsPane = new GraphicalEnivronnement(NickName.this.nickName.getText());
        System.out.println(NickName.this.nickName.getText());
      }
      public void mouseEntered(MouseEvent e)
      {

      }
      public void mouseExited(MouseEvent e)
      {

      }
    });
  }

  // public void paint(Graphics g) {
	// 	super.paint(g);
	// 	Color c = g.getColor();
  //   g.setColor(Color.BLUE);
	// 	// g.setColor(Color.RED);
	// 	g.fillRect(0,0,2800,8000);
	// }


}
