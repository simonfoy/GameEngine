package me.simonfoy.gameengine.instance.game.CraftRoyaleGame;

import me.simonfoy.gameengine.GameEngine;
import me.simonfoy.gameengine.GameState;
import me.simonfoy.gameengine.instance.Game;
import me.simonfoy.gameengine.instance.game.GameTemplate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftRoyaleGame extends GameTemplate {
    public CraftRoyaleGame(GameEngine gameEngine, Game game) {
        super(gameEngine, game);
    }

    @Override
    public void onStart() {
        startCraftRoyaleGame();
    }

    public void startCraftRoyaleGame() {

        onCraftRoyaleGameStart();
    }

    public void endCraftRoyaleGame() {

        onCraftRoyaleGameEnd();
    }

    public void onCraftRoyaleGameStart() {

    }

    public void onCraftRoyaleGameEnd() {
        game.end();
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {

        ItemStack droppedItem = event.getItemDrop().getItemStack();

        if (game != null && game.getState().equals(GameState.IN_PROGRESS)) {
            if (droppedItem.getType() == Material.STICK) {
                endCraftRoyaleGame(); // Assuming your game object has an end method
                event.getPlayer().sendMessage("You dropped a stick! Craft Royale Game over.");
            }
        }
    }
}
