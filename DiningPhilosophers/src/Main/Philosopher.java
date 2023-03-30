package Main;
// import java.awt.BorderLayout;
import java.awt.Image;
//import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea; 

public class Philosopher implements Runnable{
    private int id;
    private String name;
    private String state;
    private JPanel panel;
    private JTextArea outputArea;
    private boolean running = true;
    private Fork leftFork;
    private Fork rightFork;
    private int tickNumber;



    public Philosopher(int id, JPanel panel, JTextArea outputArea, int tickNumber) throws IOException {
        this.id = id; 
        this.name = "P" + id; 
        this.state = "thinking";
        this.panel = panel; 
        this.outputArea = outputArea;
        this.tickNumber = tickNumber;
        draw(panel);
    }
    private void draw(JPanel panel) throws IOException{
        BufferedImage image = null;
        File file = new File("./bin/Main/images/philsopher.png");
        image = ImageIO.read(file);
        Image resultingImage = image.getScaledInstance(125, 150, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(resultingImage));
        panel.setLayout(null);
        switch (id) {
            case 1: //P5
                label.setBounds(90, 210, 125, 150);
                 break;
            case 2: //P1
                label.setBounds(290, 50, 125, 150);
                break;
            case 3: //P4
                label.setBounds(150, 440, 125, 150);
                break;
            case 4: //P3
                label.setBounds(420, 440, 125, 150);
                break;
            case 5: // P2
                label.setBounds(485, 210, 125, 150);
              break;
          }
        panel.add(label);
    }
    public int getId() {
        return id; 
    }
    public String getName() {
        return name; 
    }
    public String getState() {
        return state; 
    }
    public void setState(String newState, Panel panel) {
        panel.setStateText(newState, id);
        state = newState; 
    }

    public void run(){
        while(running){
          // philosopher is thinking
          outputArea.append("Philosopher " + id + " is thinking.\n");

          // philosopher tries to pick up left fork
          leftFork.pickUp();

          // philosopher tries to pick up right fork
          if (rightFork.pickUp()) {
              // philosopher is eating
              outputArea.append("Philosopher " + id + " is eating.\n");

              // philosopher puts down right fork
              rightFork.putDown();
          }

          // philosopher puts down left fork
          leftFork.putDown();  
        }
    }
}
