package Exercise3;

public class MainApp {
    public static void main(String[] args) {
        // 1. Instantiate the Game
        Game game = new Game();
        // 2. Instantiate the Players
        Player player1 = new Player("Juan");
        Player player2 = new Player("Maria");
        Player player3 = new Player("Pedro");
        // 3. Add the players to the Game
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        // 4. Set the "taya"
        player1.setTaya(true);
        // 5. Start game and show the players
        game.startGame();
        game.displayPlayers();
        // 6. Simulate the game play
        player2.setPosition(5); // Maria hits the can ... students can manually calibrate the position
        game.displayPlayers();
        // 7. Set can status
        if (player2.getPosition() == game.getCan().getPosition()) {
            game.getCan().setKnockedDown(true);
            System.out.println("The can is knocked down!");
        }
        // 8. Reset the game after the round
        game.resetGame();
        game.displayPlayers();
    }
}

