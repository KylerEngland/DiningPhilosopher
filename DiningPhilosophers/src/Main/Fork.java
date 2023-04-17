package Main;
import java.util.concurrent.Semaphore;

public class Fork {
    private boolean availability;
    private Semaphore sem;
    private int usedBy;

    public Fork() {
        availability = true;
        sem = new Semaphore(1, true);
    }

    public synchronized boolean monitorPickUp(int id) {
        if (availability == true) {
            availability = false;
            usedBy = id;
            return true;
        } else {
            return false;
        }
    }

    public synchronized void monitorPutDown() {
        availability = true;
        usedBy = 0;
    }
    public boolean semPickUp(){
        return sem.tryAcquire();
    }
    public void semPutDown(){
        sem.release();
    }
}
