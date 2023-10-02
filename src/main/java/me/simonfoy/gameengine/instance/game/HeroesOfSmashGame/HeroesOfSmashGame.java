package me.simonfoy.gameengine.instance.game.HeroesOfSmashGame;

import me.simonfoy.gameengine.GameEngine;
import me.simonfoy.gameengine.GameState;
import me.simonfoy.gameengine.instance.Game;
import me.simonfoy.gameengine.instance.game.GameTemplate;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class HeroesOfSmashGame extends GameTemplate {
    public HeroesOfSmashGame(GameEngine gameEngine, Game game) {
        super(gameEngine, game);
    }

    @Override
    public void onStart() {
        startHeroesOfSmashGame();
    }

    public void startHeroesOfSmashGame() {

        onHeroesOfSmashGameStart();
    }

    public void endHeroesOfSmashGame() {

        onHeroesOfSmashGameEnd();
    }

    public void onHeroesOfSmashGameStart() {

    }

    public void onHeroesOfSmashGameEnd() {
        game.end();
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {

        ItemStack droppedItem = event.getItemDrop().getItemStack();

        if (game != null && game.getState().equals(GameState.IN_PROGRESS)) {
            if (droppedItem.getType() == Material.STICK) {
                endHeroesOfSmashGame(); // Assuming your game object has an end method
                event.getPlayer().sendMessage("You dropped a stick! Craft Royale Game over.");
            }
        }
    }
}
