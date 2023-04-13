package Main;

public class Fork {
    private boolean availability;

    public Fork() {
        availability = true;
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
}
