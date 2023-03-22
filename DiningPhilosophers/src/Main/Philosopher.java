package Main;
import java.awt.*;
//import 

import javax.swing.JPanel;

public class Philosopher {
    int id;
    String name;
    String state;
    JPanel panel;
    public Philosopher(int id, JPanel panel) {
        this.id = id; 
        this.name = "P" + id; 
        this.state = "thinking";
        this.panel=panel; 
        draw();

    }
    private void draw(){

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
        state = newState; 
    }
}
