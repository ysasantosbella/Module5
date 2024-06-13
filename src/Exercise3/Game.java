package Exercise3;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Can can;
    private boolean gameStatus;

    public Game() {
        this.players = new ArrayList<>();
        this.can = new Can(5, false);  // Example position for the can
        this.gameStatus = false;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void displayPlayers() {
        for (Player player : players) {
            System.out.println("Player: " + player.getName() + ", Position: " + player.getPosition() + ", Is Taya: " + player.isTaya());
        }
    }

    public void startGame() {
        gameStatus = true;
        System.out.println("Game started!");
    }

    public boolean checkGameStatus() {
        return gameStatus;
    }

    public void resetGame() {
        for (Player player : players) {
            player.setPosition(0);  // Reset player positions
            player.setTaya(false);  // Reset Taya status
        }
        can.setPosition(5);  // Reset can position
        can.setKnockedDown(false);  // Reset can status
        gameStatus = false;
        System.out.println("Game reset!");
    }

    public Can getCan() {
        return can;
    }
}
