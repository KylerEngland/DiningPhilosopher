package Main;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea; 
import java.lang.Thread;

public class Philosopher implements Runnable{
    private int id;
    private String name;
    private String state;
    private Panel panel;
    private JTextArea outputArea;
    private boolean running = true;
    //private Fork leftFork;
    //private Fork rightFork;
    private int ticksRemaining;
    private int ticksPerSecond;



    public Philosopher(int id, Panel panel, JTextArea outputArea, int ticksPerSecond) throws IOException {
        this.id = id; 
        this.name = "P" + id; 
        this.state = "thinking";
        this.panel = panel; 
        this.outputArea = outputArea;
        this.ticksRemaining = 0;
        this.ticksPerSecond = ticksPerSecond; 
        draw(panel);
    }
    private void draw(JPanel panel) throws IOException{
        BufferedImage image = null;
        //File file = new File("DiningPhilosophers/bin/Main/images/philsopher.png");
        //File file = new File("images/philsopher.png");
        File file = new File("../../images/philsopher.png");
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
    public void setState(String newState) {
        panel.setStateText(newState, id);
        state = newState; 
    }
    public void setRunning(boolean newRunning){
        running = newRunning;
    }
    public boolean canEat(){
        // check depending on semophores if this philosopher can eat 
        return true;
    }

    public void tick() throws InterruptedException {
        //System.out.println("tick");
        
        if(ticksRemaining<=0){
            int min = 1; 
            int max = 15; 
            // Set the number of remaining ticks to a random number
            ticksRemaining = (int)Math.floor(Math.random() * (max - min + 1) + min);
            // Change State
            if(state=="thinking") {
                setState("hungry");
                outputArea.append("Philosopher " + id + " is hungry and wants \n to eat for "+ ticksRemaining +" tick(s).\n");
            }
            else if(state=="eating"){
                //eat locking semephores
                setState("thinking");
                outputArea.append("Philosopher " + id + " is thinking and wants \n to think for "+ ticksRemaining +" tick(s).\n");
            } 
        }
        if(state=="thinking"){
            ticksRemaining--; 
            //output to log
            outputArea.append("Philosopher " + id + " thinks and wants \n to think for "+ ticksRemaining +" tick(s).\n");
        }
        else if(state=="eating"){
            //check if able to eat
            ticksRemaining--;
            //output to log
            outputArea.append("Philosopher " + id + " eats and wants \n to eat for "+ ticksRemaining +" tick(s).\n");
        }
        else if(state=="hungry"){
            //try to eat
            if(canEat()==true){
                //eat locking semephores
                setState("eating");
                ticksRemaining--;
                outputArea.append("Philosopher " + id + " eats and wants \n to eat for "+ ticksRemaining +" tick(s).\n");
            }
            else {
                outputArea.append("Philosopher " + id + " is unable to eat and wants \n to eat for "+ ticksRemaining +" tick(s).\n");
            }
        }
        // Sleep according to how many ticks per second
        long sleepTime = 1000/ticksPerSecond; 
        Thread.sleep(sleepTime); 
    }

    public void run(){
        while(running){
            try {
                tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        // philosopher is thinking
        //   outputArea.append("Philosopher " + id + " is thinking.\n");

        //   // philosopher tries to pick up left fork
        //   leftFork.pickUp();

        //   // philosopher tries to pick up right fork
        //   if (rightFork.pickUp()) {
        //       // philosopher is eating
        //       outputArea.append("Philosopher " + id + " is eating.\n");

        //       // philosopher puts down right fork
        //       rightFork.putDown();
        //   }

        //   // philosopher puts down left fork
        //   leftFork.putDown();  
        }
    }
}
