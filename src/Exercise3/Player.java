package Exercise3;

public class Player {
    private static int totalPlayers = 0;

    private String name;
    private int position;
    private boolean isTaya;

    public Player(String name) {
        this.name = name;
        this.position = 0;  // Default starting position
        this.isTaya = false;  // Default Taya status
        totalPlayers++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isTaya() {
        return isTaya;
    }

    public void setTaya(boolean taya) {
        isTaya = taya;
    }

    public static int getTotalPlayers() {
        return totalPlayers;
    }
}
