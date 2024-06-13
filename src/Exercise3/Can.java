package Exercise3;

public class Can {
    private int position;
    private boolean isKnockedDown;

    public Can(int position, boolean isKnockedDown) {
        this.position = position;
        this.isKnockedDown = isKnockedDown;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isKnockedDown() {
        return isKnockedDown;
    }

    public void setKnockedDown(boolean knockedDown) {
        isKnockedDown = knockedDown;
    }
}
