package me.simonfoy.gameengine.instance.game;

import me.simonfoy.gameengine.GameEngine;
import me.simonfoy.gameengine.GameState;
import me.simonfoy.gameengine.instance.Game;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public abstract class GameTemplate implements Listener {

    protected Game game;

    public GameTemplate(GameEngine gameEngine, Game game) {
        this.game = game;
        Bukkit.getPluginManager().registerEvents(this, gameEngine);
    }

    public void start() {
        game.setState(GameState.IN_PROGRESS);
        game.sendMessage("Game has started!");

        onStart();
    }

    public abstract void onStart();

    public void unregister() {
        HandlerList.unregisterAll(this);
    }

}
