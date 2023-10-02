package me.simonfoy.gameengine.instance.game.BlocksVSZombiesGame;

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

public class BlocksVSZombiesGame extends GameTemplate {
    public BlocksVSZombiesGame(GameEngine gameEngine, Game game) {
        super(gameEngine, game);
    }

    @Override
    public void onStart() {
        startBlocksVSZombiesGame();
    }

    public void startBlocksVSZombiesGame() {

        onBlocksVSZombiesGameStart();
    }

    public void endBlocksVSZombiesGame() {

        onBlocksVSZombiesGameEnd();
    }

    public void onBlocksVSZombiesGameStart() {

    }

    public void onBlocksVSZombiesGameEnd() {
        game.end();
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {

        ItemStack droppedItem = event.getItemDrop().getItemStack();

        if (game != null && game.getState().equals(GameState.IN_PROGRESS)) {
            if (droppedItem.getType() == Material.STICK) {
                endBlocksVSZombiesGame(); // Assuming your game object has an end method
                event.getPlayer().sendMessage("You dropped a stick! Blocks vs Zombies Game over.");
            }
        }
    }
}
