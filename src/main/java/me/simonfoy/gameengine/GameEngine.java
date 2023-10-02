package me.simonfoy.gameengine;

import me.simonfoy.gameengine.command.GameCommand;
import me.simonfoy.gameengine.instance.Game;
import me.simonfoy.gameengine.instance.GameType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class GameEngine extends JavaPlugin {

    private Game game;
    private GameType currentGame = GameType.CRAFTROYALE;

    @Override
    public void onEnable() {
        // Plugin startup logic

        game = new Game(this, currentGame);

        getCommand("game").setExecutor(new GameCommand(this, game));

        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Game getGame() { return game; }

    public void setGame(GameType gameType) {
        this.currentGame = gameType;
        this.game = new Game(this, currentGame);
    }
    


}
