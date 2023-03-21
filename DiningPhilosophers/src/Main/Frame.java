package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(){
        this.setTitle("Dinner");
        this.setSize(new Dimension(1024, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.setLayout(new BorderLayout());
		ImageIcon logo = new ImageIcon("../spaghettiLogo.png");
		this.setIconImage(logo.getImage()); 
        this.setVisible(true);
    }
}
