package Main;

import java.util.concurrent.Semaphore;

public class Fork {
    private boolean availability;
    private Semaphore sem;

    public Fork() {
        availability = true;
        sem = new Semaphore(1, true);
    }

    public boolean pickUp() {
        if (availability == true) {
            availability = false;
            return true;
        } else {
            return false;
        }
    }

    public void putDown() {
        availability = true;
    }
    public boolean semPickUp(){
        return sem.tryAcquire();
    }
    public void semPutDown(){
        sem.release();
    }
}
