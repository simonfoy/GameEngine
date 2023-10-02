package me.simonfoy.gameengine.command;

import me.simonfoy.gameengine.GameEngine;
import me.simonfoy.gameengine.instance.Game;
import me.simonfoy.gameengine.instance.GameType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCommand implements CommandExecutor {

    private GameEngine gameEngine;
    private Game game;

    public GameCommand(GameEngine gameEngine, Game game) {
        this.gameEngine = gameEngine;
        this.game = game;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player!");
            return true;
        }

        Game currentGame = gameEngine.getGame(); // Assuming you have such a method to get the current game.

        if (args.length == 0) {
            sender.sendMessage("Usage: /game <gameType> or /game list");
            return true;
        }

        if (args[0].equalsIgnoreCase("list")) {
            // Show available game types
            sender.sendMessage("Available game types:");
            sender.sendMessage("- TOWERWARS");
            sender.sendMessage("- CRAFTROYALE");
            sender.sendMessage("- BLOCKSVSZOMBIES");

            sender.sendMessage("Debug: Current game type is now: " + currentGame.getGameType());
            return true;
        }

        String gameType = args[0].toUpperCase();
        if (!gameType.equals("TOWERWARS")
                && !gameType.equals("CRAFTROYALE")
                && !gameType.equals("BLOCKSVSZOMBIES")) {
            sender.sendMessage("Invalid game type! Use /game list to see available game types.");
            return true;
        }

        // Get the current game instance and set its game type.
        if(currentGame == null) {
            sender.sendMessage("No active game found. Unable to switch game type.");
            return true;
        }
        currentGame.setGameType(GameType.valueOf(gameType));
        gameEngine.setGame(GameType.valueOf(gameType));

        sender.sendMessage("Switched current game to type " + gameType + "!");
        sender.sendMessage("Debug: Current game type is now: " + currentGame.getGameType());

        return true;
    }
}
